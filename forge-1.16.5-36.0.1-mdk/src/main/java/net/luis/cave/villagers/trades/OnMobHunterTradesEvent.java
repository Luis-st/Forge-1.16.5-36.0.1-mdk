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
public class OnMobHunterTradesEvent {
	
	@SubscribeEvent
	public static void MobHunterTrades(VillagerTradesEvent event) {
		
		Int2ObjectMap<List<ITrade>> trades = event.getTrades();
		VillagerProfession type = event.getType();
		Random rng = new Random();
		
		if (type == VillagerProfessions.MOB_HUNTER) {
			
			List<ITrade> newTrades1 = new ArrayList<>();
			newTrades1.add(new BasicTrade(new ItemStack(Items.ROTTEN_FLESH, 16), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(new ItemStack(Items.BONE, 8), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(1, new ItemStack(Items.GUNPOWDER, 4), 16, 2, 0.05f));
			newTrades1.add(new BasicTrade(new ItemStack(Items.STRING, 8), new ItemStack(Items.EMERALD), 16, 2, 0.05f));
			
			List<ITrade> newTrades2 = new ArrayList<>();
			newTrades2.add(new BasicTrade(new ItemStack(Items.SPIDER_EYE, 6), new ItemStack(Items.EMERALD), 16, 10, 0.05f));
			newTrades2.add(new BasicTrade(8, new ItemStack(Items.GHAST_TEAR), 16, 10, 0.05f));
			newTrades2.add(new BasicTrade(1, new ItemStack(Items.PRISMARINE_SHARD, 4), 16, 10, 0.05f));
			newTrades2.add(new BasicTrade(1, new ItemStack(Items.PRISMARINE_CRYSTALS, 4), 16, 10, 0.05f));
			
			List<ITrade> newTrades3 = new ArrayList<>();
			newTrades3.add(new BasicTrade(12, new ItemStack(Items.SCUTE), 16, 20, 0.05f));
			newTrades3.add(new BasicTrade(4, new ItemStack(Items.RABBIT_FOOT), 16, 20, 0.05f));
			newTrades3.add(new BasicTrade(4, new ItemStack(Items.SLIME_BALL), 16, 20, 0.05f));
			newTrades3.add(new BasicTrade(new ItemStack(Items.ENDER_PEARL, 5), new ItemStack(Items.EMERALD), 16, 20, 0.05f));
			newTrades3.add(new BasicTrade(new ItemStack(Items.BLAZE_ROD), new ItemStack(Items.EMERALD), 16, 20, 0.05f));
			
			List<ITrade> newTrades4 = new ArrayList<>();
			newTrades4.add(new BasicTrade(5, new ItemStack(Items.MAGMA_CREAM), 16, 30, 0.05f));
			newTrades4.add(new BasicTrade(new ItemStack(Items.PHANTOM_MEMBRANE), new ItemStack(Items.EMERALD), 16, 30, 0.05f));
			newTrades4.add(new BasicTrade(10, new ItemStack(Items.NAUTILUS_SHELL), 16, 30, 0.05f));
			
			List<ITrade> newTrades5 = new ArrayList<>();
			newTrades5.add(new BasicTrade(new ItemStack(Items.WITHER_ROSE), new ItemStack(Items.EMERALD), 16, 40, 0.05f));
			newTrades5.add(new BasicTrade(64, new ItemStack(Items.WITHER_SKELETON_SKULL), 16, 40, 0.05f));
			newTrades5.add(new BasicTrade(56 + rng.nextInt(8), new ItemStack(Items.SHULKER_SHELL), 16, 40, 0.05f));
			newTrades5.add(new BasicTrade(56 + rng.nextInt(8), new ItemStack(Items.TOTEM_OF_UNDYING), 16, 40, 0.05f));
			
			trades.put(1, newTrades1);
			trades.put(2, newTrades2);
			trades.put(3, newTrades3);
			trades.put(4, newTrades4);
			trades.put(5, newTrades5);
			
		}
		
	}
	
}