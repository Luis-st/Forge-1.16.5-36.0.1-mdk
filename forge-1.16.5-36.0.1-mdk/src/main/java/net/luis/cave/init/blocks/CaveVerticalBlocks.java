package net.luis.cave.init.blocks;

import net.luis.cave.Cave;
import net.luis.cave.blocks.slab.nether.VerticalBlackstoneSlab;
import net.luis.cave.blocks.slab.nether.VerticalNetherBrickSlab;
import net.luis.cave.blocks.slab.nether.VerticalPolishedBlackstoneSlab;
import net.luis.cave.blocks.slab.nether.VerticalQuartzSlab;
import net.luis.cave.blocks.slab.nether.VerticalRedNetherBrickSlab;
import net.luis.cave.blocks.slab.nether.VerticalSmoothQuartzSlab;
import net.luis.cave.blocks.slab.other.VerticalDarkPrismarineSlab;
import net.luis.cave.blocks.slab.other.VerticalEndStoneBrickSlab;
import net.luis.cave.blocks.slab.other.VerticalPrismarineBrickSlab;
import net.luis.cave.blocks.slab.other.VerticalPrismarineSlab;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CaveVerticalBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Cave.Mod_Id);
	
	
	public static final RegistryObject<Block> VERTICAL_BLACKSTONE_SLAB = BLOCKS.register("vertical_blackstone_slab", VerticalBlackstoneSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_NETHER_BRICK_SLAB = BLOCKS.register("vertical_nether_brick_slab", VerticalNetherBrickSlab::new);
	
	public static final RegistryObject<Block> POLISHED_VERTICAL_BLACKSTONE_SLAB = BLOCKS.register("polished_vertical_blackstone_slab", VerticalPolishedBlackstoneSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_QUARTZ_SLAB = BLOCKS.register("vertical_quartz_slab", VerticalQuartzSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_RED_NETHER_BRICK_SLAB = BLOCKS.register("vertical_red_nether_brick_slab", VerticalRedNetherBrickSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_SMOOTH_QUARTZ_SLAB = BLOCKS.register("vertical_smooth_quartz_slab", VerticalSmoothQuartzSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_DARK_PRISMARINE_SLAB = BLOCKS.register("vertical_dark_prismarine_slab", VerticalDarkPrismarineSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_END_STONE_BRICK_SLAB = BLOCKS.register("vertical_end_stone_brick_slab", VerticalEndStoneBrickSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_PRISMARINE_BRICK_SLAB = BLOCKS.register("vertical_prismarine_brick_slab", VerticalPrismarineBrickSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_PRISMARINE_SLAB = BLOCKS.register("vertical_prismarine_slab", VerticalPrismarineSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_PURPUR_SLAB = BLOCKS.register("vertical_purpur_slab", VerticalPrismarineSlab::new);
	
}
