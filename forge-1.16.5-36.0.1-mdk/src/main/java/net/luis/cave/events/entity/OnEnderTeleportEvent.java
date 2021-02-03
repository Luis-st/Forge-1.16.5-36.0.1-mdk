package net.luis.cave.events.entity;

import net.luis.cave.Cave;
import net.luis.cave.util.lib.EntityManager;
import net.luis.cave.world.CaveGameRules;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEnderTeleportEvent {

	@SubscribeEvent
	public static void EnderTeleport(EnderTeleportEvent event) {
		
		LivingEntity entity = event.getEntityLiving();
		World world = entity.getEntityWorld();
		
		if (entity instanceof PlayerEntity) {
			
			if (!world.getGameRules().getBoolean(CaveGameRules.DO_ENDERPEARL_DAMAGE.getRule())) {
				
				event.setAttackDamage(0.0f);
				
			}
			
		}
		
		if (entity instanceof EndermanEntity) {
			
			if (world.getGameRules().getBoolean(CaveGameRules.DISABLE_ENDERMAN_TELEPORT.getRule())) {
				
				event.setCanceled(true);
				
			}

			if (world.getGameRules().getBoolean(CaveGameRules.DISABLE_ENDERMAN_ATTACK_TELEPORT.getRule())) {
				
				event.setCanceled(EntityManager.hasMaxHealth(entity));
				
			}
			
		}
		
		if (entity instanceof ShulkerEntity) {
			
			if (world.getGameRules().getBoolean(CaveGameRules.DISABLE_SHULKER_TELEPORT.getRule())) {
				
				event.setCanceled(true);
				
			}

			if (world.getGameRules().getBoolean(CaveGameRules.DISABLE_SHULKER_ATTACK_TELEPORT.getRule())) {
				
				event.setCanceled(EntityManager.hasMaxHealth(entity));
				
			}
			
		}

	}
	
}

