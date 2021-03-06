package net.luis.cave.core;

import java.util.Optional;

import net.luis.cave.core.message.IMessage;
import net.luis.cave.core.message.backpack.BackpackDownToolMessage;
import net.luis.cave.core.message.backpack.BackpackNextToolMessage;
import net.luis.cave.core.message.backpack.BackpackOpenMessage;
import net.luis.cave.core.message.backpack.BackpackTopToolMessage;
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
		register(BackpackOpenMessage.class, new BackpackOpenMessage(), NetworkDirection.PLAY_TO_SERVER);
		register(BackpackNextToolMessage.class, new BackpackNextToolMessage(), NetworkDirection.PLAY_TO_SERVER);
		register(BackpackTopToolMessage.class, new BackpackTopToolMessage(), NetworkDirection.PLAY_TO_SERVER);
		register(BackpackDownToolMessage.class, new BackpackDownToolMessage(), NetworkDirection.PLAY_TO_SERVER);
		
	}
	
	private static <T> void register(Class<T> clazz, IMessage<T> message, NetworkDirection networkDirection) {
		
		simpleChannel.registerMessage(id++, clazz, message::decode, message::encode, message::handle, Optional.of(networkDirection));
		
	}
	
}
