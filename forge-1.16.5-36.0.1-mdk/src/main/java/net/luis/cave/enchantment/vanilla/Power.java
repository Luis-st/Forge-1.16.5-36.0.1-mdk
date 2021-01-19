package net.luis.cave.enchantment.vanilla;

import net.luis.cave.items.weapons.Bow;
import net.luis.cave.items.weapons.Crossbow;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;

public class Power extends Enchantment {

	public Power(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 1 + (enchantmentLevel - 1) * 10;
		
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return this.getMinEnchantability(enchantmentLevel) + 15;
		
	}
	
	@Override
	public int getMaxLevel() {

		return 5;
		
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		if (stack.getItem() instanceof BowItem)
			return true;
		if (stack.getItem() instanceof Bow)
			return true;
		if (stack.getItem() instanceof Crossbow)
			return true;
		return false;
		
	}
	
}
