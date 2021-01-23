package net.luis.cave.events.entity.player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.UUID;

import net.luis.cave.Cave;
import net.luis.cave.lib.ItemManager;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

@Mod.EventBusSubscriber(modid=Cave.Mod_Id, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class OnPlayerInteractEvent {
	
	private static final Method startConverting = ObfuscationReflectionHelper.findMethod(ZombieVillagerEntity.class, "func_191991_a", UUID.class, int.class);
	
	@SubscribeEvent
	public static void EntityInteractSpecific(PlayerInteractEvent.EntityInteractSpecific event) {
		
		PlayerEntity player = event.getPlayer();
		LivingEntity target = (LivingEntity) event.getTarget();
		World world = event.getWorld();
		
		if (target instanceof ZombieVillagerEntity) {
			
			ZombieVillagerEntity zombieVillager = (ZombieVillagerEntity) target;
			
			if (player.getHeldItem(event.getHand()).getItem() == Items.GOLDEN_APPLE) {
				
				if (!player.abilities.isCreativeMode) {
					
					player.getHeldItem(event.getHand()).shrink(1);
					
				}
				
				if (!world.isRemote) {
					
					try {
						
						startConverting.invoke(zombieVillager, player.getUniqueID(), 60);
						
					} catch (IllegalAccessException e) {
						
						e.printStackTrace();
						
					} catch (IllegalArgumentException e) {
						
						e.printStackTrace();
						
					} catch (InvocationTargetException e) {
						
						e.printStackTrace();
						
					}
					
				}
				
			}
			
		}

	}
	
	@SubscribeEvent
	public static void PlayerInteract(PlayerInteractEvent.RightClickBlock event) {
		
		PlayerEntity player = event.getPlayer();
		BlockPos pos = event.getPos();
		World world = event.getWorld();
		BlockState state = world.getBlockState(pos);
		
		if (state.getBlock() instanceof CropsBlock) {
			
			CropsBlock cropsBlock = (CropsBlock) state.getBlock();
			int age = state.get(cropsBlock.getAgeProperty());
			
			if (!cropsBlock.isMaxAge(state)) {
			
				int newAge = MathHelper.nextInt(player.getRNG(), age + 1, cropsBlock.getMaxAge());
				world.setBlockState(pos, state.with(cropsBlock.getAgeProperty(), newAge), 3);
				ItemManager.damageItem(player.getHeldItemMainhand(), newAge > 5 ? 5 : newAge, player, e -> {
					
					e.sendBreakAnimation(EquipmentSlotType.MAINHAND);
					
				}, false);
				
			}
			
		}

	}

}
