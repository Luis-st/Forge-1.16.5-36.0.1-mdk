package net.luis.cave.common.enchantment.weapon;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class EnderSlayer extends Enchantment {

	public EnderSlayer(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 5 + (enchantmentLevel - 1) * 5;
		
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return this.getMinEnchantability(enchantmentLevel) + 20;
		
	}
	
	@Override
	public int getMaxLevel() {

		return 5;
		
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		return !(ench instanceof DamageEnchantment);
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof AxeItem ? true : super.canApply(stack);
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return stack.getItem() instanceof AxeItem ? true : super.canApplyAtEnchantingTable(stack);
	}
	
}
