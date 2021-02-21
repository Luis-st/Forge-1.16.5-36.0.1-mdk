package net.luis.cave;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.luis.cave.api.capability.IModItemHandler;
import net.luis.cave.events.generation.OreGeneration;
import net.luis.cave.init.ModEnchantment;
import net.luis.cave.init.ModEntityType;
import net.luis.cave.init.ModCapability.Factory;
import net.luis.cave.init.ModCapability.Storage;
import net.luis.cave.init.blocks.ModBlockItems;
import net.luis.cave.init.blocks.ModBlocks;
import net.luis.cave.init.blocks.ModVerticalBlockItems;
import net.luis.cave.init.blocks.ModVerticalBlocks;
import net.luis.cave.init.blocks.VanillaBlockItems;
import net.luis.cave.init.blocks.VanillaBlocks;
import net.luis.cave.init.items.ModArmor;
import net.luis.cave.init.items.ModItems;
import net.luis.cave.init.items.ModTools;
import net.luis.cave.init.items.VanillaItems;
import net.luis.cave.init.util.ModContainerType;
import net.luis.cave.init.util.ModRecipeSerializer;
import net.luis.cave.init.util.ModTileEntityType;
import net.luis.cave.init.villager.ModPointOfInterestTypes;
import net.luis.cave.init.villager.ModVillagerProfessions;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.IEventBus;
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
		
		LOGGER.info("Mod found: " + Mod_Id);
		LOGGER.info("Initialization has started");
		LOGGER.info("Override of vanilla elements found");
		LOGGER.warn("Initialization was stopped");
		LOGGER.info("The initialization was started again. Overrides of vanilla elements have been considered");
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ModBlocks.BLOCKS.register(modEventBus);
		ModBlockItems.ITEMS.register(modEventBus);
		VanillaBlocks.VANILLA_BLOCKS.register(modEventBus);
		VanillaBlockItems.ITEMS.register(modEventBus);
		LOGGER.info("Blocks were successfully initialized");
		
		ModVerticalBlocks.BLOCKS.register(modEventBus);
		ModVerticalBlockItems.ITEMS.register(modEventBus);
		LOGGER.info("Vertical slabs were successfully initialized");
		
		ModItems.ITEMS.register(modEventBus);
		VanillaItems.VANILLA_ITEMS.register(modEventBus);
		ModTools.ITEMS.register(modEventBus);
		ModArmor.ITEMS.register(modEventBus);
		LOGGER.info("Items were successfully initialized");
		
		ModEnchantment.ENCHANTMENT.register(modEventBus);
		ModEnchantment.VANILLA_ENCHANTMENT.register(modEventBus);
		LOGGER.info("Enchantments were successfully initialized");
		
		ModTileEntityType.TILE_ENTITIES.register(modEventBus);
		ModContainerType.CONTAINERS.register(modEventBus);
		ModRecipeSerializer.RECIPE_SERIALIZERS.register(modEventBus);
		LOGGER.info("Util were successfully initialized");
		
		ModPointOfInterestTypes.POI_TYPE.register(modEventBus);
		ModPointOfInterestTypes.VANILLA_POI_TYPE.register(modEventBus);
		ModVillagerProfessions.PROFESSIONS.register(modEventBus);
		LOGGER.info("Villager were successfully initialized");
		
		ModEntityType.ENTITIES.register(modEventBus);
		LOGGER.info("Entities were successfully initialized");
		
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	private void setup(FMLCommonSetupEvent event) {
		
		OreGeneration.registerOres();
		CapabilityManager.INSTANCE.register(IModItemHandler.class, new Storage(), new Factory());
		
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

