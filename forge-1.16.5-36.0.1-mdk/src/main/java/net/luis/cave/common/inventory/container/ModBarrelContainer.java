package net.luis.cave.common.inventory.container;

import java.lang.reflect.Field;
import java.util.List;

import net.luis.cave.init.util.ModContainerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class ModBarrelContainer extends Container {
	
	private static final Field yPos = ObfuscationReflectionHelper.findField(Slot.class, "field_75221_f");
	
	public ModBarrelContainer(int id, PlayerInventory playerInventoryIn, PacketBuffer extraData) {
		
		this(id, playerInventoryIn, new Inventory(29 * 8));
		
	}
	
	public ModBarrelContainer(int id, PlayerInventory playerInventoryIn, IInventory inventory) {
		
		super(ModContainerType.BARREL.get(), id);
		int i = 54;
		
		// TODO: edit index calc
		
		for (int j = 0; j < 7; ++j) {
			
			for (int k = 0; k < 8; ++k) {
				
				this.addSlot(new Slot(inventory, k + j * 8, 8 + k * 18, (18 + j * 18)));
				
			}
			
		}
		
		for (int j = 0; j < 22; ++j) {
			
			for (int k = 0; k < 8; ++k) {
				
				this.addSlot(new Slot(inventory, 56 + (k + j * 8), 8 + k * 18, -1000 - (18 + j * 18)));
				
			}
			
		}
		
		for (int l = 0; l < 3; ++l) {
			
			for (int j1 = 0; j1 < 9; ++j1) {
				
				this.addSlot(new Slot(playerInventoryIn, j1 + l * 9 + 9, 8 + j1 * 18, 104 + l * 18 + i));
				
			}
			
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			
			this.addSlot(new Slot(playerInventoryIn, i1, 8 + i1 * 18, 162 + i));
			
		}
		
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return true;
		
	}

	public void moveSlots() {
		
		List<Slot> slots = this.inventorySlots;
		
		
		for (Slot slot : slots) {
			
			slot.getStack();
			
		}
		
	}
	
	@SuppressWarnings("unused")
	private void setSlotPosY(Slot slot, int newPosY) {
		
		try {
			
			yPos.setInt(slot, newPosY);
			
		} catch (IllegalArgumentException | IllegalAccessException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
