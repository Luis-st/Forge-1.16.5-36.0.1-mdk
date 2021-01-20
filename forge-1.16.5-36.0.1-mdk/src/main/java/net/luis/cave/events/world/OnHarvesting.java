package net.luis.cave.events.world;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveEnchantment;
import net.luis.cave.lib.BlockManager;
import net.luis.cave.lib.ItemManager;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnHarvesting {
	
	@SubscribeEvent
	public static void DropRuby(BlockEvent.BreakEvent event) {
		
		BlockPos pos = event.getPos();
		World world = (World) event.getWorld();
		PlayerEntity player = event.getPlayer();
		Block block = world.getBlockState(pos).getBlock();
		ItemStack item = player.getHeldItemMainhand();
		int enchHarvesting = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.HARVESTING.get(), player.getHeldItemMainhand());
		int destroyCount = enchHarvesting != 0 ? ((enchHarvesting) * 5) - 1 : 0;
		
		if (!player.abilities.isCreativeMode) {
			
			if (enchHarvesting != 0) {
				
				if (BlockManager.isBrokenWood(block.getDefaultState())) {
					
					int y = pos.getY() + 1;
					
					for (int i = 0; i < destroyCount; i++) {
						
						if (BlockManager.isBlockUpWood(world, pos.getX(), y, pos.getZ())) {
							
							world.destroyBlock(new BlockPos(pos.getX(), y, pos.getZ()), true);
							
							if (Math.random() >= 0.75) {
								
								ItemManager.unbreaking(player, item, EquipmentSlotType.MAINHAND);
								
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
