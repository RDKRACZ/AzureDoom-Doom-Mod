package mod.azure.doom.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

@Mixin(Ingredient.class)
public interface IngredientAccess {
	@Accessor("itemStacks")
	ItemStack[] getMatchingStacks();
}
