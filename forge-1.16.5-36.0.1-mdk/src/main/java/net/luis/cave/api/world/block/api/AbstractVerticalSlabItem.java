package net.luis.cave.api.world.block.api;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;

public class AbstractVerticalSlabItem extends BlockItem {
	
	private Block block;

	public AbstractVerticalSlabItem(Block blockIn, Properties builder) {
		
		super(blockIn, builder);
		this.block = blockIn;
		
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		
		BlockPos pos = context.getPos().offset(context.getFace());
		PlayerEntity player = context.getPlayer();
		
		if (context.getWorld().getBlockState(pos).getBlock() == block 
				&& !context.getWorld().getBlockState(pos).get(AbstractVerticalSlab.FULL)) {
			
			context.getWorld().setBlockState(pos, context.getWorld().getBlockState(pos).with(AbstractVerticalSlab.FULL, true));
			
			if (!player.isCreative()) {
				
				player.getHeldItem(context.getHand()).setCount(player.getHeldItem(context.getHand()).getCount() - 1);
				
			}
			
			return ActionResultType.SUCCESS;
			
		}
		
		return super.onItemUse(context);
		
	}
	
}
