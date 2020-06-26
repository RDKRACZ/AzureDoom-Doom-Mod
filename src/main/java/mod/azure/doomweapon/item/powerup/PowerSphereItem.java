package mod.azure.doomweapon.item.powerup;

import mod.azure.doomweapon.DoomMod;
import net.minecraft.item.Item;

public class PowerSphereItem extends Item {

	public PowerSphereItem() {
		super(new Item.Properties().group(DoomMod.DoomItemGroup).maxStackSize(1));
	}

}