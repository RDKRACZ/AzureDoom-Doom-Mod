package mod.azure.doom.item;

import java.util.List;

import mod.azure.doom.DoomMod;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ArgentEnergyItem extends Item {

	public ArgentEnergyItem() {
		super(new Item.Properties().group(DoomMod.DoomPowerUPItemGroup));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("doom.argent_engery1.text").mergeStyle(TextFormatting.RED)
				.mergeStyle(TextFormatting.ITALIC));
		tooltip.add(new TranslationTextComponent("doom.argent_engery2.text").mergeStyle(TextFormatting.RED)
				.mergeStyle(TextFormatting.ITALIC));
		tooltip.add(new TranslationTextComponent("doom.argent_engery3.text").mergeStyle(TextFormatting.RED)
				.mergeStyle(TextFormatting.ITALIC));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public int getBurnTime(ItemStack itemStack) {
		return 100000;
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

	public int GetFuelValue() {
		return 1200;
	}
}