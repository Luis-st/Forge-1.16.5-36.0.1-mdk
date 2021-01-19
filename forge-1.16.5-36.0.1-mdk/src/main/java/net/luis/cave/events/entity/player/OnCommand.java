package net.luis.cave.events.entity.player;

import java.util.List;

import net.luis.cave.Cave;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnCommand {

	@SubscribeEvent
	public static void Command(CommandEvent event) {
		
		String command = event.getParseResults().getReader().getRead();
		
		if (Cave.pvpServer) {
			
			event.setCanceled(true); 
			Cave.enableCommands = true;
			
		}
		
		if (!Cave.enableCommands) {
			
			if (event.getParseResults().getContext().getSource().getEntity() != null) {
				
				Entity entity = event.getParseResults().getContext().getSource().getEntity();
				
				if (entity instanceof PlayerEntity) {
					
					PlayerEntity player = (PlayerEntity) entity;
					World world = player.getEntityWorld();
					MinecraftServer server = world.getServer();
					
					if (!world.isRemote) {
						
						event.setCanceled(commandBlackList(command));
						
						if (server != null) {
							
							sendFeedbackServer(event, server, player, command);
							
						} else {
							
							sendFeedbackClient(event, world, player, command);
							
						}
						
					}
					
				}
				
			} else {
				
				sendFeedbackConsol(event, command);
				
			}
			
		}
		
	}
	
	private static void sendFeedbackClient(CommandEvent event, World world, PlayerEntity player, String command) {
		
		List<? extends PlayerEntity> playerList = world.getPlayers();
		
		if (event.isCanceled()) {
			
			for (PlayerEntity playerEntity : playerList) {
					
				playerEntity.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fThe player "+ player.getName().getString() +" wanted to execute a command!"), playerEntity.getUniqueID());
				playerEntity.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fCommand: " + command), playerEntity.getUniqueID());
					
			}
				
		} else {
			
			for (PlayerEntity playerEntity : playerList) {
				
				playerEntity.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fCommand: " + command), playerEntity.getUniqueID());
					
			}
			
		}
		
	}
	
	private static void sendFeedbackServer(CommandEvent event, MinecraftServer server, PlayerEntity player, String command) {
		
		PlayerList playerList = server.getPlayerList();
		
		if (event.isCanceled()) {
			
			for (PlayerEntity playerEntity : playerList.getPlayers()) {
					
				playerEntity.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fThe player "+ player.getName().getString() +" wanted to execute a command!"), playerEntity.getUniqueID());
				playerEntity.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fCommand: " + command), playerEntity.getUniqueID());
					
			}
				
		} else {
			
			for (PlayerEntity playerEntity : playerList.getPlayers()) {
				
				playerEntity.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fCommand: " + command), playerEntity.getUniqueID());
					
			}
			
		}
		
	}
	
	private static void sendFeedbackConsol(CommandEvent event, String command) {
		
		World world = event.getParseResults().getContext().getSource().getWorld();
		List<? extends PlayerEntity> players = world.getPlayers();
		
		for (PlayerEntity playerEntity : players) {
			
			playerEntity.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fA command was executed on the console!"), playerEntity.getUniqueID());
			
			if (event.isCanceled()) {
				
				playerEntity.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fThe execution of the command was canceled!"), playerEntity.getUniqueID());
				playerEntity.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fCommand: " + command), playerEntity.getUniqueID());
				
			} else {
				
				playerEntity.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fCommand: " + command), playerEntity.getUniqueID());
				
			}
			
		}
		
	}
	
	private static boolean commandBlackList(String command) {
		
		if (command.contains("/attribute")) {
			
			return true;
			
		} else if (command.contains("/effect")) {
			
			return true;
			
		} else if (command.contains("/enchant")) {
			
			return true;
			
		} else if (command.contains("/experience")) {
			
			return true;
			
		} else if (command.contains("/gamemode")) {
			
			return true;
			
		} else if (command.contains("/give")) {
			
			return true;
			
		} else if (command.contains("/kill")) {
			
			return true;
			
		} else if (command.contains("/locate")) {
			
			return true;
			
		} else if (command.contains("/locatebiome")) {
			
			return true;
			
		} else if (command.contains("/setblock")) {
			
			return true;
			
		} else if (command.contains("/summon")) {
			
			return true;
			
		} else if (command.contains("/tp")) {
			
			return true;
			
		} else if (command.contains("/teleport")) {
			
			return true;
			
		} else if (command.contains("/time")) {
			
			return true;
			
		} else if (command.contains("/weather")) {
			
			return true;
			
		} else if (command.contains("/xp")) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}

}
