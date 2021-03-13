package mod.azure.doom.item.weapons;

import java.util.List;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.Keybindings;
import mod.azure.doom.entity.projectiles.UnmaykrBoltEntity;
import mod.azure.doom.util.enums.DoomTier;
import mod.azure.doom.util.packets.DoomPacketHandler;
import mod.azure.doom.util.packets.UnmaykrLoadingPacket;
import mod.azure.doom.util.registry.DoomItems;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class Unmaykr extends DoomBaseItem implements IVanishable {

	public Unmaykr() {
		super(new Item.Properties().tab(DoomMod.DoomWeaponItemGroup).stacksTo(1).durability(9000));
	}

	@Override
	public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items) {
		ItemStack stack = new ItemStack(this);
		stack.hasTag();
		stack.enchant(Enchantments.INFINITY_ARROWS, 1);
		if (group == DoomMod.DoomWeaponItemGroup) {
			items.add(stack);
		}
	}

	@Override
	public void onCraftedBy(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		stack.hasTag();
		stack.enchant(Enchantments.INFINITY_ARROWS, 1);
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return false;
	}

	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
		return DoomTier.UNMAYKR.getRepairIngredient().test(repair) || super.isValidRepairItem(toRepair, repair);
	}

	@Override
	public void onUseTick(World worldIn, LivingEntity entityLiving, ItemStack stack, int count) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) entityLiving;
			if (stack.getDamageValue() < (stack.getMaxDamage() - 1) && !playerentity.getCooldowns().isOnCooldown(this)) {
				playerentity.getCooldowns().addCooldown(this, 5);
				if (!worldIn.isClientSide) {
					UnmaykrBoltEntity abstractarrowentity = createArrow(worldIn, stack, playerentity);
					abstractarrowentity = customeArrow(abstractarrowentity);
					abstractarrowentity.shootFromRotation(playerentity, playerentity.xRot,
							playerentity.yRot, 0.0F, 1.0F * 3.0F, 1.0F);
					UnmaykrBoltEntity abstractarrowentity1 = createArrow(worldIn, stack, playerentity);
					abstractarrowentity1 = customeArrow(abstractarrowentity1);
					abstractarrowentity1.shootFromRotation(playerentity, playerentity.xRot,
							playerentity.yRot + 10, 0.0F, 1.0F * 3.0F, 1.0F);
					UnmaykrBoltEntity abstractarrowentity2 = createArrow(worldIn, stack, playerentity);
					abstractarrowentity2 = customeArrow(abstractarrowentity2);
					abstractarrowentity2.shootFromRotation(playerentity, playerentity.xRot,
							playerentity.yRot - 10, 0.0F, 1.0F * 3.0F, 1.0F);

					abstractarrowentity.setBaseDamage(5.7);
					abstractarrowentity.isNoGravity();
					abstractarrowentity1.setBaseDamage(5.7);
					abstractarrowentity1.isNoGravity();
					abstractarrowentity2.setBaseDamage(5.7);
					abstractarrowentity2.isNoGravity();

					stack.hurtAndBreak(1, entityLiving, p -> p.broadcastBreakEvent(entityLiving.getUsedItemHand()));
					worldIn.addFreshEntity(abstractarrowentity);
					worldIn.addFreshEntity(abstractarrowentity1);
					worldIn.addFreshEntity(abstractarrowentity2);
					worldIn.playSound((PlayerEntity) null, playerentity.getX(), playerentity.getY(),
							playerentity.getZ(), ModSoundEvents.UNMAKYR_FIRE.get(), SoundCategory.PLAYERS, 1.0F,
							1.0F / (random.nextFloat() * 0.4F + 1.2F) + 0.25F * 0.5F);
				}
			}
		}
	}

	public UnmaykrBoltEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
		UnmaykrBoltEntity arrowentity = new UnmaykrBoltEntity(worldIn, shooter);
		return arrowentity;
	}

	@Override
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (worldIn.isClientSide) {
			if (((PlayerEntity) entityIn).getMainHandItem().getItem() instanceof Unmaykr) {
				while (Keybindings.RELOAD.consumeClick() && isSelected) {
					DoomPacketHandler.UNMAYKR.sendToServer(new UnmaykrLoadingPacket(itemSlot));
				}
			}
		}
	}

	public static void reload(PlayerEntity user, Hand hand) {
		if (user.getItemInHand(hand).getItem() instanceof Unmaykr) {
			while (user.getItemInHand(hand).getDamageValue() != 0 && user.inventory.countItem(DoomItems.UNMAKRY_BOLT.get()) > 0) {
				removeAmmo(DoomItems.UNMAKRY_BOLT.get(), user);
				user.getItemInHand(hand).hurtAndBreak(-20, user, s -> user.broadcastBreakEvent(hand));
				user.getItemInHand(hand).setPopTime(3);
			}
		}
	}

	private static void removeAmmo(Item ammo, PlayerEntity playerEntity) {
		if (!playerEntity.isCreative()) {
			for (ItemStack item : playerEntity.inventory.items) {
				if (item.getItem() == DoomItems.UNMAKRY_BOLT.get()) {
					item.shrink(1);
					break;
				}
			}
		}
	}

	public static float getArrowVelocity(int charge) {
		float f = (float) charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;
		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	@Override
	public UseAction getUseAnimation(ItemStack stack) {
		return UseAction.NONE;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent(
				"Ammo: " + (stack.getMaxDamage() - stack.getDamageValue() - 1) + " / " + (stack.getMaxDamage() - 1))
						.withStyle(TextFormatting.ITALIC));
	}

	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		playerIn.startUsingItem(handIn);
		return ActionResult.consume(itemstack);
	}

	public UnmaykrBoltEntity customeArrow(UnmaykrBoltEntity arrow) {
		return arrow;
	}
}