package net.luis.cave.common.tileentity;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import net.luis.cave.common.inventory.container.ModBeaconContainer;
import net.luis.cave.init.util.ModTileEntityType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.BlockTags;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.LockCode;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModBeaconTileEntity extends TileEntity implements INamedContainerProvider, ITickableTileEntity {
	
	public static final Effect[][] EFFECTS_LIST = new Effect[][] {{Effects.SPEED, Effects.HASTE},
			{Effects.RESISTANCE, Effects.JUMP_BOOST}, {Effects.STRENGTH}, {Effects.REGENERATION}};
	private static final Set<Effect> VALID_EFFECTS = Arrays.stream(EFFECTS_LIST).flatMap(Arrays::stream).collect(Collectors.toSet());
	private List<ModBeaconTileEntity.BeamSegment> beamSegments = Lists.newArrayList();
	private List<ModBeaconTileEntity.BeamSegment> beamColorSegments = Lists.newArrayList();
	private int levels;
	private int beaconSize = -1;
	@Nullable
	private Effect primaryEffect;
	@Nullable
	private Effect secondaryEffect;
	@Nullable
	private ITextComponent customName;
	private LockCode lockCode = LockCode.EMPTY_CODE;
	private final IIntArray beaconData = new IIntArray() {
		@Override
		public int get(int index) {
			switch (index) {
			case 0:
				return ModBeaconTileEntity.this.levels;
			case 1:
				return Effect.getId(ModBeaconTileEntity.this.primaryEffect);
			case 2:
				return Effect.getId(ModBeaconTileEntity.this.secondaryEffect);
			default:
				return 0;
			}
		}
		
		@Override
		public void set(int index, int value) {
			switch (index) {
			case 0:
				ModBeaconTileEntity.this.levels = value;
				break;
			case 1:
				if (!ModBeaconTileEntity.this.world.isRemote && !ModBeaconTileEntity.this.beamSegments.isEmpty()) {
					ModBeaconTileEntity.this.playSound(SoundEvents.BLOCK_BEACON_POWER_SELECT);
				}

				ModBeaconTileEntity.this.primaryEffect = ModBeaconTileEntity.isBeaconEffect(value);
				break;
			case 2:
				ModBeaconTileEntity.this.secondaryEffect = ModBeaconTileEntity.isBeaconEffect(value);
			}

		}
		
		@Override
		public int size() {
			return 3;
		}
	};

	public ModBeaconTileEntity() {
		
		super(ModTileEntityType.BEACON.get());
		
	}
	
	@Override
	public void tick() {
		
		int i = this.pos.getX();
		int j = this.pos.getY();
		int k = this.pos.getZ();
		BlockPos blockpos;
		
		if (this.beaconSize < j) {
			
			blockpos = this.pos;
			this.beamColorSegments = Lists.newArrayList();
			this.beaconSize = blockpos.getY() - 1;
			
		} else {
			
			blockpos = new BlockPos(i, this.beaconSize + 1, k);
			
		}

		ModBeaconTileEntity.BeamSegment beacontileentity$beamsegment = this.beamColorSegments.isEmpty() ? null 
				: this.beamColorSegments.get(this.beamColorSegments.size() - 1);
		int l = this.world.getHeight(Heightmap.Type.WORLD_SURFACE, i, k);

		for (int i1 = 0; i1 < 10 && blockpos.getY() <= l; ++i1) {
			
			BlockState blockstate = this.world.getBlockState(blockpos);
			Block block = blockstate.getBlock();
			float[] afloat = blockstate.getBeaconColorMultiplier(this.world, blockpos, getPos());
			
			if (afloat != null) {
				
				if (this.beamColorSegments.size() <= 1) {
					
					beacontileentity$beamsegment = new ModBeaconTileEntity.BeamSegment(afloat);
					this.beamColorSegments.add(beacontileentity$beamsegment);
					
				} else if (beacontileentity$beamsegment != null) {
					
					if (Arrays.equals(afloat, beacontileentity$beamsegment.colors)) {
						
						beacontileentity$beamsegment.incrementHeight();
						
					} else {
						
						beacontileentity$beamsegment = new ModBeaconTileEntity.BeamSegment(
								new float[] { (beacontileentity$beamsegment.colors[0] + afloat[0]) / 2.0F,
										(beacontileentity$beamsegment.colors[1] + afloat[1]) / 2.0F,
										(beacontileentity$beamsegment.colors[2] + afloat[2]) / 2.0F });
						this.beamColorSegments.add(beacontileentity$beamsegment);
						
					}
					
				}
				
			} else {
				
				if (beacontileentity$beamsegment == null || blockstate.getOpacity(this.world, blockpos) >= 15 && block != Blocks.BEDROCK) {
					
					this.beamColorSegments.clear();
					this.beaconSize = l;
					break;
					
				}

				beacontileentity$beamsegment.incrementHeight();
				
			}

			blockpos = blockpos.up();
			++this.beaconSize;
			
		}

		int j1 = this.levels;
		
		if (this.world.getGameTime() % 80L == 0L) {
			
			if (!this.beamSegments.isEmpty()) {
				
				this.checkBeaconLevel(i, j, k);
				
			}

			if (this.levels > 0 && !this.beamSegments.isEmpty()) {
				
				this.addEffectsToPlayers();
				this.playSound(SoundEvents.BLOCK_BEACON_AMBIENT);
				
			}
			
		}

		if (this.beaconSize >= l) {
			
			this.beaconSize = -1;
			boolean flag = j1 > 0;
			this.beamSegments = this.beamColorSegments;
			
			if (!this.world.isRemote) {
				
				boolean flag1 = this.levels > 0;
				
				if (!flag && flag1) {
					
					this.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE);
					
				} else if (flag && !flag1) {
					
					this.playSound(SoundEvents.BLOCK_BEACON_DEACTIVATE);
					
				}
				
			}
			
		}

	}

	private void checkBeaconLevel(int beaconXIn, int beaconYIn, int beaconZIn) {
		
		this.levels = 0;

		for (int i = 1; i <= 4; this.levels = i++) {
			
			int j = beaconYIn - i;
			
			if (j < 0) {
				
				break;
				
			}

			boolean flag = true;

			for (int k = beaconXIn - i; k <= beaconXIn + i && flag; ++k) {
				
				for (int l = beaconZIn - i; l <= beaconZIn + i; ++l) {
					
					if (!this.world.getBlockState(new BlockPos(k, j, l)).isIn(BlockTags.BEACON_BASE_BLOCKS)) {
						
						flag = false;
						break;
						
					}
					
				}
				
			}

			if (!flag) {
				
				break;
				
			}
			
		}

	}

	@Override
	public void remove() {
		
		this.playSound(SoundEvents.BLOCK_BEACON_DEACTIVATE);
		super.remove();
		
	}
	
	private void addEffectsToPlayers() {
		
		if (!this.world.isRemote && this.primaryEffect != null) {
			
			double d0 = (double) (this.levels * (10 * this.levels) + 10);
			int i = 0;
			
			if (this.levels >= 4 && this.primaryEffect == this.secondaryEffect) {
				
				i = 1;
				
			}

			int j = (9 + this.levels * 2) * 20;
			
			AxisAlignedBB axisalignedbb = (new AxisAlignedBB(this.pos)).grow(d0).expand(0.0D, this.world.getHeight(), 0.0D);
			List<PlayerEntity> list = this.world.getEntitiesWithinAABB(PlayerEntity.class, axisalignedbb);

			for (PlayerEntity playerentity : list) {
				
				playerentity.addPotionEffect(new EffectInstance(this.primaryEffect, j, i, true, true));
				
			}

			if (this.levels >= 4 && this.primaryEffect != this.secondaryEffect && this.secondaryEffect != null) {
				
				for (PlayerEntity playerentity1 : list) {
					
					playerentity1.addPotionEffect(new EffectInstance(this.secondaryEffect, j, 0, true, true));
					
				}
				
			}

		}
		
	}
	
	public void playSound(SoundEvent sound) {
		
		this.world.playSound((PlayerEntity) null, this.pos, sound, SoundCategory.BLOCKS, 1.0F, 1.0F);
		
	}

	@OnlyIn(Dist.CLIENT)
	public List<ModBeaconTileEntity.BeamSegment> getBeamSegments() {
		
		return this.levels == 0 ? ImmutableList.of() : this.beamSegments;
		
	}

	public int getLevels() {
		
		return this.levels;
		
	}
	
	@Override
	@Nullable
	public SUpdateTileEntityPacket getUpdatePacket() {
		
		return new SUpdateTileEntityPacket(this.pos, 3, this.getUpdateTag());
		
	}

	@Override
	public CompoundNBT getUpdateTag() {
		
		return this.write(new CompoundNBT());
		
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public double getMaxRenderDistanceSquared() {
		
		return 256.0D;
		
	}

	@Nullable
	private static Effect isBeaconEffect(int effectId) {
		
		Effect effect = Effect.get(effectId);
		return VALID_EFFECTS.contains(effect) ? effect : null;
		
	}
	
	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		
		super.read(state, nbt);
		this.primaryEffect = isBeaconEffect(nbt.getInt("Primary"));
		this.secondaryEffect = isBeaconEffect(nbt.getInt("Secondary"));
		
		if (nbt.contains("CustomName", 8)) {
			
			this.customName = ITextComponent.Serializer.getComponentFromJson(nbt.getString("CustomName"));
			
		}

		this.lockCode = LockCode.read(nbt);
		
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
		
		super.write(compound);
		compound.putInt("Primary", Effect.getId(this.primaryEffect));
		compound.putInt("Secondary", Effect.getId(this.secondaryEffect));
		compound.putInt("Levels", this.levels);
		
		if (this.customName != null) {
			
			compound.putString("CustomName", ITextComponent.Serializer.toJson(this.customName));
			
		}

		this.lockCode.write(compound);
		return compound;
		
	}
	
	public void setCustomName(@Nullable ITextComponent aname) {
		
		this.customName = aname;
		
	}
	
	@Override
	@Nullable
	public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
		
		return LockableTileEntity.canUnlock(p_createMenu_3_, this.lockCode, this.getDisplayName())
				? new ModBeaconContainer(p_createMenu_1_, p_createMenu_2_, this.beaconData, IWorldPosCallable.of(this.world, this.getPos())) : null;
	}
	
	@Override
	public ITextComponent getDisplayName() {
		
		return this.customName != null ? this.customName : new TranslationTextComponent("container.beacon");
	}

	public static class BeamSegment {
		
		private final float[] colors;
		private int height;

		public BeamSegment(float[] colorsIn) {
			
			this.colors = colorsIn;
			this.height = 1;
			
		}

		protected void incrementHeight() {
			
			++this.height;
			
		}

		@OnlyIn(Dist.CLIENT)
		public float[] getColors() {
			
			return this.colors;
			
		}

		@OnlyIn(Dist.CLIENT)
		public int getHeight() {
			
			return this.height;
			
		}
		
	}
	
}
