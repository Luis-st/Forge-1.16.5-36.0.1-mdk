package net.luis.cave.common.enchantment.armor;

import net.luis.cave.init.items.ModArmor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;

public class ElytraFalling extends Enchantment {

	public ElytraFalling(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
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
	public boolean canApply(ItemStack stack) {
		if (stack.getItem() instanceof ElytraItem)
			return true;
		if (stack.getItem() == ModArmor.ENDREITE_ELYTRA.get())
			return true;
		if (stack.getItem() == ModArmor.NIGHT_ELYTRA.get())
			return true;
		return super.canApply(stack);
	}
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		if (stack.getItem() instanceof ElytraItem)
			return true;
		if (stack.getItem() == ModArmor.ENDREITE_ELYTRA.get())
			return true;
		if (stack.getItem() == ModArmor.NIGHT_ELYTRA.get())
			return true;
		return super.canApplyAtEnchantingTable(stack);
	}
	
}
