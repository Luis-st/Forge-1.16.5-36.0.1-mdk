package net.luis.cave.client.render.item.tooltip;

import net.luis.cave.Cave;
import net.luis.cave.api.item.ItemManager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class OnRenderTooltipEvent {
	
	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void RenderTooltip(RenderTooltipEvent.Pre event) {
				
		PlayerEntity player = Minecraft.getInstance().player;
		ItemStack stack = event.getStack();
		
		if (ItemManager.isShulkerBox(stack)) {
			
			String displayName = stack.getDisplayName().getString();
			
			if (displayName.contains("-")) {
				
				String[] itemName = displayName.split("-");
				String playerName = player.getDisplayName().getString();
				
				if (itemName.length == 2) {
					
					if (!itemName[1].equals(playerName)) {
						
						event.setCanceled(true);
						
					}
					
				}
				
			}
			
		}
		
	}

}

