package net.luis.cave.events.client.world;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveEnchantment;
import net.luis.cave.init.CaveTools;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
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
		int enchSmelting = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.SMELTING.get(), player.getHeldItemMainhand());

		if(player instanceof PlayerEntity) {
			
			if (player.abilities.isCreativeMode == false) {
				
				if (player.getHeldItemMainhand().getItem() == CaveTools.BLAZING_AXE.get() |
					player.getHeldItemMainhand().getItem() == CaveTools.BLAZING_PICKAXE.get() |
					player.getHeldItemMainhand().getItem() == CaveTools.BLAZING_SHOVEL.get()) {
							
					if (player.isSneaking() == false) {
						
						if (hasSmelting(world, pos) && !smeltingBlackList(world, pos)) {
							
							if (world.getBlockState(pos).getBlock() instanceof OreBlock) {
								
								FortuneSmelting(world, pos, player);
								
							} else {
								
								Smelting(world, pos, player);
								
							}
							
							event.setCanceled(true);
							world.setBlockState(pos, Blocks.CAVE_AIR.getDefaultState());
							
							ItemStack stack = player.getHeldItemMainhand();
							unbreaking(player, stack);
								
						}
						
					}
							
				}
					
				if (enchSmelting == 1) {
					
					if (hasSmelting(world, pos)) { 
						
						if (world.getBlockState(pos).getBlock() instanceof OreBlock) {
							
							FortuneSmelting(world, pos, player);
							
						} else {
							
							Smelting(world, pos, player);
							
						}
						
						event.setCanceled(true);
						world.setBlockState(pos, Blocks.CAVE_AIR.getDefaultState());
						
						ItemStack stack = player.getHeldItemMainhand();
						unbreaking(player, stack);
								
					}
					
				}
				
			}
			
		}
		
	}
	
	private static boolean hasSmelting(World world, BlockPos pos) {
		
		if ((world.getRecipeManager().getRecipe(IRecipeType.SMELTING,new Inventory(new ItemStack(world.getBlockState(pos).getBlock())), world)
				  .isPresent() ? world.getRecipeManager().getRecipe(IRecipeType.SMELTING, new Inventory(new ItemStack(world.getBlockState(pos).getBlock())),
				   world).get().getRecipeOutput().copy() : ItemStack.EMPTY).getItem() != ItemStack.EMPTY.getItem()) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	private static boolean smeltingBlackList(World world, BlockPos pos) {
		
		if (world.getBlockState(pos).getBlock() == Blocks.ANDESITE) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	private static void Smelting(World world, BlockPos pos, PlayerEntity player) {
		
		double x = pos.getX();
		double y = pos.getY();
		double z = pos.getZ();
		
		ItemEntity stack = new ItemEntity(world, x + 0.5, y + 0.5, z + 0.5, world.getRecipeManager().getRecipe(IRecipeType.SMELTING,
				new Inventory(new ItemStack(world.getBlockState(pos).getBlock())), world)
				.isPresent()? world.getRecipeManager().getRecipe(IRecipeType.SMELTING,
				new Inventory(new ItemStack((world.getBlockState(pos)).getBlock())),
				world).get().getRecipeOutput().copy():ItemStack.EMPTY);
		stack.setPickupDelay(10);
		
		if (player.abilities.isCreativeMode == false) {
			
			world.addEntity(stack);
			
		}
		
	}
	
	public static void FortuneSmelting(World world, BlockPos pos, PlayerEntity player) {
		
		double x = pos.getX();
		double y = pos.getY();
		double z = pos.getZ();
		int EnchFortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, player.getHeldItemMainhand());
		
		ItemEntity stack0 = new ItemEntity(world, x + 0.5, y + 0.5, z + 0.5, world.getRecipeManager().getRecipe(IRecipeType.SMELTING,
				new Inventory(new ItemStack(world.getBlockState(pos).getBlock())), world)
				.isPresent()? world.getRecipeManager().getRecipe(IRecipeType.SMELTING,
				new Inventory(new ItemStack((world.getBlockState(pos)).getBlock())),
				world).get().getRecipeOutput().copy():ItemStack.EMPTY);
		ItemEntity stack1 = new ItemEntity(world, x + 0.5, y + 0.5, z + 0.5, world.getRecipeManager().getRecipe(IRecipeType.SMELTING,
				new Inventory(new ItemStack(world.getBlockState(pos).getBlock())), world)
				.isPresent()? world.getRecipeManager().getRecipe(IRecipeType.SMELTING,
				new Inventory(new ItemStack((world.getBlockState(pos)).getBlock())),
				world).get().getRecipeOutput().copy():ItemStack.EMPTY);
		ItemEntity stack2 = new ItemEntity(world, x + 0.5, y + 0.5, z + 0.5, world.getRecipeManager().getRecipe(IRecipeType.SMELTING,
				new Inventory(new ItemStack(world.getBlockState(pos).getBlock())), world)
				.isPresent()? world.getRecipeManager().getRecipe(IRecipeType.SMELTING,
				new Inventory(new ItemStack((world.getBlockState(pos)).getBlock())),
				world).get().getRecipeOutput().copy():ItemStack.EMPTY);
		ItemEntity stack3 = new ItemEntity(world, x + 0.5, y + 0.5, z + 0.5, world.getRecipeManager().getRecipe(IRecipeType.SMELTING,
				new Inventory(new ItemStack(world.getBlockState(pos).getBlock())), world)
				.isPresent()? world.getRecipeManager().getRecipe(IRecipeType.SMELTING,
				new Inventory(new ItemStack((world.getBlockState(pos)).getBlock())),
				world).get().getRecipeOutput().copy():ItemStack.EMPTY);
		stack0.setPickupDelay(10);
		stack1.setPickupDelay(10);
		stack2.setPickupDelay(10);
		stack3.setPickupDelay(10);
		
		if (player.abilities.isCreativeMode == false) {
			
			if (EnchFortune == 0) {
				
				world.addEntity(stack0);
				
			} else if (EnchFortune == 1) {
				
				if (Math.random() >= 0.95) {
						
					world.addEntity(stack1);
					world.addEntity(stack0);
		
				} else {
					
					world.addEntity(stack0);
					
				}		
				
			} else if (EnchFortune == 2) {
				
				if (Math.random() >= 0.95) {
						
					world.addEntity(stack2);
					world.addEntity(stack1);
					world.addEntity(stack0);
		
				} else if (Math.random() >= 0.9) {
						
					world.addEntity(stack1);
					world.addEntity(stack0);
						
				} else {
					
					world.addEntity(stack0);
					
				}
				
			} else if (EnchFortune == 3) {
				
				if (Math.random() >= 0.95) {
					
					world.addEntity(stack3);
					world.addEntity(stack2);
					world.addEntity(stack1);
					world.addEntity(stack0);
						
				} else if (Math.random() >= 0.9) {
						
					world.addEntity(stack2);
					world.addEntity(stack1);
					world.addEntity(stack0);
					
				} else if (Math.random() >= 0.85) {
					
					world.addEntity(stack1);
					world.addEntity(stack0);
						
				} else {
					
					world.addEntity(stack0);
					
				}
				
			}
			
		}
		
	}
	
	private static void unbreaking(PlayerEntity player, ItemStack stack) {
		
		int EnchUnbreaking = EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, player.getHeldItemMainhand());
		
		if (EnchUnbreaking == 0) {
			
			stack.damageItem(1, player, e -> e.sendBreakAnimation(player.getActiveHand()));
			
		} else if (EnchUnbreaking == 1) {
			
			if (Math.random() >= 0.5) {
				
				stack.damageItem(1, player, e -> e.sendBreakAnimation(player.getActiveHand()));
				
			}
			
		} else if (EnchUnbreaking == 2) {
			
			if (Math.random() >= 0.67) {
				
				stack.damageItem(1, player, e -> e.sendBreakAnimation(player.getActiveHand()));
				
			}
			
		} else if (EnchUnbreaking == 3) {
			
			if (Math.random() >= 0.75) {
				
				stack.damageItem(1, player, e -> e.sendBreakAnimation(player.getActiveHand()));
				
			}
			
		}
		
	}
		
}
