package net.luis.cave.events.entity;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveEnchantment;
import net.luis.cave.lib.EntityManager;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE , value = Dist.DEDICATED_SERVER)
public class OnLivingDamageEvent {
	
	@SubscribeEvent
	public static void LivingDamage(LivingDamageEvent event) {
		
		LivingEntity target = event.getEntityLiving();
		Entity entity = event.getSource().getTrueSource();
		float amount = event.getAmount();
		float newAmount;
		
		if (entity instanceof PlayerEntity) {
			
			PlayerEntity player = (PlayerEntity) entity;
			int enchEnderSlayer = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.ENDER_SLYAER.get(), player.getHeldItemMainhand());
			
			if (EntityManager.isEndertype(target)) {
				
				if (enchEnderSlayer > 0) {
					
					newAmount = amount + (enchEnderSlayer * 2.5f);
					event.setAmount(newAmount);
					
				}
				
			}
			
		}
		
	}

}
