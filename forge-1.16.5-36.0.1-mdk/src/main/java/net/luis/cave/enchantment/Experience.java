package net.luis.cave.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;

public class Experience extends Enchantment {

	public Experience(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

	}
	
	@Override
	public int getMaxLevel() {

		return 4;
		
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		return stack.getItem() instanceof PickaxeItem;
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		return !(ench == Enchantments.SILK_TOUCH);
	}

}
