package net.luis.cave.events.entity.player.tick;

import net.luis.cave.Cave;
import net.luis.cave.util.lib.PlayerManager;
import net.luis.cave.world.CaveGameRules;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnArmor {

	@SubscribeEvent
	public static void PlayerTick(TickEvent.PlayerTickEvent event) {

		PlayerEntity player = event.player;
		World world = player.getEntityWorld();
		
		if (world.getGameRules().getBoolean(CaveGameRules.ENABLE_ARMOR_EFFECTS.getRule())) {
			
			if (PlayerManager.hasSaphireArmor(player)) {
				
				player.fallDistance = 0f;
				player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 10, 4, true, false));
				
				if (player.getMotion().y < 0) {
					
					player.setMotion(player.getMotion().x, player.getMotion().y - (player.getMotion().y / 20), player.getMotion().z);
					
				}
				
			}
			
			if (PlayerManager.hasNightArmor(player, true)) {
				
				
				player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 400, 0, true, false));
				
			}
			
		}
		
	}
	
}
