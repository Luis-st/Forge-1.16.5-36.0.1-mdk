package net.luis.cave.items.shields;

import net.luis.cave.Cave;
import net.luis.cave.render.DiamondShieldRender;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

}