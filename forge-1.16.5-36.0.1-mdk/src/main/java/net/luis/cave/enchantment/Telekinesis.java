package net.luis.cave.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.OnAStickItem;
import net.minecraft.item.ShearsItem;
import net.minecraft.item.ShieldItem;

public class Telekinesis extends Enchantment {

	public Telekinesis(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 10;
		
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return 40;
		
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
		if (stack.getItem() instanceof ArmorItem)
			return false;
		if (stack.getItem() instanceof ShieldItem)
			return false;
		if (stack.getItem() instanceof ElytraItem)
			return false;
		if (stack.getItem() instanceof OnAStickItem)
			return false;
		if (stack.getItem() instanceof FishingRodItem)
			return false;
		if (stack.getItem() instanceof ShearsItem)
			return false;
		if (stack.getItem() instanceof FlintAndSteelItem)
			return false;
		return stack.isDamageable() ? true : super.canApply(stack);
	}

}

