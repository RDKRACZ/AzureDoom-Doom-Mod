package mod.azure.doomweapon.item.weapons;

import java.util.List;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.util.Config;
import mod.azure.doomweapon.util.enums.DoomTier;
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
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SwordCrucibleItem extends SwordItem {

	public SwordCrucibleItem() {
		super(DoomTier.DOOM, Config.SERVER.SWORD_CRUCIBLE_ATTACK.get(), -2.4F, new Item.Properties()
				.group(DoomMod.DoomItemGroup).maxStackSize(1).maxDamage(Config.SERVER.SWORD_CRUCIBLE_MAXDAMAGE.get()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("\u00A7c" + "Rip and Tear. Until it is done."));
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
		if (group == DoomMod.DoomItemGroup) {
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

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}
}