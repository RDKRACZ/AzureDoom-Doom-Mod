package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doom.client.DoomGeoEntityRenderer;
import mod.azure.doom.client.models.SpiderdemonModel;
import mod.azure.doom.entity.SpiderdemonEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class SpiderdemonRender extends DoomGeoEntityRenderer<SpiderdemonEntity> {

	public SpiderdemonRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new SpiderdemonModel());
	}

	@Override
	public RenderType getRenderType(SpiderdemonEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

}