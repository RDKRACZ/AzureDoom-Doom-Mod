package mod.azure.doom.item.weapons;

import java.util.function.Predicate;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.render.weapons.SSGRender;
import mod.azure.doom.entity.projectiles.ShotgunShellEntity;
import mod.azure.doom.item.ammo.ShellAmmo;
import mod.azure.doom.util.registry.DoomItems;
import mod.azure.doom.util.registry.ModSoundEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.UseAction;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class SuperShotgun extends ShootableItem implements IAnimatable {

	public AnimationFactory factory = new AnimationFactory(this);
	private String controllerName = "controller";

	private <P extends ShootableItem & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
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

	public SuperShotgun() {
		super(new Item.Properties().group(DoomMod.DoomWeaponItemGroup).maxStackSize(1).maxDamage(9000)
				.setISTER(() -> SSGRender::new));
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

			int i = this.getUseDuration(stack) - timeLeft;
			i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, playerentity, i,
					!itemstack.isEmpty() || flag);
			if (i < 0)
				return;

			if (!itemstack.isEmpty() || flag) {
				if (itemstack.isEmpty()) {
					itemstack = new ItemStack(DoomItems.SHOTGUN_SHELLS.get());
				}

				float f = getArrowVelocity(i);
				if (!((double) f < 0.1D)) {
					boolean flag1 = playerentity.abilities.isCreativeMode || (itemstack.getItem() instanceof ShellAmmo
							&& ((ShellAmmo) itemstack.getItem()).isInfinite(itemstack, stack, playerentity));
					if (!worldIn.isRemote) {
						ShellAmmo arrowitem = (ShellAmmo) (itemstack.getItem() instanceof ShellAmmo
								? itemstack.getItem()
								: DoomItems.SHOTGUN_SHELLS.get());
						ShotgunShellEntity abstractarrowentity = arrowitem.createArrow(worldIn, itemstack,
								playerentity);
						abstractarrowentity = customeArrow(abstractarrowentity);
						abstractarrowentity.func_234612_a_(playerentity, playerentity.rotationPitch,
								playerentity.rotationYaw, 0.0F, 1.0F * 3.0F, 1.0F);

						ShotgunShellEntity abstractarrowentity1 = arrowitem.createArrow(worldIn, itemstack,
								playerentity);
						abstractarrowentity1 = customeArrow(abstractarrowentity1);
						abstractarrowentity1.func_234612_a_(playerentity, playerentity.rotationPitch + 30.0F,
								playerentity.rotationYaw + 30.0F, 0.0F, 1.0F * 3.0F, 1.0F);

						abstractarrowentity.setDamage(abstractarrowentity.getDamage() + 3);
						abstractarrowentity1.setDamage(abstractarrowentity1.getDamage() + 3);

						stack.damageItem(1, playerentity, (p_220009_1_) -> {
							p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
						});
						if (flag1 || playerentity.abilities.isCreativeMode
								&& (itemstack.getItem() == DoomItems.SHOTGUN_SHELLS.get()
										|| itemstack.getItem() == DoomItems.SHOTGUN_SHELLS.get())) {
							abstractarrowentity.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
							abstractarrowentity1.pickupStatus = AbstractArrowEntity.PickupStatus.DISALLOWED;
						}
						worldIn.addEntity(abstractarrowentity);
						worldIn.addEntity(abstractarrowentity1);
					}
					worldIn.playSound((PlayerEntity) null, playerentity.getPosX(), playerentity.getPosY(),
							playerentity.getPosZ(), ModSoundEvents.SHOTGUN_SHOOT.get(), SoundCategory.PLAYERS, 1.0F,
							1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
					if (!flag1 && !playerentity.abilities.isCreativeMode) {
						itemstack.shrink(2);
						if (itemstack.isEmpty()) {
							playerentity.inventory.deleteStack(itemstack);
						}
					}
					AnimationController<?> controller = GeckoLibUtil.getControllerForStack(this.factory, stack,
							controllerName);
					if (controller.getAnimationState() == AnimationState.Stopped) {
						controller.markNeedsReload();
						controller.setAnimation(new AnimationBuilder().addAnimation("firing", false));
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
		return UseAction.BLOCK;
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
		return itemStack -> itemStack.getItem() instanceof ShellAmmo;
	}

	public ShotgunShellEntity customeArrow(ShotgunShellEntity arrow) {
		return arrow;
	}

	@Override
	public int func_230305_d_() {
		return 15;
	}
}