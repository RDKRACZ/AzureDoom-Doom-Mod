package mod.azure.doomweapon.entity.projectiles.entity;

import mod.azure.doomweapon.util.registry.ModEntityTypes;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BulletMobEntity extends DamagingProjectileEntity {

	protected int timeInAir;
	protected boolean inAir;
	private int ticksInAir;

	public BulletMobEntity(EntityType<? extends BulletMobEntity> p_i50160_1_, World p_i50160_2_) {
		super(p_i50160_1_, p_i50160_2_);
	}

	public BulletMobEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
		super(ModEntityTypes.BULLETS_MOB.get(), shooter, accelX, accelY, accelZ, worldIn);
	}

	public BulletMobEntity(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
		super(ModEntityTypes.BULLETS_MOB.get(), x, y, z, accelX, accelY, accelZ, worldIn);
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
		if (this.world.isRemote || (this.shootingEntity == null || this.shootingEntity.isAlive())
				&& this.world.isBlockLoaded(new BlockPos(this))) {
			super.tick();
			++this.ticksInAir;
			RayTraceResult raytraceresult = ProjectileHelper.rayTrace(this, true, this.ticksInAir >= 25,
					this.shootingEntity, RayTraceContext.BlockMode.COLLIDER);
			if (raytraceresult.getType() != RayTraceResult.Type.MISS
					&& !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
				this.onImpact(raytraceresult);
			}

			Vec3d vec3d = this.getMotion();
			double d0 = this.getPosX() + vec3d.x;
			double d1 = this.getPosY() + vec3d.y;
			double d2 = this.getPosZ() + vec3d.z;
			ProjectileHelper.rotateTowardsMovement(this, 0.2F);
			float f = this.getMotionFactor();
			if (this.isInWater()) {
				for (int i = 0; i < 4; ++i) {
					this.world.addParticle(ParticleTypes.BUBBLE, d0 - vec3d.x * 0.25D, d1 - vec3d.y * 0.25D,
							d2 - vec3d.z * 0.25D, vec3d.x, vec3d.y, vec3d.z);
				}
				f = 0.8F;
			}

			this.setMotion(vec3d.add(this.accelerationX, this.accelerationY, this.accelerationZ).scale((double) f));
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
	protected void onImpact(RayTraceResult result) {
		super.onImpact(result);
		if (!this.world.isRemote) {
			this.explode();
			this.remove();
		}
		this.playSound(ModSoundEvents.SHOOT1.get(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	}

	protected void explode() {
		this.world.createExplosion(this, this.getPosX(), this.getPosYHeight(0.0625D), this.getPosZ(), 0.1F,
				Explosion.Mode.NONE);
	}

}