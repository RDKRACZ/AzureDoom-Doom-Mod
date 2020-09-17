package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.BaronModel;
import mod.azure.doom.entity.BaronEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BaronRender extends MobRenderer<BaronEntity, BaronModel<BaronEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/baronofhell-texturemap.png");

	public BaronRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new BaronModel<>(), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(BaronEntity entity) {
		return TEXTURE;
	}

}