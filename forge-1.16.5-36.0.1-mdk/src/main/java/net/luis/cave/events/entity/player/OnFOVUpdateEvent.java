package net.luis.cave.events.entity.player;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnFOVUpdateEvent {
	
	@SubscribeEvent
	public static void FOVUpdate(FOVUpdateEvent event) {
		
		PlayerEntity player = event.getEntity();
		
		if (player.getActiveItemStack().getItem() == CaveItems.SPYGLASS.get()) {
			
			event.setNewfov(0.1f);
			
		}

	}

}

