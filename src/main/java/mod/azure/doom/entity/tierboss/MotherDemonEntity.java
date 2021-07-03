package mod.azure.doom.entity.tierboss;

import java.util.Random;

import mod.azure.doom.entity.DemonEntity;
import mod.azure.doom.entity.projectiles.CustomFireballEntity;
import mod.azure.doom.entity.projectiles.entity.DoomFireEntity;
import mod.azure.doom.util.config.Config;
import mod.azure.doom.util.config.EntityConfig;
import mod.azure.doom.util.config.EntityDefaults.EntityConfigType;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.BossInfo;
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

public class MotherDemonEntity extends DemonEntity implements IAnimatable {

	public static EntityConfig config = Config.SERVER.entityConfig.get(EntityConfigType.MOTHERDEMON);

	private final ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(),
			BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenScreen(true).setCreateWorldFog(true);

	public MotherDemonEntity(EntityType<MotherDemonEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("walking", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
		return PlayState.CONTINUE;
	}

	private <E extends IAnimatable> PlayState predicate1(AnimationEvent<E> event) {
		if (this.entityData.get(STATE) == 1 && !(this.dead || this.getHealth() < 0.01 || this.isDeadOrDying())) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("attacking", true));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<MotherDemonEntity>(this, "controller", 0, this::predicate));
		data.addAnimationController(
				new AnimationController<MotherDemonEntity>(this, "controller1", 0, this::predicate1));
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

	public static boolean spawning(EntityType<MotherDemonEntity> p_223337_0_, IWorld p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		return passPeacefulAndYCheck(config, p_223337_1_, reason, p_223337_3_, p_223337_4_);
	}

	public ServerBossInfo getBossInfo() {
		return bossInfo;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookAtGoal(this, AbstractVillagerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookAtGoal(this, IronGolemEntity.class, 8.0F));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
		this.applyEntityAI();
	}

	protected void applyEntityAI() {
		this.goalSelector.addGoal(1, new MotherDemonEntity.AttackingGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.addGoal(3, (new HurtByTargetGoal(this).setAlertOthers()));
	}

	static class AttackingGoal extends Goal {
		private final MotherDemonEntity parentEntity;
		protected int cooldown = 0;

		public AttackingGoal(MotherDemonEntity parentEntity) {
			this.parentEntity = parentEntity;
		}
		
		@Override
		public boolean canUse() {
			return this.parentEntity.getTarget() != null;
		}

		public void start() {
			super.start();
			this.parentEntity.setAggressive(true);
			this.cooldown = 0;
			this.parentEntity.setAttackingState(0);
		}

		@Override
		public void stop() {
			super.stop();
			this.parentEntity.setAggressive(false);
			this.parentEntity.setAttackingState(0);
		}

		public void tick() {
			LivingEntity livingEntity = this.parentEntity.getTarget();
			if (this.parentEntity.canSee(livingEntity)) {
				World world = this.parentEntity.level;
				Vector3d vec3d = this.parentEntity.getViewVector(1.0F);
				++this.cooldown;
				double f = livingEntity.getX() - (this.parentEntity.getX() + vec3d.x * 2.0D);
				double g = livingEntity.getY(0.5D) - (0.5D + this.parentEntity.getY(0.5D));
				double h = livingEntity.getZ() - (this.parentEntity.getZ() + vec3d.z * 2.0D);
				CustomFireballEntity fireballEntity = new CustomFireballEntity(world, this.parentEntity, f, g, h, 12);
				double d = Math.min(livingEntity.getY(), parentEntity.getY());
				double e1 = Math.max(livingEntity.getY(), parentEntity.getY()) + 1.0D;
				float f2 = (float) MathHelper.atan2(livingEntity.getZ() - parentEntity.getZ(),
						livingEntity.getX() - parentEntity.getX());
				int j;
				if (this.cooldown == 15) {
					if (parentEntity.distanceTo(livingEntity) < 13.0D) {
						for (j = 0; j < 16; ++j) {
							double l1 = 1.25D * (double) (j + 1);
							int m = 1 * j;
							parentEntity.spawnFlames(parentEntity.getX() + (double) MathHelper.cos(f2) * l1 + 0.5,
									parentEntity.getZ() + (double) MathHelper.sin(f2) * l1, d, e1, f2, m);
							this.parentEntity.setAttackingState(2);
						}
					} else {
						fireballEntity.setPos(this.parentEntity.getX() + vec3d.x * 2.0D,
								this.parentEntity.getY(0.5D) + 0.5D, parentEntity.getZ() + vec3d.z * 2.0D);
						world.addFreshEntity(fireballEntity);
						this.parentEntity.setAttackingState(1);
					}
				}
				if (this.cooldown == 20) {
					if (parentEntity.distanceTo(livingEntity) < 13.0D) {
						for (j = 0; j < 16; ++j) {
							double l1 = 1.25D * (double) (j + 1);
							int m = 1 * j;
							parentEntity.spawnFlames(parentEntity.getX() + (double) MathHelper.cos(f2) * l1,
									parentEntity.getZ() + (double) MathHelper.sin(f2) * l1 + 0.5, d, e1, f2, m);
						}
					} else {
						fireballEntity.setPos(this.parentEntity.getX() + vec3d.x * 2.0D,
								this.parentEntity.getY(0.5D) + 0.5D, parentEntity.getZ() + vec3d.z * 2.0D);
						world.addFreshEntity(fireballEntity);
					}
				}
				if (this.cooldown == 25) {
					this.parentEntity.setAttackingState(0);
					this.cooldown = -150;
				}
			} else if (this.cooldown > 0) {
				--this.cooldown;
			}
			this.parentEntity.lookAt(livingEntity, 30.0F, 30.0F);
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
		return config.pushAttributes(MobEntity.createMobAttributes().add(Attributes.FOLLOW_RANGE, 25.0D)
				.add(Attributes.KNOCKBACK_RESISTANCE, 1000.0D));
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

}
