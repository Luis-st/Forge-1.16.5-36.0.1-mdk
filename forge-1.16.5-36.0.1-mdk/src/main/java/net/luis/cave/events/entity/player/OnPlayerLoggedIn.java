package net.luis.cave.events.entity.player;

import net.luis.cave.Cave;
import net.luis.cave.init.util.ModGameRule;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnPlayerLoggedIn {
	
	@SubscribeEvent
	public static void PlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		
		PlayerEntity player = event.getPlayer();
		World world = player.getEntityWorld();
		
		if (!world.isRemote) {
			
			if (world.getGameRules().getBoolean(ModGameRule.ENABLE_PROTECTION_TIME.getRule())) {
				
				int multiplier = world.getGameRules().getInt(ModGameRule.PROTECTION_TIME_MULTIPLIER.getRule());
				
				player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 20 * multiplier, 4, true , true));
				
			}
			
		}
		
	}

}