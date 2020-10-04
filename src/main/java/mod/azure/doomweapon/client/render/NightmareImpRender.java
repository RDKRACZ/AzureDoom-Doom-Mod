package mod.azure.doomweapon.client.render;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.ImpNightmareModel;
import mod.azure.doomweapon.entity.NightmareImpEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class NightmareImpRender extends MobRenderer<NightmareImpEntity, ImpNightmareModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/nightmareimp-texture.png");

	public NightmareImpRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ImpNightmareModel(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(NightmareImpEntity entity) {
		return TEXTURE;
	}

}