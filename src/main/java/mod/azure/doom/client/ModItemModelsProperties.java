package mod.azure.doom.client;

import mod.azure.doom.item.weapons.Ballista;
import mod.azure.doom.item.weapons.SuperShotgun;
import mod.azure.doom.util.registry.DoomItems;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;

public class ModItemModelsProperties {

	public ModItemModelsProperties() {
		// SuperShotGun
		ItemModelsProperties.registerProperty(DoomItems.SSG.get(), new ResourceLocation("pull"),
				(p_239427_0_, p_239427_1_, p_239427_2_) -> {
					if (p_239427_2_ == null) {
						return 0.0F;
					} else {
						return SuperShotgun.isCharged(p_239427_0_) ? 0.0F
								: (float) (p_239427_0_.getUseDuration() - p_239427_2_.getItemInUseCount())
										/ (float) SuperShotgun.getChargeTime(p_239427_0_);
					}
				});
		ItemModelsProperties.registerProperty(DoomItems.SSG.get(), new ResourceLocation("pulling"),
				(p_239426_0_, p_239426_1_, p_239426_2_) -> {
					return p_239426_2_ != null && p_239426_2_.isHandActive()
							&& p_239426_2_.getActiveItemStack() == p_239426_0_ 
									? 1.0F
									: 0.0F;
				});
		ItemModelsProperties.registerProperty(DoomItems.SSG.get(), new ResourceLocation("charged"),
				(p_239425_0_, p_239425_1_, p_239425_2_) -> {
					return p_239425_2_ != null && SuperShotgun.isCharged(p_239425_0_) ? 1.0F : 0.0F;
				});
		// Ballista
		ItemModelsProperties.registerProperty(DoomItems.BALLISTA.get(), new ResourceLocation("pull"),
				(itemStack, clientWorld, livingEntity) -> {
					if (livingEntity == null) {
						return 0.0F;
					} else {
						return Ballista.isCharged(itemStack) ? 0.0F
								: (float) (itemStack.getUseDuration() - livingEntity.getItemInUseMaxCount())
										/ (float) Ballista.getChargeTime(itemStack);
					}
				});
		ItemModelsProperties.registerProperty(DoomItems.BALLISTA.get(), new ResourceLocation("pulling"),
				(itemStack, clientWorld, livingEntity) -> {
					return livingEntity != null && livingEntity.isHandActive()
							&& livingEntity.getActiveItemStack() == itemStack && !Ballista.isCharged(itemStack)
									? 1.0F
									: 0.0F;
				});
		ItemModelsProperties.registerProperty(DoomItems.BALLISTA.get(), new ResourceLocation("charged"),
				(itemStack, clientWorld, livingEntity) -> {
					return livingEntity != null && Ballista.isCharged(itemStack) ? 1.0F : 0.0F;
				});
		ItemModelsProperties.registerProperty(DoomItems.BALLISTA.get(), new ResourceLocation("firework"),
				(itemStack, clientWorld, livingEntity) -> {
					return livingEntity != null && Ballista.isCharged(itemStack)
							&& Ballista.hasChargedProjectile(itemStack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
				});
		// ShotGun
		ItemModelsProperties.registerProperty(DoomItems.SG.get(), new ResourceLocation("pull"),
				(p_239429_0_, p_239429_1_, p_239429_2_) -> {
					if (p_239429_2_ == null) {
						return 0.0F;
					} else {
						return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F
								: (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
					}
				});
		ItemModelsProperties.registerProperty(DoomItems.SG.get(), new ResourceLocation("pulling"),
				(p_239428_0_, p_239428_1_, p_239428_2_) -> {
					return p_239428_2_ != null && p_239428_2_.isHandActive()
							&& p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
				});
		// Crucible
		ItemModelsProperties.registerProperty(DoomItems.CRUCIBLESWORD.get(), new ResourceLocation("broken"),
				(p_210312_0_, p_210312_1_, p_210312_2_) -> {
					return isUsable(p_210312_0_) ? 0.0F : 1.0F;
				});
		// Marauder Axe
		ItemModelsProperties.registerProperty(DoomItems.AXE_OPEN.get(), new ResourceLocation("broken"),
				(p_210312_0_, p_210312_1_, p_210312_2_) -> {
					return isUsable(p_210312_0_) ? 0.0F : 1.0F;
				});
		// Plasma Gun
		ItemModelsProperties.registerProperty(DoomItems.PLASMAGUN.get(), new ResourceLocation("pull"),
				(p_239429_0_, p_239429_1_, p_239429_2_) -> {
					if (p_239429_2_ == null) {
						return 0.0F;
					} else {
						return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F
								: (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
					}
				});
		ItemModelsProperties.registerProperty(DoomItems.PLASMAGUN.get(), new ResourceLocation("pulling"),
				(p_239428_0_, p_239428_1_, p_239428_2_) -> {
					return p_239428_2_ != null && p_239428_2_.isHandActive()
							&& p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
				});
	}

	public static boolean isUsable(ItemStack stack) {
		return stack.getDamage() < stack.getMaxDamage() - 1;
	}
}