package mod.azure.doomweapon.item;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.util.registry.DoomItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import top.theillusivec4.curios.api.CuriosAPI;
import top.theillusivec4.curios.api.capability.CuriosCapability;
import top.theillusivec4.curios.api.capability.ICurio;

public class DaisyItem extends Item {

	public DaisyItem() {
		super(new Item.Properties().group(DoomMod.DoomPowerUPItemGroup).maxStackSize(1));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("doom.daisy1.text").applyTextStyle(TextFormatting.YELLOW)
				.applyTextStyle(TextFormatting.ITALIC));
		tooltip.add(new TranslationTextComponent("doom.daisy2.text").applyTextStyle(TextFormatting.ITALIC));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public ICapabilityProvider initCapabilities(final ItemStack stack, CompoundNBT unused) {
		ICurio curio = new ICurio() {
			@Override
			public boolean canRightClickEquip() {
				return true;
			}

			@Override
			public void onEquipped(String identifier, LivingEntity livingEntity) {
				if (livingEntity instanceof PlayerEntity) {
					startPowers((PlayerEntity) livingEntity);
				}
			}

			@Override
			public void onUnequipped(String identifier, LivingEntity livingEntity) {
				if (livingEntity instanceof PlayerEntity) {
					stopPowers((PlayerEntity) livingEntity);
				}
			}

			private void startPowers(PlayerEntity player) {
				player.addPotionEffect(new EffectInstance(Effects.SPEED, 10000000, 2));
			}

			private void stopPowers(PlayerEntity player) {
				player.removePotionEffect(Effects.SPEED);
			}

			@Override
			public void onCurioTick(String identifier, int index, LivingEntity livingEntity) {
				if (livingEntity instanceof PlayerEntity) {
					PlayerEntity player = ((PlayerEntity) livingEntity);
					startPowers(player);
				}
			}

			@Override
			public boolean canEquip(String identifier, LivingEntity entityLivingBase) {
				return !CuriosAPI.getCurioEquipped(DoomItems.DAISY.get(), entityLivingBase).isPresent();
			}
		};

		return new ICapabilityProvider() {
			private final LazyOptional<ICurio> curioOpt = LazyOptional.of(() -> curio);

			@Nonnull
			@Override
			public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {

				return CuriosCapability.ITEM.orEmpty(cap, curioOpt);
			}
		};
	}

	public static boolean isRingInCuriosSlot(ItemStack belt, LivingEntity player) {
		return CuriosAPI.getCurioEquipped(belt.getItem(), player).isPresent();
	}
}