package net.luis.cave.common.enchantment.vanilla;

import java.util.Random;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;

public class Thorns extends Enchantment {

	public Thorns(Enchantment.Rarity rarity, EnchantmentType type, EquipmentSlotType... slots) {
		
		super(rarity, type, slots);

	}
	
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		
		return 10 + 20 * (enchantmentLevel - 1);
		
	}
	
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		
		return this.getMinEnchantability(enchantmentLevel) + 50;
		
	}
	
	@Override
	public int getMaxLevel() {

		return 3;
		
	}
	
	@Override
	public void onUserHurt(LivingEntity user, Entity attacker, int level) {
		Random rng = user.getRNG();
		int thorns = getThornsLevel(user);
		if (thorns > 0) {
			if (attacker != null) {
				attacker.attackEntityFrom(DamageSource.causeThornsDamage(user), calcThorns(thorns, rng));
			}
		}	
	}
	
	private int calcThorns(int thorns, Random rng) {
		
		int rngInt = rng.nextInt(thorns);
		int ret = 1;
		
		if ((thorns / 3) + rngInt > 0) {
			
			ret = (thorns / 3) + rngInt;
			
		} else if ((thorns / 2) + rngInt > 0) {
			
			ret = (thorns / 2) + rngInt;
			
		} else if (thorns  + rngInt > 0) {
			
			ret = thorns + rngInt;
			
		}
		
		
		return ret;
		
	}

	private int getThornsLevel(LivingEntity user) {
		int head = EnchantmentHelper.getEnchantmentLevel(this, user.getItemStackFromSlot(EquipmentSlotType.HEAD));
		int chest = EnchantmentHelper.getEnchantmentLevel(this, user.getItemStackFromSlot(EquipmentSlotType.CHEST));
		int legs = EnchantmentHelper.getEnchantmentLevel(this, user.getItemStackFromSlot(EquipmentSlotType.LEGS));
		int feet = EnchantmentHelper.getEnchantmentLevel(this, user.getItemStackFromSlot(EquipmentSlotType.FEET));
		return head + chest + legs+ feet;
	}
	
}
