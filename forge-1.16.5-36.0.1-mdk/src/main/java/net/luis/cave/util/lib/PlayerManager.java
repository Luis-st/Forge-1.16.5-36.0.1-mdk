package net.luis.cave.util.lib;

import net.luis.cave.init.CaveArmor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;

public class PlayerManager {
	
	public static boolean hasSaphireArmor(PlayerEntity player) {
		
		if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == CaveArmor.SAPHIRE_HELMET.get() &&
			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == CaveArmor.SAPHIRE_CHESTPLATE.get()&&
			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == CaveArmor.SAPHIRE_LEGGINS.get() &&
			player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == CaveArmor.SAPHIRE_BOOTS.get()) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public static boolean hasNightArmor(PlayerEntity player, boolean enableElytra) {
		
		if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == CaveArmor.NIGHT_HELMET.get() &&
			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == CaveArmor.NIGHT_LEGGINS.get() &&
			player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == CaveArmor.NIGHT_BOOTS.get()) {
			
			if (enableElytra) {
				
				if (player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == CaveArmor.NIGHT_CHESTPLATE.get() ||
					player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == CaveArmor.NIGHT_ELYTRA.get()) {
					
					return true;
					
				}
				
			} else if (player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == CaveArmor.NIGHT_CHESTPLATE.get()) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}

	public static boolean hasBlazingArmor(PlayerEntity player) {
		
		if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == CaveArmor.BLAZING_HELMET.get() &&
			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() == CaveArmor.BLAZING_CHESTPLATE.get()&&
			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() == CaveArmor.BLAZING_LEGGINS.get() &&
			player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == CaveArmor.BLAZING_BOOTS.get()) {
				
			return true;
				
		}
			
		return false;
		
	}

}
