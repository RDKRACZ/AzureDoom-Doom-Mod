package mod.azure.doom.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import mod.azure.doom.util.registry.ModEntityTypes;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
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

public class GoreNestEntity extends DemonEntity implements IAnimatable {

	public GoreNestEntity(EntityType<? extends GoreNestEntity> entityType, World worldIn) {
		super(entityType, worldIn);
	}

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (this.dead) {
			if (world.isRemote) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("death", false));
				return PlayState.CONTINUE;
			}
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
		return PlayState.CONTINUE;
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	protected void collideWithNearbyEntities() {
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(entityIn, 0, 0, 0);
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<GoreNestEntity>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	protected void registerData() {
		super.registerData();
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	public static boolean spawning(EntityType<GoreNestEntity> p_223337_0_, IWorld p_223337_1_, SpawnReason reason,
			BlockPos p_223337_3_, Random p_223337_4_) {
		return p_223337_1_.getDifficulty() != Difficulty.PEACEFUL;
	}

	@Override
	protected void onDeathUpdate() {
		++this.deathTime;
		if (this.deathTime == 80) {
			this.remove();
		}

	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
		this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
		this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
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
	protected void damageEntity(DamageSource damageSrc, float damageAmount) {
		if (!(damageSrc.getTrueSource() instanceof PlayerEntity)) {
			this.setHealth(5.0F);
		} else {
			this.remove();
		}
	}

	@Override
	public void livingTick() {
		if (this.world.isRemote) {
			this.world.addParticle(RedstoneParticleData.REDSTONE_DUST, this.getPosXRandom(0.5D), this.getPosYRandom(),
					this.getPosZRandom(0.5D), (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(),
					(this.rand.nextDouble() - 0.5D) * 2.0D);
			this.world.addParticle(ParticleTypes.ENCHANT, this.getPosXRandom(0.2D), this.getPosYRandom(),
					this.getPosZRandom(0.5D), 0.0D, 0D, 0D);
		}
		++this.ticksExisted;
		if (!world.isRemote) {
			if (this.ticksExisted % 800 == 0) {
				this.spawnWave();
			}
		}
		super.livingTick();
	}

	public void spawnWave() {
		Random rand = new Random();
		List<EntityType<?>> givenList = Arrays.asList(ModEntityTypes.HELLKNIGHT.get(),
				ModEntityTypes.POSSESSEDSCIENTIST.get(), ModEntityTypes.IMP.get(), ModEntityTypes.NIGHTMARE_IMP.get(),
				ModEntityTypes.PINKY.get(), ModEntityTypes.CACODEMON.get(), ModEntityTypes.CHAINGUNNER.get(),
				ModEntityTypes.GARGOYLE.get(), ModEntityTypes.HELLKNIGHT2016.get(), ModEntityTypes.IMP2016.get(),
				ModEntityTypes.LOST_SOUL.get(), ModEntityTypes.POSSESSEDSOLDIER.get(), ModEntityTypes.SHOTGUNGUY.get(),
				ModEntityTypes.UNWILLING.get(), ModEntityTypes.ZOMBIEMAN.get(), ModEntityTypes.ARACHNOTRON.get(),
				ModEntityTypes.ARCHVILE.get(), ModEntityTypes.MECHAZOMBIE.get(), ModEntityTypes.PAIN.get(),
				ModEntityTypes.MANCUBUS.get());

		for (int i = 0; i < 1; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			EntityType<?> randomElement = givenList.get(randomIndex);
			Entity fireballentity = randomElement.create(world);
			fireballentity.setPosition(this.getPosX() + 2.0D, this.getPosY() + 0.5D, this.getPosZ() + 2.0D);
			world.addEntity(fireballentity);
		}
		for (int i = 0; i < 1; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			EntityType<?> randomElement = givenList.get(randomIndex);
			Entity fireballentity1 = randomElement.create(world);
			fireballentity1.setPosition(this.getPosX() + -2.0D, this.getPosY() + 0.5D, this.getPosZ() + -2.0D);
			world.addEntity(fireballentity1);
		}
		for (int i = 0; i < 1; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			EntityType<?> randomElement = givenList.get(randomIndex);
			Entity fireballentity11 = randomElement.create(world);
			fireballentity11.setPosition(this.getPosX() + 1.0D, this.getPosY() + 0.5D, this.getPosZ() + 1.0D);
			world.addEntity(fireballentity11);
		}
		for (int i = 0; i < 1; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			EntityType<?> randomElement = givenList.get(randomIndex);
			Entity fireballentity111 = randomElement.create(world);
			fireballentity111.setPosition(this.getPosX() + -1.0D, this.getPosY() + 0.5D, this.getPosZ() + -1.0D);
			world.addEntity(fireballentity111);
		}
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
	}

	@Nullable
	@Override
	public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
			@Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		spawnDataIn = super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
		float f = difficultyIn.getClampedAdditionalDifficulty();
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		this.setEnchantmentBasedOnDifficulty(difficultyIn);
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

	@Override
	public CreatureAttribute getCreatureAttribute() {
		return CreatureAttribute.UNDEAD;
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}
}