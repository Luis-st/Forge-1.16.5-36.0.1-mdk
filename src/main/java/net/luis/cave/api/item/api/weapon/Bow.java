package net.luis.cave.api.item.api.weapon;

import net.luis.cave.Cave;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Bow extends ModBow {
	
	private final double arrowDamageMultiplier;
	private final double arrowBaseDamage;

	public Bow(int maxDamage, double arrowDamageMultiplierIn, double arrowBaseDamageIn) {
		
		super(new Item.Properties()
				.group(Cave.WEAPONS)
				.maxStackSize(1)
				.isImmuneToFire()
				.maxDamage(maxDamage));
		this.arrowDamageMultiplier = arrowDamageMultiplierIn;
		this.arrowBaseDamage = arrowBaseDamageIn;
		
	}
	
	public Bow(Item.Properties properties) {
		
		super(properties);
		this.arrowDamageMultiplier = 1;
		this.arrowBaseDamage = 0;
		
	}
	
	@Override
	public double getArrowDamage(ItemStack stack) {
		
		int enchPower = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
		
		return enchPower * arrowDamageMultiplier + arrowBaseDamage;
		
	}

}
