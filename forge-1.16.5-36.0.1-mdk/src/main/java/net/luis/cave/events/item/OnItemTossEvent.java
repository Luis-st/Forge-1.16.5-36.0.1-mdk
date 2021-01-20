package net.luis.cave.events.item;

import net.luis.cave.Cave;
import net.luis.cave.lib.ItemManager;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnItemTossEvent {

	@SubscribeEvent
	public static void ItemToss(ItemTossEvent event) {
		
		ItemStack item = event.getEntityItem().getItem();
		
		if (ItemManager.isEnderite(item)) {
			
			ItemEntity itemEntity = event.getEntityItem();
			itemEntity.setNoGravity(true);
			itemEntity.setMotion(0, 0, 0);
			
			if (itemEntity.getPosY() < 0) {
				
				itemEntity.setPositionAndUpdate(itemEntity.getPosX(), 3, itemEntity.getPosZ());
				itemEntity.setInvulnerable(false);
				
			}
			
		} else if (ItemManager.isNight(item)) {
			
			ItemEntity itemEntity = event.getEntityItem();
			itemEntity.setNoGravity(true);
			itemEntity.setMotion(0, 0, 0);
			
			if (itemEntity.getPosY() < 0) {
				
				itemEntity.setPositionAndUpdate(itemEntity.getPosX(), 3, itemEntity.getPosZ());
				itemEntity.setInvulnerable(false);
				
			}
			
		}
		
	}

}

