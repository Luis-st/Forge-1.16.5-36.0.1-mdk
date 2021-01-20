package net.luis.cave.lib;

import net.luis.cave.init.CaveArmor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;

public class PlayerManager {
	
	public static boolean hasSaphireArmor(PlayerEntity player) {
		
		if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).equals(CaveArmor.SAPHIRE_HELMET.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.CHEST).equals(CaveArmor.SAPHIRE_CHESTPLATE.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.LEGS).equals(CaveArmor.SAPHIRE_LEGGINS.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.FEET).equals(CaveArmor.SAPHIRE_BOOTS.get().getDefaultInstance(), true)) {
				
			return true;
				
		} else {
				
			return false;
				
		}
		
	}
	
	public static boolean hasNightArmor(PlayerEntity player, boolean enableElytra) {
		
		if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).equals(CaveArmor.NIGHT_HELMET.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.LEGS).equals(CaveArmor.NIGHT_LEGGINS.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.FEET).equals(CaveArmor.NIGHT_BOOTS.get().getDefaultInstance(), true)) {
			
			if (enableElytra) {
				
				if (player.getItemStackFromSlot(EquipmentSlotType.CHEST).equals(CaveArmor.NIGHT_HELMET.get().getDefaultInstance(), true) || 
					player.getItemStackFromSlot(EquipmentSlotType.CHEST).equals(CaveArmor.NIGHT_ELYTRA.get().getDefaultInstance(), true)) {
					
					return true;
					
				}
				
			} else {
				
				if (player.getItemStackFromSlot(EquipmentSlotType.CHEST).equals(CaveArmor.NIGHT_HELMET.get().getDefaultInstance(), true)) {
						
					return true;
						
				}
				
			}
			
		}
		
		return false;
		
	}

	public static boolean hasBlazingArmor(PlayerEntity player) {
		
		if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).equals(CaveArmor.BLAZING_HELMET.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.CHEST).equals(CaveArmor.BLAZING_CHESTPLATE.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.LEGS).equals(CaveArmor.BLAZING_LEGGINS.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.FEET).equals(CaveArmor.BLAZING_BOOTS.get().getDefaultInstance(), true)) {
					
			return true;
					
		} else {
					
			return false;
					
		}
		
	}

}
