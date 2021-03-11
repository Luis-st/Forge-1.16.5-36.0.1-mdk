package net.luis.cave.api.item.api.weapon;

import net.luis.cave.common.enums.StarBonusType;
import net.luis.cave.common.enums.StarType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.world.World;

public class Star extends Item {
	
	private final StarType starType;
	private final String tag;
	private final int id;
	private final StarBonusType bonusType;

	public Star(Properties properties, StarType starTypeIn) {
		
		super(properties.maxStackSize(1).rarity(Rarity.UNCOMMON));
		this.starType = starTypeIn;
		this.tag = starTypeIn.getTagName();
		this.id = starTypeIn.getId();
		this.bonusType = starTypeIn.getBonusType();

	}
	
	protected StarType getStarType() {
		
		return this.starType;
		
	}
	
	public String getTagName() {
		
		return this.tag;
		
	}
	
	public int getId() {
		
		return this.id;
		
	}
	
	public StarBonusType getBonusType() {
		
		return this.bonusType;
		
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		
		return true;
		
	}
	
	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		
		if (entity instanceof PlayerEntity) {
			
			PlayerEntity player = (PlayerEntity) entity;
			starTick(stack, world, player);
			
		}
		
	}
	
	public void starTick(ItemStack stack, World world, PlayerEntity player) {
		
	}

}
