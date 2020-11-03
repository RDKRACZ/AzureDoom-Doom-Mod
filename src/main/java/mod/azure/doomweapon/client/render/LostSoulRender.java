package mod.azure.doomweapon.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doomweapon.client.models.LostSoulModel;
import mod.azure.doomweapon.entity.LostSoulEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.renderers.geo.GeoEntityRenderer;

public class LostSoulRender extends GeoEntityRenderer<LostSoulEntity> {

	public LostSoulRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new LostSoulModel());
	}

	@Override
	public RenderType getRenderType(LostSoulEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}
}