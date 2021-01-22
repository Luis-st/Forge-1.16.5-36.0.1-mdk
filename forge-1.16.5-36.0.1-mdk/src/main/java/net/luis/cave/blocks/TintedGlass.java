package net.luis.cave.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.BreakableBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class TintedGlass extends BreakableBlock {

	public TintedGlass() {
		
		super(AbstractBlock.Properties.create(Material.GLASS)
				.zeroHardnessAndResistance()
				.sound(SoundType.GLASS)
				.harvestLevel(0)
				.notSolid());
		
	}
	
	@Override
	public VoxelShape getRayTraceShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
		
		return VoxelShapes.fullCube();
		
	}
	
	
	
	@Override
	public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
		
		return 0.0f;
		
	}
	
	@Override
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {

		return false;
		
	}
	
}
