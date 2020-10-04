package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.PinkyModel;
import mod.azure.doom.entity.PinkyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class PinkyRender extends MobRenderer<PinkyEntity, PinkyModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/pinky-texturemap.png");

	public PinkyRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PinkyModel(), 0.7F);
	}

	@Override
	public ResourceLocation getEntityTexture(PinkyEntity entity) {
		return TEXTURE;
	}

}