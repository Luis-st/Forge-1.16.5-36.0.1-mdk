package net.luis.cave.common.enums;

import com.google.common.base.Supplier;

import net.luis.cave.init.items.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum CaveItemTier implements IItemTier {
	
	//Harvest Level, Durability, Efficiency, Attack Damage, 
	//Enchantability, Repair Material
	LIMONITE(3, 2031, 11.0f, 4.0f, 23, () -> {
		
		return Ingredient.fromItems(ModItems.LIMONITE_INGOT.get());
		
	}),
	
	JADE(2, 1561, 7.0f, 6.0f, 65, () -> {
		
		return Ingredient.fromItems(ModItems.JADE_INGOT.get());
		
	}),
	
	BLAZING(3, 1247, 8.0f, 6.0f, 15, () -> {
		
		return Ingredient.fromItems(ModItems.BLAZING_INGOT.get());
		
	}),
	
	RUBY(3, 2031, 7.0f, 7.0f, 17, () -> {
		
		return Ingredient.fromItems(ModItems.RUBY.get());
		
	}),
	
	SAPHIRE(3, 1746, 10.0f, 6.0f, 28, () -> {
		
		return Ingredient.fromItems(ModItems.SAPHIRE_INGOT.get());
		
	}),
	
	ROSITE(2, 1287, 6.5f, 7.0f, 24, () -> {
		
		return Ingredient.fromItems(ModItems.ROSITE_INGOT.get());
		
	}),
	
	ROSE_QUARTZ(1, 517, 6.0f, 10.0f, 27, () -> {
		
		return Ingredient.fromItems(ModItems.POLISHED_ROSE_QUARTZ.get());
		
	}),
	
	STEEL(4, 18473, 15.0f, 6.0f, 35, () -> {
		
		return Ingredient.fromItems(ModItems.STEEL_INGOT.get());
		
	}),
	
	ENDERITE(4, 4635, 13.5f, 20.0f, 38, () -> {
		
		return Ingredient.fromItems(ModItems.ENDERITE_INGOT.get());
		
	}),
	
	NIGHT(4, 8235, 15.0f, 25.0f, 53, () -> {
		
		return Ingredient.fromItems(ModItems.STEEL_INGOT.get());
		
	});
	
	private final int HarvestLevel;
	private final int MaxUses;
	private final float Efficiency;
	private final float AttackDamage;
	private final int Enchantability;
	private final Supplier<Ingredient> RepairMaterial;
	
	CaveItemTier(int HarvestLevel, int MaxUses, float Efficiency, float AttackDamage, int Enchantability, Supplier<Ingredient> RepairMaterial) {
		
		this.HarvestLevel = HarvestLevel;
		this.MaxUses = MaxUses;
		this.Efficiency = Efficiency;
		this.AttackDamage = AttackDamage;
		this.Enchantability = Enchantability;
		this.RepairMaterial = RepairMaterial;
		
	}

	@Override
	public float getAttackDamage() {
		
		return AttackDamage;
		
	}

	@Override
	public float getEfficiency() {
		
		return Efficiency;
		
	}

	@Override
	public int getEnchantability() {
		
		return Enchantability;
		
	}

	@Override
	public int getHarvestLevel() {
		
		return HarvestLevel;
		
	}

	@Override
	public int getMaxUses() {
		
		return MaxUses;
		
	}

	@Override
	public Ingredient getRepairMaterial() {
		
		return RepairMaterial.get();
		
	}

}
