package net.luis.cave.events.world;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveEnchantment;
import net.luis.cave.init.CaveTools;
import net.luis.cave.lib.BlockManager;
import net.luis.cave.lib.EnchantmentManager;
import net.luis.cave.lib.ItemManager;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnSmeltingDrop {
	
	@SubscribeEvent
	public static void SmeltingDrop(BlockEvent.BreakEvent event) {
		
		BlockPos pos = event.getPos();
		World world = (World) event.getWorld();
		PlayerEntity player = event.getPlayer();

		if(player instanceof PlayerEntity) {
			
			if (player.abilities.isCreativeMode == false) {
				
				if (player.getHeldItemMainhand().getItem() == CaveTools.BLAZING_AXE.get() |
					player.getHeldItemMainhand().getItem() == CaveTools.BLAZING_PICKAXE.get() |
					player.getHeldItemMainhand().getItem() == CaveTools.BLAZING_SHOVEL.get()) {
							
					if (player.isSneaking() == false) {
						
						if (BlockManager.hasSmelting(world, pos) && !BlockManager.smeltingBlackList(world, pos)) {
							
							if (world.getBlockState(pos).getBlock() instanceof OreBlock) {
								
								BlockManager.getFortuneSmelting(world, pos, player);
								
							} else {
								
								BlockManager.getSmelting(world, pos, player);
								
							}
							
							event.setCanceled(true);
							world.setBlockState(pos, Blocks.CAVE_AIR.getDefaultState());
							
							ItemStack stack = player.getHeldItemMainhand();
							ItemManager.unbreaking(player, stack, EquipmentSlotType.MAINHAND);
								
						}
						
					}
							
				}
					
				if (EnchantmentManager.hasEnchantmentWithLevel(CaveEnchantment.SMELTING.get(), player.getHeldItemMainhand(), 1, true)) {
					
					if (BlockManager.hasSmelting(world, pos)) { 
						
						if (world.getBlockState(pos).getBlock() instanceof OreBlock) {
							
							BlockManager.getFortuneSmelting(world, pos, player);
							
						} else {
							
							BlockManager.getSmelting(world, pos, player);
							
						}
						
						event.setCanceled(true);
						world.setBlockState(pos, Blocks.CAVE_AIR.getDefaultState());
						
						ItemStack stack = player.getHeldItemMainhand();
						ItemManager.unbreaking(player, stack, EquipmentSlotType.MAINHAND);
								
					}
					
				}
				
			}
			
		}
		
	}
		
}
