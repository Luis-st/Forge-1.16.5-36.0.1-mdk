package net.luis.cave.blocks;

import net.luis.cave.init.blocks.CaveBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class LightningRod extends DirectionalBlock implements IWaterLoggable {
	
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final VoxelShape FACING_DOWN = Block.makeCuboidShape(6, 0, 6, 10, 16, 10);
	private static final VoxelShape FACING_UP = Block.makeCuboidShape(6, 0, 6, 10, 16, 10);
	private static final VoxelShape FACING_NORTH = Block.makeCuboidShape(6, 6, 0, 10, 10, 16);
	private static final VoxelShape FACING_EAST = Block.makeCuboidShape(0, 6, 6, 16, 10, 10);
	private static final VoxelShape FACING_SOUTH = Block.makeCuboidShape(6, 6, 0, 10, 10, 16);
	private static final VoxelShape FACING_WEST = Block.makeCuboidShape(0, 6, 6, 16, 10, 10);

	public LightningRod() {
		
		super(AbstractBlock.Properties.from(CaveBlocks.COPPER_BLOCK.get()).notSolid());
		this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, Boolean.valueOf(false)));
		
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		
		switch (state.get(FACING)) {
		case DOWN:
			return FACING_DOWN;
		case UP:
			return FACING_UP;
		case NORTH:
			return FACING_NORTH;
		case EAST:
			return FACING_EAST;
		case SOUTH:
			return FACING_SOUTH;
		case WEST:
			return FACING_WEST;
		}
		
		return super.getShape(state, worldIn, pos, context);
		
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		
		FluidState fluidstate = context.getWorld().getFluidState(context.getPos());
		boolean flag = fluidstate.getFluid() == Fluids.WATER;
		
		return this.getDefaultState().with(FACING, context.getFace()).with(WATERLOGGED, Boolean.valueOf(flag));
		
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {

		if (state.get(WATERLOGGED)) {
			
			world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
			
		}

		return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
		
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		
		return state.with(FACING, rot.rotate(state.get(FACING)));
		
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		
		return state.rotate(mirror.toRotation(state.get(FACING)));
		
	}
	
	@Override
	public boolean allowsMovement(BlockState state, IBlockReader world, BlockPos pos, PathType type) {
		
		return false;
		
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		
		builder.add(FACING).add(WATERLOGGED);
		
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
		
	}

}
