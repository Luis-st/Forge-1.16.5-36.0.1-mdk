package net.luis.cave.api.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.world.World;

public class Star extends Item {

	public Star(Properties properties) {
		
		super(properties.maxStackSize(1).rarity(Rarity.UNCOMMON));
		
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) {
		
		return true;
		
	}
	
	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		
		if (entity instanceof PlayerEntity) {
			
			PlayerEntity player = (PlayerEntity) entity;
			starTick(stack, world, player);
			
		}
		
	}
	
	public void starTick(ItemStack stack, World world, PlayerEntity player) {
		
	}

}
