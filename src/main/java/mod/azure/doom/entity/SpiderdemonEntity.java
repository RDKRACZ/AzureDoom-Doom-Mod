package mod.azure.doom.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Random;

import javax.annotation.Nullable;

import mod.azure.doom.entity.ai.goal.RangedSpiderDemonAttackGoal;
import mod.azure.doom.entity.projectiles.ChaingunBulletEntity;
import mod.azure.doom.item.SpiderdemonAttackItem;
import mod.azure.doom.item.ammo.ChaingunAmmo;
import mod.azure.doom.item.weapons.Shotgun;
import mod.azure.doom.util.Config;
import mod.azure.doom.util.registry.DoomItems;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class SpiderdemonEntity extends DemonEntity implements IRangedAttackMob, IAnimatedEntity {

	EntityAnimationManager manager = new EntityAnimationManager();
	EntityAnimationController<SpiderdemonEntity> controller = new EntityAnimationController<SpiderdemonEntity>(this,
			"walkController", 0.09F, this::animationPredicate);

	private final RangedSpiderDemonAttackGoal<SpiderdemonEntity> aiArrowAttack = new RangedSpiderDemonAttackGoal<>(this,
			1.0D, 20, 15.0F);
	private final MeleeAttackGoal aiAttackOnCollide = new MeleeAttackGoal(this, 1.2D, false) {
		public void resetTask() {
			super.resetTask();
			SpiderdemonEntity.this.setAggroed(false);
		}

		public void startExecuting() {
			super.startExecuting();
			SpiderdemonEntity.this.setAggroed(true);
		}
	};

	public SpiderdemonEntity(EntityType<SpiderdemonEntity> entityType, World worldIn) {
		super(entityType, worldIn);
		this.setCombatTask();
		manager.addAnimationController(controller);
	}

	private <E extends Entity> boolean animationPredicate(AnimationTestEvent<E> event) {
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)) {
			controller.setAnimation(new AnimationBuilder().addAnimation("walking", true));
			return true;
		} 
		return false;
	}

	@Override
	public EntityAnimationManager getAnimationManager() {
		return manager;
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public static boolean spawning(EntityType<SpiderdemonEntity> p_223337_0_, IWorld p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		return p_223337_1_.getDifficulty() != Difficulty.PEACEFUL;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
		this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 0.8D));
		this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillagerEntity.class, false));
		if (Config.SERVER.IN_FIGHTING.get()) {
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MonsterEntity.class, true));
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, MobEntity.class, true));
		}
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
	}

	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(DoomItems.SPIDERDEMONATTACK.get()));
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setCombatTask();
	}

	@Override
	public void setItemStackToSlot(EquipmentSlotType slotIn, ItemStack stack) {
		super.setItemStackToSlot(slotIn, stack);
		if (!this.world.isRemote) {
			this.setCombatTask();
		}
	}

	public void setCombatTask() {
		if (this.world != null && !this.world.isRemote) {
			this.goalSelector.removeGoal(this.aiAttackOnCollide);
			this.goalSelector.removeGoal(this.aiArrowAttack);
			ItemStack itemstack = this
					.getHeldItem(ProjectileHelper.getHandWith(this, DoomItems.SPIDERDEMONATTACK.get()));
			if (itemstack.getItem() instanceof Shotgun) {
				int i = 20;
				if (this.world.getDifficulty() != Difficulty.HARD) {
					i = 20;
				}
				this.aiArrowAttack.setAttackCooldown(i);
				this.goalSelector.addGoal(4, this.aiArrowAttack);
			} else {
				this.goalSelector.addGoal(4, this.aiAttackOnCollide);
			}
		}
	}

	@Override
	public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
		ItemStack itemstack = this
				.findAmmo(this.getHeldItem(ProjectileHelper.getHandWith(this, DoomItems.SPIDERDEMONATTACK.get())));
		ChaingunBulletEntity abstractarrowentity = this.fireArrowa(itemstack, distanceFactor);
		if (this.getHeldItemMainhand().getItem() instanceof SpiderdemonAttackItem)
			abstractarrowentity = ((SpiderdemonAttackItem) this.getHeldItemMainhand().getItem())
					.customeArrow(abstractarrowentity);
		double d0 = target.getPosX() - this.getPosX();
		double d1 = target.getPosYHeight(0.3333333333333333D) - abstractarrowentity.getPosY();
		double d2 = target.getPosZ() - this.getPosZ();
		double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
		abstractarrowentity.shoot(d0, d1 + d3 * (double) 0.05F, d2, 1.6F, 0.0F);
		this.playSound(ModSoundEvents.CHAINGUN_SHOOT.get(), 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.world.addEntity(abstractarrowentity);
	}

	protected ChaingunBulletEntity fireArrowa(ItemStack arrowStack, float distanceFactor) {
		return SpiderdemonEntity.fireArrow(this, arrowStack, distanceFactor);
	}

	public static ChaingunBulletEntity fireArrow(LivingEntity shooter, ItemStack arrowStack, float distanceFactor) {
		ChaingunAmmo arrowitem = (ChaingunAmmo) (arrowStack.getItem() instanceof ChaingunAmmo ? arrowStack.getItem()
				: DoomItems.CHAINGUN_BULLETS.get());
		ChaingunBulletEntity abstractarrowentity = arrowitem.createArrow(shooter.world, arrowStack, shooter);
		abstractarrowentity.setEnchantmentEffectsFromEntity(shooter, distanceFactor);

		return abstractarrowentity;
	}

	public static AttributeModifierMap.MutableAttribute func_234200_m_() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.FOLLOW_RANGE, 50.0D)
				.createMutableAttribute(Attributes.MAX_HEALTH, 300.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 8.0D);
	}

	@Override
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 1.74F;
	}

	@Override
	protected int getExperiencePoints(PlayerEntity player) {
		return super.getExperiencePoints(player);
	}

	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		this.setEnchantmentBasedOnDifficulty(difficultyIn);
		this.setCombatTask();
		float f = difficultyIn.getClampedAdditionalDifficulty();
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		if (spawnDataIn == null) {
			spawnDataIn = new SpiderdemonEntity.GroupData(worldIn.getRandom()
					.nextFloat() < net.minecraftforge.common.ForgeConfig.SERVER.zombieBabyChance.get());
		}

		if (spawnDataIn instanceof ZombieEntity.GroupData) {
			ZombieEntity.GroupData zombieentity$groupdata = (ZombieEntity.GroupData) spawnDataIn;
			if (zombieentity$groupdata.isChild) {
				this.setChild(true);
			}
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
		return ModSoundEvents.SPIDERDEMON_AMBIENT.get();
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ModSoundEvents.SPIDERDEMON_HURT.get();
	}

	@Override
	protected SoundEvent getDeathSound() {
		return ModSoundEvents.SPIDERDEMON_DEATH.get();
	}

	protected SoundEvent getStepSound() {
		return ModSoundEvents.SPIDERDEMON_AMBIENT.get();
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
		return 2;
	}

}