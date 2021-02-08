package net.luis.cave.init.villager;

import com.google.common.collect.ImmutableSet;

import net.luis.cave.Cave;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModVillagerProfessions {
	
	public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, Cave.Mod_Id);
	
	
	public static final RegistryObject<VillagerProfession> LUMBERJACK = PROFESSIONS.register("lumberjack", 
			() -> new VillagerProfession("lumberjack", ModPointOfInterestTypes.LUMBERJACK.get(), ImmutableSet.of(), ImmutableSet.of(), null));
	
	public static final RegistryObject<VillagerProfession> MOB_HUNTER = PROFESSIONS.register("mob_hunter", 
			() -> new VillagerProfession("lumberjack", ModPointOfInterestTypes.MOB_HUNTER.get(), ImmutableSet.of(), ImmutableSet.of(), null));
	
	public static final RegistryObject<VillagerProfession> MINER = PROFESSIONS.register("miner", 
			() -> new VillagerProfession("lumberjack", ModPointOfInterestTypes.MINER.get(), ImmutableSet.of(), ImmutableSet.of(), null));
	
	public static final RegistryObject<VillagerProfession> ENCHANTER = PROFESSIONS.register("enchanter", 
			() -> new VillagerProfession("lumberjack", ModPointOfInterestTypes.ENCHANTER.get(), ImmutableSet.of(), ImmutableSet.of(), null));
	
	public static final RegistryObject<VillagerProfession> BEEKEEPER = PROFESSIONS.register("beekeeper", 
			() -> new VillagerProfession("lumberjack", ModPointOfInterestTypes.BEEKEEPER.get(), ImmutableSet.of(), ImmutableSet.of(), null));
	
	public static final RegistryObject<VillagerProfession> NETHER_TRADER = PROFESSIONS.register("nether_trader", 
			() -> new VillagerProfession("lumberjack", ModPointOfInterestTypes.NETHER_TRADER.get(), ImmutableSet.of(), ImmutableSet.of(), null));
	
	public static final RegistryObject<VillagerProfession> END_TRADER = PROFESSIONS.register("end_trader", 
			() -> new VillagerProfession("lumberjack", ModPointOfInterestTypes.END_TRADER.get(), ImmutableSet.of(), ImmutableSet.of(), null));
	
}
