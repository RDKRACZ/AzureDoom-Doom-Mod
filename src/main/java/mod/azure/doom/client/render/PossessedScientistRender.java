package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.PossessedScientistModel;
import mod.azure.doom.entity.PossessedScientistEntity;
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