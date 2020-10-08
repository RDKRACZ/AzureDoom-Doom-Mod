package mod.azure.doom.client.render.projectiles;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.LostSoulModel;
import mod.azure.doom.client.render.layers.LayerFlames;
import mod.azure.doom.entity.LostSoulEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class LostSoulShootRender extends MobRenderer<LostSoulEntity, LostSoulModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/lost_soul.png");

	public LostSoulShootRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new LostSoulModel(), 0.8F);
		this.addLayer(new LayerFlames(this));
	}

	@Override
	public ResourceLocation getEntityTexture(LostSoulEntity entity) {
		return TEXTURE;
	}
}