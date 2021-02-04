package net.luis.cave.common.enchantment.vanilla;

import net.luis.cave.api.item.Bow;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class Punch extends Enchantment {

	public Punch(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 12 + (enchantmentLevel - 1) * 20;
		
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return this.getMinEnchantability(enchantmentLevel) + 25;
		
	}
	
	@Override
	public int getMaxLevel() {

		return 3;
		
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof Bow;
	}
	
}
