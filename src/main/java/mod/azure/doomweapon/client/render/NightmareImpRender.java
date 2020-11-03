package mod.azure.doomweapon.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doomweapon.client.models.ImpNightmareModel;
import mod.azure.doomweapon.entity.NightmareImpEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.renderers.geo.GeoEntityRenderer;

public class NightmareImpRender extends GeoEntityRenderer<NightmareImpEntity> {

	public NightmareImpRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ImpNightmareModel());
	}

	@Override
	public RenderType getRenderType(NightmareImpEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	protected float getDeathMaxRotation(NightmareImpEntity entityLivingBaseIn) {
		return 0.0F;
	}

}