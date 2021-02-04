package net.luis.cave.common.tileentity;

import net.luis.cave.common.container.SmeltingContainer;
import net.luis.cave.init.util.ModTileEntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class SmeltingFurnaceTileEntity extends AbstractFurnaceTileEntity {

	public SmeltingFurnaceTileEntity() {
		
		super(ModTileEntityType.SMELTING_FURNACE.get(), null);
		
	}

	@Override
	protected ITextComponent getDefaultName() {
		
		return new TranslationTextComponent("container.smelting_furnace");
		
	}
	
	@Override
	protected int getBurnTime(ItemStack fuel) {
		
		return super.getBurnTime(fuel) / 2;
		
	}
	
	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		
		return new SmeltingContainer(id, player, null);
		
	}

}
