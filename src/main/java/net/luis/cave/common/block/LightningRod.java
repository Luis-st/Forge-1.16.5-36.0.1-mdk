package net.luis.cave.common.block;

import net.luis.cave.api.item.ItemManager;
import net.luis.cave.common.tileentity.LightningRodTileEntity;
import net.luis.cave.init.ModEnchantment;
import net.luis.cave.init.blocks.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DirectionalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class LightningRod extends DirectionalBlock implements IWaterLoggable {
	
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	private static final VoxelShape FACING_DOWN = Block.makeCuboidShape(6, 0, 6, 10, 16, 10);
	private static final VoxelShape FACING_UP = Block.makeCuboidShape(6, 0, 6, 10, 16, 10);
	private static final VoxelShape FACING_NORTH = Block.makeCuboidShape(6, 6, 0, 10, 10, 16);
	private static final VoxelShape FACING_EAST = Block.makeCuboidShape(0, 6, 6, 16, 10, 10);
	private static final VoxelShape FACING_SOUTH = Block.makeCuboidShape(6, 6, 0, 10, 10, 16);
	private static final VoxelShape FACING_WEST = Block.makeCuboidShape(0, 6, 6, 16, 10, 10);

	public LightningRod() {
		
		super(AbstractBlock.Properties.from(ModBlocks.COPPER_BLOCK.get()).notSolid().tickRandomly());
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
	public boolean hasTileEntity(BlockState state) {
		
		return true;
		
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		
		return new LightningRodTileEntity();
		
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
		
		int enchThunderbolt = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.THUNDERBOLT.get(), player.getHeldItem(hand));
		
		if (enchThunderbolt > 0) {
			
			LightningBoltEntity lightning = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, world);
			lightning.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), world.rand.nextFloat() * 360, 0);
			world.addEntity(lightning);
			
			ItemManager.damageItem(player.getHeldItem(hand), enchThunderbolt, player, e -> {
				
				e.sendBreakAnimation(hand);
				
			}, false);
			
			return ActionResultType.SUCCESS;
			
		}
		
		return super.onBlockActivated(state, world, pos, player, hand, hit);
		
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
