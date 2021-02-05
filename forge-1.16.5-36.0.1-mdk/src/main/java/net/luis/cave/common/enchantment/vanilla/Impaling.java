package net.luis.cave.common.enchantment.vanilla;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

public class Impaling extends Enchantment {

	public Impaling(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType... slots) {
		
		super(rarityIn, typeIn, slots);
		
	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 1 + (enchantmentLevel - 1) * 8;
		
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return this.getMinEnchantability(enchantmentLevel) + 20;
		
	}
	
	@Override
	public int getMaxLevel() {
		
		return 5;
		
	}
	
	@Override
	protected boolean canApplyTogether(Enchantment ench) {
		
		return !(ench instanceof DamageEnchantment);
		
	}
	
	@Override
	public float calcDamageByCreature(int level, CreatureAttribute creatureType) {
		
		return creatureType == CreatureAttribute.WATER ? (float)level * 2.5F : 0.0F;
		
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		if (stack.getItem() instanceof SwordItem)
			return true;
		if (stack.getItem() instanceof AxeItem)
			return true;
		return super.canApply(stack);
		
	}

}
