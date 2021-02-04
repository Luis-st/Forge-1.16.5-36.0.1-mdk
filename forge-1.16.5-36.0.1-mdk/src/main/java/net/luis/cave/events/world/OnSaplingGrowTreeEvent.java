package net.luis.cave.events.world;

import net.luis.cave.Cave;
import net.luis.cave.init.util.ModGameRules;
import net.minecraft.world.World;
import net.minecraftforge.event.world.SaplingGrowTreeEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnSaplingGrowTreeEvent {
	
	@SubscribeEvent
	public static void SaplingGrowTree(SaplingGrowTreeEvent event) {
		
		World world = (World) event.getWorld();
		
		if (!world.getGameRules().getBoolean(ModGameRules.DO_SAPLING_GROW.getRule())) {
			
			event.setResult(Result.DENY);
			
		}
		
	}
	
}
