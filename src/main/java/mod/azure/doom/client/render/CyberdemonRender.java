package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.CyberdemonModel;
import mod.azure.doom.entity.CyberdemonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CyberdemonRender extends MobRenderer<CyberdemonEntity, CyberdemonModel<CyberdemonEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/cyberdemon-texturemap.png");

	public CyberdemonRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CyberdemonModel<CyberdemonEntity>(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(CyberdemonEntity entity) {
		return TEXTURE;
	}

}