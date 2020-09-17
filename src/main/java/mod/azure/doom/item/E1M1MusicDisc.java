package mod.azure.doom.item;

import mod.azure.doom.DoomMod;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Rarity;

public class E1M1MusicDisc extends MusicDiscItem {

	public E1M1MusicDisc() {
		super(1, ModSoundEvents.E1M1,
				(new Item.Properties()).maxStackSize(1).group(DoomMod.DoomPowerUPItemGroup).rarity(Rarity.RARE));
	}

}