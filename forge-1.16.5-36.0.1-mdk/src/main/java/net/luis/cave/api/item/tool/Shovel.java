package net.luis.cave.api.item.tool;

import java.util.Set;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class Shovel extends ToolItem {

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.CLAY, Blocks.DIRT, Blocks.COARSE_DIRT,
			Blocks.PODZOL, Blocks.FARMLAND, Blocks.GRASS_BLOCK, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND,
			Blocks.RED_SAND, Blocks.SNOW_BLOCK, Blocks.SNOW, Blocks.SOUL_SAND, Blocks.GRASS_PATH,
			Blocks.WHITE_CONCRETE_POWDER, Blocks.ORANGE_CONCRETE_POWDER, Blocks.MAGENTA_CONCRETE_POWDER,
			Blocks.LIGHT_BLUE_CONCRETE_POWDER, Blocks.YELLOW_CONCRETE_POWDER, Blocks.LIME_CONCRETE_POWDER,
			Blocks.PINK_CONCRETE_POWDER, Blocks.GRAY_CONCRETE_POWDER, Blocks.LIGHT_GRAY_CONCRETE_POWDER,
			Blocks.CYAN_CONCRETE_POWDER, Blocks.PURPLE_CONCRETE_POWDER, Blocks.BLUE_CONCRETE_POWDER,
			Blocks.BROWN_CONCRETE_POWDER, Blocks.GREEN_CONCRETE_POWDER, Blocks.RED_CONCRETE_POWDER,
			Blocks.BLACK_CONCRETE_POWDER, Blocks.SOUL_SOIL);
	public static final BlockState PATH = Blocks.GRASS_PATH.getDefaultState();
	
	public Shovel(IItemTier tier, float attackDamageIn, float attackSpeedIn, Item.Properties builder) {

		super(attackDamageIn, attackSpeedIn, tier, EFFECTIVE_ON, builder.addToolType(ToolType.SHOVEL, tier.getHarvestLevel()));

	}
	
	
	@Override
	public boolean canHarvestBlock(BlockState blockIn) {
		
		return blockIn.isIn(Blocks.SNOW) || blockIn.isIn(Blocks.SNOW_BLOCK);
		
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
