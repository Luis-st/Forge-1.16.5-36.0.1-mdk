package net.luis.cave.items.armor;

import net.luis.cave.util.lib.PlayerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class NightArmor extends ArmorItem {

	public NightArmor(IArmorMaterial material, EquipmentSlotType slot, Properties builder) {
		
		super(material, slot, builder);
		
	}
	
	@Override
	public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
		
		if (PlayerManager.hasArmor(player, material)) {
			
			player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 400, 0, true, false));
			
		}
		
	}

}
