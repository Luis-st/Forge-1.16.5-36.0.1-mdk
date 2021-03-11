package net.luis.cave.common.entities;

import net.luis.cave.init.ModEntityType;
import net.luis.cave.init.items.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

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

		return new ItemStack(ModItems.NETHERITE_ARROW_ITEM.get());

	}
	
	@Override
	public IPacket<?> createSpawnPacket() {
		
		return NetworkHooks.getEntitySpawningPacket(this);
		
	}

}