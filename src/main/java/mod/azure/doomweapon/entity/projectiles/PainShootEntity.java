package mod.azure.doomweapon.entity.projectiles;

import mod.azure.doomweapon.util.registry.ModEntityTypes;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.DamagingProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class PainShootEntity extends DamagingProjectileEntity {

	private final Item referenceItem;
	public int explosionPower = 1;
	protected int timeInAir;
	protected boolean inAir;
	private int ticksInAir;

	@SuppressWarnings("unchecked")
	public PainShootEntity(EntityType<?> type, World world) {
		super((EntityType<? extends DamagingProjectileEntity>) type, world);
		this.referenceItem = null;
	}

	public PainShootEntity(LivingEntity shooter, World world, Item referenceItemIn) {
		super(ModEntityTypes.LOST_SOUL_SHOOT.get(), world);
		this.referenceItem = referenceItemIn;
	}

	@OnlyIn(Dist.CLIENT)
	public PainShootEntity(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
		super(ModEntityTypes.LOST_SOUL_SHOOT.get(), x, y, z, accelX, accelY, accelZ, worldIn);
		this.referenceItem = null;
	}

	public PainShootEntity(World worldIn, LivingEntity shooter, double accelX, double accelY, double accelZ) {
		super(ModEntityTypes.LOST_SOUL_SHOOT.get(), shooter, accelX, accelY, accelZ, worldIn);
		this.referenceItem = null;
	}

	protected void func_225516_i_() {
		++this.ticksInAir;
		if (this.ticksExisted >= 40) {
			this.remove();
		}
	}

	@Override
	public boolean canRenderOnFire() {
		return false;
	}

	@Override
	public ActionResultType applyPlayerInteraction(PlayerEntity player, Vec3d vec, Hand hand) {
		return super.applyPlayerInteraction(player, vec, hand);
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putShort("life", (short) this.ticksInAir);
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.ticksInAir = compound.getShort("life");
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
		this.playSound(ModSoundEvents.ROCKET_HIT.get(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	}

	protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
		if (!this.world.isRemote) {
			this.explode();
			this.remove();
		}
		this.playSound(ModSoundEvents.ROCKET_HIT.get(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	}

	protected void explode() {
		this.world.createExplosion(this, this.getPosX(), this.getPosYHeight(0.0625D), this.getPosZ(), 1.0F,
				Explosion.Mode.NONE);
	}

}