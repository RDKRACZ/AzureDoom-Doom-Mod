package mod.azure.doom.entity;

import java.util.Random;

import javax.annotation.Nullable;

import mod.azure.doom.entity.projectiles.entity.ArchvileFiring;
import mod.azure.doom.entity.projectiles.entity.BarenBlastEntity;
import mod.azure.doom.util.config.Config;
import mod.azure.doom.util.config.EntityConfig;
import mod.azure.doom.util.config.EntityDefaults.EntityConfigType;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
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
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
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

public class MancubusEntity extends DemonEntity implements IAnimatable {

	private static final DataParameter<Boolean> ATTACKING = EntityDataManager.createKey(MancubusEntity.class,
			DataSerializers.BOOLEAN);

	public static EntityConfig config = Config.SERVER.entityConfig.get(EntityConfigType.MANCUBUS);

	private int attackTimer;

	public MancubusEntity(EntityType<MancubusEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving() && !this.dataManager.get(ATTACKING)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("walking", true));
			return PlayState.CONTINUE;
		}
		if ((this.dead || this.getHealth() < 0.01 || this.getShouldBeDead())) {
			if (world.isRemote) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("death", false));
				return PlayState.CONTINUE;
			}
		}
		if (this.dataManager.get(ATTACKING) && !(this.dead || this.getHealth() < 0.01 || this.getShouldBeDead())) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("attacking", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<MancubusEntity>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	protected void onDeathUpdate() {
		++this.deathTime;
		if (this.deathTime == 80) {
			this.remove();
			if (world.isRemote) {
			}
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

	public static boolean spawning(EntityType<MancubusEntity> p_223337_0_, IWorld p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		return passPeacefulAndYCheck(config, p_223337_1_, reason, p_223337_3_, p_223337_4_);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookAtGoal(this, MobEntity.class, 8.0F));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
		this.applyEntityAI();
	}

	protected void applyEntityAI() {
		this.goalSelector.addGoal(1, new MancubusEntity.FireballAttackGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
		this.targetSelector.addGoal(3, (new HurtByTargetGoal(this).setCallsForHelp()));
	}

	@Override
	protected void updateMovementGoalFlags() {
		boolean flag = this.getAttackTarget() != null && this.canEntityBeSeen(this.getAttackTarget());
		this.goalSelector.setFlag(Goal.Flag.LOOK, flag);
		super.updateMovementGoalFlags();
	}

	static class FireballAttackGoal extends Goal {
		private final MancubusEntity parentEntity;
		public int attackTimer;

		public FireballAttackGoal(MancubusEntity ghast) {
			this.parentEntity = ghast;
		}

		public boolean shouldExecute() {
			return this.parentEntity.getAttackTarget() != null;
		}

		public void startExecuting() {
			this.attackTimer = 0;
		}

		public void tick() {
			LivingEntity livingentity = this.parentEntity.getAttackTarget();
			if (this.parentEntity.canEntityBeSeen(livingentity)) {
				World world = this.parentEntity.world;
				++this.attackTimer;
				Vector3d vector3d = this.parentEntity.getLook(1.0F);
				double d0 = Math.min(livingentity.getPosY(), livingentity.getPosY());
				double d1 = Math.max(livingentity.getPosY(), livingentity.getPosY()) + 1.0D;
				double d2 = livingentity.getPosX() - (this.parentEntity.getPosX() + vector3d.x * 2.0D);
				double d3 = livingentity.getPosYHeight(0.5D) - (0.5D + this.parentEntity.getPosYHeight(0.5D));
				double d4 = livingentity.getPosZ() - (this.parentEntity.getPosZ() + vector3d.z * 2.0D);
				float f = (float) MathHelper.atan2(livingentity.getPosZ() - parentEntity.getPosZ(),
						livingentity.getPosX() - parentEntity.getPosX());
				BarenBlastEntity fireballentity = new BarenBlastEntity(world, this.parentEntity, d2, d3, d4);
				if (this.attackTimer == 15) {
					if (parentEntity.getDistance(livingentity) < 3.0D) {
						for (int i = 0; i < 5; ++i) {
							float f1 = f + (float) i * (float) Math.PI * 0.4F;
							parentEntity.spawnFlames(parentEntity.getPosX() + (double) MathHelper.cos(f1) * 1.5D,
									parentEntity.getPosZ() + (double) MathHelper.sin(f1) * 1.5D, d0, d1, f1, 0);
						}

						for (int k = 0; k < 8; ++k) {
							float f2 = f + (float) k * (float) Math.PI * 2.0F / 8.0F + 1.2566371F;
							parentEntity.spawnFlames(parentEntity.getPosX() + (double) MathHelper.cos(f2) * 2.5D,
									parentEntity.getPosZ() + (double) MathHelper.sin(f2) * 2.5D, d0, d1, f2, 3);
						}
					} else if (parentEntity.getDistance(livingentity) < 13.0D) {
						for (int l = 0; l < 16; ++l) {
							double d5 = 1.25D * (double) (l + 1);
							int j = 1 * l;
							parentEntity.spawnFlames(parentEntity.getPosX() + (double) MathHelper.cos(f) * d5,
									parentEntity.getPosZ() + (double) MathHelper.sin(f) * d5, d0, d1, f, j);
						}
					} else {
						fireballentity.setPosition(this.parentEntity.getPosX() + vector3d.x * 2.0D,
								this.parentEntity.getPosYHeight(0.5D) + 0.5D,
								fireballentity.getPosZ() + vector3d.z * 2.0D);
						fireballentity.setDirectHitDamage(13);
						world.addEntity(fireballentity);
					}
				}
				if (this.attackTimer == 20) {
					if (parentEntity.getDistance(livingentity) < 3.0D) {
						for (int i = 0; i < 5; ++i) {
							float f1 = f + (float) i * (float) Math.PI * 0.4F;
							parentEntity.spawnFlames(parentEntity.getPosX() + (double) MathHelper.cos(f1) * 1.5D,
									parentEntity.getPosZ() + (double) MathHelper.sin(f1) * 1.5D, d0, d1, f1, 0);
						}

						for (int k = 0; k < 8; ++k) {
							float f2 = f + (float) k * (float) Math.PI * 2.0F / 8.0F + 1.2566371F;
							parentEntity.spawnFlames(parentEntity.getPosX() + (double) MathHelper.cos(f2) * 2.5D,
									parentEntity.getPosZ() + (double) MathHelper.sin(f2) * 2.5D, d0, d1, f2, 3);
						}
					} else if (parentEntity.getDistance(livingentity) < 13.0D) {
						for (int l = 0; l < 16; ++l) {
							double d5 = 1.25D * (double) (l + 1);
							int j = 1 * l;
							parentEntity.spawnFlames(parentEntity.getPosX() + (double) MathHelper.cos(f) * d5,
									parentEntity.getPosZ() + (double) MathHelper.sin(f) * d5, d0, d1, f, j);
						}
					} else {
						fireballentity.setPosition(this.parentEntity.getPosX() + vector3d.x * 2.0D,
								this.parentEntity.getPosYHeight(0.5D) + 0.5D,
								fireballentity.getPosZ() + vector3d.z * 2.0D);
						fireballentity.setDirectHitDamage(config.RANGED_ATTACK_DAMAGE);
						world.addEntity(fireballentity);
					}
					this.attackTimer = -50;
				}
			} else if (this.attackTimer > 0) {
				--this.attackTimer;
			}
			this.parentEntity.faceEntity(livingentity, 30.0F, 30.0F);
			this.parentEntity.setAttacking(this.attackTimer > 10);
		}

	}

	public void spawnFlames(double x, double z, double maxY, double y, float yaw, int warmup) {
		BlockPos blockpos = new BlockPos(x, y, z);
		boolean flag = false;
		double d0 = 0.0D;
		do {
			BlockPos blockpos1 = blockpos.down();
			BlockState blockstate = this.world.getBlockState(blockpos1);
			if (blockstate.isSolidSide(this.world, blockpos1, Direction.UP)) {
				if (!this.world.isAirBlock(blockpos)) {
					BlockState blockstate1 = this.world.getBlockState(blockpos);
					VoxelShape voxelshape = blockstate1.getCollisionShape(this.world, blockpos);
					if (!voxelshape.isEmpty()) {
						d0 = voxelshape.getEnd(Direction.Axis.Y);
					}
				}
				flag = true;
				break;
			}
			blockpos = blockpos.down();
		} while (blockpos.getY() >= MathHelper.floor(maxY) - 1);

		if (flag) {
			ArchvileFiring fang = new ArchvileFiring(this.world, x, (double) blockpos.getY() + d0, z, yaw, 1, this);
			fang.setFire(ticksExisted);
			fang.setInvisible(false);
			this.world.addEntity(fang);
		}
	}

	public static AttributeModifierMap.MutableAttribute func_234200_m_() {
		return config.pushAttributes(MobEntity.func_233666_p_().createMutableAttribute(Attributes.FOLLOW_RANGE, 50.0D));
	}

	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		float f = difficultyIn.getClampedAdditionalDifficulty();
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		return spawnDataIn;
	}

	@Override
	public boolean isChild() {
		return false;
	}

	protected boolean shouldDrown() {
		return false;
	}

	protected boolean shouldBurnInDay() {
		return false;
	}

	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 2.80F;
	}

	@OnlyIn(Dist.CLIENT)
	public int getAttackTimer() {
		return this.attackTimer;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.MANCUBUS_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.MANCUBUS_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.MANCUBUS_DEATH.get();
	}

	protected SoundEvent getStepSound() {
		return ModSoundEvents.MANCUBUS_STEP.get();
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(this.getStepSound(), 0.15F, 1.0F);
	}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEAD;
	}
}