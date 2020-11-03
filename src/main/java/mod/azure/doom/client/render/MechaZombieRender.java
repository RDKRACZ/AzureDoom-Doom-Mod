package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doom.client.models.MechaZombieModel;
import mod.azure.doom.entity.MechaZombieEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.renderers.geo.GeoEntityRenderer;

public class MechaZombieRender extends GeoEntityRenderer<MechaZombieEntity> {

	public MechaZombieRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new MechaZombieModel());
	}

	@Override
	public RenderType getRenderType(MechaZombieEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}

	@Override
	protected float getDeathMaxRotation(MechaZombieEntity entityLivingBaseIn) {
		return 0.0F;
	}

}