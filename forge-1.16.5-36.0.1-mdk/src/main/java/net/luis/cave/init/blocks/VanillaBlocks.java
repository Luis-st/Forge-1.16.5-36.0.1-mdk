package net.luis.cave.init.blocks;

import net.luis.cave.Cave;
import net.luis.cave.common.block.ModBarrel;
import net.luis.cave.common.block.ModBeacon;
import net.luis.cave.common.block.ModEnchantingTable;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VanillaBlocks {
	
	public static final DeferredRegister<Block> VANILLA_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Cave.Minecraft_Id);
	
	
	public static final RegistryObject<Block> BARREL = VANILLA_BLOCKS.register("barrel", 
			() -> new ModBarrel(AbstractBlock.Properties.from(Blocks.BARREL)));
	
	public static final RegistryObject<Block> ENCHANTING_TABLE = VANILLA_BLOCKS.register("enchanting_table", 
			() -> new ModEnchantingTable(AbstractBlock.Properties.from(Blocks.ENCHANTING_TABLE)));
	
	public static final RegistryObject<Block> BEACON = VANILLA_BLOCKS.register("beacon", 
			() -> new ModBeacon(AbstractBlock.Properties.from(Blocks.BEACON)));
	
}
