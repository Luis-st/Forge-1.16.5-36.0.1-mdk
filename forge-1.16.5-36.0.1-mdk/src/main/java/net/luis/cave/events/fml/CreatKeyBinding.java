package net.luis.cave.events.fml;

import net.luis.cave.Cave;
import net.luis.cave.init.util.ModKeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreatKeyBinding {
	
	@SubscribeEvent
	public static void doClientSetup(FMLClientSetupEvent event) {
		
		ClientRegistry.registerKeyBinding(ModKeyBinding.BACKPACK_OPEN);
		ClientRegistry.registerKeyBinding(ModKeyBinding.BACKPACK_NEXT);
		ClientRegistry.registerKeyBinding(ModKeyBinding.BACKPACK_SLOT_0);
		ClientRegistry.registerKeyBinding(ModKeyBinding.BACKPACK_SLOT_1);
		
	}

}
