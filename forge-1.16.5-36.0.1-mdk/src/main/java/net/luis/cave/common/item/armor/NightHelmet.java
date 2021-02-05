package net.luis.cave.common.item.armor;

import net.luis.cave.Cave;
import net.luis.cave.api.item.NightArmor;
import net.luis.cave.common.enums.ModArmorMaterial;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class NightHelmet extends NightArmor {
	
	public NightHelmet() {
		
		super(ModArmorMaterial.NIGHT, EquipmentSlotType.HEAD, new Item.Properties().group(Cave.Armor).isImmuneToFire());
		
		DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);

	}
	
	@Override
	public boolean isEnderMask(ItemStack stack, PlayerEntity player, EndermanEntity endermanEntity) {
		
		return true;
		
	}

}
