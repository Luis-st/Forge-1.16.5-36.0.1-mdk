package net.luis.cave.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class TintedGlass extends Block {

	public TintedGlass() {
		
		super(Block.Properties.create(Material.ROCK)
				.zeroHardnessAndResistance()
				.sound(SoundType.GLASS)
				.notSolid());

	}
	
	@Override
	public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
		
		return 0.0f;
		
	}
	
	@Override
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		
		return false;
		
	}
	
	@Override
	public int getOpacity(BlockState state, IBlockReader world, BlockPos pos) {
		
		return world.getMaxLightLevel();
		
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
		
		return adjacentBlockState.isIn(this) ? true : super.isSideInvisible(state, adjacentBlockState, side);
		
	}

}
