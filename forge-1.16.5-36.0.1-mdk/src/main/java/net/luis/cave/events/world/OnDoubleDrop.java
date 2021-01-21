package net.luis.cave.events.world;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveBlocks;
import net.luis.cave.init.CaveEnchantment;
import net.luis.cave.init.CaveTools;
import net.luis.cave.lib.BlockManager;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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
public class OnDoubleDrop {
	
	@SubscribeEvent
	public static void DoubleDrop(BlockEvent.BreakEvent event) {
		
		double x = event.getPos().getX();
		double y = event.getPos().getY();
		double z = event.getPos().getZ();
		BlockPos pos = event.getPos();
		World world = (World) event.getWorld();
		PlayerEntity player = event.getPlayer();
		int enchDoubleDrop = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.DOUBLE_DROPS.get(), player.getHeldItemMainhand());
		int enchTelekinesis = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.TELEKINESIS.get(), player.getHeldItemMainhand());

		if(player instanceof PlayerEntity) {
			
			if (enchTelekinesis == 0) {
				
				if (player.getHeldItemMainhand().getItem() == CaveTools.ENDERITE_PICKAXE.get() | 
						player.getHeldItemMainhand().getItem() == CaveTools.ENDERITE_AXE.get() | 
						player.getHeldItemMainhand().getItem() == CaveTools.ENDERITE_SHOVEL.get() |
						player.getHeldItemMainhand().getItem() == CaveTools.ENDERITE_HOE.get()) {
						
						if (Math.random() >= 0.99) {
							
							if (!player.abilities.isCreativeMode) {
								
								Block.spawnDrops(world.getBlockState(pos), world, new BlockPos(x + 0.5, y + 0.5, z + 0.5));
								
							}
								
						}
							
					}
					
					if (enchDoubleDrop > 0) {
							
						if (player.abilities.isCreativeMode == false) {
							
							if (!BlockManager.doubleDropBlackList(world, pos)) {
								
								if (BlockManager.isOreBlock(world, pos)) {
									
									ItemStack item = player.getHeldItemMainhand();
									int maxDamage = item.getMaxDamage();
									double percent = setPercent(world, pos);
									
									Block.spawnDrops(world.getBlockState(pos), world, new BlockPos(x + 0.5, y + 0.5, z + 0.5));
									setdamage(player, item, maxDamage, percent);
									
								} else {
									
									Block.spawnDrops(world.getBlockState(pos), world, new BlockPos(x + 0.5, y + 0.5, z + 0.5));
									
								}
								
							}
								
						}
								
					}
				
			}
			
		}
		
	}
	
	private static double setPercent(World world, BlockPos pos) {
		
		if (world.getBlockState(pos).getBlock() == Blocks.COAL_ORE) {
			
			return 0.002;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.IRON_ORE) {
			
			return 0.002;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.GOLD_ORE) {
			
			return 0.0025;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.LAPIS_ORE) {
			
			return 0.0025;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.REDSTONE_ORE) {
			
			return 0.0025;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.JADE_ORE.get()) {
			
			return 0.003;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.LIMONITE_ORE.get()) {
			
			return 0.004;
			
		}  else if (world.getBlockState(pos).getBlock() == Blocks.DIAMOND_ORE) {
			
			return 0.0065;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.EMERALD_ORE) {
			
			return 0.004;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.SAPHIRE_ORE.get()) {
			
			return 0.007;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.ROSITE_ORE.get()) {
			
			return 0.008;
			
		} else if (world.getBlockState(pos).getBlock() == Blocks.ANCIENT_DEBRIS) {
			
			return 0.01;
			
		} else if (world.getBlockState(pos).getBlock() == CaveBlocks.ENDERITE_ORE.get()) {
			
			return 0.015;
			
		} else {
			
			return 0;
			
		}
		
	}
	
	private static void setdamage(PlayerEntity player, ItemStack item, int maxDamage, double percent) {
		
		double damage = maxDamage * percent;
		item.damageItem(damage != 0 ? (int) damage : 1, player, e -> e.sendBreakAnimation(EquipmentSlotType.MAINHAND));
		
	}
		
}
