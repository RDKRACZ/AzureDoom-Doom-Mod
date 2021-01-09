package mod.azure.doom.entity;

import java.util.EnumSet;
import java.util.Random;

import mod.azure.doom.entity.ai.goal.DemonAttackGoal;
import mod.azure.doom.entity.ai.goal.RandomFlyConvergeOnTargetGoal;
import mod.azure.doom.entity.ai.goal.RangedStaticAttackGoal;
import mod.azure.doom.entity.attack.FireballAttack;
import mod.azure.doom.entity.projectiles.CustomFireballEntity;
import mod.azure.doom.util.Config;
import mod.azure.doom.util.EntityConfig;
import mod.azure.doom.util.EntityDefaults.EntityConfigType;
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
	private static final DataParameter<Boolean> ATTACKING = EntityDataManager.createKey(CacodemonEntity.class,
			DataSerializers.BOOLEAN);

	public static EntityConfig config = Config.SERVER.entityConfig.get(EntityConfigType.CACODEMON);

	public CacodemonEntity(EntityType<? extends CacodemonEntity> type, World worldIn) {
		super(type, worldIn);
		this.moveController = new CacodemonEntity.MoveHelperController(this);
	}

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F) && !this.dataManager.get(ATTACKING)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("walking", true));
			return PlayState.CONTINUE;
		}
		if ((this.dead || this.getHealth() < 0.01 || this.getShouldBeDead())) {
			if (world.isRemote) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("death", false));
				return PlayState.CONTINUE;
			}
		}
		if (this.dataManager.get(ATTACKING)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("attacking", false));
			return PlayState.CONTINUE;
		}
		if ((limbSwingAmount > -0.15F && limbSwingAmount < 0.15F) && !this.dataManager.get(ATTACKING)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
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
	protected void onDeathUpdate() {
		++this.deathTime;
		if (this.deathTime == 60) {
			this.remove();
		}
	}

	@OnlyIn(Dist.CLIENT)
	public boolean isAttacking() {
		return this.dataManager.get(ATTACKING);
	}

	@Override
	public void setAttacking(boolean attacking) {
		this.dataManager.set(ATTACKING, attacking);
	}

	@Override
	protected void registerData() {
		super.registerData();
		this.dataManager.register(ATTACKING, false);
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public static float fireBallDirectHitDamage = 6.0F;

	public static AttributeModifierMap.MutableAttribute func_234200_m_() {
		fireBallDirectHitDamage = config.RANGED_ATTACK_DAMAGE;
		return config.pushAttributes(
				MobEntity.func_233666_p_().createMutableAttribute(Attributes.ATTACK_DAMAGE, config.MELEE_ATTACK_DAMAGE)
						.createMutableAttribute(Attributes.FOLLOW_RANGE, 50.0D));
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(5, new RandomFlyConvergeOnTargetGoal(this, 2, 15, 0.5));
		this.goalSelector.addGoal(7, new CacodemonEntity.LookAroundGoal(this));
		this.goalSelector.addGoal(4,
				new RangedStaticAttackGoal(this, new FireballAttack(this, true).setDamage(config.RANGED_ATTACK_DAMAGE)
						.setProjectileOriginOffset(1.5, 0.3, 1.5).setSound(ModSoundEvents.CACODEMON_FIREBALL.get(),
								1.0F, 1.2F / (this.getRNG().nextFloat() * 0.2F + 0.9F)),
						60, 20, 30F));
		this.goalSelector.addGoal(4, new DemonAttackGoal(this, 1.0D, false));
		this.targetSelector.addGoal(1,
				new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 10, true, false, (p_213812_1_) -> {
					return Math.abs(p_213812_1_.getPosY() - this.getPosY()) <= 4.0D;
				}));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, 10, true,
				false, (p_213812_1_) -> {
					return Math.abs(p_213812_1_.getPosY() - this.getPosY()) <= 4.0D;
				}));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)));
	}

	public static boolean spawning(EntityType<CacodemonEntity> p_223368_0_, IWorld p_223368_1_, SpawnReason reason,
			BlockPos p_223368_3_, Random p_223368_4_) {
		return passPeacefulAndYCheck(config, p_223368_1_, reason, p_223368_3_, p_223368_4_)
				&& p_223368_4_.nextInt(20) == 0
				&& canSpawnOn(p_223368_0_, p_223368_1_, reason, p_223368_3_, p_223368_4_);
	}

	public int getFireballStrength() {
		return 1;
	}

	@Override
	protected boolean isDespawnPeaceful() {
		return true;
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 1.0F;
	}

	public boolean onLivingFall(float distance, float damageMultiplier) {
		return false;
	}

	protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	public void travel(Vector3d travelVector) {
		if (this.isInWater()) {
			this.moveRelative(0.02F, travelVector);
			this.move(MoverType.SELF, this.getMotion());
			this.setMotion(this.getMotion().scale((double) 0.8F));
		} else if (this.isInLava()) {
			this.moveRelative(0.02F, travelVector);
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

			this.moveRelative(this.onGround ? 0.1F * f1 : 0.02F, travelVector);
			this.move(MoverType.SELF, this.getMotion());
			this.setMotion(this.getMotion().scale((double) f));
		}

		this.func_233629_a_(this, false);
	}

	/**
	 * Returns true if this entity should move as if it were on a ladder (either
	 * because it's actually on a ladder, or for AI reasons)
	 */
	public boolean isOnLadder() {
		return false;
	}

	static class FireballAttackGoal extends Goal {
		private final CacodemonEntity parentEntity;
		public int attackTimer;

		public FireballAttackGoal(CacodemonEntity ghast) {
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
				this.parentEntity.getLookController().setLookPositionWithEntity(livingentity, 90.0F, 30.0F);
				World world = this.parentEntity.world;
				++this.attackTimer;

				if (this.attackTimer == 20) {
					Vector3d vector3d = this.parentEntity.getLook(1.0F);
					double d2 = livingentity.getPosX() - (this.parentEntity.getPosX() + vector3d.x * 0.5D);
					double d3 = livingentity.getPosYHeight(0.3D) - (0.5D + this.parentEntity.getPosYHeight(0.5D));
					double d4 = livingentity.getPosZ() - (this.parentEntity.getPosZ() + vector3d.z * 0.5D);

					CustomFireballEntity fireballentity = new CustomFireballEntity(world, this.parentEntity, d2, d3, d4,
							config.RANGED_ATTACK_DAMAGE);
					fireballentity.explosionPower = this.parentEntity.getFireballStrength();
					fireballentity.setPosition(this.parentEntity.getPosX() + vector3d.x * 0.5D,
							this.parentEntity.getPosYHeight(0.3D), fireballentity.getPosZ() + vector3d.z * 0.5D);
					this.parentEntity.playSound(ModSoundEvents.CACODEMON_FIREBALL.get(), 1.0F,
							1.2F / (this.parentEntity.rand.nextFloat() * 0.2F + 0.9F));
					world.addEntity(fireballentity);
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
			this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
		}

		public boolean shouldExecute() {
			return true;
		}

		public void tick() {
			if (this.parentEntity.getAttackTarget() == null) {
				Vector3d vec3d = this.parentEntity.getMotion();
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

	static class MoveHelperController extends MovementController {
		private final CacodemonEntity parentEntity;
		private int courseChangeCooldown;

		public MoveHelperController(CacodemonEntity ghast) {
			super(ghast);
			this.parentEntity = ghast;
		}

		public void tick() {
			if (this.action == MovementController.Action.MOVE_TO) {
				if (this.courseChangeCooldown-- <= 0) {
					this.courseChangeCooldown += this.parentEntity.getRNG().nextInt(5) + 2;
					Vector3d vector3d = new Vector3d(this.posX - this.parentEntity.getPosX(),
							this.posY - this.parentEntity.getPosY(), this.posZ - this.parentEntity.getPosZ());
					double d0 = vector3d.length();
					vector3d = vector3d.normalize();
					if (this.func_220673_a(vector3d, MathHelper.ceil(d0))) {
						this.parentEntity.setMotion(this.parentEntity.getMotion().add(vector3d.scale(0.1D))); // TODO
																												// test
																												// fly
																												// speed
																												// here
					} else {
						this.action = MovementController.Action.WAIT;
					}
				}

			}
		}

		private boolean func_220673_a(Vector3d p_220673_1_, int p_220673_2_) {
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

	static class RandomFlyGoal extends Goal {
		private final CacodemonEntity parentEntity;

		public RandomFlyGoal(CacodemonEntity ghast) {
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
				return d3 < 1.0D || d3 > 10.0D;
			}
		}

		public boolean shouldContinueExecuting() {
			return false;
		}

		public void startExecuting() {
			Random random = this.parentEntity.getRNG();
			double d0 = this.parentEntity.getPosX() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 2.0F);
			double d1 = this.parentEntity.getPosY() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 2.0F);
			double d2 = this.parentEntity.getPosZ() + (double) ((random.nextFloat() * 2.0F - 1.0F) * 2.0F);
			this.parentEntity.getMoveHelper().setMoveTo(d0, d1, d2, 1.0D);
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
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEAD;
	}

	@Override
	protected float getSoundVolume() {
		return 1.0F;
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 2;
	}

}