package net.luis.cave.init.blocks;

import net.luis.cave.Cave;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cave.Mod_Id);

	
	public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block", 
			() -> new BlockItem(ModBlocks.RUBY_BLOCK.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> ENDERITE_ORE_ITEM = ITEMS.register("enderite_ore", 
			() -> new BlockItem(ModBlocks.ENDERITE_ORE.get(),new Item.Properties().group(Cave.BUILDING_BLOCKS).isImmuneToFire()));
	
	public static final RegistryObject<Item> ENDERITE_BLOCK_ITEM = ITEMS.register("enderite_block", 
			() -> new BlockItem(ModBlocks.ENDERITE_BLOCK.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS).isImmuneToFire()));
	
	public static final RegistryObject<Item> JADE_ORE_ITEM = ITEMS.register("jade_ore", 
			() -> new BlockItem(ModBlocks.JADE_ORE.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> JADE_BLOCK_ITEM = ITEMS.register("jade_block", 
			() -> new BlockItem(ModBlocks.JADE_BLOCK.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> LIMONITE_ORE_ITEM = ITEMS.register("limonite_ore", 
			() -> new BlockItem(ModBlocks.LIMONITE_ORE.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> LIMONITE_BLOCK_ITEM = ITEMS.register("limonite_block", 
			() -> new BlockItem(ModBlocks.LIMONITE_BLOCK.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> ROSITE_ORE_ITEM = ITEMS.register("rosite_ore", 
			() -> new BlockItem(ModBlocks.ROSITE_ORE.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> ROSITE_BLOCK_ITEM = ITEMS.register("rosite_block", 
			() -> new BlockItem(ModBlocks.ROSITE_BLOCK.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> SAPHIRE_ORE_ITEM = ITEMS.register("saphire_ore", 
			() -> new BlockItem(ModBlocks.SAPHIRE_ORE.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> SAPHIRE_BLOCK_ITEM = ITEMS.register("saphire_block", 
			() -> new BlockItem(ModBlocks.SAPHIRE_BLOCK.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> POWDER_SNOW_ITEM = ITEMS.register("powder_snow", 
			() -> new BlockItem(ModBlocks.POWDER_SNOW.get(), new Item.Properties().group(Cave.DECORATIONS)));
	
	public static final RegistryObject<Item> INFINITE_ANVIL_ITEM = ITEMS.register("infinite_anvil", 
			() -> new BlockItem(ModBlocks.INFINITE_ANVIL.get(), new Item.Properties().group(Cave.DECORATIONS)));
	
	public static final RegistryObject<Item> SMELTING_FURNACE_ITEM = ITEMS.register("smelting_furnace", 
			() -> new BlockItem(ModBlocks.SMELTING_FURNACE.get(), new Item.Properties().group(Cave.DECORATIONS)));
	
	public static final RegistryObject<Item> TINTED_GLASS_ITEM = ITEMS.register("tinted_glass", 
			() -> new BlockItem(ModBlocks.TINTED_GLASS.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> AMETHYST_ORE_ITEM = ITEMS.register("amethyst_ore", 
			() -> new BlockItem(ModBlocks.AMETHYST_ORE.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> CALCITE_ITEM = ITEMS.register("calcite", 
			() -> new BlockItem(ModBlocks.CALCITE.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> TUFF_ITEM = ITEMS.register("tuff", 
			() -> new BlockItem(ModBlocks.TUFF.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> COPPER_ORE_ITEM = ITEMS.register("copper_ore", 
			() -> new BlockItem(ModBlocks.COPPER_ORE.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> COPPER_BLOCK_ITEM = ITEMS.register("copper_block", 
			() -> new BlockItem(ModBlocks.COPPER_BLOCK.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> CUT_COPPER_ITEM = ITEMS.register("cut_copper", 
			() -> new BlockItem(ModBlocks.CUT_COPPER.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> CUT_COPPER_SLAB_ITEM = ITEMS.register("cut_copper_slab", 
			() -> new BlockItem(ModBlocks.CUT_COPPER_SLAB.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> CUT_COPPER_STAIRS_ITEM = ITEMS.register("cut_copper_stairs", 
			() -> new BlockItem(ModBlocks.CUT_COPPER_STAIRS.get(), new Item.Properties().group(Cave.BUILDING_BLOCKS)));
	
	public static final RegistryObject<Item> LIGHTNING_ROD_ITEM = ITEMS.register("lightning_rod", 
			() -> new BlockItem(ModBlocks.LIGHTNING_ROD.get(), new Item.Properties().group(Cave.DECORATIONS)));
	
}
