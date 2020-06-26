package mod.azure.doomweapon.item.eggs;

import mod.azure.doomweapon.DoomMod;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DoomSpawnEgg extends Item {

	private final int primaryColor;
	private final int secondaryColor;

	public DoomSpawnEgg(int primaryColorIn, int secondaryColorIn) {
		super(new Item.Properties().maxStackSize(1).group(DoomMod.DoomItemGroup));
		this.primaryColor = primaryColorIn;
		this.secondaryColor = secondaryColorIn;
	}

	@OnlyIn(Dist.CLIENT)
	public int getColor(int tintIndex) {
		return tintIndex == 0 ? this.primaryColor : this.secondaryColor;
	}

}