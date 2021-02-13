package net.luis.cave.events.entity;

import com.mojang.authlib.GameProfile;

import net.luis.cave.Cave;
import net.luis.cave.init.util.ModGameRule;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.management.BanList;
import net.minecraft.server.management.PlayerList;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityLeaveWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE , value = Dist.DEDICATED_SERVER)
public class OnEntityLeaveWorld {
	
	@SubscribeEvent
	public static void PlayerLeaveWorld(EntityLeaveWorldEvent event) {
		
		Entity player = event.getEntity();
		World world = event.getWorld();
		
		if (!world.isRemote) {
			
			if (world.getGameRules().getBoolean(ModGameRule.DISABLE_BAN.getRule())) {
				
				PlayerList playerList = world.getServer().getPlayerList();
				BanList banList = playerList.getBannedPlayers(); 
				
				if (player instanceof PlayerEntity) {
					
					GameProfile gameprofile = ((PlayerEntity) player).getGameProfile();
					
					if (banList.isBanned(gameprofile)) {
						
						banList.removeEntry(gameprofile);
						
					}
					
				}
				
			}
			
		}
		
	}

}
