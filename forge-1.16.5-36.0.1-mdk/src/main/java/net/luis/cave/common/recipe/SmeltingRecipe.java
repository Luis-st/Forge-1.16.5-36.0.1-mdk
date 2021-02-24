package net.luis.cave.common.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.luis.cave.init.blocks.ModBlocks;
import net.luis.cave.init.util.ModRecipeSerializer;
import net.luis.cave.init.util.ModRecipeType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class SmeltingRecipe extends AbstractCookingRecipe {
	
	public static int time;

	@SuppressWarnings("static-access")
	public SmeltingRecipe(ResourceLocation idIn, String groupIn, Ingredient ingredientIn, ItemStack resultIn, float experienceIn, int cookTimeIn) {

		super(ModRecipeType.SMELTING, idIn, groupIn, ingredientIn, resultIn, experienceIn, cookTimeIn);
		this.time = cookTimeIn;
	}

	@Override
	public ItemStack getIcon() {

		return new ItemStack(ModBlocks.SMELTING_FURNACE.get());

	}

	@Override
	public IRecipeSerializer<?> getSerializer() {

		return ModRecipeSerializer.SMELTING.get();

	}

	public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<SmeltingRecipe> {

		@Override
		@SuppressWarnings("deprecation")
		public SmeltingRecipe read(ResourceLocation recipeId, JsonObject json) {

			String s = JSONUtils.getString(json, "group", "");
			JsonElement jsonelement = (JsonElement) (JSONUtils.isJsonArray(json, "ingredient")
					? JSONUtils.getJsonArray(json, "ingredient")
					: JSONUtils.getJsonObject(json, "ingredient"));
			Ingredient ingredient = Ingredient.deserialize(jsonelement);
			ItemStack itemstack;

			if (!json.has("result")) {

				throw new JsonSyntaxException("Missing result, expected to find a string or object");

			}

			if (json.get("result").isJsonObject()) {

				itemstack = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));

			} else {

				String s1 = JSONUtils.getString(json, "result");
				ResourceLocation resourcelocation = new ResourceLocation(s1);
				itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() -> {

					return new IllegalStateException("Item: " + s1 + " does not exist");

				}));

			}

			float f = JSONUtils.getFloat(json, "experience", 0.0F);
			int i = JSONUtils.getInt(json, "cookingtime", SmeltingRecipe.time);
			return new SmeltingRecipe(recipeId, s, ingredient, itemstack, f, i);

		}

		@Override
		public SmeltingRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {

			String s = buffer.readString(32767);
			Ingredient ingredient = Ingredient.read(buffer);
			ItemStack itemstack = buffer.readItemStack();
			float f = buffer.readFloat();
			int i = buffer.readVarInt();
			return new SmeltingRecipe(recipeId, s, ingredient, itemstack, f, i);

		}

		@Override
		public void write(PacketBuffer buffer, SmeltingRecipe recipe) {

			buffer.writeString(recipe.group);
			recipe.ingredient.write(buffer);
			buffer.writeItemStack(recipe.result);
			buffer.writeFloat(recipe.experience);
			buffer.writeVarInt(recipe.cookTime);

		}

	}

}
