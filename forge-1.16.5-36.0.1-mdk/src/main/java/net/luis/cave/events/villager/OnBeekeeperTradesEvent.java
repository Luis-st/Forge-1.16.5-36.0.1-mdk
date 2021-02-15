package net.luis.cave.events.villager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.luis.cave.Cave;
import net.luis.cave.api.entity.villager.VillagerManager;
import net.luis.cave.init.villager.ModVillagerProfessions;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.Items;
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
		
		if (type == ModVillagerProfessions.BEEKEEPER.get()) {
			
			List<ITrade> newTrades1 = new ArrayList<>();
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.PINK_TULIP, 10, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.WHITE_TULIP, 10, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.ORANGE_TULIP, 10, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.DANDELION, 10, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.POPPY, 10, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.OXEYE_DAISY, 10, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.AZURE_BLUET, 10, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.CORNFLOWER, 10, 1, true, 1));
			
			List<ITrade> newTrades2 = new ArrayList<>();
			newTrades2.add(VillagerManager.creatTradeItemForEmerald(Items.SUNFLOWER, 5, 1, true, 2));
			newTrades2.add(VillagerManager.creatTradeItemForEmerald(Items.LILAC, 5, 1, true, 2));
			newTrades2.add(VillagerManager.creatTradeItemForEmerald(Items.ROSE_BUSH, 5, 1, true, 2));
			newTrades2.add(VillagerManager.creatTradeItemForEmerald(Items.PEONY, 5, 1, true, 2));
			newTrades2.add(VillagerManager.creatTradeItemForEmerald(Items.ALLIUM, 5, 1, true, 2));
		
			List<ITrade> newTrades3 = new ArrayList<>();
			newTrades3.add(VillagerManager.creatTradeItemForEmerald(Items.BLUE_ORCHID, 3, 1, true, 3));
			newTrades3.add(VillagerManager.creatTradeItemForEmerald(Items.LILY_OF_THE_VALLEY, 3, 1, true, 3));
			newTrades3.add(VillagerManager.creatTradeEmeraldForItem(4, Items.HONEYCOMB, 1, true, 3));
			
			List<ITrade> newTrades4 = new ArrayList<>();
			newTrades4.add(VillagerManager.creatTradeItemForEmerald(Items.HONEY_BOTTLE, 1, 4 + rng.nextInt(2), true, 4));
			
			List<ITrade> newTrades5 = new ArrayList<>();
			newTrades5.add(VillagerManager.creatTradeEmeraldForItem(16 - rng.nextInt(3), Items.HONEY_BLOCK, 1, true, 5));
			
			trades.put(1, newTrades1);
			trades.put(2, newTrades2);
			trades.put(3, newTrades3);
			trades.put(4, newTrades4);
			trades.put(5, newTrades5);
			
		}
		
	}
	
}
