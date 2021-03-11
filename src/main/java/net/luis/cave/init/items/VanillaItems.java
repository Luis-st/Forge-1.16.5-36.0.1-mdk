package net.luis.cave.init.items;

import net.luis.cave.Cave;
import net.luis.cave.api.item.api.tool.Shovel;
import net.luis.cave.api.item.api.weapon.Bow;
import net.luis.cave.api.item.api.weapon.Crossbow;
import net.luis.cave.common.item.star.NetherStar;
import net.luis.cave.common.item.vanilla.Sugar;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VanillaItems {
	
	public static final DeferredRegister<Item> VANILLA_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cave.MINECRAFT_ID);
	
	
	public static final RegistryObject<Sugar> SUGAR = VANILLA_ITEMS.register("sugar", Sugar::new);
	
	public static final RegistryObject<NetherStar> NETHER_STAR = VANILLA_ITEMS.register("nether_star", NetherStar::new);
	
	
	public static final RegistryObject<Crossbow> CROSSBOW = VANILLA_ITEMS.register("crossbow", 
			() -> new Crossbow(new Item.Properties().maxStackSize(1).maxDamage(326).group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<Bow> BOW = VANILLA_ITEMS.register("bow", 
			() -> new Bow(new Item.Properties().maxStackSize(1).maxDamage(384).group(ItemGroup.COMBAT)));
	
	
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

}
