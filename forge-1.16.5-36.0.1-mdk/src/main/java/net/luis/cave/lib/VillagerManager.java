package net.luis.cave.lib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import net.luis.cave.init.CaveEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionBrewing;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.fml.RegistryObject;

public class VillagerManager {
	
	private static Random rng = new Random();
	
	public static BasicTrade creatTradeItemForEmerald(Item price, int priceCount, int emeralds, boolean defaultMult, int tradeLevel) {
		
		ItemStack stackPrice = new ItemStack(price, priceCount);
		ItemStack stackEmeralds = new ItemStack(Items.EMERALD, emeralds);
		return new BasicTrade(stackPrice, stackEmeralds, 16, randomXp(tradeLevel), defaultMult ? 0.05f : 0.2f);
		
	}
	
	public static BasicTrade creatTradeItemAndItemForEmerald(Item price0, int priceCount0, Item price1, int priceCount1, 
														int emeralds, boolean defaultMult, int tradeLevel) {
		
		ItemStack stackPrice0 = new ItemStack(price0, priceCount0);
		ItemStack stackPrice1 = new ItemStack(price1, priceCount1);
		ItemStack stackEmeralds = new ItemStack(Items.EMERALD, emeralds);
		return new BasicTrade(stackPrice0, stackPrice1, stackEmeralds, 16, randomXp(tradeLevel), defaultMult ? 0.05f : 0.2f);
		
	}
	
	@SuppressWarnings("deprecation")
	public static BasicTrade creatTradeEmeraldAndArrowForTippedArrow(int emeralds, int arrowCount, int tradeLevel) {
		
		ItemStack tippedArrow = new ItemStack(Items.TIPPED_ARROW, arrowCount);
		List<Potion> potions = Registry.POTION.stream().filter((potion) -> {
            return !potion.getEffects().isEmpty() && PotionBrewing.isBrewablePotion(potion);
         }).collect(Collectors.toList());
		Potion potion = potions.get(rng.nextInt(potions.size()));
		PotionUtils.addPotionToItemStack(tippedArrow, potion);
		return new BasicTrade(new ItemStack(Items.EMERALD, emeralds), new ItemStack(Items.ARROW, arrowCount), tippedArrow, 16, randomXp(tradeLevel), 0.05f);
		
	}
	
	public static List<BasicTrade> creatTradeEmeraldAndWaterBottleForPotionList(int size, int emeralds, int tradeLevel) {
		
		List<BasicTrade> trades = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			trades.add(potion(emeralds, tradeLevel));
		}
		
		return trades;
		
	}
	
	@SuppressWarnings("deprecation")
	private static BasicTrade potion(int emeralds, int tradeLevel) {
		
		ItemStack potionItem = new ItemStack(Items.POTION);
		ItemStack waterBottle = new ItemStack(Items.POTION);
		List<Potion> potions = Registry.POTION.stream().filter((potion) -> {
            return !potion.getEffects().isEmpty() && PotionBrewing.isBrewablePotion(potion);
         }).collect(Collectors.toList());
		Potion potion = potions.get(rng.nextInt(potions.size()));
		Potion water = Potions.WATER;
		PotionUtils.addPotionToItemStack(potionItem, potion);
		PotionUtils.addPotionToItemStack(waterBottle, water);
		return new BasicTrade(new ItemStack(Items.EMERALD, emeralds), waterBottle, potionItem, 16, randomXp(tradeLevel), 0.05f);
		
	}
	
	public static BasicTrade creatTradeEmeraldForEnchantedItem(Item item, int level, boolean allowTreasure, int tradeLevel) {
		
		int count = rng.nextInt(level + level) + level;		
		ItemStack stack = new ItemStack(item);
		EnchantmentHelper.addRandomEnchantment(rng, stack, level, allowTreasure);
		Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(stack);
		List<Enchantment> ench = enchantments.keySet().stream().collect(Collectors.toList());
		Iterator<Enchantment> iterator = enchantments.keySet().iterator();
		while (iterator.hasNext()) {
			ench.forEach(e -> {
				e.isCompatibleWith(iterator.next());
			});
		}
		return new BasicTrade(new ItemStack(Items.EMERALD, count), ItemStack.EMPTY, stack, 16, randomXp(tradeLevel), 0.2f);
		
	}
	
	public static List<BasicTrade> creatTradeEmeraldForEnchantedBookList(int size, int tradeLevel) {
		
		List<BasicTrade> trades = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			trades.add(enchantedBook(randomXp(tradeLevel)));
		}
		
		return trades;
		
	}
	
	public static BasicTrade creatTradeEmeraldForItem(int emeralds, Item sale, int saleCount, boolean defaultMult, int tradeLevel) {
		
		ItemStack stackSale = new ItemStack(sale, saleCount);
		return new BasicTrade(emeralds, stackSale, 16, randomXp(tradeLevel), defaultMult ? 0.05f : 0.2f);
		
	}
	
	@SuppressWarnings("deprecation")
	private static BasicTrade enchantedBook(int xp) {
		
		ItemStack book = new ItemStack(Items.ENCHANTED_BOOK);
		List<Enchantment> enchantments = Registry.ENCHANTMENT.stream().filter((enchantment) -> {
			return !enchantment.isCurse();
		}).collect(Collectors.toList());
		List<Enchantment> caveEnchantments = new ArrayList<>();
		List<RegistryObject<Enchantment>> registryObjectEnchantments= CaveEnchantment.ENCHANTMENT.getEntries().stream().filter((enchantment) -> {
			return !enchantment.get().isCurse();
		}).collect(Collectors.toList());
		registryObjectEnchantments.forEach(enchantment -> {
			caveEnchantments.add(enchantment.get());
		});
		caveEnchantments.forEach(enchantment -> {
			enchantments.add(enchantment);
		});
		Enchantment enchantment = enchantments.get(rng.nextInt(enchantments.size()));
		int enchLevel = Math.min(enchantment.getMaxLevel(), rng.nextInt(5));
		EnchantedBookItem.addEnchantment(book, new EnchantmentData(enchantment, enchLevel));
		int count = 2 + rng.nextInt(5 + enchLevel * 10) + 3 * enchLevel + 5;
		
		return new BasicTrade(new ItemStack(Items.EMERALD, count > 64 ? 64 : count), new ItemStack(Items.BOOK), book, 16, xp, 0.2f);
		
	}
	
	private static int randomXp(int level) {
		
		int basicXp[] = new int[] {2, 10, 20, 30, 40};
		int defaultxp = basicXp[level - 1];
		int xp = Math.min(
				Math.max(rng.nextInt(defaultxp) + ((defaultxp / 2) * (defaultxp / 2) - (defaultxp / 2)), defaultxp * 2),
				Math.max(rng.nextInt(defaultxp + (defaultxp / 2)) + defaultxp,defaultxp)) + level;
		return isEnable(level, xp) ? xp : basicXp[level - 1];
		
	}
	
	private static boolean isEnable(int level, int xp) {
		
		int basicXp[] = new int[] {2, 10, 20, 30, 40};
		int defaultxp = basicXp[level - 1];
		int enableXpMax = defaultxp + (defaultxp / 2) + level;
		int enableXpMin = defaultxp - (defaultxp / 2) + level;
		
		if (xp <= enableXpMin && xp >= enableXpMax) {
			
			return true;
			
		} else if (xp + 2 <= enableXpMin && xp + 2 >= enableXpMax) {
			
			return true;
			
		}
		
		return false;
		
	}
	
}
