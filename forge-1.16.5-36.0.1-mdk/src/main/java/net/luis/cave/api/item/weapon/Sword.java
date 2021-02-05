package net.luis.cave.api.item.weapon;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Sword extends SwordItem {

	public Sword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
		
		super(tier, attackDamageIn, attackSpeedIn, builderIn);
		
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
		
		if (state.getBlockHardness(worldIn, pos) != 0.0F) {
			
			stack.damageItem(1, entityLiving, (entity) -> {
				
				entity.sendBreakAnimation(EquipmentSlotType.MAINHAND);
				
			});
			
		}

		return true;
		
	}

}
