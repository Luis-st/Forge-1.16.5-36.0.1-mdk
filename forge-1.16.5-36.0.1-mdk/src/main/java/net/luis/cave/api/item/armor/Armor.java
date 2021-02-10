package net.luis.cave.api.item.armor;

import net.luis.cave.api.lib.PlayerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Armor extends ArmorItem {

	public Armor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		
		super(materialIn, slot, builderIn);
		
	}
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		
		if (PlayerManager.hasArmor(player, material)) {
			
			onCompleteArmorTick(stack, world, player);
			
		} else {
			
			switch (slot) {
			case HEAD: onHeadTick(stack, world, player);
			case CHEST: onChestTick(stack, world, player);
			case LEGS: onLegsTick(stack, world, player);
			case FEET: onFeetTick(stack, world, player);
			default:
			}
			
		}
		
	}
	
	public void onHeadTick(ItemStack stack, World world, PlayerEntity player) {
		
	}
	
	public void onChestTick(ItemStack stack, World world, PlayerEntity player) {
		
	}
	
	public void onLegsTick(ItemStack stack, World world, PlayerEntity player) {
		
	}
	
	public void onFeetTick(ItemStack stack, World world, PlayerEntity player) {
		
	}
	
	public void onCompleteArmorTick(ItemStack stack, World world, PlayerEntity player) {
		
	}

}
