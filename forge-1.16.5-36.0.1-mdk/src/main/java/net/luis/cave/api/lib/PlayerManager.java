package net.luis.cave.api.lib;

import java.util.concurrent.atomic.AtomicReference;

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
	
	public static ItemStack getItem(PlayerEntity player, Item item) {
		
		AtomicReference<IItemHandler> itemHandler = new AtomicReference<>();
		player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> itemHandler.set(capability));
		
		if (itemHandler.get() != null) {
			
			for (int i = 0; i < itemHandler.get().getSlots(); i++) {
				
				ItemStack stack = itemHandler.get().getStackInSlot(i);
				
				if (item == stack.getItem()) {
					
					return stack;
					
				}
				
			}
			
		}
		
		return ItemStack.EMPTY;
	
	}

}
