package net.luis.cave.events.villager;

import java.util.List;
import java.util.Random;

import net.luis.cave.Cave;
import net.luis.cave.api.manager.VillagerManager;
import net.luis.cave.init.items.ModArmor;
import net.luis.cave.init.items.ModTools;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades.ITrade;
import net.minecraft.item.Items;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnVillagerTradesEvent {
	
	@SubscribeEvent
	public static void VillagerTradesTest(VillagerTradesEvent event) {
		
		List<ITrade> trade1 = event.getTrades().get(1);
		List<ITrade> trade2 = event.getTrades().get(2);
		List<ITrade> trade3 = event.getTrades().get(3);
		List<ITrade> trade4 = event.getTrades().get(4);
		List<ITrade> trade5 = event.getTrades().get(5);
		VillagerProfession type = event.getType();
		
		if (type == VillagerProfession.BUTCHER) {
			
			trade1.add(VillagerManager.creatTradeItemForEmerald(Items.COOKED_CHICKEN, 14, 1, true, 1));
			trade1.add(VillagerManager.creatTradeItemForEmerald(Items.COOKED_PORKCHOP, 7, 1, true, 1));
			trade1.add(VillagerManager.creatTradeItemForEmerald(Items.COOKED_RABBIT, 4, 1, true, 1));
			
			trade3.add(VillagerManager.creatTradeItemForEmerald(Items.MUTTON, 7, 1, true, 3));
			trade3.add(VillagerManager.creatTradeItemForEmerald(Items.COOKED_MUTTON, 7, 1, true, 3));
			trade3.add(VillagerManager.creatTradeEmeraldForItem(1, Items.COOKED_MUTTON, 4, false, 3));
			trade3.add(VillagerManager.creatTradeEmeraldForItem(1, Items.BEEF, 5, true, 3));
			trade3.add(VillagerManager.creatTradeItemForEmerald(Items.COOKED_BEEF, 7, 1, true, 3));
			trade3.add(VillagerManager.creatTradeEmeraldForItem(1, Items.BEEF, 5, true, 3));
			
		} else if (type == VillagerProfession.LIBRARIAN) {
			
			trade3.add(VillagerManager.creatTradeEmeraldForItem(1, Items.INK_SAC, 3, true, 3));
			trade3.add(VillagerManager.creatTradeItemForEmerald(Items.GLASS, 8, 1, true, 3));
			
			trade4.add(VillagerManager.creatTradeItemForEmerald(Items.CLOCK, 2, 1, true, 4));
			trade4.add(VillagerManager.creatTradeItemForEmerald(Items.COMPASS, 2, 1, true, 4));
			
			trade5.addAll(VillagerManager.creatTradeEmeraldForEnchantedBookList(1000, 5));
			
		} else if (type == VillagerProfession.ARMORER) {
			
			trade1.add(VillagerManager.creatTradeEmeraldForItem(1, Items.COAL, 8, true, 1));
			
			trade2.add(VillagerManager.creatTradeEmeraldForItem(1, Items.IRON_INGOT, 2, true, 2));
			
			trade3.add(VillagerManager.creatTradeEmeraldForItem(7, ModTools.IRON_SHIELD.get(), 1, false, 3));
			trade3.add(VillagerManager.creatTradeEmeraldForItem(7, ModTools.DIAMOND_SHIELD.get(), 1, false, 3));
			
			trade4.add(VillagerManager.creatTradeEmeraldForItem(36, ModArmor.SAPHIRE_LEGGINS.get(), 1, false, 4));
			trade4.add(VillagerManager.creatTradeEmeraldForItem(30, ModArmor.SAPHIRE_BOOTS.get(), 1, false, 4));
			
			trade5.add(VillagerManager.creatTradeEmeraldForItem(38, ModArmor.SAPHIRE_CHESTPLATE.get(), 1, false, 5));
			trade5.add(VillagerManager.creatTradeEmeraldForItem(30, ModArmor.SAPHIRE_HELMET.get(), 1, false, 5));
			
		} else if (type == VillagerProfession.TOOLSMITH) {
			
			trade1.add(VillagerManager.creatTradeEmeraldForItem(1, Items.COAL, 8, true, 1));
			trade1.add(VillagerManager.creatTradeEmeraldForItem(3, Items.IRON_AXE, 1, true, 1));
			trade1.add(VillagerManager.creatTradeEmeraldForItem(3, Items.IRON_SHOVEL, 1, true, 1));
			trade1.add(VillagerManager.creatTradeEmeraldForItem(3, Items.IRON_PICKAXE, 1, true, 1));
			trade1.add(VillagerManager.creatTradeEmeraldForItem(3, Items.IRON_HOE, 1, true, 1));
			
			trade2.add(VillagerManager.creatTradeEmeraldForItem(1, Items.IRON_INGOT, 2, true, 2));
			
			trade3.add(VillagerManager.creatTradeEmeraldForItem(6, Items.DIAMOND, 1, true, 3));
			
			trade4.add(VillagerManager.creatTradeEmeraldForItem(32, ModTools.LIMONITE_AXE.get(), 1, false, 4));
			trade4.add(VillagerManager.creatTradeEmeraldForItem(30, ModTools.LIMONITE_SHOVEL.get(), 1, false, 4));
			trade4.add(VillagerManager.creatTradeEmeraldForItem(24, ModTools.LIMONITE_HOE.get(), 1, true, 4));
			
			trade5.add(VillagerManager.creatTradeEmeraldForItem(35, ModTools.LIMONITE_PICKAXE.get(), 1, false, 5));
			
		} else if (type == VillagerProfession.CLERIC) {
			
			trade1.add(VillagerManager.creatTradeItemForEmerald(Items.REDSTONE, 4, 1, true, 1));
			
			trade2.add(VillagerManager.creatTradeItemForEmerald(Items.LAPIS_LAZULI, 2, 1, true, 2));
			
			trade4.add(VillagerManager.creatTradeEmeraldForItem(16, Items.SCUTE, 1, true, 4));
			trade4.add(VillagerManager.creatTradeEmeraldForItem(1, Items.GLASS_BOTTLE, 6, true, 4));
			
			trade5.add(VillagerManager.creatTradeEmeraldForItem(7, Items.BLAZE_ROD, 1, true, 5));
			
		} else if (type == VillagerProfession.FLETCHER) {
			
			Random rng = new Random();
			
			trade1.add(VillagerManager.creatTradeItemForEmerald(Items.STICK, 32 - rng.nextInt(16), 1, true, 1));
			trade1.add(VillagerManager.creatTradeItemForEmerald(Items.ARROW, 8 + rng.nextInt(8), 1, true, 1));
			
			trade4.add(VillagerManager.creatTradeEmeraldAndArrowForTippedArrow(4, 5, 4));
			
			trade5.add(VillagerManager.creatTradeEmeraldAndArrowForTippedArrow(2, 5, 5));
			
		} else if (type == VillagerProfession.WEAPONSMITH) {
			
			trade1.add(VillagerManager.creatTradeEmeraldForItem(1, Items.COAL, 8, true, 1));
			
			trade2.add(VillagerManager.creatTradeEmeraldForItem(1, Items.IRON_INGOT, 2, true, 2));

			trade5.add(VillagerManager.creatTradeEmeraldForItem(33, ModTools.BLAZING_SWORD.get(), 1, false, 5));
			trade5.add(VillagerManager.creatTradeEmeraldForItem(23, ModTools.SAPHIRE_SWORD.get(), 1, false, 5));
			
		}
		
	}
	
}
