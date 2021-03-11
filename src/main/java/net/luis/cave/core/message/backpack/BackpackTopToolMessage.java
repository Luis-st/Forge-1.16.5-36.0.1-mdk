package net.luis.cave.core.message.backpack;

import java.util.function.Supplier;

import net.luis.cave.init.capability.BackpackCapability;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraftforge.fml.network.NetworkEvent.Context;
import net.minecraftforge.items.IItemHandlerModifiable;

public class BackpackTopToolMessage {
	
	public static void encode(BackpackTopToolMessage message, PacketBuffer buffer) {
		
	}

	
	public static BackpackTopToolMessage decode(PacketBuffer buffer) {
		
		return new BackpackTopToolMessage();
		
	}

	
	public static void handle(BackpackTopToolMessage message, Supplier<Context> networkContext) {
		
		ServerPlayerEntity player = networkContext.get().getSender();
		networkContext.get().enqueueWork(() -> {
			
			IItemHandlerModifiable itemModifiable = player.getCapability(BackpackCapability.BACKPACK, null)
					.orElseThrow(() -> new NullPointerException("The mod Capability<IBackpackItemHandler> is null"));
			ItemStack main = player.getHeldItemMainhand().copy();
			ItemStack top = itemModifiable.getStackInSlot(36).copy();
			
			if (main.getItem() instanceof TieredItem) {
				
				player.setHeldItem(Hand.MAIN_HAND, top);
				itemModifiable.setStackInSlot(36, main);
				
			}
			
		});
		networkContext.get().setPacketHandled(true);
		
	}

}
