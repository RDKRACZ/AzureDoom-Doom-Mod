package mod.azure.doomweapon.client.render;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.SpiderdemonModel;
import mod.azure.doomweapon.entity.SpiderdemonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SpiderdemonRender extends MobRenderer<SpiderdemonEntity, SpiderdemonModel<SpiderdemonEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/spiderdemon.png");

	public SpiderdemonRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new SpiderdemonModel<>(), 0.8F);
	}

	@Override
	public ResourceLocation getEntityTexture(SpiderdemonEntity entity) {
		return TEXTURE;
	}

}