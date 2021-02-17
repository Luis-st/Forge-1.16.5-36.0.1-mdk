package net.luis.cave.events.world.block.destroy;

import java.util.List;

import net.luis.cave.Cave;
import net.luis.cave.api.item.ItemManager;
import net.luis.cave.api.world.block.BlockManager;
import net.luis.cave.init.ModEnchantment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ShulkerBoxTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
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
		World world = (World) event.getWorld();
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
						
						if (state.getBlock() instanceof ShulkerBoxBlock) {
							
							event.setCanceled(true);
							
							ShulkerBoxBlock shulkerBox = (ShulkerBoxBlock) state.getBlock();
							handelShulkerBox(world, pos, shulkerBox, player);
							
							world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
							player.getHeldItemMainhand().damageItem(1, player, e -> e.sendBreakAnimation(EquipmentSlotType.MAINHAND));
							
						} else {
							
							if (event.getExpToDrop() > 0 && enchSilkTouch == 0) {
								
								player.giveExperiencePoints((xp * ((enchExperience + 1) * ((enchExperience * 2) + enchFortune))) * (enchDoubleDrop + 1));
								event.setExpToDrop(0);
								
							}
							
							event.setCanceled(true);
							
							if (enchSmelting > 0 && BlockManager.hasSmelting(world, pos) && !BlockManager.smeltingBlackList(world, pos)) {
								
								handelSmelting(world, state, pos, player, enchFortune);
								
							} else if (enchDoubleDrop > 0) {
								
								handelDoubleDrop(world, state, pos, player);
								
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
	
	@SuppressWarnings("static-access")
	private static void handelShulkerBox(World world, BlockPos pos, ShulkerBoxBlock shulkerBox, PlayerEntity player) {
		
		TileEntity tileEntity = world.getTileEntity(pos);
		
		if (tileEntity instanceof ShulkerBoxTileEntity) {
			
			ShulkerBoxTileEntity shulkerBoxTileEntity = (ShulkerBoxTileEntity) tileEntity;
			
			if (!world.isRemote && !shulkerBoxTileEntity.isEmpty()) {
				
				ItemStack itemstack = shulkerBox.getColoredItemStack(shulkerBox.getColor());
				CompoundNBT compoundnbt = shulkerBoxTileEntity.saveToNbt(new CompoundNBT());
				
				if (!compoundnbt.isEmpty()) {
					
					itemstack.setTagInfo("BlockEntityTag", compoundnbt);
					
				}

				if (shulkerBoxTileEntity.hasCustomName()) {
					
					itemstack.setDisplayName(shulkerBoxTileEntity.getCustomName());
					
				}
				
				ItemHandlerHelper.giveItemToPlayer(player, itemstack);
				
			} else {
				
				shulkerBoxTileEntity.fillWithLoot(player);
				
			}
			
		}
		
	}

	private static void handelSmelting(World world, BlockState state, BlockPos pos, PlayerEntity player, int enchFortune) {
		
		if (enchFortune == 0 || !(state.getBlock() instanceof OreBlock)) {
			
			ItemHandlerHelper.giveItemToPlayer(player, ItemManager.creatSmeltingItemStack((World) world, pos));
			
		} else {
			
			List<ItemStack> itemList = ItemManager.getFortuneSmelting((World) world, pos, player);
			
			itemList.forEach(item -> {
				
				ItemHandlerHelper.giveItemToPlayer(player, item);
				
			});
			
			
		}
		
	}
	
	private static void handelDoubleDrop(World world, BlockState state, BlockPos pos, PlayerEntity player) {
		
		List<ItemStack> drops = Block.getDrops(state, (ServerWorld) world, pos, null);
		
		for (int i = 0; i < 2; i++) {
			
			drops.forEach(item -> {
				
				ItemHandlerHelper.giveItemToPlayer(player, item);
				
			});
			
		}
		
	}

}
