package net.luis.cave.events.village;

import java.util.ArrayList;
import java.util.List;

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
public class OnEnchanterTradesEvent {
	
	@SubscribeEvent
	public static void EnchanterTrades(VillagerTradesEvent event) {
		
		Int2ObjectMap<List<ITrade>> trades = event.getTrades();
		VillagerProfession type = event.getType();
		
		if (type == ModVillagerProfessions.ENCHANTER.get()) {
			
			List<ITrade> newTrades1 = new ArrayList<>();
			newTrades1.add(VillagerManager.creatTradeEmeraldForItem(1, Items.LAPIS_LAZULI, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.LAPIS_LAZULI, 1, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeEmeraldForItem(1, Items.BOOK, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeEmeraldForItem(3, Items.EXPERIENCE_BOTTLE, 1, true, 1));
			
			List<ITrade> newTrades2 = new ArrayList<>();
			newTrades2.addAll(VillagerManager.creatTradeEmeraldForEnchantedBookList(1000, 2));
		
			List<ITrade> newTrades3 = new ArrayList<>();
			newTrades3.addAll(VillagerManager.creatTradeEmeraldForEnchantedBookList(1000, 3));
			
			List<ITrade> newTrades4 = new ArrayList<>();
			newTrades4.addAll(VillagerManager.creatTradeEmeraldForEnchantedBookList(1000, 4));
			
			List<ITrade> newTrades5 = new ArrayList<>();
			newTrades5.addAll(VillagerManager.creatTradeEmeraldForEnchantedBookList(1000, 5));
			
			trades.put(1, newTrades1);
			trades.put(2, newTrades2);
			trades.put(3, newTrades3);
			trades.put(4, newTrades4);
			trades.put(5, newTrades5);
			
		}
		
	}
	
}
