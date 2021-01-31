package net.luis.cave.events.entity.player.tick;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveItems;
import net.luis.cave.world.CaveGameRules;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.FoodStats;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnOther {

	@SubscribeEvent
	public static void PlayerTick(TickEvent.PlayerTickEvent event) {

		PlayerEntity player = event.player;
		World world = player.getEntityWorld();
		
		if (event.side.isServer() && event.phase == TickEvent.Phase.START) {
			
			if (world.getGameRules().getBoolean(CaveGameRules.DISABLE_HUNGER.getRule())) {
				
				FoodStats foodStats = player.getFoodStats();
				foodStats.setFoodLevel(Math.min(foodStats.getFoodLevel() + 1, 20));
				
				if (!foodStats.needFood() && !player.shouldHeal() && foodStats.getSaturationLevel() == 0.0f) {
					
					foodStats.setFoodSaturationLevel(1.0f);
					
				}
				
			}
			
		}
		
		if (player.getHealth() != player.getAttribute(Attributes.MAX_HEALTH).getBaseValue()) {
			
			player.setHealth((float) player.getAttribute(Attributes.MAX_HEALTH).getBaseValue());
			
		}
		
		if (player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem() == CaveItems.MINING_STAR.get()) {
			
			player.addPotionEffect(new EffectInstance(new EffectInstance(Effects.SATURATION, 10, 0, false, false)));
			player.addPotionEffect(new EffectInstance(new EffectInstance(Effects.HASTE, 10, 2, true, false)));
			
		}
		
	}
	
}
