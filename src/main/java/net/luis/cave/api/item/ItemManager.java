package net.luis.cave.api.item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import net.luis.cave.api.item.api.weapon.Bow;
import net.luis.cave.api.item.api.weapon.Crossbow;
import net.luis.cave.init.items.ModArmor;
import net.luis.cave.init.items.ModItems;
import net.luis.cave.init.items.ModTools;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.TridentItem;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemManager {
	
	public static boolean sameItemType(ItemStack inputLeft, ItemStack inputRight) {
		
		Tool toolLeft = getItemType(inputLeft);
		Tool toolRight = getItemType(inputRight);
		
		if (toolLeft == toolRight) {
			
			return true;
			
		} 
		
		return false;
		
	}
	
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
		enderiteItems.add(ModItems.ENDERITE_SCRAP.get());
		enderiteItems.add(ModItems.ENDERITE_INGOT.get());
		enderiteItems.add(ModTools.ENDERITE_SWORD.get());
		enderiteItems.add(ModTools.ENDERITE_PICKAXE.get());
		enderiteItems.add(ModTools.ENDERITE_AXE.get());
		enderiteItems.add(ModTools.ENDERITE_SHOVEL.get());
		enderiteItems.add(ModTools.ENDERITE_HOE.get());
		enderiteItems.add(ModTools.ENDERITE_SHIELD.get());
		enderiteItems.add(ModTools.ENDERITE_BOW.get());
		enderiteItems.add(ModTools.ENDERITE_CROSSBOW.get());
		enderiteItems.add(ModArmor.ENDREITE_BOOTS.get());
		enderiteItems.add(ModArmor.ENDREITE_LEGGINS.get());
		enderiteItems.add(ModArmor.ENDREITE_CHESTPLATE.get());
		enderiteItems.add(ModArmor.ENDREITE_ELYTRA.get());
		enderiteItems.add(ModArmor.ENDREITE_HELMET.get());
		
		return enderiteItems;
		
	}
	
	private static List<Item> getNightItems() {
		
		List<Item> nightItems = new ArrayList<>();
		nightItems.add(ModItems.NIGHT_INGOT.get());
		nightItems.add(ModTools.NIGHT_SWORD.get());
		nightItems.add(ModTools.NIGHT_PICKAXE.get());
		nightItems.add(ModTools.NIGHT_AXE.get());
		nightItems.add(ModTools.NIGHT_SHOVEL.get());
		nightItems.add(ModTools.NIGHT_HOE.get());
		nightItems.add(ModTools.NIGHT_SHIELD.get());
		nightItems.add(ModTools.NIGHT_BOW.get());
		nightItems.add(ModTools.NIGHT_CROSSBOW.get());
		nightItems.add(ModArmor.NIGHT_BOOTS.get());
		nightItems.add(ModArmor.NIGHT_LEGGINS.get());
		nightItems.add(ModArmor.NIGHT_CHESTPLATE.get());
		nightItems.add(ModArmor.NIGHT_ELYTRA.get());
		nightItems.add(ModArmor.NIGHT_HELMET.get());
		
		return nightItems;
		
	}
	
	public static boolean isShulkerBox(ItemStack item) {
		
		List<Item> shulkerBoxItems = getShulkerBoxItems();
		
		for (int i = 0; i < shulkerBoxItems.size(); i++) {
			
			if (shulkerBoxItems.get(i) == item.getItem()) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	private static List<Item> getShulkerBoxItems() {
		
		List<Item> shulkerBoxItems = new ArrayList<>();
		shulkerBoxItems.add(Items.SHULKER_BOX);
		shulkerBoxItems.add(Items.BLACK_SHULKER_BOX);
		shulkerBoxItems.add(Items.BLUE_SHULKER_BOX);
		shulkerBoxItems.add(Items.BROWN_SHULKER_BOX);
		shulkerBoxItems.add(Items.CYAN_SHULKER_BOX);
		shulkerBoxItems.add(Items.GRAY_SHULKER_BOX);
		shulkerBoxItems.add(Items.GREEN_SHULKER_BOX);
		shulkerBoxItems.add(Items.LIGHT_BLUE_SHULKER_BOX);
		shulkerBoxItems.add(Items.LIGHT_GRAY_SHULKER_BOX);
		shulkerBoxItems.add(Items.LIME_SHULKER_BOX);
		shulkerBoxItems.add(Items.MAGENTA_SHULKER_BOX);
		shulkerBoxItems.add(Items.ORANGE_SHULKER_BOX);
		shulkerBoxItems.add(Items.PINK_SHULKER_BOX);
		shulkerBoxItems.add(Items.PURPLE_SHULKER_BOX);
		shulkerBoxItems.add(Items.RED_SHULKER_BOX);
		shulkerBoxItems.add(Items.WHITE_SHULKER_BOX);
		shulkerBoxItems.add(Items.YELLOW_SHULKER_BOX);
		
		return shulkerBoxItems;
		
	}
	
	public static <T extends LivingEntity> void damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken, boolean enableUnbreaking) {
		
		if (!entity.world.isRemote && (!(entity instanceof PlayerEntity) || !((PlayerEntity) entity).abilities.isCreativeMode)) {
			
			if (stack.isDamageable()) {
				
				amount = stack.getItem().damageItem(stack, amount, entity, onBroken);
				
				if (!enableUnbreaking) {
					
					stack.setDamage(stack.getDamage() + amount);

					
				} else {
					
					stack.damageItem(amount, entity, onBroken);
					
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

	public static Tool getItemType(ItemStack stack) {
		
		Item item = stack.getItem();
		
		if (item instanceof ToolItem) {
			
			if (item instanceof SwordItem) {
				
				return Tool.SWORD;
				
			} else if (item instanceof PickaxeItem) {
				
				return Tool.PICKAXE;
				
			} else if (item instanceof AxeItem) {
				
				return Tool.AXE;
				
			} else if (item instanceof ShovelItem) {
				
				return Tool.SHOVEL;
				
			} else if (item instanceof HoeItem) {
				
				return Tool.HOE;
				
			} else if (item instanceof ShieldItem) {
				
				return Tool.SHIELD;
				
			} else if (item instanceof Bow) {
				
				return Tool.BOW;
				
			} else if (item instanceof Crossbow) {
				
				return Tool.CROSSBOW;
				
			} else if (item instanceof TridentItem) {
				
				return Tool.TRIDENT;
				
			} else if (item instanceof FishingRodItem) {
				
				return Tool.ROD;
				
			} else if (item instanceof FlintAndSteelItem) {
				
				return Tool.FLINT_AND_STEEL;
				
			} else if (item instanceof ArmorItem) {
				
				ArmorItem armorItem = (ArmorItem) item;
				
				if (armorItem.getEquipmentSlot() == EquipmentSlotType.HEAD) {
					
					return Tool.HELMET;
					
				} else if (armorItem.getEquipmentSlot() == EquipmentSlotType.CHEST) {
					
					return Tool.CHEST;
					
				} else if (armorItem.getEquipmentSlot() == EquipmentSlotType.LEGS) {
					
					return Tool.LEGS;
					
				} else if (armorItem.getEquipmentSlot() == EquipmentSlotType.FEET) {
					
					return Tool.FEET;
					
				}
				
			}
			
		}
		
		return Tool.ITEM;
		
	}
	
	public static boolean isBreakableItemType(ItemStack stack) {
		
		return getItemType(stack) != Tool.ITEM;
		
	}
	
	public static boolean isArmorItemType(ItemStack stack) {
		
		Tool tool = getItemType(stack);
		
		switch (tool) {
		case HELMET: {
			return true;
		} case CHEST: {
			return true;
		} case LEGS: {
			return true;
		} case FEET: {
			return true;
		} default:
			return false;
		}
		
	}
	
	public static boolean isToolItemType(ItemStack stack) {
		
		if (getItemType(stack) != Tool.ITEM) {
			
			if (!isArmorItemType(stack)) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	public enum Tool {
		
		SWORD,
		PICKAXE,
		AXE,
		SHOVEL,
		HOE,
		SHIELD,
		BOW,
		CROSSBOW,
		TRIDENT,
		ROD,
		FLINT_AND_STEEL,
		HELMET,
		CHEST,
		LEGS,
		FEET,
		ITEM;
		
	}
	
}
