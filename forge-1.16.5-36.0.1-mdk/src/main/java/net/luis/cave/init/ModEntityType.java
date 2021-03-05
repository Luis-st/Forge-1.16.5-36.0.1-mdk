package net.luis.cave.init;

import net.luis.cave.Cave;
import net.luis.cave.common.entities.DiamondArrow;
import net.luis.cave.common.entities.JadeArrow;
import net.luis.cave.common.entities.NetheriteArrow;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityType {
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Cave.MOD_ID);
	
	
	public static final RegistryObject<EntityType<JadeArrow>> JADE_ARROW = ENTITIES.register("jade_arrow", 
			() -> new EntityType<>(JadeArrow::new, EntityClassification.MISC, true, true, true, true, null, EntitySize.fixed(0.5f, 1.975f), 10, 10));
	
	public static final RegistryObject<EntityType<DiamondArrow>> DIAMOND_ARROW = ENTITIES.register("diamond_arrow", 
			() -> new EntityType<>(DiamondArrow::new, EntityClassification.MISC, false, true, true, false, null, EntitySize.fixed(0.5f, 1.975f), 10, 10));
	
	public static final RegistryObject<EntityType<NetheriteArrow>> NETHERITE_ARROW = ENTITIES.register("netherite_arrow", 
			() -> new EntityType<>(NetheriteArrow::new, EntityClassification.MISC, false, true, true, false, null, EntitySize.fixed(0.5f, 1.975f), 10, 10));

}
