package net.luis.cave.events.entity.player.tick;

import net.luis.cave.Cave;
import net.luis.cave.common.inventory.container.BackpackContainer;
import net.luis.cave.init.util.ModKeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.NetworkHooks;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnBackpack {
	
	private static final ITextComponent CONTAINER_NAME = new TranslationTextComponent("container.backpack");
	
	@SubscribeEvent
	public static void PlayerTick(TickEvent.PlayerTickEvent event) {

		PlayerEntity player = event.player;
		BlockPos pos = player.getPosition();
		
		if (event.phase == TickEvent.Phase.START) {
			
			if (ModKeyBinding.BACKPACK_OPEN.isKeyDown()) {
				
				if (player instanceof ServerPlayerEntity) {
					
					ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
					
					if (!serverPlayer.isSneaking()) {
						
						NetworkHooks.openGui(serverPlayer, new SimpleNamedContainerProvider((id, inventory, playerIn) -> {
							return new BackpackContainer(id, inventory);
						}, CONTAINER_NAME), pos);
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
