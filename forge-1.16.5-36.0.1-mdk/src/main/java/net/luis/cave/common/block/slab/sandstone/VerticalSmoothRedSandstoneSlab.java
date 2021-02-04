package net.luis.cave.common.block.slab.sandstone;

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

public class VerticalSmoothRedSandstoneSlab extends AbstractVerticalSlab {
	
	public VerticalSmoothRedSandstoneSlab() {

		super(AbstractBlock.Properties.from(Blocks.SMOOTH_RED_SANDSTONE_SLAB));

	}

	@Override
	@SuppressWarnings("deprecation")
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
	
		if (hit.getFace().getOpposite() == state.get(VerticalSmoothRedSandstoneSlab.FACING)
				&& !state.get(VerticalSmoothRedSandstoneSlab.FULL)
				&& player.getHeldItem(handIn).getItem() == ModVerticalBlockItems.VERTICAL_SMOOTH_RED_SANDSTONE_SLAB_ITEM.get()) {

			worldIn.setBlockState(pos, state.with(VerticalSmoothRedSandstoneSlab.FULL, true));

			if (!player.isCreative()) {

				player.getHeldItem(handIn).setCount(player.getHeldItem(handIn).getCount() - 1);

			}

			return ActionResultType.SUCCESS;

		}

		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);

	}
	
}
