package mod.azure.doom.entity;

import java.util.EnumSet;
import java.util.Random;

import mod.azure.doom.entity.ai.goal.HurtByAggressorGoal;
import mod.azure.doom.entity.ai.goal.TargetAggressorGoal;
import mod.azure.doom.util.registry.ModEntityTypes;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
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
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Explosion;
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
	private static final DataParameter<Boolean> ATTACKING = EntityDataManager.createKey(ArachnotronEntity.class,
			DataSerializers.BOOLEAN);

	public int explosionPower = 1;
	public int flameTimer;

	public LostSoulEntity(EntityType<? extends LostSoulEntity> type, World world) {
		super(type, world);
		this.moveController = new LostSoulEntity.MoveHelperController(this);
	}

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)) {
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
		return this.dataManager.get(ATTACKING);
	}

	public void setAttacking(boolean attacking) {
		this.dataManager.set(ATTACKING, attacking);
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(ATTACKING, false);
	}

	public boolean onLivingFall(float distance, float damageMultiplier) {
		return false;
	}

	protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	public void travel(Vec3d positionIn) {
		if (this.isInWater()) {
			this.moveRelative(0.02F, positionIn);
			this.move(MoverType.SELF, this.getMotion());
			this.setMotion(this.getMotion().scale((double) 0.8F));
		} else if (this.isInLava()) {
			this.moveRelative(0.02F, positionIn);
			this.move(MoverType.SELF, this.getMotion());
			this.setMotion(this.getMotion().scale(0.5D));
		} else {
			BlockPos ground = new BlockPos(this.getPosX(), this.getPosY() - 1.0D, this.getPosZ());
			float f = 0.91F;
			if (this.onGround) {
				f = this.world.getBlockState(ground).getSlipperiness(this.world, ground, this) * 0.91F;
			}

			float f1 = 0.16277137F / (f * f * f);
			f = 0.91F;
			if (this.onGround) {
				f = this.world.getBlockState(ground).getSlipperiness(this.world, ground, this) * 0.91F;
			}

			this.moveRelative(this.onGround ? 0.1F * f1 : 0.02F, positionIn);
			this.move(MoverType.SELF, this.getMotion());
			this.setMotion(this.getMotion().scale((double) f));
		}

		this.prevLimbSwingAmount = this.limbSwingAmount;
		double d1 = this.getPosX() - this.prevPosX;
		double d0 = this.getPosZ() - this.prevPosZ;
		float f2 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}

		this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
		this.limbSwing += this.limbSwingAmount;
	}

	public boolean isOnLadder() {
		return false;
	}

	@OnlyIn(Dist.CLIENT)
	public LostSoulEntity(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
		super(ModEntityTypes.LOST_SOUL.get(), worldIn);
	}

	public LostSoulEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
		super(ModEntityTypes.LOST_SOUL.get(), worldIn);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LostSoulEntity.LookAroundGoal(this));
		this.goalSelector.addGoal(4, new LostSoulEntity.ChargeAttackGoal());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(1, new HurtByAggressorGoal(this));
		this.targetSelector.addGoal(2, new TargetAggressorGoal(this));
	}

	public static boolean spawning(EntityType<LostSoulEntity> p_223368_0_, IWorld p_223368_1_, SpawnReason reason,
			BlockPos p_223368_3_, Random p_223368_4_) {
		return p_223368_1_.getDifficulty() != Difficulty.PEACEFUL && p_223368_4_.nextInt(20) == 0
				&& canSpawnOn(p_223368_0_, p_223368_1_, reason, p_223368_3_, p_223368_4_);
	}

	@Override
	public void livingTick() {
		super.livingTick();
		flameTimer = (flameTimer + 1) % 8;
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected boolean isDespawnPeaceful() {
		return true;
	}

	public boolean isCharging() {
		return true;
	}

	public void setCharging(boolean charging) {
		return;
	}

	class ChargeAttackGoal extends Goal {
		public ChargeAttackGoal() {
			this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
		}

		public boolean shouldExecute() {
			if (LostSoulEntity.this.getAttackTarget() != null && !LostSoulEntity.this.getMoveHelper().isUpdating()
					&& LostSoulEntity.this.rand.nextInt(7) == 0) {
				return LostSoulEntity.this.getDistanceSq(LostSoulEntity.this.getAttackTarget()) > 4.0D;
			} else {
				return false;
			}
		}

		public boolean shouldContinueExecuting() {
			return LostSoulEntity.this.getMoveHelper().isUpdating() && LostSoulEntity.this.isCharging()
					&& LostSoulEntity.this.getAttackTarget() != null && LostSoulEntity.this.getAttackTarget().isAlive();
		}

		public void startExecuting() {
			LivingEntity livingentity = LostSoulEntity.this.getAttackTarget();
			Vec3d vec3d = livingentity.getEyePosition(1.0F);
			LostSoulEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
			LostSoulEntity.this.setCharging(true);
			LostSoulEntity.this.playSound(ModSoundEvents.LOST_SOUL_AMBIENT.get(), 1.0F, 1.0F);
		}

		public void resetTask() {
			LostSoulEntity.this.setCharging(false);
		}

		public void tick() {
			LivingEntity livingentity = LostSoulEntity.this.getAttackTarget();
			if (LostSoulEntity.this.getBoundingBox().intersects(livingentity.getBoundingBox())) {
				LostSoulEntity.this.attackEntityAsMob(livingentity);
				LostSoulEntity.this.setCharging(false);
			} else {
				double d0 = LostSoulEntity.this.getDistanceSq(livingentity);
				if (d0 < 9.0D) {
					Vec3d vec3d = livingentity.getEyePosition(1.0F);
					LostSoulEntity.this.moveController.setMoveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
				}
			}

		}
	}

	static class MoveHelperController extends MovementController {
		private final LostSoulEntity parentEntity;
		private int courseChangeCooldown;

		public MoveHelperController(LostSoulEntity ghast) {
			super(ghast);
			this.parentEntity = ghast;
		}

		public void tick() {
			if (this.action == MovementController.Action.MOVE_TO) {
				if (this.courseChangeCooldown-- <= 0) {
					this.courseChangeCooldown += this.parentEntity.getRNG().nextInt(5) + 2;
					Vec3d vec3d = new Vec3d(this.posX - this.parentEntity.getPosX(),
							this.posY - this.parentEntity.getPosY(), this.posZ - this.parentEntity.getPosZ());
					double d0 = vec3d.length();
					vec3d = vec3d.normalize();
					if (this.func_220673_a(vec3d, MathHelper.ceil(d0))) {
						this.parentEntity.setMotion(this.parentEntity.getMotion().add(vec3d.scale(0.1D)));
					} else {
						this.action = MovementController.Action.WAIT;
					}
				}

			}
		}

		private boolean func_220673_a(Vec3d p_220673_1_, int p_220673_2_) {
			AxisAlignedBB axisalignedbb = this.parentEntity.getBoundingBox();

			for (int i = 1; i < p_220673_2_; ++i) {
				axisalignedbb = axisalignedbb.offset(p_220673_1_);
				if (!this.parentEntity.world.hasNoCollisions(this.parentEntity, axisalignedbb)) {
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
				if (livingentity.getDistanceSq(this.parentEntity) < 4.0D) {
					double d1 = livingentity.getPosX() - this.parentEntity.getPosX();
					double d2 = livingentity.getPosZ() - this.parentEntity.getPosZ();
					this.parentEntity.rotationYaw = -((float) MathHelper.atan2(d1, d2)) * (180F / (float) Math.PI);
					this.parentEntity.renderYawOffset = this.parentEntity.rotationYaw;
				}
			}

		}
	}

	protected boolean shouldBurnInDay() {
		return false;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.PAIN_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.PAIN_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.PAIN_DEATH.get();
	}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEAD;
	}

	@Override
	protected float getSoundVolume() {
		return 1.0F;
	}

	protected void explode() {
		this.world.createExplosion(this, this.getPosX(), this.getPosYHeight(0.0625D), this.getPosZ(), 1.0F,
				Explosion.Mode.NONE);
	}

	public int getFlameTimer() {
		return flameTimer;
	}

}