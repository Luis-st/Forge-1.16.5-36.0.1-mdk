package net.luis.cave.init;

import net.luis.cave.Cave;
import net.luis.cave.blocks.tileentity.LightningRodTileEntity;
import net.luis.cave.blocks.tileentity.SmeltingFurnaceTileEntity;
import net.luis.cave.init.blocks.CaveBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CaveTileEntityType {
	
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Cave.Mod_Id);
	
	public static final RegistryObject<TileEntityType<?>> LIGHTNING_ROD = TILE_ENTITIES.register("lightminig_rod_tileentity", 
			() -> TileEntityType.Builder.create(LightningRodTileEntity::new, CaveBlocks.LIGHTNING_ROD.get()).build(null));
	
	public static final RegistryObject<TileEntityType<?>> SMELTING_FURNACE = TILE_ENTITIES.register("smelting_furnace_tileentity", 
			() -> TileEntityType.Builder.create(SmeltingFurnaceTileEntity::new, CaveBlocks.SMELTING_FURNACE.get()).build(null));
	
}
