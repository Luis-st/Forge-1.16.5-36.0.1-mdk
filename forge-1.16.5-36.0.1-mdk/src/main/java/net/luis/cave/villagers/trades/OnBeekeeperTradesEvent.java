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
public class OnBeekeeperTradesEvent {
	
	@SubscribeEvent
	public static void BeekeeperTrades(VillagerTradesEvent event) {
		
		Int2ObjectMap<List<ITrade>> trades = event.getTrades();
		VillagerProfession type = event.getType();
		Random rng = new Random();
		
		if (type == VillagerProfessions.BEEKEEPER) {
			
			List<ITrade> newTrades1 = new ArrayList<>();
			newTrades1.add(new BasicTrade(new ItemStack(Items.PINK_TULIP, 10), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(new ItemStack(Items.WHITE_TULIP, 10), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(new ItemStack(Items.ORANGE_TULIP, 10), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(new ItemStack(Items.DANDELION, 10), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(new ItemStack(Items.POPPY, 10), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(new ItemStack(Items.OXEYE_DAISY, 10), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(new ItemStack(Items.AZURE_BLUET, 10), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(new ItemStack(Items.CORNFLOWER, 10), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			
			List<ITrade> newTrades2 = new ArrayList<>();
			newTrades2.add(new BasicTrade(new ItemStack(Items.SUNFLOWER, 5), new ItemStack(Items.EMERALD), 16, 10, 0.05f));
			newTrades2.add(new BasicTrade(new ItemStack(Items.LILAC, 5), new ItemStack(Items.EMERALD), 16, 10, 0.05f));
			newTrades2.add(new BasicTrade(new ItemStack(Items.ROSE_BUSH, 5), new ItemStack(Items.EMERALD), 16, 10, 0.05f));
			newTrades2.add(new BasicTrade(new ItemStack(Items.PEONY, 5), new ItemStack(Items.EMERALD), 16, 10, 0.05f));
			newTrades2.add(new BasicTrade(new ItemStack(Items.ALLIUM, 5), new ItemStack(Items.EMERALD), 16, 10, 0.05f));
		
			List<ITrade> newTrades3 = new ArrayList<>();
			newTrades3.add(new BasicTrade(new ItemStack(Items.BLUE_ORCHID, 5), new ItemStack(Items.EMERALD), 16, 20, 0.05f));
			newTrades3.add(new BasicTrade(new ItemStack(Items.LILY_OF_THE_VALLEY, 5), new ItemStack(Items.EMERALD), 16, 20, 0.05f));
			newTrades3.add(new BasicTrade(4, new ItemStack(Items.HONEYCOMB), 16, 20, 0.05f));
			
			List<ITrade> newTrades4 = new ArrayList<>();
			newTrades4.add(new BasicTrade(new ItemStack(Items.HONEY_BOTTLE), new ItemStack(Items.EMERALD, 4 + rng.nextInt(2)), 16, 30, 0.05f));
			
			List<ITrade> newTrades5 = new ArrayList<>();
			newTrades5.add(new BasicTrade(16 - rng.nextInt(2), new ItemStack(Items.HONEY_BLOCK), 16, 20, 0.05f));
			
			trades.put(1, newTrades1);
			trades.put(2, newTrades2);
			trades.put(3, newTrades3);
			trades.put(4, newTrades4);
			trades.put(5, newTrades5);
			
		}
		
	}
	
}
