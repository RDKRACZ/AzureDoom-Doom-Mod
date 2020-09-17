package mod.azure.doom.item.powerup;

import java.util.List;

import mod.azure.doom.DoomMod;
import mod.azure.doom.util.PMMOCompat;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;

public class InvisibleSphereItem extends Item {

	public InvisibleSphereItem() {
		super(new Item.Properties().group(DoomMod.DoomPowerUPItemGroup).maxStackSize(1));
	}

	@Override
	public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
		if (livingEntityIn instanceof ServerPlayerEntity) {
			ServerPlayerEntity playerentity = (ServerPlayerEntity) livingEntityIn;
			if (!worldIn.isRemote) {
				livingEntityIn.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, 1200, 1));
				if (ModList.get().isLoaded("pmmo")) {
					PMMOCompat.awardInvisibleXp(playerentity);
				}
				if (!playerentity.abilities.isCreativeMode) {
					stack.shrink(1);
					if (stack.isEmpty()) {
						playerentity.inventory.deleteStack(stack);
					}
				}
			}
		}
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 7000;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.NONE;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		playerIn.setActiveHand(handIn);
		return ActionResult.resultConsume(itemstack);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("doom.invisible.text").mergeStyle(TextFormatting.ITALIC));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

}