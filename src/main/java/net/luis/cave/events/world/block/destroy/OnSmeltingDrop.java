package net.luis.cave.events.world.block.destroy;

import net.luis.cave.Cave;
import net.luis.cave.api.world.block.BlockManager;
import net.luis.cave.init.ModEnchantment;
import net.luis.cave.init.items.ModTools;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnSmeltingDrop {
	
	@SubscribeEvent
	public static void SmeltingDrop(BlockEvent.BreakEvent event) {
		
		BlockPos pos = event.getPos();
		World world = (World) event.getWorld();
		PlayerEntity player = event.getPlayer();
		int enchTelekinesis = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.TELEKINESIS.get(), player.getHeldItemMainhand());
		int enchSmelting = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.SMELTING.get(), player.getHeldItemMainhand());

		if(player instanceof PlayerEntity) {
			
			if (enchTelekinesis == 0) {
				
				if (!player.abilities.isCreativeMode) {
					
					if (player.getHeldItemMainhand().getItem() == ModTools.BLAZING_AXE.get() |
						player.getHeldItemMainhand().getItem() == ModTools.BLAZING_PICKAXE.get() |
						player.getHeldItemMainhand().getItem() == ModTools.BLAZING_SHOVEL.get()) {
								
						if (player.isSneaking() == false) {
							
							if (BlockManager.hasSmelting(world, pos) && !BlockManager.smeltingBlackList(world, pos)) {
								
								if (world.getBlockState(pos).getBlock() instanceof OreBlock) {
									
									BlockManager.addFortuneSmelting(world, pos, player);
									
								} else {
									
									BlockManager.addSmelting(world, pos, player);
									
								}
								
								event.setCanceled(true);
								world.setBlockState(pos, Blocks.CAVE_AIR.getDefaultState());
								
								ItemStack stack = player.getHeldItemMainhand();
								stack.damageItem(1, player, e -> e.sendBreakAnimation(EquipmentSlotType.MAINHAND));
									
							}
							
						}
								
					}
						
					if (enchSmelting > 0) {
						
						if (BlockManager.hasSmelting(world, pos)) { 
							
							if (world.getBlockState(pos).getBlock() instanceof OreBlock) {
								
								BlockManager.addFortuneSmelting(world, pos, player);
								
							} else {
								
								BlockManager.addSmelting(world, pos, player);
								
							}
							
							event.setCanceled(true);
							world.setBlockState(pos, Blocks.CAVE_AIR.getDefaultState());
							
							ItemStack stack = player.getHeldItemMainhand();
							stack.damageItem(1, player, e -> e.sendBreakAnimation(EquipmentSlotType.MAINHAND));
									
						}
						
					}
					
				}
				
			}
			
		}
		
	}
		
}
