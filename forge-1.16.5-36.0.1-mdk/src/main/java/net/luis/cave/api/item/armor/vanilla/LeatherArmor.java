package net.luis.cave.api.item.armor.vanilla;

import net.luis.cave.api.item.armor.Armor;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IDyeableArmorItem;

public class LeatherArmor extends Armor implements IDyeableArmorItem {

	public LeatherArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn) {
		
		super(materialIn, slot, builderIn);
		
	}

}
