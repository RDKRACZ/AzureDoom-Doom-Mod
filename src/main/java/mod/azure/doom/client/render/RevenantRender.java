package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doom.client.DoomGeoEntityRenderer;
import mod.azure.doom.client.models.RevenantModel;
import mod.azure.doom.entity.RevenantEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RevenantRender extends DoomGeoEntityRenderer<RevenantEntity> {

	public RevenantRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RevenantModel());
	}

	@Override
	public RenderType getRenderType(RevenantEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

}