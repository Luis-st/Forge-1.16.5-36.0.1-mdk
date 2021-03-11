package net.luis.cave.common.item;

import net.luis.cave.Cave;
import net.luis.cave.init.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PowderSnowBucket extends Item {

	public PowderSnowBucket() {
		
		super(new Item.Properties()
				.group(Cave.MISC)
				.maxStackSize(1));
		
	}
	
	@Override
	public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
		
		World world = context.getWorld();
		BlockPos pos = context.getPos();
		PlayerEntity player = context.getPlayer();
		Direction direction = context.getFace();
		ItemStack item = new ItemStack(Items.BUCKET, 1);
		
		switch (direction) {
		case UP: 	if (world.getBlockState(pos.up()).getBlock() ==  Blocks.AIR |
						world.getBlockState(pos.up()).getBlock() ==  Blocks.CAVE_AIR) {
			
						world.setBlockState(pos.up(), ModBlocks.POWDER_SNOW.get().getDefaultState());
							
						if (!player.abilities.isCreativeMode) {
							
							player.setHeldItem(Hand.MAIN_HAND, item);
							
						}
						
						return ActionResultType.SUCCESS;
			
					} break;
				 	
		case DOWN: 	if (world.getBlockState(pos.down()).getBlock() ==  Blocks.AIR |
						world.getBlockState(pos.down()).getBlock() ==  Blocks.CAVE_AIR) {
			
						world.setBlockState(pos.down(), ModBlocks.POWDER_SNOW.get().getDefaultState());
							
						if (!player.abilities.isCreativeMode) {
								
							player.setHeldItem(Hand.MAIN_HAND, item);
								
						}
				
						return ActionResultType.SUCCESS;
	
					} break;
		 		   	
		case NORTH:	if (world.getBlockState(pos.north()).getBlock() ==  Blocks.AIR |
						world.getBlockState(pos.north()).getBlock() ==  Blocks.CAVE_AIR) {
			
						world.setBlockState(pos.north(), ModBlocks.POWDER_SNOW.get().getDefaultState());
							
						if (!player.abilities.isCreativeMode) {
								
							player.setHeldItem(Hand.MAIN_HAND, item);
								
						}
				
						return ActionResultType.SUCCESS;
	
					} break;
		 			
		case EAST:	if (world.getBlockState(pos.east()).getBlock() ==  Blocks.AIR |
						world.getBlockState(pos.east()).getBlock() ==  Blocks.CAVE_AIR) {
			
						world.setBlockState(pos.east(), ModBlocks.POWDER_SNOW.get().getDefaultState());
							
						if (!player.abilities.isCreativeMode) {
								
							player.setHeldItem(Hand.MAIN_HAND, item);
								
						}
				
						return ActionResultType.SUCCESS;
	
					} break;
		 		   	
		case SOUTH: if (world.getBlockState(pos.south()).getBlock() ==  Blocks.AIR |
						world.getBlockState(pos.south()).getBlock() ==  Blocks.CAVE_AIR) {
			
						world.setBlockState(pos.south(), ModBlocks.POWDER_SNOW.get().getDefaultState());
							
						if (!player.abilities.isCreativeMode) {
								
							player.setHeldItem(Hand.MAIN_HAND, item);
								
						}
				
						return ActionResultType.SUCCESS;
	
					} break;
		         	
		case WEST: 	if (world.getBlockState(pos.west()).getBlock() ==  Blocks.AIR |
						world.getBlockState(pos.west()).getBlock() ==  Blocks.CAVE_AIR) {
			
						world.setBlockState(pos.west(), ModBlocks.POWDER_SNOW.get().getDefaultState());
						
						if (!player.abilities.isCreativeMode) {
							
							player.setHeldItem(Hand.MAIN_HAND, item);
							
						}
				
						return ActionResultType.SUCCESS;
	
					} break;
		}
		
		return ActionResultType.PASS;
		
	}

}
