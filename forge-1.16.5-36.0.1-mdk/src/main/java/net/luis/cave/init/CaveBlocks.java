package net.luis.cave.init;

import net.luis.cave.Cave;
import net.luis.cave.blocks.BeeTable;
import net.luis.cave.blocks.InfiniteAnvil;
import net.luis.cave.blocks.PowderSnow;
import net.luis.cave.blocks.SmeltingFurnace;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CaveBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Cave.Mod_Id);
	public static final DeferredRegister<Block> VANILLA_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Cave.Minecraft_Id);
	
	public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", 
			() -> new Block(Block.Properties.create(Material.IRON, MaterialColor.RED).hardnessAndResistance(5.5f,6.5f).sound(SoundType.METAL)
			.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()));
	
	public static final RegistryObject<Block> ENDERITE_ORE = BLOCKS.register("enderite_ore", 
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.GREEN).hardnessAndResistance(30.0f,1200.0f).sound(SoundType.STONE)
			.harvestLevel(4).harvestTool(ToolType.PICKAXE).setRequiresTool()));
	
	public static final RegistryObject<Block> ENDERITE_BLOCK = BLOCKS.register("enderite_block", 
			() -> new Block(Block.Properties.create(Material.IRON, MaterialColor.GREEN).hardnessAndResistance(50.0f,1200.0f).sound(SoundType.METAL)
			.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()));
	
	public static final RegistryObject<Block> JADE_ORE = BLOCKS.register("jade_ore", 
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3.0f,3.5f).sound(SoundType.STONE)
			.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()));
	
	public static final RegistryObject<Block> JADE_BLOCK = BLOCKS.register("jade_block", 
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.EMERALD).hardnessAndResistance(4.0f,5.5f).sound(SoundType.METAL)
			.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()));
	
	public static final RegistryObject<Block> LIMONITE_ORE = BLOCKS.register("limonite_ore", 
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3.0f,3.5f).sound(SoundType.STONE)
			.harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool()));
	
	public static final RegistryObject<Block> LIMONITE_BLOCK = BLOCKS.register("limonite_block", 
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.GOLD).hardnessAndResistance(5.5f,6.5f).sound(SoundType.METAL)
			.harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool()));
	
	public static final RegistryObject<Block> ROSITE_ORE = BLOCKS.register("rosite_ore", 
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3.0f,3.5f).sound(SoundType.STONE)
			.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()));
	
	public static final RegistryObject<Block> ROSITE_BLOCK = BLOCKS.register("rosite_block", 
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.RED).hardnessAndResistance(5.0f,6.0f).sound(SoundType.METAL)
			.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()));
	
	public static final RegistryObject<Block> SAPHIRE_ORE = BLOCKS.register("saphire_ore", 
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(3.0f,3.5f).sound(SoundType.STONE)
			.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()));
	
	public static final RegistryObject<Block> SAPHIRE_BLOCK = BLOCKS.register("saphire_block", 
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.BLUE).hardnessAndResistance(5.0f,6.0f).sound(SoundType.METAL)
			.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool()));
	
	public static final RegistryObject<Block> POWDER_SNOW = BLOCKS.register("powder_snow", PowderSnow::new);
	
	public static final RegistryObject<Block> INFINITE_ANVIL = BLOCKS.register("infinite_anvil", InfiniteAnvil::new);
	
	public static final RegistryObject<Block> SMELTING_FURNACE = BLOCKS.register("smelting_furnace", SmeltingFurnace::new);
	
	public static final RegistryObject<Block> BEE_TABLE = BLOCKS.register("bee_table", BeeTable::new);

}
