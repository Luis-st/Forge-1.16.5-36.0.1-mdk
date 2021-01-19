package net.luis.cave.events.client.entity;

import net.luis.cave.Cave;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEnderTeleportEvent {

	@SubscribeEvent
	public static void EnderTeleport(EnderTeleportEvent event) {
		
		LivingEntity entity = event.getEntityLiving();
		
		if (entity instanceof EndermanEntity) {
			
			event.setCanceled(hasMaxHealth(entity));
			
		}
		
		if (entity instanceof ShulkerEntity) {
			
			event.setCanceled(hasMaxHealth(entity));
			
		}

	}
	
	private static boolean hasMaxHealth(LivingEntity enity) {
		
		if (enity.getHealth() != enity.getAttribute(net.minecraft.entity.ai.attributes.Attributes.MAX_HEALTH).getBaseValue()) {
			
			return true;
			
		}
		
		return false;
		
	}

}

