package net.luis.cave.events.fml;

import net.luis.cave.Cave;
import net.luis.cave.client.screen.container.BackpackScreen;
import net.luis.cave.client.screen.container.CraftingStationScreen;
import net.luis.cave.client.screen.container.ModBeaconScreen;
import net.luis.cave.client.screen.container.ModChestScreen17x8;
import net.luis.cave.client.screen.container.ModChestScreen9x8;
import net.luis.cave.client.screen.container.ModEnchantingTableScreen;
import net.luis.cave.client.screen.container.ModEnderChestScreen;
import net.luis.cave.client.screen.container.SmeltingScreen;
import net.luis.cave.init.util.ModContainerType;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreatContainerScreen {
	
	@SubscribeEvent
	public static void doCommonSetup(FMLCommonSetupEvent event) {
		
		event.enqueueWork(() -> ScreenManager.registerFactory(ModContainerType.SMELTING.get(), SmeltingScreen::new));
		event.enqueueWork(() -> ScreenManager.registerFactory(ModContainerType.GENERIC_9X8.get(), ModChestScreen9x8::new));
		event.enqueueWork(() -> ScreenManager.registerFactory(ModContainerType.ENDER_CHEST.get(), ModEnderChestScreen::new));
		event.enqueueWork(() -> ScreenManager.registerFactory(ModContainerType.GENERIC_17X8.get(), ModChestScreen17x8::new));
		event.enqueueWork(() -> ScreenManager.registerFactory(ModContainerType.CRAFTING_STATION.get(), CraftingStationScreen::new));
		event.enqueueWork(() -> ScreenManager.registerFactory(ModContainerType.ENCHANTING_TABLE.get(), ModEnchantingTableScreen::new));
		event.enqueueWork(() -> ScreenManager.registerFactory(ModContainerType.BEACON.get(), ModBeaconScreen::new));
		event.enqueueWork(() -> ScreenManager.registerFactory(ModContainerType.BACKPACK.get(), BackpackScreen::new));
		
	}
	
}

