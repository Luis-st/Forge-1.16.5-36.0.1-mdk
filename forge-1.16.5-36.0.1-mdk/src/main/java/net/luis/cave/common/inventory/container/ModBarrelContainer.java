package net.luis.cave.common.inventory.container;

import net.luis.cave.init.util.ModContainerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;

public class ModBarrelContainer extends Container {

	
	public ModBarrelContainer(int id, PlayerInventory playerInventoryIn, PacketBuffer extraData) {
		
		this(id, playerInventoryIn, new Inventory(1));
		
	}
	
	public ModBarrelContainer(int id, PlayerInventory playerInventoryIn, IInventory inventory) {
		
		super(ModContainerType.BARREL.get(), id);
		
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return true;
		
	}

}
