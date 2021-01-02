package mod.azure.doom.entity.projectiles.entity;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import mod.azure.doom.entity.ArchvileEntity;
import mod.azure.doom.entity.MancubusEntity;
import mod.azure.doom.util.registry.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class ArchvileFiring extends Entity implements IAnimatable {

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		return PlayState.STOP;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<ArchvileFiring>(this, "controller", 0, this::predicate));
	}

	private int warmupDelayTicks;
	private boolean sentSpikeEvent;
	private int lifeTicks = 22;
	private boolean clientSideAttackStarted;
	private LivingEntity caster;
	private UUID casterUuid;
	private float damage = 2.0F;

	public ArchvileFiring(EntityType<ArchvileFiring> p_i50170_1_, World p_i50170_2_) {
		super(p_i50170_1_, p_i50170_2_);
	}

	public ArchvileFiring(World worldIn, double x, double y, double z, float p_i47276_8_, int p_i47276_9_,
			LivingEntity casterIn) {
		this(ModEntityTypes.FIRING.get(), worldIn);
		this.warmupDelayTicks = p_i47276_9_;
		this.setCaster(casterIn);
		this.rotationYaw = p_i47276_8_ * (180F / (float) Math.PI);
		this.setPosition(x, y, z);
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	protected void registerData() {
	}

	public void setCaster(@Nullable LivingEntity p_190549_1_) {
		this.caster = p_190549_1_;
		this.casterUuid = p_190549_1_ == null ? null : p_190549_1_.getUniqueID();
	}

	@Nullable
	public LivingEntity getCaster() {
		if (this.caster == null && this.casterUuid != null && this.world instanceof ServerWorld) {
			Entity entity = ((ServerWorld) this.world).getEntityByUuid(this.casterUuid);
			if (entity instanceof LivingEntity) {
				this.caster = (LivingEntity) entity;
			}
		}

		return this.caster;
	}

	protected void readAdditional(CompoundNBT compound) {
		this.warmupDelayTicks = compound.getInt("Warmup");
		if (compound.hasUniqueId("Owner")) {
			this.casterUuid = compound.getUniqueId("Owner");
		}

	}

	protected void writeAdditional(CompoundNBT compound) {
		compound.putInt("Warmup", this.warmupDelayTicks);
		if (this.casterUuid != null) {
			compound.putUniqueId("Owner", this.casterUuid);
		}

	}

	public void tick() {
		super.tick();
		if (this.world.isRemote) {
			if (this.clientSideAttackStarted) {
				--this.lifeTicks;
				if (this.lifeTicks == 14) {
					for (int i = 0; i < 12; ++i) {
						double d0 = this.getPosX()
								+ (this.rand.nextDouble() * 2.0D - 1.0D) * (double) this.getWidth() * 0.5D;
						double d1 = this.getPosY() + 0.05D + this.rand.nextDouble();
						double d2 = this.getPosZ()
								+ (this.rand.nextDouble() * 2.0D - 1.0D) * (double) this.getWidth() * 0.5D;
						double d3 = (this.rand.nextDouble() * 2.0D - 1.0D) * 0.3D;
						double d4 = 0.3D + this.rand.nextDouble() * 0.3D;
						double d5 = (this.rand.nextDouble() * 2.0D - 1.0D) * 0.3D;
						this.world.addParticle(ParticleTypes.LAVA, d0, d1 + 1.0D, d2, d3, d4, d5);
					}
				}
			}
		} else if (--this.warmupDelayTicks < 0) {
			if (!this.sentSpikeEvent) {
				this.world.setEntityState(this, (byte) 4);
				this.sentSpikeEvent = true;
			}

			if (--this.lifeTicks < 0) {
				this.remove();
			}
		}
		final Vector3d facing = Vector3d.fromPitchYaw(this.getPitchYaw()).normalize();
		List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this,
				new AxisAlignedBB(this.getPosition().up()).grow(5D, 5D, 5D).offset(facing.scale(1D)));
		for (int k2 = 0; k2 < list.size(); ++k2) {
			Entity entity = list.get(k2);
			if (!(entity instanceof MancubusEntity) && !(entity instanceof ArchvileEntity)) {
				double d12 = (double) (MathHelper.sqrt(entity.getDistance(this)));
				if (d12 <= 1.0D) {
					if (entity.isAlive()) {
						entity.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this, this), damage);
					}
				}
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		super.handleStatusUpdate(id);
		if (id == 4) {
			this.clientSideAttackStarted = true;
		}

	}

	@OnlyIn(Dist.CLIENT)
	public float getAnimationProgress(float partialTicks) {
		if (!this.clientSideAttackStarted) {
			return 0.0F;
		} else {
			int i = this.lifeTicks - 2;
			return i <= 0 ? 1.0F : 1.0F - ((float) i - partialTicks) / 20.0F;
		}
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

}