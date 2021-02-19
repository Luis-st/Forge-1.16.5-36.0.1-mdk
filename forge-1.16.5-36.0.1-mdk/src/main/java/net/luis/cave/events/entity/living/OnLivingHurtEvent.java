package net.luis.cave.events.entity.living;

import net.luis.cave.Cave;
import net.luis.cave.api.entity.player.PlayerManager;
import net.luis.cave.common.enums.ModArmorMaterial;
import net.luis.cave.init.ModEnchantment;
import net.luis.cave.init.items.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.CooldownTracker;
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
			float health = player.getHealth();
			float amount = event.getAmount();
			ItemStack item = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
			int enchElytraFalling = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.ELYTRA_FALLING.get(), item);
			
			if (source == DamageSource.FLY_INTO_WALL) {
				
				if (enchElytraFalling > 1) {
					
					event.setCanceled(true);
					
				}
				
			}
			
			if (PlayerManager.hasArmor(player, ModArmorMaterial.BLAZING)) {
				
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
			
			if ((health - amount) <= 0) {
				
				if (PlayerManager.getItemInInventory(player, ModItems.DEATH_STAR.get()).getItem() != ItemStack.EMPTY.getItem()) {
					
					ItemStack stack = PlayerManager.getItemInInventory(player, ModItems.DEATH_STAR.get());
					CooldownTracker cooldownTracker = player.getCooldownTracker();
					
					if (!cooldownTracker.hasCooldown(stack.getItem())) {
						
						event.setCanceled(true);
						cooldownTracker.setCooldown(stack.getItem(), 24000);
						
					}
					
				}
				
			}
			
		}
		
	}
	
}

