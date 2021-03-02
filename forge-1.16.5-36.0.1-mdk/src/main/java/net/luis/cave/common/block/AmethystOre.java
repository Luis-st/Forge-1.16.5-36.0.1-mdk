package net.luis.cave.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ToolType;

public class AmethystOre extends OreBlock {

	public AmethystOre() {
		
		super(Block.Properties.create(Material.ROCK, MaterialColor.STONE)
				.hardnessAndResistance(2.5f,4.0f)
				.sound(SoundType.STONE)
				.harvestLevel(1)
				.harvestTool(ToolType.PICKAXE)
				.setRequiresTool());
		
	}
	
	@Override
	protected int getExperience(Random rand) {
		
		return MathHelper.nextInt(rand, 3, 6);
		
	}

}
