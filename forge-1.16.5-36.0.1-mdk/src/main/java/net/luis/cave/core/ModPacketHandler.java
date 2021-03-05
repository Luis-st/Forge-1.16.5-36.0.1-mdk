package net.luis.cave.core;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class ModPacketHandler {

	private static final String protocolVersion = "1";
	public static final SimpleChannel simpleChannel = NetworkRegistry.newSimpleChannel(
	    new ResourceLocation("cave:simple_chnanel"), () -> protocolVersion,  protocolVersion::equals, protocolVersion::equals);
	
	public static void init() {
		
		
		
	}
	
}
