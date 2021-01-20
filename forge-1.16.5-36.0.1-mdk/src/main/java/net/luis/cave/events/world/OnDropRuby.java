package net.luis.cave.events.world;

import net.luis.cave.Cave;
import net.luis.cave.lib.BlockManager;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnDropRuby {
	
	@SubscribeEvent
	public static void DropRuby(BlockEvent.BreakEvent event) {
		
		BlockPos pos = event.getPos();
		World world = (World) event.getWorld();
		PlayerEntity player = event.getPlayer();
		int enchFortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, player.getHeldItemMainhand());
		int enchSilkTouch = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, player.getHeldItemMainhand());

		if(player instanceof PlayerEntity) {
			
			if (world.getBlockState(pos).getBlock() == Blocks.REDSTONE_ORE) {
				
				if (enchSilkTouch == 0) { 
					
					if (enchFortune == 0) {
						
						BlockManager.dropRuby(world, pos, player, 0.99);
						
					} else if (enchFortune == 1) {
						
						BlockManager.dropRuby(world, pos, player, 0.98);
						
					} else if (enchFortune == 2) {
						
						BlockManager.dropRuby(world, pos, player, 0.97);
						
					} else if (enchFortune == 3) {
						
						BlockManager.dropRuby(world, pos, player, 0.96);
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
