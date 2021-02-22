package net.luis.cave.client.render.item.tooltip;

import net.luis.cave.Cave;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class OnRenderTooltipEvent {
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void RenderTooltip(RenderTooltipEvent event) {
				
		
		
	}

}

