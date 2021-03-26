package net.luis.cave.common.item.armor;

import net.luis.cave.Cave;
import net.luis.cave.api.item.api.armor.mod.EnderiteArmor;
import net.luis.cave.common.enums.ModArmorMaterial;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.world.World;

public class EnderiteElytra extends EnderiteArmor {

	public EnderiteElytra() {
		
		super(ModArmorMaterial.ENDERITE, EquipmentSlotType.CHEST, new Item.Properties().group(Cave.Armor).rarity(Rarity.RARE).isImmuneToFire());
		
		DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);

	}
	
	@Override
	public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
		
		return ElytraItem.isUsable(stack);
		
	}
	
	@Override
	public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
		
		if (!entity.world.isRemote && (flightTicks + 1) % 60 == 0) {
			
			stack.damageItem(1, entity, e -> e.sendBreakAnimation(net.minecraft.inventory.EquipmentSlotType.CHEST));
			
		}
		
		return true;
		
	}
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {

		player.fallDistance = 0;
		
	}

}
