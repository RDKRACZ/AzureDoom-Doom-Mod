package mod.azure.doom.item.weapons;

import mod.azure.doom.DoomMod;
import mod.azure.doom.util.enums.DoomTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class Chainsaw extends SwordItem {

	public Chainsaw() {
		super(DoomTier.DOOM, 2, -2.4F,
				new Item.Properties().group(DoomMod.DoomWeaponItemGroup).maxStackSize(1).maxDamage(600));
	}

}