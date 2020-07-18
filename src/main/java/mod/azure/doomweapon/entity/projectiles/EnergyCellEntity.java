package mod.azure.doomweapon.entity.projectiles;

import mod.azure.doomweapon.util.registry.ModEntityTypes;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EnergyCellEntity extends AbstractArrowEntity {

	private final Item referenceItem;
	public LivingEntity shootingEntity;

	@SuppressWarnings("unchecked")
	public EnergyCellEntity(EntityType<?> type, World world) {
		super((EntityType<? extends EnergyCellEntity>) type, world);
		this.referenceItem = null;
	}

	public EnergyCellEntity(LivingEntity shooter, World world, Item referenceItemIn) {
		super(ModEntityTypes.ENERGY_CELL.get(), shooter, world);
		this.referenceItem = referenceItemIn;
	}

	protected void func_225516_i_() {
		this.remove();
	}

	@Override
	public ItemStack getArrowStack() {
		return new ItemStack(this.referenceItem);
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
	protected void onHit(RayTraceResult result) {
		super.onHit(result);
		if (!this.world.isRemote) {
			this.explode();
			this.remove();
		}
		this.playSound(ModSoundEvents.PLASMA_HIT.get(), 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	}

	public void explode() {
		this.world.createExplosion(this, this.getPosX(), this.getPosYHeight(0.0625D), this.getPosZ(), 0.01F,
				Explosion.Mode.NONE);
	}
}