package net.luis.cave.events.entity;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnLivingExperienceDropEvent {

	@SubscribeEvent
	public static void LivingExperienceDrop(LivingExperienceDropEvent event) {
		
		PlayerEntity player = event.getAttackingPlayer();
		int xp = event.getOriginalExperience();
		
		if (player != null) {
			
			int enchExperience = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.EXPERIENCE.get(), player.getHeldItemMainhand());
			int enchLooting = EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING, player.getHeldItemMainhand());
			int enchTelekinesis = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.TELEKINESIS.get(), player.getHeldItemMainhand());
			
			if (enchExperience > 0 && enchTelekinesis == 0) {
				
				event.setDroppedExperience(xp * ((enchExperience + 1) * ((enchExperience * 2) + enchLooting)));
				
			} else if (enchExperience > 0 && enchTelekinesis > 0) {
				
				player.giveExperiencePoints(xp * ((enchExperience + 1) * ((enchExperience * 2) + enchLooting)));
				event.setDroppedExperience(0);
				
			} else if (enchTelekinesis > 0) {
				
				player.giveExperiencePoints(xp);
				event.setDroppedExperience(0);
				
			}
			
		}
		
	}

}
