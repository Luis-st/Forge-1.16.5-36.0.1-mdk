package net.luis.cave.events.enchanting;

import java.util.List;

import net.luis.cave.Cave;
import net.luis.cave.api.event.events.EnchantmentSetEvent;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEnchantmentSetEvent {

	@SubscribeEvent
	public static void EnchantmentSet(EnchantmentSetEvent event) {
		
		Cave.LOGGER.debug("row: " + event.getEnchantRow());
		
		List<EnchantmentData> dataList = event.getDataList();
		
		for (EnchantmentData enchantmentData : dataList) {
			
			Cave.LOGGER.debug("enchantment: " + enchantmentData.enchantment.getRegistryName());
			Cave.LOGGER.debug("enchantmentLevel: " + enchantmentData.enchantmentLevel);
			
		}

	}

}
