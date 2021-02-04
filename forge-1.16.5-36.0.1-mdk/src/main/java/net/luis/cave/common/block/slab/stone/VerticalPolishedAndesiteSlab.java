package net.luis.cave.common.block.slab.stone;

import net.luis.cave.api.block.AbstractVerticalSlab;
import net.luis.cave.init.blocks.ModVerticalBlockItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class VerticalPolishedAndesiteSlab extends AbstractVerticalSlab {
	
	public VerticalPolishedAndesiteSlab() {

		super(AbstractBlock.Properties.from(Blocks.POLISHED_ANDESITE));

	}

	@Override
	@SuppressWarnings("deprecation")
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
	
		if (hit.getFace().getOpposite() == state.get(VerticalPolishedAndesiteSlab.FACING)
				&& !state.get(VerticalPolishedAndesiteSlab.FULL)
				&& player.getHeldItem(handIn).getItem() == ModVerticalBlockItems.POLISHED_VERTICAL_ANDESITE_SLAB_ITEM.get()) {

			worldIn.setBlockState(pos, state.with(VerticalPolishedAndesiteSlab.FULL, true));

			if (!player.isCreative()) {

				player.getHeldItem(handIn).setCount(player.getHeldItem(handIn).getCount() - 1);

			}

			return ActionResultType.SUCCESS;

		}

		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);

	}
	
}
