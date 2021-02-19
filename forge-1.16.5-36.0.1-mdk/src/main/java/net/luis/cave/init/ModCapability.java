package net.luis.cave.init;

import java.util.concurrent.Callable;

import net.luis.cave.api.capability.IModItemHandler;
import net.luis.cave.api.capability.ModItemStackHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import net.minecraftforge.items.wrapper.InvWrapper;

public class ModCapability {
	
	@CapabilityInject(IModItemHandler.class)
	public static Capability<IModItemHandler> CAPABILITY = null;
	
	public ModCapability() {
		
		CapabilityManager.INSTANCE.register(IModItemHandler.class, new Storage(), new Factory());
		
	}
	
	private static class Storage implements IStorage<IModItemHandler> {
		@Override
		public INBT writeNBT(Capability<IModItemHandler> capability, IModItemHandler instance, Direction side) {
			return null;
		}
		@Override
		public void readNBT(Capability<IModItemHandler> capability, IModItemHandler instance, Direction side, INBT nbt) {
		}
	}
	
	private static class Factory implements Callable<IModItemHandler> {
		@Override
		public IModItemHandler call() throws Exception {
			return null;
		}
	}
	
	public static class Provider implements ICapabilitySerializable<CompoundNBT> {
		
		private ModItemStackHandler inventory = new ModItemStackHandler();
		private PlayerEntity player;
		private LazyOptional<CombinedInvWrapper> optional = LazyOptional.of(() -> new CombinedInvWrapper(new InvWrapper(player.getInventoryEnderChest()), inventory));
		
		public Provider(PlayerEntity playerIn) {
			
			this.player = playerIn;
			
		}
		
		@Override
		@SuppressWarnings({ "unchecked" })
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			
			return cap == CAPABILITY && cap != null ? (LazyOptional<T>) optional : LazyOptional.empty();
			
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
