package net.luis.cave.enchantment.vanilla;

import net.luis.cave.items.weapons.Bow;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BowItem;
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
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		if (stack.getItem() instanceof BowItem)
			return true;
		if (stack.getItem() instanceof Bow)
			return true;
		return false;
		
	}
	
}