package net.luis.cave.common.inventory.container;

import com.mojang.datafixers.util.Pair;

import net.luis.cave.init.capability.BackpackCapability;
import net.luis.cave.init.util.ModContainerType;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class BackpackContainer extends Container {
	
	public BackpackContainer(int id, PlayerInventory playerInventory, PacketBuffer extraData) {
		
		this(id, playerInventory);
		
	}
	
	public BackpackContainer(int id, PlayerInventory playerInventory) {
		
		super(ModContainerType.BACKPACK.get(), id);
		PlayerEntity player = playerInventory.player;
		IItemHandlerModifiable itemHandlerModifiable = player.getCapability(BackpackCapability.BACKPACK, null)
				.orElseThrow(() -> new NullPointerException("The mod Capability<IBackpackItemHandler> is null"));
		
		for (int j = 0; j < 4; ++j) {

			for (int k = 0; k < 9; ++k) {

				this.addSlot(new SlotItemHandler(itemHandlerModifiable, k + j * 9, 8 + k * 18, (j * 18) + 18));

			}

		}
		
		for (int l = 0; l < 3; ++l) {
			
			for (int j1 = 0; j1 < 9; ++j1) {
				
				this.addSlot(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 102 + l * 18));
				
			}
			
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			
			this.addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, 160));
			
		}
		
		this.addSlot(new ToolSlot(itemHandlerModifiable, 36, 174, 54));
		this.addSlot(new ToolSlot(itemHandlerModifiable, 37, 174, 72));
		
		this.addSlot(new ArmorSlot(playerInventory, EquipmentSlotType.HEAD, 39, -14, 18));
		this.addSlot(new ArmorSlot(playerInventory, EquipmentSlotType.CHEST, 38, -14, 36));
		this.addSlot(new ArmorSlot(playerInventory, EquipmentSlotType.LEGS, 37, -14, 54));
		this.addSlot(new ArmorSlot(playerInventory, EquipmentSlotType.FEET, 36, -14, 72));
		this.addSlot(new OffHandSlot(playerInventory, 40, -14, 160));
		
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack()) {
			
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (index < 37) {
				
				if (!this.mergeItemStack(itemstack1, 37, this.inventorySlots.size(), true)) {
					
					return ItemStack.EMPTY;
					
				}
				
			} else if (!this.mergeItemStack(itemstack1, 0, 37, false)) {
				
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
	
	public static class ToolSlot extends SlotItemHandler {
		
		public static final ResourceLocation EMPTY_TOOL_SLOT = new ResourceLocation("cave:items/empty_tool_slot");

		public ToolSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
			
			super(itemHandler, index, xPosition, yPosition);
			
		}
		
		@Override
		public int getSlotStackLimit() {
			
			return 1;
			
		}
		
		@Override
		public boolean isItemValid(ItemStack stack) {
			
			return stack.getItem() instanceof TieredItem;
			
		}
		
		@Override
		public Pair<ResourceLocation, ResourceLocation> getBackground() {
			
			return Pair.of(PlayerContainer.LOCATION_BLOCKS_TEXTURE, EMPTY_TOOL_SLOT);
			
		}
		
	}
	
	public static class OffHandSlot extends Slot {

		public OffHandSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
			
			super(inventoryIn, index, xPosition, yPosition);
			
		}
		
		@Override
		public Pair<ResourceLocation, ResourceLocation> getBackground() {
			
			return Pair.of(PlayerContainer.LOCATION_BLOCKS_TEXTURE, PlayerContainer.EMPTY_ARMOR_SLOT_SHIELD);
			
		}
		
	}
	
	public static class ArmorSlot extends Slot {
		
		private final PlayerEntity player;
		private final EquipmentSlotType slotType;

		public ArmorSlot(PlayerInventory playerInventory, EquipmentSlotType slotType, int index, int xPosition, int yPosition) {
			
			super(playerInventory, index, xPosition, yPosition);
			this.player = playerInventory.player;
			this.slotType = slotType;
			
		}
		
		@Override
		public int getSlotStackLimit() {
			
			return 1;
			
		}
		
		@Override
		public boolean isItemValid(ItemStack stack) {
			
			return stack.canEquip(slotType, player);
			
		}

		@Override
		public boolean canTakeStack(PlayerEntity playerIn) {
			
			ItemStack itemstack = this.getStack();
			return !itemstack.isEmpty() && !playerIn.isCreative() && EnchantmentHelper.hasBindingCurse(itemstack) ? false : super.canTakeStack(playerIn);
			
		}
		
		@Override
		public Pair<ResourceLocation, ResourceLocation> getBackground() {
			
			switch (slotType) {
			case HEAD: return Pair.of(PlayerContainer.LOCATION_BLOCKS_TEXTURE, PlayerContainer.EMPTY_ARMOR_SLOT_HELMET);
			case CHEST: return Pair.of(PlayerContainer.LOCATION_BLOCKS_TEXTURE, PlayerContainer.EMPTY_ARMOR_SLOT_CHESTPLATE);
			case LEGS: return Pair.of(PlayerContainer.LOCATION_BLOCKS_TEXTURE, PlayerContainer.EMPTY_ARMOR_SLOT_LEGGINGS);
			case FEET: return Pair.of(PlayerContainer.LOCATION_BLOCKS_TEXTURE, PlayerContainer.EMPTY_ARMOR_SLOT_BOOTS);
			default: break;
			}
			return super.getBackground();
			
		}
		
	}
	
}
