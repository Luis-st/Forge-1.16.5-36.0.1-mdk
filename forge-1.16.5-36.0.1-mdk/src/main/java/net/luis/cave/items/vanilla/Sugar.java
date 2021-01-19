package net.luis.cave.items.vanilla;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class Sugar extends Item {

	@SuppressWarnings("deprecation")
	public Sugar() {
		
		super(new Item.Properties()
				.group(ItemGroup.FOOD)
				.food(new Food.Builder()
						.hunger(2)
						.saturation(1.0f)
						.effect(new EffectInstance(Effects.SPEED, 300, 3), 1)
						.setAlwaysEdible()
						.build()));
	}

}
