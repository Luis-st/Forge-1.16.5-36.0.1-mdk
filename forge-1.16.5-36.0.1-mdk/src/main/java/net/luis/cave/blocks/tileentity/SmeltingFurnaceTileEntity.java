package net.luis.cave.blocks.tileentity;

import net.luis.cave.init.CaveTileEntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.FurnaceContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class SmeltingFurnaceTileEntity extends AbstractFurnaceTileEntity {

	public SmeltingFurnaceTileEntity() {
		
		super(CaveTileEntityType.SMELTING_FURNACE.get(), IRecipeType.SMELTING);
		
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
		
		return new FurnaceContainer(id, player, this, this.furnaceData);
		
	}

}
