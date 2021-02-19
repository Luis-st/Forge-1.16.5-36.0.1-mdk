package net.luis.cave.events.generation;

import java.util.ArrayList;

import net.luis.cave.Cave;
import net.luis.cave.init.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
 
@Mod.EventBusSubscriber(modid = Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OreGeneration {
	
	private static final ArrayList<ConfiguredFeature<?, ?>> overworldOres = new ArrayList<ConfiguredFeature<?, ?>>();
	private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
	private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();
	
	public static void registerOres() {
		
		overworldOres.add(register("jade_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.JADE_ORE.get().getDefaultState(), 7)) //vein Size
				.range(64).square() //maximum height
				.func_242731_b(20))); //count per chunk
		
		overworldOres.add(register("limonite_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.LIMONITE_ORE.get().getDefaultState(), 14))
				.range(16).square().func_242731_b(7)));
		
		overworldOres.add(register("rosite_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.ROSITE_ORE.get().getDefaultState(), 5))
				.range(64).square().func_242731_b(5)));
		
		overworldOres.add(register("saphire_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.SAPHIRE_ORE.get().getDefaultState(), 4))
				.range(64).square().func_242731_b(5)));
		
		overworldOres.add(register("amethyst_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.AMETHYST_ORE.get().getDefaultState(), 7))
				.range(64).square().func_242731_b(10)));
		
		overworldOres.add(register("copper_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.COPPER_ORE.get().getDefaultState(), 9))
				.range(128).square().func_242731_b(11)));
		
		overworldOres.add(register("calcite", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.CALCITE.get().getDefaultState(), 15))
				.range(72).square() .func_242731_b(15))); 
		
		overworldOres.add(register("tuff", Feature.ORE.withConfiguration(new OreFeatureConfig(
				OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.TUFF.get().getDefaultState(), 20))
				.range(64).square().func_242731_b(20))); 
		
		
		endOres.add(register("enderite_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
				new BlockMatchRuleTest(Blocks.END_STONE), ModBlocks.ENDERITE_ORE.get().getDefaultState(), 3))
				.range(64).square().func_242731_b(6))); 
		
	}
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void gen(BiomeLoadingEvent event) {
		
		BiomeGenerationSettingsBuilder generation = event.getGeneration();
		
		if (event.getCategory().equals(Biome.Category.NETHER)) {
			
			for (ConfiguredFeature<?, ?> ore : netherOres){
				
				if (ore != null) {
					
					generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
					
				}
				
			}
			
		}
		
		if (event.getCategory().equals(Biome.Category.THEEND)) {
			
			for (ConfiguredFeature<?, ?> ore : endOres){
				
				if (ore != null) {
					
					generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
					
				}
				
			}
			
		}
		
		for (ConfiguredFeature<?, ?> ore : overworldOres) {
			
			if (ore != null) {
				
				generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
				
			}
			
		}
		
	}

	private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
		
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, Cave.Mod_Id + ":" + name, configuredFeature);
		
	}

}