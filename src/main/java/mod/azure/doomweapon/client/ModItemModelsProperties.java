package mod.azure.doomweapon.client;

import mod.azure.doomweapon.item.weapons.SuperShotgun;
import mod.azure.doomweapon.util.registry.DoomItems;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ModItemModelsProperties {

	public ModItemModelsProperties() {
		// SuperShotGun
		ItemModelsProperties.func_239418_a_(DoomItems.SSG.get(), new ResourceLocation("pull"),
				(p_239427_0_, p_239427_1_, p_239427_2_) -> {
					if (p_239427_2_ == null) {
						return 0.0F;
					} else {
						return SuperShotgun.isCharged(p_239427_0_) ? 0.0F
								: (float) (p_239427_0_.getUseDuration() - p_239427_2_.getItemInUseCount())
										/ (float) SuperShotgun.getChargeTime(p_239427_0_);
					}
				});
		ItemModelsProperties.func_239418_a_(DoomItems.SSG.get(), new ResourceLocation("pulling"),
				(p_239426_0_, p_239426_1_, p_239426_2_) -> {
					return p_239426_2_ != null && p_239426_2_.isHandActive()
							&& p_239426_2_.getActiveItemStack() == p_239426_0_ && !SuperShotgun.isCharged(p_239426_0_)
									? 1.0F
									: 0.0F;
				});
		ItemModelsProperties.func_239418_a_(DoomItems.SSG.get(), new ResourceLocation("charged"),
				(p_239425_0_, p_239425_1_, p_239425_2_) -> {
					return p_239425_2_ != null && SuperShotgun.isCharged(p_239425_0_) ? 1.0F : 0.0F;
				});
		// ShotGun
		ItemModelsProperties.func_239418_a_(DoomItems.SG.get(), new ResourceLocation("pull"),
				(p_239429_0_, p_239429_1_, p_239429_2_) -> {
					if (p_239429_2_ == null) {
						return 0.0F;
					} else {
						return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F
								: (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
					}
				});
		ItemModelsProperties.func_239418_a_(DoomItems.SG.get(), new ResourceLocation("pulling"),
				(p_239428_0_, p_239428_1_, p_239428_2_) -> {
					return p_239428_2_ != null && p_239428_2_.isHandActive()
							&& p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
				});
		// BFG
		ItemModelsProperties.func_239418_a_(DoomItems.BFG.get(), new ResourceLocation("pull"),
				(p_239429_0_, p_239429_1_, p_239429_2_) -> {
					if (p_239429_2_ == null) {
						return 0.0F;
					} else {
						return p_239429_2_.getActiveItemStack() != p_239429_0_ ? 0.0F
								: (float) (p_239429_0_.getUseDuration() - p_239429_2_.getItemInUseCount()) / 20.0F;
					}
				});
		ItemModelsProperties.func_239418_a_(DoomItems.BFG.get(), new ResourceLocation("pulling"),
				(p_239428_0_, p_239428_1_, p_239428_2_) -> {
					return p_239428_2_ != null && p_239428_2_.isHandActive()
							&& p_239428_2_.getActiveItemStack() == p_239428_0_ ? 1.0F : 0.0F;
				});
		// Crucible
		ItemModelsProperties.func_239418_a_(DoomItems.CRUCIBLESWORD.get(), new ResourceLocation("broken"),
				(p_210312_0_, p_210312_1_, p_210312_2_) -> {
					return isUsable(p_210312_0_) ? 0.0F : 1.0F;
				});
		// Marauder Axe
		ItemModelsProperties.func_239418_a_(DoomItems.AXE_OPEN.get(), new ResourceLocation("broken"),
				(p_210312_0_, p_210312_1_, p_210312_2_) -> {
					return isUsable(p_210312_0_) ? 0.0F : 1.0F;
				});
	}

	public static boolean isUsable(ItemStack stack) {
		return stack.getDamage() < stack.getMaxDamage() - 1;
	}
}