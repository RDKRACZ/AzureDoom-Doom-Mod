package mod.azure.doom.entity.projectiles.entity;

import mod.azure.doom.util.registry.ModEntityTypes;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class RocketMobEntity extends DamagingProjectileEntity implements IAnimatable {

	public int explosionPower = 1;
	protected int timeInAir;
	protected boolean inAir;
	private int ticksInAir;
	private float directHitDamage = 0F;
	private LivingEntity shooter;

	public RocketMobEntity(EntityType<? extends RocketMobEntity> p_i50160_1_, World p_i50160_2_) {
		super(p_i50160_1_, p_i50160_2_);
	}

	public RocketMobEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
		super(ModEntityTypes.ROCKET_MOB.get(), shooter, accelX, accelY, accelZ, worldIn);
		this.shooter = shooter;
	}

//	public RocketMobEntity(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
//		super(ModEntityTypes.ROCKET_MOB.get(), x, y, z, accelX, accelY, accelZ, worldIn);
//	}
	
	public void setDirectHitDamage(float directHitDamage) {
		this.directHitDamage = directHitDamage;
	}

	private AnimationFactory factory = new AnimationFactory(this);

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<RocketMobEntity>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	@Override
	public void shoot(double x, double y, double z, float velocity, float inaccuracy) {
		super.shoot(x, y, z, velocity, inaccuracy);
		this.ticksInAir = 0;
	}

	@Override
	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putShort("life", (short) this.ticksInAir);
	}

	@Override
	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.ticksInAir = compound.getShort("life");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void tick() {
		Entity entity = this.func_234616_v_();
		if (this.world.isRemote
				|| (entity == null || entity.isAlive()) && this.world.isBlockLoaded(this.getPosition())) {
			super.tick();
			RayTraceResult raytraceresult = ProjectileHelper.func_234618_a_(this, this::func_230298_a_);
			if (raytraceresult.getType() != RayTraceResult.Type.MISS
					&& !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
				this.onImpact(raytraceresult);
			}
			this.doBlockCollisions();
			Vector3d vector3d = this.getMotion();
			double d0 = this.getPosX() + vector3d.x;
			double d1 = this.getPosY() + vector3d.y;
			double d2 = this.getPosZ() + vector3d.z;
			ProjectileHelper.rotateTowardsMovement(this, 0.2F);
			float f = this.getMotionFactor();
			if (this.isInWater()) {
				for (int i = 0; i < 4; ++i) {
					this.world.addParticle(ParticleTypes.BUBBLE, d0 - vector3d.x * 0.25D, d1 - vector3d.y * 0.25D,
							d2 - vector3d.z * 0.25D, vector3d.x, vector3d.y, vector3d.z);
				}
				f = 0.8F;
			}
			this.setMotion(vector3d.add(this.accelerationX, this.accelerationY, this.accelerationZ).scale((double) f));
			this.world.addParticle(this.getParticle(), d0, d1 + 0.5D, d2, 0.0D, 0.0D, 0.0D);
			this.setPosition(d0, d1, d2);
		} else {
			this.remove();
		}
	}

	protected boolean isFireballFiery() {
		return false;
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public boolean hasNoGravity() {
		if (this.isInWater()) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isPushedByWater() {
		return false;
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
		super.onEntityHit(p_213868_1_);
		if (!this.world.isRemote) {
			Entity entityHit = p_213868_1_.getEntity();
			if (entityHit instanceof LivingEntity && directHitDamage > 0)
				p_213868_1_.getEntity().attackEntityFrom(DamageSource.causeExplosionDamage(shooter),
						directHitDamage);
			this.explode();
			this.remove();
		}
		this.playSound(ModSoundEvents.ROCKET_HIT.get(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	}

	protected void onImpact(RayTraceResult result) {
		super.onImpact(result);
		if (!this.world.isRemote) {
			this.explode();
			this.remove();
		}
		this.playSound(ModSoundEvents.ROCKET_HIT.get(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	}

	protected void explode() {
		this.world.createExplosion(this, this.getPosX(), this.getPosYHeight(0.0625D), this.getPosZ(), 2.0F,
				Explosion.Mode.NONE);
	}

}