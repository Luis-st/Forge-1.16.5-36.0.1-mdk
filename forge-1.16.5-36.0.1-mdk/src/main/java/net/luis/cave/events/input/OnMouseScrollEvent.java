package net.luis.cave.events.input;

import net.luis.cave.Cave;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class OnMouseScrollEvent {

	@SubscribeEvent
	public static void MouseScroll(InputEvent.MouseScrollEvent event) {
		
		double delta = event.getScrollDelta();
		
		if (delta > 0) {
			
			
			
		} else if (delta < 0) {
			
			
			
		}
		
	}
	
}