package net.luis.cave.common.enchantment.curse;

import net.luis.cave.api.item.api.weapon.Bow;
import net.luis.cave.api.item.api.weapon.Crossbow;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class CurseOfHarming extends Enchantment {

	public CurseOfHarming(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 25;
		
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
	public boolean canVillagerTrade() {
		
		return false;
		
	}
	
	@Override
	public boolean isCurse() {
		
		return true;
		
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		if (stack.getItem() instanceof SwordItem)
			return true;
		if (stack.getItem() instanceof AxeItem)
			return true;
		if (stack.getItem() instanceof Bow)
			return true;
		if (stack.getItem() instanceof Crossbow)
			return true;
		return false;
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		if (stack.getItem() instanceof SwordItem)
			return true;
		if (stack.getItem() instanceof AxeItem)
			return true;
		if (stack.getItem() instanceof Bow)
			return true;
		if (stack.getItem() instanceof Crossbow)
			return true;
		return false;
	}
	
}

