package net.luis.cave.common.entities;

import net.luis.cave.init.ModEntityType;
import net.luis.cave.init.items.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DiamondArrow extends AbstractArrowEntity {

	public DiamondArrow(EntityType<? extends AbstractArrowEntity> type, World worldIn) {

		super(type, worldIn);

	}
	
	public DiamondArrow(double x, double y, double z, World worldIn) {

		super(ModEntityType.DIAMOND_ARROW.get(), x, y, z, worldIn);

	}
	
	public DiamondArrow(LivingEntity shooter, World worldIn) {

		super(ModEntityType.DIAMOND_ARROW.get(), shooter, worldIn);

	}

	@Override
	protected ItemStack getArrowStack() {

		return new ItemStack(ModItems.DIAMOND_ARROW_ITEM.get());

	}

}