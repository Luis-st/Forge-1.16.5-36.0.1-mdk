package net.luis.cave.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;

import net.luis.cave.Cave;
import net.luis.cave.init.items.ModItems;
import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.PointOfView;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class SpyglassOverlay {
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	@SuppressWarnings({ "resource", "static-access" })
	public static void RenderSpyglassOverlay(RenderGameOverlayEvent.Pre event) {
		
		PlayerEntity player = Minecraft.getInstance().player;
		GameSettings settings = Minecraft.getInstance().gameSettings;
		int posX = event.getWindow().getScaledWidth();
		int posY = event.getWindow().getScaledHeight();
		
		if (player.getActiveItemStack().getItem() == ModItems.SPYGLASS.get()) {
			
			if (settings.getPointOfView()== PointOfView.FIRST_PERSON) {
				
				if (event.getType() != ElementType.VIGNETTE) {
					
					event.setCanceled(true);
					
				}
				
				RenderSystem.disableDepthTest();
				RenderSystem.depthMask(false);
				RenderSystem.enableBlend();
				RenderSystem.blendFunc(770, 771);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("cave:textures/misc/spyglass_scope.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), 0, 0, 0, 0, posX, posY, 480, 270);
				RenderSystem.depthMask(true);
				RenderSystem.enableDepthTest();
				
			}
			
		}
		
	}

}

