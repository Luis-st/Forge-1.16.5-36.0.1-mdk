package net.luis.cave.events.world;

import java.util.List;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveEnchantment;
import net.luis.cave.lib.ItemManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnReplenish {

	@SubscribeEvent
	public static void Replenish(BlockEvent.BreakEvent event) {
		
		BlockPos pos = event.getPos();
		World world = (World) event.getWorld();
		PlayerEntity player = event.getPlayer();
		BlockState state = event.getState();
		int enchReplenish = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.REPLENISH.get(), player.getHeldItemMainhand());
		int enchTelekinesis = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.TELEKINESIS.get(), player.getHeldItemMainhand());
		int enchFortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, player.getHeldItemMainhand());
		
		if (player instanceof PlayerEntity) {
		
			if (!player.abilities.isCreativeMode) {
				
				if (enchReplenish > 0) {
					
					if (state.getBlock() instanceof CropsBlock) {
						
						CropsBlock cropsBlock = (CropsBlock) state.getBlock();
						
						if (cropsBlock.isMaxAge(world.getBlockState(pos))) {
							
							if (enchTelekinesis > 0) {
								
								List<ItemStack> drops = Block.getDrops(state, (ServerWorld) world, pos, null);
								
								drops.forEach(item -> {
									
									ItemHandlerHelper.giveItemToPlayer(player, item);
									
								});
								
							} else {
								
								Block.spawnDrops(state, world, pos);
								
							}
							
							event.setCanceled(true);
							
							world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
							
							if (cropsBlock == Blocks.WHEAT) {
								
								world.setBlockState(pos, state.with(cropsBlock.getAgeProperty(), 
										enchFortune == 0 ? 0 : MathHelper.nextInt(world.rand, 0 + enchFortune, cropsBlock.getMaxAge() - 1)), 3);
								
							} else if (cropsBlock == Blocks.POTATOES) {
								
								world.setBlockState(pos, state.with(cropsBlock.getAgeProperty(), 
										enchFortune == 0 ? 0 : MathHelper.nextInt(world.rand, 0 + enchFortune, cropsBlock.getMaxAge() - 1)), 3);
								
							} else if (cropsBlock == Blocks.CARROTS) {
								
								world.setBlockState(pos, state.with(cropsBlock.getAgeProperty(), 
										enchFortune == 0 ? 0 : MathHelper.nextInt(world.rand, 0 + enchFortune, cropsBlock.getMaxAge() - 1)), 3);
								
							} else if (cropsBlock == Blocks.BEETROOTS) {
								
								world.setBlockState(pos, state.with(cropsBlock.getAgeProperty(), 
										enchFortune == 0 ? 0 : MathHelper.nextInt(world.rand, 0 + enchFortune, cropsBlock.getMaxAge() - 1)), 3);
								
							}
							
							player.getHeldItemMainhand().damageItem(1, player, e -> e.sendBreakAnimation(EquipmentSlotType.MAINHAND));
							
						} else {
							
							event.setCanceled(true);
							
							world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
							
							if (cropsBlock == Blocks.WHEAT) {
								
								world.setBlockState(pos, state.with(cropsBlock.getAgeProperty(), 0), 3);
								
							} else if (cropsBlock == Blocks.POTATOES) {
								
								world.setBlockState(pos, state.with(cropsBlock.getAgeProperty(), 0), 3);
								
							} else if (cropsBlock == Blocks.CARROTS) {
								
								world.setBlockState(pos, state.with(cropsBlock.getAgeProperty(), 0), 3);
								
							} else if (cropsBlock == Blocks.BEETROOTS) {
								
								world.setBlockState(pos, state.with(cropsBlock.getAgeProperty(), 0), 3);
								
							}
							
							player.getHeldItemMainhand().damageItem(1, player, e -> e.sendBreakAnimation(EquipmentSlotType.MAINHAND));
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}
	
}
