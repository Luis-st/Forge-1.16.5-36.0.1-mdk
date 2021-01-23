package net.luis.cave.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import net.luis.cave.init.CaveArmor;
import net.luis.cave.init.CaveItems;
import net.luis.cave.init.CaveTools;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemManager {
	
	public static boolean isEnderite(ItemStack item) {
		
		List<Item> enderiteItems = getEnderiteItems();
		
		for (int i = 0; i < enderiteItems.size(); i++) {
			
			if (enderiteItems.get(i) == item.getItem()) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public static boolean isNight(ItemStack item) {
		
		List<Item> nightItems = getNightItems();
		
		for (int i = 0; i < nightItems.size(); i++) {
			
			if (nightItems.get(i) == item.getItem()) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	private static List<Item> getEnderiteItems() {
		
		List<Item> enderiteItems = new ArrayList<>();
		enderiteItems.add(CaveItems.ENDERITE_SCRAP.get());
		enderiteItems.add(CaveItems.ENDERITE_INGOT.get());
		enderiteItems.add(CaveTools.ENDERITE_SWORD.get());
		enderiteItems.add(CaveTools.ENDERITE_PICKAXE.get());
		enderiteItems.add(CaveTools.ENDERITE_AXE.get());
		enderiteItems.add(CaveTools.ENDERITE_SHOVEL.get());
		enderiteItems.add(CaveTools.ENDERITE_HOE.get());
		enderiteItems.add(CaveTools.ENDERITE_SHIELD.get());
		enderiteItems.add(CaveTools.ENDERITE_BOW.get());
		enderiteItems.add(CaveTools.ENDERITE_CROSSBOW.get());
		enderiteItems.add(CaveArmor.ENDREITE_BOOTS.get());
		enderiteItems.add(CaveArmor.ENDREITE_LEGGINS.get());
		enderiteItems.add(CaveArmor.ENDREITE_CHESTPLATE.get());
		enderiteItems.add(CaveArmor.ENDREITE_ELYTRA.get());
		enderiteItems.add(CaveArmor.ENDREITE_HELMET.get());
		
		return enderiteItems;
		
	}
	
	private static List<Item> getNightItems() {
		
		List<Item> nightItems = new ArrayList<>();
		nightItems.add(CaveItems.NIGHT_INGOT.get());
		nightItems.add(CaveTools.NIGHT_SWORD.get());
		nightItems.add(CaveTools.NIGHT_PICKAXE.get());
		nightItems.add(CaveTools.NIGHT_AXE.get());
		nightItems.add(CaveTools.NIGHT_SHOVEL.get());
		nightItems.add(CaveTools.NIGHT_HOE.get());
		nightItems.add(CaveTools.NIGHT_SHIELD.get());
		nightItems.add(CaveTools.NIGHT_BOW.get());
		nightItems.add(CaveTools.NIGHT_CROSSBOW.get());
		nightItems.add(CaveArmor.NIGHT_BOOTS.get());
		nightItems.add(CaveArmor.NIGHT_LEGGINS.get());
		nightItems.add(CaveArmor.NIGHT_CHESTPLATE.get());
		nightItems.add(CaveArmor.NIGHT_ELYTRA.get());
		nightItems.add(CaveArmor.NIGHT_HELMET.get());
		
		return nightItems;
		
	}
	
	public static <T extends LivingEntity> void damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken, boolean enableUnbreaking) {
		
		if (!entity.world.isRemote && (!(entity instanceof PlayerEntity) || !((PlayerEntity) entity).abilities.isCreativeMode)) {
			
			if (stack.isDamageable()) {
				
				amount = stack.getItem().damageItem(stack, amount, entity, onBroken);
				
				if (!enableUnbreaking) {
					
					stack.setDamage(stack.getDamage() + amount);

					
				} else {
					
					int enchUnbreaking = EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, entity.getHeldItemMainhand());
					
					if (enchUnbreaking == 0) {
						
						stack.setDamage(stack.getDamage() + amount);
						
					} else if (enchUnbreaking == 1) {
						
						if (Math.random() >= 0.5) {
							
							stack.setDamage(stack.getDamage() + amount);
							
						}
						
					} else if (enchUnbreaking == 2) {
						
						if (Math.random() >= 0.67) {
							
							stack.setDamage(stack.getDamage() + amount);
							
						}
						
					} else if (enchUnbreaking == 3) {
						
						if (Math.random() >= 0.75) {
							
							stack.setDamage(stack.getDamage() + amount);
							
						}
						
					}
					
				}
				
			}
			
		}
		
	}

	public static ItemEntity creatSmeltingItem(World world, BlockPos pos) {
		
		double x = pos.getX();
		double y = pos.getY();
		double z = pos.getZ();
		
		ItemEntity smeltingItem = new ItemEntity(world, x + 0.5, y + 0.5, z + 0.5, 
				world.getRecipeManager().getRecipe(IRecipeType.SMELTING,
				new Inventory(new ItemStack((world.getBlockState(pos)).getBlock())),
				world).get().getRecipeOutput().copy());
		
		smeltingItem.setPickupDelay(10);
		
		return smeltingItem;
		
	}
	
	public static ItemStack creatSmeltingItemStack(World world, BlockPos pos) {
		
		ItemStack smeltingItem = world.getRecipeManager().getRecipe(IRecipeType.SMELTING,
				new Inventory(new ItemStack((world.getBlockState(pos)).getBlock())),
				world).get().getRecipeOutput().copy();
		
		return smeltingItem;
		
	}
	
	public static List<ItemStack> getFortuneSmelting(World world, BlockPos pos, PlayerEntity player) {
		
		ItemStack stack = ItemManager.creatSmeltingItemStack(world, pos);
		int enchFortune = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, player.getHeldItemMainhand());
		List<ItemStack> itemList = new ArrayList<ItemStack>();
		
		if (!player.abilities.isCreativeMode) {
			
			if (enchFortune == 0) {
				
				itemList.add(stack);
				
			} else if (enchFortune == 1) {
				
				if (Math.random() >= 0.95) {
						
					itemList.add(stack);
					itemList.add(stack);
		
				} else {
					
					itemList.add(stack);
					
				}		
				
			} else if (enchFortune == 2) {
				
				if (Math.random() >= 0.95) {
						
					itemList.add(stack);
					itemList.add(stack);
					itemList.add(stack);
		
				} else if (Math.random() >= 0.9) {
						
					itemList.add(stack);
					itemList.add(stack);
						
				} else {
					
					itemList.add(stack);
					
				}
				
			} else if (enchFortune == 3) {
				
				if (Math.random() >= 0.95) {
					
					itemList.add(stack);
					itemList.add(stack);
					itemList.add(stack);
					itemList.add(stack);
						
				} else if (Math.random() >= 0.9) {
						
					itemList.add(stack);
					itemList.add(stack);
					itemList.add(stack);
					
				} else if (Math.random() >= 0.85) {
					
					itemList.add(stack);
					itemList.add(stack);
						
				} else {
					
					itemList.add(stack);
					
				}
				
			}
			
		}
		
		return itemList;
		
	}
	
	public static void setNoGravityItem(List<ItemEntity> drops) {
		
		drops.forEach(item -> {
			
			ItemEntity itemEntity = (ItemEntity) item.getItem().getAttachedEntity();
			
			if (ItemManager.isEnderite(itemEntity.getItem())) {
				
				itemEntity.setInvulnerable(true);
				itemEntity.setNoGravity(true);
				itemEntity.setMotion(0, 0, 0);
				
				if (itemEntity.getPosY() < 0) {
					
					itemEntity.setPositionAndUpdate(itemEntity.getPosX(), 3, itemEntity.getPosZ());
					itemEntity.setInvulnerable(false);
					
				}
				
			} else if (ItemManager.isNight(itemEntity.getItem())) {
				
				itemEntity.setInvulnerable(true);
				itemEntity.setNoGravity(true);
				itemEntity.setMotion(0, 0, 0);
				
				if (itemEntity.getPosY() < 0) {
					
					itemEntity.setPositionAndUpdate(itemEntity.getPosX(), 3, itemEntity.getPosZ());
					itemEntity.setInvulnerable(false);
					
				}
				
			}
			
		});
		
	}
	
	public static void setNoGravityItem(ItemEntity itemEntity) {
		
		itemEntity.setInvulnerable(true);
		itemEntity.setNoGravity(true);
		itemEntity.setMotion(0, 0, 0);
		
		if (itemEntity.getPosY() < 0) {
			
			itemEntity.setPositionAndUpdate(itemEntity.getPosX(), 3, itemEntity.getPosZ());
			itemEntity.setInvulnerable(false);
			
		}
		
	}
	
}
