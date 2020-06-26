package mod.azure.doomweapon.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.CyberdemonModel;
import mod.azure.doomweapon.entity.CyberdemonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CyberdemonRender extends MobRenderer<CyberdemonEntity, CyberdemonModel<CyberdemonEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/cyberdemon.png");

	public CyberdemonRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CyberdemonModel<CyberdemonEntity>(0.5f, false), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(CyberdemonEntity entity) {
		return TEXTURE;
	}

	protected void preRenderCallback(CyberdemonEntity entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		matrixStackIn.scale(2.5F, 2.5F, 2.5F);
	}

}