package net.luis.cave.events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.luis.cave.Cave;
import net.luis.cave.util.lib.GameRule;
import net.luis.cave.world.CaveGameRules;
import net.minecraft.world.GameRules;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreatGameRules {
	
	private static Method creatBoolean = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
	private static Method creatInteger = ObfuscationReflectionHelper.findMethod(GameRules.IntegerValue.class, "func_223559_b", int.class);
	
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public static void DoCommonSetup(FMLCommonSetupEvent event) {
		
		try { 
			
			creatBoolean.setAccessible(true);
			creatInteger.setAccessible(true);
			
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DISABLE_ENDERMAN_TELEPORT));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DISABLE_ENDERMAN_ATTACK_TELEPORT));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DISABLE_SHULKER_TELEPORT));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DISABLE_SHULKER_ATTACK_TELEPORT));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DO_BAT_SPAWNING));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DO_MONSTER_SPAWNING));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DISABLE_FARMLAND_TRAMPLE));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DO_CROP_GROW));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DO_SAPLING_GROW));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.ENABLE_ZOMBIEVILLAGER_FAST_CONVERT));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DO_WORKTIME_TRADE_RESETING));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.ENABLE_BLASTING_DAMAGE));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DISABLE_ITEM_DESPAWN));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DISABLE_END_STAR_DROP));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DISABLE_ITEM_GRAVITY));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.ENABLE_INFINITE_HARVESTING));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.ENABLE_PROTECTION_TIME));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.ENABLE_TRADE_REDUCTION));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.ENABLE_SLIMECHUNK_INFO));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.ENABLE_SEED_INFO));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.ENABLE_RAIN_SLEEP));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DISABLE_ENDERMAN_GRIEFING));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DISABLE_CREEPER_GRIEFING));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DISABLE_GHAST_GRIEFING));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.ENABLE_LAVA_FLUID_SOURCE));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DISABLE_HUNGER));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.ENABLE_ENCHANTMENT_TRANSFER));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DISABLE_BAN));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DISABLE_WATER_STAR_DROP));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(CaveGameRules.DO_ENDERPEARL_DAMAGE));
			
			DeferredWorkQueue.runLater(() -> addIntegerGameRule(CaveGameRules.PROTECTION_TIME_MULTIPLIER));
			
		} catch (Exception e) {
			
			
			
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void addBooleanGameRule(GameRule.BooleanGameRule gameRule) {
		
		try {
			
			Object value = creatBoolean.invoke(GameRules.BooleanValue.class, gameRule.getDefaultValue());
			gameRule.setRule(GameRules.register(gameRule.getName(), gameRule.getCategory(), (GameRules.RuleType) value));
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void addIntegerGameRule(GameRule.IntegerGameRule gameRule) {
		
		try {
			
			Object value = creatInteger.invoke(GameRules.IntegerValue.class, gameRule.getDefaultValue());
			gameRule.setRule(GameRules.register(gameRule.getName(), gameRule.getCategory(), (GameRules.RuleType) value));
			
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
