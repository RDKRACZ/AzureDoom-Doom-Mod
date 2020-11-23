package mod.azure.doom.entity.projectiles;

import java.util.List;

import mod.azure.doom.util.registry.DoomItems;
import mod.azure.doom.util.registry.ModEntityTypes;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EnergyCellEntity extends AbstractArrowEntity {

	protected int timeInAir;
	protected boolean inAir;
	private int ticksInAir;

	public EnergyCellEntity(EntityType<? extends AbstractArrowEntity> type, World world) {
		super(type, world);
	}

	public EnergyCellEntity(LivingEntity shooter, World world, Item referenceItemIn) {
		super(ModEntityTypes.ENERGY_CELL.get(), shooter, world);
	}

	@Override
	protected void func_225516_i_() {
		++this.ticksInAir;
		if (this.ticksExisted >= 40) {
			this.remove();
		}
	}

	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		super.shoot(x, y, z, velocity, inaccuracy);
		this.ticksInAir = 0;
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putShort("life", (short) this.ticksInAir);
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.ticksInAir = compound.getShort("life");
	}

	@Override
	public void tick() {
		super.tick();
		boolean flag = this.getNoClip();
		Vector3d vector3d = this.getMotion();
		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
			float f = MathHelper.sqrt(horizontalMag(vector3d));
			this.rotationYaw = (float) (MathHelper.atan2(vector3d.x, vector3d.z) * (double) (180F / (float) Math.PI));
			this.rotationPitch = (float) (MathHelper.atan2(vector3d.y, (double) f) * (double) (180F / (float) Math.PI));
			this.prevRotationYaw = this.rotationYaw;
			this.prevRotationPitch = this.rotationPitch;
		}

		if (this.ticksExisted >= 100) {
			this.remove();
		}

		if (this.inAir && !flag) {
			this.func_225516_i_();

			++this.timeInAir;
		} else {
			this.timeInAir = 0;
			Vector3d vector3d2 = this.getPositionVec();
			Vector3d vector3d3 = vector3d2.add(vector3d);
			RayTraceResult raytraceresult = this.world.rayTraceBlocks(new RayTraceContext(vector3d2, vector3d3,
					RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, this));
			if (raytraceresult.getType() != RayTraceResult.Type.MISS) {
				vector3d3 = raytraceresult.getHitVec();
			}
			while (this.isAlive()) {
				EntityRayTraceResult entityraytraceresult = this.rayTraceEntities(vector3d2, vector3d3);
				if (entityraytraceresult != null) {
					raytraceresult = entityraytraceresult;
				}
				if (raytraceresult != null && raytraceresult.getType() == RayTraceResult.Type.ENTITY) {
					Entity entity = ((EntityRayTraceResult) raytraceresult).getEntity();
					Entity entity1 = this.func_234616_v_();
					if (entity instanceof PlayerEntity && entity1 instanceof PlayerEntity
							&& !((PlayerEntity) entity1).canAttackPlayer((PlayerEntity) entity)) {
						raytraceresult = null;
						entityraytraceresult = null;
					}
				}
				if (raytraceresult != null && raytraceresult.getType() != RayTraceResult.Type.MISS && !flag
						&& !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
					this.onImpact(raytraceresult);
					this.isAirBorne = true;
				}
				if (entityraytraceresult == null || this.getPierceLevel() <= 0) {
					break;
				}
				raytraceresult = null;
			}
			vector3d = this.getMotion();
			double d3 = vector3d.x;
			double d4 = vector3d.y;
			double d0 = vector3d.z;
			double d5 = this.getPosX() + d3;
			double d1 = this.getPosY() + d4;
			double d2 = this.getPosZ() + d0;
			float f1 = MathHelper.sqrt(horizontalMag(vector3d));
			if (flag) {
				this.rotationYaw = (float) (MathHelper.atan2(-d3, -d0) * (double) (180F / (float) Math.PI));
			} else {
				this.rotationYaw = (float) (MathHelper.atan2(d3, d0) * (double) (180F / (float) Math.PI));
			}
			this.rotationPitch = (float) (MathHelper.atan2(d4, (double) f1) * (double) (180F / (float) Math.PI));
			this.rotationPitch = func_234614_e_(this.prevRotationPitch, this.rotationPitch);
			this.rotationYaw = func_234614_e_(this.prevRotationYaw, this.rotationYaw);
			float f2 = 0.99F;
			this.setMotion(vector3d.scale((double) f2));
			if (!this.hasNoGravity() && !flag) {
				Vector3d vector3d4 = this.getMotion();
				this.setMotion(vector3d4.x, vector3d4.y - (double) 0.05F, vector3d4.z);
			}
			this.setPosition(d5, d1, d2);
			this.doBlockCollisions();
		}
	}

	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(DoomItems.ENERGY_CELLS.get());
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public boolean hasNoGravity() {
		if (this.isInWater()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isPushedByWater() {
		return false;
	}

	@Override
	protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
		super.onEntityHit(p_213868_1_);
		if (!this.world.isRemote) {
			this.doDamage();
			this.remove();
		}
		this.playSound(ModSoundEvents.PLASMA_HIT.get(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	}

	protected void onImpact(RayTraceResult result) {
		super.onImpact(result);
		if (!this.world.isRemote) {
			this.doDamage();
			this.remove();
		}
		this.playSound(ModSoundEvents.PLASMA_HIT.get(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	}

	public void doDamage() {
		float f2 = 1.0F;
		int k1 = MathHelper.floor(this.getPosX() - (double) f2 - 1.0D);
		int l1 = MathHelper.floor(this.getPosX() + (double) f2 + 1.0D);
		int i2 = MathHelper.floor(this.getPosY() - (double) f2 - 1.0D);
		int i1 = MathHelper.floor(this.getPosY() + (double) f2 + 1.0D);
		int j2 = MathHelper.floor(this.getPosZ() - (double) f2 - 1.0D);
		int j1 = MathHelper.floor(this.getPosZ() + (double) f2 + 1.0D);
		List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this,
				new AxisAlignedBB((double) k1, (double) i2, (double) j2, (double) l1, (double) i1, (double) j1));
		Vector3d vector3d = new Vector3d(this.getPosX(), this.getPosY(), this.getPosZ());
		for (int k2 = 0; k2 < list.size(); ++k2) {
			Entity entity = list.get(k2);
			double d12 = (double) (MathHelper.sqrt(entity.getDistanceSq(vector3d)) / f2);
			if (d12 <= 1.0D) {
				entity.attackEntityFrom(DamageSource.func_233546_a_(), 20);
			}
		}
	}
}