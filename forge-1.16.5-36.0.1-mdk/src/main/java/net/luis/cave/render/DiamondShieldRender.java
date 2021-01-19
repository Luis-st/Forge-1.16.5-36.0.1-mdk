package net.luis.cave.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.model.ShieldModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class DiamondShieldRender extends ItemStackTileEntityRenderer {
	
    private final ShieldModel shieldModel;
    
    public DiamondShieldRender() {
    	
        this.shieldModel = new ShieldModel();
        
    }
    
    public void func_239207_a_(ItemStack p_239207_1_, ItemCameraTransforms.TransformType p_239207_2_, MatrixStack p_239207_3_, 
								IRenderTypeBuffer p_239207_4_, int p_239207_5_, int p_239207_6_) {
    	
    	p_239207_3_.push();
    	p_239207_3_.scale(1.0F, -1.0F, -1.0F);
    	
    	final IVertexBuilder vertexConsumer = ItemRenderer.getBuffer(p_239207_4_, 
    						this.shieldModel.getRenderType(new ResourceLocation("cave:textures/entity/diamond_shield.png")), false, p_239207_1_.hasEffect());
    	
    	this.shieldModel.render(p_239207_3_, vertexConsumer, p_239207_5_, p_239207_6_, 1.0f, 1.0f, 1.0f, 1.0f);
    	
    	p_239207_3_.pop();
    	
    }	 

}
