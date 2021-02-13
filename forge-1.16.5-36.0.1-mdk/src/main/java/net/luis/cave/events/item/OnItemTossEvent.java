package net.luis.cave.events.item;

import net.luis.cave.Cave;
import net.luis.cave.api.lib.ItemManager;
import net.luis.cave.init.util.ModGameRule;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnItemTossEvent {

	@SubscribeEvent
	public static void ItemToss(ItemTossEvent event) {
		
		ItemStack item = event.getEntityItem().getItem();
		ItemEntity itemEntity = event.getEntityItem();
		World world = itemEntity.getEntityWorld();
		
		if (ItemManager.isEnderite(item)) {
			
			if (world.getGameRules().getBoolean(ModGameRule.DISABLE_ITEM_GRAVITY.getRule())) {
				
				ItemManager.setNoGravityItem(itemEntity);
				
			}
			
		} else if (ItemManager.isNight(item)) {
			
			if (world.getGameRules().getBoolean(ModGameRule.DISABLE_ITEM_GRAVITY.getRule())) {
				
				ItemManager.setNoGravityItem(itemEntity);
				
			}
			
		}
		
	}

}

