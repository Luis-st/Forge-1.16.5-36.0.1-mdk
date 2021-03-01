package net.luis.cave.common.inventory.container;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.luis.cave.api.event.ModEventFactory;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.stats.Stats;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.ForgeEventFactory;

public class ModEnchantingTableContainer extends Container {
	
	private final IInventory tableInventory = new Inventory(2) {
		
		@Override
		public void markDirty() {
			
			super.markDirty();
			ModEnchantingTableContainer.this.onCraftMatrixChanged(this);
			
		}
		
	};
	private final IWorldPosCallable worldPosCallable;
	private final Random rand = new Random();
	private final IntReferenceHolder xpSeed = IntReferenceHolder.single();
	private final PlayerEntity player;
	private final BlockPos pos;
	public final int[] enchantLevels = new int[3];
	public final int[] enchantClue = new int[] { -1, -1, -1 };
	public final int[] worldClue = new int[] { -1, -1, -1 };

	public ModEnchantingTableContainer(int id, PlayerInventory playerInventory, PacketBuffer extraData) {
		
		this(id, playerInventory, null, null);
		
	}

	public ModEnchantingTableContainer(int id, PlayerInventory playerInventory, @Nullable World world, @Nullable BlockPos pos) {
		
		super(ContainerType.ENCHANTMENT, id);
		this.worldPosCallable = world == null || pos == null ? IWorldPosCallable.DUMMY : IWorldPosCallable.of(world, pos);
		this.player = playerInventory.player;
		this.pos = pos;
		this.addSlot(new Slot(this.tableInventory, 0, 15, 47) {
			
			@Override
			public boolean isItemValid(ItemStack stack) {
				
				return true;
				
			}
			
			@Override
			public int getSlotStackLimit() {
				
				return 1;
				
			}
			
		});
		this.addSlot(new Slot(this.tableInventory, 1, 35, 47) {
			
			@Override
			public boolean isItemValid(ItemStack stack) {
				
				return net.minecraftforge.common.Tags.Items.GEMS_LAPIS.contains(stack.getItem());
				
			}
			
		});

		for (int i = 0; i < 3; ++i) {
			
			for (int j = 0; j < 9; ++j) {
				
				this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
				
			}
			
		}

		for (int k = 0; k < 9; ++k) {
			
			this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
			
		}

		this.trackInt(IntReferenceHolder.create(this.enchantLevels, 0));
		this.trackInt(IntReferenceHolder.create(this.enchantLevels, 1));
		this.trackInt(IntReferenceHolder.create(this.enchantLevels, 2));
		this.trackInt(this.xpSeed).set(playerInventory.player.getXPSeed());
		this.trackInt(IntReferenceHolder.create(this.enchantClue, 0));
		this.trackInt(IntReferenceHolder.create(this.enchantClue, 1));
		this.trackInt(IntReferenceHolder.create(this.enchantClue, 2));
		this.trackInt(IntReferenceHolder.create(this.worldClue, 0));
		this.trackInt(IntReferenceHolder.create(this.worldClue, 1));
		this.trackInt(IntReferenceHolder.create(this.worldClue, 2));
		
	}

	private float getPower(World world, BlockPos pos) {
		
		return world.getBlockState(pos).getEnchantPowerBonus(world, pos);
		
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public void onCraftMatrixChanged(IInventory inventoryIn) {
		
		if (inventoryIn == this.tableInventory) {
			
			ItemStack itemstack = inventoryIn.getStackInSlot(0);
			
			if (!itemstack.isEmpty() && itemstack.isEnchantable()) {
				
				this.worldPosCallable.consume((world, pos) -> {
					
					int power = 0;

					for (int k = -1; k <= 1; ++k) {
						
						for (int l = -1; l <= 1; ++l) {
							
							if ((k != 0 || l != 0) && world.isAirBlock(pos.add(l, 0, k)) && world.isAirBlock(pos.add(l, 1, k))) {
								
								power += getPower(world, pos.add(l * 2, 0, k * 2));
								power += getPower(world, pos.add(l * 2, 1, k * 2));

								if (l != 0 && k != 0) {
									
									power += getPower(world, pos.add(l * 2, 0, k));
									power += getPower(world, pos.add(l * 2, 1, k));
									power += getPower(world, pos.add(l, 0, k * 2));
									power += getPower(world, pos.add(l, 1, k * 2));
									
								}
								
							}
							
						}
						
					}

					this.rand.setSeed(this.xpSeed.get());

					for (int i1 = 0; i1 < 3; ++i1) {
						
						this.enchantLevels[i1] = EnchantmentHelper.calcItemStackEnchantability(this.rand, i1, power, itemstack);
						this.enchantClue[i1] = -1;
						this.worldClue[i1] = -1;
						if (this.enchantLevels[i1] < i1 + 1) {
							
							this.enchantLevels[i1] = 0;
							
						}
						
						this.enchantLevels[i1] = ForgeEventFactory.onEnchantmentLevelSet(world, pos, i1, power, itemstack, enchantLevels[i1]);
						
					}

					for (int j1 = 0; j1 < 3; ++j1) {
						
						if (this.enchantLevels[j1] > 0) {
							
							List<EnchantmentData> list = this.getEnchantmentList(player, itemstack, j1, this.enchantLevels[j1]);
							List<EnchantmentData> modifyList = ModEventFactory.onEnchantmentSet(player, pos, itemstack, list, this.enchantLevels[j1]);
							
							if (list != null && !list.isEmpty()) {
								
								EnchantmentData enchantmentdata = list.get(this.rand.nextInt(list.size()));
								
								this.enchantClue[j1] = Registry.ENCHANTMENT.getId(enchantmentdata.enchantment);
								this.worldClue[j1] = enchantmentdata.enchantmentLevel;
								
							}
							
						}
						
					}

					this.detectAndSendChanges();
					
				});
				
			} else {
				
				for (int i = 0; i < 3; ++i) {
					
					this.enchantLevels[i] = 0;
					this.enchantClue[i] = -1;
					this.worldClue[i] = -1;
					
				}
				
			}
			
		}

	}
	
	@Override
	public boolean enchantItem(PlayerEntity playerIn, int id) {
		
		ItemStack itemstack = this.tableInventory.getStackInSlot(0);
		ItemStack itemstack1 = this.tableInventory.getStackInSlot(1);
		int i = id + 1;
		
		if ((itemstack1.isEmpty() || itemstack1.getCount() < i) && !playerIn.abilities.isCreativeMode) {
			
			return false;
			
		} else if (this.enchantLevels[id] <= 0 || itemstack.isEmpty() || 
					(playerIn.experienceLevel < i || playerIn.experienceLevel < this.enchantLevels[id]) && 
					!playerIn.abilities.isCreativeMode) {
			
			return false;
			
		} else {
			
			this.worldPosCallable.consume((world, pos) -> {
				
				ItemStack itemstack2 = itemstack;
				List<EnchantmentData> list = this.getEnchantmentList(playerIn, itemstack, id, this.enchantLevels[id]);
				
				if (!list.isEmpty()) {
					
					playerIn.onEnchant(itemstack, i);
					boolean flag = itemstack.getItem() == Items.BOOK;
					
					if (flag) {
						
						itemstack2 = new ItemStack(Items.ENCHANTED_BOOK);
						CompoundNBT compoundnbt = itemstack.getTag();
						
						if (compoundnbt != null) {
							
							itemstack2.setTag(compoundnbt.copy());
							
						}

						this.tableInventory.setInventorySlotContents(0, itemstack2);
						
					}

					for (int j = 0; j < list.size(); ++j) {
						
						EnchantmentData enchantmentdata = list.get(j);
						
						if (flag) {
							
							EnchantedBookItem.addEnchantment(itemstack2, enchantmentdata);
							
						} else {
							
							itemstack2.addEnchantment(enchantmentdata.enchantment, enchantmentdata.enchantmentLevel);
							
						}
						
					}

					if (!playerIn.abilities.isCreativeMode) {
						
						itemstack1.shrink(i);
						
						if (itemstack1.isEmpty()) {
							
							this.tableInventory.setInventorySlotContents(1, ItemStack.EMPTY);
							
						}
						
					}

					playerIn.addStat(Stats.ENCHANT_ITEM);
					
					if (playerIn instanceof ServerPlayerEntity) {
						
						CriteriaTriggers.ENCHANTED_ITEM.trigger((ServerPlayerEntity) playerIn, itemstack2, i);
						
					}

					this.tableInventory.markDirty();
					this.xpSeed.set(playerIn.getXPSeed());
					this.onCraftMatrixChanged(this.tableInventory);
					world.playSound(null, pos, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1.0F, world.rand.nextFloat() * 0.1F + 0.9F);
					
				}
				

			});
			
			return true;
			
		}
		
	}

	private List<EnchantmentData> getEnchantmentList(PlayerEntity player, ItemStack stack, int enchantSlot, int level) {
		
		this.rand.setSeed(this.xpSeed.get() + enchantSlot);
		List<EnchantmentData> list = EnchantmentHelper.buildEnchantmentList(this.rand, stack, level, false);
		
		if (stack.getItem() == Items.BOOK && list.size() > 1) {
			
			list.remove(this.rand.nextInt(list.size()));
			
		}
		
		List<EnchantmentData> modifyList = ModEventFactory.onEnchantmentSet(player, pos, stack, list, level);
		return modifyList;
		
	}

	@OnlyIn(Dist.CLIENT)
	public int getLapisAmount() {
		
		ItemStack itemstack = this.tableInventory.getStackInSlot(1);
		return itemstack.isEmpty() ? 0 : itemstack.getCount();
		
	}

	@OnlyIn(Dist.CLIENT)
	public int getXPSeed() {
		
		return this.xpSeed.get();
		
	}
	
	@Override
	public void onContainerClosed(PlayerEntity playerIn) {
		
		super.onContainerClosed(playerIn);
		this.worldPosCallable.consume((world, pos) -> {
			
			this.clearContainer(playerIn, playerIn.world, this.tableInventory);
			
		});
		
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		
		return isWithinUsableDistance(this.worldPosCallable, playerIn, Blocks.ENCHANTING_TABLE);
		
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack()) {
			
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (index == 0) {
				
				if (!this.mergeItemStack(itemstack1, 2, 38, true)) {
					
					return ItemStack.EMPTY;
					
				}
				
			} else if (index == 1) {
				
				if (!this.mergeItemStack(itemstack1, 2, 38, true)) {
					
					return ItemStack.EMPTY;
					
				}
				
			} else if (itemstack1.getItem() == Items.LAPIS_LAZULI) {
				
				if (!this.mergeItemStack(itemstack1, 1, 2, true)) {
					
					return ItemStack.EMPTY;
					
				}
				
			} else {
				
				if (this.inventorySlots.get(0).getHasStack() || !this.inventorySlots.get(0).isItemValid(itemstack1)) {
					
					return ItemStack.EMPTY;
					
				}

				ItemStack itemstack2 = itemstack1.copy();
				itemstack2.setCount(1);
				itemstack1.shrink(1);
				this.inventorySlots.get(0).putStack(itemstack2);
				
			}

			if (itemstack1.isEmpty()) {
				
				slot.putStack(ItemStack.EMPTY);
				
			} else {
				
				slot.onSlotChanged();
				
			}

			if (itemstack1.getCount() == itemstack.getCount()) {
				
				return ItemStack.EMPTY;
				
			}

			slot.onTake(playerIn, itemstack1);
			
		}

		return itemstack;
		
	}
	
}
