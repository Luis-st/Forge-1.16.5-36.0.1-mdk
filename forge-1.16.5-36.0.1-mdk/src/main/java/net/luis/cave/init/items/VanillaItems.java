package net.luis.cave.init.items;

import net.luis.cave.Cave;
import net.luis.cave.api.item.armor.vanilla.ChainArmor;
import net.luis.cave.api.item.armor.vanilla.DiamondArmor;
import net.luis.cave.api.item.armor.vanilla.GoldArmor;
import net.luis.cave.api.item.armor.vanilla.IronArmor;
import net.luis.cave.api.item.armor.vanilla.LeatherArmor;
import net.luis.cave.api.item.armor.vanilla.NetheriteArmor;
import net.luis.cave.api.item.armor.vanilla.TurtleArmor;
import net.luis.cave.api.item.tool.Shovel;
import net.luis.cave.api.item.weapon.Bow;
import net.luis.cave.api.item.weapon.Crossbow;
import net.luis.cave.common.enums.VanillaArmorMaterial;
import net.luis.cave.common.item.star.NetherStar;
import net.luis.cave.common.item.vanilla.Sugar;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VanillaItems {
	
	public static final DeferredRegister<Item> VANILLA_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cave.Minecraft_Id);
	
	
	public static final RegistryObject<Sugar> SUGAR = VANILLA_ITEMS.register("sugar", Sugar::new);
	
	public static final RegistryObject<NetherStar> NETHER_STAR = VANILLA_ITEMS.register("nether_star", NetherStar::new);
	
	
	public static final RegistryObject<Crossbow> CROSSBOW = VANILLA_ITEMS.register("crossbow", 
			() -> new Crossbow(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).maxDamage(326)));
	
	public static final RegistryObject<Bow> BOW = VANILLA_ITEMS.register("bow", 
			() -> new Bow(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).maxDamage(384)));
	
	
	public static final RegistryObject<Shovel> WOODEN_SHOVEL = VANILLA_ITEMS.register("wooden_shovel", 
			() -> new Shovel(ItemTier.WOOD, 1.5F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));
	
	public static final RegistryObject<Shovel> STONE_SHOVEL = VANILLA_ITEMS.register("stone_shovel", 
			() -> new Shovel(ItemTier.STONE, 1.5F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));
	
	public static final RegistryObject<Shovel> IRON_SHOVEL = VANILLA_ITEMS.register("iron_shovel", 
			() -> new Shovel(ItemTier.IRON, 1.5F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));
	
	public static final RegistryObject<Shovel> GOLDEN_SHOVEL = VANILLA_ITEMS.register("golden_shovel", 
			() -> new Shovel(ItemTier.GOLD, 1.5F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));
	
	public static final RegistryObject<Shovel> DIAMOND_SHOVEL = VANILLA_ITEMS.register("diamond_shovel", 
			() -> new Shovel(ItemTier.DIAMOND, 1.5F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS)));
	
	public static final RegistryObject<Shovel> NETHERITE_SHOVEL = VANILLA_ITEMS.register("netherite_shovel", 
			() -> new Shovel(ItemTier.NETHERITE, 1.5F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS).isImmuneToFire()));
	

	public static final RegistryObject<LeatherArmor> LEATHER_HELMET = VANILLA_ITEMS.register("leather_helmet", 
			() -> new LeatherArmor(VanillaArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<LeatherArmor> LEATHER_CHESTPLATE = VANILLA_ITEMS.register("leather_chestplate", 
			() -> new LeatherArmor(VanillaArmorMaterial.LEATHER, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<LeatherArmor> LEATHER_LEGGINS = VANILLA_ITEMS.register("leather_leggings", 
			() -> new LeatherArmor(VanillaArmorMaterial.LEATHER, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<LeatherArmor> LEATHER_BOOTS = VANILLA_ITEMS.register("leather_boots", 
			() -> new LeatherArmor(VanillaArmorMaterial.LEATHER, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
	
	
	public static final RegistryObject<ChainArmor> CHAIN_HELMET = VANILLA_ITEMS.register("chainmail_helmet", 
			() -> new ChainArmor(VanillaArmorMaterial.CHAIN, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<ChainArmor> CHAIN_CHESTPLATE = VANILLA_ITEMS.register("chainmail_chestplate", 
			() -> new ChainArmor(VanillaArmorMaterial.CHAIN, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<ChainArmor> CHAIN_LEGGINS = VANILLA_ITEMS.register("chainmail_leggings", 
			() -> new ChainArmor(VanillaArmorMaterial.CHAIN, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<ChainArmor> CHAIN_BOOTS = VANILLA_ITEMS.register("chainmail_boots", 
			() -> new ChainArmor(VanillaArmorMaterial.CHAIN, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
	
	
	public static final RegistryObject<IronArmor> IRON_HELMET = VANILLA_ITEMS.register("iron_helmet", 
			() -> new IronArmor(VanillaArmorMaterial.IRON, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<IronArmor> IRON_CHESTPLATE = VANILLA_ITEMS.register("iron_chestplate", 
			() -> new IronArmor(VanillaArmorMaterial.IRON, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<IronArmor> IRON_LEGGINS = VANILLA_ITEMS.register("iron_leggings", 
			() -> new IronArmor(VanillaArmorMaterial.IRON, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<IronArmor> IRON_BOOTS = VANILLA_ITEMS.register("iron_boots", 
			() -> new IronArmor(VanillaArmorMaterial.IRON, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
	
	
	public static final RegistryObject<GoldArmor> GOLD_HELMET = VANILLA_ITEMS.register("golden_helmet", 
			() -> new GoldArmor(VanillaArmorMaterial.GOLD, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<GoldArmor> GOLD_CHESTPLATE = VANILLA_ITEMS.register("golden_chestplate", 
			() -> new GoldArmor(VanillaArmorMaterial.GOLD, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<GoldArmor> GOLD_LEGGINS = VANILLA_ITEMS.register("golden_leggings", 
			() -> new GoldArmor(VanillaArmorMaterial.GOLD, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<GoldArmor> GOLD_BOOTS = VANILLA_ITEMS.register("golden_boots", 
			() -> new GoldArmor(VanillaArmorMaterial.GOLD, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
	
	
	public static final RegistryObject<DiamondArmor> DIAMOND_HELMET = VANILLA_ITEMS.register("diamond_helmet", 
			() -> new DiamondArmor(VanillaArmorMaterial.DIAMOND, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<DiamondArmor> DIAMOND_CHESTPLATE = VANILLA_ITEMS.register("diamond_chestplate", 
			() -> new DiamondArmor(VanillaArmorMaterial.DIAMOND, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<DiamondArmor> DIAMOND_LEGGINS = VANILLA_ITEMS.register("diamond_leggings", 
			() -> new DiamondArmor(VanillaArmorMaterial.DIAMOND, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<DiamondArmor> DIAMOND_BOOTS = VANILLA_ITEMS.register("diamond_boots", 
			() -> new DiamondArmor(VanillaArmorMaterial.DIAMOND, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
	
	
	public static final RegistryObject<NetheriteArmor> NETHERITE_HELMET = VANILLA_ITEMS.register("netherite_helmet", 
			() -> new NetheriteArmor(VanillaArmorMaterial.NETHERITE, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<NetheriteArmor> NETHERITE_CHESTPLATE = VANILLA_ITEMS.register("netherite_chestplate", 
			() -> new NetheriteArmor(VanillaArmorMaterial.NETHERITE, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<NetheriteArmor> NETHERITE_LEGGINS = VANILLA_ITEMS.register("netherite_leggings", 
			() -> new NetheriteArmor(VanillaArmorMaterial.NETHERITE, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<NetheriteArmor> NETHERITE_BOOTS = VANILLA_ITEMS.register("netherite_boots", 
			() -> new NetheriteArmor(VanillaArmorMaterial.NETHERITE, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)));
	
	
	public static final RegistryObject<TurtleArmor> TURTLE_HELMET = VANILLA_ITEMS.register("turtle_helmet", 
			() -> new TurtleArmor(VanillaArmorMaterial.TURTLE, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)));

}
