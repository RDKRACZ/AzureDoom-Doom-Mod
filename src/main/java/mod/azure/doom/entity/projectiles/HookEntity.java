package mod.azure.doom.entity.projectiles;

import javax.annotation.Nullable;

import mod.azure.doom.util.registry.DoomItems;
import mod.azure.doom.util.registry.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class HookEntity extends ProjectileEntity {
	private static final DataParameter<Integer> DATA_HOOKED_ENTITY = EntityDataManager.defineId(HookEntity.class,
			DataSerializers.INT);
	private int life;
	private Entity hookedIn;
	private HookEntity.State currentState = HookEntity.State.FLYING;

	public HookEntity(EntityType<? extends ProjectileEntity> type, World world) {
		super(type, world);
	}

	@OnlyIn(Dist.CLIENT)
	public HookEntity(World world, PlayerEntity player, double p_i47290_3_, double p_i47290_5_, double p_i47290_7_) {
		super(ModEntityTypes.HOOK.get(), world);
		this.noCulling = true;
		this.setOwner(player);
		this.setPos(p_i47290_3_, p_i47290_5_, p_i47290_7_);
		this.xo = this.getX();
		this.yo = this.getY();
		this.zo = this.getZ();
	}

	public HookEntity(PlayerEntity player, World world) {
		super(ModEntityTypes.HOOK.get(), world);
		float f = player.xRot;
		float f1 = player.yRot;
		float f2 = MathHelper.cos(-f1 * ((float) Math.PI / 180F) - (float) Math.PI);
		float f3 = MathHelper.sin(-f1 * ((float) Math.PI / 180F) - (float) Math.PI);
		float f4 = -MathHelper.cos(-f * ((float) Math.PI / 180F));
		float f5 = MathHelper.sin(-f * ((float) Math.PI / 180F));
		double d0 = player.getX() - (double) f3 * 0.3D;
		double d1 = player.getEyeY();
		double d2 = player.getZ() - (double) f2 * 0.3D;
		this.moveTo(d0, d1, d2, f1, f);
		Vector3d vector3d = new Vector3d((double) (-f3), (double) MathHelper.clamp(-(f5 / f4), -5.0F, 5.0F),
				(double) (-f2));
		double d3 = vector3d.length();
		vector3d = vector3d.multiply(0.6D / d3 + 0.5D + this.random.nextGaussian() * 0.0045D,
				0.6D / d3 + 0.5D + this.random.nextGaussian() * 0.0045D,
				0.6D / d3 + 0.5D + this.random.nextGaussian() * 0.0045D);
		this.setDeltaMovement(vector3d);
		this.yRot = (float) (MathHelper.atan2(vector3d.x, vector3d.z) * (double) (180F / (float) Math.PI));
		this.xRot = (float) (MathHelper.atan2(vector3d.y, (double) MathHelper.sqrt(getHorizontalDistanceSqr(vector3d)))
				* (double) (180F / (float) Math.PI));
		this.yRotO = this.yRot;
		this.xRotO = this.xRot;
	}

	protected void defineSynchedData() {
		this.getEntityData().define(DATA_HOOKED_ENTITY, 0);
	}

	public void onSyncedDataUpdated(DataParameter<?> key) {
		super.onSyncedDataUpdated(key);
		if (DATA_HOOKED_ENTITY.equals(key)) {
			int i = this.getEntityData().get(DATA_HOOKED_ENTITY);
			this.hookedIn = i > 0 ? this.level.getEntity(i - 1) : null;
		}
	}

	@OnlyIn(Dist.CLIENT)
	public boolean shouldRenderAtSqrDistance(double p_70112_1_) {
		return p_70112_1_ < 4096.0D;
	}

	@OnlyIn(Dist.CLIENT)
	public void lerpTo(double p_180426_1_, double p_180426_3_, double p_180426_5_, float p_180426_7_, float p_180426_8_,
			int p_180426_9_, boolean p_180426_10_) {
	}

	@SuppressWarnings("deprecation")
	public void tick() {
		super.tick();
		PlayerEntity playerentity = this.getPlayerOwner();
		if (playerentity == null) {
			this.remove();
		} else if (this.level.isClientSide || !this.shouldStopFishing(playerentity)) {
			if (this.onGround) {
				++this.life;
				if (this.life >= 1200) {
					this.remove();
					return;
				}
			} else {
				this.life = 0;
			}
			if (this.currentState == HookEntity.State.FLYING) {
				if (this.hookedIn != null) {
					this.setDeltaMovement(Vector3d.ZERO);
					this.currentState = HookEntity.State.HOOKED_IN_ENTITY;
					return;
				}

				this.checkCollision();
			} else {
				if (this.currentState == HookEntity.State.HOOKED_IN_ENTITY) {
					if (this.hookedIn != null) {
						if (this.hookedIn.removed) {
							this.hookedIn = null;
							this.currentState = HookEntity.State.FLYING;
						} else {
							this.setPos(this.hookedIn.getX(), this.hookedIn.getY(0.8D), this.hookedIn.getZ());
						}
					}

					return;
				}
			}
			this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.03D, 0.0D));
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.updateRotation();
			if (this.currentState == HookEntity.State.FLYING && (this.onGround || this.horizontalCollision)) {
				this.setDeltaMovement(Vector3d.ZERO);
			}
			this.setDeltaMovement(this.getDeltaMovement().scale(0.92D));
			this.reapplyPosition();
		}
	}

	private boolean shouldStopFishing(PlayerEntity player) {
		ItemStack itemstack = player.getMainHandItem();
		ItemStack itemstack1 = player.getOffhandItem();
		boolean flag = itemstack.getItem() == DoomItems.SSG.get();
		boolean flag1 = itemstack1.getItem() == DoomItems.SSG.get();
		if (player.isAlive() && (flag || flag1) && !(this.distanceToSqr(player) > 1024.0D)) {
			return false;
		} else {
			return true;
		}
	}

	private void checkCollision() {
		RayTraceResult raytraceresult = ProjectileHelper.getHitResult(this, this::canHitEntity);
		this.onHit(raytraceresult);
	}

	protected boolean canHitEntity(Entity p_230298_1_) {
		return super.canHitEntity(p_230298_1_) || p_230298_1_.isAlive() && p_230298_1_ instanceof ItemEntity;
	}

	protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
		super.onHitEntity(p_213868_1_);
		if (!this.level.isClientSide) {
			this.hookedIn = p_213868_1_.getEntity();
			this.setHookedEntity();
		}
	}

	protected void onHitBlock(BlockRayTraceResult p_230299_1_) {
		super.onHitBlock(p_230299_1_);
		this.setDeltaMovement(this.getDeltaMovement().normalize().scale(p_230299_1_.distanceTo(this)));
	}

	private void setHookedEntity() {
		this.getEntityData().set(DATA_HOOKED_ENTITY, this.hookedIn.getId() + 1);
	}

	@Override
	public void addAdditionalSaveData(CompoundNBT compound) {
		super.addAdditionalSaveData(compound);
		compound.putShort("life", (short) this.life);
	}

	@Override
	public void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		this.life = compound.getShort("life");
	}

	public void handleEntityEvent(byte p_70103_1_) {
		if (p_70103_1_ == 31 && this.level.isClientSide && this.hookedIn instanceof PlayerEntity
				&& ((PlayerEntity) this.hookedIn).isLocalPlayer()) {
			this.bringInHookedEntity();
		}

		super.handleEntityEvent(p_70103_1_);
	}

	protected void bringInHookedEntity() {
		Entity entity = this.getOwner();
		if (entity != null) {
			Vector3d vector3d = (new Vector3d(entity.getX() - this.getX(), entity.getY() - this.getY(),
					entity.getZ() - this.getZ())).scale(0.1D);
			this.hookedIn.setDeltaMovement(this.hookedIn.getDeltaMovement().add(vector3d));
		}
	}

	protected boolean isMovementNoisy() {
		return false;
	}

	@Nullable
	public PlayerEntity getPlayerOwner() {
		Entity entity = this.getOwner();
		return entity instanceof PlayerEntity ? (PlayerEntity) entity : null;
	}

	@Nullable
	public Entity getHookedIn() {
		return this.hookedIn;
	}

	public boolean canChangeDimensions() {
		return false;
	}

	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	static enum State {
		FLYING, HOOKED_IN_ENTITY, BOBBING;
	}
}
