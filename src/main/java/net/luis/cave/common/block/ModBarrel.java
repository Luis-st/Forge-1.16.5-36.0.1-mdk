package net.luis.cave.common.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.luis.cave.common.tileentity.ModBarrelTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

public class ModBarrel extends ContainerBlock {
	
	public static final DirectionProperty PROPERTY_FACING = BlockStateProperties.FACING;
	public static final BooleanProperty PROPERTY_OPEN = BlockStateProperties.OPEN;

	public ModBarrel(AbstractBlock.Properties properties) {
		
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(PROPERTY_FACING, Direction.NORTH) .with(PROPERTY_OPEN, Boolean.valueOf(false)));
		
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		
		if (worldIn.isRemote) {
			
			return ActionResultType.SUCCESS;
			
		} else {
			
			TileEntity tileentity = worldIn.getTileEntity(pos);
			
			if (tileentity instanceof ModBarrelTileEntity && player instanceof ServerPlayerEntity) {
				
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
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		
		TileEntity tileentity = worldIn.getTileEntity(pos);
		
		if (tileentity instanceof ModBarrelTileEntity) {
			
			((ModBarrelTileEntity) tileentity).barrelTick();
			
		}

	}

	@Nullable
	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		
		return new ModBarrelTileEntity();
		
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		
		return BlockRenderType.MODEL;
		
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		
		if (stack.hasDisplayName()) {
			
			TileEntity tileentity = worldIn.getTileEntity(pos);
			
			if (tileentity instanceof ModBarrelTileEntity) {
				
				((ModBarrelTileEntity) tileentity).setCustomName(stack.getDisplayName());
				
			}
			
		}

	}

	@Override
	public boolean hasComparatorInputOverride(BlockState state) {
		
		return true;
		
	}

	@Override
	public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
		
		return Container.calcRedstone(worldIn.getTileEntity(pos));
		
	}

	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		
		return state.with(PROPERTY_FACING, rot.rotate(state.get(PROPERTY_FACING)));
		
	}

	@Override
	@SuppressWarnings("deprecation")
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		
		return state.rotate(mirrorIn.toRotation(state.get(PROPERTY_FACING)));
		
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		
		builder.add(PROPERTY_FACING, PROPERTY_OPEN);
		
	}

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		
		return this.getDefaultState().with(PROPERTY_FACING, context.getNearestLookingDirection().getOpposite());
		
	}
	
}