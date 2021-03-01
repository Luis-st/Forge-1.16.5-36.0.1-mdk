package net.luis.cave.common.inventory.container;

import javax.annotation.Nullable;

import net.luis.cave.init.util.ModContainerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.potion.Effect;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntArray;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModBeaconContainer extends Container {
	
	private final IInventory tileBeacon = new Inventory(1) {
		@Override
		public boolean isItemValidForSlot(int index, ItemStack stack) {
			return stack.getItem().isIn(ItemTags.BEACON_PAYMENT_ITEMS);
		}
		
		@Override
		public int getInventoryStackLimit() {
			return 1;
		}
	};
	private final ModBeaconContainer.BeaconSlot beaconSlot;
	private final IWorldPosCallable worldPosCallable;
	private final IIntArray field_216972_f;

	public ModBeaconContainer(int id, IInventory p_i50099_2_, PacketBuffer extraData) {
		
		this(id, p_i50099_2_, new IntArray(3), IWorldPosCallable.DUMMY);
		
	}

	public ModBeaconContainer(int id, IInventory inventory, IIntArray p_i50100_3_, IWorldPosCallable worldPosCallable) {
		
		super(ModContainerType.BEACON.get(), id);
		assertIntArraySize(p_i50100_3_, 3);
		this.field_216972_f = p_i50100_3_;
		this.worldPosCallable = worldPosCallable;
		this.beaconSlot = new ModBeaconContainer.BeaconSlot(this.tileBeacon, 0, 136, 110);
		this.addSlot(this.beaconSlot);
		this.trackIntArray(p_i50100_3_);

		for (int k = 0; k < 3; ++k) {
			
			for (int l = 0; l < 9; ++l) {
				
				this.addSlot(new Slot(inventory, l + k * 9 + 9, 36 + l * 18, 137 + k * 18));
				
			}
			
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			
			this.addSlot(new Slot(inventory, i1, 36 + i1 * 18, 195));
			
		}

	}

	@Override
	public void onContainerClosed(PlayerEntity playerIn) {
		
		super.onContainerClosed(playerIn);
		
		if (!playerIn.world.isRemote) {
			
			ItemStack itemstack = this.beaconSlot.decrStackSize(this.beaconSlot.getSlotStackLimit());
			
			if (!itemstack.isEmpty()) {
				
				playerIn.dropItem(itemstack, false);
				
			}

		}
		
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return true;
		
	}
	
	@Override
	public void updateProgressBar(int id, int data) {
		
		super.updateProgressBar(id, data);
		this.detectAndSendChanges();
		
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack()) {
			
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (index == 0) {
				
				if (!this.mergeItemStack(itemstack1, 1, 37, true)) {
					
					return ItemStack.EMPTY;
					
				}

				slot.onSlotChange(itemstack1, itemstack);
				
			} else if (this.mergeItemStack(itemstack1, 0, 1, false)) { 
																		
				return ItemStack.EMPTY;
				
			} else if (index >= 1 && index < 28) {
				
				if (!this.mergeItemStack(itemstack1, 28, 37, false)) {
					
					return ItemStack.EMPTY;
					
				}
			} else if (index >= 28 && index < 37) {
				
				if (!this.mergeItemStack(itemstack1, 1, 28, false)) {
					
					return ItemStack.EMPTY;
					
				}
				
			} else if (!this.mergeItemStack(itemstack1, 1, 37, false)) {
				
				return ItemStack.EMPTY;
				
			}

			if (itemstack1.isEmpty()) {
				
				slot.putStack(ItemStack.EMPTY);
				
			} else {
				
				slot.onSlotChanged();
				
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				
				return ItemStack.EMPTY;
				
			}

			slot.onTake(playerIn, itemstack1);
			
		}

		return itemstack;
		
	}

	@OnlyIn(Dist.CLIENT)
	public int func_216969_e() {
		
		return this.field_216972_f.get(0);
		
	}

	@Nullable
	@OnlyIn(Dist.CLIENT)
	public Effect func_216967_f() {
		
		return Effect.get(this.field_216972_f.get(1));
		
	}

	@Nullable
	@OnlyIn(Dist.CLIENT)
	public Effect func_216968_g() {
		
		return Effect.get(this.field_216972_f.get(2));
		
	}
	
	public void func_216966_c(int p_216966_1_, int p_216966_2_) {
		
		if (this.beaconSlot.getHasStack()) {
			
			this.field_216972_f.set(1, p_216966_1_);
			this.field_216972_f.set(2, p_216966_2_);
			this.beaconSlot.decrStackSize(1);
			
		}

	}

	@OnlyIn(Dist.CLIENT)
	public boolean func_216970_h() {
		
		return !this.tileBeacon.getStackInSlot(0).isEmpty();
		
	}

	public IWorldPosCallable getWorldPosCallable() {
		
		return worldPosCallable;
		
	}

	class BeaconSlot extends Slot {
		
		public BeaconSlot(IInventory inventoryIn, int index, int xIn, int yIn) {
			
			super(inventoryIn, index, xIn, yIn);
			
		}

		@Override
		public boolean isItemValid(ItemStack stack) {
			
			return stack.getItem().isIn(ItemTags.BEACON_PAYMENT_ITEMS);
			
		}

		@Override
		public int getSlotStackLimit() {
			
			return 1;
			
		}
		
	}
	
}
