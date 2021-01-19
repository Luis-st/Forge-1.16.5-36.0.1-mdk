package net.luis.cave.events.item;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveArmor;
import net.luis.cave.init.CaveItems;
import net.luis.cave.init.CaveTools;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnItemTossEvent {

	@SubscribeEvent
	public static void ItemToss(ItemTossEvent event) {
		
		ItemStack item = event.getEntityItem().getItem();
		Item items[] = new Item[] {CaveItems.ENDERITE_SCRAP.get(), CaveItems.ENDERITE_INGOT.get(), CaveTools.ENDERITE_SWORD.get(), 
				CaveTools.ENDERITE_PICKAXE.get(),CaveTools.ENDERITE_AXE.get(), CaveTools.ENDERITE_SHOVEL.get(), 
				CaveTools.ENDERITE_SHIELD.get(), CaveTools.ENDERITE_BOW.get(), CaveTools.ENDERITE_CROSSBOW.get(), 
				CaveArmor.ENDREITE_BOOTS.get(), CaveArmor.ENDREITE_LEGGINS.get(), CaveArmor.ENDREITE_CHESTPLATE.get(),
				CaveArmor.ENDREITE_ELYTRA.get(), CaveArmor.ENDREITE_HELMET.get(),CaveArmor.NIGHT_BOOTS.get(), 
				CaveArmor.NIGHT_LEGGINS.get(), CaveArmor.NIGHT_CHESTPLATE.get(),CaveArmor.NIGHT_ELYTRA.get(), 
				CaveArmor.NIGHT_HELMET.get()};
		
		for (int i = 0; i < items.length; i++) {
			
			if (items[i] == item.getItem()) {
				
				ItemEntity entityItem = event.getEntityItem();
				entityItem.setNoGravity(true);
				entityItem.setMotion(0, 0, 0);
				
			}
			
		}
		
	}

}

