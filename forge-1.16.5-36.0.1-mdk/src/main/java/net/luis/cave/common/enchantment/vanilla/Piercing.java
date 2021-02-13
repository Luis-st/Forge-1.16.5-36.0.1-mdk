package net.luis.cave.common.enchantment.vanilla;

import net.luis.cave.api.item.weapon.Crossbow;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class Piercing extends Enchantment {

	public Piercing(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 1 + (enchantmentLevel - 1) * 10;
		
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return 50;
		
	}
	
	@Override
	public int getMaxLevel() {

		return 4;
		
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof Crossbow;	
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return stack.getItem() instanceof Crossbow;
	}
	
}
