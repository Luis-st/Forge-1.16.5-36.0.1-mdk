package net.luis.cave.api.world.block.api;

import java.util.stream.Stream;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class AbstractVerticalSlab extends Block implements IWaterLoggable {
	
	public static DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static BooleanProperty FULL = BooleanProperty.create("full");
	public static IntegerProperty SHAPE = IntegerProperty.create("shape", 0, 4);
	private static VoxelShape SHAPE_N = Stream.of(Block.makeCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 8.0))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_NIL = Stream
			.of(new VoxelShape[] { Block.makeCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 8.0),
					Block.makeCuboidShape(0.0, 0.0, 8.0, 8.0, 16.0, 16.0) })
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_NIR = Stream
			.of(new VoxelShape[] { Block.makeCuboidShape(0.0, 16.0, 0.0, 16.0, 0.0, 8.0),
					Block.makeCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 16.0) })
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_NOL = Stream.of(Block.makeCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 8.0))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_NOR = Stream.of(Block.makeCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 8.0))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_S = Stream.of(Block.makeCuboidShape(0.0, 0.0, 8.0, 16.0, 16.0, 16.0))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_SIL = Stream
			.of(new VoxelShape[] { Block.makeCuboidShape(0.0, 0.0, 8.0, 16.0, 16.0, 16.0),
					Block.makeCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 16.0) })
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_SIR = Stream
			.of(new VoxelShape[] { Block.makeCuboidShape(0.0, 0.0, 8.0, 16.0, 16.0, 16.0),
					Block.makeCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 16.0) })
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_SOL = Stream.of(Block.makeCuboidShape(0.0, 0.0, 8.0, 8.0, 16.0, 16.0))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_SOR = Stream.of(Block.makeCuboidShape(8.0, 0.0, 8.0, 16.0, 16.0, 16.0))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_W = Stream.of(Block.makeCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 16.0))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_WIL = Stream.of(Block.makeCuboidShape(0.0, 0.0, 8.0, 8.0, 16.0, 16.0))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_WIR = Stream.of(Block.makeCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 8.0))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_WOL = Stream
			.of(new VoxelShape[] { Block.makeCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 16.0),
					Block.makeCuboidShape(8.0, 0.0, 8.0, 16.0, 16.0, 16.0) })
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_WOR = Stream
			.of(new VoxelShape[] { Block.makeCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 16.0),
					Block.makeCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 8.0) })
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_E = Stream.of(Block.makeCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 16.0))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_EIL = Stream.of(Block.makeCuboidShape(8.0, 0.0, 8.0, 16.0, 16.0, 16.0))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_EIR = Stream.of(Block.makeCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 8.0))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_EOL = Stream
			.of(new VoxelShape[] { Block.makeCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 16.0),
					Block.makeCuboidShape(0.0, 0.0, 8.0, 8.0, 16.0, 16.0) })
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_EOR = Stream
			.of(new VoxelShape[] { Block.makeCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 16.0),
					Block.makeCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 8.0) })
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();
	private static VoxelShape SHAPE_FULL = Stream.of(Block.makeCuboidShape(0.0, 16.0, 0.0, 16.0, 0.0, 16.0))
			.reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

	public AbstractVerticalSlab( AbstractBlock.Properties properties) {
		
		super(properties.notSolid().variableOpacity());
		this.setDefaultState(this.stateContainer.getBaseState()
				.with(AbstractVerticalSlab.FULL, false)
				.with(AbstractVerticalSlab.SHAPE, 0)
				.with(BlockStateProperties.WATERLOGGED, false));
		
	}

	@Override
	public BlockState getStateForPlacement( BlockItemUseContext context) { 
		BlockState checkedState = this.checkAdjacentBlocks(context.getWorld(), context.getPos(), this.getDefaultState() 
				.with(AbstractVerticalSlab.FACING, context.getPlacementHorizontalFacing()), 0);
		
		if (context.getWorld().getBlockState(context.getPos()).getFluidState()
				.getFluid() instanceof WaterFluid && context.getWorld().getBlockState(context.getPos()).getFluidState().isSource()) {
			
			checkedState = checkedState.with(BlockStateProperties.WATERLOGGED, true);
			
		}
		
		return checkedState;
		
	}

	@Override
	public VoxelShape getShape( BlockState state,  IBlockReader worldIn,  BlockPos pos, ISelectionContext context) {
		
		if (state.get(AbstractVerticalSlab.FULL)) {
			
			return AbstractVerticalSlab.SHAPE_FULL;
			
		}
		
		switch ((Direction) state.get(AbstractVerticalSlab.FACING)) {
			case NORTH: {
				if (state.get(AbstractVerticalSlab.SHAPE) == 1) {
					return AbstractVerticalSlab.SHAPE_NIL;
				}
				if (state.get(AbstractVerticalSlab.SHAPE) == 2) {
					return AbstractVerticalSlab.SHAPE_NIR;
				}
				if (state.get(AbstractVerticalSlab.SHAPE) == 3) {
					return AbstractVerticalSlab.SHAPE_NOL;
				}
				if (state.get(AbstractVerticalSlab.SHAPE) == 4) {
					return AbstractVerticalSlab.SHAPE_NOR;
				}
				
				return AbstractVerticalSlab.SHAPE_N;
				
			}
			case SOUTH: {
				if (state.get( AbstractVerticalSlab.SHAPE) == 1) {
					return AbstractVerticalSlab.SHAPE_SIL;
				}
				if (state.get(AbstractVerticalSlab.SHAPE) == 2) {
					return AbstractVerticalSlab.SHAPE_SIR;
				}
				if (state.get(AbstractVerticalSlab.SHAPE) == 3) {
					return AbstractVerticalSlab.SHAPE_SOL;
				}
				if (state.get(AbstractVerticalSlab.SHAPE) == 4) {
					return AbstractVerticalSlab.SHAPE_SOR;
				}
				
				return AbstractVerticalSlab.SHAPE_S;
				
			}
			case EAST: {
				if (state.get(AbstractVerticalSlab.SHAPE) == 1) {
					return AbstractVerticalSlab.SHAPE_EOR;
				}
				if (state.get(AbstractVerticalSlab.SHAPE) == 2) {
					return AbstractVerticalSlab.SHAPE_EOL;
				}
				if (state.get(AbstractVerticalSlab.SHAPE) == 3) {
					return AbstractVerticalSlab.SHAPE_EIR;
				}
				if (state.get(AbstractVerticalSlab.SHAPE) == 4) {
					return AbstractVerticalSlab.SHAPE_EIL;
				}
				
				return AbstractVerticalSlab.SHAPE_E;
				
			}
			case WEST: {
				if (state.get(AbstractVerticalSlab.SHAPE) == 1) {
					return AbstractVerticalSlab.SHAPE_WOR;
				}
				if (state.get(AbstractVerticalSlab.SHAPE) == 2) {
					return AbstractVerticalSlab.SHAPE_WOL;
				}
				if (state.get(AbstractVerticalSlab.SHAPE) == 3) {
					return AbstractVerticalSlab.SHAPE_WIR;
				}
				if (state.get(AbstractVerticalSlab.SHAPE) == 4) {
					return AbstractVerticalSlab.SHAPE_WIL;
				}
				
				return AbstractVerticalSlab.SHAPE_W;
				
			}
		
			default: {
			
				return AbstractVerticalSlab.SHAPE_N;
			
			}
		
		}
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		
		return state.with(AbstractVerticalSlab.FACING, rot.rotate(state.get(AbstractVerticalSlab.FACING)));
		
	}

	@Override
	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirror) {
		
		return state.rotate(mirror.toRotation((Direction) state.get(AbstractVerticalSlab.FACING)));
		
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		
		builder.add(new Property[] {AbstractVerticalSlab.FACING, AbstractVerticalSlab.FULL, AbstractVerticalSlab.SHAPE, BlockStateProperties.WATERLOGGED});
		
	}

	private void updateNeighbours(World world, BlockPos pos, boolean blockBeingDestroyed) {
		
		 BlockState north = world.getBlockState(pos.offset(Direction.NORTH));
		 BlockState south = world.getBlockState(pos.offset(Direction.SOUTH));
		 BlockState west = world.getBlockState(pos.offset(Direction.WEST));
		 BlockState east = world.getBlockState(pos.offset(Direction.EAST));
		 
		if (north.getBlock() instanceof AbstractVerticalSlab) {
			
			if (!blockBeingDestroyed) {
				
				world.setBlockState(pos.offset(Direction.NORTH), this.checkAdjacentBlocks(world, pos.offset(Direction.NORTH), north, 0));
				
			} else {
				
				world.setBlockState(pos.offset(Direction.NORTH), this.checkAdjacentBlocks(world, pos.offset(Direction.NORTH), north, 2));
				
			}
			
		}
		
		if (south.getBlock() instanceof AbstractVerticalSlab) {
			
			if (!blockBeingDestroyed) {
				
				world.setBlockState(pos.offset(Direction.SOUTH), this.checkAdjacentBlocks(world, pos.offset(Direction.SOUTH), south, 0));
				
			} else {
				
				world.setBlockState(pos.offset(Direction.SOUTH), this.checkAdjacentBlocks(world, pos.offset(Direction.SOUTH), south, 1));
				
			}
			
		}
		
		if (west.getBlock() instanceof AbstractVerticalSlab) {
			
			if (!blockBeingDestroyed) {
				
				world.setBlockState(pos.offset(Direction.WEST), this.checkAdjacentBlocks(world, pos.offset(Direction.WEST), west, 0));
				
			} else {
				
				world.setBlockState(pos.offset(Direction.WEST), this.checkAdjacentBlocks(world, pos.offset(Direction.WEST), west, 4));
				
			}
			
		}
		if (east.getBlock() instanceof AbstractVerticalSlab) {
			
			if (!blockBeingDestroyed) {
				
				world.setBlockState(pos.offset(Direction.EAST), this.checkAdjacentBlocks(world, pos.offset(Direction.EAST), east, 0));
			} else {
				
				world.setBlockState(pos.offset(Direction.EAST), this.checkAdjacentBlocks(world, pos.offset(Direction.EAST), east, 3));
				
			}
			
		}
		
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		
		this.updateNeighbours(world, pos, false);
		super.onBlockPlacedBy(world, pos, state, placer, stack);
	}

	@Override
	public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		
		this.updateNeighbours(world, pos, true);
		super.onBlockHarvested(world, pos, state, player);
		
	}

	@Override
	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		
		return !state.get(AbstractVerticalSlab.FULL) && !state.get(BlockStateProperties.WATERLOGGED) && fluidIn instanceof WaterFluid;
		
	}

	@Override
	public Fluid pickupFluid(IWorld world, BlockPos pos, BlockState state) {
		
		if (state.get(BlockStateProperties.WATERLOGGED)) {
			
			world.setBlockState(pos, state.with(BlockStateProperties.WATERLOGGED, false), 3);
			return (Fluid) Fluids.WATER;
			
		}
		
		return Fluids.EMPTY;
		
	}

	@Override
	public FluidState getFluidState( BlockState state) {
		
		if (state.get(BlockStateProperties.WATERLOGGED)) {
			
			return Fluids.WATER.getStillFluidState(true);
			
		}
		
		return Fluids.EMPTY.getDefaultState();
		
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		
		if (stateIn.get(BlockStateProperties.WATERLOGGED)) {
			
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
			
		}
		
		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		
	}

	private BlockState checkAdjacentBlocks(World world, BlockPos pos, BlockState center, int beingDestroyed) {
		
		if (center.get(AbstractVerticalSlab.FULL)) {
			
			return center;
			
		}
		
		BlockState north = world.getBlockState(pos.offset(Direction.NORTH));
		
		if (beingDestroyed == 1) {
			
			north = (BlockState) north.with(AbstractVerticalSlab.FULL, true);
			
		}
		
		BlockState south = world.getBlockState(pos.offset(Direction.SOUTH));
		
		if (beingDestroyed == 2) {
			
			south = (BlockState) south.with(AbstractVerticalSlab.FULL, true);
			
		}
		
		BlockState west = world.getBlockState(pos.offset(Direction.WEST));
		
		if (beingDestroyed == 3) {
			
			west = (BlockState) west.with(AbstractVerticalSlab.FULL, true);
			
		}
		
		BlockState east = world.getBlockState(pos.offset(Direction.EAST));
		
		if (beingDestroyed == 4) {
			
			east = (BlockState) east.with(AbstractVerticalSlab.FULL, true);
			
		}
		
		if (center.get(AbstractVerticalSlab.FACING) == Direction.NORTH && (!(west.getBlock() instanceof AbstractVerticalSlab) || west.get(AbstractVerticalSlab.FULL)
			|| ((west.get(AbstractVerticalSlab.FACING) != Direction.NORTH || (west.get(AbstractVerticalSlab.SHAPE) != 0 && west.get(AbstractVerticalSlab.SHAPE) != 1
			&& west.get(AbstractVerticalSlab.SHAPE) != 4)) && (west.get(AbstractVerticalSlab.FACING) != Direction.WEST || ((west.get(AbstractVerticalSlab.SHAPE) != 0
			&& west.get(AbstractVerticalSlab.SHAPE) != 1))) || !(east.getBlock() instanceof AbstractVerticalSlab) || east.get(AbstractVerticalSlab.FULL) 
			|| ((east.get(AbstractVerticalSlab.FACING) != Direction.NORTH || (east.get(AbstractVerticalSlab.SHAPE) != 0 && east.get(AbstractVerticalSlab.SHAPE) != 2
			&& east.get(AbstractVerticalSlab.SHAPE) != 3)) && (east.get(AbstractVerticalSlab.FACING) != Direction.EAST || (east.get(AbstractVerticalSlab.SHAPE) != 0
			&& east.get(AbstractVerticalSlab.SHAPE) != 1)))))) {
			
			if (north.getBlock() instanceof AbstractVerticalSlab && !north.get(AbstractVerticalSlab.FULL)) {
				
				if (north.get(AbstractVerticalSlab.FACING) == Direction.WEST) {
					
					if (east.getBlock() instanceof AbstractVerticalSlab && ((east.get(AbstractVerticalSlab.FACING) == Direction.NORTH 
						&& (east.get(AbstractVerticalSlab.SHAPE) == 0 || east.get(AbstractVerticalSlab.SHAPE) == 3 || east.get(AbstractVerticalSlab.SHAPE) == 2
						|| east.get(AbstractVerticalSlab.SHAPE) == 4)) || (east.get(AbstractVerticalSlab.FACING) == Direction.EAST 
						&& (east.get(AbstractVerticalSlab.SHAPE) == 0 || east.get(AbstractVerticalSlab.SHAPE) == 1)))) {
						if (south.getBlock() instanceof AbstractVerticalSlab && !south.get(AbstractVerticalSlab.FULL)) {
							
							if (south.get(AbstractVerticalSlab.FACING) == Direction.WEST) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 1);
								
							}
							
							if (south.get(AbstractVerticalSlab.FACING) == Direction.EAST) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 2);
								
							}
							
						}
						
						return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 0);
						
					}
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 3);
					
				} else if (north.get(AbstractVerticalSlab.FACING) == Direction.EAST) {
					
					if (west.getBlock() instanceof AbstractVerticalSlab && ((west.get(AbstractVerticalSlab.FACING) == Direction.NORTH
						&& (west.get(AbstractVerticalSlab.SHAPE) == 0 || west.get(AbstractVerticalSlab.SHAPE) == 4 || west.get(AbstractVerticalSlab.SHAPE) == 1
						|| west.get(AbstractVerticalSlab.SHAPE) == 3)) || (west.get(AbstractVerticalSlab.FACING) == Direction.WEST 
						&& (west.get(AbstractVerticalSlab.SHAPE) == 0 || west.get(AbstractVerticalSlab.SHAPE) == 1)))) {
						
						if (south.getBlock() instanceof AbstractVerticalSlab && !south.get(AbstractVerticalSlab.FULL)) {
							
							if (south.get(AbstractVerticalSlab.FACING) == Direction.WEST) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 1);
								
							}
							
							if (south.get(AbstractVerticalSlab.FACING) == Direction.EAST) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 2);
								
							}
							
						}
						
						return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 0);
						
					}
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 4);
					
				}
				
			}
			
			if (south.getBlock() instanceof AbstractVerticalSlab && !south.get(AbstractVerticalSlab.FULL)) {
				
				if (south.get(AbstractVerticalSlab.FACING) == Direction.WEST) {
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 1);
					
				}
				
				if (south.get(AbstractVerticalSlab.FACING) == Direction.EAST) {
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 2);
					
				}
				
			}
			
		} else if (center.get(AbstractVerticalSlab.FACING) == Direction.SOUTH && (!(west.getBlock() instanceof AbstractVerticalSlab) || west.get(AbstractVerticalSlab.FULL)
					|| ((west.get(AbstractVerticalSlab.FACING) != Direction.SOUTH || (west.get(AbstractVerticalSlab.SHAPE) != 0 && west.get(AbstractVerticalSlab.SHAPE) != 2
					&& west.get(AbstractVerticalSlab.SHAPE) != 3)) && (west.get(AbstractVerticalSlab.FACING) != Direction.WEST || (west.get(AbstractVerticalSlab.SHAPE) != 0
					&& west.get(AbstractVerticalSlab.SHAPE) != 2))) || !(east.getBlock() instanceof AbstractVerticalSlab) || east.get(AbstractVerticalSlab.FULL)
					|| ((east.get(AbstractVerticalSlab.FACING) != Direction.SOUTH || (east.get(AbstractVerticalSlab.SHAPE) != 0 && east.get(AbstractVerticalSlab.SHAPE) != 1
					&& east.get(AbstractVerticalSlab.SHAPE) != 4)) && (east.get(AbstractVerticalSlab.FACING) != Direction.EAST || (east.get(AbstractVerticalSlab.SHAPE) != 0
					&& east.get(AbstractVerticalSlab.SHAPE) != 2))))) {
			
			if (south.getBlock() instanceof AbstractVerticalSlab && !south.get(AbstractVerticalSlab.FULL)) {
				
				if (south.get(AbstractVerticalSlab.FACING) == Direction.WEST) {
					
					if (east.getBlock() instanceof AbstractVerticalSlab && ((east.get(AbstractVerticalSlab.FACING) == Direction.SOUTH
						&& (east.get(AbstractVerticalSlab.SHAPE) == 0 || east.get(AbstractVerticalSlab.SHAPE) == 2 || east.get(AbstractVerticalSlab.SHAPE) == 3
						|| east.get(AbstractVerticalSlab.SHAPE) == 4)) || (east.get(AbstractVerticalSlab.FACING) == Direction.EAST 
						&& (east.get(AbstractVerticalSlab.SHAPE) == 0 || east.get(AbstractVerticalSlab.SHAPE) == 2)))) {
						
						if (north.getBlock() instanceof AbstractVerticalSlab && !north.get(AbstractVerticalSlab.FULL)) {
							
							if (north.get(AbstractVerticalSlab.FACING) == Direction.WEST) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 1);
								
							}
							
							if (north.get(AbstractVerticalSlab.FACING) == Direction.EAST) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 2);
								
							}
							
						}
						
						return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 0);
						
					}
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 3);
					
				} else if (south.get(AbstractVerticalSlab.FACING) == Direction.EAST) {
					
					if (west.getBlock() instanceof AbstractVerticalSlab && ((west.get(AbstractVerticalSlab.FACING) == Direction.SOUTH
						&& (west.get(AbstractVerticalSlab.SHAPE) == 0 || west.get(AbstractVerticalSlab.SHAPE) == 1 || west.get(AbstractVerticalSlab.SHAPE) == 4
						|| west.get(AbstractVerticalSlab.SHAPE) == 3)) || (west.get(AbstractVerticalSlab.FACING) == Direction.WEST 
						&& (west.get(AbstractVerticalSlab.SHAPE) == 0 || west.get(AbstractVerticalSlab.SHAPE) == 2)))) {
						
						if (north.getBlock() instanceof AbstractVerticalSlab && !north.get(AbstractVerticalSlab.FULL)) {
							
							if (north.get(AbstractVerticalSlab.FACING) == Direction.WEST) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 1);
								
							}
							
							if (north.get(AbstractVerticalSlab.FACING) == Direction.EAST) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 2);
								
							}
							
						}
						
						return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 0);
						
					}
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 4);
					
				}
				
			}
			
			if (north.getBlock() instanceof AbstractVerticalSlab && !north.get(AbstractVerticalSlab.FULL)) {
				
				if (north.get(AbstractVerticalSlab.FACING) == Direction.WEST) {
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 1);
					
				}
				
				if (north.get(AbstractVerticalSlab.FACING) == Direction.EAST) {
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 2);
					
				}
				
			}
			
		} else if (center.get(AbstractVerticalSlab.FACING) == Direction.WEST && (!(south.getBlock() instanceof AbstractVerticalSlab) || south.get(AbstractVerticalSlab.FULL)
					|| ((south.get(AbstractVerticalSlab.FACING) != Direction.WEST || (south.get(AbstractVerticalSlab.SHAPE) != 0 && south.get(AbstractVerticalSlab.SHAPE) != 1
					&& south.get(AbstractVerticalSlab.SHAPE) != 4)) && (south.get(AbstractVerticalSlab.FACING) != Direction.SOUTH || (south.get(AbstractVerticalSlab.SHAPE) != 0
					&& south.get(AbstractVerticalSlab.SHAPE) != 1))) || !(north.getBlock() instanceof AbstractVerticalSlab) || north.get(AbstractVerticalSlab.FULL)
					|| ((north.get(AbstractVerticalSlab.FACING) != Direction.WEST || (north.get(AbstractVerticalSlab.SHAPE) != 0
					&& north.get(AbstractVerticalSlab.SHAPE) != 2 && north.get(AbstractVerticalSlab.SHAPE) != 3)) && (north.get(AbstractVerticalSlab.FACING) != Direction.NORTH
					|| (north.get(AbstractVerticalSlab.SHAPE) != 0 && north.get(AbstractVerticalSlab.SHAPE) != 1))))) {
			
			if (west.getBlock() instanceof AbstractVerticalSlab && !west.get(AbstractVerticalSlab.FULL)) {
				
				if (west.get(AbstractVerticalSlab.FACING) == Direction.NORTH) {
					
					if (south.getBlock() instanceof AbstractVerticalSlab && ((south.get(AbstractVerticalSlab.FACING) == Direction.WEST
						&& (south.get(AbstractVerticalSlab.SHAPE) == 0 || south.get(AbstractVerticalSlab.SHAPE) == 2 
						|| south.get(AbstractVerticalSlab.SHAPE) == 3|| south.get(AbstractVerticalSlab.SHAPE) == 4)) 
						|| (south.get(AbstractVerticalSlab.FACING) == Direction.SOUTH && (south.get(AbstractVerticalSlab.SHAPE) == 0
						|| south.get(AbstractVerticalSlab.SHAPE) == 1)))) {
						
						if (east.getBlock() instanceof AbstractVerticalSlab && !east.get(AbstractVerticalSlab.FULL)) {
							
							if (east.get(AbstractVerticalSlab.FACING) == Direction.NORTH) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 1);
								
							}
							
							if (east.get(AbstractVerticalSlab.FACING) == Direction.SOUTH) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 2);
								
							}
							
						}
						
						return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 0);
						
					}
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 3);
					
				} else if (west.get(AbstractVerticalSlab.FACING) == Direction.SOUTH) {
					
					if (north.getBlock() instanceof AbstractVerticalSlab && ((north.get(AbstractVerticalSlab.FACING) == Direction.WEST
						&& (north.get(AbstractVerticalSlab.SHAPE) == 0 || north.get(AbstractVerticalSlab.SHAPE) == 1 || north.get(AbstractVerticalSlab.SHAPE) == 4
						|| north.get(AbstractVerticalSlab.SHAPE) == 3)) || (north.get(AbstractVerticalSlab.FACING) == Direction.NORTH 
						&& (north.get(AbstractVerticalSlab.SHAPE) == 0 || north.get(AbstractVerticalSlab.SHAPE) == 1)))) {
						
						if (east.getBlock() instanceof AbstractVerticalSlab && !east.get(AbstractVerticalSlab.FULL)) {
							
							if (east.get(AbstractVerticalSlab.FACING) == Direction.NORTH) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 1);
								
							}
							
							if (east.get(AbstractVerticalSlab.FACING) == Direction.SOUTH) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 2);
								
							}
							
						}
						
						return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 0);
						
					}
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 4);
					
				}
				
			}
			
			if (east.getBlock() instanceof AbstractVerticalSlab && !east.get(AbstractVerticalSlab.FULL)) {
				
				if (east.get(AbstractVerticalSlab.FACING) == Direction.NORTH) {
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 1);
					
				}
				
				if (east.get(AbstractVerticalSlab.FACING) == Direction.SOUTH) {
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 2);
					
				}
				
			}
			
		} else if (center.get(AbstractVerticalSlab.FACING) == Direction.EAST && (!(south.getBlock() instanceof AbstractVerticalSlab) || south.get(AbstractVerticalSlab.FULL)
					|| ((south.get(AbstractVerticalSlab.FACING) != Direction.EAST || (south.get(AbstractVerticalSlab.SHAPE) != 0 && south.get(AbstractVerticalSlab.SHAPE) != 3
					&& south.get(AbstractVerticalSlab.SHAPE) != 4)) && (south.get(AbstractVerticalSlab.FACING) != Direction.SOUTH || (south.get(AbstractVerticalSlab.SHAPE) != 0
					&& south.get(AbstractVerticalSlab.SHAPE) != 2))) || !(north.getBlock() instanceof AbstractVerticalSlab) || north.get(AbstractVerticalSlab.FULL)
					|| ((north.get(AbstractVerticalSlab.FACING) != Direction.EAST || (north.get(AbstractVerticalSlab.SHAPE) != 0 && north.get(AbstractVerticalSlab.SHAPE) != 2
					&& north.get(AbstractVerticalSlab.SHAPE) != 3)) && (north.get(AbstractVerticalSlab.FACING) != Direction.NORTH || (north.get(AbstractVerticalSlab.SHAPE) != 0
					&& north.get(AbstractVerticalSlab.SHAPE) != 2))))) {
			
			if (east.getBlock() instanceof AbstractVerticalSlab && !east.get(AbstractVerticalSlab.FULL)) {
				
				if (east.get(AbstractVerticalSlab.FACING) == Direction.NORTH) {
					
					if (south.getBlock() instanceof AbstractVerticalSlab && ((south.get(AbstractVerticalSlab.FACING) == Direction.EAST && (south.get(AbstractVerticalSlab.SHAPE) == 0
						|| south.get(AbstractVerticalSlab.SHAPE) == 2 || south.get(AbstractVerticalSlab.SHAPE) == 3 || south.get(AbstractVerticalSlab.SHAPE) == 4)) 
						|| (south.get(AbstractVerticalSlab.FACING) == Direction.SOUTH && (south.get(AbstractVerticalSlab.SHAPE) == 0 || south.get(AbstractVerticalSlab.SHAPE) == 2)))) {
						
						if (west.getBlock() instanceof AbstractVerticalSlab && !west.get(AbstractVerticalSlab.FULL)) {
							
							if (west.get(AbstractVerticalSlab.FACING) == Direction.NORTH) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 1);
								
							}
							
							if (west.get(AbstractVerticalSlab.FACING) == Direction.SOUTH) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 2);
								
							}
							
						}
						
						return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 0);
						
					}
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 3);
					
				} else if (east.get(AbstractVerticalSlab.FACING) == Direction.SOUTH) {
					
					if (north.getBlock() instanceof AbstractVerticalSlab && ((north.get(AbstractVerticalSlab.FACING) == Direction.EAST && (north.get(AbstractVerticalSlab.SHAPE) == 0 
						|| north.get(AbstractVerticalSlab.SHAPE) == 1 || north.get(AbstractVerticalSlab.SHAPE) == 4 || north.get(AbstractVerticalSlab.SHAPE) == 3)) 
						|| (north.get(AbstractVerticalSlab.FACING) == Direction.NORTH && (north.get(AbstractVerticalSlab.SHAPE) == 0 || north.get(AbstractVerticalSlab.SHAPE) == 2)))) {
						
						if (west.getBlock() instanceof AbstractVerticalSlab  && !west.get(AbstractVerticalSlab.FULL)) {
							
							if (west.get(AbstractVerticalSlab.FACING) == Direction.NORTH) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 1);
								
							}
							
							if (west.get(AbstractVerticalSlab.FACING) == Direction.SOUTH) {
								
								return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 2);
								
							}
							
						}
						
						return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 0);
						
					}
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 4);
					
				}
				
			}
			
			if (west.getBlock() instanceof AbstractVerticalSlab && !west.get(AbstractVerticalSlab.FULL)) {
				
				if (west.get(AbstractVerticalSlab.FACING) == Direction.NORTH) {
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 1);
					
				}
				
				if (west.get(AbstractVerticalSlab.FACING) == Direction.SOUTH) {
					
					return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 2);
					
				}
				
			}
			
		}
		
		return (BlockState) center.with(AbstractVerticalSlab.SHAPE, 0);
		
	}

}
