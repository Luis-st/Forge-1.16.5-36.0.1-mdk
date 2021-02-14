package net.luis.cave.common.container;

import net.luis.cave.init.util.ModContainerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ShulkerBoxSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;

public class ModShulkerBoxContainer extends Container {

	private final IInventory inventory;

	public ModShulkerBoxContainer(int id, PlayerInventory playerInventory, PacketBuffer extraData) {

		this(id, playerInventory, new Inventory(54));

	}

	public ModShulkerBoxContainer(int id, PlayerInventory playerInventory, IInventory inventory) {

		super(ModContainerType.SHULKER_BOX_CONTAINER.get(), id);
		assertInventorySize(inventory, 54);
		this.inventory = inventory;
		inventory.openInventory(playerInventory.player);
		int i = (6 - 4) * 18;

		for (int j = 0; j < 6; ++j) {
			
			for (int k = 0; k < 9; ++k) {
				
				this.addSlot(new ShulkerBoxSlot(inventory, k + j * 9, 8 + k * 18, 18 + j * 18));
				
			}
			
		}
		
		for (int l = 0; l < 3; ++l) {
			
			for (int j1 = 0; j1 < 9; ++j1) {
				
				this.addSlot(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
				
			}
			
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			
			this.addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, 161 + i));
			
		}

	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return this.inventory.isUsableByPlayer(playerIn);
		
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack()) {
			
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (index < this.inventory.getSizeInventory()) {
				
				if (!this.mergeItemStack(itemstack1, this.inventory.getSizeInventory(), this.inventorySlots.size(), true)) {
					
					return ItemStack.EMPTY;
					
				}
				
			} else if (!this.mergeItemStack(itemstack1, 0, this.inventory.getSizeInventory(), false)) {
				
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

	@Override
	public void onContainerClosed(PlayerEntity playerIn) {
		
		super.onContainerClosed(playerIn);
		this.inventory.closeInventory(playerIn);
		
	}
	
}
