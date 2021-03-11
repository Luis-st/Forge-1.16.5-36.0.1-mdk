package net.luis.cave.common.tileentity;

import net.luis.cave.common.inventory.container.CraftingStationContainer;
import net.luis.cave.init.util.ModTileEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class CraftingStationTileEntity extends LockableLootTileEntity {
	
	private final int rows = 7;
	private final int size = 4;
	private final int invSize = size * rows + 10;
	private NonNullList<ItemStack> inventory = NonNullList.withSize(invSize, ItemStack.EMPTY);
	private int numPlayersUsing;

	public CraftingStationTileEntity() {
		
		super(ModTileEntityType.CRAFTING_STATION.get());
		
	}

	@Override
	public int getSizeInventory() {
		
		return invSize;
		
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		
		return this.inventory;
		
	}

	@Override
	protected void setItems(NonNullList<ItemStack> itemsIn) {
		
		this.inventory = itemsIn;
		
	}

	@Override
	protected ITextComponent getDefaultName() {
		
		return new TranslationTextComponent("container.crafting_station");
		
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		
		return new CraftingStationContainer(id, player, this);
		
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
		
		super.write(compound);
		
		if (!this.checkLootAndWrite(compound)) {
			
			ItemStackHelper.saveAllItems(compound, this.inventory);
			
		}

		return compound;
		
	}

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		
		super.read(state, nbt);
		
		this.inventory = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		
		if (!this.checkLootAndRead(nbt)) {
			
			ItemStackHelper.loadAllItems(nbt, this.inventory);
			
		}

	}
	
	@Override
	public void openInventory(PlayerEntity player) {
		
		if (!player.isSpectator()) {
			
			if (this.numPlayersUsing < 0) {
				
				this.numPlayersUsing = 0;
				
			}

			++this.numPlayersUsing;
			
		}

	}

}
