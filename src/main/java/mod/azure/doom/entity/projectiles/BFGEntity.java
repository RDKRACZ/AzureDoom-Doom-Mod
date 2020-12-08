package mod.azure.doom.entity.projectiles;

import java.util.List;

import javax.annotation.Nullable;

import com.blackgear.nether.common.entity.HoglinEntity;

import mod.azure.doom.entity.GoreNestEntity;
import mod.azure.doom.util.registry.DoomItems;
import mod.azure.doom.util.registry.ModEntityTypes;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BFGEntity extends AbstractArrowEntity {

	protected int timeInAir;
	protected boolean inAir;
	private int ticksInAir;
	private static final DataParameter<Integer> TARGET_ENTITY = EntityDataManager.createKey(BFGEntity.class,
			DataSerializers.VARINT);
	private LivingEntity targetedEntity;

	public BFGEntity(EntityType<? extends AbstractArrowEntity> type, World world) {
		super(type, world);
	}

	public BFGEntity(LivingEntity shooter, World world, Item referenceItemIn) {
		super(ModEntityTypes.BFG_CELL.get(), shooter, world);
	}

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

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putShort("life", (short) this.ticksInAir);
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.ticksInAir = compound.getShort("life");
	}

	@Override
	public void tick() {
		super.tick();
		boolean flag = this.getNoClip();
		Vec3d vec3d = this.getMotion();
		if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F) {
			float f = MathHelper.sqrt(horizontalMag(vec3d));
			this.rotationYaw = (float) (MathHelper.atan2(vec3d.x, vec3d.z) * (double) (180F / (float) Math.PI));
			this.rotationPitch = (float) (MathHelper.atan2(vec3d.y, (double) f) * (double) (180F / (float) Math.PI));
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
			++this.ticksInAir;
			Vec3d vec3d2 = this.getPositionVec();
			Vec3d vec3d3 = vec3d2.add(vec3d);
			RayTraceResult raytraceresult = this.world.rayTraceBlocks(new RayTraceContext(vec3d2, vec3d3,
					RayTraceContext.BlockMode.COLLIDER, RayTraceContext.FluidMode.NONE, this));
			if (raytraceresult.getType() != RayTraceResult.Type.MISS) {
				vec3d3 = raytraceresult.getHitVec();
			}

			while (this.isAlive()) {
				EntityRayTraceResult entityraytraceresult = this.rayTraceEntities(vec3d2, vec3d3);
				if (entityraytraceresult != null) {
					raytraceresult = entityraytraceresult;
				}

				if (raytraceresult != null && raytraceresult.getType() == RayTraceResult.Type.ENTITY) {
					Entity entity = ((EntityRayTraceResult) raytraceresult).getEntity();
					Entity entity1 = this.getShooter();
					if (entity instanceof PlayerEntity && entity1 instanceof PlayerEntity
							&& !((PlayerEntity) entity1).canAttackPlayer((PlayerEntity) entity)) {
						raytraceresult = null;
						entityraytraceresult = null;
					}
				}

				if (raytraceresult != null && raytraceresult.getType() != RayTraceResult.Type.MISS && !flag
						&& !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
					this.onHit(raytraceresult);
					this.isAirBorne = true;
				}

				if (entityraytraceresult == null || this.getPierceLevel() <= 0) {
					break;
				}

				raytraceresult = null;
			}

			vec3d = this.getMotion();
			double d3 = vec3d.x;
			double d4 = vec3d.y;
			double d0 = vec3d.z;
			if (this.getIsCritical()) {
				for (int i = 0; i < 4; ++i) {
					this.world.addParticle(ParticleTypes.CRIT, this.getPosX() + d3 * (double) i / 4.0D,
							this.getPosY() + d4 * (double) i / 4.0D, this.getPosZ() + d0 * (double) i / 4.0D, -d3,
							-d4 + 0.2D, -d0);
				}
			}

			double d5 = this.getPosX() + d3;
			double d1 = this.getPosY() + d4;
			double d2 = this.getPosZ() + d0;
			float f1 = MathHelper.sqrt(horizontalMag(vec3d));
			if (flag) {
				this.rotationYaw = (float) (MathHelper.atan2(-d3, -d0) * (double) (180F / (float) Math.PI));
			} else {
				this.rotationYaw = (float) (MathHelper.atan2(d3, d0) * (double) (180F / (float) Math.PI));
			}

			for (this.rotationPitch = (float) (MathHelper.atan2(d4, (double) f1)
					* (double) (180F / (float) Math.PI)); this.rotationPitch
							- this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {
				;
			}

			while (this.rotationPitch - this.prevRotationPitch >= 180.0F) {
				this.prevRotationPitch += 360.0F;
			}

			while (this.rotationYaw - this.prevRotationYaw < -180.0F) {
				this.prevRotationYaw -= 360.0F;
			}

			while (this.rotationYaw - this.prevRotationYaw >= 180.0F) {
				this.prevRotationYaw += 360.0F;
			}

			this.rotationPitch = MathHelper.lerp(0.2F, this.prevRotationPitch, this.rotationPitch);
			this.rotationYaw = MathHelper.lerp(0.2F, this.prevRotationYaw, this.rotationYaw);
			float f2 = 0.99F;

			this.setMotion(vec3d.scale((double) f2));
			if (!this.hasNoGravity() && !flag) {
				Vec3d vec3d4 = this.getMotion();
				this.setMotion(vec3d4.x, vec3d4.y - (double) 0.05F, vec3d4.z);
			}

			this.setPosition(d5, d1, d2);
			this.doBlockCollisions();
		}

		float f2 = 24.0F;
		int k1 = MathHelper.floor(this.getPosX() - (double) f2 - 1.0D);
		int l1 = MathHelper.floor(this.getPosX() + (double) f2 + 1.0D);
		int i2 = MathHelper.floor(this.getPosY() - (double) f2 - 1.0D);
		int i1 = MathHelper.floor(this.getPosY() + (double) f2 + 1.0D);
		int j2 = MathHelper.floor(this.getPosZ() - (double) f2 - 1.0D);
		int j1 = MathHelper.floor(this.getPosZ() + (double) f2 + 1.0D);
		List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this,
				new AxisAlignedBB((double) k1, (double) i2, (double) j2, (double) l1, (double) i1, (double) j1));
		Vec3d vector3d1 = new Vec3d(this.getPosX(), this.getPosY(), this.getPosZ());
		for (int k2 = 0; k2 < list.size(); ++k2) {
			Entity entity = list.get(k2);
			if (!(entity instanceof ServerPlayerEntity) && !(entity instanceof GoreNestEntity)
					&& (entity instanceof MonsterEntity) || (entity instanceof SlimeEntity)
					|| (entity instanceof PhantomEntity) || (entity instanceof ShulkerEntity)
					|| (entity instanceof HoglinEntity)) {
				double d12 = (double) (MathHelper.sqrt(entity.getDistanceSq(vector3d1)) / f2);
				if (d12 <= 1.0D) {
					if (entity.isAlive()) {
						entity.attackEntityFrom(DamageSource.causeArrowDamage(this, this), 10);
						setTargetedEntity(entity.getEntityId());
					}
				}
			}
		}
	}

	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(DoomItems.BFG_CELL.get());
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
	protected void onHit(RayTraceResult result) {
		super.onHit(result);
		if (!this.world.isRemote) {
			this.doDamage();
			this.remove();
			AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.getPosX(),
					this.getPosY(), this.getPosZ());
			areaeffectcloudentity.setParticleData(ParticleTypes.EXPLOSION);
			areaeffectcloudentity.setRadius(3.0F);
			areaeffectcloudentity.setDuration(2);
			areaeffectcloudentity.setPosition(this.getPosX(), this.getPosYEye(), this.getPosZ());
			this.world.addEntity(areaeffectcloudentity);
		}
		this.playSound(ModSoundEvents.BFG_HIT.get(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	}

	@Override
	protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
		super.onEntityHit(p_213868_1_);
		Entity entity = p_213868_1_.getEntity();
		if (!this.world.isRemote) {
			this.doDamage();
			this.remove();
			AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(entity.world, entity.getPosX(),
					entity.getPosY(), entity.getPosZ());
			areaeffectcloudentity.setParticleData(ParticleTypes.EXPLOSION);
			areaeffectcloudentity.setRadius(3.0F);
			areaeffectcloudentity.setDuration(2);
			areaeffectcloudentity.setPosition(this.getPosX(), this.getPosYEye(), this.getPosZ());
			entity.world.addEntity(areaeffectcloudentity);
		}
		this.playSound(ModSoundEvents.BFG_HIT.get(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	}

	public void doDamage() {
		float f2 = 24.0F;
		int k1 = MathHelper.floor(this.getPosX() - (double) f2 - 1.0D);
		int l1 = MathHelper.floor(this.getPosX() + (double) f2 + 1.0D);
		int i2 = MathHelper.floor(this.getPosY() - (double) f2 - 1.0D);
		int i1 = MathHelper.floor(this.getPosY() + (double) f2 + 1.0D);
		int j2 = MathHelper.floor(this.getPosZ() - (double) f2 - 1.0D);
		int j1 = MathHelper.floor(this.getPosZ() + (double) f2 + 1.0D);
		List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this,
				new AxisAlignedBB((double) k1, (double) i2, (double) j2, (double) l1, (double) i1, (double) j1));
		Vec3d vector3d = new Vec3d(this.getPosX(), this.getPosY(), this.getPosZ());

		for (int k2 = 0; k2 < list.size(); ++k2) {
			Entity entity = list.get(k2);
			if (!(entity instanceof ServerPlayerEntity) && !(entity instanceof GoreNestEntity)
					&& (entity instanceof MonsterEntity) || (entity instanceof SlimeEntity)
					|| (entity instanceof PhantomEntity) || (entity instanceof ShulkerEntity)) {
				double d12 = (double) (MathHelper.sqrt(entity.getDistanceSq(vector3d)) / f2);
				if (d12 <= 1.0D) {
					entity.attackEntityFrom(DamageSource.causeArrowDamage(this, this), 100);
					if (!this.world.isRemote) {
						List<LivingEntity> list1 = this.world.getEntitiesWithinAABB(LivingEntity.class,
								this.getBoundingBox().grow(4.0D, 2.0D, 4.0D));
						AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(entity.world,
								entity.getPosX(), entity.getPosY(), entity.getPosZ());
						areaeffectcloudentity.setParticleData(ParticleTypes.TOTEM_OF_UNDYING);
						areaeffectcloudentity.setRadius(3.0F);
						areaeffectcloudentity.setDuration(10);
						if (!list1.isEmpty()) {
							for (LivingEntity livingentity : list1) {
								double d0 = this.getDistanceSq(livingentity);
								if (d0 < 16.0D) {
									areaeffectcloudentity.setPosition(entity.getPosX(), entity.getPosYEye(),
											entity.getPosZ());
									break;
								}
							}
						}
						entity.world.addEntity(areaeffectcloudentity);
					}
				}
			}
		}
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(TARGET_ENTITY, 0);
	}

	private void setTargetedEntity(int entityId) {
		this.dataManager.set(TARGET_ENTITY, entityId);
	}

	public boolean hasTargetedEntity() {
		return this.dataManager.get(TARGET_ENTITY) != 0;
	}

	@Nullable
	public LivingEntity getTargetedEntity() {
		if (!this.hasTargetedEntity()) {
			return null;
		} else if (this.world.isRemote) {
			if (this.targetedEntity != null) {
				return this.targetedEntity;
			} else {
				Entity entity = this.world.getEntityByID(this.dataManager.get(TARGET_ENTITY));
				if (!(entity instanceof ServerPlayerEntity) && entity instanceof LivingEntity) {
					this.targetedEntity = (LivingEntity) entity;
					return this.targetedEntity;
				} else {
					return null;
				}
			}
		} else {
			return this.getAttackTarget();
		}
	}

	@Override
	public void notifyDataManagerChange(DataParameter<?> key) {
		super.notifyDataManagerChange(key);
		if (TARGET_ENTITY.equals(key)) {
			this.targetedEntity = null;
		}

	}

	@Nullable
	public LivingEntity getAttackTarget() {
		return this.targetedEntity;
	}
}