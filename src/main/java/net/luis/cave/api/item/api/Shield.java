package net.luis.cave.api.item.api;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import net.luis.cave.Cave;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;

public class Shield extends ShieldItem {
	
	private final Item repairItem;

	public Shield(int maxDamage, Supplier<Callable<ItemStackTileEntityRenderer>> ister, Item repairItemIn) {
		
		super(new Item.Properties().group(Cave.WEAPONS)
				.maxStackSize(1)
				.maxDamage(maxDamage)
				.isImmuneToFire()
				.setISTER(ister));
		DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
		this.repairItem = repairItemIn;
		
	}
	
	@Override
	public boolean isShield(ItemStack stack, LivingEntity entity) {
		
		return true;
		
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		
		return repair.getItem() == repairItem || super.getIsRepairable(toRepair, repair);
		
	}
	
}
