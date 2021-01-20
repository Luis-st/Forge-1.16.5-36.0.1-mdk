package net.luis.cave.enchantment;

import net.luis.cave.init.CaveEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;

public class Thunderbolt extends Enchantment {

	public Thunderbolt(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

	}
	
	@Override
	public int getMaxLevel() {

		return 1;
		
	}
	
	@Override
	public boolean isTreasureEnchantment() {
		
		return true;
		
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		if (ench != Enchantments.FIRE_ASPECT)
			return true;
		if (ench != CaveEnchantment.FROST_ASPECT.get())
			return true;
		if (ench != CaveEnchantment.POISON_ASPECT.get())
			return true;
		return false;
	}

}
