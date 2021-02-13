package net.luis.cave.events.entity.living;

import java.util.List;

import net.luis.cave.Cave;
import net.luis.cave.api.lib.ItemManager;
import net.luis.cave.init.ModEnchantment;
import net.luis.cave.init.util.ModGameRule;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.world.World;
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
		World world = target.getEntityWorld();
		
		if (attacker != null && attacker instanceof PlayerEntity) {
			
			PlayerEntity player = (PlayerEntity) attacker;
			int enchTelekinesis = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.TELEKINESIS.get(), player.getHeldItemMainhand());
			
			if (!(target instanceof PlayerEntity) && !(target instanceof ServerPlayerEntity)) {
				
				if (enchTelekinesis > 0) {
					
					drops.forEach(item -> {
						
						ItemHandlerHelper.giveItemToPlayer(player, item.getItem());
						
					});
					
					event.setCanceled(true);
					
				} else {
					
					if (!world.getGameRules().getBoolean(ModGameRule.DISABLE_ITEM_GRAVITY.getRule())) {
						
						ItemManager.setNoGravityItem(drops);
						
					}
					
				}
				
			} else {
				
				if (!world.getGameRules().getBoolean(ModGameRule.DISABLE_ITEM_GRAVITY.getRule())) {
					
					ItemManager.setNoGravityItem(drops);
					
				}
				
			}
			
		} else {
			
			if (!world.getGameRules().getBoolean(ModGameRule.DISABLE_ITEM_GRAVITY.getRule())) {
				
				ItemManager.setNoGravityItem(drops);
				
			}
			
		}
		
	}
	
}
