package net.luis.cave.events.world.tick;

import java.util.List;

import net.luis.cave.Cave;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class OnSleepJump {

	@SubscribeEvent
	public static void WorldTick(TickEvent.WorldTickEvent event) {

		World world = event.world;
		List<? extends PlayerEntity> players = world.getPlayers();
		
		if (!world.isRemote) {
			
			int sleepPlayers = 0;
			int playerCount = world.getPlayers().size();
			
			for (PlayerEntity playerEntity : players) {
				
				if (playerEntity.isSleeping()) {
					
					sleepPlayers++;
					
				}
				
			}
			
			if (playerCount == sleepPlayers) {
				
				
				
			} else {
				
				ServerWorld serverWorld = (ServerWorld) world;
				
				if (playerCount / 2 <= sleepPlayers) {
					
					if (sleepPlayers != 0) {
						
						serverWorld.setDayTime(0);
						serverWorld.func_241113_a_(0, 0, false, false);
						
					}
					
				}
				
			}
			
		}
		
	}
	
}