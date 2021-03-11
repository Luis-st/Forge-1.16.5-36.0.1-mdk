package net.luis.cave.common.block;

import java.util.Random;

import net.luis.cave.common.inventory.container.ModEnchantingTableContainer;
import net.luis.cave.common.tileentity.ModEnchantingTableTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.INameable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModEnchantingTable extends ContainerBlock {
	
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);

	public ModEnchantingTable(Properties builder) {
		
		super(builder);
		
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		
		return true;
		
	}
	
	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		
		return new ModEnchantingTableTileEntity();
		
	}
	
	@Override
	public boolean isTransparent(BlockState state) {
		
		return true;
		
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		
		return SHAPE;
		
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
			
			player.openContainer(state.getContainer(worldIn, pos));
			return ActionResultType.CONSUME;
			
		}
		
	}
	
	@Override
	public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
		
		TileEntity tileentity = worldIn.getTileEntity(pos);
		
		if (tileentity instanceof ModEnchantingTableTileEntity) {
			
			ITextComponent itextcomponent = ((INameable) tileentity).getDisplayName();
			
			return new SimpleNamedContainerProvider((id, inventory, player) -> {
				
				return new ModEnchantingTableContainer(id, inventory, worldIn, pos);
				
			}, itextcomponent);
			
		} else {
			
			return null;
			
		}
		
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		
		if (stack.hasDisplayName()) {
			
			TileEntity tileentity = worldIn.getTileEntity(pos);
			
			if (tileentity instanceof ModEnchantingTableTileEntity) {
				
				((ModEnchantingTableTileEntity) tileentity).setCustomName(stack.getDisplayName());
				
			}
			
		}

	}

	@Override
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		
		return false;
		
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		
		super.animateTick(stateIn, worldIn, pos, rand);

		for (int i = -2; i <= 2; ++i) {
			
			for (int j = -2; j <= 2; ++j) {
				
				if (i > -2 && i < 2 && j == -1) {
					
					j = 2;
					
				}

				if (rand.nextInt(16) == 0) {
					
					for (int k = 0; k <= 1; ++k) {
						
						BlockPos blockpos = pos.add(i, k, j);
						
						if (worldIn.getBlockState(blockpos).getEnchantPowerBonus(worldIn, blockpos) > 0) {
							
							if (!worldIn.isAirBlock(pos.add(i / 2, 0, j / 2))) {
								
								break;
								
							}

							worldIn.addParticle(ParticleTypes.ENCHANT, pos.getX() + 0.5D, pos.getY() + 2.0D, pos.getZ() + 0.5D, 
									(i + rand.nextFloat()) - 0.5D, (k - rand.nextFloat() - 1.0F), (j + rand.nextFloat()) - 0.5D);
							
						}
						
					}
					
				}
				
			}
			
		}

	}

}
