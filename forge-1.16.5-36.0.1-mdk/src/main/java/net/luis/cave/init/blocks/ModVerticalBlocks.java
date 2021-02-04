package net.luis.cave.init.blocks;

import net.luis.cave.Cave;
import net.luis.cave.common.block.slab.nether.VerticalBlackstoneSlab;
import net.luis.cave.common.block.slab.nether.VerticalNetherBrickSlab;
import net.luis.cave.common.block.slab.nether.VerticalPolishedBlackstoneBrickSlab;
import net.luis.cave.common.block.slab.nether.VerticalPolishedBlackstoneSlab;
import net.luis.cave.common.block.slab.nether.VerticalQuartzSlab;
import net.luis.cave.common.block.slab.nether.VerticalRedNetherBrickSlab;
import net.luis.cave.common.block.slab.nether.VerticalSmoothQuartzSlab;
import net.luis.cave.common.block.slab.other.VerticalCutCopperSlab;
import net.luis.cave.common.block.slab.other.VerticalDarkPrismarineSlab;
import net.luis.cave.common.block.slab.other.VerticalEndStoneBrickSlab;
import net.luis.cave.common.block.slab.other.VerticalPrismarineBrickSlab;
import net.luis.cave.common.block.slab.other.VerticalPrismarineSlab;
import net.luis.cave.common.block.slab.other.VerticalPurpurSlab;
import net.luis.cave.common.block.slab.sandstone.VerticalCutRedSandstoneSlab;
import net.luis.cave.common.block.slab.sandstone.VerticalCutSandstoneSlab;
import net.luis.cave.common.block.slab.sandstone.VerticalRedSandstoneSlab;
import net.luis.cave.common.block.slab.sandstone.VerticalSandstoneSlab;
import net.luis.cave.common.block.slab.sandstone.VerticalSmoothRedSandstoneSlab;
import net.luis.cave.common.block.slab.sandstone.VerticalSmoothSandstoneSlab;
import net.luis.cave.common.block.slab.stone.VerticalAndesiteSlab;
import net.luis.cave.common.block.slab.stone.VerticalBrickSlab;
import net.luis.cave.common.block.slab.stone.VerticalCobblestoneSlab;
import net.luis.cave.common.block.slab.stone.VerticalDioriteSlab;
import net.luis.cave.common.block.slab.stone.VerticalGraniteSlab;
import net.luis.cave.common.block.slab.stone.VerticalMossyCobblestoneSlab;
import net.luis.cave.common.block.slab.stone.VerticalMossyStoneBrickSlab;
import net.luis.cave.common.block.slab.stone.VerticalPolishedAndesiteSlab;
import net.luis.cave.common.block.slab.stone.VerticalPolishedDioriteSlab;
import net.luis.cave.common.block.slab.stone.VerticalPolishedGraniteSlab;
import net.luis.cave.common.block.slab.stone.VerticalSmoothStoneSlab;
import net.luis.cave.common.block.slab.stone.VerticalStoneBrickSlab;
import net.luis.cave.common.block.slab.stone.VerticalStoneSlab;
import net.luis.cave.common.block.slab.wood.VerticalAcaciaSlab;
import net.luis.cave.common.block.slab.wood.VerticalBirchSlab;
import net.luis.cave.common.block.slab.wood.VerticalCrimsonSlab;
import net.luis.cave.common.block.slab.wood.VerticalDarkOakSlab;
import net.luis.cave.common.block.slab.wood.VerticalJungleSlab;
import net.luis.cave.common.block.slab.wood.VerticalOakSlab;
import net.luis.cave.common.block.slab.wood.VerticalSpruceSlab;
import net.luis.cave.common.block.slab.wood.VerticalWarpedSlab;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModVerticalBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Cave.Mod_Id);
	
	
	public static final RegistryObject<Block> VERTICAL_BLACKSTONE_SLAB = BLOCKS.register("vertical_blackstone_slab", VerticalBlackstoneSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_NETHER_BRICK_SLAB = BLOCKS.register("vertical_nether_brick_slab", VerticalNetherBrickSlab::new);
	
	public static final RegistryObject<Block> POLISHED_VERTICAL_BLACKSTONE_BRICK_SLAB = BLOCKS.register("polished_vertical_blackstone_brick_slab", VerticalPolishedBlackstoneBrickSlab::new);
	
	public static final RegistryObject<Block> POLISHED_VERTICAL_BLACKSTONE_SLAB = BLOCKS.register("polished_vertical_blackstone_slab", VerticalPolishedBlackstoneSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_QUARTZ_SLAB = BLOCKS.register("vertical_quartz_slab", VerticalQuartzSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_RED_NETHER_BRICK_SLAB = BLOCKS.register("vertical_red_nether_brick_slab", VerticalRedNetherBrickSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_SMOOTH_QUARTZ_SLAB = BLOCKS.register("vertical_smooth_quartz_slab", VerticalSmoothQuartzSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_DARK_PRISMARINE_SLAB = BLOCKS.register("vertical_dark_prismarine_slab", VerticalDarkPrismarineSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_END_STONE_BRICK_SLAB = BLOCKS.register("vertical_end_stone_brick_slab", VerticalEndStoneBrickSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_PRISMARINE_BRICK_SLAB = BLOCKS.register("vertical_prismarine_brick_slab", VerticalPrismarineBrickSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_PRISMARINE_SLAB = BLOCKS.register("vertical_prismarine_slab", VerticalPrismarineSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_PURPUR_SLAB = BLOCKS.register("vertical_purpur_slab", VerticalPurpurSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_CUT_RED_SANDSTONE_SLAB = BLOCKS.register("vertical_cut_red_sandstone_slab", VerticalCutRedSandstoneSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_CUT_SANDSTONE_SLAB = BLOCKS.register("vertical_cut_sandstone_slab", VerticalCutSandstoneSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_RED_SANDSTONE_SLAB = BLOCKS.register("vertical_red_sandstone_slab", VerticalRedSandstoneSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_SANDSTONE_SLAB = BLOCKS.register("vertical_sandstone_slab", VerticalSandstoneSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_SMOOTH_RED_SANDSTONE_SLAB = BLOCKS.register("vertical_smooth_red_sandstone_slab", VerticalSmoothRedSandstoneSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_SMOOTH_SANDSTONE_SLAB = BLOCKS.register("vertical_smooth_sandstone_slab", VerticalSmoothSandstoneSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_ANDESITE_SLAB = BLOCKS.register("vertical_andesite_slab", VerticalAndesiteSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_BRICK_SLAB = BLOCKS.register("vertical_brick_slab", VerticalBrickSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_COBBLESTONE_SLAB = BLOCKS.register("vertical_cobblestone_slab", VerticalCobblestoneSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_DIORITE_SLAB = BLOCKS.register("vertical_diorite_slab", VerticalDioriteSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_GRANITE_SLAB = BLOCKS.register("vertical_granite_slab", VerticalGraniteSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_MOSSY_COBBLESTONE_SLAB = BLOCKS.register("vertical_mossy_cobblestone_slab", VerticalMossyCobblestoneSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_MOSSY_STONE_BRICK_SLAB = BLOCKS.register("vertical_mossy_stone_brick_slab", VerticalMossyStoneBrickSlab::new);
	
	public static final RegistryObject<Block> POLISHED_VERTICAL_ANDESITE_SLAB = BLOCKS.register("polished_vertical_andesite_slab", VerticalPolishedAndesiteSlab::new);
	
	public static final RegistryObject<Block> POLISHED_VERTICAL_DIORITE_SLAB = BLOCKS.register("polished_vertical_diorite_slab", VerticalPolishedDioriteSlab::new);
	
	public static final RegistryObject<Block> POLISHED_VERTICAL_GRANITE_SLAB = BLOCKS.register("polished_vertical_granite_slab", VerticalPolishedGraniteSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_SMOOTH_STONE_SLAB = BLOCKS.register("vertical_smooth_stone_slab", VerticalSmoothStoneSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_STONE_BRICK_SLAB = BLOCKS.register("vertical_stone_brick_slab", VerticalStoneBrickSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_STONE_SLAB = BLOCKS.register("vertical_stone_slab", VerticalStoneSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_ACACIA_SLAB = BLOCKS.register("vertical_acacia_slab", VerticalAcaciaSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_BIRCH_SLAB = BLOCKS.register("vertical_birch_slab", VerticalBirchSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_CRIMSON_SLAB = BLOCKS.register("vertical_crimson_slab", VerticalCrimsonSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_DARK_OAK_SLAB = BLOCKS.register("vertical_dark_oak_slab", VerticalDarkOakSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_JUNGLE_SLAB = BLOCKS.register("vertical_jungle_slab", VerticalJungleSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_OAK_SLAB = BLOCKS.register("vertical_oak_slab", VerticalOakSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_SPRUCE_SLAB = BLOCKS.register("vertical_spruce_slab", VerticalSpruceSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_WARPED_SLAB = BLOCKS.register("vertical_warped_slab", VerticalWarpedSlab::new);
	
	public static final RegistryObject<Block> VERTICAL_CUT_COPPER_SLAB = BLOCKS.register("vertical_cut_copper_slab", VerticalCutCopperSlab::new);
	
}
