package net.luis.cave.util.lib;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.monster.ShulkerEntity;

public abstract class EntityManager {

	public static boolean hasMaxHealth(LivingEntity enity) {
		
		if (enity.getHealth() != enity.getAttribute(Attributes.MAX_HEALTH).getBaseValue()) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public static boolean isEndertype(LivingEntity entity) {
		
		if (entity instanceof EndermanEntity) {
			
			return true;
			
		} else if (entity instanceof EndermiteEntity) {
			
			return true;
			
		} else if (entity instanceof ShulkerEntity) {
			
			return true;
			
		}
		
		return false;
		
	}

}
