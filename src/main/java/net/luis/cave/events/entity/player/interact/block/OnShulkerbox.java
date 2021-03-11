package net.luis.cave.events.entity.player.interact.block;

import net.luis.cave.Cave;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.NameTagItem;
import net.minecraft.tileentity.ShulkerBoxTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnShulkerbox {
	
	@SubscribeEvent
	public static void PlayerInteract(PlayerInteractEvent.RightClickBlock event) {
		
		PlayerEntity player = event.getPlayer();
		BlockPos pos = event.getPos();
		World world = event.getWorld();
		BlockState state = world.getBlockState(pos);
		
		if (state.getBlock() instanceof ShulkerBoxBlock) {
			
			TileEntity tileEntity = world.getTileEntity(pos);
			
			if (tileEntity instanceof ShulkerBoxTileEntity) {
				
				INamedContainerProvider containerProvider = (INamedContainerProvider) tileEntity;
				String textComponent = containerProvider.getDisplayName().getString();
				
				if (textComponent.contains("-")) {
					
					String[] containerName = textComponent.split("-");
					ItemStack item = player.getHeldItemMainhand();
					
					if (containerName.length == 2) {
						
						if (item.getItem() instanceof NameTagItem) {
							
							if (containerName[0].equals(item.getDisplayName().getString())) {
								
								if (containerName[1].equals(player.getDisplayName().getString())) {
									
								} else {
									
									event.setCanceled(true);
									
								}
								
							} else {
								
								event.setCanceled(true);
								
							}
							
						} else {
							
							event.setCanceled(true);
							
						}
						
					}
					
				}
				
			}
			
		}

	}

}
