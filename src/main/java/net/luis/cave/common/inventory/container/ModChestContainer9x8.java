package net.luis.cave.common.inventory.container;

import net.luis.cave.init.util.ModContainerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.network.PacketBuffer;

public class ModChestContainer9x8 extends ChestContainer {

	public ModChestContainer9x8(int id, PlayerInventory playerInventoryIn, IInventory p_i50092_4_) {
		
		super(ModContainerType.GENERIC_9X8.get(), id, playerInventoryIn, p_i50092_4_, 8);
		
	}
	
	public ModChestContainer9x8(int id, PlayerInventory playerInventoryIn, PacketBuffer extraData) {
		
		super(ModContainerType.GENERIC_9X8.get(), id, playerInventoryIn, new Inventory(9 * 8), 8);
		
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return true;
		
	}

}
