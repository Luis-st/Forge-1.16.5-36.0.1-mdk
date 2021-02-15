package net.luis.cave.common.item.star;

import net.luis.cave.Cave;
import net.luis.cave.api.item.api.Star;
import net.luis.cave.common.enums.StarType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class WaterStar extends Star {

	public WaterStar() {
		
		super(new Item.Properties().group(Cave.MISC), StarType.WATER);
		
	}
	
	@Override
	public void starTick(ItemStack stack, World world, PlayerEntity player) {
		
		if (player.isInWater()) {
			
			player.addPotionEffect(new EffectInstance(new EffectInstance(Effects.WATER_BREATHING, 10, 0, true, false)));
			player.addPotionEffect(new EffectInstance(new EffectInstance(Effects.DOLPHINS_GRACE, 10, 0, true, false)));
			
		}
		
	}

}
