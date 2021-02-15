package net.luis.cave.common.enchantment.vanilla;

import net.luis.cave.api.item.api.weapon.Crossbow;
import net.luis.cave.init.ModEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class Multishot extends Enchantment {

	public Multishot(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
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

		return 2;
		
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		return ench != Enchantments.FLAME && ench != ModEnchantment.FLAME.get();
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
