package net.luis.cave.common.inventory.container;

import net.luis.cave.init.util.ModContainerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

public class ModChestContainer25x8 extends Container {
	
	private static int rows = 8;
	private static int size = 25;

	public ModChestContainer25x8(int id, PlayerInventory playerInventoryIn, PacketBuffer extraData) {
		
		this(ModContainerType.GENERIC_25X8.get(), id, playerInventoryIn, new Inventory(size * rows));
		
	}
	
	public ModChestContainer25x8(ContainerType<?> type, int id, PlayerInventory playerInventoryIn, IInventory inventory) {
		
		super(type, id);
		assertInventorySize(inventory, rows * size);
		inventory.openInventory(playerInventoryIn.player);
		int i = (rows - 4) * 18;
		int k1 = (-(((size - 9) / 2) * 18)) + 8;
		
		for (int j = 0; j < rows; ++j) {
			
			for (int k = 0; k < size; ++k) {
				
				this.addSlot(new Slot(inventory, k + j * size, (k * 18) + k1, 18 + j * 18));
				
			}
			
		}

		for (int l = 0; l < 3; ++l) {
			
			for (int j1 = 0; j1 < 9; ++j1) {
				
				this.addSlot(new Slot(playerInventoryIn, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
				
			}
			
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			
			this.addSlot(new Slot(playerInventoryIn, i1, 8 + i1 * 18, 161 + i));
			
		}
		
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return true;
		
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack()) {
			
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (index < rows * size) {
				
				if (!this.mergeItemStack(itemstack1, rows * size, this.inventorySlots.size(), true)) {
					
					return ItemStack.EMPTY;
					
				}
				
			} else if (!this.mergeItemStack(itemstack1, 0, rows * size, false)) {
				
				return ItemStack.EMPTY;
				
			}

			if (itemstack1.isEmpty()) {
				
				slot.putStack(ItemStack.EMPTY);
				
			} else {
				
				slot.onSlotChanged();
				
			}
			
		}

		return itemstack;
		
	}

}
