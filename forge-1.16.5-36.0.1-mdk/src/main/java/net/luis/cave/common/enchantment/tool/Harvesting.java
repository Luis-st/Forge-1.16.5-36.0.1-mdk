package net.luis.cave.common.enchantment.tool;

import net.luis.cave.init.ModEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class Harvesting extends Enchantment {
	
	public Harvesting(Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);
		
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 1 + 10 * (enchantmentLevel - 1);
		
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return this.getMinEnchantability(enchantmentLevel) + 50;
		
	}
	
	@Override
	public int getMaxLevel() {
		
		return 5;
		
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		if (ench == Enchantments.SILK_TOUCH)
			return false;
		if (ench == ModEnchantment.BLASTING.get())
			return false;
		if (ench == ModEnchantment.SMELTING.get())
			return false;
		return true;
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof AxeItem;
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return stack.getItem() instanceof AxeItem;
	}

}
