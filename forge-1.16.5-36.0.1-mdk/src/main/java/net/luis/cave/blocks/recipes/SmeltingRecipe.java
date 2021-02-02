package net.luis.cave.blocks.recipes;

import net.luis.cave.init.CaveRecipe;
import net.luis.cave.init.blocks.CaveBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class SmeltingRecipe extends AbstractCookingRecipe {

	public SmeltingRecipe(ResourceLocation idIn, String groupIn, Ingredient ingredientIn, ItemStack resultIn, float experienceIn, int cookTimeIn) {
		
		super(IRecipeType.register("cave_smelting"), idIn, groupIn, ingredientIn, resultIn, experienceIn, cookTimeIn);
		
	}
	
	@Override
	public ItemStack getIcon() {
		
		return new ItemStack(CaveBlocks.SMELTING_FURNACE.get());
		
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		
		return CaveRecipe.SMELTING_RECIPE.get();
		
	}

}
