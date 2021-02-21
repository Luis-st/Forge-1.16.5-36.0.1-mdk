package net.luis.cave.common.container.chest;

import net.luis.cave.init.ModCapability;
import net.luis.cave.init.util.ModContainerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class ModEnderChestContainer extends Container {
	
	public ModEnderChestContainer(int id, PlayerInventory playerInventory, PacketBuffer extraData) {
		
		super(ModContainerType.ENDER_CHEST.get(), id);
		PlayerEntity player = playerInventory.player;
		IItemHandlerModifiable itemHandlerModifiable = player.getCapability(ModCapability.CAPABILITY, null)
				.orElseThrow(() -> new NullPointerException("The mod Capability<IModItemHandler> is null"));
		int i = (6 - 4) * 18;
		
		for (int j = 0; j < 6; ++j) {

			for (int k = 0; k < 9; ++k) {

				this.addSlot(new SlotItemHandler(itemHandlerModifiable, k + j * 9, 8 + k * 18, (j * 18) - 9));

			}

		}

		for (int l = 0; l < 3; ++l) {
			
			for (int j1 = 0; j1 < 9; ++j1) {
				
				this.addSlot(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, (103 + l * 18 + i) - 27));
				
			}
			
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			
			this.addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, 134 + i));
			
		}
		
	}

	public ModEnderChestContainer(int id, PlayerInventory playerInventory, IItemHandlerModifiable itemHandlerModifiable) {
		
		// TODO: fix
		
		super(ModContainerType.ENDER_CHEST.get(), id);
		int i = (6 - 4) * 18;
		
		for (int j = 0; j < 6; ++j) {

			for (int k = 0; k < 9; ++k) {

				this.addSlot(new SlotItemHandler(itemHandlerModifiable, k + j * 9, 8 + k * 18, (j * 18) - 9));

			}

		}

		for (int l = 0; l < 3; ++l) {
			
			for (int j1 = 0; j1 < 9; ++j1) {
				
				this.addSlot(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, (103 + l * 18 + i) - 27));
				
			}
			
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			
			this.addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, 134 + i));
			
		}

	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack()) {
			
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (index < 6 * 9) {
				
				if (!this.mergeItemStack(itemstack1, 6 * 9, this.inventorySlots.size(), true)) {
					
					return ItemStack.EMPTY;
					
				}
				
			} else if (!this.mergeItemStack(itemstack1, 0, 6 * 9, false)) {
				
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
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return true;
		
	}

}
