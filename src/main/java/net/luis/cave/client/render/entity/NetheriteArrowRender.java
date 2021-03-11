package net.luis.cave.client.render.entity;

import net.luis.cave.common.entities.NetheriteArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class NetheriteArrowRender extends ArrowRenderer<NetheriteArrow> {
	
	private static final ResourceLocation NETHERITE = new ResourceLocation("cave:textures/entity/netherite_arrow.png");

	public NetheriteArrowRender(EntityRendererManager renderManagerIn) {
		
		super(renderManagerIn);

	}

	@Override
	public ResourceLocation getEntityTexture(NetheriteArrow entity) {
		
		return NETHERITE;
		
	}

}
