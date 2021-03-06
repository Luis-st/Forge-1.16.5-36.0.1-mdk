package net.luis.cave.events.input;

import net.luis.cave.Cave;
import net.luis.cave.core.ModPacketHandler;
import net.luis.cave.core.message.backpack.BackpackDownToolMessage;
import net.luis.cave.core.message.backpack.BackpackNextToolMessage;
import net.luis.cave.core.message.backpack.BackpackOpenMessage;
import net.luis.cave.core.message.backpack.BackpackTopToolMessage;
import net.luis.cave.init.util.ModKeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class OnClientTickEvent {

	@SubscribeEvent
	public static void ClientTick(TickEvent.ClientTickEvent event) {

		if (ModKeyBinding.BACKPACK_OPEN.isKeyDown()) {
			
			ModPacketHandler.simpleChannel.sendToServer(new BackpackOpenMessage());
			
		}
		
		if (ModKeyBinding.BACKPACK_NEXT.isKeyDown()) {
			
			ModPacketHandler.simpleChannel.sendToServer(new BackpackNextToolMessage());
			
		}
		
		if (ModKeyBinding.BACKPACK_SLOT_TOP.isKeyDown()) {
			
			ModPacketHandler.simpleChannel.sendToServer(new BackpackTopToolMessage());
			
		}
		
		if (ModKeyBinding.BACKPACK_SLOT_DOWN.isKeyDown()) {
			
			ModPacketHandler.simpleChannel.sendToServer(new BackpackDownToolMessage());
			
		}
		
	}
	
}