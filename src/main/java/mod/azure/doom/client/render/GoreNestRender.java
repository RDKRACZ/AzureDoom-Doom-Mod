package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doom.client.models.GoreNestModel;
import mod.azure.doom.entity.GoreNestEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GoreNestRender extends GeoEntityRenderer<GoreNestEntity> {

	public GoreNestRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new GoreNestModel());
	}

	@Override
	public RenderType getRenderType(GoreNestEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void renderEarly(GoreNestEntity animatable, MatrixStack stackIn, float ticks,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float partialTicks) {
		super.renderEarly(animatable, stackIn, ticks, renderTypeBuffer, vertexBuilder, packedLightIn, packedOverlayIn,
				red, green, blue, partialTicks);
		stackIn.scale(1.5F, 1.5F, 1.5F);
	}

	@Override
	protected float getDeathMaxRotation(GoreNestEntity entityLivingBaseIn) {
		return 0.0F;
	}
}