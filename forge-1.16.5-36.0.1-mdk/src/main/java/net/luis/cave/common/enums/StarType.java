package net.luis.cave.common.enums;

import net.luis.cave.api.item.api.IStarType;

public enum StarType implements IStarType {
	
	END("end", 0, StarBonusType.MOVEMENT),
	MINING("mining", 1, StarBonusType.EFFECT),
	NETHER("nether", 2, StarBonusType.EFFECT),
	WATER("water", 3, StarBonusType.EFFECT),
	DAMAGE("damage", 4, StarBonusType.EFFECT),
	DEATH("death", 5, StarBonusType.FUNCTION);
	
	private final String tag;
	private final int id;
	private final StarBonusType bonusType;
	
	StarType(String tagIn, int idIn, StarBonusType bonusTypeIn) {
		
		this.tag = tagIn;
		this.id = idIn;
		this.bonusType = bonusTypeIn;
		
	}
	
	@Override
	public String getTagName() {
		
		return this.tag;
		
	}

	@Override
	public int getId() {
		
		return this.id;
		
	}

	@Override
	public StarBonusType getBonusType() {
		
		return this.bonusType;
		
	}

}
