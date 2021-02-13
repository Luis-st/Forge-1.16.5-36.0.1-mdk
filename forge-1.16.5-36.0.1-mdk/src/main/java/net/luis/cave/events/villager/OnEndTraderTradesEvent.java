package net.luis.cave.events.villager;

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
public class OnEndTraderTradesEvent {
	
	@SubscribeEvent
	public static void EnchanterTrades(VillagerTradesEvent event) {
		
		Int2ObjectMap<List<ITrade>> trades = event.getTrades();
		VillagerProfession type = event.getType();
		Random rng = new Random();
		
		if (type == ModVillagerProfessions.END_TRADER.get()) {
			
			List<ITrade> newTrades1 = new ArrayList<>();
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.END_STONE, 12, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.MAGENTA_STAINED_GLASS, 8, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeEmeraldForItem(4, Items.CHORUS_FLOWER, 1, true, 1));
			
			List<ITrade> newTrades2 = new ArrayList<>();
			newTrades2.add(VillagerManager.creatTradeItemForEmerald(Items.END_STONE_BRICKS, 2, 1, true, 2));
			newTrades2.add(VillagerManager.creatTradeEmeraldForItem(1, Items.PURPUR_BLOCK, 4, true, 2));
			newTrades2.add(VillagerManager.creatTradeEmeraldForItem(4, Items.FIREWORK_ROCKET, 1, true, 2));
		
			List<ITrade> newTrades3 = new ArrayList<>();
			newTrades3.add(VillagerManager.creatTradeItemForEmerald(Items.CHORUS_FRUIT, 8, 1, true, 3));
			newTrades3.add(VillagerManager.creatTradeItemForEmerald(Items.DRAGON_BREATH, 1, 4, true, 3));
			newTrades3.add(VillagerManager.creatTradeEmeraldForItem(1, Items.POPPED_CHORUS_FRUIT, 8, true, 3));
			
			List<ITrade> newTrades4 = new ArrayList<>();
			newTrades4.add(VillagerManager.creatTradeItemForEmerald(Items.ENDER_PEARL, 4, 1, true, 4));
			newTrades4.add(VillagerManager.creatTradeEmeraldForItem(8, Items.ENDER_EYE, 1, true, 4));
			newTrades4.add(VillagerManager.creatTradeEmeraldForItem(8, Items.OBSIDIAN, 8, true, 4));
			
			List<ITrade> newTrades5 = new ArrayList<>();
			newTrades5.add(VillagerManager.creatTradeEmeraldForItem(48 + rng.nextInt(8 + rng.nextInt(8)), Items.SHULKER_SHELL, 1, true, 5));
			
			trades.put(1, newTrades1);
			trades.put(2, newTrades2);
			trades.put(3, newTrades3);
			trades.put(4, newTrades4);
			trades.put(5, newTrades5);
			
		}
		
	}
	
}
