package net.luis.cave.api.world;

import java.util.Random;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.server.ServerWorld;

public class WorldManager {
	
	public static boolean isSlimeChunk(World world, ServerPlayerEntity player) {
		
		if (!world.isRemote) {
			
			Chunk chunk = world.getChunkAt(new BlockPos(player.getPosX(), player.getPosY(), player.getPosZ()));
			ChunkPos chunkPos = new ChunkPos(chunk.getPos().asLong());
			int chunkPosX = chunkPos.x;
			int chunkPosZ = chunkPos.z;
			long seed = ((ServerWorld) world).getSeed();
			
			Random rnd = new Random(seed + (chunkPosX * chunkPosX * 0x4c1906) +  (chunkPosX * 0x5ac0db) + (chunkPosZ * chunkPosZ) * 0x4307a7L + (chunkPosZ * 0x5f24f) ^ 0x3ad8025fL);
			
			return rnd.nextInt(10) == 0;
			
		}
		
		return false;
		
	}

}
