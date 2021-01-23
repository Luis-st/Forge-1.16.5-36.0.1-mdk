package net.luis.cave.enchantment;

import net.luis.cave.init.CaveEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;

public class Replenish extends Enchantment {

	public Replenish(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

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
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof HoeItem;
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		return ench != CaveEnchantment.BLASTING.get() || ench != CaveEnchantment.SMELTING.get();
	}

}
