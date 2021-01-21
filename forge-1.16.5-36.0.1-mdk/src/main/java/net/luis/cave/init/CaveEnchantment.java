package net.luis.cave.init;

import net.luis.cave.Cave;
import net.luis.cave.enchantment.Blasting;
import net.luis.cave.enchantment.DoubleDrops;
import net.luis.cave.enchantment.ElytraFalling;
import net.luis.cave.enchantment.ElytraProtection;
import net.luis.cave.enchantment.EnderSlayer;
import net.luis.cave.enchantment.Experience;
import net.luis.cave.enchantment.FrostAspect;
import net.luis.cave.enchantment.Growth;
import net.luis.cave.enchantment.Harvesting;
import net.luis.cave.enchantment.PoisonAspect;
import net.luis.cave.enchantment.Smelting;
import net.luis.cave.enchantment.Thunderbolt;
import net.luis.cave.enchantment.VoidWalker;
import net.luis.cave.enchantment.curse.CurseOfBreaking;
import net.luis.cave.enchantment.curse.CurseOfHarming;
import net.luis.cave.enchantment.vanilla.Flame;
import net.luis.cave.enchantment.vanilla.Infinity;
import net.luis.cave.enchantment.vanilla.Multishot;
import net.luis.cave.enchantment.vanilla.Piercing;
import net.luis.cave.enchantment.vanilla.Power;
import net.luis.cave.enchantment.vanilla.Punch;
import net.luis.cave.enchantment.vanilla.QuickCharge;
import net.luis.cave.enchantment.vanilla.Thorns;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CaveEnchantment {
	
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
			() -> new Experience(Rarity.UNCOMMON, EnchantmentType.DIGGER, EquipmentSlotType.MAINHAND));
	
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
			() -> new CurseOfHarming(Rarity.VERY_RARE, EnchantmentType.WEARABLE, ARMOR_SLOTS));
	
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
			() -> new Thunderbolt(Rarity.VERY_RARE, EnchantmentType.BREAKABLE, EquipmentSlotType.MAINHAND));
	
	public static final RegistryObject<Enchantment> REPLENISH = ENCHANTMENT.register("replenish", 
			() -> new Thunderbolt(Rarity.VERY_RARE, EnchantmentType.DIGGER, EquipmentSlotType.MAINHAND));
	
	

}