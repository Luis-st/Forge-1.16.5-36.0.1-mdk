package net.luis.cave.client.render.entity;

import net.luis.cave.common.entities.DiamondArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class DiamondArrowRender extends ArrowRenderer<DiamondArrow> {
	
	private static final ResourceLocation DIAMOND = new ResourceLocation("cave:textures/entity/diamond_arrow.png");

	public DiamondArrowRender(EntityRendererManager renderManagerIn) {
		
		super(renderManagerIn);

	}

	@Override
	public ResourceLocation getEntityTexture(DiamondArrow entity) {
		
		return DIAMOND;
		
	}

}
