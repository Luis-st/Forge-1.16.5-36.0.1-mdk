package net.luis.cave.common.container;

import net.luis.cave.init.util.ModContainer;
import net.luis.cave.init.util.ModRecipeType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.util.IIntArray;

public class SmeltingContainer extends AbstractFurnaceContainer {
	
	public SmeltingContainer(int id, PlayerInventory playerInventory, IInventory inventory, IIntArray array) {
		
		super(ModContainer.SMELTING_CONTAINER.get(), ModRecipeType.SMELTING_RECIPE, RecipeBookCategory.FURNACE, id, playerInventory, inventory, array);
		
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return true;
		
	}

}