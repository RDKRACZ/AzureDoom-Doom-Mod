package mod.azure.doomweapon.item.weapons;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import com.google.common.collect.Lists;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.item.ammo.ArgentBolt;
import mod.azure.doomweapon.util.enums.DoomTier;
import mod.azure.doomweapon.util.registry.DoomItems;
import mod.azure.doomweapon.util.registry.ModSoundEvents;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ICrossbowUser;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;

public class Ballista extends ShootableItem implements IVanishable {

	private boolean isLoadingStart = false;
	private boolean isLoadingMiddle = false;

	public Ballista() {
		super(new Item.Properties().group(DoomMod.DoomWeaponItemGroup).maxStackSize(1).maxDamage(9000));
	}

	@Override
	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
		ItemStack stack = new ItemStack(this);
		stack.hasTag();
		stack.addEnchantment(Enchantments.PIERCING, 10);
		if (group == DoomMod.DoomWeaponItemGroup) {
			items.add(stack);
		}
	}

	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		stack.hasTag();
		stack.addEnchantment(Enchantments.PIERCING, 10);
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return DoomTier.DOOM.getRepairMaterial().test(repair) || super.getIsRepairable(toRepair, repair);
	}

	@Override
	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return getAmmoPredicate();
	}

	@Override
	public Predicate<ItemStack> getAmmoPredicate() {
		return itemStack -> itemStack.getItem() instanceof ArgentBolt;
	}

	public static int getChargeTime(ItemStack stack) {
		int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.QUICK_CHARGE, stack);
		return i == 0 ? 25 : 25 - 5 * i;
	}

	private static AbstractArrowEntity createArrow(World worldIn, LivingEntity shooter, ItemStack crossbow,
			ItemStack ammo) {
		ArgentBolt arrowitem = (ArgentBolt) (ammo.getItem() instanceof ArgentBolt ? ammo.getItem()
				: DoomItems.ARGENT_BOLT.get());
		AbstractArrowEntity abstractarrowentity = arrowitem.createArrow(worldIn, ammo, shooter);
		if (shooter instanceof PlayerEntity) {
			abstractarrowentity.setIsCritical(true);
		}

		abstractarrowentity.setHitSound(SoundEvents.ITEM_CROSSBOW_HIT);
		abstractarrowentity.setShotFromCrossbow(true);
		int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.PIERCING, crossbow);
		if (i > 0) {
			abstractarrowentity.setPierceLevel((byte) i);
		}

		return abstractarrowentity;
	}

	public static void fireProjectiles(World worldIn, LivingEntity shooter, Hand handIn, ItemStack stack,
			float velocityIn, float inaccuracyIn) {
		List<ItemStack> list = getChargedProjectiles(stack);
		float[] afloat = getRandomSoundPitches(shooter.getRNG());

		for (int i = 0; i < list.size(); ++i) {
			ItemStack itemstack = list.get(i);
			boolean flag = shooter instanceof PlayerEntity && ((PlayerEntity) shooter).abilities.isCreativeMode;
			if (!itemstack.isEmpty()) {
				if (i == 0) {
					fireProjectile(worldIn, shooter, handIn, stack, itemstack, afloat[i], flag, velocityIn,
							inaccuracyIn, 0.0F);
				} else if (i == 1) {
					fireProjectile(worldIn, shooter, handIn, stack, itemstack, afloat[i], flag, velocityIn,
							inaccuracyIn, -10.0F);
				} else if (i == 2) {
					fireProjectile(worldIn, shooter, handIn, stack, itemstack, afloat[i], flag, velocityIn,
							inaccuracyIn, 10.0F);
				}
			}
		}

		fireProjectilesAfter(worldIn, shooter, stack);
	}

	@Override
	public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
		if (!worldIn.isRemote) {
			int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.QUICK_CHARGE, stack);
			SoundEvent soundevent = this.getSoundEvent(i);
			SoundEvent soundevent1 = i == 0 ? ModSoundEvents.LOADING_MIDDLE1.get() : null;
			float f = (float) (stack.getUseDuration() - count) / (float) getChargeTime(stack);
			if (f < 0.2F) {
				this.isLoadingStart = false;
				this.isLoadingMiddle = false;
			}

			if (f >= 0.2F && !this.isLoadingStart) {
				this.isLoadingStart = true;
				worldIn.playSound((PlayerEntity) null, livingEntityIn.getPosX(), livingEntityIn.getPosY(),
						livingEntityIn.getPosZ(), soundevent, SoundCategory.PLAYERS, 0.5F, 1.0F);
			}

			if (f >= 0.5F && soundevent1 != null && !this.isLoadingMiddle) {
				this.isLoadingMiddle = true;
				worldIn.playSound((PlayerEntity) null, livingEntityIn.getPosX(), livingEntityIn.getPosY(),
						livingEntityIn.getPosZ(), soundevent1, SoundCategory.PLAYERS, 0.5F, 1.0F);
			}
		}

	}

	private static void fireProjectilesAfter(World worldIn, LivingEntity shooter, ItemStack stack) {
		if (shooter instanceof ServerPlayerEntity) {
			ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) shooter;
			if (!worldIn.isRemote) {
				CriteriaTriggers.SHOT_CROSSBOW.test(serverplayerentity, stack);
			}

			serverplayerentity.addStat(Stats.ITEM_USED.get(stack.getItem()));
		}

		clearProjectiles(stack);
	}

	private static float[] getRandomSoundPitches(Random rand) {
		boolean flag = rand.nextBoolean();
		return new float[] { 1.0F, getRandomSoundPitch(flag), getRandomSoundPitch(!flag) };
	}

	private static float getRandomSoundPitch(boolean flagIn) {
		float f = flagIn ? 0.63F : 0.43F;
		return 1.0F / (random.nextFloat() * 0.5F + 1.8F) + f;
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		if (isCharged(itemstack)) {
			fireProjectiles(worldIn, playerIn, handIn, itemstack, func_220013_l(itemstack), 1.0F);
			setCharged(itemstack, false);
			return ActionResult.resultConsume(itemstack);
		} else if (!playerIn.findAmmo(itemstack).isEmpty()) {
			if (!isCharged(itemstack)) {
				this.isLoadingStart = false;
				this.isLoadingMiddle = false;
				playerIn.setActiveHand(handIn);
			}

			return ActionResult.resultConsume(itemstack);
		} else {
			return ActionResult.resultFail(itemstack);
		}
	}

	private static List<ItemStack> getChargedProjectiles(ItemStack stack) {
		List<ItemStack> list = Lists.newArrayList();
		CompoundNBT compoundnbt = stack.getTag();
		if (compoundnbt != null && compoundnbt.contains("ChargedProjectiles", 9)) {
			ListNBT listnbt = compoundnbt.getList("ChargedProjectiles", 10);
			if (listnbt != null) {
				for (int i = 0; i < listnbt.size(); ++i) {
					CompoundNBT compoundnbt1 = listnbt.getCompound(i);
					list.add(ItemStack.read(compoundnbt1));
				}
			}
		}

		return list;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return getChargeTime(stack) + 128;
	}

	private static void clearProjectiles(ItemStack stack) {
		CompoundNBT compoundnbt = stack.getTag();
		if (compoundnbt != null) {
			ListNBT listnbt = compoundnbt.getList("ChargedProjectiles", 9);
			listnbt.clear();
			compoundnbt.put("ChargedProjectiles", listnbt);
		}

	}

	public static boolean hasChargedProjectile(ItemStack stack, Item ammoItem) {
		return getChargedProjectiles(stack).stream().anyMatch((p_220010_1_) -> {
			return p_220010_1_.getItem() == ammoItem;
		});
	}

	private static void fireProjectile(World worldIn, LivingEntity shooter, Hand handIn, ItemStack crossbow,
			ItemStack projectile, float soundPitch, boolean isCreativeMode, float velocity, float inaccuracy,
			float projectileAngle) {
		if (!worldIn.isRemote) {
			boolean flag = projectile.getItem() == Items.FIREWORK_ROCKET;
			ProjectileEntity iprojectile;
			if (flag) {
				iprojectile = new FireworkRocketEntity(worldIn, projectile, shooter.getPosX(),
						shooter.getPosYEye() - (double) 0.15F, shooter.getPosZ(), true);
			} else {
				iprojectile = createArrow(worldIn, shooter, crossbow, projectile);
				if (isCreativeMode || projectileAngle != 0.0F) {
					((AbstractArrowEntity) iprojectile).pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
				}
			}

			if (shooter instanceof ICrossbowUser) {
				ICrossbowUser icrossbowuser = (ICrossbowUser) shooter;
				icrossbowuser.func_230284_a_(icrossbowuser.getAttackTarget(), crossbow, iprojectile, projectileAngle);
			} else {
				Vector3d vec3d1 = shooter.getUpVector(1.0F);
				Quaternion quaternion = new Quaternion(new Vector3f(vec3d1), projectileAngle, true);
				Vector3d vec3d = shooter.getLook(1.0F);
				Vector3f vector3f = new Vector3f(vec3d);
				vector3f.transform(quaternion);
				iprojectile.shoot((double) vector3f.getX(), (double) vector3f.getY(), (double) vector3f.getZ(),
						velocity, inaccuracy);
			}

			crossbow.damageItem(flag ? 3 : 1, shooter, (p_220017_1_) -> {
				p_220017_1_.sendBreakAnimation(handIn);
			});
			worldIn.addEntity((Entity) iprojectile);
			worldIn.playSound((PlayerEntity) null, shooter.getPosX(), shooter.getPosY(), shooter.getPosZ(),
					SoundEvents.ITEM_CROSSBOW_SHOOT, SoundCategory.PLAYERS, 1.0F, soundPitch);
		}
	}

	public static boolean hasAmmo(LivingEntity entityIn, ItemStack stack) {
		int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.MULTISHOT, stack);
		int j = i == 0 ? 1 : 3;
		boolean flag = entityIn instanceof PlayerEntity && ((PlayerEntity) entityIn).abilities.isCreativeMode;
		ItemStack itemstack = entityIn.findAmmo(stack);
		ItemStack itemstack1 = itemstack.copy();

		for (int k = 0; k < j; ++k) {
			if (k > 0) {
				itemstack = itemstack1.copy();
			}
			if (itemstack.isEmpty() && flag) {
				itemstack = new ItemStack(DoomItems.ARGENT_BOLT.get());
				itemstack1 = itemstack.copy();
			}

			if (!func_220023_a(entityIn, stack, itemstack, k > 0, flag)) {
				return false;
			}
		}

		return true;
	}

	private static boolean func_220023_a(LivingEntity p_220023_0_, ItemStack p_220023_1_, ItemStack p_220023_2_,
			boolean p_220023_3_, boolean p_220023_4_) {
		if (p_220023_2_.isEmpty()) {
			return false;
		} else {
			boolean flag = p_220023_4_ && p_220023_2_.getItem() instanceof ArgentBolt;
			ItemStack itemstack;
			if (!flag && !p_220023_4_ && !p_220023_3_) {
				itemstack = p_220023_2_.split(1);
				if (p_220023_2_.isEmpty() && p_220023_0_ instanceof PlayerEntity) {
					((PlayerEntity) p_220023_0_).inventory.deleteStack(p_220023_2_);
				}
			} else {
				itemstack = p_220023_2_.copy();
			}

			addChargedProjectile(p_220023_1_, itemstack);
			return true;
		}
	}

	private static void addChargedProjectile(ItemStack crossbow, ItemStack projectile) {
		CompoundNBT compoundnbt = crossbow.getOrCreateTag();
		ListNBT listnbt;
		if (compoundnbt.contains("ChargedProjectiles", 9)) {
			listnbt = compoundnbt.getList("ChargedProjectiles", 10);
		} else {
			listnbt = new ListNBT();
		}

		CompoundNBT compoundnbt1 = new CompoundNBT();
		projectile.write(compoundnbt1);
		listnbt.add(compoundnbt1);
		compoundnbt.put("ChargedProjectiles", listnbt);
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		int i = this.getUseDuration(stack) - timeLeft;
		float f = getCharge(i, stack);
		if (f >= 1.0F && !isCharged(stack) && hasAmmo(entityLiving, stack)) {
			setCharged(stack, true);
			SoundCategory soundcategory = entityLiving instanceof PlayerEntity ? SoundCategory.PLAYERS
					: SoundCategory.HOSTILE;
			worldIn.playSound((PlayerEntity) null, entityLiving.getPosX(), entityLiving.getPosY(),
					entityLiving.getPosZ(), ModSoundEvents.LOADING_END.get(), soundcategory, 1.0F,
					1.0F / (random.nextFloat() * 0.5F + 1.0F) + 0.2F);
		}

	}

	public static float getCharge(int useTime, ItemStack stack) {
		float f = (float) useTime / (float) getChargeTime(stack);
		if (f > 1.0F) {
			f = 1.0F;
		}

		return f;
	}

	public static boolean isCharged(ItemStack stack) {
		CompoundNBT compoundnbt = stack.getTag();
		return compoundnbt != null && compoundnbt.getBoolean("Charged");
	}

	public static void setCharged(ItemStack stack, boolean chargedIn) {
		CompoundNBT compoundnbt = stack.getOrCreateTag();
		compoundnbt.putBoolean("Charged", chargedIn);
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.CROSSBOW;
	}

	private static float func_220013_l(ItemStack p_220013_0_) {
		return p_220013_0_.getItem() == DoomItems.BALLISTA.get()
				&& hasChargedProjectile(p_220013_0_, Items.FIREWORK_ROCKET) ? 1.6F : 3.15F;
	}

	public SoundEvent getSoundEvent(int enchantmentLevel) {
		switch (enchantmentLevel) {
		case 1:
			return ModSoundEvents.QUICK1_1.get();
		case 2:
			return ModSoundEvents.QUICK2_1.get();
		case 3:
			return ModSoundEvents.QUICK3_1.get();
		default:
			return ModSoundEvents.LOADING_START.get();
		}
	}

	@Override
	public int func_230305_d_() {
		return 15;
	}
}