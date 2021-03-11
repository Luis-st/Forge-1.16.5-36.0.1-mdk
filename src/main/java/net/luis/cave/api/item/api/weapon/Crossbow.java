package net.luis.cave.api.item.api.weapon;

import net.luis.cave.Cave;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Crossbow extends ModCrossbow {
	
	private final double arrowDamage;
	private final int arrowPierce;

	public Crossbow(int maxDamage, double arrowDamageIn, int arrowPierceIn) {
		
		super(new Item.Properties()
				.group(Cave.WEAPONS)
				.maxStackSize(1)
				.isImmuneToFire()
				.maxDamage(maxDamage));
		this.arrowDamage = arrowDamageIn;
		this.arrowPierce = arrowPierceIn;
		
	}
	
	public Crossbow(Item.Properties properties) {
		
		super(properties);
		this.arrowDamage = 1;
		this.arrowPierce = 0;
		
	}
	
	@Override
	public boolean isCrossbow(ItemStack stack) {

		return true;
		
	}
	
	@Override
	public double getArrowDamage(ItemStack stack) {
		
		int enchPower = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
		
		return enchPower * arrowDamage + arrowDamage;
		
	}
	
	@Override
	public int getArrowPierce(ItemStack stack) {
		
		int enchPiercing = EnchantmentHelper.getEnchantmentLevel(Enchantments.PIERCING, stack);
		
		return enchPiercing + arrowPierce;
		
	}
	
}

