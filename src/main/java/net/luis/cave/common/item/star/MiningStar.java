package net.luis.cave.common.item.star;

import net.luis.cave.Cave;
import net.luis.cave.api.item.api.weapon.Star;
import net.luis.cave.common.enums.StarType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class MiningStar extends Star {

	public MiningStar() {
		
		super(new Item.Properties().group(Cave.MISC), StarType.MINING);
		
	}
	
	@Override
	public void starTick(ItemStack stack, World world, PlayerEntity player) {
		
		player.addPotionEffect(new EffectInstance(new EffectInstance(Effects.HASTE, 10, 2, true, false)));
		
	}
	
}