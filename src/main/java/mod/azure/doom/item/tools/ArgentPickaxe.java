package mod.azure.doom.item.tools;

import java.util.List;

import mod.azure.doom.DoomMod;
import mod.azure.doom.util.enums.DoomTier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ArgentPickaxe extends PickaxeItem {

	public ArgentPickaxe() {
		super(DoomTier.DOOM, 4, -2.4F, new Item.Properties().group(DoomMod.DoomWeaponItemGroup).maxStackSize(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("doom.argent_powered.text").mergeStyle(TextFormatting.RED)
				.mergeStyle(TextFormatting.ITALIC));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

}