package net.luis.cave.init.items;

import net.luis.cave.Cave;
import net.luis.cave.api.item.api.armor.mod.BlazingArmor;
import net.luis.cave.api.item.api.armor.mod.EnderiteArmor;
import net.luis.cave.api.item.api.armor.mod.JadeArmor;
import net.luis.cave.api.item.api.armor.mod.LimoniteArmor;
import net.luis.cave.api.item.api.armor.mod.NightArmor;
import net.luis.cave.api.item.api.armor.mod.RubyArmor;
import net.luis.cave.api.item.api.armor.mod.SaphireArmor;
import net.luis.cave.api.item.api.armor.mod.SlimeArmor;
import net.luis.cave.common.enums.ModArmorMaterial;
import net.luis.cave.common.item.armor.EnderiteElytra;
import net.luis.cave.common.item.armor.EnderiteHelmet;
import net.luis.cave.common.item.armor.NightElytra;
import net.luis.cave.common.item.armor.NightHelmet;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModArmor {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cave.MOD_ID);
	
	
	public static final RegistryObject<SlimeArmor> SLIME_HELMET = ITEMS.register("slime_helmet", 
			() -> new SlimeArmor(ModArmorMaterial.SLIME, EquipmentSlotType.HEAD, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<SlimeArmor> SLIME_CHESTPLATE = ITEMS.register("slime_chestplate", 
			() -> new SlimeArmor(ModArmorMaterial.SLIME, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<SlimeArmor> SLIME_LEGGINS = ITEMS.register("slime_leggings", 
			() -> new SlimeArmor(ModArmorMaterial.SLIME, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<SlimeArmor> SLIME_BOOTS = ITEMS.register("slime_boots", 
			() -> new SlimeArmor(ModArmorMaterial.SLIME, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor)));
	
	
	public static final RegistryObject<LimoniteArmor> LIMONITE_HELMET = ITEMS.register("limonite_helmet", 
			() -> new LimoniteArmor(ModArmorMaterial.LIMONITE, EquipmentSlotType.HEAD, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<LimoniteArmor> LIMONITE_CHESTPLATE = ITEMS.register("limonite_chestplate", 
			() -> new LimoniteArmor(ModArmorMaterial.LIMONITE, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<LimoniteArmor> LIMONITE_LEGGINS = ITEMS.register("limonite_leggings", 
			() -> new LimoniteArmor(ModArmorMaterial.LIMONITE, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<LimoniteArmor> LIMONITE_BOOTS = ITEMS.register("limonite_boots", 
			() -> new LimoniteArmor(ModArmorMaterial.LIMONITE, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor)));
	
	
	public static final RegistryObject<JadeArmor> JADE_HELMET = ITEMS.register("jade_helmet", 
			() -> new JadeArmor(ModArmorMaterial.JADE, EquipmentSlotType.HEAD, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<JadeArmor> JADE_CHESTPLATE = ITEMS.register("jade_chestplate", 
			() -> new JadeArmor(ModArmorMaterial.JADE, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<JadeArmor> JADE_LEGGINS = ITEMS.register("jade_leggings", 
			() -> new JadeArmor(ModArmorMaterial.JADE, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<JadeArmor> JADE_BOOTS = ITEMS.register("jade_boots", 
			() -> new JadeArmor(ModArmorMaterial.JADE, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor)));
	
	
	public static final RegistryObject<BlazingArmor> BLAZING_HELMET = ITEMS.register("blazing_helmet", 
			() -> new BlazingArmor(ModArmorMaterial.BLAZING, EquipmentSlotType.HEAD, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	public static final RegistryObject<BlazingArmor> BLAZING_CHESTPLATE = ITEMS.register("blazing_chestplate", 
			() -> new BlazingArmor(ModArmorMaterial.BLAZING, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	public static final RegistryObject<BlazingArmor> BLAZING_LEGGINS = ITEMS.register("blazing_leggings", 
			() -> new BlazingArmor(ModArmorMaterial.BLAZING, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	public static final RegistryObject<BlazingArmor> BLAZING_BOOTS = ITEMS.register("blazing_boots", 
			() -> new BlazingArmor(ModArmorMaterial.BLAZING, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	
	public static final RegistryObject<RubyArmor> RUBY_HELMET = ITEMS.register("ruby_helmet", 
			() -> new RubyArmor(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<RubyArmor> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate", 
			() -> new RubyArmor(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<RubyArmor> RUBY_LEGGINS = ITEMS.register("ruby_leggings", 
			() -> new RubyArmor(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<RubyArmor> RUBY_BOOTS = ITEMS.register("ruby_boots", 
			() -> new RubyArmor(ModArmorMaterial.RUBY, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor)));
	
	
	public static final RegistryObject<SaphireArmor> SAPHIRE_HELMET = ITEMS.register("saphire_helmet", 
			() -> new SaphireArmor(ModArmorMaterial.SAPHIRE, EquipmentSlotType.HEAD, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<SaphireArmor> SAPHIRE_CHESTPLATE = ITEMS.register("saphire_chestplate", 
			() -> new SaphireArmor(ModArmorMaterial.SAPHIRE, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<SaphireArmor> SAPHIRE_LEGGINS = ITEMS.register("saphire_leggings", 
			() -> new SaphireArmor(ModArmorMaterial.SAPHIRE, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor)));
	
	public static final RegistryObject<SaphireArmor> SAPHIRE_BOOTS = ITEMS.register("saphire_boots", 
			() -> new SaphireArmor(ModArmorMaterial.SAPHIRE, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor)));
	
	
	public static final RegistryObject<EnderiteArmor> ENDREITE_HELMET = ITEMS.register("enderite_helmet", EnderiteHelmet::new);
	
	public static final RegistryObject<EnderiteArmor> ENDREITE_CHESTPLATE = ITEMS.register("enderite_chestplate", 
			() -> new EnderiteArmor(ModArmorMaterial.ENDERITE, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	public static final RegistryObject<EnderiteArmor> ENDREITE_ELYTRA = ITEMS.register("enderite_elytra", EnderiteElytra::new);
	
	public static final RegistryObject<EnderiteArmor> ENDREITE_LEGGINS = ITEMS.register("enderite_leggings", 
			() -> new EnderiteArmor(ModArmorMaterial.ENDERITE, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	public static final RegistryObject<EnderiteArmor> ENDREITE_BOOTS = ITEMS.register("enderite_boots", 
			() -> new EnderiteArmor(ModArmorMaterial.ENDERITE, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	
	public static final RegistryObject<NightArmor> NIGHT_HELMET = ITEMS.register("night_helmet", NightHelmet::new);
	
	public static final RegistryObject<NightArmor> NIGHT_CHESTPLATE = ITEMS.register("night_chestplate", 
			() -> new NightArmor(ModArmorMaterial.NIGHT, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	public static final RegistryObject<NightArmor> NIGHT_ELYTRA = ITEMS.register("night_elytra", NightElytra::new);
	
	public static final RegistryObject<NightArmor> NIGHT_LEGGINS = ITEMS.register("night_leggings", 
			() -> new NightArmor(ModArmorMaterial.NIGHT, EquipmentSlotType.LEGS, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
	public static final RegistryObject<NightArmor> NIGHT_BOOTS = ITEMS.register("night_boots", 
			() -> new NightArmor(ModArmorMaterial.NIGHT, EquipmentSlotType.FEET, new Item.Properties().group(Cave.Armor).isImmuneToFire()));
	
}
