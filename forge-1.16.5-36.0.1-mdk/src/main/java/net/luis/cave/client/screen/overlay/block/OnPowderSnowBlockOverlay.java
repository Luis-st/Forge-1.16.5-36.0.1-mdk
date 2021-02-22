package net.luis.cave.client.screen.overlay.block;

import net.luis.cave.Cave;
import net.luis.cave.init.blocks.ModBlocks;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent.OverlayType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class OnPowderSnowBlockOverlay {
	
	@SubscribeEvent
	@SuppressWarnings("unused")
	public static void RenderPowderSnowBlockOverlay(RenderBlockOverlayEvent event) {
		
		// TODO: fix
		
		MainWindow window = Minecraft.getInstance().getMainWindow();
		int posX = window.getScaledWidth();
		int posY = window.getScaledHeight();
		
		if (event.getOverlayType() == OverlayType.BLOCK) {
			
			if (event.getBlockForOverlay().getBlock() == ModBlocks.POWDER_SNOW.get()) {
				
				
				
			}
			
		}
		
	}

}
