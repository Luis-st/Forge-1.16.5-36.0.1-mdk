package net.luis.cave.api.item.api.tool;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Shovel extends ShovelItem {

	public static final BlockState PATH = Blocks.GRASS_PATH.getDefaultState();
	
	public Shovel(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
		
		super(tier, attackDamageIn, attackSpeedIn, builder);
		
	}
	
	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		
		World world = context.getWorld();
		BlockPos blockPos = context.getPos();
		BlockState blockState = world.getBlockState(blockPos);
		
		if (context.getFace() == Direction.DOWN) {
			
			return ActionResultType.PASS;
			
		} else {
			
			PlayerEntity playerEntity = context.getPlayer();
			BlockState toolState = this.getToolModifiedState(blockState);
			BlockState newState = null;
			
			if (toolState != null && world.isAirBlock(blockPos.up())) {
				
				world.playSound(playerEntity, blockPos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
				newState = toolState;
				
			} else if (blockState.getBlock() instanceof CampfireBlock && blockState.get(CampfireBlock.LIT)) {
				
				if (!world.isRemote()) {
					
					world.playEvent((PlayerEntity) null, 1009, blockPos, 0);
					
				}

				CampfireBlock.extinguish(world, blockPos, blockState);
				newState = blockState.with(CampfireBlock.LIT, Boolean.valueOf(false));
				
			}

			if (newState != null) {
				
				if (!world.isRemote) {
					
					world.setBlockState(blockPos, newState, 11);
					
					if (playerEntity != null) {
						
						context.getItem().damageItem(1, playerEntity, (player) -> {
							
							player.sendBreakAnimation(context.getHand());
							
						});
						
					}
					
				}

				return ActionResultType.func_233537_a_(world.isRemote);
				
			} else {
				
				return ActionResultType.PASS;
				
			}
			
		}
		
	}
	
	@Nullable
	public BlockState getToolModifiedState(BlockState state) {
		
		if (state.getBlock() == Blocks.GRASS_BLOCK) {
			
			return PATH;
			
		} else if (state.getBlock() == Blocks.DIRT) {
			
			return PATH;
			
		} else if (state.getBlock() == Blocks.COARSE_DIRT) {
			
			return PATH;
			
		} else if (state.getBlock() == Blocks.PODZOL) {
			
			return PATH;
			
		} else if (state.getBlock() == Blocks.MYCELIUM) {
			
			return PATH;
			
		}
		
		return null;
		
	}
	
}
