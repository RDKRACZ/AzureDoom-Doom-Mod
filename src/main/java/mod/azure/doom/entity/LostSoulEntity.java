package mod.azure.doom.entity;

import java.util.EnumSet;
import java.util.Random;

import mod.azure.doom.entity.ai.goal.RandomFlyConvergeOnTargetGoal;
import mod.azure.doom.util.config.Config;
import mod.azure.doom.util.config.EntityConfig;
import mod.azure.doom.util.config.EntityDefaults.EntityConfigType;
import mod.azure.doom.util.registry.ModEntityTypes;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.MoverType;
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
import net.minecraft.entity.passive.IronGolemEntity;
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

public class LostSoulEntity extends DemonEntity implements IMob, IAnimatable {
	private static final DataParameter<Boolean> ATTACKING = EntityDataManager.defineId(LostSoulEntity.class,
			DataSerializers.BOOLEAN);
	public int explosionPower = 1;
	public int flameTimer;
	
	public static EntityConfig config = Config.SERVER.entityConfig.get(EntityConfigType.LOST_SOUL);

	public LostSoulEntity(EntityType<? extends LostSoulEntity> type, World world) {
		super(type, world);
		this.moveControl = new LostSoulEntity.MoveHelperController(this);
	}

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (!(animationSpeed > -0.15F && animationSpeed < 0.15F)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("walking", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<LostSoulEntity>(this, "controller", 0.1F, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@OnlyIn(Dist.CLIENT)
	public boolean isAttacking() {
		return this.entityData.get(ATTACKING);
	}

	public void setAttacking(boolean attacking) {
		this.entityData.set(ATTACKING, attacking);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(ATTACKING, false);
	}

	@OnlyIn(Dist.CLIENT)
	public LostSoulEntity(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
		super(ModEntityTypes.LOST_SOUL.get(), worldIn);
	}

	public LostSoulEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
		super(ModEntityTypes.LOST_SOUL.get(), worldIn);
	}

	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return config.pushAttributes(MobEntity.createMobAttributes().add(Attributes.FOLLOW_RANGE, 25.0D));
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LostSoulEntity.LookAroundGoal(this));
		this.goalSelector.addGoal(4, new LostSoulEntity.ChargeAttackGoal());
		this.goalSelector.addGoal(5, new RandomFlyConvergeOnTargetGoal(this, 4, 15, 0.5));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this).setAlertOthers()));
	}

	public static boolean spawning(EntityType<LostSoulEntity> p_223368_0_, IWorld p_223368_1_, SpawnReason reason,
			BlockPos p_223368_3_, Random p_223368_4_) {
		return passPeacefulAndYCheck(config, p_223368_1_, reason, p_223368_3_, p_223368_4_) && p_223368_4_.nextInt(20) == 0
				&& checkMobSpawnRules(p_223368_0_, p_223368_1_, reason, p_223368_3_, p_223368_4_);
	}

	public boolean isCharging() {
		return true;
	}

	public void setCharging(boolean charging) {
		return;
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

	public boolean onClimbable() {
		return false;
	}

	class ChargeAttackGoal extends Goal {
		public int attackTimer;

		public ChargeAttackGoal() {
			this.setFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean canUse() {
			if (LostSoulEntity.this.getTarget() != null && !LostSoulEntity.this.getMoveControl().hasWanted()
					&& LostSoulEntity.this.random.nextInt(7) == 0) {
				return LostSoulEntity.this.distanceToSqr(LostSoulEntity.this.getTarget()) > 4.0D;
			} else {
				return false;
			}
		}

		public boolean canContinueToUse() {
			return LostSoulEntity.this.getMoveControl().hasWanted() && LostSoulEntity.this.isCharging()
					&& LostSoulEntity.this.getTarget() != null && LostSoulEntity.this.getTarget().isAlive();
		}

		public void start() {
			LivingEntity livingentity = LostSoulEntity.this.getTarget();
			Vector3d vec3d = livingentity.getEyePosition(1.0F);
			LostSoulEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 4.0D);
			LostSoulEntity.this.setCharging(true);
			LostSoulEntity.this.playSound(ModSoundEvents.LOST_SOUL_AMBIENT.get(), 1.0F, 1.0F);
			this.attackTimer = 0;
		}

		public void stop() {
			LostSoulEntity.this.setCharging(false);
			LostSoulEntity.this.setAttacking(false);
		}

		public void tick() {
			LivingEntity livingentity = LostSoulEntity.this.getTarget();
			++this.attackTimer;
			if (LostSoulEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
				LostSoulEntity.this.doHurtTarget(livingentity);
				LostSoulEntity.this.setCharging(false);
				--this.attackTimer;
			} else {
				double d0 = LostSoulEntity.this.distanceToSqr(livingentity);
				if (d0 < 400.0D) { //this was set to 30.0D (very short) is this intended? results in tons of these mobs just sitting around
					Vector3d vec3d = livingentity.getEyePosition(1.0F);
					LostSoulEntity.this.moveControl.setWantedPosition(vec3d.x, vec3d.y, vec3d.z, 1.0D);
					this.attackTimer = -40;
				}
			}

			LostSoulEntity.this.setAttacking(this.attackTimer > 10);
		}
	}

	@Override
	public void aiStep() {
		super.aiStep();
		flameTimer = (flameTimer + 1) % 8;
	}

	@Override
	protected boolean shouldDespawnInPeaceful() {
		return true;
	}

	static class MoveHelperController extends MovementController {
		private final LostSoulEntity parentEntity;
		private int courseChangeCooldown;

		public MoveHelperController(LostSoulEntity ghast) {
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
						this.parentEntity.setDeltaMovement(this.parentEntity.getDeltaMovement().add(vector3d.scale(0.1D)));
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

	static class LookAroundGoal extends Goal {
		private final LostSoulEntity parentEntity;

		public LookAroundGoal(LostSoulEntity ghast) {
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

	protected boolean shouldBurnInDay() {
		return false;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.LOST_SOUL_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.LOST_SOUL_DEATH.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.LOST_SOUL_DEATH.get();
	}

	@Override
	public CreatureAttribute getMobType() {
		return CreatureAttribute.UNDEAD;
	}

	@Override
	protected float getSoundVolume() {
		return 1.0F;
	}

	public int getFlameTimer() {
		return flameTimer;
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return 7;
	}

}