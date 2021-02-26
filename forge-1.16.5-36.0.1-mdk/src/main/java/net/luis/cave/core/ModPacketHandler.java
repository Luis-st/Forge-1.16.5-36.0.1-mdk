package net.luis.cave.core;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class ModPacketHandler {
	
	private static final String PROTOCOL_VERSION = "1";
	private static int nextId = 0;
	public static SimpleChannel INSTANCE;
	
	public static void init() {
		
		INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation("cave", "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
		register(SyncSlotPosition.class, new SyncSlotPosition());
		
	}
	
	private static <T> void register(final Class<T> clazz, final IMessage<T> message) {
		
		ModPacketHandler.INSTANCE.registerMessage(ModPacketHandler.nextId++, clazz, message::encode, message::decode, message::handle);
		
	}
	
}
