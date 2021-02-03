package net.luis.cave.init;

import net.luis.cave.Cave;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CaveRecipe {
	
	public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Cave.Mod_Id);
	
	
	public static final RegistryObject<IRecipeSerializer<?>> SMELTING_RECIPE = RECIPE_SERIALIZERS.register("smelting_recipe", 
			() -> CaveRecipeSerializer.CAVE_SMELTING);
	
}
