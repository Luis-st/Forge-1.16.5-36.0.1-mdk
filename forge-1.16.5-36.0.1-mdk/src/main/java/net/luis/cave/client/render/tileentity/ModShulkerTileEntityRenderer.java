package net.luis.cave.client.render.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.luis.cave.common.tileentity.ModShulkerBoxTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.ShulkerModel;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.DyeColor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;

public class ModShulkerTileEntityRenderer extends TileEntityRenderer<ModShulkerBoxTileEntity> {
	
	private final ShulkerModel<?> model = new ShulkerModel<>();

	public ModShulkerTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		
		super(rendererDispatcherIn);
		
	}

	@Override
	public void render(ModShulkerBoxTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		
		Direction direction = Direction.UP;
		
		if (tileEntityIn.hasWorld()) {
			
			BlockState blockstate = tileEntityIn.getWorld().getBlockState(tileEntityIn.getPos());
			
			if (blockstate.getBlock() instanceof ShulkerBoxBlock) {
				
				direction = blockstate.get(ShulkerBoxBlock.FACING);
				
			}
			
		}

		DyeColor dyecolor = tileEntityIn.getColor();
		RenderMaterial rendermaterial;
		
		if (dyecolor == null) {
			
			rendermaterial = Atlases.DEFAULT_SHULKER_TEXTURE;
			
		} else {
			
			rendermaterial = Atlases.SHULKER_TEXTURES.get(dyecolor.getId());
			
		}

		matrixStackIn.push();
		matrixStackIn.translate(0.5D, 0.5D, 0.5D);;
		matrixStackIn.scale(0.9995F, 0.9995F, 0.9995F);
		matrixStackIn.rotate(direction.getRotation());
		matrixStackIn.scale(1.0F, -1.0F, -1.0F);
		matrixStackIn.translate(0.0D, -1.0D, 0.0D);
		IVertexBuilder ivertexbuilder = rendermaterial.getBuffer(bufferIn, RenderType::getEntityCutoutNoCull);
		this.model.getBase().render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
		matrixStackIn.translate(0.0D, (double) (-tileEntityIn.getProgress(partialTicks) * 0.5F), 0.0D);
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees(270.0F * tileEntityIn.getProgress(partialTicks)));
		this.model.getLid().render(matrixStackIn, ivertexbuilder, combinedLightIn, combinedOverlayIn);
		matrixStackIn.pop();
		
	}

}
