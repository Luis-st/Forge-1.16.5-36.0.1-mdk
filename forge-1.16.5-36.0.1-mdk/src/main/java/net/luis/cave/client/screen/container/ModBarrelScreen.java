package net.luis.cave.client.screen.container;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.luis.cave.common.inventory.container.ModBarrelContainer;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;

public class ModBarrelScreen extends ContainerScreen<ModBarrelContainer> implements IHasContainer<ModBarrelContainer> {

	private static final ResourceLocation GUI_TEXTURE = new ResourceLocation("cave:textures/gui/container/generic_x.png");
	private boolean clickedOnSroll;
	public float sliderProgress;

	public ModBarrelScreen(ModBarrelContainer container, PlayerInventory playerInventory, ITextComponent title) {
		
		super(container, playerInventory, title);
		this.passEvents = false;
		this.ySize = 114 + 8 * 18;
		this.playerInventoryTitleY = this.ySize - 112;
		
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
		this.minecraft.getTextureManager().bindTexture(GUI_TEXTURE);
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		this.blit(matrixStack, i, j, 0, 0, 176, 240);
		int k = (int) this.sliderProgress;
		this.blit(matrixStack, i + 155, (j + 18) + k, 176, 0, 12, 15);
		
	}
	
	@Override
	public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
		
		float oldPos = this.sliderProgress;
        this.sliderProgress = (float) (this.sliderProgress - delta * 5);
        this.sliderProgress = MathHelper.clamp(this.sliderProgress, 0.0F, 109.0F);
        float newPos = this.sliderProgress;
        this.onMouseMove(oldPos, newPos);
        
		return super.mouseScrolled(mouseX, mouseY, delta);
		
	}
	
	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		
		this.clickedOnSroll = false;
		int progress = (int) this.sliderProgress;
		int x = this.guiLeft + 155;
		int y = this.guiTop + 18 + progress;
		
		if (mouseX >= x && mouseX < (x + 12) && mouseY >= y && mouseY < (y + 15)) {
			
			this.clickedOnSroll = true;
			
		}
		
		return super.mouseClicked(mouseX, mouseY, button);
		
	}
	
	@Override
	public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
		
		if (this.clickedOnSroll) {
			
			int i = this.guiTop + 18;
			float oldPos = this.sliderProgress;
			this.sliderProgress = (float) (mouseY - i - 7.5f);
			this.sliderProgress = MathHelper.clamp(this.sliderProgress, 0.0F, 109.0F);
			float newPos = this.sliderProgress;
			this.onMouseMove(oldPos, newPos);
			
			return true;
			
		} else {
			
			return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
			
		}
		
	}
	
	public void onMouseMove(float oldPos, float newPos) {
		
		
		
	}
	
}
