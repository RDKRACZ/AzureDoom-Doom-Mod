package mod.azure.doomweapon.item;

import java.util.List;

import mod.azure.doomweapon.DoomMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class UnopenedItem extends Item {

	public UnopenedItem() {
		super(new Item.Properties().group(DoomMod.DoomWeaponItemGroup).maxStackSize(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("\u00A7o" + "Expired but holds tremendous potential."));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
}