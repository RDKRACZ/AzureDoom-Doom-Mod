package mod.azure.doom.entity;

import java.util.List;
import java.util.Random;

import mod.azure.doom.entity.ai.goal.HurtByAggressorGoal;
import mod.azure.doom.entity.ai.goal.TargetAggressorGoal;
import mod.azure.doom.entity.projectiles.entity.ArchvileFiring;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class ArchvileEntity extends DemonEntity {

	private static final DataParameter<Boolean> ATTACKING = EntityDataManager.createKey(ArchvileEntity.class,
			DataSerializers.BOOLEAN);

	public ArchvileEntity(EntityType<ArchvileEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public static boolean spawning(EntityType<ArchvileEntity> p_223337_0_, IWorld p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		return p_223337_1_.getDifficulty() != Difficulty.PEACEFUL;
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(25.0D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
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

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(7, new ArchvileEntity.AttackGoal(this));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(1, new HurtByAggressorGoal(this));
		this.targetSelector.addGoal(2, new TargetAggressorGoal(this));
	}

	static class AttackGoal extends Goal {
		private final ArchvileEntity parentEntity;
		public int attackTimer;

		public AttackGoal(ArchvileEntity ghast) {
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
				this.parentEntity.getLookController().setLookPositionWithEntity(livingentity, 90.0F, 30.0F);
				++this.attackTimer;
				if (this.attackTimer == 40) {
					if (!this.parentEntity.world.isRemote) {
						float f2 = 24.0F;
						int k1 = MathHelper.floor(this.parentEntity.getPosX() - (double) f2 - 1.0D);
						int l1 = MathHelper.floor(this.parentEntity.getPosX() + (double) f2 + 1.0D);
						int i2 = MathHelper.floor(this.parentEntity.getPosY() - (double) f2 - 1.0D);
						int i1 = MathHelper.floor(this.parentEntity.getPosY() + (double) f2 + 1.0D);
						int j2 = MathHelper.floor(this.parentEntity.getPosZ() - (double) f2 - 1.0D);
						int j1 = MathHelper.floor(this.parentEntity.getPosZ() + (double) f2 + 1.0D);
						List<Entity> list = this.parentEntity.world
								.getEntitiesWithinAABBExcludingEntity(this.parentEntity, new AxisAlignedBB((double) k1,
										(double) i2, (double) j2, (double) l1, (double) i1, (double) j1));
						Vec3d vector3d1 = new Vec3d(this.parentEntity.getPosX(), this.parentEntity.getPosY(),
								this.parentEntity.getPosZ());
						for (int k2 = 0; k2 < list.size(); ++k2) {
							Entity entity = list.get(k2);

							if ((entity instanceof DemonEntity)) {
								double d12 = (double) (MathHelper.sqrt(entity.getDistanceSq(vector3d1)) / f2);
								if (d12 <= 1.0D) {
									if (entity.isAlive() || entity.isLiving()) {
										((DemonEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.SPEED, 1000, 1));
										((DemonEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.STRENGTH, 1000, 1));
									}
									entity.setGlowing(true);
								}
							}
							if (entity instanceof LivingEntity) {
								if (entity.isAlive() && parentEntity.getAttackTarget().canEntityBeSeen(livingentity)) {
									entity.setFire(3);
								}
							}
						}
						double d0 = Math.min(livingentity.getPosY(), livingentity.getPosY());
						double d1 = Math.max(livingentity.getPosY(), livingentity.getPosY()) + 1.0D;
						float f = (float) MathHelper.atan2(livingentity.getPosZ() - parentEntity.getPosZ(),
								livingentity.getPosX() - parentEntity.getPosX());
						if (parentEntity.getDistanceSq(livingentity) < 9.0D
								&& parentEntity.getAttackTarget().canEntityBeSeen(livingentity)) {
							for (int i = 0; i < 5; ++i) {
								float f1 = f + (float) i * (float) Math.PI * 0.4F;
								parentEntity.spawnFangs(parentEntity.getPosX() + (double) MathHelper.cos(f1) * 1.5D,
										parentEntity.getPosZ() + (double) MathHelper.sin(f1) * 1.5D, d0, d1, f1, 0);
							}

							for (int k = 0; k < 8; ++k) {
								float f21 = f + (float) k * (float) Math.PI * 2.0F / 8.0F + 1.2566371F;
								parentEntity.spawnFangs(parentEntity.getPosX() + (double) MathHelper.cos(f21) * 2.5D,
										parentEntity.getPosZ() + (double) MathHelper.sin(f21) * 2.5D, d0, d1, f21, 3);
							}
						} else {
							for (int l = 0; l < 16; ++l) {
								double d2 = 1.25D * (double) (l + 1);
								int j = 1 * l;
								parentEntity.spawnFangs(parentEntity.getPosX() + (double) MathHelper.cos(f) * d2,
										parentEntity.getPosZ() + (double) MathHelper.sin(f) * d2, d0, d1, f, j);
							}
						}
					}
					this.parentEntity.getLookController().setLookPositionWithEntity(livingentity, 30.0F, 30.0F);
					if (!(this.parentEntity.world.isRemote)) {
						this.parentEntity.playSound(ModSoundEvents.ARCHVILE_SCREAM.get(), 1.0F,
								1.2F / (this.parentEntity.rand.nextFloat() * 0.2F + 0.9F));
					}
					this.attackTimer = -80;
				}
			} else if (this.attackTimer > 0) {
				--this.attackTimer;
			}

			this.parentEntity.setAttacking(this.attackTimer > 10);
		}
	}

	public void spawnFangs(double p_190876_1_, double p_190876_3_, double p_190876_5_, double p_190876_7_,
			float p_190876_9_, int p_190876_10_) {
		BlockPos blockpos = new BlockPos(p_190876_1_, p_190876_7_, p_190876_3_);
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
		} while (blockpos.getY() >= MathHelper.floor(p_190876_5_) - 1);

		if (flag) {
			ArchvileFiring fang = new ArchvileFiring(this.world, p_190876_1_, (double) blockpos.getY() + d0,
					p_190876_3_, p_190876_9_, p_190876_10_, this);
			fang.setFire(ticksExisted);
			fang.setInvisible(false);
			this.world.addEntity(fang);
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.ARCHVILE_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.ARCHVILE_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.ARCHVILE_DEATH.get();
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

}