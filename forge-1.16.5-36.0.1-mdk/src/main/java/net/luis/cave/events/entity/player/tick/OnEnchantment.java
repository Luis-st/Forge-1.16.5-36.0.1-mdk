package net.luis.cave.events.entity.player.tick;

import java.util.Map.Entry;

import net.luis.cave.Cave;
import net.luis.cave.api.lib.EnchantmentManager;
import net.luis.cave.init.ModEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnEnchantment {

	@SubscribeEvent
	public static void PlayerTick(TickEvent.PlayerTickEvent event) {

		PlayerEntity player = event.player;
		World world = player.getEntityWorld();
		MinecraftServer server = world.getServer();
		Entry<EquipmentSlotType, ItemStack> enchCurseBreaking = EnchantmentHelper.getRandomItemWithEnchantment(ModEnchantment.CURSE_OF_BREAKING.get(), player);
		EquipmentSlotType[] slot = new EquipmentSlotType[] {EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET};
		ItemStack[] item = new ItemStack[] {player.getItemStackFromSlot(slot[0]), player.getItemStackFromSlot(slot[1]), 
											player.getItemStackFromSlot(slot[2]) , player.getItemStackFromSlot(slot[3])};
		int enchElytraFalling = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.ELYTRA_FALLING.get(), item[1]);
		int enchVoidWalker = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.VOID_WALKER.get(), item[3]);
		int enchGrowth = EnchantmentManager.growthLevel(item);
		int enchLavaWalker = EnchantmentHelper.getEnchantmentLevel(ModEnchantment.LAVA_WALKER.get(), item[3]);
		
		if (enchElytraFalling == 1) {
			
			player.fallDistance = 0f;
			
		}
		
		if (server != null) {
			
			if (server.isFlightAllowed()) {
				
				if (enchVoidWalker == 1) {
					
					EnchantmentManager.voidWalker(world, player);
					
				}
				
			} else {
				
				server.setAllowFlight(true);
				
			}
			
		} else {
			
			if (enchVoidWalker == 1) {
				
				EnchantmentManager.voidWalker(world, player);
				
			}
			
		}
		
		if (enchGrowth > 0) {
			
			player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20 + enchGrowth);
			
		} else {
			
			player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);
			
			if (player.getHealth() > 20) {
				
				player.setHealth(20);
				
			}
			
		}
		
		if (enchLavaWalker > 0) {
			
			EnchantmentManager.lavaWalker(player, world, player.getPosition());
			
		}
		
		if (world.getGameTime() % 60 == 0) {
			
			if (!player.abilities.isCreativeMode) {
				
				if (enchCurseBreaking != null) {
					
					ItemStack itemBreaking = enchCurseBreaking.getValue();
					EquipmentSlotType slotBreaking = enchCurseBreaking.getKey();
					
					double damage = itemBreaking.getMaxDamage() * 0.0025;	
					itemBreaking.damageItem((int) damage, player, e -> e.sendBreakAnimation(slotBreaking));
					
				}
				
			}
			
		}
		
	}
	
}
