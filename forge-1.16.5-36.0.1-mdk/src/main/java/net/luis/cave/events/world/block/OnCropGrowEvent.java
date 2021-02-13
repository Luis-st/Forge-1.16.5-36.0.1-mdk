package net.luis.cave.events.world.block;

import net.luis.cave.Cave;
import net.luis.cave.init.util.ModGameRule;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnCropGrowEvent {
	
	@SubscribeEvent
	public static void CropGrow(BlockEvent.CropGrowEvent event) {
		
		World world = (World) event.getWorld();
		
		if (!world.getGameRules().getBoolean(ModGameRule.DO_CROP_GROW.getRule())) {
			
			event.setResult(Result.DENY);
			
		}
		
	}
	
}
