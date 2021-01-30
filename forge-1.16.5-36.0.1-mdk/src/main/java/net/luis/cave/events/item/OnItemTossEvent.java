package net.luis.cave.events.item;

import net.luis.cave.Cave;
import net.luis.cave.util.lib.ItemManager;
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
		ItemEntity itemEntity = event.getEntityItem();
		
		if (ItemManager.isEnderite(item)) {
			
			ItemManager.setNoGravityItem(itemEntity);
			
		} else if (ItemManager.isNight(item)) {
			
			ItemManager.setNoGravityItem(itemEntity);
			
		}
		
	}

}

