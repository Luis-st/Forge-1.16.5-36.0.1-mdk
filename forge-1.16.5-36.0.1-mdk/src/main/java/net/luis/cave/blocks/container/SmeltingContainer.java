package net.luis.cave.blocks.container;

import net.luis.cave.init.CaveContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.AbstractFurnaceContainer;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.network.PacketBuffer;

public class SmeltingContainer extends AbstractFurnaceContainer {

	public SmeltingContainer(int id, PlayerInventory playerInventory, PacketBuffer extraData) {
		
		super(CaveContainer.SMELTING_CONTAINER.get(), null, RecipeBookCategory.FURNACE, id, playerInventory);
		
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return true;
		
	}

}
