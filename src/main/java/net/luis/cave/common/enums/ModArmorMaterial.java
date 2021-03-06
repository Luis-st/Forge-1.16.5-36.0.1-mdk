package net.luis.cave.common.enums;

import java.util.function.Supplier;

import net.luis.cave.Cave;
import net.luis.cave.init.items.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ModArmorMaterial implements IArmorMaterial {
	
	//Name, Durability multiplier, Damage Reduction multiplier, 
	//Damage Reduction, Enchantability, Toughness, Knockback Resistance, Repair Material
	SLIME(Cave.MOD_ID + ":slime", 16, new int[] {1, 3, 4, 1}, 5, 0.0f, 1.0f, () -> {
		
		return Ingredient.fromItems(Items.SLIME_BALL);
		
	}),
	
	LIMONITE(Cave.MOD_ID + ":limonite", 37, new int[] {2, 4, 6, 2}, 19, 1.0f, 0.0f, () -> {
		
		return Ingredient.fromItems(ModItems.LIMONITE_INGOT.get());
		
	}),
	
	JADE(Cave.MOD_ID + ":jade", 25, new int[] {3, 6, 8, 3}, 53, 2.0f, 0.0f, () -> {
		
		return Ingredient.fromItems(ModItems.JADE_INGOT.get());
		
	}), 
	
	
	BLAZING(Cave.MOD_ID + ":blazing", 20, new int[] {4, 7, 9, 4}, 13, 2.0f, 0.1f, () -> {
		
		return Ingredient.fromItems(ModItems.BLAZING_INGOT.get());
		
	}),
	
	SAPHIRE(Cave.MOD_ID + ":saphire", 27, new int[] {5, 8, 11, 5}, 24, 4.0f, 0.3f, () -> {
		
		return Ingredient.fromItems(ModItems.SAPHIRE_INGOT.get());
		
	}),
	
	RUBY(Cave.MOD_ID + ":ruby", 37, new int[] {6, 9, 12, 6}, 16, 3.0f, 0.2f, () -> {
		
		return Ingredient.fromItems(ModItems.RUBY.get());
		
	}),
	
	ENDERITE(Cave.MOD_ID + ":enderite", 73, new int[] {10, 13, 16, 10}, 34, 5.0f, 0.4f, () -> {
		
		return Ingredient.fromItems(ModItems.ENDERITE_INGOT.get());
		
	}),
	
	NIGHT(Cave.MOD_ID + ":night", 112, new int[] {17, 18, 23, 17}, 50, 9.0f, 0.8f, () -> {
		
		return Ingredient.fromItems(ModItems.NIGHT_INGOT.get());
		
	});
	
	private final int[] MAX_DAMAGE_ARRAY = new int[] {13, 15, 16, 11};
	private final String name;
	private final int durability;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final float toughness;
	private final float knockbackResistance;
	private final Supplier<Ingredient> repairMaterial;

	private ModArmorMaterial(String nameIn, int durabilityIn, int[] damageReductionAmountArrayIn, int enchantabilityIn, float toughnessIn, 
			float knockbackResistanceIn, Supplier<Ingredient> repairMaterialIn) {
		
		this.name = nameIn;
		this.durability = durabilityIn;
		this.damageReductionAmountArray = damageReductionAmountArrayIn;
		this.enchantability = enchantabilityIn;
		this.toughness = toughnessIn;
		this.knockbackResistance = knockbackResistanceIn;
		this.repairMaterial = repairMaterialIn;
		
	}
	
	@OnlyIn(Dist.CLIENT)
	public String getName() {
		
		return this.name;
		
	}

	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.durability;
		
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		
		return this.damageReductionAmountArray[slotIn.getIndex()];
		
	}

	@Override
	public int getEnchantability() {
		
		return this.enchantability;
		
	}

	@Override
	public SoundEvent getSoundEvent() {
		
		return null;
		
	}

	@Override
	public float getToughness() {
		
		return this.toughness;
		
	}

	@Override
	public float getKnockbackResistance() {
		
		return this.knockbackResistance;
		
	}
	
	@Override
	public Ingredient getRepairMaterial() {
		
		return this.repairMaterial.get();
		
	}

}
