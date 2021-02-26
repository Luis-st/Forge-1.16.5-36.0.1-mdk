package net.luis.cave.core;

import java.util.function.Supplier;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent.Context;

public class SyncSlotPosition implements IMessage<SyncSlotPosition> {

	@Override
	public void encode(SyncSlotPosition clazz, PacketBuffer buffer) {
		
		
		
	}

	@Override
	public SyncSlotPosition decode(PacketBuffer buffer) {
		
		return null;
		
	}

	@Override
	public void handle(SyncSlotPosition clazz, Supplier<Context> supplier) {
		
		
		
	}

}
