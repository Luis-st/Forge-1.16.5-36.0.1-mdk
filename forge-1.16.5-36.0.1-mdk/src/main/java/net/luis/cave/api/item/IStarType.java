package net.luis.cave.api.item;

import net.luis.cave.common.enums.StarBonusType;

public interface IStarType {
	
	String getTagName();
	
	int getId();
	
	StarBonusType getBonusType();

}
