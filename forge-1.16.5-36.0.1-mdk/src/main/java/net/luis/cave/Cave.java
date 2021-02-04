package net.luis.cave;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.luis.cave.api.villager.VillagerUtil;
import net.luis.cave.events.generation.OreGeneration;
import net.luis.cave.init.ModEnchantment;
import net.luis.cave.init.blocks.ModBlockItems;
import net.luis.cave.init.blocks.ModBlocks;
import net.luis.cave.init.blocks.ModVerticalBlockItems;
import net.luis.cave.init.blocks.ModVerticalBlocks;
import net.luis.cave.init.items.ModArmor;
import net.luis.cave.init.items.ModItems;
import net.luis.cave.init.items.ModTools;
import net.luis.cave.init.util.ModContainer;
import net.luis.cave.init.util.ModTileEntityType;
import net.luis.cave.init.villager.ModPointOfInterestTypes;
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
		
		ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModBlockItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModVerticalBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModItems.VANILLA_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModTools.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModTools.VANILLA_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModArmor.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModEnchantment.ENCHANTMENT.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModEnchantment.VANILLA_ENCHANTMENT.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModVerticalBlockItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModTileEntityType.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModContainer.CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
		
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		
		OreGeneration.registerOres();
		
		VillagerUtil.fixPOITypeBlockStates(ModPointOfInterestTypes.LUMBERJACK);
		VillagerUtil.fixPOITypeBlockStates(ModPointOfInterestTypes.MOB_HUNTER);
		VillagerUtil.fixPOITypeBlockStates(ModPointOfInterestTypes.MINER);
		VillagerUtil.fixPOITypeBlockStates(ModPointOfInterestTypes.ENCHANTER);
		VillagerUtil.fixPOITypeBlockStates(ModPointOfInterestTypes.BEEKEEPER);
		VillagerUtil.fixPOITypeBlockStates(ModPointOfInterestTypes.NETHER_TRADER);
		
	}
	
	private void doClientStuff(FMLClientSetupEvent event) {
	
		RenderTypeLookup.setRenderLayer(ModBlocks.TINTED_GLASS.get(), RenderType.getTranslucent());
		
	}
	
	public static final ItemGroup BUILDING_BLOCKS = new ItemGroup("blocks") {

		@Override
		public ItemStack createIcon() {
			
			return new ItemStack(Blocks.BRICKS);
			
		}
		
	};
	
	public static final ItemGroup VERTICAL_SLABS = new ItemGroup("vertical_slabs") {

		@Override
		public ItemStack createIcon() {
			
			return new ItemStack(Blocks.BRICK_SLAB);
			
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

