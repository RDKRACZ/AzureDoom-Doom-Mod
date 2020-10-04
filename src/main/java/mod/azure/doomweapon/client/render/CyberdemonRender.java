package mod.azure.doomweapon.client.render;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.CyberdemonModel;
import mod.azure.doomweapon.entity.CyberdemonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CyberdemonRender extends MobRenderer<CyberdemonEntity, CyberdemonModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/cyberdemon-texturemap.png");

	public CyberdemonRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CyberdemonModel(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(CyberdemonEntity entity) {
		return TEXTURE;
	}

}