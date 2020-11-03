package mod.azure.doomweapon.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doomweapon.client.models.PinkyModel;
import mod.azure.doomweapon.entity.PinkyEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.renderers.geo.GeoEntityRenderer;

public class PinkyRender extends GeoEntityRenderer<PinkyEntity> {

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