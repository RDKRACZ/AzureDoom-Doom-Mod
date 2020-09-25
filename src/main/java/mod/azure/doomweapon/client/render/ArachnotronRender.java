package mod.azure.doomweapon.client.render;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.ArachnotronModel;
import mod.azure.doomweapon.entity.ArachnotronEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ArachnotronRender extends MobRenderer<ArachnotronEntity, ArachnotronModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/arachnotron-texturemap.png");

	public ArachnotronRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ArachnotronModel(), 0.8F);
	}

	@Override
	public ResourceLocation getEntityTexture(ArachnotronEntity entity) {
		return TEXTURE;
	}

}