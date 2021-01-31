package net.luis.cave.world;

import net.luis.cave.util.lib.GameRule;
import net.minecraft.world.GameRules;

public class CaveGameRules {

	public static GameRule.BooleanGameRule DISABLE_ENDERMAN_TELEPORT = new GameRule.BooleanGameRule("disableEndermanTeleport", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule DISABLE_ENDERMAN_ATTACK_TELEPORT = new GameRule.BooleanGameRule("disableEndermanAttackTeleport", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule DISABLE_SHULKER_TELEPORT = new GameRule.BooleanGameRule("disableShulkerTeleport", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule DISABLE_SHULKER_ATTACK_TELEPORT = new GameRule.BooleanGameRule("disableShulkerAttackTeleport", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule DO_BAT_SPAWNING = new GameRule.BooleanGameRule("doBatSpawning", GameRules.Category.MOBS, true);
	public static GameRule.BooleanGameRule DO_MONSTER_SPAWNING = new GameRule.BooleanGameRule("doMonsterSpawning", GameRules.Category.MOBS, true);
	public static GameRule.BooleanGameRule DISABLE_FARMLAND_TRAMPLE = new GameRule.BooleanGameRule("disableFarmlandTrample", GameRules.Category.UPDATES, false);
	public static GameRule.BooleanGameRule DO_CROP_GROW = new GameRule.BooleanGameRule("doCropGrow", GameRules.Category.UPDATES, true);
	public static GameRule.BooleanGameRule DO_SAPLING_GROW = new GameRule.BooleanGameRule("doSaplingGrow", GameRules.Category.UPDATES, true);	
	public static GameRule.BooleanGameRule ENABLE_ZOMBIEVILLAGER_FAST_CONVERT = new GameRule.BooleanGameRule("enableZombievillagerFastConvert", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule DO_WORKTIME_TRADE_RESETING = new GameRule.BooleanGameRule("doWorktimeTradeReseting", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule ENABLE_PROTECTION_TIME = new GameRule.BooleanGameRule("enableProtectionTime", GameRules.Category.PLAYER, true);
	public static GameRule.BooleanGameRule ENABLE_BLASTING_DAMAGE = new GameRule.BooleanGameRule("enableBlastingDamage", GameRules.Category.PLAYER, false);
	public static GameRule.BooleanGameRule DISABLE_ITEM_DESPAWN = new GameRule.BooleanGameRule("disableItemDespawn", GameRules.Category.MISC, false);
	public static GameRule.BooleanGameRule DISABLE_ENDSTAR_DROP = new GameRule.BooleanGameRule("disableEndstarDrop", GameRules.Category.DROPS, false);
	public static GameRule.BooleanGameRule DISABLE_ITEM_GRAVITY = new GameRule.BooleanGameRule("disableItemGravity", GameRules.Category.DROPS, true);
	public static GameRule.BooleanGameRule ENABLE_INFINITE_HARVESTING = new GameRule.BooleanGameRule("enableInfiniteHarvesting", GameRules.Category.MISC, false);
	public static GameRule.BooleanGameRule ENABLE_TRADE_REDUCTION = new GameRule.BooleanGameRule("enableTradeReduction", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule ENABLE_SLIMECHUNK_INFO = new GameRule.BooleanGameRule("enableSlimechunkInfo", GameRules.Category.CHAT, false);
	public static GameRule.BooleanGameRule ENABLE_SEED_INFO = new GameRule.BooleanGameRule("enableSeedInfo", GameRules.Category.CHAT, false);
	//Error
	public static GameRule.BooleanGameRule ENABLE_ARMOR_EFFECTS = new GameRule.BooleanGameRule("enableArmorEffects", GameRules.Category.PLAYER, true);
	public static GameRule.BooleanGameRule ENABLE_RAIN_SLEEP = new GameRule.BooleanGameRule("enableRainSleep", GameRules.Category.PLAYER, true);
	public static GameRule.BooleanGameRule DISABLE_ENDERMAN_GRIEFING = new GameRule.BooleanGameRule("disableEndermanGriefing", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule DISABLE_CREEPER_GRIEFING = new GameRule.BooleanGameRule("disableCreeperGriefing", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule DISABLE_GHAST_GRIEFING = new GameRule.BooleanGameRule("disableGhastGriefing", GameRules.Category.MOBS, false);
	public static GameRule.BooleanGameRule ENABLE_LAVA_FLUID_SOURCE = new GameRule.BooleanGameRule("enableLavaFluidSource", GameRules.Category.MISC, false);	
	public static GameRule.BooleanGameRule DISABLE_HUNGER = new GameRule.BooleanGameRule("disableHunger", GameRules.Category.PLAYER, false);
	public static GameRule.BooleanGameRule ENABLE_ENCHANTMENT_TRANSFER = new GameRule.BooleanGameRule("enableEnchantmentTransfer", GameRules.Category.MISC, false);
	public static GameRule.BooleanGameRule DISABLE_BAN = new GameRule.BooleanGameRule("disableBan", GameRules.Category.MISC, false);
	
	//Error
	public static GameRule.IntegerGameRule GROWTH_ENCHANTMENT_MULTIPLIER  = new GameRule.IntegerGameRule("growthEnchantmentMultiplier", GameRules.Category.PLAYER, 1);
	public static GameRule.IntegerGameRule PROTECTION_TIME_MULTIPLIER = new GameRule.IntegerGameRule("protectionTimeMultiplier", GameRules.Category.PLAYER, 10);
	
}
