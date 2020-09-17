package mod.azure.doomweapon.item.tools;

import java.util.List;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.util.enums.DoomTier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ArgentShovel extends ShovelItem {

	public ArgentShovel() {
		super(DoomTier.DOOM, 4, -2.4F, new Item.Properties().group(DoomMod.DoomWeaponItemGroup).maxStackSize(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("doom.argent_powered.text").applyTextStyle(TextFormatting.RED)
				.applyTextStyle(TextFormatting.ITALIC));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

}