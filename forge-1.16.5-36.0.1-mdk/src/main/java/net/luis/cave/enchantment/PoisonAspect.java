package net.luis.cave.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;

public class PoisonAspect extends Enchantment {

	public PoisonAspect(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(Enchantment.Rarity.RARE, EnchantmentType.WEAPON, slots);

	}
	
	@Override
	public int getMaxLevel() {

		return 2;
		
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		if (ench != Enchantments.FIRE_ASPECT)
			return true;
		return false;
	}

}
