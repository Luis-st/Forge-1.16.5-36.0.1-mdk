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

public class BackpackNextToolMessage {

	
	public static void encode(BackpackNextToolMessage message, PacketBuffer buffer) {
		
	}

	
	public static BackpackNextToolMessage decode(PacketBuffer buffer) {
		
		return new BackpackNextToolMessage();
		
	}

	
	public static void handle(BackpackNextToolMessage message, Supplier<Context> networkContext) {
		
		ServerPlayerEntity player = networkContext.get().getSender();
		networkContext.get().enqueueWork(() -> {
			
			IItemHandlerModifiable itemModifiable = player.getCapability(BackpackCapability.BACKPACK, null)
					.orElseThrow(() -> new NullPointerException("The mod Capability<IBackpackItemHandler> is null"));
			ItemStack main = player.getHeldItemMainhand().copy();
			ItemStack top = itemModifiable.getStackInSlot(36).copy();
			ItemStack down = itemModifiable.getStackInSlot(37).copy();
			
			if (main.getItem() instanceof TieredItem) {
				
				player.setHeldItem(Hand.MAIN_HAND, down);
				itemModifiable.setStackInSlot(36, main);
				itemModifiable.setStackInSlot(37, top);
				
			}
			
		});
		networkContext.get().setPacketHandled(true);
		
	}

}
