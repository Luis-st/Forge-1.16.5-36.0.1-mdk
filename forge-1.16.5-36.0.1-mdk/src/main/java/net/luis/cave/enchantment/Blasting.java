package net.luis.cave.enchantment;

import net.luis.cave.init.CaveEnchantment;
import net.luis.cave.init.CaveTools;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class Blasting extends Enchantment {

	public Blasting(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 1 + 10 * (enchantmentLevel - 1);
		
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return super.getMinEnchantability(enchantmentLevel) + 50;
		
	}
	
	@Override
	public int getMaxLevel() {

		return 4;
		
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		return ench != CaveEnchantment.SMELTING.get();
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		if (stack.getItem() != CaveTools.BLAZING_AXE.get())
			return true;
		if (stack.getItem() != CaveTools.BLAZING_PICKAXE.get())
			return true;
		if (stack.getItem() != CaveTools.BLAZING_SHOVEL.get())
			return true;
		if (stack.getItem() != CaveTools.BLAZING_SWORD.get())
			return true;
		return false;
	}
	
}
