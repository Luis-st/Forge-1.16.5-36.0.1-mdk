package net.luis.cave.events.fml;

import net.luis.cave.Cave;
import net.luis.cave.client.render.entity.DiamondArrowRender;
import net.luis.cave.client.render.entity.JadeArrowRender;
import net.luis.cave.client.render.entity.NetheriteArrowRender;
import net.luis.cave.client.render.item.EnderiteElytraLayer;
import net.luis.cave.client.render.item.NightElytraLayer;
import net.luis.cave.client.render.tileentity.ModShulkerTileEntityRenderer;
import net.luis.cave.init.ModEntityType;
import net.luis.cave.init.util.ModTileEntityType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CreatRenderLayer {
	
	@SubscribeEvent
	public static void doClientSetup(FMLClientSetupEvent event) {
		
		for (PlayerRenderer playerRenderer : Minecraft.getInstance().getRenderManager().getSkinMap().values()) {
			
			playerRenderer.addLayer(new EnderiteElytraLayer<>(playerRenderer));
			playerRenderer.addLayer(new NightElytraLayer<>(playerRenderer));
			
		}
		
		RenderingRegistry.registerEntityRenderingHandler(ModEntityType.JADE_ARROW.get(), JadeArrowRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityType.DIAMOND_ARROW.get(), DiamondArrowRender::new);
		RenderingRegistry.registerEntityRenderingHandler(ModEntityType.NETHERITE_ARROW.get(), NetheriteArrowRender::new);
		
		// TODO: fix
		
		ClientRegistry.bindTileEntityRenderer(ModTileEntityType.SHULKER.get(), ModShulkerTileEntityRenderer::new);
		
	}

}
