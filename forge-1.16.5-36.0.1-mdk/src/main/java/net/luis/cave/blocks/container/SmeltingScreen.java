package net.luis.cave.blocks.container;

import net.minecraft.client.gui.screen.inventory.AbstractFurnaceScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SmeltingScreen extends AbstractFurnaceScreen<SmeltingContainer> {
	
	private static final ResourceLocation FURNACE_GUI_TEXTURES = new ResourceLocation("textures/gui/container/furnace.png");

	public SmeltingScreen(SmeltingContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		
		super(screenContainer, null, inv, titleIn, FURNACE_GUI_TEXTURES);
		
	}

}
