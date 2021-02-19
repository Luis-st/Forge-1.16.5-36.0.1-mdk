package net.luis.cave.common.item.star;

import net.luis.cave.Cave;
import net.luis.cave.api.item.api.Star;
import net.luis.cave.common.enums.StarType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class DeathStar extends Star {

	public DeathStar() {
		
		super(new Item.Properties().group(Cave.MISC), StarType.DEATH);
		
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		
		DamageSource deathStar = (new DamageSource("death_star")).setDamageAllowedInCreativeMode().setDamageBypassesArmor().setDamageIsAbsolute();
		target.attackEntityFrom(deathStar, Float.MAX_VALUE);
		return true;
		
	}

}
