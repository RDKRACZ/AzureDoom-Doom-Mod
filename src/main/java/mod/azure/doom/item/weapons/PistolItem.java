package mod.azure.doom.item.weapons;

import java.util.function.Predicate;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.projectiles.BulletEntity;
import mod.azure.doom.item.ammo.ClipAmmo;
import mod.azure.doom.util.enums.DoomTier;
import mod.azure.doom.util.registry.DoomItems;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class PistolItem extends BowItem {

	public PistolItem() {
		super(new Item.Properties().group(DoomMod.DoomWeaponItemGroup).maxStackSize(1).maxDamage(9000));
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return DoomTier.DOOM.getRepairMaterial().test(repair) || super.getIsRepairable(toRepair, repair);
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) entityLiving;
			boolean flag = playerentity.abilities.isCreativeMode
					|| EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack itemstack = playerentity.findAmmo(stack);

			int i = this.getUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i,
					!itemstack.isEmpty() || flag);
			if (i < 0)
				return;

			if (!itemstack.isEmpty() || flag) {
				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(DoomItems.BULLETS.get());
				}

				if (playerentity.getHeldItemMainhand().getAnimationsToGo() == 0) {

					boolean flag1 = playerentity.abilities.isCreativeMode || (itemstack.getItem() instanceof ClipAmmo
							&& ((ClipAmmo) itemstack.getItem()).isInfinite(itemstack, stack, playerentity));
					if (!worldIn.isRemote) {
						ClipAmmo arrowitem = (ClipAmmo) (itemstack.getItem() instanceof ClipAmmo ? itemstack.getItem()
								: DoomItems.BULLETS.get());
						BulletEntity abstractarrowentity = arrowitem.createArrow(worldIn, itemstack, playerentity);
						abstractarrowentity = customeArrow(abstractarrowentity);
						abstractarrowentity.func_234612_a_(playerentity, playerentity.rotationPitch,
								playerentity.rotationYaw, 0.0F, 0.25F * 3.0F, 1.0F);

						abstractarrowentity.setDamage(abstractarrowentity.getDamage() + 1.3);

						int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
						if (k > 0) {
							abstractarrowentity.setKnockbackStrength(k);
						}

						if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
							abstractarrowentity.setFire(100);
						}

						stack.damageItem(1, playerentity, (p_220009_1_) -> {
							p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
						});
						if (flag1 || playerentity.abilities.isCreativeMode
								&& (itemstack.getItem() == DoomItems.BULLETS.get()
										|| itemstack.getItem() == DoomItems.BULLETS.get())) {
							abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
						}
						worldIn.addEntity(abstractarrowentity);

						worldIn.playSound((PlayerEntity) null, playerentity.getPosX(), playerentity.getPosY(),
								playerentity.getPosZ(), ModSoundEvents.PISTOL_HIT.get(), SoundCategory.PLAYERS, 1.0F,
								1.0F / (random.nextFloat() * 0.4F + 1.2F) + 0.25F * 0.5F);
						if (!flag1 && !playerentity.abilities.isCreativeMode) {
							itemstack.shrink(1);
							if (itemstack.isEmpty()) {
								playerentity.inventory.deleteStack(itemstack);
							}
						}
						playerentity.getHeldItemMainhand().setAnimationsToGo(5);
					}
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
	public int getUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		boolean flag = !playerIn.findAmmo(itemstack).isEmpty();

		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn,
				playerIn, handIn, flag);
		if (ret != null)
			return ret;

		if (!playerIn.abilities.isCreativeMode && !flag) {
			return ActionResult.resultFail(itemstack);
		} else {
			playerIn.setActiveHand(handIn);
			return ActionResult.resultConsume(itemstack);
		}
	}

	@Override
	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return getAmmoPredicate();
	}

	@Override
	public Predicate<ItemStack> getAmmoPredicate() {
		return itemStack -> itemStack.getItem() instanceof ClipAmmo;
	}

	public BulletEntity customeArrow(BulletEntity arrow) {
		return arrow;
	}
}