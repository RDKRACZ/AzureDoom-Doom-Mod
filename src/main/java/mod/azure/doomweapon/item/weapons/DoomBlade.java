package mod.azure.doomweapon.item.weapons;

import java.util.List;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.util.enums.DoomTier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DoomBlade extends SwordItem {

	public DoomBlade() {
		super(DoomTier.DOOM, 2, -2.4F,
				new Item.Properties().group(DoomMod.DoomWeaponItemGroup).maxStackSize(1).maxDamage(9000));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World world, List<ITextComponent> tooltip, ITooltipFlag context) {
		tooltip.add(new StringTextComponent("\u00A7c" + "\u00A7o" + "A modification to the Praetor suit,"));
		tooltip.add(new StringTextComponent("\u00A7c" + "\u00A7o" + "the arm-mounted Doomblade is designed"));
		tooltip.add(new StringTextComponent(
				"\u00A7c" + "\u00A7o" + "to increase the Slayer's short-range striking power."));
		super.addInformation(stack, world, tooltip, context);
	}
}