package net.luis.cave.enchantment.vanilla;

import net.luis.cave.init.CaveEnchantment;
import net.luis.cave.items.weapons.Bow;
import net.luis.cave.items.weapons.Crossbow;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;

public class Flame extends Enchantment {

	public Flame(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
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
	protected boolean canApplyTogether(Enchantment ench) {
		if (ench == Enchantments.MULTISHOT || ench == CaveEnchantment.MULTISHOT.get())
			return false;
		return true;
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
