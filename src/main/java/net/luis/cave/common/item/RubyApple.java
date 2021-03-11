package net.luis.cave.common.item;

import net.luis.cave.Cave;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class RubyApple extends Item {

	@SuppressWarnings("deprecation")
	public RubyApple() {
		
		super(new Item.Properties()
					.group(Cave.FOOD)
					.rarity(Rarity.EPIC)
					.food(new Food.Builder()
							.hunger(12)
							.saturation(12.8f)
							.effect(new EffectInstance(Effects.ABSORPTION, 4800, 4), 1)
							.effect(new EffectInstance(Effects.REGENERATION, 1200, 1), 1)
							.effect(new EffectInstance(Effects.RESISTANCE, 12000, 1), 1)
							.effect(new EffectInstance(Effects.FIRE_RESISTANCE, 12000, 0), 1)
							.effect(new EffectInstance(Effects.SPEED, 6000, 0), 1)
							.setAlwaysEdible()
							.build()));
		
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {

		return true;
		
	}
	
}
