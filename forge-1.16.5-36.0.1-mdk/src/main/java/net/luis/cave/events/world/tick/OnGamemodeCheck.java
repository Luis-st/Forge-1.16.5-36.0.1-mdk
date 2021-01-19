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

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class OnGamemodeCheck {

	@SubscribeEvent
	public static void WorldTick(TickEvent.WorldTickEvent event) {

		World world = event.world;
		MinecraftServer server = world.getServer();
		
		if (!world.isRemote) {
			
			if (!Cave.pvpServer) {
				
				checkGamemode(server, world);
				
			}
			
		}
		
	}
	
	private static void checkGamemode(MinecraftServer server, World world) {
		
		if (server != null) {
			
			PlayerList playerList = server.getPlayerList();
			
			for (PlayerEntity playerEntity : playerList.getPlayers()) {
				
				if (!Cave.enableCommands) {
					
					if (playerEntity.isCreative() || playerEntity.isSpectator()) {
						
						playerEntity.setGameType(GameType.SURVIVAL);
						
						for (PlayerEntity playerSendMessage : playerList.getPlayers()) {
							
							playerSendMessage.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fThe player: " + 
																playerEntity.getName().getString() + 
															   	" was in a gamemode which is not allowed on this server, the player's game mode was set to survival"), 
																playerSendMessage.getUniqueID());
							
						}
						
					}
					
				}
				
			}
			
		} else {
			
			List<? extends PlayerEntity> players = world.getPlayers();
			
			for (PlayerEntity playerEntity : players) {
				
				if (!Cave.enableCommands) {
					
					if (playerEntity.isCreative() || playerEntity.isSpectator()) {
						
						playerEntity.setGameType(GameType.SURVIVAL);
						
						for (PlayerEntity playerSendMessage : players) {
							
							playerSendMessage.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fThe player: " + 
																playerEntity.getName().getString() + 
															   	" was in a gamemode which is not allowed on this server, the player's game mode was set to survival"), 
																playerSendMessage.getUniqueID());
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
}