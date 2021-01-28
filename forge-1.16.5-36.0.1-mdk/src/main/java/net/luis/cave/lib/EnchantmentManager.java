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
		
		Random rng = new Random();
		Map<Enchantment, Integer> returnEnchantment = new HashMap<Enchantment, Integer>();
		List<Enchantment> enchantments = getAllowedEnchantmens(item, allowTreasure);
		List<Integer> levels = getEnchantmentsLevel(enchantments, enchantingLevel);
		
		List<Enchantment> retEnchantment = new ArrayList<Enchantment>();
		List<Integer> retLevel = new ArrayList<Integer>();
		
		if (item.isEnchantable() && !enchantments.isEmpty() && !levels.isEmpty()) {
			
			if (enchantments.size() == 1) {
				
				retEnchantment.add(enchantments.get(0));
				retLevel.add(levels.get(0));
				
			} else if (enchantments.size() == 2) {
				
				if (enchantingLevel >= 15) {
					
					retEnchantment.add(enchantments.get(0));
					retLevel.add(levels.get(0));
					
					retEnchantment.add(enchantments.get(1));
					retLevel.add(levels.get(1));
					
				} else {
					
					int rngEnch = rng.nextInt(enchantments.size());
					
					retEnchantment.add(enchantments.get(rngEnch));
					retLevel.add(levels.get(rngEnch));
					
				}
				
			} else if (enchantments.size() == 3) {
				
				if (enchantingLevel >= 20) {
					
					retEnchantment.add(enchantments.get(0));
					retLevel.add(levels.get(0));
					
					retEnchantment.add(enchantments.get(1));
					retLevel.add(levels.get(1));
					
					retEnchantment.add(enchantments.get(2));
					retLevel.add(levels.get(2));
					
				} else if (enchantingLevel >= 10) {
					
					int rngEnch0 = 0;
					int rngEnch1 = 0;
					
					do {
						
						rngEnch0 = rng.nextInt(enchantments.size());
						rngEnch1 = rng.nextInt(enchantments.size());

					} while (rngEnch0 == rngEnch1);
					
					retEnchantment.add(enchantments.get(rngEnch0));
					retLevel.add(levels.get(rngEnch0));
					
					retEnchantment.add(enchantments.get(rngEnch1));
					retLevel.add(levels.get(rngEnch1));
					
				} else {
					
					int rngEnch = rng.nextInt(enchantments.size());
					
					retEnchantment.add(enchantments.get(rngEnch));
					retLevel.add(levels.get(rngEnch));
					
				}
				
			} else {
				
				int rngEnch0 = 0;
				int rngEnch1 = 0;
				int rngEnch2 = 0;
				int rngEnch3 = 0;
				
				if (enchantingLevel <= 10) {
					
					rngEnch0 = rng.nextInt(enchantments.size());
					
					retEnchantment.add(enchantments.get(rngEnch0));
					retLevel.add(levels.get(rngEnch0));
					
				} else if (enchantingLevel <= 20) {
					
					do {
						
						rngEnch0 = rng.nextInt(enchantments.size());
						rngEnch1 = rng.nextInt(enchantments.size());

					} while (rngEnch0 == rngEnch1);
					
					retEnchantment.add(enchantments.get(rngEnch0));
					retLevel.add(levels.get(rngEnch0));
					
					retEnchantment.add(enchantments.get(rngEnch1));
					retLevel.add(levels.get(rngEnch1));
					
				} else if (enchantingLevel <= 30) {
					
					do {
						
						rngEnch0 = rng.nextInt(enchantments.size());
						rngEnch1 = rng.nextInt(enchantments.size());
						rngEnch2 = rng.nextInt(enchantments.size());

					} while (rngEnch0 == rngEnch1 || rngEnch0 == rngEnch2 || rngEnch1 == rngEnch2);
					
					retEnchantment.add(enchantments.get(rngEnch0));
					retLevel.add(levels.get(rngEnch0));
					
					retEnchantment.add(enchantments.get(rngEnch1));
					retLevel.add(levels.get(rngEnch1));
					
					retEnchantment.add(enchantments.get(rngEnch2));
					retLevel.add(levels.get(rngEnch2));
					
				} else {
					
					do {
						
						rngEnch0 = rng.nextInt(enchantments.size());
						rngEnch1 = rng.nextInt(enchantments.size());
						rngEnch2 = rng.nextInt(enchantments.size());
						rngEnch3 = rng.nextInt(enchantments.size());

					} while (rngEnch0 == rngEnch1 || rngEnch0 == rngEnch2 || rngEnch0 == rngEnch3
							|| rngEnch1 == rngEnch2 || rngEnch1 == rngEnch3 || rngEnch2 == rngEnch3);
					
					retEnchantment.add(enchantments.get(rngEnch0));
					retLevel.add(levels.get(rngEnch0));
					
					retEnchantment.add(enchantments.get(rngEnch1));
					retLevel.add(levels.get(rngEnch1));
					
					retEnchantment.add(enchantments.get(rngEnch2));
					retLevel.add(levels.get(rngEnch2));
					
					retEnchantment.add(enchantments.get(rngEnch3));
					retLevel.add(levels.get(rngEnch3));
					
				}
				
			}
			
			for (int i = 0; i < retEnchantment.size(); i++) {
				
				returnEnchantment.put(retEnchantment.get(i), retLevel.get(i));
				
			}
			
			return !returnEnchantment.isEmpty() ? returnEnchantment : null;
			
		} else {
			
			return null;
			
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
