package net.luis.cave.events.entity;

import net.luis.cave.Cave;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnLivingSpawnEvent {

	@SubscribeEvent
	public static void LivingSpawn(LivingSpawnEvent.SpecialSpawn event) {
		
		LivingEntity entity = event.getEntityLiving();
		
		if (entity instanceof BatEntity) {
			
			event.setResult(Result.DENY);
			
		} else if (entity instanceof PiglinEntity) {
			
			if (entity.isChild()) {
				
				event.setResult(Result.DENY);
				
			}
			
		}
		
	}

}

