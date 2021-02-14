package net.luis.cave.events.world.block.destroy;

import net.luis.cave.Cave;
import net.luis.cave.api.manager.BlockManager;
import net.luis.cave.init.ModEnchantment;
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
		int enchTelekinesis = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.TELEKINESIS.get(), player.getHeldItemMainhand());

		if(player instanceof PlayerEntity) {
			
			if (world.getBlockState(pos).getBlock() == Blocks.REDSTONE_ORE && !player.abilities.isCreativeMode) {
				
				if (enchSilkTouch == 0 && enchTelekinesis == 0) { 
					
					if (enchFortune == 0) {
						
						BlockManager.addRuby(world, pos, player, 0.99);
						
					} else if (enchFortune == 1) {
						
						BlockManager.addRuby(world, pos, player, 0.98);
						
					} else if (enchFortune == 2) {
						
						BlockManager.addRuby(world, pos, player, 0.97);
						
					} else if (enchFortune == 3) {
						
						BlockManager.addRuby(world, pos, player, 0.96);
						
					}
					
				} else if (enchSilkTouch == 0 && enchTelekinesis > 0) {
					
					if (enchFortune == 0) {
						
						BlockManager.getRuby(player, 0.99);
						
					} else if (enchFortune == 1) {
						
						BlockManager.getRuby(player, 0.98);
						
					} else if (enchFortune == 2) {
						
						BlockManager.getRuby(player, 0.97);
						
					} else if (enchFortune == 3) {
						
						BlockManager.getRuby(player, 0.96);
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
