package net.luis.cave.api.lib;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;

public class PlayerManager {
	
	public static boolean hasArmor(PlayerEntity player, IArmorMaterial material) {
		
		if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() instanceof ArmorItem &&
			player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() instanceof ArmorItem &&	
			player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() instanceof ArmorItem &&	
			player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() instanceof ArmorItem) {
			
			if (((ArmorItem) player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem()).getArmorMaterial() == material &&
				((ArmorItem) player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem()).getArmorMaterial() == material &&	
				((ArmorItem) player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem()).getArmorMaterial() == material &&	
				((ArmorItem) player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem()).getArmorMaterial() == material) {
					
					return true;
					
			}
			
			return false;
			
		}
			
		return false;
		
	}

}
