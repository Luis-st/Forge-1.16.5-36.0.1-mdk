package net.luis.cave.init;

import net.luis.cave.Cave;
import net.luis.cave.blocks.container.SmeltingContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CaveContainer {
	
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Cave.Mod_Id);
	
	
	public static final RegistryObject<ContainerType<?>> SMELTING_CONTAINER = CONTAINERS.register("smelting_container", 
			() -> IForgeContainerType.create(SmeltingContainer::new));
	
}
