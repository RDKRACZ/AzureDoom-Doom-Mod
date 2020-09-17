package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.SpiderdemonModel;
import mod.azure.doom.entity.SpiderdemonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SpiderdemonRender extends MobRenderer<SpiderdemonEntity, SpiderdemonModel<SpiderdemonEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/spidermastermind-texturemap.png");

	public SpiderdemonRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new SpiderdemonModel<>(), 0.8F);
	}

	@Override
	public ResourceLocation getEntityTexture(SpiderdemonEntity entity) {
		return TEXTURE;
	}

}