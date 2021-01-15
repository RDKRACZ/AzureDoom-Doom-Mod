package mod.azure.doom.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Random;

import javax.annotation.Nullable;

import mod.azure.doom.entity.ai.goal.DemonAttackGoal;
import mod.azure.doom.entity.ai.goal.HurtByAggressorGoal;
import mod.azure.doom.entity.ai.goal.RangedStaticAttackGoal;
import mod.azure.doom.entity.ai.goal.TargetAggressorGoal;
import mod.azure.doom.entity.attack.AbstractRangedAttack;
import mod.azure.doom.entity.attack.AttackSound;
import mod.azure.doom.entity.projectiles.entity.BarenBlastEntity;
import mod.azure.doom.util.Config;
import mod.azure.doom.util.EntityConfig;
import mod.azure.doom.util.EntityDefaults.EntityConfigType;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
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

public class CyberdemonEntity extends DemonEntity implements IAnimatable {
	private static final DataParameter<Boolean> ATTACKING = EntityDataManager.createKey(CyberdemonEntity.class,
			DataSerializers.BOOLEAN);

	public static EntityConfig config = Config.SERVER.entityConfig.get(EntityConfigType.CYBER_DEMON);

	public CyberdemonEntity(EntityType<? extends CyberdemonEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("walking", true));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<CyberdemonEntity>(this, "controller", 0, this::predicate));
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

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public static boolean spawning(EntityType<CyberdemonEntity> p_223337_0_, IWorld p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		return p_223337_1_.getDifficulty() != Difficulty.PEACEFUL;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.goalSelector.addGoal(4,
				new RangedStaticAttackGoal(this,
						new CyberdemonEntity.FireballAttack(this).setProjectileOriginOffset(0.8, 0.8, 0.8).setDamage(18),
						60, 20, 30F));
		this.goalSelector.addGoal(4, new DemonAttackGoal(this, 1.0D, false));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setCallsForHelp());
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, true));
		this.targetSelector.addGoal(1, new HurtByAggressorGoal(this));
		this.targetSelector.addGoal(2, new TargetAggressorGoal(this));
	}

	public class FireballAttack extends AbstractRangedAttack {

		public FireballAttack(DemonEntity parentEntity, double xOffSetModifier, double entityHeightFraction,
				double zOffSetModifier, float damage) {
			super(parentEntity, xOffSetModifier, entityHeightFraction, zOffSetModifier, damage);
		}

		public FireballAttack(DemonEntity parentEntity) {
			super(parentEntity);
		}

		@Override
		public AttackSound getDefaultAttackSound() {
			return new AttackSound(SoundEvents.ENTITY_FIREWORK_ROCKET_BLAST, 1, 1);
		}

		@Override
		public Entity getProjectile(World world, double d2, double d3, double d4) {
			return new BarenBlastEntity(world, this.parentEntity, d2, d3, d4);

		}
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double) 0.23F);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0F);
	}

	@Override
	public void notifyDataManagerChange(DataParameter<?> key) {
		super.notifyDataManagerChange(key);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	public void livingTick() {
		super.livingTick();
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
	}

	@Override
	public void setItemStackToSlot(EquipmentSlotType slotIn, ItemStack stack) {
		super.setItemStackToSlot(slotIn, stack);
		if (!this.world.isRemote) {
		}
	}

	@Override
	protected int getExperiencePoints(PlayerEntity player) {
		return super.getExperiencePoints(player);
	}

	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 4.70F;
	}

	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		float f = difficultyIn.getClampedAdditionalDifficulty();
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		if (spawnDataIn == null) {
			spawnDataIn = new CyberdemonEntity.GroupData(worldIn.getRandom()
					.nextFloat() < net.minecraftforge.common.ForgeConfig.SERVER.zombieBabyChance.get());
		}

		this.setEnchantmentBasedOnDifficulty(difficultyIn);

		if (this.getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty()) {
			LocalDate localdate = LocalDate.now();
			int i = localdate.get(ChronoField.DAY_OF_MONTH);
			int j = localdate.get(ChronoField.MONTH_OF_YEAR);
			if (j == 10 && i == 31 && this.rand.nextFloat() < 0.25F) {
				this.setItemStackToSlot(EquipmentSlotType.HEAD,
						new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
				this.inventoryArmorDropChances[EquipmentSlotType.HEAD.getIndex()] = 0.0F;
			}
		}
		return spawnDataIn;
	}

	public class GroupData implements ILivingEntityData {
		public final boolean isChild;

		private GroupData(boolean isChildIn) {
			this.isChild = isChildIn;
		}
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
	protected SoundEvent getAmbientSound() {
		return ModSoundEvents.CYBERDEMON_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.CYBERDEMON_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.CYBERDEMON_DEATH.get();
	}

	protected SoundEvent getStepSound() {
		return ModSoundEvents.CYBERDEMON_STEP.get();
	}

	@Override
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(this.getStepSound(), 0.15F, 1.0F);
	}

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEAD;
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

}