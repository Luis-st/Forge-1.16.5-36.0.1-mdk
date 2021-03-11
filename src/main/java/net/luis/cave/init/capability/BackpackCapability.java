package net.luis.cave.init.capability;

import java.util.concurrent.Callable;

import net.luis.cave.api.capability.BackpackItemStackHandler;
import net.luis.cave.api.capability.IBackpackItemHandler;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;

public class BackpackCapability {
	
	@CapabilityInject(IBackpackItemHandler.class)
	public static Capability<IBackpackItemHandler> BACKPACK = null;
	
	public static class BagpackStorage implements IStorage<IBackpackItemHandler> {
		@Override
		public INBT writeNBT(Capability<IBackpackItemHandler> capability, IBackpackItemHandler instance, Direction side) {
			return null;
		}
		@Override
		public void readNBT(Capability<IBackpackItemHandler> capability, IBackpackItemHandler instance, Direction side, INBT nbt) {
		}
	}
	
	public static class BagpackFactory implements Callable<IBackpackItemHandler> {
		@Override
		public IBackpackItemHandler call() throws Exception {
			return null;
		}
	}
	
	public static class BagpackProvider implements ICapabilitySerializable<CompoundNBT> {
		
		private BackpackItemStackHandler inventory = new BackpackItemStackHandler(38);
		private LazyOptional<IItemHandlerModifiable> optional = LazyOptional.of(() -> inventory);
		
		public BagpackProvider() {
			
		}
		
		@Override
		@SuppressWarnings({ "unchecked" })
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			
			return cap == BACKPACK && cap != null ? (LazyOptional<T>) optional : LazyOptional.empty();
			
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
