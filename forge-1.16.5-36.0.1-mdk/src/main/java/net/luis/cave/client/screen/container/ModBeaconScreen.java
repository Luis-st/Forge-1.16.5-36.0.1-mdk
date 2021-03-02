package net.luis.cave.client.screen.container;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.luis.cave.common.inventory.container.ModBeaconContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.AbstractButton;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerListener;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.play.client.CCloseWindowPacket;
import net.minecraft.network.play.client.CUpdateBeaconPacket;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.BeaconTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class ModBeaconScreen extends ContainerScreen<ModBeaconContainer> {

	private static final ResourceLocation BEACON_GUI_TEXTURES = new ResourceLocation("textures/gui/container/beacon.png");
	private static final ITextComponent field_243334_B = new TranslationTextComponent("block.minecraft.beacon.primary");
	private static final ITextComponent field_243335_C = new TranslationTextComponent("block.minecraft.beacon.secondary");
	private ModBeaconScreen.ConfirmButton beaconConfirmButton;
	private boolean buttonsNotDrawn;
	private Effect primaryEffect;
	private Effect secondaryEffect;

	public ModBeaconScreen(ModBeaconContainer container, PlayerInventory playerInventory, ITextComponent title) {
		
		super(container, playerInventory, title);
		this.xSize = 230;
		this.ySize = 219;
		container.addListener(new IContainerListener() {
			@Override
			public void sendAllContents(Container containerToSend, NonNullList<ItemStack> itemsList) {
				
			}

			@Override
			public void sendSlotContents(Container containerToSend, int slotInd, ItemStack stack) {
				
			}

			@Override
			public void sendWindowProperty(Container containerIn, int varToUpdate, int newValue) {
				
				ModBeaconScreen.this.primaryEffect = container.func_216967_f();
				ModBeaconScreen.this.secondaryEffect = container.func_216968_g();
				ModBeaconScreen.this.buttonsNotDrawn = true;
				
			}
		});
		
	}
	
	@Override
	protected void init() {
		
		super.init();
		this.beaconConfirmButton = this.addButton(new ModBeaconScreen.ConfirmButton(this.guiLeft + 164, this.guiTop + 107));
		this.addButton(new ModBeaconScreen.CancelButton(this.guiLeft + 190, this.guiTop + 107));
		this.buttonsNotDrawn = true;
		this.beaconConfirmButton.active = false;
		
	}
	
	@Override
	public void tick() {
		
		super.tick();
		int i = this.container.func_216969_e();
		
		if (this.buttonsNotDrawn && i >= 0) {
			
			this.buttonsNotDrawn = false;

			for (int j = 0; j <= 2; ++j) {
				
				int k = BeaconTileEntity.EFFECTS_LIST[j].length;
				int l = k * 22 + (k - 1) * 2;

				for (int i1 = 0; i1 < k; ++i1) {
					
					Effect effect = BeaconTileEntity.EFFECTS_LIST[j][i1];
					ModBeaconScreen.PowerButton beaconscreen$powerbutton = new ModBeaconScreen.PowerButton(
							this.guiLeft + 76 + i1 * 24 - l / 2, this.guiTop + 22 + j * 25, effect, true);
					this.addButton(beaconscreen$powerbutton);
					
					if (j >= i) {
						
						beaconscreen$powerbutton.active = false;
						
					} else if (effect == this.primaryEffect) {
						
						beaconscreen$powerbutton.setSelected(true);
						
					}
					
				}
				
			}

			int k1 = BeaconTileEntity.EFFECTS_LIST[3].length + 1;
			int l1 = k1 * 22 + (k1 - 1) * 2;
			
			for (int i2 = 0; i2 < k1 - 1; ++i2) {
				
				Effect effect1 = BeaconTileEntity.EFFECTS_LIST[3][i2];
				ModBeaconScreen.PowerButton beaconscreen$powerbutton2 = new ModBeaconScreen.PowerButton(
						this.guiLeft + 167 + i2 * 24 - l1 / 2, this.guiTop + 47, effect1, false);
				this.addButton(beaconscreen$powerbutton2);
				
				if (3 >= i) {
					
					beaconscreen$powerbutton2.active = false;
					
				} else if (effect1 == this.secondaryEffect) {
					
					beaconscreen$powerbutton2.setSelected(true);
					
				}
				
			}

			if (this.primaryEffect != null) {
				
				ModBeaconScreen.PowerButton beaconscreen$powerbutton1 = new ModBeaconScreen.PowerButton(
						this.guiLeft + 167 + (k1 - 1) * 24 - l1 / 2, this.guiTop + 47, this.primaryEffect, false);
				this.addButton(beaconscreen$powerbutton1);
				
				if (3 >= i) {
					
					beaconscreen$powerbutton1.active = false;
					
				} else if (this.primaryEffect == this.secondaryEffect) {
					
					beaconscreen$powerbutton1.setSelected(true);
					
				}
				
			}
			
		}

		this.beaconConfirmButton.active = this.container.func_216970_h() && this.primaryEffect != null;
		
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
		
		drawCenteredString(matrixStack, this.font, field_243334_B, 62, 10, 14737632);
		drawCenteredString(matrixStack, this.font, field_243335_C, 169, 10, 14737632);

		for (Widget widget : this.buttons) {
			
			if (widget.isHovered()) {
				
				widget.renderToolTip(matrixStack, x - this.guiLeft, y - this.guiTop);
				break;
				
			}
			
		}

	}
	
	@Override
	@SuppressWarnings("deprecation")
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
		
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(BEACON_GUI_TEXTURES);
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);
		this.itemRenderer.zLevel = 100.0F;
		this.itemRenderer.renderItemAndEffectIntoGUI(new ItemStack(Items.NETHERITE_INGOT), i + 20, j + 109);
		this.itemRenderer.renderItemAndEffectIntoGUI(new ItemStack(Items.EMERALD), i + 41, j + 109);
		this.itemRenderer.renderItemAndEffectIntoGUI(new ItemStack(Items.DIAMOND), i + 41 + 22, j + 109);
		this.itemRenderer.renderItemAndEffectIntoGUI(new ItemStack(Items.GOLD_INGOT), i + 42 + 44, j + 109);
		this.itemRenderer.renderItemAndEffectIntoGUI(new ItemStack(Items.IRON_INGOT), i + 42 + 66, j + 109);
		this.itemRenderer.zLevel = 0.0F;
		
	}
	
	@Override
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		
		this.renderBackground(matrixStack);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
		
	}
	
	abstract static class Button extends AbstractButton {
		
		private boolean selected;

		protected Button(int x, int y) {
			
			super(x, y, 22, 22, StringTextComponent.EMPTY);
			
		}
		
		@Override
		@SuppressWarnings("deprecation")
		public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
			
			Minecraft.getInstance().getTextureManager().bindTexture(ModBeaconScreen.BEACON_GUI_TEXTURES);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			int j = 0;
			
			if (!this.active) {
				
				j += this.width * 2;
				
			} else if (this.selected) {
				
				j += this.width * 1;
				
			} else if (this.isHovered()) {
				
				j += this.width * 3;
				
			}

			this.blit(matrixStack, this.x, this.y, j, 219, this.width, this.height);
			this.func_230454_a_(matrixStack);
			
		}
		
		protected abstract void func_230454_a_(MatrixStack p_230454_1_);

		public boolean isSelected() {
			
			return this.selected;
			
		}

		public void setSelected(boolean selectedIn) {
			
			this.selected = selectedIn;
			
		}
		
	}
	
	class CancelButton extends ModBeaconScreen.SpriteButton {
		
		public CancelButton(int x, int y) {
			
			super(x, y, 112, 220);
			
		}
		
		@Override
		public void onPress() {
			
			ModBeaconScreen.this.minecraft.player.connection.sendPacket(new CCloseWindowPacket(ModBeaconScreen.this.minecraft.player.openContainer.windowId));
			ModBeaconScreen.this.minecraft.displayGuiScreen((Screen) null);
			
		}
		
		@Override
		public void renderToolTip(MatrixStack matrixStack, int mouseX, int mouseY) {
			
			ModBeaconScreen.this.renderTooltip(matrixStack, DialogTexts.GUI_CANCEL, mouseX, mouseY);
			
		}
		
	}
	
	class ConfirmButton extends ModBeaconScreen.SpriteButton {
		
		public ConfirmButton(int x, int y) {
			
			super(x, y, 90, 220);
			
		}
		
		@Override
		public void onPress() {
			
			ModBeaconScreen.this.minecraft.getConnection().sendPacket(new CUpdateBeaconPacket(Effect.getId(ModBeaconScreen.this.primaryEffect),
							Effect.getId(ModBeaconScreen.this.secondaryEffect)));
			ModBeaconScreen.this.minecraft.player.connection.sendPacket(new CCloseWindowPacket(ModBeaconScreen.this.minecraft.player.openContainer.windowId));
			ModBeaconScreen.this.minecraft.displayGuiScreen((Screen) null);
			
		}
		
		@Override
		public void renderToolTip(MatrixStack matrixStack, int mouseX, int mouseY) {
			
			ModBeaconScreen.this.renderTooltip(matrixStack, DialogTexts.GUI_DONE, mouseX, mouseY);
			
		}
	}
	
	class PowerButton extends ModBeaconScreen.Button {
		
		private final Effect effect;
		private final TextureAtlasSprite field_212946_c;
		private final boolean field_212947_d;
		private final ITextComponent field_243336_e;
		
		public PowerButton(int x, int y, Effect p_i50827_4_, boolean p_i50827_5_) {
			
			super(x, y);
			this.effect = p_i50827_4_;
			this.field_212946_c = Minecraft.getInstance().getPotionSpriteUploader().getSprite(p_i50827_4_);
			this.field_212947_d = p_i50827_5_;
			this.field_243336_e = this.func_243337_a(p_i50827_4_, p_i50827_5_);
			
		}
		
		private ITextComponent func_243337_a(Effect p_243337_1_, boolean p_243337_2_) {
			
			IFormattableTextComponent iformattabletextcomponent = new TranslationTextComponent(p_243337_1_.getName());
			
			if (!p_243337_2_ && p_243337_1_ != Effects.REGENERATION) {
				
				iformattabletextcomponent.appendString(" II");
				
			}

			return iformattabletextcomponent;
			
		}
		
		@Override
		public void onPress() {
			
			if (!this.isSelected()) {
				
				if (this.field_212947_d) {
					
					ModBeaconScreen.this.primaryEffect = this.effect;
					
				} else {
					
					ModBeaconScreen.this.secondaryEffect = this.effect;
					
				}

				ModBeaconScreen.this.buttons.clear();
				ModBeaconScreen.this.children.clear();
				ModBeaconScreen.this.init();
				ModBeaconScreen.this.tick();
				
			}
			
		}
		
		@Override
		public void renderToolTip(MatrixStack matrixStack, int mouseX, int mouseY) {
			
			ModBeaconScreen.this.renderTooltip(matrixStack, this.field_243336_e, mouseX, mouseY);
			
		}

		@Override
		protected void func_230454_a_(MatrixStack p_230454_1_) {
			
			Minecraft.getInstance().getTextureManager().bindTexture(this.field_212946_c.getAtlasTexture().getTextureLocation());
			blit(p_230454_1_, this.x + 2, this.y + 2, this.getBlitOffset(), 18, 18, this.field_212946_c);
			
		}
		
	}
	
	abstract static class SpriteButton extends ModBeaconScreen.Button {
		
		private final int u;
		private final int v;

		protected SpriteButton(int x, int y, int u, int v) {
			
			super(x, y);
			this.u = u;
			this.v = v;
			
		}
		
		@Override
		protected void func_230454_a_(MatrixStack p_230454_1_) {
			
			this.blit(p_230454_1_, this.x + 2, this.y + 2, this.u, this.v, 18, 18);
			
		}
		
	}
	
}
