package mod.azure.doomweapon.entity;

import java.util.Random;

import javax.annotation.Nullable;

import mod.azure.doomweapon.util.registry.ModEntityTypes;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib.animation.builder.AnimationBuilder;
import software.bernie.geckolib.animation.controller.EntityAnimationController;
import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.event.AnimationTestEvent;
import software.bernie.geckolib.manager.EntityAnimationManager;

public class GoreNestEntity extends DemonEntity implements IAnimatedEntity {

	private final GoreNestEntity parentEntity;

	EntityAnimationManager manager = new EntityAnimationManager();
	EntityAnimationController<GoreNestEntity> controller = new EntityAnimationController<GoreNestEntity>(this,
			"walkController", 0.09F, this::animationPredicate);

	public GoreNestEntity(EntityType<? extends GoreNestEntity> entityType, World worldIn) {
		super(entityType, worldIn);
		manager.addAnimationController(controller);
		this.parentEntity = GoreNestEntity.this;
	}

	private <E extends Entity> boolean animationPredicate(AnimationTestEvent<E> event) {
		controller.setAnimation(new AnimationBuilder().addAnimation("idle", true));
		return true;
	}

	@Override
	protected void registerData() {
		super.registerData();
	}

	@Override
	public EntityAnimationManager getAnimationManager() {
		return manager;
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
		Vec3d vector3d = this.parentEntity.getLook(1.0F);
		if (this.deathTime == 80) {
			this.remove();
			for (int i = 0; i < 20; ++i) {
				controller.setAnimation(new AnimationBuilder().addAnimation("death", false));
			}
			HellknightEntity fireballentity = ModEntityTypes.HELLKNIGHT.get().create(world);
			fireballentity.setPosition(this.parentEntity.getPosX() + vector3d.x * 4.0D,
					this.parentEntity.getPosYHeight(0.5D) + 0.5D, fireballentity.getPosZ() + vector3d.z * 4.0D);
			world.addEntity(fireballentity);

			PossessedScientistEntity fireballentity1 = ModEntityTypes.POSSESSEDSCIENTIST.get().create(world);
			fireballentity1.setPosition(this.parentEntity.getPosX() + vector3d.x * -8.0D,
					this.parentEntity.getPosYHeight(0.5D) + 0.5D, fireballentity1.getPosZ() + vector3d.z * -8.0D);
			world.addEntity(fireballentity1);

			ImpEntity fireballentity11 = ModEntityTypes.IMP.get().create(world);
			fireballentity11.setPosition(this.parentEntity.getPosX() + vector3d.x * 8.0D,
					this.parentEntity.getPosYHeight(0.5D) + 0.5D, fireballentity11.getPosZ() + vector3d.z * 8.0D);
			world.addEntity(fireballentity11);

			NightmareImpEntity fireballentity111 = ModEntityTypes.NIGHTMARE_IMP.get().create(world);
			fireballentity111.setPosition(this.parentEntity.getPosX() + vector3d.x * -4.0D,
					this.parentEntity.getPosYHeight(0.5D) + 0.5D, fireballentity11.getPosZ() + vector3d.z * -4.0D);
			world.addEntity(fireballentity111);
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