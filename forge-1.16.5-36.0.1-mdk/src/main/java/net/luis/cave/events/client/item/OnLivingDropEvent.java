package net.luis.cave.events.client.item;

import java.util.List;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveArmor;
import net.luis.cave.init.CaveItems;
import net.luis.cave.init.CaveTools;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnLivingDropEvent {

	@SubscribeEvent
	public static void LivingDrop(LivingDropsEvent event) {
		
		List<ItemEntity> drops = (List<ItemEntity>) event.getDrops();
		Item items[] = new Item[] {CaveItems.ENDERITE_SCRAP.get(), CaveItems.ENDERITE_INGOT.get(), CaveTools.ENDERITE_SWORD.get(), 
				CaveTools.ENDERITE_PICKAXE.get(),CaveTools.ENDERITE_AXE.get(), CaveTools.ENDERITE_SHOVEL.get(), 
				CaveTools.ENDERITE_SHIELD.get(), CaveTools.ENDERITE_BOW.get(), CaveTools.ENDERITE_CROSSBOW.get(), 
				CaveArmor.ENDREITE_BOOTS.get(), CaveArmor.ENDREITE_LEGGINS.get(), CaveArmor.ENDREITE_CHESTPLATE.get(),
				CaveArmor.ENDREITE_ELYTRA.get(), CaveArmor.ENDREITE_HELMET.get(),CaveArmor.NIGHT_BOOTS.get(), 
				CaveArmor.NIGHT_LEGGINS.get(), CaveArmor.NIGHT_CHESTPLATE.get(),CaveArmor.NIGHT_ELYTRA.get(), 
				CaveArmor.NIGHT_HELMET.get()};
		
		for (ItemEntity item : drops) {
			
			ItemEntity itemEntity = (ItemEntity) item.getItem().getAttachedEntity();
			
			for (int j = 0; j < items.length; j++) {
				
				if (items[j] == itemEntity.getItem().getItem()) {
					
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

}
