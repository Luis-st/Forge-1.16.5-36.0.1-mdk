package net.luis.cave.events.fml;

import net.luis.cave.Cave;
import net.luis.cave.client.screen.SmeltingScreen;
import net.luis.cave.init.util.ModContainer;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreatContainerScreen {
	
	@SubscribeEvent
	public static void doCommonSetup(FMLCommonSetupEvent event) {
		
		event.enqueueWork(() -> ScreenManager.registerFactory(ModContainer.SMELTING_CONTAINER.get(), SmeltingScreen::new));
		
	}
	
}

