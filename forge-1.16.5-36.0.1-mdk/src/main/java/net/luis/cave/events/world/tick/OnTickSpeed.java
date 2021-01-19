package net.luis.cave.events.world.tick;

import java.util.List;

import net.luis.cave.Cave;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ICommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class OnTickSpeed {

	@SubscribeEvent
	public static void WorldTick(TickEvent.WorldTickEvent event) {

		World world = event.world;
		MinecraftServer server = world.getServer();
		int randomTickSpeed = world.getWorldInfo().getGameRulesInstance().getInt(GameRules.RANDOM_TICK_SPEED);
		
		if (!world.isRemote) {
			
			if (world.getDifficulty() != Difficulty.HARD) {
				
				world.getServer().setDifficultyForAllWorlds(Difficulty.HARD, true);
				
			}
			
			if (randomTickSpeed >= 300) {
				
				if (server != null) { 
					
					sendFeedbackServerTick(server, "randomTickSpeed is too high");
					
				} else {
					
					sendFeedbackClientTick(world, "randomTickSpeed is too high");
					
				}
				
				world.getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, null, null, (ServerWorld) world, 4, null, null, server, null),
						String.format("gamerule %s %d", (GameRules.RANDOM_TICK_SPEED).toString(), 3));
				
			}
			
		}
		
	}
	
	private static void sendFeedbackClientTick(World world, String reason) {
		
		List<? extends PlayerEntity> playerList = world.getPlayers();
		
		for (PlayerEntity player: playerList) {
			
			player.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fServer Overload!"), player.getUniqueID());
			player.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fReason: " + reason), player.getUniqueID());
				
		}
		
	}
	
	private static void sendFeedbackServerTick(MinecraftServer server, String reason) {
		
		PlayerList playerList = server.getPlayerList();
			
		for (PlayerEntity player : playerList.getPlayers()) {
			
			player.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fServer Overload!"), player.getUniqueID());
			player.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fReason: " + reason), player.getUniqueID());
				
		}
		
	}
	
}