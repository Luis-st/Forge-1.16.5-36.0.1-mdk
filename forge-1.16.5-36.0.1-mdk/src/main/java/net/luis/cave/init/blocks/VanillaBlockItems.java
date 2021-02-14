package net.luis.cave.init.blocks;

import net.luis.cave.Cave;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VanillaBlockItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cave.Minecraft_Id);

	
	public static final RegistryObject<Item> BARREL_ITEM = ITEMS.register("barrel", 
			() -> new BlockItem(VanillaBlocks.BARREL.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> SHULKER_BOX_ITEM = ITEMS.register("shulker_box", 
			() -> new BlockItem(VanillaBlocks.SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> WHITE_SHULKER_BOX_ITEM = ITEMS.register("white_shulker_box", 
			() -> new BlockItem(VanillaBlocks.WHITE_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> ORANGE_SHULKER_BOX_ITEM = ITEMS.register("orange_shulker_box", 
			() -> new BlockItem(VanillaBlocks.ORANGE_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> MAGENTA_SHULKER_BOX_ITEM = ITEMS.register("magenta_shulker_box", 
			() -> new BlockItem(VanillaBlocks.MAGENTA_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> LIGHT_BLUE_SHULKER_BOX_ITEM = ITEMS.register("light_blue_shulker_box", 
			() -> new BlockItem(VanillaBlocks.LIGHT_BLUE_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> YELLOW_SHULKER_BOX_ITEM = ITEMS.register("yellow_shulker_box", 
			() -> new BlockItem(VanillaBlocks.YELLOW_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> LIME_SHULKER_BOX_ITEM = ITEMS.register("lime_shulker_box", 
			() -> new BlockItem(VanillaBlocks.LIME_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> PINK_SHULKER_BOX_ITEM = ITEMS.register("pink_shulker_box", 
			() -> new BlockItem(VanillaBlocks.PINK_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> GRAY_SHULKER_BOX_ITEM = ITEMS.register("gray_shulker_box", 
			() -> new BlockItem(VanillaBlocks.GRAY_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> LIGHT_GRAY_SHULKER_BOX_ITEM = ITEMS.register("light_gray_shulker_box", 
			() -> new BlockItem(VanillaBlocks.LIGHT_GRAY_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> CYAN_SHULKER_BOX_ITEM = ITEMS.register("cyan_shulker_box", 
			() -> new BlockItem(VanillaBlocks.CYAN_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> PURPLE_SHULKER_BOX_ITEM = ITEMS.register("purple_shulker_box", 
			() -> new BlockItem(VanillaBlocks.PURPLE_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> BLUE_SHULKER_BOX_ITEM = ITEMS.register("blue_shulker_box", 
			() -> new BlockItem(VanillaBlocks.BLUE_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> BROWN_SHULKER_BOX_ITEM = ITEMS.register("brown_shulker_box", 
			() -> new BlockItem(VanillaBlocks.BROWN_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> GREEN_SHULKER_BOX_ITEM = ITEMS.register("green_shulker_box", 
			() -> new BlockItem(VanillaBlocks.GREEN_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> RED_SHULKER_BOX_ITEM = ITEMS.register("red_shulker_box", 
			() -> new BlockItem(VanillaBlocks.RED_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));
	
	public static final RegistryObject<Item> BLACK_SHULKER_BOX_ITEM = ITEMS.register("black_shulker_box", 
			() -> new BlockItem(VanillaBlocks.BLACK_SHULKER_BOX.get(), new Item.Properties().group(ItemGroup.DECORATIONS)));

}
