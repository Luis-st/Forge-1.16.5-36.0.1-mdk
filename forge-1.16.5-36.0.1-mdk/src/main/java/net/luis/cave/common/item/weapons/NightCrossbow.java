package net.luis.cave.common.item.weapons;

import net.luis.cave.Cave;
import net.luis.cave.api.item.weapon.Crossbow;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
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
		
		int enchPower = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
		
		return enchPower * 2D + 2D;
		
	}
	
	@Override
	public int getArrowPierce(ItemStack stack) {
		
		int enchPiercing = EnchantmentHelper.getEnchantmentLevel(Enchantments.PIERCING, stack);
		
		return enchPiercing + 3;
		
	}
	
}