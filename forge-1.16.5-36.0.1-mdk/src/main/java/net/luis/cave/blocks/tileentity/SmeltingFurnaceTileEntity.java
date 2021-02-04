package net.luis.cave.blocks.tileentity;

import net.luis.cave.blocks.container.SmeltingContainer;
import net.luis.cave.init.CaveRecipe;
import net.luis.cave.init.CaveTileEntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class SmeltingFurnaceTileEntity extends AbstractFurnaceTileEntity {

	public SmeltingFurnaceTileEntity() {
		
		super(CaveTileEntityType.SMELTING_FURNACE.get(), CaveRecipe.ISMELTING);
		
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
