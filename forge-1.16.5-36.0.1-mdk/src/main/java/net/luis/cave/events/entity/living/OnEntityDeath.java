package net.luis.cave.events.entity.living;

import net.luis.cave.Cave;
import net.luis.cave.init.items.ModItems;
import net.luis.cave.init.util.ModGameRules;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.ElderGuardianEntity;
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
			
			if (!world.getGameRules().getBoolean(ModGameRules.DISABLE_END_STAR_DROP.getRule())) {
				
				ItemEntity  item = new ItemEntity(world, entity.getPosX(), entity.getPosY(), entity.getPosZ(), new ItemStack(ModItems.END_STAR.get()));
				item.setPickupDelay(10);
				world.addEntity(item);
				
			}
			
		}
		
		if (entity instanceof ElderGuardianEntity) {
			
			if (!world.getGameRules().getBoolean(ModGameRules.DISABLE_WATER_STAR_DROP.getRule())) {
				
				ItemEntity  item = new ItemEntity(world, entity.getPosX(), entity.getPosY(), entity.getPosZ(), new ItemStack(ModItems.WATER_STAR.get()));
				item.setPickupDelay(10);
				world.addEntity(item);
				
			}
			
		}

	}

}
