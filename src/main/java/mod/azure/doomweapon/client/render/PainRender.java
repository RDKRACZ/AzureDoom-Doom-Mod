package mod.azure.doomweapon.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.PainModel;
import mod.azure.doomweapon.entity.PainEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PainRender extends MobRenderer<PainEntity, PainModel<PainEntity>> {
	private static final ResourceLocation GHAST_TEXTURES = new ResourceLocation(DoomMod.MODID,
			"textures/entity/pain_elemental.png");

	public PainRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PainModel<>(), 1.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(PainEntity entity) {
		return GHAST_TEXTURES;
	}

	@Override
	protected void preRenderCallback(PainEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
		matrixStackIn.scale(2.0F, 2.0F, 2.0F);
	}
}