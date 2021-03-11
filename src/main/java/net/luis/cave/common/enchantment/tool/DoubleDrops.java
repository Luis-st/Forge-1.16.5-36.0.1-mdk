package net.luis.cave.common.enchantment.tool;

import net.luis.cave.init.ModEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;

public class DoubleDrops extends Enchantment {

	public DoubleDrops(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);
		
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 20;
		
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return 50;
		
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
		if (ench != Enchantments.SILK_TOUCH)
			return true;
		if (ench != ModEnchantment.SMELTING.get())
			return true;
		return false;
	}

}
