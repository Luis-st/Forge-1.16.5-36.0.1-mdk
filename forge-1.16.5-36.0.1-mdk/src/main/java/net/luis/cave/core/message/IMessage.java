package net.luis.cave.core.message;

import java.util.function.Supplier;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public interface IMessage<T> {
	
	void decode(T message, PacketBuffer buffer);
	
	T encode(PacketBuffer buffer);
	
	void handle(T message, Supplier<NetworkEvent.Context> networkContext);
	
}
