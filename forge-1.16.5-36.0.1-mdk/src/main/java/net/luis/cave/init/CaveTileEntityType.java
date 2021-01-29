package net.luis.cave.init;

import net.luis.cave.Cave;
import net.luis.cave.blocks.tileentity.LightningRodTileEntity;
import net.luis.cave.blocks.tileentity.SmeltingFurnaceTileEntity;
import net.luis.cave.init.blocks.CaveBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Cave.Mod_Id)
public class CaveTileEntityType {
	
	public static TileEntityType<LightningRodTileEntity> LIGHTNING_ROD = null;
	public static TileEntityType<SmeltingFurnaceTileEntity> SMELTING_FURNACE = null;
	
	@SubscribeEvent
	public static void registerTE(RegistryEvent.Register<TileEntityType<?>> event) {
		
		LIGHTNING_ROD = TileEntityType.Builder.create(LightningRodTileEntity::new, CaveBlocks.LIGHTNING_ROD.get()).build(null);
		LIGHTNING_ROD.setRegistryName(Cave.Mod_Id, "lightminig_rod_tileentity");
		event.getRegistry().register(LIGHTNING_ROD);
		
		SMELTING_FURNACE = TileEntityType.Builder.create(SmeltingFurnaceTileEntity::new, CaveBlocks.SMELTING_FURNACE.get()).build(null);
		SMELTING_FURNACE.setRegistryName(Cave.Mod_Id, "smelting_furnace_tileentity");
		event.getRegistry().register(SMELTING_FURNACE);
		
	}

}
