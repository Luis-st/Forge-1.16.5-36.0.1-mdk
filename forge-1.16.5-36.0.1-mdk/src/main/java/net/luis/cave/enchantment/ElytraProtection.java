package net.luis.cave.enchantment;

import net.luis.cave.init.CaveArmor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class ElytraProtection extends Enchantment {

	public ElytraProtection(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

	}
	
	@Override
	public int getMaxLevel() {

		return 4;
		
	}
	
	@Override
	public int calcModifierDamage(int level, DamageSource source) {
		if (source.canHarmInCreative())
			return 0;
		return level;	
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		if (ench instanceof ProtectionEnchantment)
			return false;
		return true;
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
