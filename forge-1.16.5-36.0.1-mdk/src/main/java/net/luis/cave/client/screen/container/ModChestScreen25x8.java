package net.luis.cave.client.screen.container;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.luis.cave.common.inventory.container.ModChestContainer25x8;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ModChestScreen25x8 extends ContainerScreen<ModChestContainer25x8> implements IHasContainer<ModChestContainer25x8> {

	private static final ResourceLocation CHEST_GUI_TEXTURE = new ResourceLocation("cave:textures/gui/container/generic_200.png");

	public ModChestScreen25x8(ModChestContainer25x8 container, PlayerInventory playerInventory, ITextComponent title) {
		
		super(container, playerInventory, title);
		this.passEvents = false;
		this.ySize = 114 + 8 * 18;
		this.titleX = this.xSize - 311;
		this.playerInventoryTitleY = this.ySize - 93;
		
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
		int i = (this.width - (this.xSize + 288)) / 2;
		int j = (this.height - this.ySize) / 2;
		AbstractGui.blit(matrixStack, i, j, 0, 0, 464, 256, 512, 512);
		
	}
}
