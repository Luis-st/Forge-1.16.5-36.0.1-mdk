package net.luis.cave.common.inventory.container;

import java.util.Optional;

import net.luis.cave.init.util.ModContainerType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.CraftingResultSlot;
import net.minecraft.inventory.container.RecipeBookContainer;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SSetSlotPacket;
import net.minecraft.world.World;

public class CraftingStationContainer extends RecipeBookContainer<CraftingInventory> {
	
	private final CraftingInventory craftMatrix = new CraftingInventory(this, 3, 3);
	private final CraftResultInventory craftResult = new CraftResultInventory();
	private final PlayerEntity player;
	
	public CraftingStationContainer(int id, PlayerInventory playerInventory, PacketBuffer extraData) {
		
		this(id, playerInventory, new Inventory(4 * 7 + 10));
		
	}
	
	public CraftingStationContainer(int id, PlayerInventory playerInventory, IInventory inventory) {
		
		super(ModContainerType.CRAFTING_STATION.get(), id);
		this.player = playerInventory.player;
		
		this.addSlot(new CraftingResultSlot(playerInventory.player, this.craftMatrix, this.craftResult, 0, 116, 112));
		
		for (int i = 0; i < 7; ++i) {
			
			for (int j = 0; j < 4; j++) {
				
				this.addSlot(new Slot(inventory, j + i * 4, 8 + j * 18, 18 + i * 18));
				
			}
			
		}
		
		for (int i = 0; i < 3; ++i) {
			
			for (int j = 0; j < 3; ++j) {
				
				this.addSlot(new Slot(this.craftMatrix, j + i * 3, (j * 18) + 98, (i * 18) + 18));
				
			}
			
		}
		
		for (int i = 0; i < 3; ++i) {
			
			for (int j = 0; j < 9; ++j) {
				
				this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, (i * 18) + 159));
				
			}
			
		}
		
		for (int i = 0; i < 9; ++i) {
			
			this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 217));
			
		}
		
	}
	
	@Override
	public void onCraftMatrixChanged(IInventory inventoryIn) {
		
		super.onCraftMatrixChanged(inventoryIn);		
		World world = player.getEntityWorld();
		
		if (!world.isRemote) {
			
			ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) player;
			ItemStack itemstack = ItemStack.EMPTY;
			Optional<ICraftingRecipe> optional = world.getServer().getRecipeManager().getRecipe(IRecipeType.CRAFTING, craftMatrix, world);
			
			if (optional.isPresent()) {
				
				ICraftingRecipe icraftingrecipe = optional.get();
				
				if (craftResult.canUseRecipe(world, serverplayerentity, icraftingrecipe)) {
					
					itemstack = icraftingrecipe.getCraftingResult(craftMatrix);
					
				}
				
			}

			craftResult.setInventorySlotContents(0, itemstack);
			serverplayerentity.connection.sendPacket(new SSetSlotPacket(this.windowId, 0, itemstack));
			
		}
		
	}

	@Override
	public void fillStackedContents(RecipeItemHelper itemHelperIn) {
			
		this.craftMatrix.fillStackedContents(itemHelperIn);
		
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {

		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {

			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (index == 0) {
				
				itemstack1.getItem().onCreated(itemstack1, player.getEntityWorld(), playerIn);
				if (!this.mergeItemStack(itemstack1, 10, 46, true)) {

					return ItemStack.EMPTY;

				}

				slot.onSlotChange(itemstack1, itemstack);

			} else if (index < (4 * 7 + 10)) {

				if (!this.mergeItemStack(itemstack1, 4 * 7 + 10, this.inventorySlots.size(), true)) {

					return ItemStack.EMPTY;

				}

			} else if (!this.mergeItemStack(itemstack1, 0, 4 * 7 + 10, false)) {

				return ItemStack.EMPTY;

			}

			if (itemstack1.isEmpty()) {

				slot.putStack(ItemStack.EMPTY);

			} else {

				slot.onSlotChanged();

			}
			
			ItemStack itemstack2 = slot.onTake(playerIn, itemstack1);
			
			if (index == 0) {
				
				playerIn.dropItem(itemstack2, false);
				
			}

		}

		return itemstack;
		
	}

	@Override
	public void onContainerClosed(PlayerEntity playerIn) {
		
		super.onContainerClosed(playerIn);
		InventoryHelper.dropInventoryItems(player.world, player, craftMatrix);
		
	}
	
	@Override
	public void clear() {
		
		this.craftMatrix.clear();
		this.craftResult.clear();
		
	}

	@Override
	public boolean matches(IRecipe<? super CraftingInventory> recipe) {
		
		return recipe.matches(this.craftMatrix, player.world);
		
	}

	@Override
	public int getOutputSlot() {
		
		return 0;
		
	}

	@Override
	public int getWidth() {
		
		return this.craftMatrix.getWidth();
		
	}

	@Override
	public int getHeight() {
		
		return this.craftMatrix.getWidth();
		
	}

	@Override
	public int getSize() {
		
		return 4 * 7 + 10;
		
	}

	@Override
	public RecipeBookCategory func_241850_m() {
		
		return RecipeBookCategory.CRAFTING;
		
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return true;
		
	}

}
