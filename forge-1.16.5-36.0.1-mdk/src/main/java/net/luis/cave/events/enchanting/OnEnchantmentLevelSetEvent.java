package net.luis.cave.events.enchanting;

import net.luis.cave.Cave;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.enchanting.EnchantmentLevelSetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEnchantmentLevelSetEvent {

	@SubscribeEvent
	public static void EnchantmentLevelSet(EnchantmentLevelSetEvent event) {
		
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 6, false);
		int level = event.getOriginalLevel();
		int power = event.getPower() / 3;
		
		if (player != null) {
			
			int xp = player.experienceLevel;
			
			if (xp >= 30) {
				
				int bonus = (xp / 10) > 1 ? xp / 10 : 1;
				int newLevel = level + bonus + power;
				
				if (xp >= 75) {
					
					newLevel += (power / 2);
					
				}
				
				if (xp >= 100) {
					
					newLevel = 30;
					
				}
				
				if (level < 30) {
					
					event.setLevel(newLevel > 30 ? 30 : newLevel);
					
				}
				
			}
		
			
		}

	}

}
