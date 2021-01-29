package net.luis.cave.events.world;

import net.luis.cave.Cave;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnCreateFluidSourceEvent {
	
	@SubscribeEvent
	public static void CreateFluidSource(BlockEvent.CreateFluidSourceEvent event) {
		
		BlockState state = event.getState();
		
		if (state.getBlock() == Blocks.LAVA) {
			
			event.setResult(Result.ALLOW);
			
		}
		
	}
	
}

