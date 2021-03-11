package net.luis.cave.core.message.backpack;

import java.util.function.Supplier;

import net.luis.cave.common.inventory.container.BackpackContainer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.network.NetworkEvent.Context;
import net.minecraftforge.fml.network.NetworkHooks;

public class BackpackOpenMessage {
	
	private static final ITextComponent CONTAINER_NAME = new TranslationTextComponent("container.backpack");
	
	
	public static void encode(BackpackOpenMessage message, PacketBuffer buffer) {
		
	}

	
	public static BackpackOpenMessage decode(PacketBuffer buffer) {
		
		return new BackpackOpenMessage();
		
	}

	
	public static void handle(BackpackOpenMessage message, Supplier<Context> networkContext) {
		
		ServerPlayerEntity player = networkContext.get().getSender();
		networkContext.get().enqueueWork(() -> {
			
			NetworkHooks.openGui(player, new SimpleNamedContainerProvider((id, inventory, playerIn) -> {
							return new BackpackContainer(id, inventory);
						}, CONTAINER_NAME));
			
		});
		networkContext.get().setPacketHandled(true);
		
	}

}
