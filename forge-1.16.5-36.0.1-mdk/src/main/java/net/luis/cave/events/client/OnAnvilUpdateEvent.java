package net.luis.cave.events.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.luis.cave.Cave;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.BookItem;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnAnvilUpdateEvent {

	@SubscribeEvent
	public static void AnvilUpdate(net.minecraftforge.event.AnvilUpdateEvent event) {
		
		ItemStack inputLeft = event.getLeft();
		ItemStack inputRight = event.getRight();
		
		if (inputLeft != null && inputRight != null) {
			
			if (inputLeft.isEnchanted()) {
				
				Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(inputLeft);
				int mapSize = enchantments.size();
				
				if (inputRight.getItem() instanceof BookItem) {
					
					if (!inputRight.isEnchanted()) {
						
						if (inputRight.getCount() == 1) {
							
							ItemStack output = new ItemStack(Items.ENCHANTED_BOOK);
							Enchantment randomEnchantment = null;
							int randomEnchantmentLevel = 0;
							
							do {
								
								//Get a random Enchantment
								List<Enchantment> enchantmenList = new ArrayList<Enchantment>(enchantments.keySet());
								int random = new Random().nextInt(enchantmenList.size());
								randomEnchantment = enchantmenList.get(random);
								
								//Get the Level of the Random Enchantment
								List<Integer> levelList = new ArrayList<Integer>(enchantments.values());
								randomEnchantmentLevel = levelList.get(random);
								
							} while (randomEnchantment.isCurse() && mapSize > 1);
							
							if (!randomEnchantment.isCurse()) {
								
								EnchantedBookItem.addEnchantment(output, new EnchantmentData(randomEnchantment, randomEnchantmentLevel));
								
								event.setCost(1 + (mapSize / 2));
								event.setOutput(output);
								
							} else {
								
								event.setCanceled(true);
								
							}
								
						}
						
					}
					
				}
				
			}
			
			if (isEnchanted(inputLeft, inputRight)) {
				
				Map<Enchantment, Integer> enchantmentsLeft = EnchantmentHelper.getEnchantments(inputLeft);
				Map<Enchantment, Integer> enchantmentsRight = EnchantmentHelper.getEnchantments(inputRight);
				
				int enchCountLeft = enchantmentsLeft.size();
				int enchCountRight = enchantmentsRight.size();
				int enchCount = enchCountLeft + enchCountRight;
				
				int cost = enchCount >= 6 ?  (enchCountLeft + enchCountRight) * 2 : ((enchCountLeft + 1) + (enchCountRight + 1)) * 2;
				
				event.setCost(cost);
				
			}
			
		}
		
	}
	
	private static boolean isEnchanted(ItemStack inputLeft, ItemStack inputRight) {
		
		if (!inputLeft.isEnchanted() && !inputRight.isEnchanted()) {
			
			return false;
			
		} else if (inputLeft.isEnchanted() && !inputRight.isEnchanted()) {
			
			return true;
			
		} else if (!inputLeft.isEnchanted() && inputRight.isEnchanted()) {
			
			return true;
			
		} else {
			
			return true;
			
		}
		
	}

}
