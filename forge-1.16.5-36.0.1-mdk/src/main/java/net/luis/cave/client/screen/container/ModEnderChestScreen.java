package net.luis.cave.client.screen.container;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.luis.cave.common.container.container.ModEnderChestContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ModEnderChestScreen extends ContainerScreen<ModEnderChestContainer> {
	
	private static final ResourceLocation CHEST_GUI_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");
	private final int inventoryRows = 6;

	public ModEnderChestScreen(ModEnderChestContainer container, PlayerInventory playerInventory, ITextComponent title) {
		
		super(container, playerInventory, title);
		this.ySize = 114 + this.inventoryRows * 18;
		this.playerInventoryTitleY = this.ySize - 94; 
		 
	}

	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		
		this.renderBackground(matrixStack);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
		
	}
	
	@Override
	@SuppressWarnings("deprecation")
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
		
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(CHEST_GUI_TEXTURE);
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		this.blit(matrixStack, i, j, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
		this.blit(matrixStack, i, j + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
		
	}

}
