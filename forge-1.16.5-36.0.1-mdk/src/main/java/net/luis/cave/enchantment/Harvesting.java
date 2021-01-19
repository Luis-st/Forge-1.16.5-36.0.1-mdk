package net.luis.cave.enchantment;

import net.luis.cave.init.CaveEnchantment;
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
	public int getMaxLevel() {
		
		return 5;
		
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		if (stack.getItem() instanceof AxeItem)
			return true;
		return false;
		
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		if (ench == Enchantments.SILK_TOUCH)
			return false;
		if (ench == CaveEnchantment.BLASTING.get())
			return false;
		if (ench == CaveEnchantment.SMELTING.get())
			return false;
		return true;
	}

}