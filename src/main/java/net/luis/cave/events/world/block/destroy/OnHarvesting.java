package net.luis.cave.events.world.block.destroy;

import net.luis.cave.Cave;
import net.luis.cave.api.world.block.BlockManager;
import net.luis.cave.init.ModEnchantment;
import net.luis.cave.init.util.ModGameRule;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnHarvesting {
	
	@SubscribeEvent
	@SuppressWarnings("deprecation")
	public static void Harvesting(BlockEvent.BreakEvent event) {
		
		BlockPos pos = event.getPos();
		World world = (World) event.getWorld();
		PlayerEntity player = event.getPlayer();
		BlockState state = event.getState();
		int enchHarvesting = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.HARVESTING.get(), player.getHeldItemMainhand());
		int enchTelekinesis = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.TELEKINESIS.get(), player.getHeldItemMainhand());
		int destroyCount = enchHarvesting != 0 ? ((enchHarvesting) * 5) - 1 : 0;
		
		if (player instanceof PlayerEntity) {
			
			if (world.getGameRules().getBoolean(ModGameRule.ENABLE_INFINITE_HARVESTING.getRule())) {
				
				if (enchHarvesting >= 5) {
					
					destroyCount = 255;
					
				}
				
			}
			
			if (!player.abilities.isCreativeMode) {
				
				if (enchHarvesting > 0 && enchTelekinesis == 0) {
					
					if (BlockManager.isBrokenWood(state)) {
						
						int y = pos.getY() + 1;
						
						for (int i = 0; i < destroyCount; i++) {
							
							if (BlockManager.isBlockUpWood(world, pos.getX(), y, pos.getZ())) {
								
								world.destroyBlock(new BlockPos(pos.getX(), y, pos.getZ()), true);
								
								if (Math.random() >= 0.66) {
									
									player.getHeldItemMainhand().damageItem(1, player, e -> e.sendBreakAnimation(EquipmentSlotType.MAINHAND));
									
								}
								
							} else {
								
								break;
								
							}
							
							y++;
							
						}
						
					}
					
				} else if (enchHarvesting > 0 && enchTelekinesis > 0) {
					
					if (BlockManager.isBrokenWood(state)) {
						
						int y = pos.getY() + 1;
						
						for (int i = 0; i < destroyCount; i++) {
							
							if (BlockManager.isBlockUpWood(world, pos.getX(), y, pos.getZ())) {
								
								world.destroyBlock(new BlockPos(pos.getX(), y, pos.getZ()), false);
								
								ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(Item.getItemFromBlock(state.getBlock())));
								
								if (Math.random() >= 0.5) {
									
									player.getHeldItemMainhand().damageItem(1, player, e -> e.sendBreakAnimation(EquipmentSlotType.MAINHAND));
									
								}
								
							} else {
								
								break;
								
							}
							
							y++;
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
