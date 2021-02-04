package net.luis.cave.events.world.block.destroy;

import java.util.List;

import net.luis.cave.Cave;
import net.luis.cave.api.lib.BlockManager;
import net.luis.cave.api.lib.ItemManager;
import net.luis.cave.init.ModEnchantment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
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
		int xp = event.getExpToDrop();
		int enchTelekinesis = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.TELEKINESIS.get(), player.getHeldItemMainhand());
		int enchBlasting = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.BLASTING.get(), player.getHeldItemMainhand());
		int enchExperience = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.EXPERIENCE.get(), player.getHeldItemMainhand());
		int enchSmelting = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.SMELTING.get(), player.getHeldItemMainhand());
		int enchDoubleDrop = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.DOUBLE_DROPS.get(), player.getHeldItemMainhand());
		int enchFortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, player.getHeldItemMainhand());
		int enchSilkTouch = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, player.getHeldItemMainhand());
		int enchReplenish = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.REPLENISH.get(), player.getHeldItemMainhand());

		if (player instanceof PlayerEntity) {
			
			if (enchBlasting == 0 && enchReplenish == 0) {
				
				if (!player.abilities.isCreativeMode) {
					
					if (enchTelekinesis > 0) {
						
						if (event.getExpToDrop() > 0 && enchSilkTouch == 0) {
							
							player.giveExperiencePoints((xp * ((enchExperience + 1) * ((enchExperience * 2) + enchFortune))) * (enchDoubleDrop + 1));
							event.setExpToDrop(0);
							
						}
						
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
						
						player.getHeldItemMainhand().damageItem(1, player, e -> e.sendBreakAnimation(EquipmentSlotType.MAINHAND));
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
