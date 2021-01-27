package net.luis.cave.events.entity.player.interact;

import java.util.Map;

import net.luis.cave.Cave;
import net.luis.cave.lib.EnchantmentManager;
import net.luis.cave.lib.ItemManager;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnRightClickBlockEvent {
	
	@SubscribeEvent
	public static void PlayerInteract(PlayerInteractEvent.RightClickBlock event) {
		
		PlayerEntity player = event.getPlayer();
		BlockPos pos = event.getPos();
		World world = event.getWorld();
		BlockState state = world.getBlockState(pos);
		
		if (!player.getHeldItemMainhand().isEmpty() && player.getHeldItemMainhand().isEnchantable()) {
			
			Map<Enchantment, Integer> rngEnch = EnchantmentManager.addRandomEnchantment(player.getHeldItemMainhand(), 30, true);
			
			if (!rngEnch.isEmpty()) {
				
				EnchantmentHelper.setEnchantments(rngEnch, player.getHeldItemMainhand());
				
			}
			
		}
		
		if (state.getBlock() instanceof CropsBlock) {
			
			CropsBlock cropsBlock = (CropsBlock) state.getBlock();
			int age = state.get(cropsBlock.getAgeProperty());
			
			if (!cropsBlock.isMaxAge(state)) {
			
				int newAge = MathHelper.nextInt(player.getRNG(), age + 1, cropsBlock.getMaxAge());
				world.setBlockState(pos, state.with(cropsBlock.getAgeProperty(), newAge), 3);
				
				if (!player.abilities.isCreativeMode) {
					
					ItemManager.damageItem(player.getHeldItemMainhand(), newAge > 5 ? 5 : newAge, player, e -> {
						
						e.sendBreakAnimation(EquipmentSlotType.MAINHAND);
						
					}, false);
					
				}
				
			}
			
		}

	}

}
