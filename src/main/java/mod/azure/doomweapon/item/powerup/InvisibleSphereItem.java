package mod.azure.doomweapon.item.powerup;

import java.util.List;

import mod.azure.doomweapon.DoomMod;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class InvisibleSphereItem extends Item {

	public InvisibleSphereItem() {
		super(new Item.Properties().group(DoomMod.DoomItemGroup).maxStackSize(1));
	}

	public ItemStack getDefaultInstance() {
		return PotionUtils.addPotionToItemStack(super.getDefaultInstance(), Potions.INVISIBILITY);
	}

	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity) entityLiving : null;
		if (playerentity instanceof ServerPlayerEntity) {
			CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity) playerentity, stack);
		}

		if (!worldIn.isRemote) {
			for (EffectInstance effectinstance : PotionUtils.getEffectsFromStack(stack)) {
				if (effectinstance.getPotion().isInstant()) {
					effectinstance.getPotion().affectEntity(playerentity, playerentity, entityLiving,
							effectinstance.getAmplifier(), 1.0D);
				} else {
					entityLiving.addPotionEffect(new EffectInstance(Effects.INVISIBILITY));
				}
			}
		}

		return stack;
	}

	public int getUseDuration(ItemStack stack) {
		return 1;
	}

	public UseAction getUseAction(ItemStack stack) {
		return UseAction.EAT;
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		playerIn.setActiveHand(handIn);
		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent("\u00A7o" + "Turns the user invisible for x amount of time."));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

	@Override
	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
		ItemStack stack = new ItemStack(this);
		stack.hasTag();
		if (group == DoomMod.DoomItemGroup) {
			items.add(stack);
		}
	}

	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		stack.hasTag();
		stack.addEnchantment(Enchantments.SMITE, 10);
	}

}