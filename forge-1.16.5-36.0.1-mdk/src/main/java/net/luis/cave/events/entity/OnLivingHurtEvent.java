package net.luis.cave.events.entity;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveArmor;
import net.luis.cave.init.CaveEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnLivingHurtEvent {
	
	@SubscribeEvent
	public static void LivingHurt(LivingHurtEvent event) {
		
		LivingEntity entity = event.getEntityLiving();
		DamageSource source = event.getSource();
		
		if (entity instanceof PlayerEntity) {
			
			PlayerEntity player = (PlayerEntity) entity;
			ItemStack item = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
			int EnchElytraFalling = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.ELYTRA_FALLING.get(), item);
			
			if (EnchElytraFalling == 1) {
				
				if (source == DamageSource.FLY_INTO_WALL) {
					
					event.setCanceled(true);
					
				}
				
			}
			
			if (hasBlazingArmor(player)) {
				
				if (source == DamageSource.IN_FIRE) {
					
					event.setCanceled(true);
					
				} else if (source == DamageSource.ON_FIRE) {
					
					event.setCanceled(true);
					
				} else if (source == DamageSource.HOT_FLOOR) {
					
					event.setCanceled(true);
					
				} else if (source == DamageSource.LAVA) {
					
					event.setCanceled(true);
					
				}
				
			}
			
		}
		
	}
	
	private static boolean hasBlazingArmor(PlayerEntity player) {
		
		if (player.getItemStackFromSlot(EquipmentSlotType.HEAD).equals(CaveArmor.BLAZING_HELMET.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.CHEST).equals(CaveArmor.BLAZING_CHESTPLATE.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.LEGS).equals(CaveArmor.BLAZING_LEGGINS.get().getDefaultInstance(), true) &&
			player.getItemStackFromSlot(EquipmentSlotType.FEET).equals(CaveArmor.BLAZING_BOOTS.get().getDefaultInstance(), true)) {
					
			return true;
					
		} else {
					
			return false;
					
		}
		
	}

}

