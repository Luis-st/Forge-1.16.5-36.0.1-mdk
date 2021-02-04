package net.luis.cave.api.lib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import net.luis.cave.init.ModEnchantment;
import net.luis.cave.init.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.ForgeEventFactory;

public class EnchantmentManager extends EnchantmentHelper {
	
	public static int growthLevel(ItemStack[] item) {
		
		int enchGrowthHead = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.GROWTH.get(), item[0]);
		int enchGrowthChest = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.GROWTH.get(), item[1]);
		int enchGrowthLegs = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.GROWTH.get(), item[2]);
		int enchGrowthFeet = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.GROWTH.get(), item[3]);
		
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
	
	@SuppressWarnings("deprecation")
	public static void lavaWalker(LivingEntity living, World world, BlockPos pos) {
		
		if (living.isOnGround()) {
			
			BlockState crackedLava = ModBlocks.CRACKED_LAVA.get().getDefaultState();
			float size = 3;
			BlockPos.Mutable mutablePos = new BlockPos.Mutable();

			for (BlockPos blockPos : BlockPos.getAllInBoxMutable(pos.add(-size, -1.0D, -size), pos.add(size, -1.0D, size))) {
				
				if (blockPos.withinDistance(living.getPositionVec(), size)) {
					
					mutablePos.setPos(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ());
					BlockState checkState = world.getBlockState(mutablePos);
					
					if (checkState.isAir(world, mutablePos)) {
						
						BlockState airState = world.getBlockState(blockPos);
						boolean isFull = airState.getBlock() == Blocks.LAVA && airState.get(FlowingFluidBlock.LEVEL) == 0;
						
						if (airState.getMaterial() == Material.LAVA && isFull && 
							crackedLava.isValidPosition(world, blockPos) && 
							world.placedBlockCollides(crackedLava, blockPos, ISelectionContext.dummy()) && 
							!ForgeEventFactory.onBlockPlace(living, BlockSnapshot.create(world.getDimensionKey(), world, blockPos), Direction.UP)) {
							
							world.setBlockState(blockPos, crackedLava);
							world.getPendingBlockTicks().scheduleTick(blockPos, ModBlocks.CRACKED_LAVA.get(), MathHelper.nextInt(living.getRNG(), 60, 120));
							
						}
						
					}
					
				}
				
			}

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
