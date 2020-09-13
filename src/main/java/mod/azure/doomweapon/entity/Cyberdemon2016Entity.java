package mod.azure.doomweapon.entity;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Random;

import javax.annotation.Nullable;

import mod.azure.doomweapon.entity.ai.goal.RangedCyberdemonAttackGoal;
import mod.azure.doomweapon.entity.projectiles.RocketEntity;
import mod.azure.doomweapon.item.ammo.Rocket;
import mod.azure.doomweapon.item.entityweapons.CyberdemonAttackItem;
import mod.azure.doomweapon.util.Config;
import mod.azure.doomweapon.util.registry.DoomItems;
import mod.azure.doomweapon.util.registry.ModEntityTypes;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class Cyberdemon2016Entity extends DemonEntity implements IRangedAttackMob {

	private final RangedCyberdemonAttackGoal<Cyberdemon2016Entity> aiArrowAttack = new RangedCyberdemonAttackGoal<>(
			this, 1.0D, 20, 15.0F);
	private final MeleeAttackGoal aiAttackOnCollide = new MeleeAttackGoal(this, 1.2D, false) {
		public void resetTask() {
			super.resetTask();
			Cyberdemon2016Entity.this.setAggroed(false);
		}

		public void startExecuting() {
			super.startExecuting();
			Cyberdemon2016Entity.this.setAggroed(true);
		}
	};

	public Cyberdemon2016Entity(EntityType<Cyberdemon2016Entity> entityType, World worldIn) {
		super(entityType, worldIn);
		this.setCombatTask();
	}

	public Cyberdemon2016Entity(World worldIn) {
		this(ModEntityTypes.CYBERDEMON2016.get(), worldIn);
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public static boolean spawning(EntityType<Cyberdemon2016Entity> p_223337_0_, IWorld p_223337_1_, SpawnReason reason,
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
		if (Config.SERVER.IN_FIGHTING.get()) {
			this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, CyberdemonEntity.class, true));
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
	protected void registerData() {
		super.registerData();
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
		this.setCombatTask();
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

	@Override
	protected int getExperiencePoints(PlayerEntity player) {
		return super.getExperiencePoints(player);
	}

	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		return 4.70F;
	}

	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(DoomItems.CYBERDEMONATTACK.get()));
	}

	public void setCombatTask() {
		if (this.world != null && !this.world.isRemote) {
			this.goalSelector.removeGoal(this.aiAttackOnCollide);
			this.goalSelector.removeGoal(this.aiArrowAttack);
			ItemStack itemstack = this
					.getHeldItem(ProjectileHelper.getHandWith(this, DoomItems.CYBERDEMONATTACK.get()));
			if (itemstack.getItem() instanceof CyberdemonAttackItem) {
				int i = 20;
				if (this.world.getDifficulty() != Difficulty.HARD) {
					i = 40;
				}

				this.aiArrowAttack.setAttackCooldown(i);
				this.goalSelector.addGoal(4, this.aiArrowAttack);
			} else {
				this.goalSelector.addGoal(4, this.aiAttackOnCollide);
			}

		}
	}

	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		float f = difficultyIn.getClampedAdditionalDifficulty();
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		if (spawnDataIn == null) {
			spawnDataIn = new Cyberdemon2016Entity.GroupData(worldIn.getRandom()
					.nextFloat() < net.minecraftforge.common.ForgeConfig.SERVER.zombieBabyChance.get());
		}

		this.setEquipmentBasedOnDifficulty(difficultyIn);
		this.setEnchantmentBasedOnDifficulty(difficultyIn);
		this.setCombatTask();

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

	@Override
	public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
		ItemStack itemstack = this
				.findAmmo(this.getHeldItem(ProjectileHelper.getHandWith(this, DoomItems.CYBERDEMONATTACK.get())));
		RocketEntity abstractarrowentity = this.fireArrowa(itemstack, distanceFactor);
		if (this.getHeldItemMainhand().getItem() instanceof CyberdemonAttackItem)
			abstractarrowentity = ((CyberdemonAttackItem) this.getHeldItemMainhand().getItem())
					.customeArrow(abstractarrowentity);
		double d0 = target.getPosX() - this.getPosX();
		double d1 = target.getPosYHeight(0.3333333333333333D) - abstractarrowentity.getPosY();
		double d2 = target.getPosZ() - this.getPosZ();
		double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
		abstractarrowentity.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F,
				(float) (14 - this.world.getDifficulty().getId() * 4));
		this.playSound(ModSoundEvents.ROCKET_HIT.get(), 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.world.addEntity(abstractarrowentity);
	}

	protected RocketEntity fireArrowa(ItemStack arrowStack, float distanceFactor) {
		return Cyberdemon2016Entity.fireArrow(this, arrowStack, distanceFactor);
	}

	public static RocketEntity fireArrow(LivingEntity shooter, ItemStack arrowStack, float distanceFactor) {
		Rocket arrowitem = (Rocket) (arrowStack.getItem() instanceof Rocket ? arrowStack.getItem()
				: DoomItems.ROCKET.get());
		RocketEntity abstractarrowentity = arrowitem.createArrow(shooter.world, arrowStack, shooter);
		abstractarrowentity.setEnchantmentEffectsFromEntity(shooter, distanceFactor);

		return abstractarrowentity;
	}
}