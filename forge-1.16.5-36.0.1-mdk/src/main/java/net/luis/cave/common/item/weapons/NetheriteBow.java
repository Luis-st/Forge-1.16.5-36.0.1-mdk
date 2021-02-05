package net.luis.cave.common.item.weapons;

import net.luis.cave.Cave;
import net.luis.cave.api.item.weapon.Bow;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
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
		
		int enchPower = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
		
		return enchPower * 1.5D + 1.0D;
		
	}

}

