package mod.azure.doom.entity;

import java.util.Random;

import javax.annotation.Nullable;

import mod.azure.doom.util.Config;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.Explosion;
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
		if (Config.SERVER.IN_FIGHTING.get()) {
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MobEntity.class, true));
		}
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
						this.parentEntity.createExplosion(this.parentEntity, DamageSource.LIGHTNING_BOLT,
								this.parentEntity.getAttackTarget().getPosX(),
								this.parentEntity.getAttackTarget().getPosYEye(),
								this.parentEntity.getAttackTarget().getPosZ(), 1.0F, true, Explosion.Mode.NONE);
					}
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

	public Explosion createExplosion(@Nullable Entity entityIn, @Nullable DamageSource damageSourceIn, double xIn,
			double yIn, double zIn, float explosionRadius, boolean causesFire, Explosion.Mode modeIn) {
		Explosion explosion = new Explosion(this.world, entityIn, xIn, yIn, zIn, explosionRadius, causesFire, modeIn);
		if (damageSourceIn != null) {
			explosion.setDamageSource(damageSourceIn);
		}
		if (net.minecraftforge.event.ForgeEventFactory.onExplosionStart(this.world, explosion))
			return explosion;

		explosion.doExplosionA();
		explosion.doExplosionB(false);
		return explosion;
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