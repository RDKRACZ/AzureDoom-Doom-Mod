package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doom.client.DoomGeoEntityRenderer;
import mod.azure.doom.client.models.MancubusModel;
import mod.azure.doom.entity.MancubusEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class MancubusRender extends DoomGeoEntityRenderer<MancubusEntity> {

	public MancubusRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new MancubusModel());
	}

	@Override
	public RenderType getRenderType(MancubusEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	protected float getDeathMaxRotation(MancubusEntity entityLivingBaseIn) {
		return 0.0F;
	}

}