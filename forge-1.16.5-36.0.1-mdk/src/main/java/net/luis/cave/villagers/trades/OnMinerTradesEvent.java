package net.luis.cave.villagers.trades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.luis.cave.Cave;
import net.luis.cave.init.CaveItems;
import net.luis.cave.villagers.VillagerProfessions;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnMinerTradesEvent {
	
	@SubscribeEvent
	public static void MinerTrades(VillagerTradesEvent event) {
		
		Int2ObjectMap<List<ITrade>> trades = event.getTrades();
		VillagerProfession type = event.getType();
		Random rng = new Random();
		
		if (type == VillagerProfessions.MINER) {
			
			List<ITrade> newTrades1 = new ArrayList<>();
			newTrades1.add(new BasicTrade(new ItemStack(CaveItems.ANDESITE_ALLOY.get(), 5), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(new ItemStack(Items.IRON_INGOT, 4), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(1, new ItemStack(Items.IRON_INGOT), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(new ItemStack(Items.GOLD_INGOT, 3), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(5 + rng.nextInt(2), new ItemStack(Items.GOLD_INGOT), 16, 2, 0.05f));
			
			List<ITrade> newTrades2 = new ArrayList<>();
			newTrades2.add(new BasicTrade(new ItemStack(CaveItems.JADE_INGOT.get(), 3), new ItemStack(Items.EMERALD), 16, 10, 0.05f));
			newTrades2.add(new BasicTrade(10 + rng.nextInt(3), new ItemStack(CaveItems.JADE_INGOT.get()), 16, 2, 0.05f));
			newTrades2.add(new BasicTrade(1, new ItemStack(Items.LAVA_BUCKET), 16, 10, 0.05f));
			newTrades2.add(new BasicTrade(new ItemStack(CaveItems.LIMONITE_INGOT.get(), 2), new ItemStack(Items.EMERALD), 16, 10, 0.05f));
			newTrades2.add(new BasicTrade(16 + rng.nextInt(4), new ItemStack(CaveItems.LIMONITE_INGOT.get()), 16, 2, 0.05f));
			
			List<ITrade> newTrades3 = new ArrayList<>();
			newTrades3.add(new BasicTrade(new ItemStack(Items.DIAMOND), new ItemStack(Items.EMERALD), 16, 20, 0.05f));
			newTrades3.add(new BasicTrade(32 + rng.nextInt(5), new ItemStack(Items.DIAMOND), 16, 20, 0.05f));
			newTrades3.add(new BasicTrade(1, new ItemStack(Items.OBSIDIAN, 4), 16, 20, 0.05f));
			newTrades3.add(new BasicTrade(new ItemStack(CaveItems.SAPHIRE_INGOT.get()), new ItemStack(Items.EMERALD, 2), 16, 20, 0.05f));
			newTrades3.add(new BasicTrade(40 + rng.nextInt(6), new ItemStack(CaveItems.SAPHIRE_INGOT.get()), 16, 20, 0.05f));
			
			List<ITrade> newTrades4 = new ArrayList<>();
			newTrades4.add(new BasicTrade(new ItemStack(CaveItems.RUBY.get()), new ItemStack(Items.EMERALD, 3), 16, 30, 0.05f));
			newTrades4.add(new BasicTrade(48 + rng.nextInt(7), new ItemStack(CaveItems.RUBY.get()), 16, 30, 0.05f));
			newTrades4.add(new BasicTrade(1, new ItemStack(Items.CRYING_OBSIDIAN, 2), 16, 30, 0.05f));
			newTrades4.add(new BasicTrade(new ItemStack(CaveItems.ROSITE_INGOT.get()), new ItemStack(Items.EMERALD, 4), 16, 30, 0.05f));
			
			List<ITrade> newTrades5 = new ArrayList<>();
			newTrades5.add(new BasicTrade(new ItemStack(Items.NETHERITE_SCRAP), new ItemStack(Items.EMERALD, 32 + rng.nextInt(16)), 16, 40, 0.05f));
			newTrades5.add(new BasicTrade(new ItemStack(CaveItems.STEEL_INGOT.get()), new ItemStack(Items.EMERALD, 48 + rng.nextInt(16)), 16, 40, 0.05f));
			newTrades5.add(new BasicTrade(64, new ItemStack(CaveItems.ROSITE_INGOT.get()), 16, 40, 0.05f));
			
			trades.put(1, newTrades1);
			trades.put(2, newTrades2);
			trades.put(3, newTrades3);
			trades.put(4, newTrades4);
			trades.put(5, newTrades5);
			
		}
		
	}
	
}
