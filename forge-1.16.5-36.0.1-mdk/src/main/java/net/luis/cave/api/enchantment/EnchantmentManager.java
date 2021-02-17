package net.luis.cave.api.enchantment;

import net.luis.cave.init.ModEnchantment;
import net.luis.cave.init.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.World;
import net.minecraftforge.common.util.BlockSnapshot;
import net.minecraftforge.event.ForgeEventFactory;

public class EnchantmentManager extends EnchantmentHelper {
	
	public static boolean enchantmentTransferCase1(ItemStack inputLeft, ItemStack inputRight) {
		
		if (inputLeft != null && inputRight != null) {
			
			if (inputLeft.isEnchanted() && !inputRight.isEnchanted()) {
				
				if (inputRight.getItem() instanceof BookItem && inputRight.getCount() == 1) {
					
					return true;
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
	public static boolean enchantmentTransferCase2(ItemStack inputLeft, ItemStack inputRight) {
		
		if (inputLeft != null && inputRight != null) {
			
			if (inputLeft.isEnchanted() && !inputRight.isEnchanted()) {
				
				if (inputLeft.getItem() instanceof BookItem && inputRight.getItem() instanceof BookItem) {
					
					if (inputRight.getCount() == 1) {
						
						return true;
						
					}
					
				}
				
			}
			
		}
		
		return false;
		
	}
	
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
	
}
