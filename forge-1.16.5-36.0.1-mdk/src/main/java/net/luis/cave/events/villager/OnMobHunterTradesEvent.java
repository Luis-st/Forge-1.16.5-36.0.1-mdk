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
public class OnMobHunterTradesEvent {
	
	@SubscribeEvent
	public static void MobHunterTrades(VillagerTradesEvent event) {
		
		Int2ObjectMap<List<ITrade>> trades = event.getTrades();
		VillagerProfession type = event.getType();
		Random rng = new Random();
		
		if (type == ModVillagerProfessions.MOB_HUNTER.get()) {
			
			List<ITrade> newTrades1 = new ArrayList<>();
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.ROTTEN_FLESH, 16, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.BONE, 8, 1, true, 1));
			newTrades1.add(VillagerManager.creatTradeEmeraldForItem(1, Items.GUNPOWDER, 4, true, 1));
			newTrades1.add(VillagerManager.creatTradeItemForEmerald(Items.STRING, 8, 1, true, 1));
			
			List<ITrade> newTrades2 = new ArrayList<>();
			newTrades2.add(VillagerManager.creatTradeItemForEmerald(Items.SPIDER_EYE, 6, 1, true, 2));
			newTrades2.add(VillagerManager.creatTradeEmeraldForItem(8, Items.GHAST_TEAR, 1, true, 2));
			newTrades2.add(VillagerManager.creatTradeEmeraldForItem(1, Items.PRISMARINE_SHARD, 4, true, 2));
			newTrades2.add(VillagerManager.creatTradeEmeraldForItem(1, Items.PRISMARINE_CRYSTALS, 4, true, 2));
			
			List<ITrade> newTrades3 = new ArrayList<>();
			newTrades3.add(VillagerManager.creatTradeEmeraldForItem(12, Items.SCUTE, 1, true, 3));
			newTrades3.add(VillagerManager.creatTradeEmeraldForItem(4, Items.RABBIT_FOOT, 1, true, 3));
			newTrades3.add(VillagerManager.creatTradeEmeraldForItem(4, Items.SLIME_BALL, 1, true, 3));
			newTrades3.add(VillagerManager.creatTradeItemForEmerald(Items.ENDER_PEARL, 5, 1, true, 3));
			newTrades3.add(VillagerManager.creatTradeItemForEmerald(Items.BLAZE_ROD, 1, 1, true, 3));
			
			List<ITrade> newTrades4 = new ArrayList<>();
			newTrades4.add(VillagerManager.creatTradeEmeraldForItem(5, Items.MAGMA_CREAM, 1, true, 4));
			newTrades4.add(VillagerManager.creatTradeItemForEmerald(Items.PHANTOM_MEMBRANE, 1, 1, true, 4));
			newTrades4.add(VillagerManager.creatTradeEmeraldForItem(10, Items.NAUTILUS_SHELL, 1, true, 4));
			
			List<ITrade> newTrades5 = new ArrayList<>();
			newTrades5.add(VillagerManager.creatTradeItemForEmerald(Items.WITHER_ROSE, 1, 1, true, 5));
			newTrades4.add(VillagerManager.creatTradeEmeraldForItem(64 - rng.nextInt(4), Items.SKELETON_SKULL, 1, true, 5));
			newTrades4.add(VillagerManager.creatTradeEmeraldForItem(64 - rng.nextInt(4), Items.CREEPER_HEAD, 1, true, 5));
			newTrades4.add(VillagerManager.creatTradeEmeraldForItem(64 - rng.nextInt(4), Items.ZOMBIE_HEAD, 1, true, 5));
			newTrades4.add(VillagerManager.creatTradeEmeraldForItem(56 + rng.nextInt(8), Items.TOTEM_OF_UNDYING, 1, true, 5));
			
			trades.put(1, newTrades1);
			trades.put(2, newTrades2);
			trades.put(3, newTrades3);
			trades.put(4, newTrades4);
			trades.put(5, newTrades5);
			
		}
		
	}
	
}
