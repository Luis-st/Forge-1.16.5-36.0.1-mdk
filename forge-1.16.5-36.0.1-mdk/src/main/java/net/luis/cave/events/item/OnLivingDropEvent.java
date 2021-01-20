package net.luis.cave.events.item;

import java.util.List;

import net.luis.cave.Cave;
import net.luis.cave.lib.ItemManager;
import net.minecraft.entity.item.ItemEntity;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnLivingDropEvent {

	@SubscribeEvent
	public static void LivingDrop(LivingDropsEvent event) {
		
		List<ItemEntity> drops = (List<ItemEntity>) event.getDrops();
		
		for (ItemEntity item : drops) {
			
			ItemEntity itemEntity = (ItemEntity) item.getItem().getAttachedEntity();
			
			if (ItemManager.isEnderite(itemEntity.getItem())) {
				
				itemEntity.setInvulnerable(true);
				itemEntity.setNoGravity(true);
				itemEntity.setMotion(0, 0, 0);
				
				if (itemEntity.getPosY() < 0) {
					
					itemEntity.setPositionAndUpdate(itemEntity.getPosX(), 3, itemEntity.getPosZ());
					itemEntity.setInvulnerable(false);
					
				}
				
			} else if (ItemManager.isNight(itemEntity.getItem())) {
				
				itemEntity.setInvulnerable(true);
				itemEntity.setNoGravity(true);
				itemEntity.setMotion(0, 0, 0);
				
				if (itemEntity.getPosY() < 0) {
					
					itemEntity.setPositionAndUpdate(itemEntity.getPosX(), 3, itemEntity.getPosZ());
					itemEntity.setInvulnerable(false);
					
				}
				
			}
			
		}
		
	}

}
