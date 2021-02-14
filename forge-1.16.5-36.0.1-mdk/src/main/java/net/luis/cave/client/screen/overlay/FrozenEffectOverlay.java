package net.luis.cave.client.screen.overlay;

import com.mojang.blaze3d.systems.RenderSystem;

import net.luis.cave.Cave;
import net.luis.cave.init.blocks.ModBlocks;
import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.PointOfView;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class FrozenEffectOverlay {
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	@SuppressWarnings({ "static-access" })
	public static void RenderSpyglassOverlay(RenderGameOverlayEvent event) {
				
		Minecraft mc = Minecraft.getInstance();
		PlayerEntity player = mc.player;
		World world = player.getEntityWorld();
		GameSettings settings = mc.gameSettings;
		BlockPos playerPos = player.getPosition();
		BlockPos playerEyePos = new BlockPos(player.getPosX(), player.getPosY() + 1, player.getPosZ());
		int posX = event.getWindow().getScaledWidth();
		int posY = event.getWindow().getScaledHeight();
		
		if (world.getBlockState(playerPos).getBlock() == ModBlocks.POWDER_SNOW.get() || 
			world.getBlockState(playerEyePos).getBlock() == ModBlocks.POWDER_SNOW.get()) {
			
			if (settings.getPointOfView()== PointOfView.FIRST_PERSON) {
				
				if (event.getType() == ElementType.HEALTH) {
					
					event.setCanceled(true);
					
				}
				
				if (event.getType() == ElementType.ARMOR) {
					
					event.setCanceled(true);
					
				}
				
				if (event.getType() != ElementType.VIGNETTE) {
					
					return;
					
				}
				
				if (!player.abilities.isCreativeMode) {
					
					RenderSystem.disableDepthTest();
					RenderSystem.depthMask(false);
					RenderSystem.enableBlend();
					RenderSystem.blendFunc(770, 771);
					mc.getTextureManager().bindTexture(new ResourceLocation("cave:textures/misc/frozen_effect.png"));
					mc.ingameGUI.blit(event.getMatrixStack(), 0, 0, 0, 0, posX, posY, 480, 270);
					RenderSystem.depthMask(true);
					RenderSystem.enableDepthTest();
					
				} else {
					
					RenderSystem.disableDepthTest();
					RenderSystem.depthMask(false);
					RenderSystem.enableBlend();
					RenderSystem.blendFunc(770, 771);
					mc.getTextureManager().bindTexture(new ResourceLocation("cave:textures/misc/frozen_effect_creative.png"));
					mc.ingameGUI.blit(event.getMatrixStack(), 0, 0, 0, 0, posX, posY, 480, 270);
					RenderSystem.depthMask(true);
					RenderSystem.enableDepthTest();
					
				}
				
			}
			
		}
		
	}

}

