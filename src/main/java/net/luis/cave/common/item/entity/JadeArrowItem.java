package net.luis.cave.common.item.entity;

import javax.annotation.Nullable;

import net.luis.cave.common.entities.JadeArrow;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class JadeArrowItem extends ArrowItem {

	public JadeArrowItem(Properties builder) {
		
		super(builder);
		
	}
	
	@Override
	public AbstractArrowEntity createArrow(World worldIn, @Nullable ItemStack stack, LivingEntity shooter) {
		
		JadeArrow jadeArrow = new JadeArrow(shooter, worldIn);
		return jadeArrow;
		
	}

}
