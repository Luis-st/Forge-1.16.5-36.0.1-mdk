package net.luis.cave.events.world.block;

import net.luis.cave.Cave;
import net.luis.cave.world.CaveGameRules;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnCreateFluidSourceEvent {
	
	@SubscribeEvent
	public static void CreateFluidSource(BlockEvent.CreateFluidSourceEvent event) {
		
		BlockState state = event.getState();
		World world = (World) event.getWorld();
		
		if (state.getBlock() == Blocks.LAVA) {
			
			if (world.getGameRules().getBoolean(CaveGameRules.ENABLE_LAVA_FLUID_SOURCE.getRule())) {
				
				event.setResult(Result.ALLOW);
				
			}
			
		}
		
	}
	
}

