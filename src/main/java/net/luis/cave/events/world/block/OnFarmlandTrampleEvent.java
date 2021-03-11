package net.luis.cave.events.world.block;

import net.luis.cave.Cave;
import net.luis.cave.init.util.ModGameRule;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnFarmlandTrampleEvent {
	
	@SubscribeEvent
	public static void FarmlandTrample(BlockEvent.FarmlandTrampleEvent event) {
		
		World world = (World) event.getWorld();
		
		if (world.getGameRules().getBoolean(ModGameRule.DISABLE_FARMLAND_TRAMPLE.getRule())) {
			
			event.setCanceled(true);
			
		}
		
	}
	
}

