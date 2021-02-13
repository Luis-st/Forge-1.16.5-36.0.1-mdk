package net.luis.cave.common.enchantment.vanilla;

import net.luis.cave.api.item.weapon.Bow;
import net.luis.cave.api.item.weapon.Crossbow;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class Infinity extends Enchantment {

	public Infinity(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
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
	public boolean canApply(ItemStack stack) {
		if (stack.getItem() instanceof Bow)
			return true;
		if (stack.getItem() instanceof Crossbow)
			return true;
		return false;
		
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		if (stack.getItem() instanceof Bow)
			return true;
		if (stack.getItem() instanceof Crossbow)
			return true;
		return false;
	}
	
}
