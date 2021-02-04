package net.luis.cave.events.entity.living;

import net.luis.cave.Cave;
import net.luis.cave.init.util.ModGameRules;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityMobGriefingEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEntityMobGriefingEvent {
	
	@SubscribeEvent
	public static void PlayerLeaveWorld(EntityMobGriefingEvent event) {
		
		Entity entity = event.getEntity();
		World world = entity.getEntityWorld();
		
		if (entity instanceof EndermanEntity) {
			
			if (world.getGameRules().getBoolean(ModGameRules.DISABLE_ENDERMAN_GRIEFING.getRule())) {
				
				event.setResult(Result.DENY);
				
			}
			
		}
		
		if (entity instanceof CreeperEntity) {
			
			if (world.getGameRules().getBoolean(ModGameRules.DISABLE_CREEPER_GRIEFING.getRule())) {
				
				event.setResult(Result.DENY);
				
			}
			
		}
		
		if (entity instanceof GhastEntity) {
			
			if (world.getGameRules().getBoolean(ModGameRules.DISABLE_GHAST_GRIEFING.getRule())) {
				
				event.setResult(Result.DENY);
				
			}
			
		}
		
	}

}