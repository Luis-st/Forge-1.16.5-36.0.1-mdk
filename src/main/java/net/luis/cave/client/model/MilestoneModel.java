package net.luis.cave.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MilestoneModel extends EntityModel<Entity> {
	private final ModelRenderer milestone;
	private final ModelRenderer inner;
	private final ModelRenderer outer;
	private final ModelRenderer north;
	private final ModelRenderer east;
	private final ModelRenderer south;
	private final ModelRenderer west;

	public MilestoneModel() {
		textureWidth = 128;
		textureHeight = 128;

		milestone = new ModelRenderer(this);
		milestone.setRotationPoint(0.0F, 16.0F, 0.0F);
		

		inner = new ModelRenderer(this);
		inner.setRotationPoint(0.0F, 0.0F, 0.0F);
		milestone.addChild(inner);
		inner.setTextureOffset(0, 48).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 7.0F, 8.0F, 0.0F, false);

		outer = new ModelRenderer(this);
		outer.setRotationPoint(0.0F, 0.0F, 0.0F);
		milestone.addChild(outer);
		outer.setTextureOffset(48, 0).addBox(-6.0F, -4.0F, -6.0F, 12.0F, 5.0F, 12.0F, 0.0F, false);

		north = new ModelRenderer(this);
		north.setRotationPoint(0.0F, 0.0F, 0.0F);
		milestone.addChild(north);
		north.setTextureOffset(24, 30).addBox(-1.5F, -4.5F, -9.0F, 3.0F, 6.0F, 18.0F, 0.0F, false);

		east = new ModelRenderer(this);
		east.setRotationPoint(0.0F, 0.0F, 0.0F);
		milestone.addChild(east);
		setRotationAngle(east, 0.0F, 0.7854F, 0.0F);
		east.setTextureOffset(0, 24).addBox(-1.5F, -4.5F, -9.0F, 3.0F, 6.0F, 18.0F, 0.0F, false);

		south = new ModelRenderer(this);
		south.setRotationPoint(0.0F, 0.0F, 0.0F);
		milestone.addChild(south);
		setRotationAngle(south, 0.0F, 1.5708F, 0.0F);
		south.setTextureOffset(24, 6).addBox(-1.5F, -4.5F, -9.0F, 3.0F, 6.0F, 18.0F, 0.0F, false);

		west = new ModelRenderer(this);
		west.setRotationPoint(0.0F, 0.0F, 0.0F);
		milestone.addChild(west);
		setRotationAngle(west, 0.0F, -0.7854F, 0.0F);
		west.setTextureOffset(0, 0).addBox(-1.5F, -4.5F, -9.0F, 3.0F, 6.0F, 18.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		milestone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}