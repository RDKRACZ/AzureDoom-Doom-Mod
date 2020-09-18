package mod.azure.doomweapon.entity.projectiles;

import java.util.EnumSet;
import java.util.Random;

import mod.azure.doomweapon.entity.DemonEntity;
import mod.azure.doomweapon.entity.ai.goal.DemonAttackGoal;
import mod.azure.doomweapon.util.Config;
import mod.azure.doomweapon.util.registry.ModEntityTypes;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
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

public class LostSoulEntity extends DemonEntity implements IMob {

	public int explosionPower = 1;
	public int flameTimer;

	public LostSoulEntity(EntityType<? extends LostSoulEntity> type, World world) {
		super(type, world);
		this.moveController = new LostSoulEntity.MoveHelperController(this);
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
		this.goalSelector.addGoal(2, new LostSoulEntity.RandomFlyGoal(this));
		this.goalSelector.addGoal(2, new LostSoulEntity.LookAroundGoal(this));
		this.goalSelector.addGoal(2, new DemonAttackGoal(this, 1.0D, false));
		this.targetSelector.addGoal(9, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		if (Config.SERVER.IN_FIGHTING.get()) {
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MobEntity.class, true));
		}
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