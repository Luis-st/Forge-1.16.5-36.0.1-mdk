package net.luis.cave.events.client.entity.tick;

import java.util.Map.Entry;

import net.luis.cave.Cave;
import net.luis.cave.init.CaveEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
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
		Entry<EquipmentSlotType, ItemStack> enchCurseBreaking = EnchantmentHelper.getRandomItemWithEnchantment(CaveEnchantment.CURSE_OF_BREAKING.get(), player);
		EquipmentSlotType[] slot = new EquipmentSlotType[] {EquipmentSlotType.HEAD, EquipmentSlotType.CHEST, EquipmentSlotType.LEGS, EquipmentSlotType.FEET};
		ItemStack[] item = new ItemStack[] {player.getItemStackFromSlot(slot[0]), player.getItemStackFromSlot(slot[1]), 
											player.getItemStackFromSlot(slot[2]) , player.getItemStackFromSlot(slot[3])};
		int enchElytraFalling = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.ELYTRA_FALLING.get(), item[1]);
		int enchVoidWalker = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.VOID_WALKER.get(), item[3]);
		int enchGrowth = growthLevel(item);
		
		if (enchElytraFalling == 1) {
			
			player.fallDistance = 0f;
			
		}
		
		if (server != null) {
			
			if (server.isFlightAllowed()) {
				
				if (enchVoidWalker == 1) {
					
					voidWalker(world, player);
					
				}
				
			} else {
				
				server.setAllowFlight(true);
				
			}
			
		} else {
			
			if (enchVoidWalker == 1) {
				
				voidWalker(world, player);
				
			}
			
		}
		
		if (enchGrowth > 0) {
			
			player.getAttribute(net.minecraft.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(20 + enchGrowth);
			
		} else {
			
			player.getAttribute(net.minecraft.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(20);
			
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
	
	private static int growthLevel(ItemStack[] item) {
		
		int enchGrowthHead = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.GROWTH.get(), item[0]);
		int enchGrowthChest = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.GROWTH.get(), item[1]);
		int enchGrowthLegs = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.GROWTH.get(), item[2]);
		int enchGrowthFeet = EnchantmentHelper.getEnchantmentLevel(CaveEnchantment.GROWTH.get(), item[3]);
		
		return enchGrowthHead + enchGrowthChest + enchGrowthLegs + enchGrowthFeet;
		
	}
	
	private static void voidWalker(World world, PlayerEntity player) {
		
		player.fallDistance = 0f;
		
		if (!player.isSneaking()) {
	
			if (!world.getBlockState(new BlockPos(player.getPosX(), player.getPosY() - 1, player.getPosZ())).isSolid()) {
				
				if (player.getMotion().getY() < 0) {
					
					player.setMotion(player.getMotion().getX(), 0, player.getMotion().getZ());
					player.addPotionEffect(new EffectInstance(Effects.HASTE, 40, 1, false, false));
					
				}
				
			}
			
		}
		
	}

}
