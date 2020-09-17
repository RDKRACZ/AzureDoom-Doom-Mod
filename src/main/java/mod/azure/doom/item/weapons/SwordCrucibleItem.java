package mod.azure.doom.item.weapons;

import java.util.List;

import mod.azure.doom.DoomMod;
import mod.azure.doom.util.enums.DoomTier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SwordCrucibleItem extends SwordItem {

	public SwordCrucibleItem() {
		super(DoomTier.DOOM_HIGHTEIR, 12, -2.4F,
				new Item.Properties().group(DoomMod.DoomWeaponItemGroup).maxStackSize(1).maxDamage(5));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("doom.crucible_sword.text").mergeStyle(TextFormatting.RED)
				.mergeStyle(TextFormatting.ITALIC));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		// double posX = playerIn.getPosX();
		// double posY = playerIn.getPosY();
		// double posZ = playerIn.getPosZ();
		// worldIn.playSound(null, posX, posY, posZ, ModSoundEvents.WEAPON_THEME,
		// SoundCategory.BLOCKS, 1F, 1F);
		UseAction offhandItemAction = playerIn.getHeldItemOffhand().getUseAction();

		if (offhandItemAction != UseAction.BOW && offhandItemAction != UseAction.SPEAR) {
			playerIn.setActiveHand(handIn);
		}

		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	}

	@Override
	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
		ItemStack stack = new ItemStack(this);
		stack.hasTag();
		stack.addEnchantment(Enchantments.SMITE, 10);
		stack.addEnchantment(Enchantments.LOOTING, 10);
		stack.addEnchantment(Enchantments.SHARPNESS, 10);
		stack.addEnchantment(Enchantments.SWEEPING, 10);
		if (group == DoomMod.DoomWeaponItemGroup) {
			items.add(stack);
		}
	}

	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		stack.hasTag();
		stack.addEnchantment(Enchantments.SMITE, 10);
		stack.addEnchantment(Enchantments.LOOTING, 10);
		stack.addEnchantment(Enchantments.SHARPNESS, 10);
		stack.addEnchantment(Enchantments.SWEEPING, 10);
	}
}