package net.luis.cave.common.entities;

import net.luis.cave.init.ModEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class NetheriteArrow extends AbstractArrowEntity {

	public NetheriteArrow(EntityType<? extends AbstractArrowEntity> type, World worldIn) {

		super(type, worldIn);

	}
	
	public NetheriteArrow(double x, double y, double z, World worldIn) {

		super(ModEntityType.NETHERITE_ARROW.get(), x, y, z, worldIn);

	}
	
	public NetheriteArrow(LivingEntity shooter, World worldIn) {

		super(ModEntityType.NETHERITE_ARROW.get(), shooter, worldIn);

	}

	@Override
	protected ItemStack getArrowStack() {

		return null;

	}

}