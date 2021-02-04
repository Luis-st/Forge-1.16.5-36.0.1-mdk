package net.luis.cave.init;

import net.luis.cave.blocks.recipes.SmeltingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;

public class CaveRecipe {

	public static final IRecipeSerializer<?> CAVE_SMELTING = IRecipeSerializer.register("cave_smelting", new SmeltingRecipe.Serializer());
	
	

}
