package net.luis.cave.events.item;

import java.util.List;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveEnchantment;
import net.luis.cave.lib.ItemManager;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnLivingDropEvent {

	@SubscribeEvent
	public static void LivingDrop(LivingDropsEvent event) {
		
		List<ItemEntity> drops = (List<ItemEntity>) event.getDrops();
		LivingEntity target = event.getEntityLiving();
		Entity attacker = event.getSource().getTrueSource();
		
		if (attacker != null && attacker instanceof PlayerEntity) {
			
			PlayerEntity player = (PlayerEntity) attacker;
			int enchTelekinesis = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.TELEKINESIS.get(), player.getHeldItemMainhand());
			
			if (!(target instanceof PlayerEntity) && !(target instanceof ServerPlayerEntity)) {
				
				if (enchTelekinesis > 0) {
					
					drops.forEach(item -> {
						
						ItemHandlerHelper.giveItemToPlayer(player, item.getItem());
						
					});
					
					event.setCanceled(true);
					
				} else {
					
					setNoGravity(drops);
					
				}
				
			} else {
				
				setNoGravity(drops);
				
			}
			
		} else {
			
			setNoGravity(drops);
			
		}
		
	}
	
	private static void setNoGravity(List<ItemEntity> drops) {
		
		drops.forEach(item -> {
			
			ItemEntity itemEntity = (ItemEntity) item.getItem().getAttachedEntity();
			
			if (ItemManager.isEnderite(itemEntity.getItem())) {
				
				itemEntity.setInvulnerable(true);
				itemEntity.setNoGravity(true);
				itemEntity.setMotion(0, 0, 0);
				
				if (itemEntity.getPosY() < 0) {
					
					itemEntity.setPositionAndUpdate(itemEntity.getPosX(), 3, itemEntity.getPosZ());
					itemEntity.setInvulnerable(false);
					
				}
				
			} else if (ItemManager.isNight(itemEntity.getItem())) {
				
				itemEntity.setInvulnerable(true);
				itemEntity.setNoGravity(true);
				itemEntity.setMotion(0, 0, 0);
				
				if (itemEntity.getPosY() < 0) {
					
					itemEntity.setPositionAndUpdate(itemEntity.getPosX(), 3, itemEntity.getPosZ());
					itemEntity.setInvulnerable(false);
					
				}
				
			}
			
		});
		
	}

}
