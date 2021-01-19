package net.luis.cave.items.weapons;

import net.luis.cave.Cave;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NetheriteCrossbow extends Crossbow {

	public NetheriteCrossbow() {
		
		super(new Item.Properties()
				.group(Cave.WEAPONS)
				.maxStackSize(1)
				.isImmuneToFire()
				.maxDamage(1634));
		
	}
	
	@Override
	public boolean isCrossbow(ItemStack stack) {

		return true;
		
	}
	
	@Override
	public double getArrowDamage(ItemStack stack) {
		
		return super.getArrowDamage(stack) * 1.5;
		
	}
	
}
