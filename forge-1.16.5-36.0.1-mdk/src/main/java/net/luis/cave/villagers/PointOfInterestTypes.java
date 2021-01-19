package net.luis.cave.villagers;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Cave.Mod_Id)
public class PointOfInterestTypes {

	public static final PointOfInterestType LUMBERJACK = null;
	public static final PointOfInterestType MOB_HUNTER = null;
	public static final PointOfInterestType MINER = null;
	public static final PointOfInterestType ENCHANTER = null;
	public static final PointOfInterestType BEEKEEPER = null;
	
	@SubscribeEvent
	public static void registerPointOfInterestTypes(Register<PointOfInterestType> event) {
		
		IForgeRegistry<PointOfInterestType> registry = event.getRegistry();
		
		registry.register(VillagerUtil.pointOfInterestType("lumberjack", 
				VillagerUtil.getAllStates(Blocks.CRAFTING_TABLE), 1, 1).setRegistryName(Cave.Mod_Id, "lumberjack"));
		
		registry.register(VillagerUtil.pointOfInterestType("mob_hunter", 
				VillagerUtil.getAllStates(Blocks.ANVIL), 1, 1).setRegistryName(Cave.Mod_Id, "mob_hunter"));
		
		registry.register(VillagerUtil.pointOfInterestType("miner", 
				VillagerUtil.getAllStates(CaveBlocks.SMELTING_FURNACE.get()), 1, 1).setRegistryName(Cave.Mod_Id, "miner"));
		
		registry.register(VillagerUtil.pointOfInterestType("enchanter", 
				VillagerUtil.getAllStates(Blocks.ENCHANTING_TABLE), 1, 1).setRegistryName(Cave.Mod_Id, "enchanter"));
		
		registry.register(VillagerUtil.pointOfInterestType("beekeeper", 
				VillagerUtil.getAllStates(CaveBlocks.BEE_TABLE.get()), 1, 1).setRegistryName(Cave.Mod_Id, "beekeeper"));
		
	}
	
}
