package net.luis.cave.events.other;

import net.luis.cave.Cave;
import net.luis.cave.core.BackpackMessage;
import net.luis.cave.core.ModPacketHandler;
import net.luis.cave.init.util.ModKeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class OnClientTickEvent {

	@SubscribeEvent
	public static void WorldTick(TickEvent.ClientTickEvent event) {

		if (ModKeyBinding.BACKPACK_OPEN.isKeyDown()) {
			
			ModPacketHandler.simpleChannel.sendToServer(new BackpackMessage());
			
		}
		
	}
	
}