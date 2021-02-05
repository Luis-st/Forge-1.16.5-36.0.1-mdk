package net.luis.cave.init.items;

import net.luis.cave.Cave;
import net.luis.cave.common.item.star.NetherStar;
import net.luis.cave.common.item.vanilla.Sugar;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class VanillaItems {
	
	public static final DeferredRegister<Item> VANILLA_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cave.Minecraft_Id);
	
	
	public static final RegistryObject<Item> SUGAR = VANILLA_ITEMS.register("sugar", Sugar::new);
	
	public static final RegistryObject<Item> NETHER_STAR = VANILLA_ITEMS.register("nether_star", NetherStar::new);
	
	

}
