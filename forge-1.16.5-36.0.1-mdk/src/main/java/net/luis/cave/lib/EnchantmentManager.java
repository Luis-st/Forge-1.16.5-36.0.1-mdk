package net.luis.cave.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import net.luis.cave.init.CaveEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
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
	
	public static void addRandomEnchantment(ItemStack item, int enchantingLevel, boolean allowTreasure) {
		
		Random rng = new Random();
		int echantability = item.getItemEnchantability();
		Map<Enchantment, Integer> returnEnchantment = new HashMap<Enchantment, Integer>();
		List<Enchantment> enchantments = getAllowedEnchantmens(item, allowTreasure);
		List<Integer> levels = getEnchantmentsLevel(enchantments);
		
		if (echantability < 50) {
			
			echantability *= 2;
			
		}
		
		if (item.isEnchantable() && !enchantments.isEmpty() && !levels.isEmpty()) {
			
			if (enchantments.size() == 1) {
				
				returnEnchantment.put(enchantments.get(0), levels.get(0));
				
			} else {
				
				if (enchantingLevel <= 8) {
					
					int rngEnch = rng.nextInt(enchantments.size());
					returnEnchantment.put(enchantments.get(rngEnch), levels.get(rngEnch));
					
				} else {
					
					if (enchantingLevel <= 18) {
						
						int rngEnch0 = rng.nextInt(enchantments.size());
						Enchantment ench0 = enchantments.get(rngEnch0);
						returnEnchantment.put(enchantments.get(rngEnch0), levels.get(rngEnch0));
						
						do {
							
						} while (allowTreasure);
						
						
						int rngEnch1 = rng.nextInt(enchantments.size());
						Enchantment ench1 = enchantments.get(rngEnch1);
						
					} else {
						
						int rngEnch = rng.nextInt(enchantments.size());
						
					}
					
				}
				
			}
			
		} else {
			
			
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	private static List<Enchantment> getAllowedEnchantmens(ItemStack item, boolean allowTreasure) {
		
		List<Enchantment> registryEnchantments = Registry.ENCHANTMENT.stream().filter(Enchantment::canVillagerTrade).collect(Collectors.toList());
		List<Enchantment> usefulEnchantments = new ArrayList<Enchantment>();
		
		if (!allowTreasure) {
			
			for (Enchantment enchantment : registryEnchantments) {
				
				if (enchantment.isTreasureEnchantment()) {
					
					registryEnchantments.remove(enchantment);
					
				}
				
			}
			
		}
		
		for (Enchantment enchantment : registryEnchantments) {
			
			if (!enchantment.isCurse()) {
				
				if (enchantment.canApply(item)) {
					
					usefulEnchantments.add(enchantment);
					
				}
				
			}
			
		}
		
		return usefulEnchantments;
		
	}
	
	private static List<Integer> getEnchantmentsLevel(List<Enchantment> enchantments) {
		
		List<Integer> levels = new ArrayList<Integer>();
		Random rng = new Random();
		
		for (Enchantment enchantment : enchantments) {
			
			int enchLevel = Math.min(enchantment.getMinLevel(), rng.nextInt(5) + 1);
			levels.add(enchLevel);
			
		}
		
		return levels;
		
	}
	
}
