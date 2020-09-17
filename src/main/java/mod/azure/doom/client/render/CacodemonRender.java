package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.CacodemonModel;
import mod.azure.doom.entity.CacodemonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CacodemonRender extends MobRenderer<CacodemonEntity, CacodemonModel<CacodemonEntity>> {
	private static final ResourceLocation GHAST_TEXTURES = new ResourceLocation(DoomMod.MODID,
			"textures/entity/cacodemon.png");

	public CacodemonRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CacodemonModel<>(), 1.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(CacodemonEntity entity) {
		return GHAST_TEXTURES;
	}

	@SuppressWarnings("unused")
	@Override
	protected void preRenderCallback(CacodemonEntity entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		float f = 1.0F;
		float f1 = 4.5F;
		float f2 = 4.5F;
		matrixStackIn.scale(2.0F, 2.0F, 2.0F);
	}
}