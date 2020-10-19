package mod.azure.doomweapon.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.GoreNestModel;
import mod.azure.doomweapon.entity.GoreNestEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GoreNestRender extends MobRenderer<GoreNestEntity, GoreNestModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/gore_nest.png");

	public GoreNestRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new GoreNestModel(), 0.5f);

	}

	@Override
	protected void preRenderCallback(GoreNestEntity entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		matrixStackIn.scale(1.5F, 1.5F, 1.5F);
	}

	@Override
	protected float getDeathMaxRotation(GoreNestEntity entityLivingBaseIn) {
		return 0.0F;
	}

	@Override
	public ResourceLocation getEntityTexture(GoreNestEntity entity) {
		return TEXTURE;
	}

}