package net.luis.cave.common.enums;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;

public enum VanillaItemTier implements IItemTier {
	
	WOOD(0, 59, 2.0F, 0.0F, 15, () -> {
		
		return Ingredient.fromTag(ItemTags.PLANKS);
		
	}), 
	
	STONE(1, 131, 4.0F, 1.0F, 5, () -> {
		
		return Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS);
		
	}), 
	
	IRON(2, 250, 6.0F, 2.0F, 14, () -> {
		
		return Ingredient.fromItems(Items.IRON_INGOT);
		
	}), 
	
	DIAMOND(3, 1561, 8.0F, 3.0F, 10, () -> {
		
		return Ingredient.fromItems(Items.DIAMOND);
		
	}), 
	
	GOLD(0, 32, 12.0F, 0.0F, 22, () -> {
		
		return Ingredient.fromItems(Items.GOLD_INGOT);
		
	}), 
	
	NETHERITE(4, 2031, 9.0F, 4.0F, 15, () -> {
		
		return Ingredient.fromItems(Items.NETHERITE_INGOT);
		
	});

	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final Supplier<Ingredient> repairMaterial;

	private VanillaItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
		
		this.harvestLevel = harvestLevelIn;
		this.maxUses = maxUsesIn;
		this.efficiency = efficiencyIn;
		this.attackDamage = attackDamageIn;
		this.enchantability = enchantabilityIn;
		this.repairMaterial = repairMaterialIn;
		
	}

	@Override
	public int getMaxUses() {
		
		return this.maxUses;
		
	}

	@Override
	public float getEfficiency() {
		
		return this.efficiency;
		
	}

	@Override
	public float getAttackDamage() {
		
		return this.attackDamage;
		
	}

	@Override
	public int getHarvestLevel() {
		
		return this.harvestLevel;
		
	}

	@Override
	public int getEnchantability() {
		
		return this.enchantability;
		
	}

	@Override
	public Ingredient getRepairMaterial() {
		
		return this.repairMaterial.get();
		
	}
	
}
