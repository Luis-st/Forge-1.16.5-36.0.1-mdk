package net.luis.cave.common.block;

import net.luis.cave.common.container.CaveRepairContainer;
import net.luis.cave.init.blocks.ModBlockItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

public class InfiniteAnvil extends FallingBlock {
	
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	private static final VoxelShape PART_BASE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 4.0D, 14.0D);
	private static final VoxelShape PART_LOWER_X = Block.makeCuboidShape(3.0D, 4.0D, 4.0D, 13.0D, 5.0D, 12.0D);
	private static final VoxelShape PART_MID_X = Block.makeCuboidShape(4.0D, 5.0D, 6.0D, 12.0D, 10.0D, 10.0D);
	private static final VoxelShape PART_UPPER_X = Block.makeCuboidShape(0.0D, 10.0D, 3.0D, 16.0D, 16.0D, 13.0D);
	private static final VoxelShape PART_LOWER_Z = Block.makeCuboidShape(4.0D, 4.0D, 3.0D, 12.0D, 5.0D, 13.0D);
	private static final VoxelShape PART_MID_Z = Block.makeCuboidShape(6.0D, 5.0D, 4.0D, 10.0D, 10.0D, 12.0D);
	private static final VoxelShape PART_UPPER_Z = Block.makeCuboidShape(3.0D, 10.0D, 0.0D, 13.0D, 16.0D, 16.0D);
	private static final VoxelShape X_AXIS_AABB = VoxelShapes.or(PART_BASE, PART_LOWER_X, PART_MID_X, PART_UPPER_X);
	private static final VoxelShape Z_AXIS_AABB = VoxelShapes.or(PART_BASE, PART_LOWER_Z, PART_MID_Z, PART_UPPER_Z);
	
	private static final ITextComponent containerName = new TranslationTextComponent("container.repair");

	public InfiniteAnvil() {
		
		super(Block.Properties.create(Material.ANVIL, MaterialColor.IRON)
				.hardnessAndResistance(5.0f, 1200.0f)
				.sound(SoundType.ANVIL)
				.harvestTool(ToolType.PICKAXE)
				.setRequiresTool());
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
		
	}
	
	@Override
	public INamedContainerProvider getContainer(BlockState state, World world, BlockPos pos) {
		
		return new SimpleNamedContainerProvider((id, inventory, player) -> {
			
			return new CaveRepairContainer(id, inventory);
			
		}, containerName);
		
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().rotateY());
		
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		
		if (world.isRemote) {
			
			return ActionResultType.SUCCESS;
			
		} else {
			
			player.openContainer(state.getContainer(world, pos));
			player.addStat(Stats.INTERACT_WITH_ANVIL);
			return ActionResultType.CONSUME;
			
		}
		
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		
		Direction direction = state.get(FACING);
		return direction.getAxis() == Direction.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
		
	}
	
	@Override
	protected void onStartFalling(FallingBlockEntity fallingEntity) {
		
		fallingEntity.setHurtEntities(true);
		
	}
	
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		
		return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		
	}
	
	@Override
	public void onEndFalling(World world, BlockPos pos, BlockState fallingState, BlockState hitState, FallingBlockEntity fallingBlock) {
		
		if (!fallingBlock.isSilent()) {
			
			world.playEvent(1031, pos, 0);
			
		}
		
	}
	
	@Override
	public void onBroken(World world, BlockPos pos, FallingBlockEntity fallingBlock) {
		
		double x = pos.getX();
		double y = pos.getY();
		double z = pos.getZ();
		
		ItemStack stack = new ItemStack(ModBlockItems.INFINITE_ANVIL_ITEM.get());
		ItemEntity item = new ItemEntity(world, x, y, z, stack);
		item.setPickupDelay(10);
		
		if (!fallingBlock.isSilent()) {
			
			world.playEvent(1029, pos, 0);
			
		}
		
		world.addEntity(item);
		
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		
		return state.with(FACING, rot.rotate(state.get(FACING)));
		
	}
	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		
		builder.add(FACING);
		
	}
	
	@Override
	public boolean allowsMovement(BlockState state, IBlockReader world, BlockPos pos, PathType type) {
		
		return false;
		
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public int getDustColor(BlockState state, IBlockReader reader, BlockPos pos) {
		
		return state.getMaterialColor(reader, pos).colorValue;
		
	}
	
}
