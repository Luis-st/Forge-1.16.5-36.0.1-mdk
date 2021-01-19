package net.luis.cave.villagers.trades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.luis.cave.Cave;
import net.luis.cave.init.CaveEnchantment;
import net.luis.cave.villagers.VillagerProfessions;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEnchanterTradesEvent {
	
	@SubscribeEvent
	public static void EnchanterTrades(VillagerTradesEvent event) {
		
		Int2ObjectMap<List<ITrade>> trades = event.getTrades();
		VillagerProfession type = event.getType();
		
		if (type == VillagerProfessions.ENCHANTER) {
			
			List<ITrade> newTrades1 = new ArrayList<>();
			newTrades1.add(new BasicTrade(1, new ItemStack(Items.LAPIS_LAZULI), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(new ItemStack(Items.LAPIS_LAZULI), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(1, new ItemStack(Items.BOOK), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(3, new ItemStack(Items.EXPERIENCE_BOTTLE), 16, 2, 0.05f));
			
			List<ITrade> newTrades2 = new ArrayList<>();
			newTrades2.addAll(createBasicTradeList(1000, 10));
		
			List<ITrade> newTrades3 = new ArrayList<>();
			newTrades3.addAll(createBasicTradeList(1000, 20));
			
			List<ITrade> newTrades4 = new ArrayList<>();
			newTrades4.addAll(createBasicTradeList(1000, 30));
			
			List<ITrade> newTrades5 = new ArrayList<>();
			newTrades5.addAll(createBasicTradeList(1000, 40));
			
			trades.put(1, newTrades1);
			trades.put(2, newTrades2);
			trades.put(3, newTrades3);
			trades.put(4, newTrades4);
			trades.put(5, newTrades5);
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	private static BasicTrade enchantedBook(int xp) {
		
		Random rng = new Random();
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

	private static List<BasicTrade> createBasicTradeList(int size, int xp) {
		
		List<BasicTrade> trades = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			trades.add(enchantedBook(xp));
		}
		
		return trades;
		
	}
	
}
