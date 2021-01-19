package net.luis.cave.events.entity.player.tick;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveArmor;
import net.luis.cave.init.CaveItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnArmor {

	@SubscribeEvent
	public static void PlayerTick(TickEvent.PlayerTickEvent event) {

		PlayerEntity player = event.player;
		
		if (hasSaphireArmor(player)) {
			
			player.fallDistance = 0f;
			player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 10, 3, true, false));
			
		}
		
		if (hasNightArmor(player)) {
			
			player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 400, 0, true, false));
			
		}
		
		if (player.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem() == CaveItems.MINING_STAR.get()) {
			
			player.addPotionEffect(new EffectInstance(new EffectInstance(Effects.SATURATION, 10, 0, false, false)));
			player.addPotionEffect(new EffectInstance(new EffectInstance(Effects.HASTE, 10, 2, true, false)));
			
		}
		
	}
	
	private static boolean hasSaphireArmor(PlayerEntity player) {
		
		if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).equals(CaveArmor.SAPHIRE_HELMET.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.CHEST).equals(CaveArmor.SAPHIRE_CHESTPLATE.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.LEGS).equals(CaveArmor.SAPHIRE_LEGGINS.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.FEET).equals(CaveArmor.SAPHIRE_BOOTS.get().getDefaultInstance(), true)) {
				
			return true;
				
		} else {
				
			return false;
				
		}
		
	}
	
	private static boolean hasNightArmor(PlayerEntity player) {
		
		if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).equals(CaveArmor.NIGHT_HELMET.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.CHEST).equals(CaveArmor.NIGHT_HELMET.get().getDefaultInstance(), true) || 
			player.getItemStackFromSlot(EquipmentSlotType.CHEST).equals(CaveArmor.NIGHT_ELYTRA.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.LEGS).equals(CaveArmor.NIGHT_LEGGINS.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.FEET).equals(CaveArmor.NIGHT_BOOTS.get().getDefaultInstance(), true)) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
		
	}

}
