package net.luis.cave.init;

import java.util.concurrent.Callable;

import net.luis.cave.api.capability.IModItemHandler;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

public class ModCapability {
	
	@CapabilityInject(IModItemHandler.class)
	public static Capability<IModItemHandler> CAPABILITY = null;
	
	public ModCapability() {
		
		CapabilityManager.INSTANCE.register(IModItemHandler.class, new Storage(), new Factory());
		
	}
	
	public static class Storage implements IStorage<IModItemHandler> {

		@Override
		public INBT writeNBT(Capability<IModItemHandler> capability, IModItemHandler instance, Direction side) {
			
			CompoundNBT nbt = new CompoundNBT();
			return nbt;
			
		}

		@Override
		public void readNBT(Capability<IModItemHandler> capability, IModItemHandler instance, Direction side, INBT nbt) {
			
			
			
		}
		
	}
	
	public static class Factory implements Callable<IModItemHandler> {

		@Override
		public IModItemHandler call() throws Exception {
			
			return null;
			
		}
		
	}
	
	public static class Provider implements ICapabilityProvider {

		private final LazyOptional<IModItemHandler> lazyOptional = LazyOptional.of(CAPABILITY::getDefaultInstance);
		
		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			
			return cap == CAPABILITY ? lazyOptional.cast() : LazyOptional.empty();
			
		}
		
	}
	
}
