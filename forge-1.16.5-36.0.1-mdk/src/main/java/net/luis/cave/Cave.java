package net.luis.cave;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.luis.cave.init.CaveArmor;
import net.luis.cave.init.CaveBlockItems;
import net.luis.cave.init.CaveBlocks;
import net.luis.cave.init.CaveEnchantment;
import net.luis.cave.init.CaveItems;
import net.luis.cave.init.CaveTools;
import net.luis.cave.villagers.PointOfInterestTypes;
import net.luis.cave.villagers.VillagerUtil;
import net.luis.cave.world.gen.OreGen;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Cave.Mod_Id)
public class Cave {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String Mod_Id = "cave";
	public static final String Minecraft_Id = "minecraft";
	public static boolean enableCommands = true;
	public static final boolean pvpServer = false;
	
	public Cave() {
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		
		CaveBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		CaveBlockItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		CaveItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		CaveItems.VANILLA_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		CaveTools.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		CaveArmor.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		CaveEnchantment.ENCHANTMENT.register(FMLJavaModLoadingContext.get().getModEventBus());
		CaveEnchantment.VANILLA_ENCHANTMENT.register(FMLJavaModLoadingContext.get().getModEventBus());
		
		MinecraftForge.EVENT_BUS.register(this);

	}
	
	private void setup(final FMLCommonSetupEvent event) {
		
		OreGen.registerOres();
		
		VillagerUtil.fixPOITypeBlockStates(PointOfInterestTypes.LUMBERJACK);
		VillagerUtil.fixPOITypeBlockStates(PointOfInterestTypes.MOB_HUNTER);
		VillagerUtil.fixPOITypeBlockStates(PointOfInterestTypes.MINER);
		VillagerUtil.fixPOITypeBlockStates(PointOfInterestTypes.ENCHANTER);
		VillagerUtil.fixPOITypeBlockStates(PointOfInterestTypes.BEEKEEPER);
		VillagerUtil.fixPOITypeBlockStates(PointOfInterestTypes.NETHER_TRADER);
		
	}
	
	private void doClientStuff(FMLClientSetupEvent event) {
		
		RenderTypeLookup.setRenderLayer(CaveBlocks.TINTED_GLASS.get(), RenderType.getTranslucent());
		
	}
	
	public static final ItemGroup BUILDING_BLOCKS = new ItemGroup("blocks") {

		@Override
		public ItemStack createIcon() {
			
			return new ItemStack(Blocks.BRICKS);
			
		}
		
	};

	
	public static final ItemGroup DECORATIONS = new ItemGroup("decorations") {

		@Override
		public ItemStack createIcon() {
			
			return new ItemStack(Blocks.PEONY);
			
		}
		
	};
	
	public static final ItemGroup MISC = new ItemGroup("misc") {

		@Override
		public ItemStack createIcon() {
			
			return new ItemStack(Items.LAVA_BUCKET);
			
		}
		
	};
	
	public static final ItemGroup FOOD = new ItemGroup("food") {

		@Override
		public ItemStack createIcon() {
			
			return new ItemStack(Items.APPLE);
			
		}
		
	};
	
	public static final ItemGroup TOOLS = new ItemGroup("tools") {

		@Override
		public ItemStack createIcon() {
			
			return new ItemStack(Items.IRON_AXE);
			
		}
		
	};
	
	public static final ItemGroup Armor = new ItemGroup("armor") {

		@Override
		public ItemStack createIcon() {
			
			return new ItemStack(Items.CHAINMAIL_CHESTPLATE);
			
		}
		
	};
	
	public static final ItemGroup WEAPONS = new ItemGroup("weapons") {

		@Override
		public ItemStack createIcon() {
			
			return new ItemStack(Items.GOLDEN_SWORD);
			
		}
		
	};

}

