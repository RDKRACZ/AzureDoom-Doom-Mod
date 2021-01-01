package mod.azure.doom.entity.projectiles.entity;

import java.util.List;

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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class ChaingunMobEntity extends DamagingProjectileEntity {

	protected int timeInAir;
	protected boolean inAir;
	private int ticksInAir;

	public ChaingunMobEntity(EntityType<? extends ChaingunMobEntity> p_i50160_1_, World p_i50160_2_) {
		super(p_i50160_1_, p_i50160_2_);
	}

	public ChaingunMobEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
		super(ModEntityTypes.CHAINGUN_MOB.get(), shooter, accelX, accelY, accelZ, worldIn);
	}

	public ChaingunMobEntity(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
		super(ModEntityTypes.CHAINGUN_MOB.get(), x, y, z, accelX, accelY, accelZ, worldIn);
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

	private float directHitDamage = 3;

	public void setDirectHitDamage(float directHitDamage) {
		this.directHitDamage = directHitDamage;
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
			this.doDamage();
			this.remove();
		}
		this.playSound(ModSoundEvents.CHAINGUN_SHOOT.get(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	}

	public void doDamage() {
		float f2 = 24.0F;
		int k1 = MathHelper.floor(this.getPosX() - (double) f2 - 1.0D);
		int l1 = MathHelper.floor(this.getPosX() + (double) f2 + 1.0D);
		int i2 = MathHelper.floor(this.getPosY() - (double) f2 - 1.0D);
		int i1 = MathHelper.floor(this.getPosY() + (double) f2 + 1.0D);
		int j2 = MathHelper.floor(this.getPosZ() - (double) f2 - 1.0D);
		int j1 = MathHelper.floor(this.getPosZ() + (double) f2 + 1.0D);
		List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this,
				new AxisAlignedBB((double) k1, (double) i2, (double) j2, (double) l1, (double) i1, (double) j1));
		Vector3d vector3d = new Vector3d(this.getPosX(), this.getPosY(), this.getPosZ());
		for (int k2 = 0; k2 < list.size(); ++k2) {
			Entity entity = list.get(k2);
			double d12 = (double) (MathHelper.sqrt(entity.getDistanceSq(vector3d)) / f2);
			if (d12 <= 1.0D) {
				entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this), directHitDamage);
			}
		}
	}
}