package net.luis.cave.common.item.shields;

import net.luis.cave.Cave;
import net.luis.cave.client.render.item.DiamondShieldRender;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;

public class DiamondShield extends ShieldItem {

	public DiamondShield() {
		
		super(new Item.Properties().group(Cave.WEAPONS)
				.maxStackSize(1)
				.maxDamage(4683)
				.setISTER(() -> DiamondShieldRender::new));
		DispenserBlock.registerDispenseBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
		
	}
	
	@Override
	public boolean isShield(ItemStack stack, LivingEntity entity) {
		
		return true;
		
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		
		return repair.getItem() == Items.DIAMOND || super.getIsRepairable(toRepair, repair);
		
	}

}
