package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.ArachnotronModel;
import mod.azure.doom.entity.ArachnotronEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ArachnotronRender extends MobRenderer<ArachnotronEntity, ArachnotronModel<ArachnotronEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/arachnotron-texturemap.png");

	public ArachnotronRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ArachnotronModel<>(), 0.8F);
	}

	@Override
	public ResourceLocation getEntityTexture(ArachnotronEntity entity) {
		return TEXTURE;
	}

}