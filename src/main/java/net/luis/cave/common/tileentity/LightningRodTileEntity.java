package net.luis.cave.common.tileentity;

import java.util.Random;

import net.luis.cave.init.util.ModTileEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class LightningRodTileEntity extends TileEntity implements ITickableTileEntity {
	
	public LightningRodTileEntity() {
		
		super(ModTileEntityType.LIGHTNING_ROD.get());
		
	}
	
	

	@Override
	@SuppressWarnings("resource")
	public void tick() {
		
		if (world != null) {
			
			Random rng = this.getWorld().rand;
			
			LightningBoltEntity lightning = new LightningBoltEntity(EntityType.LIGHTNING_BOLT, this.getWorld());
			lightning.setLocationAndAngles(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), rng.nextFloat() * 360, 0);
			
			if (this.getWorld().isThundering()) {
				
				if (this.getWorld().getGameTime() % (200 - rng.nextInt(100)) == 0) {
					
					this.getWorld().addEntity(lightning);
					
				}
				
			}
			
		}
		
	}

}
