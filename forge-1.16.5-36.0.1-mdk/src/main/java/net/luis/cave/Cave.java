package net.luis.cave;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.luis.cave.events.generation.OreGeneration;
import net.luis.cave.init.ModEnchantment;
import net.luis.cave.init.ModEntityType;
import net.luis.cave.init.blocks.ModBlockItems;
import net.luis.cave.init.blocks.ModBlocks;
import net.luis.cave.init.blocks.ModVerticalBlockItems;
import net.luis.cave.init.blocks.ModVerticalBlocks;
import net.luis.cave.init.items.ModArmor;
import net.luis.cave.init.items.ModItems;
import net.luis.cave.init.items.ModTools;
import net.luis.cave.init.items.VanillaItems;
import net.luis.cave.init.util.ModContainer;
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
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ModBlocks.BLOCKS.register(modEventBus);
		ModBlockItems.ITEMS.register(modEventBus);
		
		ModVerticalBlocks.BLOCKS.register(modEventBus);
		ModVerticalBlockItems.ITEMS.register(modEventBus);
		
		ModItems.ITEMS.register(modEventBus);
		VanillaItems.VANILLA_ITEMS.register(modEventBus);
		ModTools.ITEMS.register(modEventBus);
		ModArmor.ITEMS.register(modEventBus);
		
		ModEnchantment.ENCHANTMENT.register(modEventBus);
		ModEnchantment.VANILLA_ENCHANTMENT.register(modEventBus);
		
		ModTileEntityType.TILE_ENTITIES.register(modEventBus);
		ModContainer.CONTAINERS.register(modEventBus);
		ModRecipeSerializer.RECIPE_SERIALIZERS.register(modEventBus);
		
		ModPointOfInterestTypes.POI_TYPE.register(modEventBus);
		ModVillagerProfessions.PROFESSIONS.register(modEventBus);
		
		ModEntityType.ENTITIES.register(modEventBus);
		
		MinecraftForge.EVENT_BUS.register(this);
		
	}
	
	private void setup(FMLCommonSetupEvent event) {
		
		OreGeneration.registerOres();
		
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

