package net.luis.cave.events.other;

import net.luis.cave.Cave;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnTextureStitchEvent {

	@SubscribeEvent
	public static void TextureStitch(TextureStitchEvent.Pre event) {
		
		event.addSprite(new ResourceLocation("cave:items/empty_tool_slot.png"));
		
	}

}