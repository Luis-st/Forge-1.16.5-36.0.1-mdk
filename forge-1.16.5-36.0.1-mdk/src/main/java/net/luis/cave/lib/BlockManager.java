package net.luis.cave.lib;

import net.luis.cave.init.CaveBlocks;
import net.luis.cave.init.CaveItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockManager {
	
	public static boolean isOreBlock(World world, BlockPos pos) {
		
		if (world.getBlockState(pos).getBlock() == Blocks.COAL_ORE) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.IRON_ORE) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.GOLD_ORE) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.LAPIS_ORE) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.REDSTONE_ORE) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.JADE_ORE.get()) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.LIMONITE_ORE.get()) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.DIAMOND_ORE) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.EMERALD_ORE) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.SAPHIRE_ORE.get()) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.ROSITE_ORE.get()) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.ANCIENT_DEBRIS) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.ENDERITE_ORE.get()) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}

	public static void dropRuby(World world, BlockPos pos, PlayerEntity player, double chance) {
		
		double x = pos.getX();
		double y = pos.getY();
		double z = pos.getZ();
		
		if (Math.random() >= chance) {
			
			if (!player.abilities.isCreativeMode) {
				
				ItemEntity  item = new ItemEntity(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(CaveItems.RUBY.get()));
				item.setPickupDelay(10);
				world.addEntity(item);
				
			}
			
		}
		
	}
	
	public static boolean isBrokenWood(BlockState state) {
		
		if (state.isIn(BlockTags.LOGS)) {
			
			return true;
			
		}
		
		return false;
		
	}

	public static boolean isBlockUpWood(World world, int x, int y, int z) {
		
		if (world.getBlockState(new BlockPos(x, y, z)).isIn(BlockTags.LOGS)) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public static boolean doubleDropBlackList(World world, BlockPos pos) {
		
		if (world.getBlockState(pos).getBlock() == Blocks.COAL_BLOCK) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.IRON_BLOCK) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.GOLD_BLOCK) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.LAPIS_BLOCK) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.DIAMOND_BLOCK) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.REDSTONE_BLOCK) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.EMERALD_BLOCK) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.NETHERITE_BLOCK) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.JADE_BLOCK.get()) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.LIMONITE_BLOCK.get()) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.ROSITE_BLOCK.get()) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.RUBY_BLOCK.get()) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.SAPHIRE_BLOCK.get()) {
			
			return true;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.ENDERITE_BLOCK.get()) {
			
			return true;
			
		}
		
		return false;
		
	}

	public static boolean hasSmelting(World world, BlockPos pos) {
		
		if (world.getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(new ItemStack(world.getBlockState(pos).getBlock())), world).isPresent()) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public static boolean smeltingBlackList(World world, BlockPos pos) {
		
		if (world.getBlockState(pos).getBlock() == Blocks.ANDESITE) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	public static void getSmelting(World world, BlockPos pos, PlayerEntity player) {
		
		ItemEntity stack = ItemManager.creatSmeltingItem(world, pos);

		if (player.abilities.isCreativeMode == false) {
			
			world.addEntity(stack);
			
		}
		
	}
	
	public static void getFortuneSmelting(World world, BlockPos pos, PlayerEntity player) {
		
		ItemEntity stack0 = ItemManager.creatSmeltingItem(world, pos);
		ItemEntity stack1 = ItemManager.creatSmeltingItem(world, pos);
		ItemEntity stack2 = ItemManager.creatSmeltingItem(world, pos);
		ItemEntity stack3 = ItemManager.creatSmeltingItem(world, pos);
		
		if (player.abilities.isCreativeMode == false) {
			
			if (EnchantmentManager.hasEnchantmentWithLevel(Enchantments.FORTUNE, player.getHeldItemMainhand(), 0, false)) {
				
				world.addEntity(stack0);
				
			} else if (EnchantmentManager.hasEnchantmentWithLevel(Enchantments.FORTUNE, player.getHeldItemMainhand(), 1, false)) {
				
				if (Math.random() >= 0.95) {
						
					world.addEntity(stack1);
					world.addEntity(stack0);
		
				} else {
					
					world.addEntity(stack0);
					
				}		
				
			} else if (EnchantmentManager.hasEnchantmentWithLevel(Enchantments.FORTUNE, player.getHeldItemMainhand(), 2, false)) {
				
				if (Math.random() >= 0.95) {
						
					world.addEntity(stack2);
					world.addEntity(stack1);
					world.addEntity(stack0);
		
				} else if (Math.random() >= 0.9) {
						
					world.addEntity(stack1);
					world.addEntity(stack0);
						
				} else {
					
					world.addEntity(stack0);
					
				}
				
			} else if (EnchantmentManager.hasEnchantmentWithLevel(Enchantments.FORTUNE, player.getHeldItemMainhand(), 3, false)) {
				
				if (Math.random() >= 0.95) {
					
					world.addEntity(stack3);
					world.addEntity(stack2);
					world.addEntity(stack1);
					world.addEntity(stack0);
						
				} else if (Math.random() >= 0.9) {
						
					world.addEntity(stack2);
					world.addEntity(stack1);
					world.addEntity(stack0);
					
				} else if (Math.random() >= 0.85) {
					
					world.addEntity(stack1);
					world.addEntity(stack0);
						
				} else {
					
					world.addEntity(stack0);
					
				}
				
			}
			
		}
		
	}

}
