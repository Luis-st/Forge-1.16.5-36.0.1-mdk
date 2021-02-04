package net.luis.cave.events;

import net.luis.cave.Cave;
import net.luis.cave.blocks.container.SmeltingScreen;
import net.luis.cave.init.CaveContainer;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreatContainerScreen {
	
	@SubscribeEvent
	public static void DoCommonSetup(FMLCommonSetupEvent event) {
		
		event.enqueueWork(() -> ScreenManager.registerFactory(CaveContainer.SMELTING_CONTAINER.get(), SmeltingScreen::new));
		
	}
	
}

