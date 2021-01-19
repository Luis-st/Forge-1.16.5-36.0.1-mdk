package net.luis.cave.items.weapons;

import net.luis.cave.Cave;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NightCrossbow extends Crossbow {

	public NightCrossbow() {
		
		super(new Item.Properties()
				.group(Cave.WEAPONS)
				.maxStackSize(1)
				.isImmuneToFire()
				.maxDamage(3864));
		
	}
	
	@Override
	public boolean isCrossbow(ItemStack stack) {

		return true;
		
	}
	
	@Override
	public double getArrowDamage(ItemStack stack) {
		
		return super.getArrowDamage(stack) * 2;
		
	}
	
	@Override
	public int getArrowPierce(ItemStack stack) {
		
		return (int) (super.getArrowPierce(stack) * 1.5);
		
	}
	
}