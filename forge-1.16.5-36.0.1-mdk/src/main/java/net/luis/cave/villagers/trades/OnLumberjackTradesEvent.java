package net.luis.cave.villagers.trades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.luis.cave.Cave;
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
public class OnLumberjackTradesEvent {
	
	@SubscribeEvent
	public static void LumberjackTrades(VillagerTradesEvent event) {
		
		Int2ObjectMap<List<ITrade>> trades = event.getTrades();
		VillagerProfession type = event.getType();
		Random rng = new Random();
		
		if (type == VillagerProfessions.LUMBERJACK) {
			
			List<ITrade> newTrades1 = new ArrayList<>();
			newTrades1.add(new BasicTrade(new ItemStack(Items.STICK, 32 - rng.nextInt(16)), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(1, new ItemStack(Items.APPLE, 4), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(new ItemStack(Items.OAK_SAPLING, 8), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(1, new ItemStack(Items.OAK_LOG, 8), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(new ItemStack(Items.OAK_LOG, 8), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			
			List<ITrade> newTrades2 = new ArrayList<>();
			newTrades2.add(new BasicTrade(new ItemStack(Items.STICK, 16), new ItemStack(Items.EMERALD), 16, 10, 0.05f));
			newTrades2.add(new BasicTrade(new ItemStack(Items.BIRCH_SAPLING, 8), new ItemStack(Items.EMERALD), 16, 10, 0.05f));
			newTrades2.add(new BasicTrade(1, new ItemStack(Items.BIRCH_LOG, 8), 16, 10, 0.05f));
			newTrades2.add(new BasicTrade(new ItemStack(Items.BIRCH_LOG, 8), new ItemStack(Items.EMERALD), 16, 10, 0.05f));
			
			List<ITrade> newTrades3 = new ArrayList<>();
			newTrades3.add(new BasicTrade(new ItemStack(Items.SPRUCE_SAPLING, 8), new ItemStack(Items.EMERALD), 16, 20, 0.05f));
			newTrades3.add(new BasicTrade(1, new ItemStack(Items.SPRUCE_LOG, 8), 16, 20, 0.05f));
			newTrades3.add(new BasicTrade(new ItemStack(Items.SPRUCE_LOG, 8), new ItemStack(Items.EMERALD), 16, 20, 0.05f));
			newTrades3.add(new BasicTrade(new ItemStack(Items.DARK_OAK_SAPLING, 8), new ItemStack(Items.EMERALD), 16, 20, 0.05f));
			newTrades3.add(new BasicTrade(1, new ItemStack(Items.DARK_OAK_LOG, 8), 16, 20, 0.05f));
			newTrades3.add(new BasicTrade(new ItemStack(Items.DARK_OAK_LOG, 8), new ItemStack(Items.EMERALD), 16, 20, 0.05f));
			
			List<ITrade> newTrades4 = new ArrayList<>();
			newTrades4.add(new BasicTrade(new ItemStack(Items.ACACIA_SAPLING, 8), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
			newTrades4.add(new BasicTrade(1, new ItemStack(Items.ACACIA_LOG, 8), 16, 30, 0.05f));
			newTrades4.add(new BasicTrade(new ItemStack(Items.ACACIA_LOG, 8), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
			newTrades4.add(new BasicTrade(new ItemStack(Items.JUNGLE_SAPLING, 8), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
			newTrades4.add(new BasicTrade(1, new ItemStack(Items.JUNGLE_LOG, 8), 16, 30, 0.05f));
			newTrades4.add(new BasicTrade(new ItemStack(Items.JUNGLE_LOG, 8), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
			
			List<ITrade> newTrades5 = new ArrayList<>();
			newTrades5.add(new BasicTrade(new ItemStack(Items.CRIMSON_FUNGUS, 8), new ItemStack(Items.EMERALD), 16, 40, 0.05f));
			newTrades5.add(new BasicTrade(1, new ItemStack(Items.CRIMSON_STEM, 8), 16, 40, 0.05f));
			newTrades5.add(new BasicTrade(new ItemStack(Items.CRIMSON_STEM, 8), new ItemStack(Items.EMERALD), 16, 40, 0.05f));
			newTrades5.add(new BasicTrade(new ItemStack(Items.WARPED_FUNGUS, 8), new ItemStack(Items.EMERALD), 16, 40, 0.05f));
			newTrades5.add(new BasicTrade(1, new ItemStack(Items.WARPED_STEM, 8), 16, 40, 0.05f));
			newTrades5.add(new BasicTrade(new ItemStack(Items.WARPED_STEM, 8), new ItemStack(Items.EMERALD), 16, 40, 0.05f));
			
			trades.put(1, newTrades1);
			trades.put(2, newTrades2);
			trades.put(3, newTrades3);
			trades.put(4, newTrades4);
			trades.put(5, newTrades5);
			
		}
	
	}
	
}
