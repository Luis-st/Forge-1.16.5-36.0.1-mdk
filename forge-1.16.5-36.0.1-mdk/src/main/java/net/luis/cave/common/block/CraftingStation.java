package net.luis.cave.common.block;

import java.util.stream.Stream;

import javax.annotation.Nullable;

import net.luis.cave.common.tileentity.CraftingStationTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class CraftingStation extends ContainerBlock implements IWaterLoggable {
	
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	@SuppressWarnings("unused")
	private static final ITextComponent CONTAINER_NAME = new TranslationTextComponent("container.crafting_station");
	private static final VoxelShape SHAPE = Stream.of(Block.makeCuboidShape(0, 12, 0, 16, 16, 16),
			Block.makeCuboidShape(0, 0, 12, 4, 12, 16), Block.makeCuboidShape(12, 0, 12, 16, 12, 16),
			Block.makeCuboidShape(12, 0, 0, 16, 12, 4), Block.makeCuboidShape(0, 0, 0, 4, 12, 4)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();

	public CraftingStation() {
		
		super(Block.Properties.from(Blocks.CRAFTING_TABLE));
		this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, Boolean.valueOf(false)));
		
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		
		return SHAPE;
		
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		
		return true;
		
	}
	
	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		
		return new CraftingStationTileEntity();
		
	}
	
	@Override
	public BlockRenderType getRenderType(BlockState state) {
		
		return BlockRenderType.MODEL;
		
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		
		if (worldIn.isRemote) {
			
			return ActionResultType.SUCCESS;
			
		} else {
			
			TileEntity tileentity = worldIn.getTileEntity(pos);
			
			if (tileentity instanceof CraftingStationTileEntity && player instanceof ServerPlayerEntity) {
				
				NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileentity, pos);
				player.addStat(Stats.OPEN_BARREL);
				PiglinTasks.func_234478_a_(player, true);
				
			}

			return ActionResultType.CONSUME;
			
		}
		
	}

	@Override
	@SuppressWarnings("deprecation")
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		
		if (!state.isIn(newState.getBlock())) {
			
			TileEntity tileentity = worldIn.getTileEntity(pos);
			
			if (tileentity instanceof IInventory) {
				
				InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory) tileentity);
				worldIn.updateComparatorOutputLevel(pos, this);
				
			}

			super.onReplaced(state, worldIn, pos, newState, isMoving);
			
		}
		
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		
		if (stack.hasDisplayName()) {
			
			TileEntity tileentity = worldIn.getTileEntity(pos);
			
			if (tileentity instanceof CraftingStationTileEntity) {
				
				((CraftingStationTileEntity) tileentity).setCustomName(stack.getDisplayName());
				
			}
			
		}

	}

	@Override
	public boolean hasComparatorInputOverride(BlockState state) {
		
		return true;
		
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		
		FluidState fluidstate = context.getWorld().getFluidState(context.getPos());
		boolean flag = fluidstate.getFluid() == Fluids.WATER;
		return super.getStateForPlacement(context).with(WATERLOGGED, Boolean.valueOf(flag));
		
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		
		if (stateIn.get(WATERLOGGED)) {
			
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
			
		}

		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		
		builder.add(WATERLOGGED);
		
	}

	@Override
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
		
	}

}
