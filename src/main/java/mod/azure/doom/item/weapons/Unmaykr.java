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

public class Unmaykr extends Item {

	public Unmaykr() {
		super(new Item.Properties().group(DoomMod.DoomWeaponItemGroup).maxStackSize(1).maxDamage(9000));
	}

	@Override
	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
		ItemStack stack = new ItemStack(this);
		stack.hasTag();
		stack.addEnchantment(Enchantments.INFINITY, 1);
		if (group == DoomMod.DoomWeaponItemGroup) {
			items.add(stack);
		}
	}

	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		stack.hasTag();
		stack.addEnchantment(Enchantments.INFINITY, 1);
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return DoomTier.UNMAYKR.getRepairMaterial().test(repair) || super.getIsRepairable(toRepair, repair);
	}

	@Override
	public void onUse(World worldIn, LivingEntity entityLiving, ItemStack stack, int count) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) entityLiving;
			if (stack.getDamage() < (stack.getMaxDamage() - 1)) {
				playerentity.getCooldownTracker().setCooldown(this, 5);
				if (!worldIn.isRemote) {
					UnmaykrBoltEntity abstractarrowentity = createArrow(worldIn, stack, playerentity);
					abstractarrowentity = customeArrow(abstractarrowentity);
					abstractarrowentity.shoot(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F,
							1.0F * 3.0F, 1.0F);

					abstractarrowentity.setDamage(5.7);
					abstractarrowentity.hasNoGravity();

					stack.damageItem(1, entityLiving, p -> p.sendBreakAnimation(entityLiving.getActiveHand()));
					worldIn.addEntity(abstractarrowentity);
					worldIn.playSound((PlayerEntity) null, playerentity.getPosX(), playerentity.getPosY(),
							playerentity.getPosZ(), ModSoundEvents.UNMAKYR_FIRE.get(), SoundCategory.PLAYERS, 1.0F,
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
		if (worldIn.isRemote) {
			if (((PlayerEntity) entityIn).getHeldItemMainhand().getItem() instanceof Unmaykr) {
				while (Keybindings.RELOAD.isPressed() && isSelected) {
					DoomPacketHandler.UNMAYKR.sendToServer(new UnmaykrLoadingPacket(itemSlot));
				}
			}
		}
	}

	public static void reload(PlayerEntity user, Hand hand) {
		if (user.getHeldItem(hand).getItem() instanceof Unmaykr) {
			while (user.getHeldItem(hand).getDamage() != 0 && user.inventory.count(DoomItems.UNMAKRY_BOLT.get()) > 0) {
				removeAmmo(DoomItems.UNMAKRY_BOLT.get(), user);
				user.getHeldItem(hand).damageItem(-20, user, s -> user.sendBreakAnimation(hand));
				user.getHeldItem(hand).setAnimationsToGo(3);
			}
		}
	}

	private static void removeAmmo(Item ammo, PlayerEntity playerEntity) {
		if (!playerEntity.isCreative()) {
			for (ItemStack item : playerEntity.inventory.mainInventory) {
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
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.NONE;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent(
				"Ammo: " + (stack.getMaxDamage() - stack.getDamage() - 1) + " / " + (stack.getMaxDamage() - 1))
						.applyTextStyle(TextFormatting.ITALIC));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		playerIn.setActiveHand(handIn);
		return ActionResult.resultConsume(itemstack);
	}

	public UnmaykrBoltEntity customeArrow(UnmaykrBoltEntity arrow) {
		return arrow;
	}
}