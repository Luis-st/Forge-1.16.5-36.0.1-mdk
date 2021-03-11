package net.luis.cave.common.inventory.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.BeaconContainer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntArray;

public class ModBeaconContainer extends BeaconContainer {
	
	public ModBeaconContainer(int id, IInventory p_i50099_2_, PacketBuffer extraData) {
		
		this(id, p_i50099_2_, new IntArray(3), IWorldPosCallable.DUMMY);
		
	}

	public ModBeaconContainer(int id, IInventory inventory, IIntArray p_i50100_3_, IWorldPosCallable worldPosCallable) {
		
		super(id, inventory, p_i50100_3_, worldPosCallable);
		
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return true;
		
	}
	
}