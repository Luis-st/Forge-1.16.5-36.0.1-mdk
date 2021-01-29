package net.luis.cave.events.entity;

import net.luis.cave.Cave;
import net.luis.cave.init.blocks.CaveBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEntityJoinWorldEvent {

	@SubscribeEvent
	public static void EntityJoinWorld(EntityJoinWorldEvent event) {
		
		Entity entity = event.getEntity();
		World world = event.getWorld();
		
		if (entity instanceof LightningBoltEntity) {
			
			LightningBoltEntity lightning = (LightningBoltEntity) entity;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			
			for (int cx = -32; cx < 32; cx++) {
				
				for (int cy = -32; cy < 32; cy++) {
					
					for (int cz = -32; cz < 32; cz++) {
						
						if (world.getBlockState(new BlockPos(x + cx, y + cy, z + cz)).getBlock() == CaveBlocks.LIGHTNING_ROD.get()) {
							
							lightning.setPositionAndUpdate(x + cx, y + cy, z + cz);
							
						}
						
					}
					
				}
				
			}
			
		}

	}

}
