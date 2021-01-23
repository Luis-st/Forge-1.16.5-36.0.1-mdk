package net.luis.cave.events.world;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnXpDrop {
	
	@SubscribeEvent
	public static void XpDrop(BlockEvent.BreakEvent event) {
		
		PlayerEntity player = event.getPlayer();

		if (player instanceof PlayerEntity) {
			
			if (event.getExpToDrop() > 0 && !player.abilities.isCreativeMode) {
				
				int xp = event.getExpToDrop();
				int enchExperience = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.EXPERIENCE.get(), player.getHeldItemMainhand());
				int enchFortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, player.getHeldItemMainhand());
				int enchDoubleDrop = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.DOUBLE_DROPS.get(), player.getHeldItemMainhand());
				int enchSilkTouch = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, player.getHeldItemMainhand());
				int enchTelekinesis = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.TELEKINESIS.get(), player.getHeldItemMainhand());
				
				if (enchExperience > 0) {
					
					if (enchSilkTouch == 0 && enchTelekinesis == 0) {
						
						event.setExpToDrop((xp * ((enchExperience + 1) * ((enchExperience * 2) + enchFortune))) * (enchDoubleDrop + 1));
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
