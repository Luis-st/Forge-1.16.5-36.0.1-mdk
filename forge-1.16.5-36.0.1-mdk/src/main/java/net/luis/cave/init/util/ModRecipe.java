package net.luis.cave.init.util;

import net.luis.cave.common.recipe.SmeltingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;

public class ModRecipe {

	public static final IRecipeSerializer<?> CAVE_SMELTING = IRecipeSerializer.register("cave_smelting", new SmeltingRecipe.Serializer());
	
	

}
