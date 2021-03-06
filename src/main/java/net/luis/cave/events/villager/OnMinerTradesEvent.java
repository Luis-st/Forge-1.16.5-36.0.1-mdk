package net.luis.cave.events.villager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.luis.cave.Cave;
import net.luis.cave.api.entity.villager.VillagerManager;
import net.luis.cave.init.items.ModItems;
import net.luis.cave.init.villager.ModVillagerProfessions;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.Items;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnMinerTradesEvent {
	
	@SubscribeEvent
	public static void MinerTrades(VillagerTradesEvent event) {
		
		Int2ObjectMap<List<ITrade>> trades = event.getTrades();
		VillagerProfession type = event.getType();
		Random rng = new Random();
		
		if (type == ModVillagerProfessions.MINER.get()) {
			
			List<ITrade> newTrades1 = new ArrayList<>();
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(ModItems.ANDESITE_ALLOY.get(), 5, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.IRON_INGOT, 4, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeEmeraldForItem(1, Items.IRON_INGOT, 2, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.GOLD_INGOT, 3, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeEmeraldForItem(4 + rng.nextInt(2), Items.GOLD_INGOT, 1, true, 1));
			
			List<ITrade> newTrades2 = new ArrayList<>();
			newTrades2.add(VillagerManager.creatTradeItemForEmerald(ModItems.JADE_INGOT.get(), 3, 1, true, 2));
			newTrades2.add(VillagerManager.creatTradeEmeraldForItem(10 + rng.nextInt(3), ModItems.JADE_INGOT.get(), 1, true, 2));
			newTrades2.add(VillagerManager.creatTradeEmeraldForItem(1, Items.LAVA_BUCKET, 1, true, 2));
			newTrades2.add(VillagerManager.creatTradeItemForEmerald(ModItems.LIMONITE_INGOT.get(), 2, 1, true, 2));
			newTrades2.add(VillagerManager.creatTradeEmeraldForItem(16 + rng.nextInt(4), ModItems.LIMONITE_INGOT.get(), 1, true, 2));
			
			List<ITrade> newTrades3 = new ArrayList<>();
			newTrades3.add(VillagerManager.creatTradeItemForEmerald(Items.DIAMOND, 1, 1, true, 3));
			newTrades3.add(VillagerManager.creatTradeEmeraldForItem(32 + rng.nextInt(5), Items.DIAMOND, 1, true, 3));
			newTrades3.add(VillagerManager.creatTradeEmeraldForItem(1, Items.OBSIDIAN, 4, true, 3));
			newTrades3.add(VillagerManager.creatTradeItemForEmerald(ModItems.SAPHIRE_INGOT.get(), 1, 2, true, 3));
			newTrades3.add(VillagerManager.creatTradeEmeraldForItem(40 + rng.nextInt(6), ModItems.SAPHIRE_INGOT.get(), 1, true, 3));
			
			List<ITrade> newTrades4 = new ArrayList<>();
			newTrades4.add(VillagerManager.creatTradeItemForEmerald(ModItems.RUBY.get(), 3, 1, true, 4));
			newTrades4.add(VillagerManager.creatTradeEmeraldForItem(48 + rng.nextInt(7), ModItems.RUBY.get(), 1, true, 4));
			newTrades4.add(VillagerManager.creatTradeEmeraldForItem(1, Items.CRYING_OBSIDIAN, 2, true, 4));
			newTrades4.add(VillagerManager.creatTradeItemForEmerald(ModItems.ROSITE_INGOT.get(), 1, 4, true, 4));
			
			List<ITrade> newTrades5 = new ArrayList<>();
			newTrades5.add(VillagerManager.creatTradeEmeraldForItem(64, ModItems.ROSITE_INGOT.get(), 1, true, 5));
			newTrades5.add(VillagerManager.creatTradeItemForEmerald(Items.NETHERITE_SCRAP, 1, 32 + rng.nextInt(16), true, 5));
			newTrades5.add(VillagerManager.creatTradeItemForEmerald(ModItems.STEEL_INGOT.get(), 1, 48 + rng.nextInt(16), true, 5));
			
			trades.put(1, newTrades1);
			trades.put(2, newTrades2);
			trades.put(3, newTrades3);
			trades.put(4, newTrades4);
			trades.put(5, newTrades5);
			
		}
		
	}
	
}
