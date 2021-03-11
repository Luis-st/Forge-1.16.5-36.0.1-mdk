package net.luis.cave.common.tileentity;

import java.util.Random;

import javax.annotation.Nullable;

import net.luis.cave.init.util.ModTileEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.INameable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ModEnchantingTableTileEntity extends TileEntity implements INameable, ITickableTileEntity {

	public int ticks;
	public float field_195523_f;
	public float field_195524_g;
	public float rawSpeedIncrement;
	public float clampedSpeedIncrement;
	public float nextPageTurningSpeed;
	public float pageTurningSpeed;
	public float nextPageAngle;
	public float pageAngle;
	public float playerTableAngle;
	private static final Random random = new Random();
	private ITextComponent customname;

	public ModEnchantingTableTileEntity() {
		
		super(ModTileEntityType.ENCHANTING_TABLE.get());
		
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
		
		super.write(compound);
		
		if (this.hasCustomName()) {
			
			compound.putString("CustomName", ITextComponent.Serializer.toJson(this.customname));
			
		}

		return compound;
		
	}

	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		
		super.read(state, nbt);
		
		if (nbt.contains("CustomName", 8)) {
			
			this.customname = ITextComponent.Serializer.getComponentFromJson(nbt.getString("CustomName"));
			
		}

	}

	@Override
	public void tick() {
		
		this.pageTurningSpeed = this.nextPageTurningSpeed;
		this.pageAngle = this.nextPageAngle;
		
		PlayerEntity playerentity = this.world.getClosestPlayer(this.pos.getX() + 0.5D,
				this.pos.getY() + 0.5D, this.pos.getZ() + 0.5D, 3.0D, false);
		
		if (playerentity != null) {
			
			double d0 = playerentity.getPosX() - (this.pos.getX() + 0.5D);
			double d1 = playerentity.getPosZ() - (this.pos.getZ() + 0.5D);
			
			this.playerTableAngle = (float) MathHelper.atan2(d1, d0);
			this.nextPageTurningSpeed += 0.1F;
			
			if (this.nextPageTurningSpeed < 0.5F || random.nextInt(40) == 0) {
				
				float f1 = this.rawSpeedIncrement;

				do {
					
					this.rawSpeedIncrement += (random.nextInt(4) - random.nextInt(4));
					
				} while (f1 == this.rawSpeedIncrement);
				
			}
			
		} else {
			
			this.playerTableAngle += 0.02F;
			this.nextPageTurningSpeed -= 0.1F;
			
		}

		while (this.nextPageAngle >= Math.PI) {
			
			this.nextPageAngle -= Math.PI * 2F;
			
		}

		while (this.nextPageAngle < -Math.PI) {
			
			this.nextPageAngle += Math.PI * 2F;
			
		}

		while (this.playerTableAngle >= Math.PI) {
			
			this.playerTableAngle -= Math.PI * 2F;
			
		}

		while (this.playerTableAngle < -Math.PI) {
			
			this.playerTableAngle += Math.PI * 2F;
			
		}

		float f2;
		
		for (f2 = this.playerTableAngle - this.nextPageAngle; f2 >= Math.PI; f2 -= Math.PI * 2F) {
			
		}

		while (f2 < -Math.PI) {
			
			f2 += Math.PI * 2F;
			
		}

		this.nextPageAngle += f2 * 0.4F;
		this.nextPageTurningSpeed = MathHelper.clamp(this.nextPageTurningSpeed, 0.0F, 1.0F);
		++this.ticks;
		this.field_195524_g = this.field_195523_f;
		float f = (this.rawSpeedIncrement - this.field_195523_f) * 0.4F;
		f = MathHelper.clamp(f, -0.2F, 0.2F);
		this.clampedSpeedIncrement += (f - this.clampedSpeedIncrement) * 0.9F;
		this.field_195523_f += this.clampedSpeedIncrement;
		
	}

	@Override
	public ITextComponent getName() {
		
		return (ITextComponent) (this.customname != null ? this.customname : new TranslationTextComponent("container.enchant"));
		
	}

	public void setCustomName(@Nullable ITextComponent name) {
		
		this.customname = name;
		
	}

	@Nullable
	@Override
	public ITextComponent getCustomName() {
		
		return this.customname;
		
	}
}
