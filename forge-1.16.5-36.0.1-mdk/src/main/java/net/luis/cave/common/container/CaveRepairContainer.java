package net.luis.cave.common.container;

import net.luis.cave.init.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.RepairContainer;

public class CaveRepairContainer extends RepairContainer {

	public CaveRepairContainer(int id, PlayerInventory playerInventory) {
		super(id, playerInventory);
		
	}
	
	@Override
	protected boolean func_230302_a_(BlockState state) {
		
		return state.getBlock() == ModBlocks.INFINITE_ANVIL.get() ? true : false;
		
	}
	
	@Override
	public int getMaximumCost() {
		
		return 200;
		
	}
	
}