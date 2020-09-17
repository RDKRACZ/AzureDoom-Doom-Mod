package mod.azure.doom.item.tools;

import java.util.List;

import mod.azure.doom.DoomMod;
import mod.azure.doom.util.registry.DoomItems;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ArgentShield extends Item {

	public ArgentShield() {
		super(new Item.Properties().group(DoomMod.DoomWeaponItemGroup).maxStackSize(1));
		DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("doom.argent_powered.text").mergeStyle(TextFormatting.RED)
				.mergeStyle(TextFormatting.ITALIC));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BLOCK;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		playerIn.setActiveHand(handIn);
		return ActionResult.resultConsume(itemstack);
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return DoomItems.ARGENT_ENERGY.get() == repair.getItem() ? true : super.getIsRepairable(toRepair, repair);
	}

}