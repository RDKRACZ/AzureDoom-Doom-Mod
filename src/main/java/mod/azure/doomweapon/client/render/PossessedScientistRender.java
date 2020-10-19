package mod.azure.doomweapon.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.PossessedScientistModel;
import mod.azure.doomweapon.entity.PossessedScientistEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PossessedScientistRender extends MobRenderer<PossessedScientistEntity, PossessedScientistModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/possessedscientist.png");

	public PossessedScientistRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PossessedScientistModel(), 0.5f);
	}

	@Override
	protected void preRenderCallback(PossessedScientistEntity entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		matrixStackIn.scale(0.625F, 0.6F, 0.625F);
	}

	@Override
	protected float getDeathMaxRotation(PossessedScientistEntity entityLivingBaseIn) {
		return 0.0F;
	}

	@Override
	public ResourceLocation getEntityTexture(PossessedScientistEntity entity) {
		return TEXTURE;
	}

}