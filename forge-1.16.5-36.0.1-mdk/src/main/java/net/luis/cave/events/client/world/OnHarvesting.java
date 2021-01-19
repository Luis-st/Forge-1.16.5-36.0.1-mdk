package net.luis.cave.events.client.world;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveEnchantment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
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
				
				if (isBrokenWood(block.getDefaultState())) {
					
					int y = pos.getY() + 1;
					
					for (int i = 0; i < destroyCount; i++) {
						
						if (isBlockUpWood(world, pos.getX(), y, pos.getZ())) {
							
							world.destroyBlock(new BlockPos(pos.getX(), y, pos.getZ()), true);
							
							if (Math.random() >= 0.75) {
								
								unbreaking(player, item, EquipmentSlotType.MAINHAND);
								
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
	
	private static boolean isBrokenWood(BlockState state) {
		
		if (state.isIn(BlockTags.LOGS)) {
			
			return true;
			
		}
		
		return false;
		
	}

	
	private static boolean isBlockUpWood(World world, int x, int y, int z) {
		
		if (world.getBlockState(new BlockPos(x, y, z)).isIn(BlockTags.LOGS)) {
			
			return true;
			
		}
		
		return false;
		
	}

	
	private static void unbreaking(PlayerEntity player, ItemStack stack, EquipmentSlotType type) {
		
		int EnchUnbreaking = EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, player.getHeldItemMainhand());
		
		if (EnchUnbreaking == 0) {
			
			stack.damageItem(1, player, e -> e.sendBreakAnimation(type));
			
		} else if (EnchUnbreaking == 1) {
			
			if (Math.random() >= 0.5) {
				
				stack.damageItem(1, player, e -> e.sendBreakAnimation(type));
				
			}
			
		} else if (EnchUnbreaking == 2) {
			
			if (Math.random() >= 0.67) {
				
				stack.damageItem(1, player, e -> e.sendBreakAnimation(type));
				
			}
			
		} else if (EnchUnbreaking == 3) {
			
			if (Math.random() >= 0.75) {
				
				stack.damageItem(1, player, e -> e.sendBreakAnimation(type));
				
			}
			
		}
		
	}
	
}
