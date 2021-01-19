package net.luis.cave.blocks;

import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class Barrel extends BarrelBlock {


	public Barrel() {

		super(Block.Properties.create(Material.WOOD)
				.hardnessAndResistance(2.5f)
				.harvestTool(ToolType.AXE)
				.sound(SoundType.WOOD));
		

	}
	
}
