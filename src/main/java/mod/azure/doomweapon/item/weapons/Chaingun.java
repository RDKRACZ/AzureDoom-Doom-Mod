package mod.azure.doomweapon.item.weapons;

import java.util.function.Predicate;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.projectiles.ChaingunBulletEntity;
import mod.azure.doomweapon.item.ammo.ChaingunAmmo;
import mod.azure.doomweapon.util.registry.DoomItems;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class Chaingun extends ShootableItem {

	public Chaingun() {
		super(new Item.Properties().group(DoomMod.DoomItemGroup).maxStackSize(1));
	}

	@Override
	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
		ItemStack stack = new ItemStack(this);
		stack.hasTag();
		stack.addEnchantment(Enchantments.PUNCH, 2);
		if (group == DoomMod.DoomItemGroup) {
			items.add(stack);
		}
	}

	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		stack.hasTag();
		stack.addEnchantment(Enchantments.PUNCH, 2);
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		if (entityLiving instanceof PlayerEntity) {
			PlayerEntity playerentity = (PlayerEntity) entityLiving;
			boolean flag = playerentity.abilities.isCreativeMode
					|| EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack itemstack = playerentity.findAmmo(stack);

			if (!itemstack.isEmpty() || flag) {
				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(DoomItems.CHAINGUN_BULLETS.get());
				}

				boolean flag1 = playerentity.abilities.isCreativeMode || (itemstack.getItem() instanceof ChaingunAmmo
						&& ((ChaingunAmmo) itemstack.getItem()).isInfinite(itemstack, stack, playerentity));
				if (!worldIn.isRemote) {
					ChaingunAmmo arrowitem = (ChaingunAmmo) (itemstack.getItem() instanceof ChaingunAmmo
							? itemstack.getItem()
							: DoomItems.CHAINGUN_BULLETS.get());
					ChaingunBulletEntity abstractarrowentity = arrowitem.createArrow(worldIn, itemstack, playerentity);
					abstractarrowentity = customeArrow(abstractarrowentity);
					abstractarrowentity.func_234612_a_(playerentity, playerentity.rotationPitch,
							playerentity.rotationYaw, 0.0F, 1 * 3.0F, 1.0F);
					abstractarrowentity.setIsCritical(true);

					int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
					if (j > 0) {
						abstractarrowentity.setDamage(abstractarrowentity.getDamage() + (double) j * 0.5D + 0.5D);
					}

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
							&& (itemstack.getItem() == DoomItems.CHAINGUN_BULLETS.get()
									|| itemstack.getItem() == DoomItems.CHAINGUN_BULLETS.get())) {
						abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
					}
					worldIn.addEntity(abstractarrowentity);
				}
				worldIn.playSound((PlayerEntity) null, playerentity.getPosX(), playerentity.getPosY(),
						playerentity.getPosZ(), ModSoundEvents.CHAINGUN_SHOOT.get(), SoundCategory.PLAYERS, 1.0F,
						1.0F / (random.nextFloat() * 0.4F + 1.2F) + 1 * 0.5F);
				if (!flag1 && !playerentity.abilities.isCreativeMode) {
					itemstack.shrink(1);
					if (itemstack.isEmpty()) {
						playerentity.inventory.deleteStack(itemstack);
					}
				}
				playerentity.addStat(Stats.ITEM_USED.get(this));
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
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		boolean flag = !playerIn.findAmmo(itemstack).isEmpty();

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
		return itemStack -> itemStack.getItem() instanceof ChaingunAmmo;
	}

	public ChaingunBulletEntity customeArrow(ChaingunBulletEntity arrow) {
		return arrow;
	}

	@Override
	public int func_230305_d_() {
		return 15;
	}
}