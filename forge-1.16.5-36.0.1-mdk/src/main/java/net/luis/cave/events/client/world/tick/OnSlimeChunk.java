package net.luis.cave.events.client.world.tick;

import java.util.List;
import java.util.Random;

import net.luis.cave.Cave;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnSlimeChunk {
	
	@SubscribeEvent
	public static void WorldTick(TickEvent.WorldTickEvent event) {
		
		ServerWorld world = (ServerWorld) event.world;
		List<ServerPlayerEntity> players = world.getPlayers();
		long seed = world.getSeed();
	
		for (ServerPlayerEntity player : players) {
			
			Chunk chunk = (Chunk) world.getChunk(new BlockPos(player.getPositionVec()));
			ChunkPos chunkPos = chunk.getPos();
			
			if (isSlimeChunk(chunkPos, seed)) {
				
				if (world.getGameTime() % (600 - world.rand.nextInt(150)) == 0) {
					
					BlockPos pos = randomPos(world, chunk);
					
					if (pos != null) {
						
						SlimeEntity slime = new SlimeEntity(EntityType.SLIME, world);
						slime.setLocationAndAngles(chunkPos.getXStart() + pos.getX(), pos.getY(), chunkPos.getZStart() + pos.getZ(), world.rand.nextFloat() * 360, 0);
						slime.onInitialSpawn(world, world.getDifficultyForLocation(pos), SpawnReason.MOB_SUMMONED, null, null);
						world.addEntity(slime);
						slime.fallDistance = 0f;
						
					}
					
				}
				
			}
			
		}
		
	}
	
	private static boolean isSlimeChunk(ChunkPos chunkPos, long seed) {
		
		int x = chunkPos.x;
		int z = chunkPos.z;
		
		Random rnd = new Random(seed + (x * x * 0x4c1906) + (x * 0x5ac0db) + (z * z) * 0x4307a7L + (z * 0x5f24f) ^ 0x3ad8025fL);
		
		return rnd.nextInt(10) == 0;
		
	}

	private static BlockPos randomPos(ServerWorld world, Chunk chunk) {
		
		int x = world.rand.nextInt(16);
		int z = world.rand.nextInt(16);
		int y = checkAir(world, x, z);
		
		BlockPos pos = new BlockPos(x, y, z);
		
		if (y != -1) {
			
			return pos;
			
		} else {
			
			return null;
			
		}
		
	}
	
	private static int checkAir(ServerWorld world, int x, int z) {
		
		for (int y = 0; y < 40; y++) {
			
			if (isAir(world, x, y, z)) {
				
				return y;
				
			}
			
		}
		
		return -1;
		
	}
	
	private static boolean isAir(ServerWorld world, int x, int y, int z) {
		
		if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.AIR) {
			
			return true;
			
		} else if (world.getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.CAVE_AIR) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
}
