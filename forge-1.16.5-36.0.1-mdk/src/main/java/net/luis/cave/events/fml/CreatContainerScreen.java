package net.luis.cave.events.fml;

import net.luis.cave.Cave;
import net.luis.cave.client.screen.container.ModChestScreen9x7;
import net.luis.cave.client.screen.container.ModChestScreen9x8;
import net.luis.cave.client.screen.container.ModShulkerBoxScreen;
import net.luis.cave.client.screen.container.SmeltingScreen;
import net.luis.cave.init.util.ModContainerType;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreatContainerScreen {
	
	@SubscribeEvent
	public static void doCommonSetup(FMLCommonSetupEvent event) {
		
		event.enqueueWork(() -> ScreenManager.registerFactory(ModContainerType.SMELTING_CONTAINER.get(), SmeltingScreen::new));
		event.enqueueWork(() -> ScreenManager.registerFactory(ModContainerType.GENERIC_9X7.get(), ModChestScreen9x7::new));
		event.enqueueWork(() -> ScreenManager.registerFactory(ModContainerType.GENERIC_9X8.get(), ModChestScreen9x8::new));
		event.enqueueWork(() -> ScreenManager.registerFactory(ModContainerType.SHULKER_BOX_CONTAINER.get(), ModShulkerBoxScreen::new));
		
	}
	
}

