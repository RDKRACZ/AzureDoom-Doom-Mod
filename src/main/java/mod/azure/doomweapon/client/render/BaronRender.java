package mod.azure.doomweapon.client.render;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.BaronModel;
import mod.azure.doomweapon.entity.BaronEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BaronRender extends MobRenderer<BaronEntity, BaronModel<BaronEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/barron-of-hell_new.png");

	public BaronRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new BaronModel<>(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(BaronEntity entity) {
		return TEXTURE;
	}

}