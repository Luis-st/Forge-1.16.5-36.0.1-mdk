package net.luis.cave.events.client.entity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

import net.luis.cave.Cave;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEntityInteractSpecificEvent {
	
	private static final Method startConverting = ObfuscationReflectionHelper.findMethod(ZombieVillagerEntity.class, "func_191991_a", UUID.class, int.class);
	
	@SubscribeEvent
	public static void EntityInteractSpecific(PlayerInteractEvent.EntityInteractSpecific event) {
		
		PlayerEntity player = event.getPlayer();
		LivingEntity target = (LivingEntity) event.getTarget();
		World world = event.getWorld();
		
		if (target instanceof ZombieVillagerEntity) {
			
			ZombieVillagerEntity zombieVillager = (ZombieVillagerEntity) target;
			
			if (player.getHeldItem(event.getHand()).getItem() == Items.GOLDEN_APPLE) {
				
				if (!player.abilities.isCreativeMode) {
					
					player.getHeldItem(event.getHand()).shrink(1);
					
				}
				
				if (!world.isRemote) {
					
					try {
						
						startConverting.invoke(zombieVillager, player.getUniqueID(), 60);
						
					} catch (IllegalAccessException e) {
						
						e.printStackTrace();
						
					} catch (IllegalArgumentException e) {
						
						e.printStackTrace();
						
					} catch (InvocationTargetException e) {
						
						e.printStackTrace();
						
					}
					
				}
				
			}
			
		}

	}

}
