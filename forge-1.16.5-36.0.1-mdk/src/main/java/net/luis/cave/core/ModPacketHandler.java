package net.luis.cave.core;

import java.util.Optional;

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
	
		simpleChannel.registerMessage(id++, BackpackOpenMessage.class, BackpackOpenMessage::encode,
				BackpackOpenMessage::decode, BackpackOpenMessage::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
		simpleChannel.registerMessage(id++, BackpackNextToolMessage.class, BackpackNextToolMessage::encode,
				BackpackNextToolMessage::decode, BackpackNextToolMessage::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
		simpleChannel.registerMessage(id++, BackpackTopToolMessage.class, BackpackTopToolMessage::encode,
				BackpackTopToolMessage::decode, BackpackTopToolMessage::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
		simpleChannel.registerMessage(id++, BackpackDownToolMessage.class, BackpackDownToolMessage::encode,
				BackpackDownToolMessage::decode, BackpackDownToolMessage::handle, Optional.of(NetworkDirection.PLAY_TO_SERVER));
		
	}
	
}
