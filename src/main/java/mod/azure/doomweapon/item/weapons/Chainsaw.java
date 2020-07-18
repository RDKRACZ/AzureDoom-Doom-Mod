package mod.azure.doomweapon.item.weapons;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.util.enums.DoomTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class Chainsaw extends SwordItem {

	public Chainsaw() {
		super(DoomTier.DOOM, 2, -2.4F,
				new Item.Properties().group(DoomMod.DoomItemGroup).maxStackSize(1).maxDamage(600));
	}

}