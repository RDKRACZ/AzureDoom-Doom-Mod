package mod.azure.doom.entity;

import java.util.Random;

import javax.annotation.Nullable;

import mod.azure.doom.util.registry.ModEntityTypes;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
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

public class GoreNestEntity extends DemonEntity implements IAnimatable {

	private final GoreNestEntity parentEntity;

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
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<GoreNestEntity>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	public GoreNestEntity(EntityType<? extends GoreNestEntity> entityType, World worldIn) {
		super(entityType, worldIn);
		this.parentEntity = GoreNestEntity.this;
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
			for (int i = 0; i < 20; ++i) {
				if (world.isRemote) {
				}
			}
			HellknightEntity fireballentity = ModEntityTypes.HELLKNIGHT.get().create(world);
			fireballentity.setPosition(this.parentEntity.getPosX() + 2.0D, this.parentEntity.getPosY() + 0.5D,
					this.parentEntity.getPosZ() + 2.0D);
			world.addEntity(fireballentity);

			PossessedScientistEntity fireballentity1 = ModEntityTypes.POSSESSEDSCIENTIST.get().create(world);
			fireballentity1.setPosition(this.parentEntity.getPosX() + -2.0D, this.parentEntity.getPosY() + 0.5D,
					this.parentEntity.getPosZ() + -2.0D);
			world.addEntity(fireballentity1);

			ImpEntity fireballentity11 = ModEntityTypes.IMP.get().create(world);
			fireballentity11.setPosition(this.parentEntity.getPosX() + 1.0D, this.parentEntity.getPosY() + 0.5D,
					this.parentEntity.getPosZ() + 1.0D);
			world.addEntity(fireballentity11);

			NightmareImpEntity fireballentity111 = ModEntityTypes.NIGHTMARE_IMP.get().create(world);
			fireballentity111.setPosition(this.parentEntity.getPosX() + -1.0D, this.parentEntity.getPosY() + 0.5D,
					this.parentEntity.getPosZ() + -1.0D);
			world.addEntity(fireballentity111);
		}

	}

	public static AttributeModifierMap.MutableAttribute func_234200_m_() {
		return MobEntity.func_233666_p_().createMutableAttribute(Attributes.FOLLOW_RANGE, 50.0D)
				.createMutableAttribute(Attributes.MAX_HEALTH, 5.0D)
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.0D)
				.createMutableAttribute(Attributes.ATTACK_DAMAGE, 15.0D);
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
		if (this.world.isRemote) {
			this.world.addParticle(RedstoneParticleData.REDSTONE_DUST, this.getPosXRandom(0.5D), this.getPosYRandom(),
					this.getPosZRandom(0.5D), (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(),
					(this.rand.nextDouble() - 0.5D) * 2.0D);
			this.world.addParticle(ParticleTypes.SOUL, this.getPosXRandom(0.2D), this.getPosYRandom(),
					this.getPosZRandom(0.5D), 0.0D, 0D, 0D);
		}
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
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason,
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