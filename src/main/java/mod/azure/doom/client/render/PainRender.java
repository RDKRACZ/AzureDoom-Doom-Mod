package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doom.client.models.PainModel;
import mod.azure.doom.entity.PainEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PainRender extends GeoEntityRenderer<PainEntity> {

	public PainRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PainModel());
	}

	@Override
	public RenderType getRenderType(PainEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	protected int getBlockLight(PainEntity entityIn, BlockPos partialTicks) {
		if (entityIn.isAttacking()) {
			return 15;
		} else {
			return 0;
		}
	}

}