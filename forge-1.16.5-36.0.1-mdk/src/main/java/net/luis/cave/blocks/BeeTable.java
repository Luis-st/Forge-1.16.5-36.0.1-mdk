package net.luis.cave.blocks;

import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BeeTable extends BeehiveBlock {

	public BeeTable() {
		
		super(Block.Properties.create(Material.WOOD)
				.hardnessAndResistance(0.6f)
				.harvestTool(ToolType.AXE)
				.sound(SoundType.WOOD));

	}

}
