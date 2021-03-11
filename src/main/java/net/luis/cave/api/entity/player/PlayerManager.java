package net.luis.cave.api.entity.player;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

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
	
	public static boolean hasItemInInventory(PlayerEntity player, Item item) {
		
		return getItemInInventory(player, item).getItem() == item;
		
	}
	
	public static ItemStack getItemInInventory(PlayerEntity player, Item item) {
		
		IItemHandler itemHandler = player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).orElseThrow(
				() -> new NullPointerException("The mod Capability<IItemHandler> is null"));
		
		if (itemHandler != null) {
			
			for (int i = 0; i < itemHandler.getSlots(); i++) {
				
				ItemStack stack = itemHandler.getStackInSlot(i);
				
				if (item == stack.getItem()) {
					
					return stack;
					
				}
				
			}
			
		}
		
		return ItemStack.EMPTY;
	
	}

}
