package net.luis.cave.common.item.star;

import net.luis.cave.api.item.api.Star;
import net.luis.cave.common.enums.StarType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class NetherStar extends Star {

	public NetherStar() {
		
		super(new Item.Properties().group(ItemGroup.MISC), StarType.NETHER);
		
	}
	
	@Override
	public void starTick(ItemStack stack, World world, PlayerEntity player) {
		
		player.addPotionEffect(new EffectInstance(new EffectInstance(Effects.FIRE_RESISTANCE, 10, 0, true, false)));
		
	}

}
