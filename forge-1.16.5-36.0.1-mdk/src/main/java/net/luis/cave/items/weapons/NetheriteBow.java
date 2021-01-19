package net.luis.cave.items.weapons;

import net.luis.cave.Cave;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NetheriteBow extends Bow {

	public NetheriteBow() {
		
		super(new Item.Properties()
				.group(Cave.WEAPONS)
				.maxStackSize(1)
				.isImmuneToFire()
				.maxDamage(1927));
		
	}
	
	@Override
	public double getArrowDamage(ItemStack stack) {
		
		return super.getArrowDamage(stack) * 1.5;
		
	}

}

