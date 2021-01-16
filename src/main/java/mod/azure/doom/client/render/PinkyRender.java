package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doom.client.DoomGeoEntityRenderer;
import mod.azure.doom.client.models.PinkyModel;
import mod.azure.doom.entity.PinkyEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class PinkyRender extends DoomGeoEntityRenderer<PinkyEntity> {

	public PinkyRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PinkyModel());
	}

	@Override
	public RenderType getRenderType(PinkyEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	protected float getDeathMaxRotation(PinkyEntity entityLivingBaseIn) {
		return 0.0F;
	}
}