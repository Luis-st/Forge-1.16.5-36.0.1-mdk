package net.luis.cave.events.item;

import net.luis.cave.Cave;
import net.luis.cave.init.util.ModGameRule;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnItemExpireEvent {

	@SubscribeEvent
	public static void ItemExpire(ItemExpireEvent event) {
		
		World world = event.getEntityItem().getEntityWorld();
		
		if (world.getGameRules().getBoolean(ModGameRule.DISABLE_ITEM_DESPAWN.getRule())) {
			
			event.setCanceled(true);
			
		}
		
	}

}
