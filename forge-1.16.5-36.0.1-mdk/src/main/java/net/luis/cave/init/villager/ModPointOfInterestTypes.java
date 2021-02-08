package net.luis.cave.init.villager;

import net.luis.cave.Cave;
import net.luis.cave.api.villager.VillagerUtil;
import net.luis.cave.init.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPointOfInterestTypes {
	
	public static final DeferredRegister<PointOfInterestType> POI_TYPE = DeferredRegister.create(ForgeRegistries.POI_TYPES, Cave.Mod_Id);
	
	
	public static final RegistryObject<PointOfInterestType> LUMBERJACK = POI_TYPE.register("lumberjack", 
			() -> new PointOfInterestType("lumberjack", VillagerUtil.getAllStates(Blocks.CRAFTING_TABLE), 1, 1));
	
	public static final RegistryObject<PointOfInterestType> MOB_HUNTER = POI_TYPE.register("mob_hunter", 
			() -> new PointOfInterestType("mob_hunter", VillagerUtil.getAllStates(Blocks.ANVIL), 1, 1));
	
	public static final RegistryObject<PointOfInterestType> MINER = POI_TYPE.register("miner", 
			() -> new PointOfInterestType("miner", VillagerUtil.getAllStates(ModBlocks.SMELTING_FURNACE.get()), 1, 1));
	
	public static final RegistryObject<PointOfInterestType> ENCHANTER = POI_TYPE.register("enchanter", 
			() -> new PointOfInterestType("enchanter", VillagerUtil.getAllStates(Blocks.ENCHANTING_TABLE), 1, 1));
	
	public static final RegistryObject<PointOfInterestType> BEEKEEPER = POI_TYPE.register("beekeeper", 
			() -> new PointOfInterestType("beekeeper", VillagerUtil.getAllStates(ModBlocks.BEE_TABLE.get()), 1, 1));
	
	public static final RegistryObject<PointOfInterestType> NETHER_TRADER = POI_TYPE.register("nether_trader", 
			() -> new PointOfInterestType("nether_trader", VillagerUtil.getAllStates(Blocks.RESPAWN_ANCHOR), 1, 1));
	
	public static final RegistryObject<PointOfInterestType> END_TRADER = POI_TYPE.register("end_trader", 
			() -> new PointOfInterestType("end_trader", VillagerUtil.getAllStates(Blocks.ENDER_CHEST), 1, 1));
	
}
