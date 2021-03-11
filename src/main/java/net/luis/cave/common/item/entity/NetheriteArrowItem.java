package net.luis.cave.common.item.entity;

import javax.annotation.Nullable;

import net.luis.cave.common.entities.NetheriteArrow;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class NetheriteArrowItem extends ArrowItem {

	public NetheriteArrowItem(Properties builder) {
		
		super(builder);
		
	}
	
	@Override
	public AbstractArrowEntity createArrow(World worldIn, @Nullable ItemStack stack, LivingEntity shooter) {
		
		NetheriteArrow netheriteArrow = new NetheriteArrow(shooter, worldIn);
		return netheriteArrow;
		
	}

}
