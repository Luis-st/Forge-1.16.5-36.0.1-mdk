package net.luis.cave.core;

import java.util.function.Supplier;

import net.luis.cave.common.inventory.container.BackpackContainer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.network.NetworkEvent.Context;
import net.minecraftforge.fml.network.NetworkHooks;

public class BackpackMessage implements IMessage<BackpackMessage> {
	
	private static final ITextComponent CONTAINER_NAME = new TranslationTextComponent("container.backpack");
	
	@Override
	public void decode(BackpackMessage message, PacketBuffer buffer) {
		
		
		
	}

	@Override
	public BackpackMessage encode(PacketBuffer buffer) {
		
		return new BackpackMessage();
		
	}

	@Override
	public void handle(BackpackMessage message, Supplier<Context> networkContext) {
		
		ServerPlayerEntity playerEntity = networkContext.get().getSender();
		networkContext.get().enqueueWork(() -> {
			NetworkHooks.openGui(playerEntity, new SimpleNamedContainerProvider((id, inventory, playerIn) -> {
							return new BackpackContainer(id, inventory);
						}, CONTAINER_NAME));
		});
		networkContext.get().setPacketHandled(true);
		
	}

}
