package net.luis.cave.events.entity.player.interact;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.luis.cave.Cave;
import net.luis.cave.init.items.ModItems;
import net.luis.cave.init.util.ModGameRule;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.village.GossipManager;
import net.minecraft.village.GossipType;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEntityInteractSpecificEvent {
	
	private static final Method startConverting = ObfuscationReflectionHelper.findMethod(ZombieVillagerEntity.class, "func_191991_a", UUID.class, int.class);
	
	@SubscribeEvent
	public static void EntityInteractSpecific(PlayerInteractEvent.EntityInteractSpecific event) {
		
		PlayerEntity player = event.getPlayer();
		Entity target = event.getTarget();
		World world = event.getWorld();
		
		if (target instanceof VillagerEntity) {
			
			VillagerEntity villager = (VillagerEntity) target;
			GossipManager gossipManager = villager.getGossip();
			String uuid = villager.getUniqueID().toString().replace("-", "");
			int uniqueInteger = Integer.parseInt(uniqueHex(uuid, 2), 16) / 10;
			uniqueInteger = uniqueInteger > 10 ? 10 : uniqueInteger;
			Item item = player.getHeldItem(event.getHand()).getItem();
			
			if (world.getDayTime() >= 1000 && world.getDayTime() <= 11000) {
				
				if (world.getGameRules().getBoolean(ModGameRule.DO_WORKTIME_TRADE_RESETING.getRule())) {
					
					villager.restock();
					
				}
				
			}
			
			if (item == ModItems.RUBY_APPLE.get() || item == Items.ENCHANTED_GOLDEN_APPLE) {
				
				if (world.getGameRules().getBoolean(ModGameRule.ENABLE_TRADE_REDUCTION.getRule())) {
					
					if (!player.abilities.isCreativeMode) {
						
						player.getHeldItem(event.getHand()).shrink(1);
						
					}
					
					gossipManager.add(player.getUniqueID(), GossipType.MINOR_POSITIVE, uniqueInteger);
					gossipManager.add(player.getUniqueID(), GossipType.MAJOR_POSITIVE, uniqueInteger / 2);
					
				}
				
			}
			
		} else if (target instanceof ZombieVillagerEntity) {
			
			if (world.getGameRules().getBoolean(ModGameRule.ENABLE_ZOMBIEVILLAGER_FAST_CONVERT.getRule())) {
				
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
	
	public static String uniqueHex(String string, int size) {

		List<String> ret = new ArrayList<String>((string.length() + size - 1) / size);

		for (int start = 0; start < string.length(); start += size) {
			
			ret.add(string.substring(start, Math.min(string.length(), start + size)));
			
		}
		
		return ret != null ? ret.get(0) : null;
		
	}

}

