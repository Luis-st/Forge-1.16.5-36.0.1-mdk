package net.luis.cave.core;

import java.util.Optional;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class ModPacketHandler {

	private static final String version = "1";
	private static int id = 0;
	public static SimpleChannel simpleChannel;
	
	public static void init() {
		
		simpleChannel = NetworkRegistry.newSimpleChannel(new ResourceLocation("cave:simple_chnanel"), () -> version,  version::equals, version::equals);
		register(BackpackMessage.class, new BackpackMessage(), NetworkDirection.PLAY_TO_SERVER);
		
	}
	
	public static <T> void register(Class<T> clazz, IMessage<T> message, NetworkDirection networkDirection) {
		
		simpleChannel.registerMessage(id++, clazz, message::decode, message::encode, message::handle, Optional.of(networkDirection));
		
	}
	
}
