package net.luis.cave.init.items;

import net.luis.cave.Cave;
import net.luis.cave.api.item.NightArmor;
import net.luis.cave.api.item.SaphireArmor;
import net.luis.cave.common.enums.ModArmorMaterial;
import net.luis.cave.common.item.armor.EnderiteElytra;
import net.luis.cave.common.item.armor.EnderiteHelmet;
import net.luis.cave.common.item.armor.NightElytra;
import net.luis.cave.common.item.armor.NightHelmet;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModArmor {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cave.Mod_Id);
	
	
	public static final RegistryObject<ArmorItem> SLIME_HELMET = ITEMS.register("slime_helmet", 
			() -> new ArmorItem(ModArmorMaterial.SLIME, EquipmentSlotType.HEAD, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<ArmorItem> SLIME_CHESTPLATE = ITEMS.register("slime_chestplate", 
			() -> new ArmorItem(ModArmorMaterial.SLIME, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<ArmorItem> SLIME_LEGGINS = ITEMS.register("slime_leggings", 
			() -> new ArmorItem(ModArmorMaterial.SLIME, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<ArmorItem> SLIME_BOOTS = ITEMS.register("slime_boots", 
			() -> new ArmorItem(ModArmorMaterial.SLIME, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor)));
	
	
	public static final RegistryObject<ArmorItem> LIMONITE_HELMET = ITEMS.register("limonite_helmet", 
			() -> new ArmorItem(ModArmorMaterial.LIMONITE, EquipmentSlotType.HEAD, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<ArmorItem> LIMONITE_CHESTPLATE = ITEMS.register("limonite_chestplate", 
			() -> new ArmorItem(ModArmorMaterial.LIMONITE, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<ArmorItem> LIMONITE_LEGGINS = ITEMS.register("limonite_leggings", 
			() -> new ArmorItem(ModArmorMaterial.LIMONITE, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<ArmorItem> LIMONITE_BOOTS = ITEMS.register("limonite_boots", 
			() -> new ArmorItem(ModArmorMaterial.LIMONITE, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor)));
	
	
	public static final RegistryObject<ArmorItem> JADE_HELMET = ITEMS.register("jade_helmet", 
			() -> new ArmorItem(ModArmorMaterial.JADE, EquipmentSlotType.HEAD, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<ArmorItem> JADE_CHESTPLATE = ITEMS.register("jade_chestplate", 
			() -> new ArmorItem(ModArmorMaterial.JADE, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<ArmorItem> JADE_LEGGINS = ITEMS.register("jade_leggings", 
			() -> new ArmorItem(ModArmorMaterial.JADE, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<ArmorItem> JADE_BOOTS = ITEMS.register("jade_boots", 
			() -> new ArmorItem(ModArmorMaterial.JADE, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor)));
	
	
	public static final RegistryObject<ArmorItem> BLAZING_HELMET = ITEMS.register("blazing_helmet", 
			() -> new ArmorItem(ModArmorMaterial.BLAZING, EquipmentSlotType.HEAD, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	public static final RegistryObject<ArmorItem> BLAZING_CHESTPLATE = ITEMS.register("blazing_chestplate", 
			() -> new ArmorItem(ModArmorMaterial.BLAZING, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	public static final RegistryObject<ArmorItem> BLAZING_LEGGINS = ITEMS.register("blazing_leggings", 
			() -> new ArmorItem(ModArmorMaterial.BLAZING, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	public static final RegistryObject<ArmorItem> BLAZING_BOOTS = ITEMS.register("blazing_boots", 
			() -> new ArmorItem(ModArmorMaterial.BLAZING, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	
	public static final RegistryObject<ArmorItem> RUBY_HELMET = ITEMS.register("ruby_helmet", 
			() -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<ArmorItem> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", 
			() -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<ArmorItem> RUBY_LEGGINS = ITEMS.register("ruby_leggings", 
			() -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<ArmorItem> RUBY_BOOTS = ITEMS.register("ruby_boots", 
			() -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor)));
	
	
	public static final RegistryObject<ArmorItem> SAPHIRE_HELMET = ITEMS.register("saphire_helmet", 
			() -> new SaphireArmor(ModArmorMaterial.SAPHIRE, EquipmentSlotType.HEAD, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<ArmorItem> SAPHIRE_CHESTPLATE = ITEMS.register("saphire_chestplate", 
			() -> new SaphireArmor(ModArmorMaterial.SAPHIRE, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<ArmorItem> SAPHIRE_LEGGINS = ITEMS.register("saphire_leggings", 
			() -> new SaphireArmor(ModArmorMaterial.SAPHIRE, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<ArmorItem> SAPHIRE_BOOTS = ITEMS.register("saphire_boots", 
			() -> new SaphireArmor(ModArmorMaterial.SAPHIRE, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor)));
	
	
	public static final RegistryObject<ArmorItem> ENDREITE_HELMET = ITEMS.register("enderite_helmet", EnderiteHelmet::new);
	
	public static final RegistryObject<ArmorItem> ENDREITE_CHESTPLATE = ITEMS.register("enderite_chestplate", 
			() -> new ArmorItem(ModArmorMaterial.ENDERITE, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	public static final RegistryObject<ArmorItem> ENDREITE_ELYTRA = ITEMS.register("enderite_elytra", EnderiteElytra::new);
	
	public static final RegistryObject<ArmorItem> ENDREITE_LEGGINS = ITEMS.register("enderite_leggings", 
			() -> new ArmorItem(ModArmorMaterial.ENDERITE, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	public static final RegistryObject<ArmorItem> ENDREITE_BOOTS = ITEMS.register("enderite_boots", 
			() -> new ArmorItem(ModArmorMaterial.ENDERITE, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	
	public static final RegistryObject<ArmorItem> NIGHT_HELMET = ITEMS.register("night_helmet", NightHelmet::new);
	
	public static final RegistryObject<ArmorItem> NIGHT_CHESTPLATE = ITEMS.register("night_chestplate", 
			() -> new NightArmor(ModArmorMaterial.NIGHT, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	public static final RegistryObject<ArmorItem> NIGHT_ELYTRA = ITEMS.register("night_elytra", NightElytra::new);
	
	public static final RegistryObject<ArmorItem> NIGHT_LEGGINS = ITEMS.register("night_leggings", 
			() -> new NightArmor(ModArmorMaterial.NIGHT, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	public static final RegistryObject<ArmorItem> NIGHT_BOOTS = ITEMS.register("night_boots", 
			() -> new NightArmor(ModArmorMaterial.NIGHT, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
}
