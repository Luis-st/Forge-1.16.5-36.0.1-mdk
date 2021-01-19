package net.luis.cave.events;

import java.util.Random;

import net.luis.cave.Cave;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
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
		ServerWorld world = (ServerWorld) player.getEntityWorld();
		
		if (msg.equalsIgnoreCase("?slime")) {
			
			event.setCanceled(true);
			
			if (isSlimeChunk(world, player)) {
				
				player.sendMessage(new StringTextComponent("§e§l[DEBUG]: §fThe current chunk is a slime chunk!"), player.getUniqueID());
				
			}
			
		}
		
	}
	
	private static boolean isSlimeChunk(ServerWorld world, ServerPlayerEntity player) {
		
		Chunk chunk = ((World) world).getChunkAt(new BlockPos(player.getPosX(), player.getPosY(), player.getPosZ()));
		ChunkPos chunkPos = new ChunkPos(chunk.getPos().asLong());
		int chunkPosX = chunkPos.x;
		int chunkPosZ = chunkPos.z;
		long seed = world.getSeed();
		
		Random rnd = new Random(seed + (chunkPosX * chunkPosX * 0x4c1906) + (chunkPosX * 0x5ac0db) + (chunkPosZ * chunkPosZ) * 0x4307a7L + (chunkPosZ * 0x5f24f) ^ 0x3ad8025fL);

		return rnd.nextInt(10) == 0;
		
	}

}
