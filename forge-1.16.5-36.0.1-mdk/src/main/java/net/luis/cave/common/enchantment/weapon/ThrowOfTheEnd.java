package net.luis.cave.common.enchantment.weapon;

import net.luis.cave.api.item.weapon.Bow;
import net.luis.cave.init.ModEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class ThrowOfTheEnd extends Enchantment {

	public ThrowOfTheEnd(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
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
	public boolean canVillagerTrade() {
		
		return false;
		
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		return ench != ModEnchantment.DOUBLE_SHOT.get();
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof Bow;
	}
	
}
