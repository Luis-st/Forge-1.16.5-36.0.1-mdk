package net.luis.cave.common.enchantment.tool;

import net.luis.cave.init.ModEnchantment;
import net.luis.cave.init.items.ModTools;
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
		return ench != ModEnchantment.SMELTING.get();
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		if (stack.getItem() == ModTools.BLAZING_AXE.get())
			return false;
		if (stack.getItem() == ModTools.BLAZING_PICKAXE.get())
			return false;
		if (stack.getItem() == ModTools.BLAZING_SHOVEL.get())
			return false;
		if (stack.getItem() == ModTools.BLAZING_SWORD.get())
			return false;
		return super.canApply(stack);
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		if (stack.getItem() == ModTools.BLAZING_AXE.get())
			return false;
		if (stack.getItem() == ModTools.BLAZING_PICKAXE.get())
			return false;
		if (stack.getItem() == ModTools.BLAZING_SHOVEL.get())
			return false;
		if (stack.getItem() == ModTools.BLAZING_SWORD.get())
			return false;
		return super.canApplyAtEnchantingTable(stack);
	}
	
}
