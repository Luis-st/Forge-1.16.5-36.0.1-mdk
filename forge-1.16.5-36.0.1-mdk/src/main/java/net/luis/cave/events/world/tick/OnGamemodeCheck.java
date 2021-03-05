package net.luis.cave.events.world.tick;

import java.util.List;

import net.luis.cave.Cave;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class OnGamemodeCheck {

	@SubscribeEvent
	public static void WorldTick(TickEvent.WorldTickEvent event) {

		World world = event.world;
		MinecraftServer server = world.getServer();
		
		if (!world.isRemote) {
			
			checkGamemode(server, world);
			
		}
		
	}
	
	private static void checkGamemode(MinecraftServer server, World world) {
		
		if (server != null) {
			
			PlayerList playerList = server.getPlayerList();
			
			for (PlayerEntity playerEntity : playerList.getPlayers()) {
				
				if (playerEntity.isCreative() || playerEntity.isSpectator()) {
					
					playerEntity.setGameType(GameType.SURVIVAL);
					
					for (PlayerEntity playerSendMessage : playerList.getPlayers()) {
						
						sendFeedback(playerEntity, playerSendMessage);
						
					}
					
				}
				
			}
			
		} else {
			
			List<? extends PlayerEntity> players = world.getPlayers();
			
			for (PlayerEntity playerEntity : players) {
				
				if (playerEntity.isCreative() || playerEntity.isSpectator()) {
					
					playerEntity.setGameType(GameType.SURVIVAL);
					
					for (PlayerEntity playerSendMessage : players) {
						
						sendFeedback(playerEntity, playerSendMessage);
						
					}
					
				}
				
			}
			
		}
		
	}
	
	private static void sendFeedback(PlayerEntity player, PlayerEntity playerSendMessage) {
		
		playerSendMessage.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fThe player: " + 
				player.getName().getString() + 
			   	" was in a gamemode which is not allowed on this server, the player's game mode was set to survival"), 
				playerSendMessage.getUniqueID());
		
	}
	
}