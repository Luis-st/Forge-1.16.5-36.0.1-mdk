package net.luis.cave.init.recipe;

import net.luis.cave.Cave;
import net.luis.cave.common.recipe.SmeltingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeSerializer {
	
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Cave.MOD_ID);
	
	
	public static final RegistryObject<IRecipeSerializer<?>> SMELTING = RECIPE_SERIALIZERS.register("cave_smelting", 
			() -> new SmeltingRecipe.Serializer());
	
}
