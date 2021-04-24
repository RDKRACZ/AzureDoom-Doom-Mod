package mod.azure.doom.item.weapons;

import java.util.List;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.Keybindings;
import mod.azure.doom.client.render.weapons.CrucibleRender;
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
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class SwordCrucibleItem extends SwordItem implements IAnimatable {

	public AnimationFactory factory = new AnimationFactory(this);
	private String controllerName = "controller";

	private <P extends SwordItem & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
		return PlayState.CONTINUE;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, controllerName, 1, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	public SwordCrucibleItem() {
		super(DoomTier.DOOM_HIGHTEIR, 36, -2.4F, new Item.Properties().tab(DoomMod.DoomWeaponItemGroup).stacksTo(1)
				.durability(5).setISTER(() -> CrucibleRender::new));
	}

	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
		return DoomTier.DOOM_HIGHTEIR.getRepairIngredient().test(repair) || super.isValidRepairItem(toRepair, repair);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("doom.crucible_sword.text").withStyle(TextFormatting.RED)
				.withStyle(TextFormatting.ITALIC));
		tooltip.add(new TranslationTextComponent(
				"Ammo: " + (stack.getMaxDamage() - stack.getDamageValue() - 1) + " / " + (stack.getMaxDamage() - 1))
						.withStyle(TextFormatting.ITALIC));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (stack.getDamageValue() < (stack.getMaxDamage() - 1)) {
			stack.hurtAndBreak(1, target, p -> p.broadcastBreakEvent(target.getUsedItemHand()));
		}
		return (stack.getDamageValue() < (stack.getMaxDamage() - 1)) ? true : false;
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		PlayerEntity playerentity = (PlayerEntity) entityIn;
		boolean activestate = playerentity.getMainHandItem().getItem() instanceof SwordCrucibleItem && isSelected;
		AnimationController<?> controller = GeckoLibUtil.getControllerForStack(this.factory, stack, controllerName);
		controller.markNeedsReload();
		controller.setAnimation(new AnimationBuilder().addAnimation((activestate ? "close" : "open"), false)
				.addAnimation((activestate ? "open_loop" : "close_loop"), false));
		if (worldIn.isClientSide) {
			if (playerentity.getMainHandItem().getItem() instanceof SwordCrucibleItem) {
				while (Keybindings.RELOAD.consumeClick() && isSelected) {
					DoomPacketHandler.CRUCIBLE.sendToServer(new CrucibleLoadingPacket(itemSlot));
				}
			}
		}
	}

	public static void reload(PlayerEntity user, Hand hand) {
		if (user.getItemInHand(hand).getItem() instanceof SwordCrucibleItem) {
			while (user.getItemInHand(hand).getDamageValue() != 0
					&& user.inventory.countItem(DoomItems.ARGENT_BLOCK.get()) > 0) {
				removeAmmo(DoomItems.ARGENT_BLOCK.get(), user);
				user.getItemInHand(hand).hurtAndBreak(-5, user, s -> user.broadcastBreakEvent(hand));
				user.getItemInHand(hand).setPopTime(3);
			}
		}
	}

	public static void removeAmmo(Item ammo, PlayerEntity playerEntity) {
		if (!playerEntity.isCreative()) {
			for (ItemStack item : playerEntity.inventory.offhand) {
				if (item.getItem() == ammo) {
					item.shrink(1);
					break;
				}
				for (ItemStack item1 : playerEntity.inventory.items) {
					if (item1.getItem() == ammo) {
						item1.shrink(1);
						break;
					}
				}
			}
		}
	}

	@Override
	public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items) {
		ItemStack stack = new ItemStack(this);
		stack.hasTag();
		stack.enchant(Enchantments.SMITE, 10);
		stack.enchant(Enchantments.MOB_LOOTING, 10);
		stack.enchant(Enchantments.SHARPNESS, 10);
		stack.enchant(Enchantments.SWEEPING_EDGE, 10);
		if ((group == DoomMod.DoomWeaponItemGroup) || (group == ItemGroup.TAB_SEARCH)) {
			items.add(stack);
		}
	}

	@Override
	public void onCraftedBy(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		stack.hasTag();
		stack.enchant(Enchantments.SMITE, 10);
		stack.enchant(Enchantments.MOB_LOOTING, 10);
		stack.enchant(Enchantments.SHARPNESS, 10);
		stack.enchant(Enchantments.SWEEPING_EDGE, 10);
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return false;
	}
}