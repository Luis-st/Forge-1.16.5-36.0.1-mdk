package net.luis.cave.common.item;

import net.luis.cave.Cave;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class FungusSoup extends Item {

	public FungusSoup() {
		
		super(new Item.Properties()
					.group(Cave.FOOD)
					.maxStackSize(1)
					.food(new Food.Builder()
							.hunger(10)
							.saturation(8.2f)
							.effect(() -> new EffectInstance(Effects.RESISTANCE, 600, 4), 1)
							.effect(() -> new EffectInstance(Effects.MINING_FATIGUE, 600, 0), 0.25f)
							.setAlwaysEdible()
							.build()));
		
	}
	
	@Override
	public UseAction getUseAction(ItemStack stack) {
		
		return UseAction.EAT;
		
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);
		return entityLiving instanceof PlayerEntity && ((PlayerEntity)entityLiving).abilities.isCreativeMode ? itemstack : new ItemStack(Items.BOWL);
	}
	
}