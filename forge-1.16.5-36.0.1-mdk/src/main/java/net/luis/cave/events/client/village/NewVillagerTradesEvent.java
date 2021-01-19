package net.luis.cave.events.client.village;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveArmor;
import net.luis.cave.init.CaveTools;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionBrewing;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class NewVillagerTradesEvent {
	
	@SubscribeEvent
	public static void VillagerTradesTest(VillagerTradesEvent event) {
		
		List<ITrade> trade1 = event.getTrades().get(1);
		List<ITrade> trade2 = event.getTrades().get(2);
		List<ITrade> trade3 = event.getTrades().get(3);
		List<ITrade> trade4 = event.getTrades().get(4);
		List<ITrade> trade5 = event.getTrades().get(5);
		VillagerProfession type = event.getType();
		
		if (type == VillagerProfession.BUTCHER) {
			
			trade1.add(new BasicTrade(new ItemStack(Items.COOKED_CHICKEN , 14), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			trade1.add(new BasicTrade(new ItemStack(Items.COOKED_PORKCHOP , 7), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			trade1.add(new BasicTrade(new ItemStack(Items.COOKED_RABBIT , 4), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			
			trade3.add(new BasicTrade(new ItemStack(Items.MUTTON, 7), new ItemStack(Items.EMERALD), 16, 20, 0.05f));
			trade3.add(new BasicTrade(new ItemStack(Items.COOKED_MUTTON, 7), new ItemStack(Items.EMERALD), 16, 20, 0.05f));
			trade3.add(new BasicTrade(1, new ItemStack(Items.COOKED_MUTTON, 4), 16, 20));
			trade3.add(new BasicTrade(1, new ItemStack(Items.BEEF, 5), 16, 20, 0.05f));
			trade3.add(new BasicTrade(new ItemStack(Items.COOKED_BEEF, 10), new ItemStack(Items.EMERALD), 16, 20, 0.05f));
			trade3.add(new BasicTrade(1, new ItemStack(Items.COOKED_BEEF, 5), 16, 20, 0.05f));
			
		} else if (type == VillagerProfession.LIBRARIAN) {
			
			trade3.add(new BasicTrade(1, new ItemStack(Items.INK_SAC, 3), 16, 20, 0.05f));
			trade3.add(new BasicTrade(new ItemStack(Items.GLASS , 8), new ItemStack(Items.EMERALD), 16, 20, 0.05f));
			
			trade4.add(new BasicTrade(new ItemStack(Items.CLOCK), new ItemStack(Items.EMERALD, 2), 16, 30, 0.05f));
			trade4.add(new BasicTrade(new ItemStack(Items.COMPASS), new ItemStack(Items.EMERALD, 2), 16, 30, 0.05f));
			
			trade5.addAll(createBasicTradeListBooks(1000, 40));
			
		} else if (type == VillagerProfession.ARMORER) {
			
			trade1.add(new BasicTrade(1, new ItemStack(Items.COAL, 8), 16, 2, 0.05f));
			
			trade2.add(new BasicTrade(1, new ItemStack(Items.IRON_INGOT, 2), 16, 10, 0.05f));
			
			trade3.add(new BasicTrade(7, new ItemStack(CaveTools.IRON_SHIELD.get()), 16, 20, 0.2f));
			trade3.add(new BasicTrade(15, new ItemStack(CaveTools.DIAMOND_SHIELD.get()), 16, 20, 0.2f));
			
			trade4.add(enchantedItem(CaveArmor.SAPHIRE_LEGGINS.get(), 15, false, 30));
			trade4.add(enchantedItem(CaveArmor.SAPHIRE_BOOTS.get(), 15, false, 30));
			
			trade5.add(enchantedItem(CaveArmor.SAPHIRE_CHESTPLATE.get(), 15, false, 40));
			trade5.add(enchantedItem(CaveArmor.SAPHIRE_HELMET.get(), 15, false, 40));
			
		} else if (type == VillagerProfession.TOOLSMITH) {
			
			trade1.add(new BasicTrade(1, new ItemStack(Items.COAL, 8), 16, 2, 0.05f));
			trade1.add(new BasicTrade(3, new ItemStack(Items.IRON_AXE), 16, 2, 0.2f));
			trade1.add(new BasicTrade(3, new ItemStack(Items.IRON_SHOVEL), 16, 2, 0.2f));
			trade1.add(new BasicTrade(3, new ItemStack(Items.IRON_PICKAXE), 16, 2, 0.2f));
			trade1.add(new BasicTrade(3, new ItemStack(Items.IRON_HOE), 16, 2, 0.2f));
			
			trade2.add(new BasicTrade(1, new ItemStack(Items.IRON_INGOT, 2), 16, 10, 0.05f));
			
			trade3.add(new BasicTrade(6, new ItemStack(Items.DIAMOND), 16, 30, 0.05f));
			
			trade4.add(enchantedItem(CaveTools.LIMONITE_AXE.get(), 15, false, 30));
			trade4.add(enchantedItem(CaveTools.LIMONITE_SHOVEL.get(), 15, false, 30));
			trade4.add(enchantedItem(CaveTools.LIMONITE_HOE.get(), 15, false, 30));
			
			trade5.add(enchantedItem(CaveTools.LIMONITE_PICKAXE.get(), 15, false, 40));
			
		} else if (type == VillagerProfession.CLERIC) {
			
			trade1.add(new BasicTrade(new ItemStack(Items.REDSTONE, 4), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			
			trade2.add(new BasicTrade(1, new ItemStack(Items.GOLD_INGOT, 2), 16, 10));
			trade2.add(new BasicTrade(new ItemStack(Items.LAPIS_LAZULI, 2), new ItemStack(Items.EMERALD), 16, 10, 0.05f));
			
			trade4.add(new BasicTrade(16, new ItemStack(Items.SCUTE), 16, 30, 0.05f));
			trade4.add(new BasicTrade(1, new ItemStack(Items.GLASS_BOTTLE, 6), 16, 30, 0.05f));
			
			trade5.add(new BasicTrade(7, new ItemStack(Items.BLAZE_ROD), 16, 40, 0.05f));
			
		} else if (type == VillagerProfession.FLETCHER) {
			
			Random rng = new Random();
			
			trade1.add(new BasicTrade(new ItemStack(Items.STICK, 32 - rng.nextInt(16)), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			trade1.add(new BasicTrade(new ItemStack(Items.ARROW, 8 + rng.nextInt(8)), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			
			trade4.addAll(createBasicTradeListArrows(4, 100, 30));
			
			trade5.addAll(createBasicTradeListArrows(2, 100, 40));
			
		} else if (type == VillagerProfession.WEAPONSMITH) {
			
			trade1.add(new BasicTrade(1, new ItemStack(Items.COAL, 8), 16, 2, 0.05f));
			
			trade2.add(new BasicTrade(1, new ItemStack(Items.IRON_INGOT, 2), 16, 10, 0.05f));

			trade5.add(new BasicTrade(33, new ItemStack(CaveTools.BLAZING_SWORD.get()), 16, 40, 0.2f));
			trade5.add(enchantedItem(CaveTools.SAPHIRE_SWORD.get(), 20, false, 40));
			
		}
		
		
	}
	
	private static BasicTrade enchantedItem(Item item, int level, boolean allowTreasure, int xp) {
		
		Random rng = new Random();
		int count = rng.nextInt(level + level) + level;		
		ItemStack stack = new ItemStack(item);
		EnchantmentHelper.addRandomEnchantment(rng, stack, level, allowTreasure);
		
		return new BasicTrade(new ItemStack(Items.EMERALD, count), ItemStack.EMPTY, stack, 16, xp, 0.2f);
		
	}
	
	@SuppressWarnings("deprecation")
	private static BasicTrade enchantedBook(int xp) {
		
		Random rng = new Random();
		ItemStack book = new ItemStack(Items.ENCHANTED_BOOK);
		List<Enchantment> enchantments = Registry.ENCHANTMENT.stream().filter((enchantment) -> {
			return !enchantment.isCurse();
		}).collect(Collectors.toList());
		Enchantment enchantment = enchantments.get(rng.nextInt(enchantments.size()));
		int enchLevel = MathHelper.nextInt(rng, enchantment.getMinLevel(), enchantment.getMaxLevel());
		EnchantedBookItem.addEnchantment(book, new EnchantmentData(enchantment, enchLevel));
		int count = 2 + rng.nextInt(5 + enchLevel * 10) + 3 * enchLevel;
		
		return new BasicTrade(new ItemStack(Items.EMERALD, count > 64 ? 64 : count), new ItemStack(Items.BOOK), book, 16, xp, 0.2f);
		
	}
	
	@SuppressWarnings("deprecation")
	private static ItemStack tippedArrow() {
		
		Random rng = new Random();
		ItemStack tippedArrow = new ItemStack(Items.TIPPED_ARROW, 5);
		List<Potion> potions = Registry.POTION.stream().filter((potion) -> {
            return !potion.getEffects().isEmpty() && PotionBrewing.isBrewablePotion(potion);
         }).collect(Collectors.toList());
		Potion potion = potions.get(rng.nextInt(potions.size()));
		PotionUtils.addPotionToItemStack(tippedArrow, potion);
		
		return tippedArrow;
	
	}
	
	private static List<BasicTrade> createBasicTradeListBooks(int size, int xp) {
		
		List<BasicTrade> trades = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			trades.add(enchantedBook(xp));
		}
		
		return trades;
		
	}
	
	private static List<BasicTrade> createBasicTradeListArrows(int emeralds, int size, int xp) {
		
		List<BasicTrade> trades = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			trades.add(new BasicTrade(new ItemStack(Items.EMERALD, emeralds), new ItemStack(Items.ARROW, 5), tippedArrow(), 16, xp, 0.05f));
		}
		
		return trades;
		
	}
	
}
