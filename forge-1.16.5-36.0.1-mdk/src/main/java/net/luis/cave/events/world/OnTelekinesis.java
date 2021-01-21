package net.luis.cave.events.world;

import java.util.List;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveEnchantment;
import net.luis.cave.lib.BlockManager;
import net.luis.cave.lib.ItemManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnTelekinesis {
	
	@SubscribeEvent
	public static void Telekinesis(BlockEvent.BreakEvent event) {
		
		PlayerEntity player = event.getPlayer();
		BlockState state = event.getState();
		BlockPos pos = event.getPos();
		IWorld world = event.getWorld();
		int enchTelekinesis = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.TELEKINESIS.get(), player.getHeldItemMainhand());
		int enchSmelting = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.SMELTING.get(), player.getHeldItemMainhand());
		int enchDoubleDrop = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.DOUBLE_DROPS.get(), player.getHeldItemMainhand());
		int enchFortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, player.getHeldItemMainhand());

		if (player instanceof PlayerEntity) {
			
			if (enchTelekinesis > 0) {
				
				event.setCanceled(true);
				
				if (enchSmelting > 0 && BlockManager.hasSmelting((World) world, pos) && !BlockManager.smeltingBlackList((World) world, pos)) {
					
					if (enchFortune == 0 || !(state.getBlock() instanceof OreBlock)) {
						
						ItemHandlerHelper.giveItemToPlayer(player, ItemManager.creatSmeltingItemStack((World) world, pos));
						
					} else {
						
						List<ItemStack> itemList = ItemManager.getFortuneSmelting((World) world, pos, player);
						
						itemList.forEach(item -> {
							
							ItemHandlerHelper.giveItemToPlayer(player, item);
							
						});
						
						
					}
					
				} else if (enchDoubleDrop > 0) {
					
					List<ItemStack> drops = Block.getDrops(state, (ServerWorld) world, pos, null);
					
					for (int i = 0; i < 2; i++) {
						
						drops.forEach(item -> {
							
							ItemHandlerHelper.giveItemToPlayer(player, item);
							
						});
						
					}
					
				} else {
					
					List<ItemStack> drops = Block.getDrops(state, (ServerWorld) world, pos, null);
					
					drops.forEach(item -> {
						
						ItemHandlerHelper.giveItemToPlayer(player, item);
						
					});
					
				}
				
				world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
				
			}
			
		}
		
	}
	
}
