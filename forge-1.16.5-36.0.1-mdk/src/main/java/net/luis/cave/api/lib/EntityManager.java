package net.luis.cave.api.lib;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.entity.passive.StriderEntity;

public class EntityManager {

	public static boolean hasMaxHealth(LivingEntity enity) {
		
		if (enity.getHealth() != enity.getAttribute(Attributes.MAX_HEALTH).getBaseValue()) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public static boolean isEndertype(Entity entity) {
		
		if (entity instanceof EndermanEntity) {
			
			return true;
			
		} else if (entity instanceof EndermiteEntity) {
			
			return true;
			
		} else if (entity instanceof ShulkerEntity) {
			
			return true;
			
		} else if (entity instanceof EnderDragonEntity) { 
			
			return true;
			
		}
		
		return false;
		
	}
	
	public static boolean isLavatype(Entity entity) {
		
		if (entity instanceof MagmaCubeEntity) {
			
			return true;
			
		} else if (entity instanceof GhastEntity) {
			
			return true;
			
		} else if (entity instanceof BlazeEntity) {
			
			return true;
			
		} else if (entity instanceof StriderEntity) { 
			
			return true;
			
		}
		
		return false;
		
	}

}
