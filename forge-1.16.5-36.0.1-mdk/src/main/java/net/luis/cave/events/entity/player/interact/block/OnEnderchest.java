package net.luis.cave.events.entity.player.interact.block;

import net.luis.cave.Cave;
import net.luis.cave.common.inventory.container.ModEnderChestContainer;
import net.luis.cave.init.capability.EnderChestCapability;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.IItemHandlerModifiable;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEnderchest {
	
	private static final ITextComponent CONTAINER_NAME = new TranslationTextComponent("container.enderchest");
	
	@SubscribeEvent
	public static void PlayerInteract(PlayerInteractEvent.RightClickBlock event) {
		
		PlayerEntity player = event.getPlayer();
		BlockPos pos = event.getPos();
		World world = event.getWorld();
		BlockState state = world.getBlockState(pos);
		
		if (state.getBlock() == Blocks.ENDER_CHEST) {

			if (player instanceof ServerPlayerEntity) {
				
				if (!player.isSneaking()) {
					
					event.setUseBlock(Result.DENY);
					if (!player.getHeldItemMainhand().isEmpty()) {
						
						event.setUseItem(Result.DENY);
						
					}
					
					ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
					IItemHandlerModifiable itemHandlerModifiable = serverPlayer.getCapability(EnderChestCapability.ENDERCHEST, null)
							.orElseThrow(() -> new NullPointerException("The mod Capability<IModItemHandler> is null"));
					
					if (itemHandlerModifiable != null) {
						
						NetworkHooks.openGui(serverPlayer, new SimpleNamedContainerProvider((id, inventory, playerIn) -> {
							return new ModEnderChestContainer(id, inventory, itemHandlerModifiable);
						}, CONTAINER_NAME), pos);
						
						double d0 = (double) pos.getX() + 0.5D;
						double d1 = (double) pos.getZ() + 0.5D;
						
						world.playSound(null, d0, pos.getY() + 0.5D, d1,
								SoundEvents.BLOCK_ENDER_CHEST_OPEN, SoundCategory.BLOCKS, 0.5F, 
								world.rand.nextFloat() * 0.1F + 0.9F);
						
					}
					
				} else {
					
					event.setCanceled(true);
					
				}
				
			}
			
		}

	}

}
