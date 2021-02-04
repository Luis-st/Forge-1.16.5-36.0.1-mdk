package net.luis.cave.init.villager;

import com.google.common.collect.ImmutableSet;

import net.luis.cave.Cave;
import net.luis.cave.api.villager.VillagerUtil;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Cave.Mod_Id)
public class ModVillagerProfessions {
	
	public static final VillagerProfession LUMBERJACK = null;
	public static final VillagerProfession MOB_HUNTER = null;
	public static final VillagerProfession MINER = null;
	public static final VillagerProfession ENCHANTER = null;
	public static final VillagerProfession BEEKEEPER = null;
	public static final VillagerProfession NETHER_TRADER = null;
	public static final VillagerProfession END_TRADER = null;

	@SubscribeEvent
	public static void registerVillagerProfessions(Register<VillagerProfession> event) {
		
		IForgeRegistry<VillagerProfession> registry = event.getRegistry();

		registry.register(VillagerUtil.villagerProfession("lumberjack", ModPointOfInterestTypes.LUMBERJACK,
				ImmutableSet.of(), ImmutableSet.of(), null).setRegistryName(Cave.Mod_Id, "lumberjack"));
		
		registry.register(VillagerUtil.villagerProfession("mob_hunter", ModPointOfInterestTypes.MOB_HUNTER, ImmutableSet.of(), 
				ImmutableSet.of(), null).setRegistryName(Cave.Mod_Id, "mob_hunter"));
		
		registry.register(VillagerUtil.villagerProfession("miner", ModPointOfInterestTypes.MINER,
				ImmutableSet.of(), ImmutableSet.of(), null).setRegistryName(Cave.Mod_Id, "miner"));
		
		registry.register(VillagerUtil.villagerProfession("enchanter", ModPointOfInterestTypes.ENCHANTER,
				ImmutableSet.of(), ImmutableSet.of(), null).setRegistryName(Cave.Mod_Id, "enchanter"));
		
		registry.register(VillagerUtil.villagerProfession("beekeeper", ModPointOfInterestTypes.BEEKEEPER,
				ImmutableSet.of(), ImmutableSet.of(), null).setRegistryName(Cave.Mod_Id, "beekeeper"));
		
		registry.register(VillagerUtil.villagerProfession("nether_trader", ModPointOfInterestTypes.NETHER_TRADER,
				ImmutableSet.of(), ImmutableSet.of(), null).setRegistryName(Cave.Mod_Id, "nether_trader"));
		
		registry.register(VillagerUtil.villagerProfession("end_trader", ModPointOfInterestTypes.END_TRADER,
				ImmutableSet.of(), ImmutableSet.of(), null).setRegistryName(Cave.Mod_Id, "end_trader"));
		
	}
	
}
