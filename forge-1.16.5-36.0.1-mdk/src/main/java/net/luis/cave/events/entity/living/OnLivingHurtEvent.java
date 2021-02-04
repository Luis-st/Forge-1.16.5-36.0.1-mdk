package net.luis.cave.events.entity.living;

import net.luis.cave.Cave;
import net.luis.cave.api.lib.PlayerManager;
import net.luis.cave.common.enums.CaveArmorMaterial;
import net.luis.cave.init.ModEnchantment;
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
			int EnchElytraFalling = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.ELYTRA_FALLING.get(), item);
			
			if (EnchElytraFalling == 1) {
				
				if (source == DamageSource.FLY_INTO_WALL) {
					
					event.setCanceled(true);
					
				}
				
			}
			
			if (PlayerManager.hasArmor(player, CaveArmorMaterial.BLAZING)) {
				
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
	
}

