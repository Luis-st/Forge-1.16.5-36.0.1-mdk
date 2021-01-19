package net.luis.cave.enchantment;

import net.luis.cave.init.CaveArmor;
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
	public boolean canApplyAtEnchantingTable(ItemStack stack) {	
		if (stack.getItem() instanceof ElytraItem)
			return true;
		if (stack.getItem() == CaveArmor.ENDREITE_ELYTRA.get())
			return true;
		if (stack.getItem() == CaveArmor.NIGHT_ELYTRA.get())
			return true;
		return false;
		
	}
	
}
