package net.luis.cave.common.enchantment.tool;

import net.luis.cave.init.ModEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;

public class Smelting extends Enchantment {

	public Smelting(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
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
		if (ench != ModEnchantment.DOUBLE_DROPS.get())
			return true;
		if (ench != ModEnchantment.BLASTING.get())
			return true;
		return false;
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		return !(stack.getItem() instanceof HoeItem);
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return !(stack.getItem() instanceof HoeItem);
	}

}
