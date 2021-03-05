package net.luis.cave.events.entity.player;

import net.luis.cave.Cave;
import net.luis.cave.init.items.ModItems;
import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.PointOfView;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnFOVUpdateEvent {
	
	@SubscribeEvent
	@SuppressWarnings("resource")
	public static void FOVUpdate(FOVUpdateEvent event) {
		
		PlayerEntity player = event.getEntity();
		GameSettings settings = Minecraft.getInstance().gameSettings;
		
		if (player.getActiveItemStack().getItem() == ModItems.SPYGLASS.get()) {
			
			if (settings.getPointOfView()== PointOfView.FIRST_PERSON) {
				
				event.setNewfov(0.1f);
				
			}
			
		}

	}

}

