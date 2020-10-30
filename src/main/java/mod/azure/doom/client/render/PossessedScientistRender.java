package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doom.client.models.PossessedScientistModel;
import mod.azure.doom.entity.PossessedScientistEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.renderers.geo.GeoEntityRenderer;

public class PossessedScientistRender extends GeoEntityRenderer<PossessedScientistEntity> {

	public PossessedScientistRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PossessedScientistModel());
	}

	@Override
	public RenderType getRenderType(PossessedScientistEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

	protected void preRenderCallback(PossessedScientistEntity entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		matrixStackIn.scale(0.625F, 0.6F, 0.625F);
	}

	@Override
	protected float getDeathMaxRotation(PossessedScientistEntity entityLivingBaseIn) {
		return 0.0F;
	}

}