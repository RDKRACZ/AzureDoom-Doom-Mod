package mod.azure.doom.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Random;

import javax.annotation.Nullable;

import mod.azure.doom.entity.ai.goal.DemonAttackGoal;
import mod.azure.doom.util.config.Config;
import mod.azure.doom.util.config.EntityConfig;
import mod.azure.doom.util.config.EntityDefaults.EntityConfigType;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class PossessedScientistEntity extends DemonEntity implements IAnimatable {

	public PossessedScientistEntity(EntityType<PossessedScientistEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	public static EntityConfig config = Config.SERVER.entityConfig.get(EntityConfigType.POSSESSED_SCIENTIST);

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (!(limbSwingAmount > -0.10F && limbSwingAmount < 0.10F) && !this.isAggressive()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
			return PlayState.CONTINUE;
		}
		if ((this.dead || this.getHealth() < 0.01 || this.getShouldBeDead())) {
			if (world.isRemote) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("death", false));
				return PlayState.CONTINUE;
			}
		}
		if (this.isAggressive()) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("attack", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(
				new AnimationController<PossessedScientistEntity>(this, "controller", 0, this::predicate));
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

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public static boolean spawning(EntityType<PossessedScientistEntity> p_223337_0_, IWorld p_223337_1_,
			SpawnReason reason, BlockPos p_223337_3_, Random p_223337_4_) {
		return passPeacefulAndYCheck(config, p_223337_1_, reason, p_223337_3_, p_223337_4_);
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.applyEntityAI();
	}

	protected void applyEntityAI() {
		this.goalSelector.addGoal(2, new DemonAttackGoal(this, 1.0D, false));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
		this.targetSelector.addGoal(1, (new HurtByTargetGoal(this).setCallsForHelp()));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
	}

	public static AttributeModifierMap.MutableAttribute func_234200_m_() {
		return config.pushAttributes(MobEntity.func_233666_p_().createMutableAttribute(Attributes.FOLLOW_RANGE, 25.0D));
	}

	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		float f = difficultyIn.getClampedAdditionalDifficulty();
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		if (spawnDataIn == null) {
			spawnDataIn = new PossessedScientistEntity.GroupData(worldIn.getRandom()
					.nextFloat() < net.minecraftforge.common.ForgeConfig.SERVER.zombieBabyChance.get());
		}

		if (spawnDataIn instanceof ZombieEntity.GroupData) {
			ZombieEntity.GroupData zombieentity$groupdata = (ZombieEntity.GroupData) spawnDataIn;
			if (zombieentity$groupdata.isChild) {
				this.setChild(true);
			}

			this.setEquipmentBasedOnDifficulty(difficultyIn);
			this.setEnchantmentBasedOnDifficulty(difficultyIn);
		}

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
		return ModSoundEvents.ZOMBIEMAN_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.ZOMBIEMAN_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.ZOMBIEMAN_DEATH.get();
	}

	protected SoundEvent getStepSound() {
		return SoundEvents.ENTITY_ZOMBIE_STEP;
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
		return 7;
	}

}