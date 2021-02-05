package net.luis.cave.init.items;

import net.luis.cave.Cave;
import net.luis.cave.api.item.tool.Shovel;
import net.luis.cave.api.item.weapon.Bow;
import net.luis.cave.api.item.weapon.Crossbow;
import net.luis.cave.common.enums.ModItemTier;
import net.luis.cave.common.item.shields.DiamondShield;
import net.luis.cave.common.item.shields.EnderiteShield;
import net.luis.cave.common.item.shields.GoldenShield;
import net.luis.cave.common.item.shields.IronShield;
import net.luis.cave.common.item.shields.NetheriteShield;
import net.luis.cave.common.item.shields.NightShield;
import net.luis.cave.common.item.weapons.EnderiteBow;
import net.luis.cave.common.item.weapons.EnderiteCrossbow;
import net.luis.cave.common.item.weapons.NetheriteBow;
import net.luis.cave.common.item.weapons.NetheriteCrossbow;
import net.luis.cave.common.item.weapons.NightBow;
import net.luis.cave.common.item.weapons.NightCrossbow;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTools {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cave.Mod_Id);
	public static final DeferredRegister<Item> VANILLA_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cave.Minecraft_Id);
	
	
	public static final RegistryObject<Shovel> JADE_SHOVEL = ITEMS.register("jade_shovel", 
			() -> new Shovel(ModItemTier.JADE, (float) -1.5, -3.0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<PickaxeItem> JADE_PICKAXE = ITEMS.register("jade_pickaxe", 
			() -> new PickaxeItem(ModItemTier.JADE, -2, -2.8f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<AxeItem> JADE_AXE = ITEMS.register("jade_axe", 
			() -> new AxeItem(ModItemTier.JADE, 3, -3.1f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<HoeItem> JADE_HOE = ITEMS.register("jade_hoe", 
			() -> new HoeItem(ModItemTier.JADE, -5, -0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<SwordItem> JADE_SWORD = ITEMS.register("jade_sword", 
			() -> new SwordItem(ModItemTier.JADE, 0, -2.4f, new Item.Properties().group(Cave.WEAPONS)));
	
	
	public static final RegistryObject<Shovel> LIMONITE_SHOVEL = ITEMS.register("limonite_shovel", 
			() -> new Shovel(ModItemTier.LIMONITE, (float) -0.5, -3.0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<PickaxeItem> LIMONITE_PICKAXE = ITEMS.register("limonite_pickaxe", 
			() -> new PickaxeItem(ModItemTier.LIMONITE, -1, -2.8f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<AxeItem> LIMONITE_AXE = ITEMS.register("limonite_axe", 
			() -> new AxeItem(ModItemTier.LIMONITE, 3, -3.1f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<HoeItem> LIMONITE_HOE = ITEMS.register("limonite_hoe", 
			() -> new HoeItem(ModItemTier.LIMONITE, -5, -0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<SwordItem> LIMONITE_SWORD = ITEMS.register("limonite_sword", 
			() -> new SwordItem(ModItemTier.LIMONITE, 1, -2.4f, new Item.Properties().group(Cave.WEAPONS)));
	
	
	public static final RegistryObject<Shovel> BLAZING_SHOVEL = ITEMS.register("blazing_shovel", 
			() -> new Shovel(ModItemTier.BLAZING, (float) -0.5, -3.0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<PickaxeItem> BLAZING_PICKAXE = ITEMS.register("blazing_pickaxe", 
			() -> new PickaxeItem(ModItemTier.BLAZING, -1, -2.8f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<AxeItem> BLAZING_AXE = ITEMS.register("blazing_axe", 
			() -> new AxeItem(ModItemTier.BLAZING, 3, -3.0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<SwordItem> BLAZING_SWORD = ITEMS.register("blazing_sword", 
			() -> new SwordItem(ModItemTier.BLAZING, 1, -2.4f, new Item.Properties().group(Cave.WEAPONS)));
	
	
	public static final RegistryObject<Shovel> RUBY_SHOVEL = ITEMS.register("ruby_shovel", 
			() -> new Shovel(ModItemTier.RUBY, (float) -0.5, -3.0f, new Item.Properties().group(Cave.TOOLS)));
		
	public static final RegistryObject<SwordItem> RUBY_SWORD = ITEMS.register("ruby_sword", 
			() -> new SwordItem(ModItemTier.RUBY, 1, -2.4f, new Item.Properties().group(Cave.WEAPONS)));
		
	public static final RegistryObject<PickaxeItem> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", 
			() -> new PickaxeItem(ModItemTier.RUBY, -1, -2.8f, new Item.Properties().group(Cave.TOOLS)));
		
	public static final RegistryObject<AxeItem> RUBY_AXE = ITEMS.register("ruby_axe", 
			() -> new AxeItem(ModItemTier.RUBY, 3, -3.0f, new Item.Properties().group(Cave.TOOLS)));
		
	public static final RegistryObject<HoeItem> RUBY_HOE = ITEMS.register("ruby_hoe", 
			() -> new HoeItem(ModItemTier.RUBY, -7, -0f, new Item.Properties().group(Cave.TOOLS)));
	
	
	public static final RegistryObject<Shovel> SAPHIRE_SHOVEL = ITEMS.register("saphire_shovel", 
			() -> new Shovel(ModItemTier.SAPHIRE, (float) -0.5, -3.0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<PickaxeItem> SAPHIRE_PICKAXE = ITEMS.register("saphire_pickaxe", 
			() -> new PickaxeItem(ModItemTier.SAPHIRE, -1, -2.8f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<AxeItem> SAPHIRE_AXE = ITEMS.register("saphire_axe", 
			() -> new AxeItem(ModItemTier.SAPHIRE, 3, -3.0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<HoeItem> SAPHIRE_HOE = ITEMS.register("saphire_hoe", 
			() -> new HoeItem(ModItemTier.SAPHIRE, -6, -0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<SwordItem> SAPHIRE_SWORD = ITEMS.register("saphire_sword", 
			() -> new SwordItem(ModItemTier.SAPHIRE, 1, -2.4f, new Item.Properties().group(Cave.WEAPONS)));
	
	
	public static final RegistryObject<Shovel> ROSITE_SHOVEL = ITEMS.register("rosite_shovel", 
			() -> new Shovel(ModItemTier.ROSITE, (float) 2.5, -3.0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<PickaxeItem> ROSITE_PICKAXE = ITEMS.register("rosite_pickaxe", 
			() -> new PickaxeItem(ModItemTier.ROSITE, 2, -2.8f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<AxeItem> ROSITE_AXE = ITEMS.register("rosite_axe", 
			() -> new AxeItem(ModItemTier.ROSITE, 6, -3.0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<HoeItem> ROSITE_HOE = ITEMS.register("rosite_hoe", 
			() -> new HoeItem(ModItemTier.ROSITE, -7, -0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<SwordItem> ROSITE_SWORD = ITEMS.register("rosite_sword", 
			() -> new SwordItem(ModItemTier.ROSITE, 4, -2.4f, new Item.Properties().group(Cave.WEAPONS)));
	
	
	public static final RegistryObject<Shovel> ROSE_QUARTZ_SHOVEL = ITEMS.register("rose_quartz_shovel", 
			() -> new Shovel(ModItemTier.ROSE_QUARTZ, (float) 2.5, -3.0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<PickaxeItem> ROSE_QUARTZ_PICKAXE = ITEMS.register("rose_quartz_pickaxe", 
			() -> new PickaxeItem(ModItemTier.ROSE_QUARTZ, 2, -2.8f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<AxeItem> ROSE_QUARTZ_AXE = ITEMS.register("rose_quartz_axe", 
			() -> new AxeItem(ModItemTier.ROSE_QUARTZ, 6, -3.0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<HoeItem> ROSE_QUARTZ_HOE = ITEMS.register("rose_quartz_hoe", 
			() -> new HoeItem(ModItemTier.ROSE_QUARTZ, -10, -0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<SwordItem> ROSE_QUARTZ_SWORD = ITEMS.register("rose_quartz_sword", 
			() -> new SwordItem(ModItemTier.ROSE_QUARTZ, 4, -2.4f, new Item.Properties().group(Cave.WEAPONS)));
	
	
	public static final RegistryObject<Shovel> STEEL_SHOVEL = ITEMS.register("steel_shovel", 
			() -> new Shovel(ModItemTier.STEEL, (float) -0.5, -3.0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", 
			() -> new PickaxeItem(ModItemTier.STEEL, -1, -2.8f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe", 
			() -> new AxeItem(ModItemTier.STEEL, 3, -3.0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe", 
			() -> new HoeItem(ModItemTier.STEEL, -6, -0f, new Item.Properties().group(Cave.TOOLS)));
	
	public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", 
			() -> new SwordItem(ModItemTier.STEEL, 1, -2.4f, new Item.Properties().group(Cave.WEAPONS)));
	
	
	public static final RegistryObject<Shovel> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel", 
			() -> new Shovel(ModItemTier.ENDERITE, (float) -2.5, -3.0f, new Item.Properties().group(Cave.TOOLS).isImmuneToFire()));
	
	public static final RegistryObject<PickaxeItem> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe", 
			() -> new PickaxeItem(ModItemTier.ENDERITE, -3, -2.8f, new Item.Properties().group(Cave.TOOLS).isImmuneToFire()));
	
	public static final RegistryObject<AxeItem> ENDERITE_AXE = ITEMS.register("enderite_axe", 
			() -> new AxeItem(ModItemTier.ENDERITE, 1, -3.0f, new Item.Properties().group(Cave.TOOLS).isImmuneToFire()));
	
	public static final RegistryObject<HoeItem> ENDERITE_HOE = ITEMS.register("enderite_hoe", 
			() -> new HoeItem(ModItemTier.ENDERITE, -20, -0f, new Item.Properties().group(Cave.TOOLS).isImmuneToFire()));	
	
	public static final RegistryObject<SwordItem> ENDERITE_SWORD = ITEMS.register("enderite_sword", 
			() -> new SwordItem(ModItemTier.ENDERITE, -1, -2.4f, new Item.Properties().group(Cave.WEAPONS).isImmuneToFire()));
	
	
	public static final RegistryObject<Shovel> NIGHT_SHOVEL = ITEMS.register("night_shovel", 
			() -> new Shovel(ModItemTier.NIGHT, (float) -2.5, -3.0f, new Item.Properties().group(Cave.TOOLS).isImmuneToFire()));
	
	public static final RegistryObject<PickaxeItem> NIGHT_PICKAXE = ITEMS.register("night_pickaxe", 
			() -> new PickaxeItem(ModItemTier.NIGHT, -3, -2.8f, new Item.Properties().group(Cave.TOOLS).isImmuneToFire()));
	
	public static final RegistryObject<AxeItem> NIGHT_AXE = ITEMS.register("night_axe", 
			() -> new AxeItem(ModItemTier.NIGHT, 1, -3.0f, new Item.Properties().group(Cave.TOOLS).isImmuneToFire()));
	
	public static final RegistryObject<HoeItem> NIGHT_HOE = ITEMS.register("night_hoe", 
			() -> new HoeItem(ModItemTier.NIGHT, -25, -0f, new Item.Properties().group(Cave.TOOLS).isImmuneToFire()));	
	
	public static final RegistryObject<SwordItem> NIGHT_SWORD = ITEMS.register("night_sword", 
			() -> new SwordItem(ModItemTier.NIGHT, -1, -2.4f, new Item.Properties().group(Cave.WEAPONS).isImmuneToFire()));
	
	
	public static final RegistryObject<Item> BOW = VANILLA_ITEMS.register("bow", 
			() -> new Bow(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).maxDamage(384)));
	
	public static final RegistryObject<Item> NETHERITE_BOW = ITEMS.register("netherite_bow", NetheriteBow::new);
	
	public static final RegistryObject<Item> ENDERITE_BOW = ITEMS.register("enderite_bow", EnderiteBow::new);
	
	public static final RegistryObject<Item> NIGHT_BOW = ITEMS.register("night_bow", NightBow::new);
	
	
	public static final RegistryObject<Item> CROSSBOW = VANILLA_ITEMS.register("crossbow", 
			() -> new Crossbow(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).maxDamage(326)));
	
	public static final RegistryObject<Item> NETHERITE_CROSSBOW = ITEMS.register("netherite_crossbow", NetheriteCrossbow::new);
	
	public static final RegistryObject<Item> ENDERITE_CROSSBOW = ITEMS.register("enderite_crossbow", EnderiteCrossbow::new);
	
	public static final RegistryObject<Item> NIGHT_CROSSBOW = ITEMS.register("night_crossbow", NightCrossbow::new);
	
	
	public static final RegistryObject<Item> IRON_SHIELD = ITEMS.register("iron_shield", IronShield::new);
	
	public static final RegistryObject<Item> GOLDEN_SHIELD = ITEMS.register("golden_shield", GoldenShield::new);
	
	public static final RegistryObject<Item> DIAMOND_SHIELD = ITEMS.register("diamond_shield", DiamondShield::new);
	
	public static final RegistryObject<Item> NETHERITE_SHIELD = ITEMS.register("netherite_shield", NetheriteShield::new);
	
	public static final RegistryObject<Item> ENDERITE_SHIELD = ITEMS.register("enderite_shield", EnderiteShield::new);
	
	public static final RegistryObject<Item> NIGHT_SHIELD = ITEMS.register("night_shield", NightShield::new);
	
}
