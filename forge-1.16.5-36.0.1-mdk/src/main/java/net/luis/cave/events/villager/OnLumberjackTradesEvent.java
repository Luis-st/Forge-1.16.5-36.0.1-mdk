package net.luis.cave.events.villager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.luis.cave.Cave;
import net.luis.cave.api.manager.VillagerManager;
import net.luis.cave.init.villager.ModVillagerProfessions;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.Items;
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
		
		if (type == ModVillagerProfessions.LUMBERJACK.get()) {
			
			List<ITrade> newTrades1 = new ArrayList<>();
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.STICK, 32 - rng.nextInt(16), 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeEmeraldForItem(1, Items.APPLE, 4, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.OAK_SAPLING, 8, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeEmeraldForItem(1, Items.OAK_LOG, 8, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.OAK_LOG, 8, 1, true, 1));
			
			List<ITrade> newTrades2 = new ArrayList<>();
			newTrades2.add(VillagerManager.creatTradeItemForEmerald(Items.STICK, 16, 1, true, 2));
			newTrades2.add(VillagerManager.creatTradeItemForEmerald(Items.BIRCH_SAPLING, 8, 1, true, 2));
			newTrades2.add(VillagerManager.creatTradeEmeraldForItem(1, Items.BIRCH_LOG, 8, true, 2));
			newTrades2.add(VillagerManager.creatTradeItemForEmerald(Items.BIRCH_LOG, 8, 1, true, 2));
			
			List<ITrade> newTrades3 = new ArrayList<>();
			newTrades3.add(VillagerManager.creatTradeItemForEmerald(Items.SPRUCE_SAPLING, 8, 1, true, 3));
			newTrades3.add(VillagerManager.creatTradeEmeraldForItem(1, Items.SPRUCE_LOG, 8, true, 3));
			newTrades3.add(VillagerManager.creatTradeItemForEmerald(Items.SPRUCE_LOG, 8, 1, true, 3));
			newTrades3.add(VillagerManager.creatTradeItemForEmerald(Items.DARK_OAK_SAPLING, 8, 1, true, 3));
			newTrades3.add(VillagerManager.creatTradeEmeraldForItem(1, Items.DARK_OAK_LOG, 8, true, 3));
			newTrades3.add(VillagerManager.creatTradeItemForEmerald(Items.DARK_OAK_LOG, 8, 1, true, 3));
			
			List<ITrade> newTrades4 = new ArrayList<>();
			newTrades4.add(VillagerManager.creatTradeItemForEmerald(Items.ACACIA_SAPLING, 8, 1, true, 4));
			newTrades4.add(VillagerManager.creatTradeEmeraldForItem(1, Items.ACACIA_LOG, 8, true, 4));
			newTrades4.add(VillagerManager.creatTradeItemForEmerald(Items.ACACIA_LOG, 8, 1, true, 4));
			newTrades4.add(VillagerManager.creatTradeItemForEmerald(Items.JUNGLE_SAPLING, 8, 1, true, 4));
			newTrades4.add(VillagerManager.creatTradeEmeraldForItem(1, Items.JUNGLE_LOG, 8, true, 4));
			newTrades4.add(VillagerManager.creatTradeItemForEmerald(Items.JUNGLE_LOG, 8, 1, true, 4));
			
			List<ITrade> newTrades5 = new ArrayList<>();
			newTrades5.add(VillagerManager.creatTradeItemForEmerald(Items.CRIMSON_FUNGUS, 8, 1, true, 5));
			newTrades5.add(VillagerManager.creatTradeEmeraldForItem(1, Items.CRIMSON_STEM, 8, true, 5));
			newTrades5.add(VillagerManager.creatTradeItemForEmerald(Items.CRIMSON_STEM, 8, 1, true, 5));
			newTrades5.add(VillagerManager.creatTradeItemForEmerald(Items.WARPED_FUNGUS, 8, 1, true, 5));
			newTrades5.add(VillagerManager.creatTradeEmeraldForItem(1, Items.WARPED_STEM, 8, true, 5));
			newTrades5.add(VillagerManager.creatTradeItemForEmerald(Items.WARPED_STEM, 8, 1, true, 5));
			
			trades.put(1, newTrades1);
			trades.put(2, newTrades2);
			trades.put(3, newTrades3);
			trades.put(4, newTrades4);
			trades.put(5, newTrades5);
			
		}
	
	}
	
}
