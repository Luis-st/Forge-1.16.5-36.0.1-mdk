package net.luis.cave.world;

import net.luis.cave.util.lib.GameRule;
import net.minecraft.world.GameRules;

public class CaveGameRules {

	public static GameRule.BooleanGameRule DO_ENDERMAN_TELEPORT = new GameRule.BooleanGameRule("doEndermanTeleport", GameRules.Category.MOBS, true);
	public static GameRule.BooleanGameRule DO_ENDERMAN_ATTACK_TELEPORT = new GameRule.BooleanGameRule("doEndermanAttackTeleport", GameRules.Category.MOBS, true);
	public static GameRule.BooleanGameRule DO_SHULKER_TELEPORT = new GameRule.BooleanGameRule("doShulkerTeleport", GameRules.Category.MOBS, true);
	public static GameRule.BooleanGameRule DO_BAT_SPAWNING = new GameRule.BooleanGameRule("doBatSpawning", GameRules.Category.MOBS, true);
	public static GameRule.BooleanGameRule DO_MONSTER_SPAWNING = new GameRule.BooleanGameRule("doMonsterSpawning", GameRules.Category.MOBS, true);
	public static GameRule.BooleanGameRule DO_FARMLAND_TRAMPLE = new GameRule.BooleanGameRule("doFarmlandTrample", GameRules.Category.UPDATES, true);
	public static GameRule.BooleanGameRule DO_CROP_GROW = new GameRule.BooleanGameRule("doGropGrow", GameRules.Category.UPDATES, true);
	public static GameRule.BooleanGameRule DO_SAPLING_GROW = new GameRule.BooleanGameRule("doSaplingGrow", GameRules.Category.UPDATES, true);
	public static GameRule.BooleanGameRule DO_VILLAGER_FAST_CONVERT = new GameRule.BooleanGameRule("doVillagerFastConvert", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule DO_WORKTIME_TRADE_RESETING = new GameRule.BooleanGameRule("doWorktimeTradeReseting", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule DO_TRADE_REDUCTION = new GameRule.BooleanGameRule("doTradeReduction", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule DO_PROTECTION_TIME = new GameRule.BooleanGameRule("doProtectionTime", GameRules.Category.PLAYER, true);
	public static GameRule.BooleanGameRule DO_BLASTING_RESISTANCE = new GameRule.BooleanGameRule("doBlastingResistance", GameRules.Category.PLAYER, true);
	public static GameRule.BooleanGameRule DO_ITEM_DESPAWN = new GameRule.BooleanGameRule("doItemDespawn", GameRules.Category.MISC, true);
	public static GameRule.BooleanGameRule DROP_ENDSTAR = new GameRule.BooleanGameRule("dropEndstar", GameRules.Category.DROPS, true);
	public static GameRule.BooleanGameRule ITEM_NO_GRAVITY = new GameRule.BooleanGameRule("itemNoGravity", GameRules.Category.DROPS, true);
	public static GameRule.BooleanGameRule INFINITE_HARVESTING = new GameRule.BooleanGameRule("infiniteHarvesting", GameRules.Category.MISC, false);
	public static GameRule.BooleanGameRule ENABLE_SLIMECHUNK_INFO = new GameRule.BooleanGameRule("enableSlimechunkInfo", GameRules.Category.CHAT, false);
	public static GameRule.BooleanGameRule ENABLE_SEED_INFO = new GameRule.BooleanGameRule("enableSeedInfo", GameRules.Category.CHAT, false)
	public static GameRule.BooleanGameRule ENABLE_ARMOR_EFFECTS = new GameRule.BooleanGameRule("enableArmorEffects", GameRules.Category.PLAYER, true);
	public static GameRule.BooleanGameRule ENABLE_RAIN_SLEEP = new GameRule.BooleanGameRule("enableRainSleep", GameRules.Category.PLAYER, true);
	public static GameRule.BooleanGameRule DISABLE_ENDERMAN_GRIEFING = new GameRule.BooleanGameRule("disableEndermanGriefing", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule DISABLE_CREEPER_GRIEFING = new GameRule.BooleanGameRule("disableCreeperGriefing", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule DISABLE_GHAST_GRIEFING = new GameRule.BooleanGameRule("disableGhastGriefing", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule ENABLE_LAVA_FLUID_SOURCE = new GameRule.BooleanGameRule("enableLavaFluidSource", GameRules.Category.MISC, false);
	public static GameRule.BooleanGameRule DISABLE_HUNGER = new GameRule.BooleanGameRule("disableHunger", GameRules.Category.PLAYER, false);
	public static GameRule.BooleanGameRule ENABLE_ENCHANTMENT_TRANSFER = new GameRule.BooleanGameRule("enableEnchantmentTransfer", GameRules.Category.MISC, false);
	public static GameRule.BooleanGameRule DISABLE_BAN = new GameRule.BooleanGameRule("disableBan", GameRules.Category.MISC, true);
	
	public static GameRule.IntegerGameRule MAX_HEALTH = new GameRule.IntegerGameRule("maxHealth", GameRules.Category.PLAYER, 20);
	public static GameRule.IntegerGameRule PROTECTION_TIME_MULTIPLIER = new GameRule.IntegerGameRule("protectionTimeMultiplier", GameRules.Category.PLAYER, 1);
	
}
