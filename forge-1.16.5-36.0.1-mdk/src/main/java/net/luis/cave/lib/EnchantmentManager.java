package net.luis.cave.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import net.luis.cave.init.CaveEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class EnchantmentManager {
	
	public static int growthLevel(ItemStack[] item) {
		
		int enchGrowthHead = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.GROWTH.get(), item[0]);
		int enchGrowthChest = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.GROWTH.get(), item[1]);
		int enchGrowthLegs = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.GROWTH.get(), item[2]);
		int enchGrowthFeet = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.GROWTH.get(), item[3]);
		
		return enchGrowthHead + enchGrowthChest + enchGrowthLegs + enchGrowthFeet;
		
	}
	
	public static void voidWalker(World world, PlayerEntity player) {
		
		player.fallDistance = 0f;
		
		if (!player.isSneaking()) {
	
			if (!world.getBlockState(new BlockPos(player.getPosX(), player.getPosY() - 1, player.getPosZ())).isSolid()) {
				
				if (player.getMotion().getY() < 0) {
					
					player.setMotion(player.getMotion().getX(), 0, player.getMotion().getZ());
					player.setOnGround(true);
					
				}
				
			}
			
		}
		
	}
	
	public static boolean isItemEnchanted(ItemStack inputLeft, ItemStack inputRight) {
		
		if (!inputLeft.isEnchanted() && !inputRight.isEnchanted()) {
			
			return false;
			
		} else if (inputLeft.isEnchanted() && !inputRight.isEnchanted()) {
			
			return true;
			
		} else if (!inputLeft.isEnchanted() && inputRight.isEnchanted()) {
			
			return true;
			
		} else {
			
			return true;
			
		}
		
	}
	
	public static Map<Enchantment, Integer> addRandomEnchantment(ItemStack item, int enchantingLevel, boolean allowTreasure) {
		
		int enchCount = MathHelper.floor(enchantingLevel / 10);
		Map<Enchantment, Integer> returnEnchantment = new HashMap<Enchantment, Integer>();
		List<Enchantment> enchantments = getAllowedEnchantmens(item, allowTreasure);
		List<Integer> levels = getEnchantmentsLevel(enchantments, enchantingLevel);
		
		if (item.isEnchantable() && !enchantments.isEmpty() && !levels.isEmpty()) {
			
			if (enchantingLevel > 0) {
				
				if (enchCount > enchantments.size()) {
					
					for (int i = 0; i < enchantments.size(); i++) {
						
						returnEnchantment.put(enchantments.get(i), levels.get(i));
						
					}
					
				} else if (enchCount == enchantments.size()) {
					
					for (int i = 0; i < enchCount; i++) {
						
						returnEnchantment.put(enchantments.get(i), levels.get(i));
						
					}
					
				} else {
					
					List<Integer> rngEnch = getRandomEnchantmentPos(enchCount, enchantments.size());
					
					for (int i = 0; i <rngEnch.size(); i++) {
						
						returnEnchantment.put(enchantments.get(rngEnch.get(i)), levels.get(rngEnch.get(i)));
						
					}
					
				}
				
				returnEnchantment = removeIncompatible(returnEnchantment);
				
				return !returnEnchantment.isEmpty() && returnEnchantment != null ? returnEnchantment : null;
				
			} else {
				
				return null;
				
			}
			
		} else {
			
			return null;
			
		}
		
	}
	
	private static Map<Enchantment, Integer> removeIncompatible(Map<Enchantment, Integer> enchantments) {
		
		Map<Enchantment, Integer> returnMap = new HashMap<Enchantment, Integer>();
		List<Enchantment> enchantmentList = enchantments.keySet().stream().collect(Collectors.toList());
		List<Integer> levelList = enchantments.values().stream().collect(Collectors.toList());
		List<EnchantmentData> data = new ArrayList<EnchantmentData>();
		
		for (int i = 0; i < enchantments.size(); i++) {
			
			data.add(new EnchantmentData(enchantmentList.get(i), levelList.get(i)));
			
		}
		
		Iterator<EnchantmentData> iterator = data.iterator();

		while (iterator.hasNext()) {
			
			if (!data.get(0).enchantment.isCompatibleWith(iterator.next().enchantment)) {
				
				iterator.remove();
				break;
				
			}
			
		}
		
		while (iterator.hasNext()) {
			
			if (!data.get(0).enchantment.isCompatibleWith(iterator.next().enchantment)) {
				
				iterator.remove();
				break;
				
			}
			
		}
		
		for (int i = 0; i < data.size(); i++) {
			
			returnMap.put(data.get(i).enchantment, data.get(i).enchantmentLevel);
			
		}
		
		return returnMap;
		
	}
	
	private static List<Integer> getRandomEnchantmentPos(int enchCount, int size) {
		
		Random rng = new Random();
		List<Integer> rngEnch = new ArrayList<Integer>();
		
		for (int i = 0; i < enchCount; i++) {
			
			int rngInt = 0;
			
			do {
				
				rngInt = rng.nextInt(size);
						
			} while (rngEnch.contains(rngInt));
			
			rngEnch.add(rngInt);
			
		}
		
		return rngEnch;
		
	}
	
	@SuppressWarnings("deprecation")
	private static List<Enchantment> getAllowedEnchantmens(ItemStack item, boolean allowTreasure) {
		
		List<Enchantment> registryEnchantments = Registry.ENCHANTMENT.stream().filter(Enchantment::canVillagerTrade).collect(Collectors.toList());
		List<Enchantment> usefulEnchantments = new ArrayList<Enchantment>();
		
//		if (!allowTreasure) {
//			
//			for (Enchantment enchantment : registryEnchantments) {
//				
//				if (enchantment.isTreasureEnchantment()) {
//					
//					registryEnchantments.remove(enchantment);
//					
//				}
//				
//			}
//			
//		}
		
		for (Enchantment enchantment : registryEnchantments) {
			
			if (!enchantment.isCurse()) {
				
				if (allowTreasure) {
					
					if (enchantment.canApply(item)) {
						
						usefulEnchantments.add(enchantment);
						
					}
					
				} else {
					
					if (!enchantment.isTreasureEnchantment()) {
						
						if (enchantment.canApply(item)) {
							
							usefulEnchantments.add(enchantment);
							
						}
						
					}
					
				}
				
			}
			
		}
		
		return usefulEnchantments;
		
	}
	
	private static List<Integer> getEnchantmentsLevel(List<Enchantment> enchantments, int enchantingLevel) {
		
		List<Integer> levels = new ArrayList<Integer>();
		Random rng = new Random();
		
		for (Enchantment enchantment : enchantments) {
			
			int enchLevel = MathHelper.nextInt(rng, enchantment.getMinLevel(), enchantment.getMaxLevel());
			
			if (enchantingLevel > 30) {
				
				if (enchLevel != enchantment.getMaxLevel()) {
					
					enchLevel++;
					
				}
				
			} else if (enchantingLevel > 20) {
				
				if (enchLevel != enchantment.getMaxLevel() && rng.nextInt(1) == 0) {
					
					enchLevel++;
					
				}
				
			} else if (enchantingLevel > 10) {
				
				if (enchLevel != enchantment.getMaxLevel() && rng.nextInt(2) == 0) {
					
					enchLevel++;
					
				}
				
			}
			
			levels.add(enchLevel);
			
		}
		
		return levels;
		
	}
	
}
