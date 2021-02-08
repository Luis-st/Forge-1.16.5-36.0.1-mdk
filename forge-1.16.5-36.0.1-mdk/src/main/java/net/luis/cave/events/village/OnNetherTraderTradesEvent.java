package net.luis.cave.events.village;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.luis.cave.Cave;
import net.luis.cave.api.lib.VillagerManager;
import net.luis.cave.init.villager.ModVillagerProfessions;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.Items;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnNetherTraderTradesEvent {
	
	@SubscribeEvent
	public static void EnchanterTrades(VillagerTradesEvent event) {
		
		Int2ObjectMap<List<ITrade>> trades = event.getTrades();
		VillagerProfession type = event.getType();
		Random rng = new Random();
		
		if (type == ModVillagerProfessions.NETHER_TRADER.get()) {
			
			List<ITrade> newTrades1 = new ArrayList<>();
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.NETHERRACK, 64 - rng.nextInt(32), 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.BASALT, 32 - rng.nextInt(16), 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.BLACKSTONE, 32 - rng.nextInt(16), 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeEmeraldForItem(1, Items.SOUL_SAND, 16, true, 1));
			newTrades1.add(VillagerManager.creatTradeEmeraldForItem(1, Items.SOUL_SOIL, 16, true, 1));
			
			List<ITrade> newTrades2 = new ArrayList<>();
			newTrades2.add(VillagerManager.creatTradeEmeraldForItem(1, Items.NETHER_BRICKS, 4, true, 2));
			newTrades2.add(VillagerManager.creatTradeItemForEmerald(Items.NETHER_BRICK, 16 - rng.nextInt(8), 1, true, 2));
			newTrades2.add(VillagerManager.creatTradeEmeraldForItem(1, Items.QUARTZ, 2, true, 2));
		
			List<ITrade> newTrades3 = new ArrayList<>();
			newTrades3.add(VillagerManager.creatTradeItemForEmerald(Items.OBSIDIAN, 4 -rng.nextInt(1), 1, true, 3));
			newTrades3.add(VillagerManager.creatTradeEmeraldForItem(1, Items.CRYING_OBSIDIAN, 4, true, 3));
			newTrades3.add(VillagerManager.creatTradeItemForEmerald(Items.GOLDEN_CARROT, 1, 1, true, 3));
			newTrades3.add(VillagerManager.creatTradeEmeraldForItem(2, Items.GLISTERING_MELON_SLICE, 1, true, 3));
			newTrades3.add(VillagerManager.creatTradeEmeraldForItem(2, Items.FERMENTED_SPIDER_EYE, 1, true, 3));
			
			List<ITrade> newTrades4 = new ArrayList<>();
			newTrades4.add(VillagerManager.creatTradeEmeraldForItem(8, Items.GHAST_TEAR, 1, true, 4));
			newTrades4.add(VillagerManager.creatTradeItemForEmerald(Items.NETHER_WART, 8 - rng.nextInt(2), 1, true, 4));
			newTrades4.add(VillagerManager.creatTradeEmeraldForItem(6, Items.MAGMA_CREAM, 1, true, 4));
			
			List<ITrade> newTrades5 = new ArrayList<>();
			newTrades5.add(VillagerManager.creatTradeEmeraldForItem(24 + rng.nextInt(8), Items.MUSIC_DISC_PIGSTEP, 1, true, 5));
			newTrades5.addAll(VillagerManager.creatTradeEmeraldAndWaterBottleForPotionList(100, 10, 5));
			newTrades5.addAll(VillagerManager.creatTradeEmeraldAndWaterBottleForPotionList(100, 10, 5));
			newTrades5.add(VillagerManager.creatTradeEmeraldForItem(64 - rng.nextInt(8), Items.WITHER_SKELETON_SKULL, 1, true, 5));
			
			trades.put(1, newTrades1);
			trades.put(2, newTrades2);
			trades.put(3, newTrades3);
			trades.put(4, newTrades4);
			trades.put(5, newTrades5);
			
		}
		
	}
	
}
