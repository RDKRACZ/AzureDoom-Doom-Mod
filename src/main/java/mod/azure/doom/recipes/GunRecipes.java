package mod.azure.doom.recipes;

import mod.azure.doom.client.gui.GunTableInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;

public interface GunRecipes extends IRecipe<GunTableInventory> {
	default IRecipeType<?> getType() {
		return IRecipeType.CRAFTING;
	}
}