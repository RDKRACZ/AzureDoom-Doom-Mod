package mod.azure.doomweapon.item.tools;

import java.util.List;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.util.enums.DoomTier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class ArgentPaxel extends PickaxeItem {

	public ArgentPaxel() {
		super(DoomTier.DOOM, 8, -2.4F, new Item.Properties().group(DoomMod.DoomItemGroup).maxStackSize(1)
				.addToolType(ToolType.AXE, 6).addToolType(ToolType.SHOVEL, 6));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("\u00A7c" + "\u00A7o" + "Powered by Argent Energy"));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

}