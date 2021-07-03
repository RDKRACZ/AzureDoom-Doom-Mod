package mod.azure.doom.entity.tierboss;

import java.util.List;
import java.util.Random;
import java.util.SplittableRandom;

import javax.annotation.Nullable;

import mod.azure.doom.entity.DemonEntity;
import mod.azure.doom.entity.projectiles.entity.DoomFireEntity;
import mod.azure.doom.util.config.Config;
import mod.azure.doom.util.config.EntityConfig;
import mod.azure.doom.util.config.EntityDefaults.EntityConfigType;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class IconofsinEntity extends DemonEntity implements IAnimatable {

	public static EntityConfig config = Config.SERVER.entityConfig.get(EntityConfigType.ICON_OF_SIN);

	private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(),
			BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenScreen(true).setCreateWorldFog(true);

	public IconofsinEntity(EntityType<IconofsinEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving() && this.getHealth() > (this.getMaxHealth() * 0.50)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("walking", true));
			return PlayState.CONTINUE;
		}
		if ((this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("death", false));
			return PlayState.CONTINUE;
		}
		if (event.isMoving() && this.getHealth() < (this.getMaxHealth() * 0.50)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("walking_nohelmet", true));
			return PlayState.CONTINUE;
		}
		if (this.getHealth() < (this.getMaxHealth() * 0.50)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("idle_nohelmet", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
		return PlayState.CONTINUE;
	}

	private <E extends IAnimatable> PlayState predicate1(AnimationEvent<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("summoned", true));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<IconofsinEntity>(this, "controller", 0, this::predicate));
		data.addAnimationController(new AnimationController<IconofsinEntity>(this, "controller1", 0, this::predicate1));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 50) {
			this.remove();
		}
	}

	@Override
	public boolean causeFallDamage(float distance, float damageMultiplier) {
		return false;
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void pushEntities() {
	}

	@Override
	protected boolean canRide(Entity p_184228_1_) {
		return false;
	}

	@Override
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public static boolean spawning(EntityType<IconofsinEntity> p_223337_0_, IWorld p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		return passPeacefulAndYCheck(config, p_223337_1_, reason, p_223337_3_, p_223337_4_);
	}

	public ServerBossInfo getBossInfo() {
		return bossInfo;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.applyEntityAI();
	}

	protected void applyEntityAI() {
		this.goalSelector.addGoal(9, new IconofsinEntity.FireballAttackGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this).setAlertOthers()));
	}

	static class FireballAttackGoal extends Goal {
		private final IconofsinEntity parentEntity;
		protected int attackTimer = 0;

		public FireballAttackGoal(IconofsinEntity ghast) {
			this.parentEntity = ghast;
		}

		@Override
		public boolean canUse() {
			return this.parentEntity.getTarget() != null;
		}

		public void start() {
			super.start();
			this.parentEntity.setAggressive(true);
		}

		@Override
		public void stop() {
			super.stop();
			this.parentEntity.setAggressive(false);
			this.parentEntity.setAttackingState(0);
			this.attackTimer = -1;
		}

		@Override
		public void tick() {
			LivingEntity livingentity = this.parentEntity.getTarget();
			if (livingentity != null) {
				if (this.parentEntity.canSee(livingentity) && parentEntity.distanceTo(livingentity) < 10.0D) {
					attackTimer++;
					Random rand = new Random();
					double d0 = Math.min(livingentity.getY(), livingentity.getY());
					double d1 = Math.max(livingentity.getY(), livingentity.getY()) + 1.0D;
					float f = (float) MathHelper.atan2(livingentity.getZ() - parentEntity.getZ(),
							livingentity.getX() - parentEntity.getX());
					if (this.attackTimer == 35) {
						SplittableRandom random = new SplittableRandom();
						boolean r = random.nextInt(1, 101) <= 20;
						if (parentEntity.distanceTo(livingentity) < 13.0D) {
							if (r) {
								for (int i = 15; i < 55; ++i) {
									float f1 = f + (float) i * (float) Math.PI * 0.4F;
									parentEntity.spawnFlames(
											parentEntity.getX()
													+ (double) MathHelper.cos(f1) * rand.nextDouble() * 11.5D,
											parentEntity.getZ()
													+ (double) MathHelper.sin(f1) * rand.nextDouble() * 11.5D,
											d0, d1, f1, 0);
									parentEntity.spawnFlames(
											parentEntity.getX()
													+ (double) MathHelper.cos(f1) * rand.nextDouble() * 11.5D,
											parentEntity.getZ()
													+ (double) MathHelper.sin(f1) * rand.nextDouble() * 11.5D,
											d0, d1, f1, 0);
									parentEntity.spawnFlames(
											parentEntity.getX()
													+ (double) MathHelper.cos(f1) * rand.nextDouble() * 11.5D,
											parentEntity.getZ()
													+ (double) MathHelper.sin(f1) * rand.nextDouble() * 11.5D,
											d0, d1, f1, 0);
									parentEntity.spawnFlames(
											parentEntity.getX()
													+ (double) MathHelper.cos(f1) * rand.nextDouble() * 11.5D,
											parentEntity.getZ()
													+ (double) MathHelper.sin(f1) * rand.nextDouble() * 11.5D,
											d0, d1, f1, 0);
									parentEntity.spawnFlames(
											parentEntity.getX()
													+ (double) MathHelper.cos(f1) * rand.nextDouble() * 11.5D,
											parentEntity.getZ()
													+ (double) MathHelper.sin(f1) * rand.nextDouble() * 11.5D,
											d0, d1, f1, 0);
								}
							} else {
								parentEntity.doDamage();
							}
							this.parentEntity.setAttackingState(1);
						}
					}
					if (this.attackTimer == 45) {
						this.parentEntity.setAttackingState(0);
						this.attackTimer = -135;
					}
				} else if (this.attackTimer > 0) {
					--this.attackTimer;
					this.parentEntity.setAttackingState(0);
				}
			}
		}

	}

	public void doDamage() {
		float f2 = 4.0F;
		int k1 = MathHelper.floor(this.getX() - (double) f2 - 1.0D);
		int l1 = MathHelper.floor(this.getX() + (double) f2 + 1.0D);
		int i2 = MathHelper.floor(this.getY() - (double) f2 - 1.0D);
		int i1 = MathHelper.floor(this.getY() + (double) f2 + 1.0D);
		int j2 = MathHelper.floor(this.getZ() - (double) f2 - 1.0D);
		int j1 = MathHelper.floor(this.getZ() + (double) f2 + 1.0D);
		List<Entity> list = this.level.getEntities(this,
				new AxisAlignedBB((double) k1, (double) i2, (double) j2, (double) l1, (double) i1, (double) j1));
		Vector3d vector3d = new Vector3d(this.getX(), this.getY(), this.getZ());
		for (int k2 = 0; k2 < list.size(); ++k2) {
			Entity entity = list.get(k2);
			double d12 = (double) (MathHelper.sqrt(entity.distanceToSqr(vector3d)) / f2);
			if (d12 <= 1.0D) {
				if (entity instanceof LivingEntity) {
					entity.hurt(DamageSource.indirectMagic(this, this.getTarget()), 7);
					if (!this.level.isClientSide) {
						List<LivingEntity> list1 = this.level.getEntitiesOfClass(LivingEntity.class,
								this.getBoundingBox().inflate(4.0D, 2.0D, 4.0D));
						AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(entity.level,
								entity.getX(), entity.getY(), entity.getZ());
						areaeffectcloudentity.setParticle(ParticleTypes.EXPLOSION);
						areaeffectcloudentity.setRadius(3.0F);
						areaeffectcloudentity.setDuration(10);
						if (!list1.isEmpty()) {
							for (LivingEntity livingentity : list1) {
								double d0 = this.distanceToSqr(livingentity);
								if (d0 < 16.0D) {
									areaeffectcloudentity.setPos(entity.getX(), entity.getEyeY(), entity.getZ());
								}
							}
						}
						entity.level.addFreshEntity(areaeffectcloudentity);
					}
				}
			}
		}
	}

	public void spawnFlames(double x, double z, double maxY, double y, float yaw, int warmup) {
		BlockPos blockpos = new BlockPos(x, y, z);
		boolean flag = false;
		double d0 = 0.0D;
		do {
			BlockPos blockpos1 = blockpos.below();
			BlockState blockstate = this.level.getBlockState(blockpos1);
			if (blockstate.isFaceSturdy(this.level, blockpos1, Direction.UP)) {
				if (!this.level.isEmptyBlock(blockpos)) {
					BlockState blockstate1 = this.level.getBlockState(blockpos);
					VoxelShape voxelshape = blockstate1.getCollisionShape(this.level, blockpos);
					if (!voxelshape.isEmpty()) {
						d0 = voxelshape.max(Direction.Axis.Y);
					}
				}
				flag = true;
				break;
			}
			blockpos = blockpos.below();
		} while (blockpos.getY() >= MathHelper.floor(maxY) - 1);

		if (flag) {
			DoomFireEntity fang = new DoomFireEntity(this.level, x, (double) blockpos.getY() + d0, z, yaw, 1, this);
			fang.setSecondsOnFire(tickCount);
			fang.setInvisible(false);
			this.level.addFreshEntity(fang);
		}
	}

	public static AttributeModifierMap.MutableAttribute createAttributes() {
		return config.pushAttributes(MobEntity.createMobAttributes().add(Attributes.FOLLOW_RANGE, 100.0D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1000.0D));
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 18.70F;
	}

	@Nullable
	@Override
	public ILivingEntityData finalizeSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.finalizeSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		float f = difficultyIn.getSpecialMultiplier();
		this.setCanPickUpLoot(this.random.nextFloat() < 0.55F * f);
		return spawnDataIn;
	}

	protected boolean shouldDrown() {
		return false;
	}

	protected boolean shouldBurnInDay() {
		return false;
	}

	public void addAdditionalSaveData(CompoundNBT compound) {
		super.addAdditionalSaveData(compound);
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.ICON_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.ICON_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.ICON_DEATH.get();
	}

	protected SoundEvent getStepSound() {
		return SoundEvents.SKELETON_STEP;
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(this.getStepSound(), 0.15F, 1.0F);
	}

	@Override
	public CreatureAttribute getMobType() {
		return CreatureAttribute.UNDEAD;
	}

	@Override
	public boolean canChangeDimensions() {
		return false;
	}

	@Override
	public void startSeenByPlayer(ServerPlayerEntity player) {
		super.startSeenByPlayer(player);
		this.bossInfo.addPlayer(player);
	}

	@Override
	public void stopSeenByPlayer(ServerPlayerEntity player) {
		super.stopSeenByPlayer(player);
		this.bossInfo.removePlayer(player);
	}

	@Override
	public int getMaxSpawnClusterSize() {
		return 1;
	}

	@Override
	public void readAdditionalSaveData(CompoundNBT compound) {
		super.readAdditionalSaveData(compound);
		if (this.hasCustomName()) {
			this.bossInfo.setName(this.getDisplayName());
		}
	}

	@Override
	public void setCustomName(ITextComponent name) {
		super.setCustomName(name);
		this.bossInfo.setName(this.getDisplayName());
	}

	@Override
	protected void customServerAiStep() {
		super.customServerAiStep();
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}

	@Override
	public void tick() {
		super.tick();
		if (this.isAlive()) {
			if (this.isInWall()) {
				this.noPhysics = true;
			}
			if (!this.isInWall()) {
				this.noPhysics = false;
			}
		}
	}

	@Override
	public int getArmorValue() {
		float health = this.getHealth();
		return (health < (this.getMaxHealth() * 0.95) && health >= (this.getMaxHealth() * 0.90) ? 27
				: health < (this.getMaxHealth() * 0.90) && health >= (this.getMaxHealth() * 0.85) ? 24
						: health < (this.getMaxHealth() * 0.85) && health >= (this.getMaxHealth() * 0.80) ? 21
								: health < (this.getMaxHealth() * 0.80) && health >= (this.getMaxHealth() * 0.75) ? 18
										: health < (this.getMaxHealth() * 0.75)
												&& health >= (this.getMaxHealth() * 0.70)
														? 15
														: health < (this.getMaxHealth() * 0.70)
																&& health >= (this.getMaxHealth() * 0.65)
																		? 12
																		: health < (this.getMaxHealth() * 0.65)
																				&& health >= (this
																						.getMaxHealth() * 0.60)
																								? 9
																								: health < (this
																										.getMaxHealth()
																										* 0.60)
																										&& health >= (this
																												.getMaxHealth()
																												* 0.55) ? 6
																														: health < (this
																																.getMaxHealth()
																																* 0.55)
																																&& health >= (this
																																		.getMaxHealth()
																																		* 0.50) ? 3
																																				: health < (this
																																						.getMaxHealth()
																																						* 0.50) ? 0
																																								: 30);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		++this.tickCount;
		if (this.getHealth() > (this.getMaxHealth() * 0.50)) {
			if (!this.level.isClientSide) {
				this.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 1000000, 1));
			}
		}
		if (this.getHealth() < (this.getMaxHealth() * 0.50)) {
			if (!this.level.isClientSide) {
				this.removeEffect(Effects.DAMAGE_BOOST);
				this.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 10000000, 2));
				this.addEffect(new EffectInstance(Effects.WEAKNESS, 10000000, 1));
			}
		}
		if (!this.level.dimensionType().respawnAnchorWorks()) {
			if (!this.level.isClientSide) {
				this.setGlowing(true);
				this.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 10000000, 3));
			}
		}
		if (!this.level.dimensionType().respawnAnchorWorks()) {
			if (this.tickCount % 2400 == 0) {
				this.heal(40F);
			}
		}
	}

	@Override
	public boolean hurt(DamageSource p_70097_1_, float p_70097_2_) {
		return p_70097_1_ == DamageSource.IN_WALL ? false : super.hurt(p_70097_1_, p_70097_2_);
	}
}