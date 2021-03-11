package net.luis.cave.init.capability;

import java.util.concurrent.Callable;

import net.luis.cave.api.capability.IEnderChestItemHandler;
import net.luis.cave.api.capability.EnderChestItemStackHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import net.minecraftforge.items.wrapper.InvWrapper;

public class EnderChestCapability {
	
	@CapabilityInject(IEnderChestItemHandler.class)
	public static Capability<IEnderChestItemHandler> ENDERCHEST = null;
	
	public static class EnderChestStorage implements IStorage<IEnderChestItemHandler> {
		@Override
		public INBT writeNBT(Capability<IEnderChestItemHandler> capability, IEnderChestItemHandler instance, Direction side) {
			return null;
		}
		@Override
		public void readNBT(Capability<IEnderChestItemHandler> capability, IEnderChestItemHandler instance, Direction side, INBT nbt) {
		}
	}
	
	public static class EnderChestFactory implements Callable<IEnderChestItemHandler> {
		@Override
		public IEnderChestItemHandler call() throws Exception {
			return null;
		}
	}
	
	public static class EnderChestProvider implements ICapabilitySerializable<CompoundNBT> {
		
		private EnderChestItemStackHandler inventory = new EnderChestItemStackHandler(27);
		private PlayerEntity player;
		private LazyOptional<CombinedInvWrapper> optional = LazyOptional.of(() -> {
			
			EnderChestInventory enderChestInventory = player.getInventoryEnderChest();
			InvWrapper invWrapper = new InvWrapper(enderChestInventory);
			CombinedInvWrapper combinedInvWrapper = new CombinedInvWrapper(invWrapper, inventory);
			
			return combinedInvWrapper;
			
		});
		
		public EnderChestProvider(PlayerEntity playerIn) {
			
			this.player = playerIn;
			
		}
		
		@Override
		@SuppressWarnings({ "unchecked" })
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			
			return cap == ENDERCHEST && cap != null ? (LazyOptional<T>) optional : LazyOptional.empty();
			
		}

		@Override
		public CompoundNBT serializeNBT() {
			
			return inventory.serializeNBT();
			
		}

		@Override
		public void deserializeNBT(CompoundNBT nbt) {
			
			inventory.deserializeNBT(nbt);
			
		}
		
	}
	
}
