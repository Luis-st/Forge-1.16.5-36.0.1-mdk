package net.luis.cave.events.entity.player;

import net.luis.cave.Cave;
import net.luis.cave.lib.WorldManager;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class OnServerChatEvent {
	
	@SubscribeEvent
	public static void ServerChat(ServerChatEvent event) {
		
		String msg = event.getMessage();
		ServerPlayerEntity player = event.getPlayer();
		World world = player.getEntityWorld();
		
		if (msg.equalsIgnoreCase("?slime")) {
			
			event.setCanceled(true);
			
			if (WorldManager.isSlimeChunk(world, player)) {
				
				player.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fThe current chunk is a slime chunk!"), player.getUniqueID());
				
			}
			
		}
		
		if (msg.equalsIgnoreCase("?seed")) {
			
			event.setCanceled(true);
			
			if (!world.isRemote) {
				
				ServerWorld serverWorld = (ServerWorld) world;
				
				player.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fThe seed of the world is: " + serverWorld.getSeed()), player.getUniqueID());
				
			}
			
		}
		
	}
	
}
