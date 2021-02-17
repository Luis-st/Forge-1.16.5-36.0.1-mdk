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

}
