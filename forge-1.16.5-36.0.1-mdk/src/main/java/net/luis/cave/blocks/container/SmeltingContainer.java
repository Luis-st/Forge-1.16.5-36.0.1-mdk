package net.luis.cave.blocks.container;

import net.luis.cave.init.CaveContainer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.util.IIntArray;

public class SmeltingContainer extends AbstractFurnaceContainer {

	public SmeltingContainer(int id, PlayerInventory playerInventory, IInventory furnaceInventoryIn, IIntArray p_i241922_7_) {
		
		super(CaveContainer.SMELTING_CONTAINER.get(), null, RecipeBookCategory.FURNACE, id, playerInventory, furnaceInventoryIn, p_i241922_7_);
		
	}

}
