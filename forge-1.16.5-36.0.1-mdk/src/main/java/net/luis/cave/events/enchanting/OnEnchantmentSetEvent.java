package net.luis.cave.events.enchanting;

import net.luis.cave.Cave;
import net.luis.cave.api.event.events.EnchantmentSetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OnEnchantmentSetEvent {

	@SubscribeEvent
	public static void EntityJoinWorld(EnchantmentSetEvent event) {
		
		Cave.LOGGER.debug("EnchantmentSetEvent");

	}

}
