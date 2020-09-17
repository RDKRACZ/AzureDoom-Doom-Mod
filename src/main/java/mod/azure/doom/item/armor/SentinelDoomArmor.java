package mod.azure.doom.item.armor;

import java.util.List;

import mod.azure.doom.DoomMod;
import mod.azure.doom.item.armor.skin.SkinArmor;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SentinelDoomArmor extends SkinArmor {

	public SentinelDoomArmor(IArmorMaterial materialIn, EquipmentSlotType slot) {
		super(materialIn, slot, new Item.Properties().group(DoomMod.DoomArmorItemGroup).maxStackSize(1));

	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("doom.sentinelarmor.text").mergeStyle(TextFormatting.YELLOW)
				.mergeStyle(TextFormatting.ITALIC));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

}