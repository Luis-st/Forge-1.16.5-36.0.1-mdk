package net.luis.cave.events.world;

import net.luis.cave.Cave;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.SleepingTimeCheckEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnSleepingTimeCheckEvent {
	
	@SubscribeEvent
	public static void SleepingTimeCheck(SleepingTimeCheckEvent event) {
		
		PlayerEntity player = event.getPlayer();
		World world = player.getEntityWorld();
		
		if (world.isRaining()) {
			
			event.setResult(net.minecraftforge.eventbus.api.Event.Result.ALLOW);
			
		}

	}

}

