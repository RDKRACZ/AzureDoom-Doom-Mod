package mod.azure.doomweapon.entity.projectiles;

import mod.azure.doomweapon.util.registry.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class ShotgunShellEntity extends AbstractArrowEntity  {

	private final Item referenceItem;

	@SuppressWarnings("unchecked")
	public ShotgunShellEntity(EntityType<?> type, World world) {
		super((EntityType<? extends AbstractArrowEntity>) type, world);
		this.referenceItem = null;
	}

	public ShotgunShellEntity(LivingEntity shooter, World world, Item referenceItemIn) {
		super(ModEntityTypes.SHOTGUN_SHELL.get(), shooter, world);
		this.referenceItem = referenceItemIn;
	}

	protected void func_225516_i_() {
		this.remove();
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
	public ItemStack getArrowStack() {
		return new ItemStack(this.referenceItem);
	}

	@Override
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

}