package net.luis.cave.init.blocks;

import net.luis.cave.Cave;
import net.luis.cave.common.block.ModBarrel;
import net.luis.cave.common.block.ModShulkerBox;
import net.luis.cave.common.tileentity.ModShulkerBoxTileEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VanillaBlocks {
	
	public static final DeferredRegister<Block> VANILLA_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Cave.Minecraft_Id);
	
	
	public static final RegistryObject<Block> BARREL = VANILLA_BLOCKS.register("barrel", 
			() -> new ModBarrel(AbstractBlock.Properties.from(Blocks.BARREL)));
	
	public static final RegistryObject<Block> SHULKER_BOX = VANILLA_BLOCKS.register("shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(null, AbstractBlock.Properties.create(Material.SHULKER)));
	
	public static final RegistryObject<Block> WHITE_SHULKER_BOX = VANILLA_BLOCKS.register("white_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.WHITE, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.SNOW)));
	
	public static final RegistryObject<Block> ORANGE_SHULKER_BOX = VANILLA_BLOCKS.register("orange_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.ORANGE, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.ADOBE)));
	
	public static final RegistryObject<Block> MAGENTA_SHULKER_BOX = VANILLA_BLOCKS.register("magenta_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.MAGENTA, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.MAGENTA)));
	
	public static final RegistryObject<Block> LIGHT_BLUE_SHULKER_BOX = VANILLA_BLOCKS.register("light_blue_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.LIGHT_BLUE, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.LIGHT_BLUE)));
	
	public static final RegistryObject<Block> YELLOW_SHULKER_BOX = VANILLA_BLOCKS.register("yellow_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.YELLOW, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.YELLOW)));
	
	public static final RegistryObject<Block> LIME_SHULKER_BOX = VANILLA_BLOCKS.register("lime_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.LIME, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.LIME)));
	
	public static final RegistryObject<Block> PINK_SHULKER_BOX = VANILLA_BLOCKS.register("pink_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.PINK, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.PINK)));
	
	public static final RegistryObject<Block> GRAY_SHULKER_BOX = VANILLA_BLOCKS.register("gray_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.GRAY, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.GRAY)));
	
	public static final RegistryObject<Block> LIGHT_GRAY_SHULKER_BOX = VANILLA_BLOCKS.register("light_gray_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.LIGHT_GRAY, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.LIGHT_GRAY)));
	
	public static final RegistryObject<Block> CYAN_SHULKER_BOX = VANILLA_BLOCKS.register("cyan_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.CYAN, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.CYAN)));
	
	public static final RegistryObject<Block> PURPLE_SHULKER_BOX = VANILLA_BLOCKS.register("purple_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.PURPLE, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.PURPLE_TERRACOTTA)));
	
	public static final RegistryObject<Block> BLUE_SHULKER_BOX = VANILLA_BLOCKS.register("blue_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.BLUE, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.BLUE)));
	
	public static final RegistryObject<Block> BROWN_SHULKER_BOX = VANILLA_BLOCKS.register("brown_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.BROWN, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.BROWN)));
	
	public static final RegistryObject<Block> GREEN_SHULKER_BOX = VANILLA_BLOCKS.register("green_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.GREEN, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.GREEN)));
	
	public static final RegistryObject<Block> RED_SHULKER_BOX = VANILLA_BLOCKS.register("red_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.RED, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.RED)));
	
	public static final RegistryObject<Block> BLACK_SHULKER_BOX = VANILLA_BLOCKS.register("black_shulker_box", 
			() -> createShulkerBoxFromColorAndProperties(DyeColor.BLACK, AbstractBlock.Properties.create(Material.SHULKER, MaterialColor.BLACK)));

	
	private static ModShulkerBox createShulkerBoxFromColorAndProperties(DyeColor color, AbstractBlock.Properties properties) {
		
		AbstractBlock.IPositionPredicate positionPredicate = (state, reader, pos) -> {
			
			TileEntity tileEntity = reader.getTileEntity(pos);
			
			if (!(tileEntity instanceof ModShulkerBoxTileEntity)) {
				
				return true;
				
			} else {
				
				ModShulkerBoxTileEntity shulkerBoxTileEntity = (ModShulkerBoxTileEntity) tileEntity;
				return shulkerBoxTileEntity.func_235676_l_();
				
			}
			
		};
		
		return new ModShulkerBox(color, properties.hardnessAndResistance(2.0F).variableOpacity().notSolid()
				.setSuffocates(positionPredicate).setBlocksVision(positionPredicate));
		
	}
	
}
