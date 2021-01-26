package net.luis.cave.init.blocks;

import net.luis.cave.Cave;
import net.luis.cave.blocks.slab.AbstractVerticalSlabItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CaveVerticalBlockItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cave.Mod_Id);
	
	
	public static final RegistryObject<Item> VERTICAL_OAK_SLAB_ITEM = ITEMS.register("vertical_oak_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_OAK_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_SPRUCE_SLAB_ITEM = ITEMS.register("vertical_spruce_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_SPRUCE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_BIRCH_SLAB_ITEM = ITEMS.register("vertical_birch_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_BIRCH_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_JUNGLE_SLAB_ITEM = ITEMS.register("vertical_jungle_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_JUNGLE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_ACACIA_SLAB_ITEM = ITEMS.register("vertical_acacia_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_ACACIA_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_DARK_OAK_SLAB_ITEM = ITEMS.register("vertical_dark_oak_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_DARK_OAK_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_CRIMSON_SLAB_ITEM = ITEMS.register("vertical_crimson_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_CRIMSON_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_WARPED_SLAB_ITEM = ITEMS.register("vertical_warped_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_WARPED_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_STONE_SLAB_ITEM = ITEMS.register("vertical_stone_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_STONE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_SMOOTH_STONE_SLAB_ITEM = ITEMS.register("vertical_smooth_stone_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_SMOOTH_STONE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_SANDSTONE_SLAB_ITEM = ITEMS.register("vertical_sandstone_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_SANDSTONE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_CUT_SANDSTONE_SLAB_ITEM = ITEMS.register("vertical_cut_sandstone_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_CUT_SANDSTONE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_COBBLESTONE_SLAB_ITEM = ITEMS.register("vertical_cobblestone_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_COBBLESTONE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_BRICK_SLAB_ITEM = ITEMS.register("vertical_brick_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_BRICK_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_STONE_BRICK_SLAB_ITEM = ITEMS.register("vertical_stone_brick_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_STONE_BRICK_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_NETHER_BRICK_SLAB_ITEM = ITEMS.register("vertical_nether_brick_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_NETHER_BRICK_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_QUARTZ_SLAB_ITEM = ITEMS.register("vertical_quartz_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_QUARTZ_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_MOSSY_STONE_BRICK_SLAB_ITEM = ITEMS.register("vertical_mossy_stone_brick_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_MOSSY_STONE_BRICK_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_CUT_RED_SANDSTONE_SLAB_ITEM = ITEMS.register("vertical_cut_red_sandstone_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_CUT_RED_SANDSTONE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_PURPUR_SLAB_ITEM = ITEMS.register("vertical_purpur_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_PURPUR_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_PRISMARINE_SLAB_ITEM = ITEMS.register("vertical_prismarine_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_PRISMARINE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_PRISMARINE_BRICK_SLAB_ITEM = ITEMS.register("vertical_prismarine_brick_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_PRISMARINE_BRICK_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_DARK_PRISMARINE_SLAB_ITEM = ITEMS.register("vertical_dark_prismarine_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_DARK_PRISMARINE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> POLISHED_VERTICAL_GRANITE_SLAB_ITEM = ITEMS.register("polished_vertical_granite_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.POLISHED_VERTICAL_GRANITE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_SMOOTH_RED_SANDSTONE_SLAB_ITEM = ITEMS.register("vertical_smooth_red_sandstone_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_SMOOTH_RED_SANDSTONE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_RED_SANDSTONE_SLAB_ITEM = ITEMS.register("vertical_red_sandstone_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_RED_SANDSTONE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> POLISHED_VERTICAL_ANDESITE_SLAB_ITEM = ITEMS.register("polished_vertical_andesite_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.POLISHED_VERTICAL_ANDESITE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_MOSSY_COBBLESTONE_SLAB_ITEM = ITEMS.register("vertical_mossy_cobblestone_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_MOSSY_COBBLESTONE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_END_STONE_BRICK_SLAB_ITEM = ITEMS.register("vertical_end_stone_brick_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_END_STONE_BRICK_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_SMOOTH_SANDSTONE_SLAB_ITEM = ITEMS.register("vertical_smooth_sandstone_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_SMOOTH_SANDSTONE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_SMOOTH_QUARTZ_SLAB_ITEM = ITEMS.register("vertical_smooth_quartz_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_SMOOTH_QUARTZ_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_GRANITE_SLAB_ITEM = ITEMS.register("vertical_granite_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_GRANITE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_ANDESITE_SLAB_ITEM = ITEMS.register("vertical_andesite_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_ANDESITE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_RED_NETHER_BRICK_SLAB_ITEM = ITEMS.register("vertical_red_nether_brick_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_RED_NETHER_BRICK_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> POLISHED_VERTICAL_DIORITE_SLAB_ITEM = ITEMS.register("polished_vertical_diorite_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.POLISHED_VERTICAL_DIORITE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_DIORITE_SLAB_ITEM = ITEMS.register("vertical_diorite_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_DIORITE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> VERTICAL_BLACKSTONE_SLAB_ITEM = ITEMS.register("vertical_blackstone_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.VERTICAL_BLACKSTONE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> POLISHED_VERTICAL_BLACKSTONE_SLAB_ITEM = ITEMS.register("polished_vertical_blackstone_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.POLISHED_VERTICAL_BLACKSTONE_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
	public static final RegistryObject<Item> POLISHED_VERTICAL_BLACKSTONE_BRICK_SLAB_ITEM = ITEMS.register("polished_vertical_blackstone_brick_slab", 
			() -> new AbstractVerticalSlabItem(CaveVerticalBlocks.POLISHED_VERTICAL_BLACKSTONE_BRICK_SLAB.get(), new Item.Properties().group(Cave.VERTICAL_SLABS)));
	
}
