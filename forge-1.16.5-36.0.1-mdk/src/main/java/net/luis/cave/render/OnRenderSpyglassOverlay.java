package net.luis.cave.render;

import com.mojang.blaze3d.systems.RenderSystem;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveItems;
import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.PointOfView;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class OnRenderSpyglassOverlay {
	
	@SuppressWarnings({ "resource", "static-access", "deprecation" })
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void RenderSpyglassOverlay(RenderGameOverlayEvent event) {
		
		PlayerEntity player = Minecraft.getInstance().player;
		GameSettings settings = Minecraft.getInstance().gameSettings;
		int posX = event.getWindow().getScaledWidth() / 2;
		int posY = event.getWindow().getScaledHeight() / 2;
		
		if (player.getActiveItemStack().getItem() == CaveItems.SPYGLASS.get()) {
			
			if (settings.getPointOfView()== PointOfView.FIRST_PERSON) {
				
				RenderSystem.disableDepthTest();
				RenderSystem.depthMask(false);
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				RenderSystem.disableAlphaTest();
				RenderSystem.enableBlend();
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("cave:textures/misc/spyglass_scope.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), 0, 0, 0, 0, posX * 2, posY * 2, 480, 270);
				RenderSystem.depthMask(true);
				RenderSystem.enableDepthTest();
				RenderSystem.enableAlphaTest();
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				
			}
			
		}
		
	}

}

