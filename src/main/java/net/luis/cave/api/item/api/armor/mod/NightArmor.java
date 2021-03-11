package net.luis.cave.api.item.api.armor.mod;

import net.luis.cave.api.item.api.armor.Armor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class NightArmor extends Armor {

	public NightArmor(IArmorMaterial material, EquipmentSlotType slot, Properties builder) {
		
		super(material, slot, builder);
		
	}
	
	@Override
	public void onCompleteArmorTick(ItemStack stack, World world, PlayerEntity player) {
		
		player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 400, 0, true, false));
		
	}

}
