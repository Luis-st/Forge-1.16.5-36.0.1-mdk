package net.luis.cave.events.entity.living;

import net.luis.cave.Cave;
import net.luis.cave.api.entity.EntityManager;
import net.luis.cave.init.ModEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnLivingDamageEvent {
	
	@SubscribeEvent
	public static void LivingDamage(LivingDamageEvent event) {
		
		// TODO: add Damage star multiplier
		
		Entity target = event.getEntity();
		Entity entity = event.getSource().getTrueSource();
		float amount = event.getAmount();
		float newAmount = amount;
		
		if (entity instanceof PlayerEntity) {
			
			PlayerEntity player = (PlayerEntity) entity;
			int enchEnderSlayer = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.ENDER_SLYAER.get(), player.getHeldItemMainhand());
			int enchImpaling= EnchantmentHelper.getEnchantmentLevel(ModEnchantment.IMPALING.get(), player.getHeldItemMainhand());
			
			if (EntityManager.isEnderType(target)) {
				
				if (enchEnderSlayer > 0) {
					
					newAmount += (enchEnderSlayer * 2.5f) + enchEnderSlayer;
					event.setAmount(newAmount);
					
				}
				
			}
			
			if (EntityManager.isLavaType(target) || EntityManager.isWaterType(target)) {
				
				if (enchImpaling > 0) {
					
					newAmount += (enchImpaling * 2.5f) + enchImpaling;
					event.setAmount(newAmount);
					
				}
				
			}
			
		}
		
	}

}
