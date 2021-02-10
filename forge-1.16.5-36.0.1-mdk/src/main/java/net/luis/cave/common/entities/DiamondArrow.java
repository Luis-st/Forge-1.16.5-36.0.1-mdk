package net.luis.cave.common.entities;

import net.luis.cave.init.ModEntityType;
import net.luis.cave.init.items.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class DiamondArrow extends AbstractArrowEntity {
	
	protected LivingEntity shooter;

	public DiamondArrow(EntityType<? extends AbstractArrowEntity> type, World worldIn) {

		super(type, worldIn);

	}
	
	public DiamondArrow(double x, double y, double z, World worldIn) {

		super(ModEntityType.DIAMOND_ARROW.get(), x, y, z, worldIn);

	}
	
	public DiamondArrow(LivingEntity shooterIn, World worldIn) {

		super(ModEntityType.DIAMOND_ARROW.get(), shooterIn, worldIn);
		this.shooter = shooterIn;

	}

	@Override
	protected ItemStack getArrowStack() {

		return new ItemStack(ModItems.DIAMOND_ARROW_ITEM.get());

	}
	
	@Override
	public IPacket<?> createSpawnPacket() {
		
		return NetworkHooks.getEntitySpawningPacket(this);
		
	}
	
	@Override
	public void tick() {
		
		super.tick();
		
//		if (!this.inGround && !this.onGround) {
//			
//			this.setPositionAndRotationDirect(this.getPosX(), this.getPosY(), this.getPosZ(), prevRotationYaw, prevRotationPitch, 0, false);
//			
//			World world = this.world;
//			List<Entity> livingEntity = WorldManager.getEntitiesIn(this, 10);
//			
//			Cave.LOGGER.debug("Entities: " + livingEntity.size());
//			
//		}
		
	}
	
	protected void calcYaw(Entity entity, LivingEntity target) {
		
		double entityPosX = entity.getPosX();
		double entityPosZ = entity.getPosZ();
		
		double targetPosX = target.getPosX();
		double targetPosZ = target.getPosZ();
		
		double x0 = entityPosX - targetPosX;
		double z0 = entityPosZ - targetPosZ;
		
		double x1 = Math.pow(x0, 2);
		double z1 = Math.pow(z0, 2);
		
		double distance = Math.sqrt(x1 + z1);
		
		Math.toDegrees(Math.asin(distance / distance));
		
	}
	
}