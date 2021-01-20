package net.luis.cave.lib;

import java.util.ArrayList;
import java.util.List;

import net.luis.cave.init.CaveArmor;
import net.luis.cave.init.CaveItems;
import net.luis.cave.init.CaveTools;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
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
	
	public static void unbreaking(PlayerEntity player, ItemStack stack, EquipmentSlotType type) {
		
		int enchUnbreaking = EnchantmentHelper.getEnchantmentLevel(Enchantments.UNBREAKING, player.getHeldItemMainhand());
		
		if (enchUnbreaking == 0) {
			
			stack.damageItem(1, player, e -> e.sendBreakAnimation(type));
			
		} else if (enchUnbreaking == 1) {
			
			if (Math.random() >= 0.5) {
				
				stack.damageItem(1, player, e -> e.sendBreakAnimation(type));
				
			}
			
		} else if (enchUnbreaking == 2) {
			
			if (Math.random() >= 0.67) {
				
				stack.damageItem(1, player, e -> e.sendBreakAnimation(type));
				
			}
			
		} else if (enchUnbreaking == 3) {
			
			if (Math.random() >= 0.75) {
				
				stack.damageItem(1, player, e -> e.sendBreakAnimation(type));
				
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
	
}
