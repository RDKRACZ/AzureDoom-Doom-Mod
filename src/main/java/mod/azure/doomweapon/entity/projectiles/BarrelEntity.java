package mod.azure.doomweapon.entity.projectiles;

import javax.annotation.Nullable;

import mod.azure.doomweapon.util.registry.ModEntityTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BarrelEntity extends Entity {

	@Nullable
	private LivingEntity tntPlacedBy;

	public BarrelEntity(EntityType<?> entityTypeIn, World worldIn) {
		super(entityTypeIn, worldIn);
		this.preventEntitySpawning = true;
	}

	protected void explode() {
		this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 2.0F, true,
				Explosion.Mode.NONE);
	}

	public BarrelEntity(World worldIn, double x, double y, double z, @Nullable LivingEntity igniter) {
		this(ModEntityTypes.BARREL.get(), worldIn);
		this.setPosition(x, y, z);
		double d0 = worldIn.rand.nextDouble() * (double) ((float) Math.PI * 2F);
		this.setMotion(-Math.sin(d0) * 0.02D, (double) 0.2F, -Math.cos(d0) * 0.02D);
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
		this.tntPlacedBy = igniter;
	}

	@Nullable
	public LivingEntity getTntPlacedBy() {
		return this.tntPlacedBy;
	}

	@Override
	protected void registerData() {
	}

	@Override
	public void tick() {
		if (!this.hasNoGravity()) {
			this.setMotion(this.getMotion().add(0.0D, -0.04D, 0.0D));
		}

		this.move(MoverType.SELF, this.getMotion());
		this.setMotion(this.getMotion().scale(0.98D));
		if (this.onGround) {
			this.setMotion(this.getMotion().mul(0.7D, -0.5D, 0.7D));
		}

		this.remove();
		if (!this.world.isRemote) {
			this.explode();
		}
	}

	@Override
	protected void readAdditional(CompoundNBT compound) {
	}

	@Override
	protected void writeAdditional(CompoundNBT compound) {
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

}