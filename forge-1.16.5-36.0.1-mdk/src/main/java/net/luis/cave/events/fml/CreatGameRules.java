package net.luis.cave.events.fml;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.luis.cave.Cave;
import net.luis.cave.api.lib.GameRule;
import net.luis.cave.init.util.ModGameRule;
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
	public static void doCommonSetup(FMLCommonSetupEvent event) {
		
		try { 
			
			creatBoolean.setAccessible(true);
			creatInteger.setAccessible(true);
			
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DISABLE_ENDERMAN_TELEPORT));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DISABLE_ENDERMAN_ATTACK_TELEPORT));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DISABLE_SHULKER_TELEPORT));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DISABLE_SHULKER_ATTACK_TELEPORT));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DO_BAT_SPAWNING));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DO_MONSTER_SPAWNING));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DISABLE_FARMLAND_TRAMPLE));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DO_CROP_GROW));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DO_SAPLING_GROW));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.ENABLE_ZOMBIEVILLAGER_FAST_CONVERT));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DO_WORKTIME_TRADE_RESETING));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.ENABLE_BLASTING_DAMAGE));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DISABLE_ITEM_DESPAWN));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DISABLE_END_STAR_DROP));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DISABLE_ITEM_GRAVITY));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.ENABLE_INFINITE_HARVESTING));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.ENABLE_PROTECTION_TIME));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.ENABLE_TRADE_REDUCTION));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.ENABLE_SLIMECHUNK_INFO));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.ENABLE_SEED_INFO));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.ENABLE_RAIN_SLEEP));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DISABLE_ENDERMAN_GRIEFING));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DISABLE_CREEPER_GRIEFING));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DISABLE_GHAST_GRIEFING));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.ENABLE_LAVA_FLUID_SOURCE));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DISABLE_HUNGER));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.ENABLE_ENCHANTMENT_TRANSFER));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DISABLE_BAN));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DISABLE_WATER_STAR_DROP));
			DeferredWorkQueue.runLater(() -> addBooleanGameRule(ModGameRule.DO_ENDERPEARL_DAMAGE));
			
			DeferredWorkQueue.runLater(() -> addIntegerGameRule(ModGameRule.PROTECTION_TIME_MULTIPLIER));
			DeferredWorkQueue.runLater(() -> addIntegerGameRule(ModGameRule.MAX_BONUS_DAMAGE));
			
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
