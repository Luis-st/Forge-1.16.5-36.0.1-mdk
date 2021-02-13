package net.luis.cave.init.util;

import net.luis.cave.Cave;
import net.luis.cave.common.container.SmeltingContainer;
import net.luis.cave.common.container.chest.ModChestContainer9x7;
import net.luis.cave.common.container.chest.ModChestContainer9x8;
import net.luis.cave.common.container.chest.ModChestContainer9x9;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerType {
	
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Cave.Mod_Id);
	
	
	public static final RegistryObject<ContainerType<SmeltingContainer>> SMELTING_CONTAINER = CONTAINERS.register("smelting_container", 
			() -> IForgeContainerType.create(SmeltingContainer::new));
	
	public static final RegistryObject<ContainerType<ModChestContainer9x7>> GENERIC_9X7 = CONTAINERS.register("generic_9x7",
			() -> IForgeContainerType.create(ModChestContainer9x7::new));
	
	public static final RegistryObject<ContainerType<ModChestContainer9x8>> GENERIC_9X8 = CONTAINERS.register("generic_9x8", 
			() -> IForgeContainerType.create(ModChestContainer9x8::new));
	
	public static final RegistryObject<ContainerType<ModChestContainer9x9>> GENERIC_9X9 = CONTAINERS.register("generic_9x9", 
			() -> IForgeContainerType.create(ModChestContainer9x9::new));
	
}
