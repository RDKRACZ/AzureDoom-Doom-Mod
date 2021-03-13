package mod.azure.doom.entity;

import java.util.EnumSet;
import java.util.Random;

import mod.azure.doom.entity.ai.goal.DemonAttackGoal;
import mod.azure.doom.entity.ai.goal.RandomFlyConvergeOnTargetGoal;
import mod.azure.doom.entity.ai.goal.RangedStaticAttackGoal;
import mod.azure.doom.entity.attack.FireballAttack;
import mod.azure.doom.entity.projectiles.CustomFireballEntity;
import mod.azure.doom.util.config.Config;
import mod.azure.doom.util.config.EntityConfig;
import mod.azure.doom.util.config.EntityDefaults.EntityConfigType;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class CacodemonEntity extends DemonEntity implements IMob, IAnimatable {
	private static final DataParameter<Boolean> ATTACKING = EntityDataManager.defineId(CacodemonEntity.class,
			DataSerializers.BOOLEAN);

	public static EntityConfig config = Config.SERVER.entityConfig.get(EntityConfigType.CACODEMON);

	public CacodemonEntity(EntityType<? extends CacodemonEntity> type, World worldIn) {
		super(type, worldIn);
		this.moveControl = new CacodemonEntity.MoveHelperController(this);
	}

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving() && !this.entityData.get(ATTACKING)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("walking", true));
			return PlayState.CONTINUE;
		}
		if (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying()) {
			if (level.isClientSide) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("death", false));
				return PlayState.CONTINUE;
			}
		}
		if (this.entityData.get(ATTACKING) && (this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("attacking", false));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<CacodemonEntity>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 60) {
			this.remove();
		}
	}

	@OnlyIn(Dist.CLIENT)
	public boolean isAttacking() {
		return this.entityData.get(ATTACKING);
	}

	@Override
	public void setAttacking(boolean attacking) {
		this.entityData.set(ATTACKING, attacking);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ATTACKING, false);
	}

	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public static float fireBallDirectHitDamage = 6.0F;

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		fireBallDirectHitDamage = config.RANGED_ATTACK_DAMAGE;
		return config.pushAttributes(
				MobEntity.createMobAttributes().add(Attributes.ATTACK_DAMAGE, config.MELEE_ATTACK_DAMAGE)
						.add(Attributes.FOLLOW_RANGE, 50.0D));
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(5, new RandomFlyConvergeOnTargetGoal(this, 2, 15, 0.5));
		this.goalSelector.addGoal(7, new CacodemonEntity.LookAroundGoal(this));
		this.goalSelector.addGoal(4,
				new RangedStaticAttackGoal(this,
						new FireballAttack(this, true).setDamage(5).setProjectileOriginOffset(1.5, 0.3, 1.5).setSound(
								ModSoundEvents.CACODEMON_FIREBALL.get(), 1.0F,
								1.2F / (this.getRandom().nextFloat() * 0.2F + 0.9F)),
						60, 20, 30F));
		this.goalSelector.addGoal(4, new DemonAttackGoal(this, 1.0D, false));
		this.targetSelector.addGoal(1,
				new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, (p_213812_1_) -> {
					return Math.abs(p_213812_1_.getY() - this.getY()) <= 4.0D;
				}));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, 10, true,
				false, (p_213812_1_) -> {
					return Math.abs(p_213812_1_.getY() - this.getY()) <= 4.0D;
				}));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this).setAlertOthers()));
	}

	public static boolean spawning(EntityType<CacodemonEntity> p_223368_0_, IWorld p_223368_1_, SpawnReason reason,
			BlockPos p_223368_3_, Random p_223368_4_) {
		return passPeacefulAndYCheck(config, p_223368_1_, reason, p_223368_3_, p_223368_4_)
				&& p_223368_4_.nextInt(20) == 0
				&& checkMobSpawnRules(p_223368_0_, p_223368_1_, reason, p_223368_3_, p_223368_4_);
	}

	public int getFireballStrength() {
		return 1;
	}

	@Override
	protected boolean shouldDespawnInPeaceful() {
		return true;
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 1.0F;
	}

	public boolean causeFallDamage(float distance, float damageMultiplier) {
		return false;
	}

	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	public void travel(Vector3d travelVector) {
		if (this.isInWater()) {
			this.moveRelative(0.02F, travelVector);
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().scale((double) 0.8F));
		} else if (this.isInLava()) {
			this.moveRelative(0.02F, travelVector);
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
		} else {
			BlockPos ground = new BlockPos(this.getX(), this.getY() - 1.0D, this.getZ());
			float f = 0.91F;
			if (this.onGround) {
				f = this.level.getBlockState(ground).getSlipperiness(this.level, ground, this) * 0.91F;
			}

			float f1 = 0.16277137F / (f * f * f);
			f = 0.91F;
			if (this.onGround) {
				f = this.level.getBlockState(ground).getSlipperiness(this.level, ground, this) * 0.91F;
			}

			this.moveRelative(this.onGround ? 0.1F * f1 : 0.02F, travelVector);
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().scale((double) f));
		}

		this.calculateEntityAnimation(this, false);
	}

	/**
	 * Returns true if this entity should move as if it were on a ladder (either
	 * because it's actually on a ladder, or for AI reasons)
	 */
	public boolean onClimbable() {
		return false;
	}

	static class FireballAttackGoal extends Goal {
		private final CacodemonEntity parentEntity;
		public int attackTimer;

		public FireballAttackGoal(CacodemonEntity ghast) {
			this.parentEntity = ghast;
		}

		public boolean canUse() {
			return this.parentEntity.getTarget() != null;
		}

		public void start() {
			this.attackTimer = 0;
		}

		public void stop() {
			this.parentEntity.setAttacking(false);
		}

		public void tick() {
			LivingEntity livingentity = this.parentEntity.getTarget();
			if (livingentity.distanceToSqr(this.parentEntity) < 4096.0D
					&& this.parentEntity.canSee(livingentity)) {
				this.parentEntity.getLookControl().setLookAt(livingentity, 90.0F, 30.0F);
				World world = this.parentEntity.level;
				++this.attackTimer;

				if (this.attackTimer == 20) {
					Vector3d vector3d = this.parentEntity.getViewVector(1.0F);
					double d2 = livingentity.getX() - (this.parentEntity.getX() + vector3d.x * 0.5D);
					double d3 = livingentity.getY(0.3D) - (0.5D + this.parentEntity.getY(0.5D));
					double d4 = livingentity.getZ() - (this.parentEntity.getZ() + vector3d.z * 0.5D);

					CustomFireballEntity fireballentity = new CustomFireballEntity(world, this.parentEntity, d2, d3, d4,
							config.RANGED_ATTACK_DAMAGE);
					fireballentity.explosionPower = this.parentEntity.getFireballStrength();
					fireballentity.setPos(this.parentEntity.getX() + vector3d.x * 0.5D,
							this.parentEntity.getY(0.3D), fireballentity.getZ() + vector3d.z * 0.5D);
					this.parentEntity.playSound(ModSoundEvents.CACODEMON_FIREBALL.get(), 1.0F,
							1.2F / (this.parentEntity.random.nextFloat() * 0.2F + 0.9F));
					world.addFreshEntity(fireballentity);
					this.attackTimer = -40;
				}
			} else if (this.attackTimer > 0) {
				--this.attackTimer;
			}

			this.parentEntity.setAttacking(true);
		}
	}

	static class LookAroundGoal extends Goal {
		private final CacodemonEntity parentEntity;

		public LookAroundGoal(CacodemonEntity ghast) {
			this.parentEntity = ghast;
			this.setFlags(EnumSet.of(Goal.Flag.LOOK));
		}

		public boolean canUse() {
			return true;
		}

		public void tick() {
			if (this.parentEntity.getTarget() == null) {
				Vector3d vec3d = this.parentEntity.getDeltaMovement();
				this.parentEntity.yRot = -((float) MathHelper.atan2(vec3d.x, vec3d.z))
						* (180F / (float) Math.PI);
				this.parentEntity.yBodyRot = this.parentEntity.yRot;
			} else {
				LivingEntity livingentity = this.parentEntity.getTarget();
				if (livingentity.distanceToSqr(this.parentEntity) < 4096.0D) {
					double d1 = livingentity.getX() - this.parentEntity.getX();
					double d2 = livingentity.getZ() - this.parentEntity.getZ();
					this.parentEntity.yRot = -((float) MathHelper.atan2(d1, d2)) * (180F / (float) Math.PI);
					this.parentEntity.yBodyRot = this.parentEntity.yRot;
				}
			}

		}
	}

	static class MoveHelperController extends MovementController {
		private final CacodemonEntity parentEntity;
		private int courseChangeCooldown;

		public MoveHelperController(CacodemonEntity ghast) {
			super(ghast);
			this.parentEntity = ghast;
		}

		public void tick() {
			if (this.operation == MovementController.Action.MOVE_TO) {
				if (this.courseChangeCooldown-- <= 0) {
					this.courseChangeCooldown += this.parentEntity.getRandom().nextInt(5) + 2;
					Vector3d vector3d = new Vector3d(this.wantedX - this.parentEntity.getX(),
							this.wantedY - this.parentEntity.getY(), this.wantedZ - this.parentEntity.getZ());
					double d0 = vector3d.length();
					vector3d = vector3d.normalize();
					if (this.canReach(vector3d, MathHelper.ceil(d0))) {
						this.parentEntity.setDeltaMovement(this.parentEntity.getDeltaMovement().add(vector3d.scale(0.1D))); // TODO
																												// test
																												// fly
																												// speed
																												// here
					} else {
						this.operation = MovementController.Action.WAIT;
					}
				}

			}
		}

		private boolean canReach(Vector3d p_220673_1_, int p_220673_2_) {
			AxisAlignedBB axisalignedbb = this.parentEntity.getBoundingBox();

			for (int i = 1; i < p_220673_2_; ++i) {
				axisalignedbb = axisalignedbb.move(p_220673_1_);
				if (!this.parentEntity.level.noCollision(this.parentEntity, axisalignedbb)) {
					return false;
				}
			}

			return true;
		}
	}

	static class RandomFlyGoal extends Goal {
		private final CacodemonEntity parentEntity;

		public RandomFlyGoal(CacodemonEntity ghast) {
			this.parentEntity = ghast;
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean canUse() {
			MovementController movementcontroller = this.parentEntity.getMoveControl();
			if (!movementcontroller.hasWanted()) {
				return true;
			} else {
				double d0 = movementcontroller.getWantedX() - this.parentEntity.getX();
				double d1 = movementcontroller.getWantedY() - this.parentEntity.getY();
				double d2 = movementcontroller.getWantedZ() - this.parentEntity.getZ();
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				return d3 < 1.0D || d3 > 10.0D;
			}
		}

		public boolean canContinueToUse() {
			return false;
		}

		public void start() {
			Random random = this.parentEntity.getRandom();
			double d0 = this.parentEntity.getX() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 2.0F);
			double d1 = this.parentEntity.getY() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 2.0F);
			double d2 = this.parentEntity.getZ() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 2.0F);
			this.parentEntity.getMoveControl().setWantedPosition(d0, d1, d2, 1.0D);
		}
	}

	protected boolean shouldBurnInDay() {
		return false;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.CACODEMON_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.CACODEMON_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.CACODEMON_DEATH.get();
	}

	@Override
	public CreatureAttribute getMobType() {
		return CreatureAttribute.UNDEAD;
	}

	@Override
	protected float getSoundVolume() {
		return 1.0F;
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return 2;
	}

}