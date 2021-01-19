package net.luis.cave.events.client.entity;

import net.luis.cave.Cave;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnSleepingTimeCheckEvent {
	
	@SubscribeEvent
	public static void SleepingTimeCheck(net.minecraftforge.event.entity.player.SleepingTimeCheckEvent event) {
		
		PlayerEntity player = event.getPlayer();
		World world = player.getEntityWorld();
		
		if (world.isRaining()) {
			
			event.setResult(net.minecraftforge.eventbus.api.Event.Result.ALLOW);
			
		}

	}

}

