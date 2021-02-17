package net.luis.cave.events.entity.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.luis.cave.Cave;
import net.luis.cave.api.enchantment.EnchantmentManager;
import net.luis.cave.init.util.ModGameRule;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnAnvilUpdateEvent {
	
	// TODO: repair Enchbook + Book -> EnchBook + BackBook

	@SubscribeEvent
	public static void AnvilUpdate(AnvilUpdateEvent event) {
		
		ItemStack inputLeft = event.getLeft();
		ItemStack inputRight = event.getRight();
		World world = event.getPlayer().getEntityWorld();
		
		if (inputLeft != null && inputRight != null) {
			
			if (world.getGameRules().getBoolean(ModGameRule.ENABLE_ENCHANTMENT_TRANSFER.getRule())) {
				
				if (EnchantmentManager.enchantmentTransferCase1(inputLeft, inputRight)) {
					
					handelCase(event, inputLeft, inputRight);
					
				} else if (EnchantmentManager.enchantmentTransferCase2(inputLeft, inputRight)) {
					
					handelCase(event, inputLeft, inputRight);
					
				}
				
			}
			
			if (EnchantmentManager.isItemEnchanted(inputLeft, inputRight)) {
				
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
	
	private static void handelCase(AnvilUpdateEvent event, ItemStack inputLeft, ItemStack inputRight) {
		
		Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(inputLeft);
		int mapSize = enchantments.size();
		ItemStack output = new ItemStack(Items.ENCHANTED_BOOK);
		Enchantment randomEnchantment = null;
		int randomEnchantmentLevel = 0;
		
		do {
			
			List<Enchantment> enchantmenList = new ArrayList<Enchantment>(enchantments.keySet());
			int random = new Random().nextInt(enchantmenList.size());
			randomEnchantment = enchantmenList.get(random);
			
			List<Integer> levelList = new ArrayList<Integer>(enchantments.values());
			randomEnchantmentLevel = levelList.get(random);
			
		} while (randomEnchantment.isCurse() && mapSize > 1);
		
		if (!randomEnchantment.isCurse()) {
			
			EnchantedBookItem.addEnchantment(output, new EnchantmentData(randomEnchantment, randomEnchantmentLevel));
			
			event.setCost(1 + (mapSize / 4));
			event.setOutput(output);
			
		} else {
			
			event.setCanceled(true);
			
		}
		
	}
	
}
