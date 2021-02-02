package net.luis.cave.items.star;

import net.luis.cave.Cave;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class MiningStar extends Star {

	public MiningStar() {
		
		super(new Item.Properties().group(Cave.MISC));
		
	}
	
	@Override
	public void starTick(ItemStack stack, World world, PlayerEntity player) {
		
		player.addPotionEffect(new EffectInstance(new EffectInstance(Effects.HASTE, 10, 2, true, false)));
		
	}
	
}