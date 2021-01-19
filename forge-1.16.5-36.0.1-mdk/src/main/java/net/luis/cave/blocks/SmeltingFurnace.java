package net.luis.cave.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraftforge.common.ToolType;

public class SmeltingFurnace extends Block {
	
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final BooleanProperty LIT = BlockStateProperties.LIT;
	
	public SmeltingFurnace() {
		
		super(Block.Properties.create(Material.ROCK)
				.hardnessAndResistance(3.5f)
				.sound(SoundType.STONE)
				.harvestTool(ToolType.PICKAXE)
				.setRequiresTool());
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(LIT, Boolean.valueOf(false)));
		
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
		
	}
	
	@Override
	public BlockRenderType getRenderType(BlockState state) {
		
		return BlockRenderType.MODEL;
		
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		
		return state.with(FACING, rot.rotate(state.get(FACING)));
		
	}

	@Override
	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
		
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		
		builder.add(FACING, LIT);
		
	}
	
}