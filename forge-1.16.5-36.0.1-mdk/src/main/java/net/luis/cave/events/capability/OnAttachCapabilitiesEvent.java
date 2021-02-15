package net.luis.cave.events.capability;

import net.luis.cave.Cave;
import net.luis.cave.init.ModCapability;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnAttachCapabilitiesEvent {
	
	@SubscribeEvent
	public static void AttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer)) {
			
			event.addCapability(new ResourceLocation("cave:extended_enderchest_gui"), new ModCapability.Provider());
			
		}
		
	}

}