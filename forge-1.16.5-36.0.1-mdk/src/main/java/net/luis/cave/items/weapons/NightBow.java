package net.luis.cave.items.weapons;

import net.luis.cave.Cave;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NightBow extends Bow {

	public NightBow() {
		
		super(new Item.Properties()
				.group(Cave.WEAPONS)
				.maxStackSize(1)
				.isImmuneToFire()
				.maxDamage(4235));
		
	}
	
	@Override
	public double getArrowDamage(ItemStack stack) {
		
		return super.getArrowDamage(stack) * 2;
		
	}
	
}
