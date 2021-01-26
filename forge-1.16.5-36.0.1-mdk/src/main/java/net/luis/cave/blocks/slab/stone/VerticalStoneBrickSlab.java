package net.luis.cave.blocks.slab.stone;

import net.luis.cave.blocks.slab.AbstractVerticalSlab;
import net.luis.cave.init.blocks.CaveVerticalBlockItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class VerticalStoneBrickSlab extends AbstractVerticalSlab {
	
	public VerticalStoneBrickSlab() {

		super(AbstractBlock.Properties.from(Blocks.STONE_BRICK_SLAB));

	}

	@Override
	@SuppressWarnings("deprecation")
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
	
		if (hit.getFace().getOpposite() == state.get(VerticalStoneBrickSlab.FACING)
				&& !state.get(VerticalStoneBrickSlab.FULL)
				&& player.getHeldItem(handIn).getItem() == CaveVerticalBlockItems.VERTICAL_STONE_BRICK_SLAB_ITEM.get()) {

			worldIn.setBlockState(pos, state.with(VerticalStoneBrickSlab.FULL, true));

			if (!player.isCreative()) {

				player.getHeldItem(handIn).setCount(player.getHeldItem(handIn).getCount() - 1);

			}

			return ActionResultType.SUCCESS;

		}

		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);

	}
	
}
