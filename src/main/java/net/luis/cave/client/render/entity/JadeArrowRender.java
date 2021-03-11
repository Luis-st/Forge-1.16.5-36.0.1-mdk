package net.luis.cave.client.render.entity;

import net.luis.cave.common.entities.JadeArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class JadeArrowRender extends ArrowRenderer<JadeArrow> {
	
	private static final ResourceLocation JADE = new ResourceLocation("cave:textures/entity/jade_arrow.png");

	public JadeArrowRender(EntityRendererManager renderManagerIn) {
		
		super(renderManagerIn);

	}

	@Override
	public ResourceLocation getEntityTexture(JadeArrow entity) {
		
		return JADE;
		
	}

}
