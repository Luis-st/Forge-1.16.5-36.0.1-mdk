package net.luis.cave.events.entity;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEntityDeath {

	@SubscribeEvent
	public static void EntityDeath(LivingDeathEvent event) {
		
		Entity entity = event.getEntity();
		World world = entity.getEntityWorld();
		
		if (entity instanceof EnderDragonEntity) {
			
			ItemEntity  item = new ItemEntity(world, entity.getPosX(), entity.getPosY(), entity.getPosZ(), new ItemStack(CaveItems.END_STAR.get()));
			item.setPickupDelay(10);
			world.addEntity(item);
			
		}

	}

}
