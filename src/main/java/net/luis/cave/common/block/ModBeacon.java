package net.luis.cave.common.block;

import net.luis.cave.common.tileentity.ModBeaconTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.IBeaconBeamColorProvider;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ModBeacon extends ContainerBlock implements IBeaconBeamColorProvider {
	
	public ModBeacon(AbstractBlock.Properties properties) {
		
		super(properties);
		
	}

	public DyeColor getColor() {
		
		return DyeColor.WHITE;
		
	}

	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		
		return new ModBeaconTileEntity();
		
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		
		if (worldIn.isRemote) {
			
			return ActionResultType.SUCCESS;
			
		} else {
			
			TileEntity tileentity = worldIn.getTileEntity(pos);
			
			if (tileentity instanceof ModBeaconTileEntity) {
				
				player.openContainer((ModBeaconTileEntity) tileentity);
				player.addStat(Stats.INTERACT_WITH_BEACON);
				
			}

			return ActionResultType.CONSUME;
			
		}
		
	}
	
	@Override
	public BlockRenderType getRenderType(BlockState state) {
		
		return BlockRenderType.MODEL;
		
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		
		if (stack.hasDisplayName()) {
			
			TileEntity tileentity = worldIn.getTileEntity(pos);
			
			if (tileentity instanceof ModBeaconTileEntity) {
				
				((ModBeaconTileEntity) tileentity).setCustomName(stack.getDisplayName());
				
			}
			
		}

	}
	
}
