package net.luis.cave.events.entity.living;

import net.luis.cave.Cave;
import net.luis.cave.api.lib.EntityManager;
import net.luis.cave.api.lib.PlayerManager;
import net.luis.cave.common.item.star.DamageStar;
import net.luis.cave.init.ModEnchantment;
import net.luis.cave.init.items.ModItems;
import net.luis.cave.init.util.ModGameRules;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnLivingDamageEvent {
	
	@SubscribeEvent
	public static void LivingDamage(LivingDamageEvent event) {
		
		Entity target = event.getEntity();
		Entity entity = event.getSource().getTrueSource();
		World world = target.getEntityWorld();
		float amount = event.getAmount();
		float newAmount = amount;
		
		if (entity instanceof PlayerEntity) {
			
			PlayerEntity player = (PlayerEntity) entity;
			int enchEnderSlayer = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.ENDER_SLYAER.get(), player.getHeldItemMainhand());
			int enchImpaling= EnchantmentHelper.getEnchantmentLevel(ModEnchantment.IMPALING.get(), player.getHeldItemMainhand());
			
			if (EntityManager.isEnderType(target)) {
				
				if (enchEnderSlayer > 0) {
					
					newAmount += (enchEnderSlayer * 2.5f) + enchEnderSlayer;
					
				}
				
			}
			
			if (EntityManager.isLavaType(target) || EntityManager.isWaterType(target)) {
				
				if (enchImpaling > 0) {
					
					newAmount += (enchImpaling * 2.5f) + enchImpaling;
					
				}
				
			}
			
			if (PlayerManager.getItem(player, ModItems.DAMAGE_STAR.get()).getItem() != ItemStack.EMPTY.getItem()) {
				
				ItemStack stack = PlayerManager.getItem(player, ModItems.DAMAGE_STAR.get());
				
				if (stack.getItem() instanceof DamageStar) {
					
					DamageStar star = (DamageStar) stack.getItem();
					int max = world.getGameRules().getInt(ModGameRules.MAX_BONUS_DAMAGE.getRule());
					final String tag = star.getTagName();
					
					newAmount += stack.getOrCreateChildTag(tag).getDouble(tag);
					
					if (max > stack.getOrCreateChildTag(tag).getDouble(tag)) {
						
						stack.getOrCreateChildTag(tag).putDouble(tag, stack.getOrCreateChildTag(tag).getDouble(tag) + 1);
						
					}
					
				}
				
			}
			
			if (target instanceof PlayerEntity) {
				
				boolean flag = (newAmount - amount) >= 10;
				float playerAmount = flag ? amount + 10 : newAmount;
				event.setAmount(playerAmount);
				
			} else {
				
				event.setAmount(newAmount);
				
			}
			
		}
		
	}

}
