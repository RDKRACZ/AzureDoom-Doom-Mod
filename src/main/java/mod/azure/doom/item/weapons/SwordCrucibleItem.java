package mod.azure.doom.item.weapons;

import java.util.List;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.Keybindings;
import mod.azure.doom.util.enums.DoomTier;
import mod.azure.doom.util.packets.CrucibleLoadingPacket;
import mod.azure.doom.util.packets.DoomPacketHandler;
import mod.azure.doom.util.registry.DoomItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
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
		super(DoomTier.DOOM_HIGHTEIR, 36, -2.4F,
				new Item.Properties().group(DoomMod.DoomWeaponItemGroup).maxStackSize(1).maxDamage(5));
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return DoomTier.DOOM_HIGHTEIR.getRepairMaterial().test(repair) || super.getIsRepairable(toRepair, repair);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("doom.crucible_sword.text").mergeStyle(TextFormatting.RED)
				.mergeStyle(TextFormatting.ITALIC));
		tooltip.add(new TranslationTextComponent(
				"Ammo: " + (stack.getMaxDamage() - stack.getDamage() - 1) + " / " + (stack.getMaxDamage() - 1))
						.mergeStyle(TextFormatting.ITALIC));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (stack.getDamage() < (stack.getMaxDamage() - 1)) {
			stack.damageItem(1, target, p -> p.sendBreakAnimation(target.getActiveHand()));
		}
		return (stack.getDamage() < (stack.getMaxDamage() - 1)) ? true : false;
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (worldIn.isRemote) {
			PlayerEntity playerentity = (PlayerEntity) entityIn;
			if (playerentity.getHeldItemMainhand().getItem() instanceof SwordCrucibleItem) {
				while (Keybindings.RELOAD.isPressed() && isSelected) {
					DoomPacketHandler.CRUCIBLE.sendToServer(new CrucibleLoadingPacket(itemSlot));
				}
			}
		}
	}

	public static void reload(PlayerEntity user, Hand hand) {
		if (user.getHeldItem(hand).getItem() instanceof SwordCrucibleItem) {
			while (user.getHeldItem(hand).getDamage() != 0 && user.inventory.count(DoomItems.ARGENT_BLOCK.get()) > 0) {
				removeAmmo(DoomItems.ARGENT_BLOCK.get(), user);
				user.getHeldItem(hand).damageItem(-5, user, s -> user.sendBreakAnimation(hand));
				user.getHeldItem(hand).setAnimationsToGo(3);
			}
		}
	}

	private static void removeAmmo(Item ammo, PlayerEntity playerEntity) {
		if (!playerEntity.isCreative()) {
			for (ItemStack item : playerEntity.inventory.mainInventory) {
				if (item.getItem() == DoomItems.ARGENT_BLOCK.get()) {
					item.shrink(1);
					break;
				}
			}
		}
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

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}
}