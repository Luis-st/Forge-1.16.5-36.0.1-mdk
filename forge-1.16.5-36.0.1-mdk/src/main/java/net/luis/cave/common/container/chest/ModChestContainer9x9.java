package net.luis.cave.common.container.chest;

import net.luis.cave.init.util.ModContainerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.network.PacketBuffer;

public class ModChestContainer9x9 extends ChestContainer {

	public ModChestContainer9x9(int id, PlayerInventory playerInventoryIn, IInventory p_i50092_4_) {
		
		super(ModContainerType.GENERIC_9X9.get(), id, playerInventoryIn, p_i50092_4_, 9);
		
	}
	
	public ModChestContainer9x9(int id, PlayerInventory playerInventoryIn, PacketBuffer extraData) {
		
		super(ModContainerType.GENERIC_9X9.get(), id, playerInventoryIn, new Inventory(9 * 9), 9);
		
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return true;
		
	}

}
