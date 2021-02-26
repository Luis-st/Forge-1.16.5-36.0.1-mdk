package net.luis.cave.core;

import java.util.function.Supplier;

import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public interface IMessage<T> {
	
	void encode(final T clazz, final PacketBuffer buffer);

	T decode(final PacketBuffer buffer);

	void handle(final T clazz, final Supplier<NetworkEvent.Context> supplier);
	
}
