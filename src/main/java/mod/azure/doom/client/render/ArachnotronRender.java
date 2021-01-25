package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import mod.azure.doom.client.models.ArachnotronModel;
import mod.azure.doom.entity.ArachnotronEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class ArachnotronRender extends GeoEntityRenderer<ArachnotronEntity> {

	public ArachnotronRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ArachnotronModel());
		this.shadowSize = 0.7F;
	}

	@Override
	public RenderType getRenderType(ArachnotronEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

}