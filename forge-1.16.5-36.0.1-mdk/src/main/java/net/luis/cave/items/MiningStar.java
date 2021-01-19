package net.luis.cave.items;

import net.luis.cave.Cave;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;

public class MiningStar extends Item {

	public MiningStar() {
		
		super(new Item.Properties()
					.group(Cave.MISC)
					.maxStackSize(1)
					.rarity(Rarity.UNCOMMON));
		
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {

		return true;
		
	}
	
}