package mod.azure.doomweapon.entity;

import java.util.EnumSet;
import java.util.Random;

import mod.azure.doomweapon.entity.ai.goal.LostSoulAttackGoal;
import mod.azure.doomweapon.util.registry.DoomItems;
import mod.azure.doomweapon.util.registry.ModEntityTypes;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class LostSoulEntity extends FlyingEntity implements IMob {

	private static final DataParameter<Boolean> ATTACKING = EntityDataManager.createKey(GhastEntity.class,
			DataSerializers.BOOLEAN);

	public LostSoulEntity(EntityType<LostSoulEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	public LostSoulEntity(World worldIn) {
		this(ModEntityTypes.LOST_SOUL.get(), worldIn);
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(2, new LostSoulAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(5, new LostSoulEntity.RandomFlyGoal(this));
		this.goalSelector.addGoal(7, new LostSoulEntity.LookAroundGoal(this));
		this.goalSelector.addGoal(7, new LostSoulEntity.FireballAttackGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	}

	public static boolean spawning(EntityType<LostSoulEntity> p_223368_0_, IWorld p_223368_1_, SpawnReason reason,
			BlockPos p_223368_3_, Random p_223368_4_) {
		return p_223368_1_.getDifficulty() != Difficulty.PEACEFUL && p_223368_4_.nextInt(20) == 0
				&& canSpawnOn(p_223368_0_, p_223368_1_, reason, p_223368_3_, p_223368_4_);
	}

	public int getFireballStrength() {
		return 1;
	}

	@Override
	protected boolean isDespawnPeaceful() {
		return true;
	}

	public void setAttacking(boolean attacking) {
		this.dataManager.set(ATTACKING, attacking);
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 0.5F;
	}

	protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropSpecialItems(source, looting, recentlyHitIn);
		ItemEntity itementity = this.entityDropItem(DoomItems.ARGENT_ENERGY.get());
		if (itementity != null) {
			itementity.isImmuneToFire();
			itementity.setNoDespawn();
			itementity.setGlowing(true);
		}
	}

	static class FireballAttackGoal extends Goal {
		private final LostSoulEntity parentEntity;
		public int attackTimer;

		public FireballAttackGoal(LostSoulEntity ghast) {
			this.parentEntity = ghast;
		}

		public boolean shouldExecute() {
			return this.parentEntity.getAttackTarget() != null;
		}

		public void startExecuting() {
			this.attackTimer = 0;
		}

		public void resetTask() {
			this.parentEntity.setAttacking(false);
		}

		public void tick() {
			LivingEntity livingentity = this.parentEntity.getAttackTarget();
			if (livingentity.getDistanceSq(this.parentEntity) < 4096.0D
					&& this.parentEntity.canEntityBeSeen(livingentity)) {
				World world = this.parentEntity.world;
				++this.attackTimer;
				if (this.attackTimer == 10) {
					world.playEvent((PlayerEntity) null, 1015, new BlockPos(this.parentEntity), 0);
				}

				if (this.attackTimer == 20) {
					Vec3d vec3d = this.parentEntity.getLook(1.0F);
					double d2 = livingentity.getPosX() - (this.parentEntity.getPosX() + vec3d.x * 4.0D);
					double d3 = livingentity.getPosYHeight(0.5D) - (0.5D + this.parentEntity.getPosYHeight(0.5D));
					double d4 = livingentity.getPosZ() - (this.parentEntity.getPosZ() + vec3d.z * 4.0D);
					world.playEvent((PlayerEntity) null, 1016, new BlockPos(this.parentEntity), 0);
					FireballEntity fireballentity = new FireballEntity(world, this.parentEntity, d2, d3, d4);
					fireballentity.explosionPower = this.parentEntity.getFireballStrength();
					fireballentity.setPosition(this.parentEntity.getPosX() + vec3d.x * 4.0D,
							this.parentEntity.getPosYHeight(0.5D) + 0.5D, fireballentity.getPosZ() + vec3d.z * 4.0D);
					world.addEntity(fireballentity);
					this.attackTimer = -40;
				}
			} else if (this.attackTimer > 0) {
				--this.attackTimer;
			}

			this.parentEntity.setAttacking(this.attackTimer > 10);
		}
	}

	static class LookAroundGoal extends Goal {
		private final LostSoulEntity parentEntity;

		public LookAroundGoal(LostSoulEntity ghast) {
			this.parentEntity = ghast;
			this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
		}

		public boolean shouldExecute() {
			return true;
		}

		public void tick() {
			if (this.parentEntity.getAttackTarget() == null) {
				Vec3d vec3d = this.parentEntity.getMotion();
				this.parentEntity.rotationYaw = -((float) MathHelper.atan2(vec3d.x, vec3d.z))
						* (180F / (float) Math.PI);
				this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
			} else {
				LivingEntity livingentity = this.parentEntity.getAttackTarget();
				if (livingentity.getDistanceSq(this.parentEntity) < 4096.0D) {
					double d1 = livingentity.getPosX() - this.parentEntity.getPosX();
					double d2 = livingentity.getPosZ() - this.parentEntity.getPosZ();
					this.parentEntity.rotationYaw = -((float) MathHelper.atan2(d1, d2)) * (180F / (float) Math.PI);
					this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
				}
			}

		}
	}

	static class RandomFlyGoal extends Goal {
		private final LostSoulEntity parentEntity;

		public RandomFlyGoal(LostSoulEntity ghast) {
			this.parentEntity = ghast;
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean shouldExecute() {
			MovementController movementcontroller = this.parentEntity.getMoveHelper();
			if (!movementcontroller.isUpdating()) {
				return true;
			} else {
				double d0 = movementcontroller.getX() - this.parentEntity.getPosX();
				double d1 = movementcontroller.getY() - this.parentEntity.getPosY();
				double d2 = movementcontroller.getZ() - this.parentEntity.getPosZ();
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				return d3 < 1.0D || d3 > 3600.0D;
			}
		}

		public boolean shouldContinueExecuting() {
			return false;
		}

		public void startExecuting() {
			Random random = this.parentEntity.getRNG();
			double d0 = this.parentEntity.getPosX() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d1 = this.parentEntity.getPosY() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			double d2 = this.parentEntity.getPosZ() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
			this.parentEntity.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.LOST_SOUL_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_GENERIC_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.LOST_SOUL_DEATH.get();
	}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEAD;
	}

	@Override
	protected float getSoundVolume() {
		return 1.0F;
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 4;
	}

}