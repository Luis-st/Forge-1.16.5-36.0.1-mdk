package net.luis.cave.init;

import net.luis.cave.Cave;
import net.luis.cave.common.enchantment.armor.ElytraFalling;
import net.luis.cave.common.enchantment.armor.ElytraProtection;
import net.luis.cave.common.enchantment.armor.Growth;
import net.luis.cave.common.enchantment.armor.LavaWalker;
import net.luis.cave.common.enchantment.armor.VoidWalker;
import net.luis.cave.common.enchantment.curse.CurseOfBreaking;
import net.luis.cave.common.enchantment.curse.CurseOfHarming;
import net.luis.cave.common.enchantment.tool.Blasting;
import net.luis.cave.common.enchantment.tool.DoubleDrops;
import net.luis.cave.common.enchantment.tool.Experience;
import net.luis.cave.common.enchantment.tool.Harvesting;
import net.luis.cave.common.enchantment.tool.Replenish;
import net.luis.cave.common.enchantment.tool.Smelting;
import net.luis.cave.common.enchantment.tool.Telekinesis;
import net.luis.cave.common.enchantment.vanilla.Flame;
import net.luis.cave.common.enchantment.vanilla.Impaling;
import net.luis.cave.common.enchantment.vanilla.Infinity;
import net.luis.cave.common.enchantment.vanilla.Multishot;
import net.luis.cave.common.enchantment.vanilla.Piercing;
import net.luis.cave.common.enchantment.vanilla.Power;
import net.luis.cave.common.enchantment.vanilla.Punch;
import net.luis.cave.common.enchantment.vanilla.QuickCharge;
import net.luis.cave.common.enchantment.vanilla.Thorns;
import net.luis.cave.common.enchantment.weapon.DoubleShot;
import net.luis.cave.common.enchantment.weapon.EnderSlayer;
import net.luis.cave.common.enchantment.weapon.FrostAspect;
import net.luis.cave.common.enchantment.weapon.PoisonAspect;
import net.luis.cave.common.enchantment.weapon.ThrowOfTheEnd;
import net.luis.cave.common.enchantment.weapon.Thunderbolt;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEnchantment {
	
	public static final DeferredRegister<Enchantment> ENCHANTMENT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Cave.Mod_Id);
	public static final DeferredRegister<Enchantment> VANILLA_ENCHANTMENT = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Cave.Minecraft_Id);
	private static final EquipmentSlotType[] ARMOR_SLOTS = new EquipmentSlotType[]{EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET};
	
	public static final RegistryObject<Enchantment> DOUBLE_DROPS = ENCHANTMENT.register("double_drops", 
			() -> new DoubleDrops(Rarity.VERY_RARE, EnchantmentType.DIGGER, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> BLASTING = ENCHANTMENT.register("blasting", 
			() -> new Blasting(Rarity.UNCOMMON, EnchantmentType.DIGGER, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> POISON_ASPECT = ENCHANTMENT.register("poison_aspect", 
			() -> new PoisonAspect(Rarity.RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> FROST_ASPECT = ENCHANTMENT.register("frost_aspect", 
			() -> new FrostAspect(Rarity.RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> EXPERIENCE = ENCHANTMENT.register("experience", 
			() -> new Experience(Rarity.UNCOMMON, EnchantmentType.BREAKABLE, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> SMELTING = ENCHANTMENT.register("smelting", 
			() -> new Smelting(Rarity.RARE, EnchantmentType.DIGGER, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> INFINITY = VANILLA_ENCHANTMENT.register("infinity", 
			() -> new Infinity(Rarity.VERY_RARE, EnchantmentType.BREAKABLE, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> ELYTRA_PROTECTION = ENCHANTMENT.register("elytra_protection", 
			() -> new ElytraProtection(Rarity.VERY_RARE, EnchantmentType.ARMOR_CHEST, EquipmentSlotType.CHEST));
	
	public static final RegistryObject<Enchantment> ELYTRA_FALLING = ENCHANTMENT.register("elytra_falling", 
			() -> new ElytraFalling(Rarity.VERY_RARE, EnchantmentType.ARMOR_CHEST, EquipmentSlotType.CHEST));
	
	public static final RegistryObject<Enchantment> VOID_WALKER = ENCHANTMENT.register("void_walker", 
			() -> new VoidWalker(Rarity.VERY_RARE, EnchantmentType.ARMOR_FEET, EquipmentSlotType.FEET));
	
	public static final RegistryObject<Enchantment> MULTISHOT = VANILLA_ENCHANTMENT.register("multishot", 
			() -> new Multishot(Rarity.RARE, EnchantmentType.CROSSBOW, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> PIERCING = VANILLA_ENCHANTMENT.register("piercing",
			() -> new Piercing(Rarity.COMMON, EnchantmentType.CROSSBOW, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> QUICK_CHARGE = VANILLA_ENCHANTMENT.register("quick_charge", 
			() -> new QuickCharge(Rarity.UNCOMMON, EnchantmentType.CROSSBOW, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> GROWTH = ENCHANTMENT.register("growth", 
			() -> new Growth(Rarity.UNCOMMON, EnchantmentType.ARMOR, ARMOR_SLOTS));
	
	public static final RegistryObject<Enchantment> CURSE_OF_BREAKING = ENCHANTMENT.register("curse_of_breaking", 
			() -> new CurseOfBreaking(Rarity.VERY_RARE, EnchantmentType.BREAKABLE, EquipmentSlotType.values()));
	
	public static final RegistryObject<Enchantment> CURSE_OF_HARMING = ENCHANTMENT.register("curse_of_harming", 
			() -> new CurseOfHarming(Rarity.VERY_RARE, EnchantmentType.WEARABLE, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> HARVESTING = ENCHANTMENT.register("harvesting", 
			() -> new Harvesting(Rarity.COMMON, EnchantmentType.DIGGER, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> THORNS = VANILLA_ENCHANTMENT.register("thorns", 
			() -> new Thorns(Rarity.VERY_RARE, EnchantmentType.ARMOR, ARMOR_SLOTS));
	
	public static final RegistryObject<Enchantment> POWER = VANILLA_ENCHANTMENT.register("power", 
			() -> new Power(Rarity.COMMON, EnchantmentType.BREAKABLE, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> PUNCH = VANILLA_ENCHANTMENT.register("punch", 
			() -> new Punch(Rarity.RARE, EnchantmentType.BREAKABLE, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> FLAME = VANILLA_ENCHANTMENT.register("flame", 
			() -> new Flame(Rarity.RARE, EnchantmentType.BREAKABLE, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> ENDER_SLYAER = ENCHANTMENT.register("ender_slayer", 
			() -> new EnderSlayer(Rarity.UNCOMMON, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> THUNDERBOLT = ENCHANTMENT.register("thunderbolt", 
			() -> new Thunderbolt(Rarity.VERY_RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> TELEKINESIS = ENCHANTMENT.register("telekinesis", 
			() -> new Telekinesis(Rarity.VERY_RARE, EnchantmentType.BREAKABLE, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> REPLENISH = ENCHANTMENT.register("replenish", 
			() -> new Replenish(Rarity.VERY_RARE, EnchantmentType.DIGGER, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> DOUBLE_SHOT = ENCHANTMENT.register("double_shot", 
			() -> new DoubleShot(Rarity.VERY_RARE, EnchantmentType.BOW, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> THROW_OF_THE_END = ENCHANTMENT.register("throw_of_the_end", 
			() -> new ThrowOfTheEnd(Rarity.VERY_RARE, EnchantmentType.BOW, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> LAVA_WALKER = ENCHANTMENT.register("lava_walker", 
			() -> new LavaWalker(Rarity.VERY_RARE, EnchantmentType.ARMOR_FEET, EquipmentSlotType.FEET));
	
	public static final RegistryObject<Enchantment> IMPALING = VANILLA_ENCHANTMENT.register("impaling", 
			() -> new Impaling(Rarity.RARE, EnchantmentType.WEAPON, EquipmentSlotType.MAINHAND));

}