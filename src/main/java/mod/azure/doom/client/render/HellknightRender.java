package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.HellknightModel;
import mod.azure.doom.entity.HellknightEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HellknightRender extends MobRenderer<HellknightEntity, HellknightModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/hellknight-texturemap.png");

	public HellknightRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new HellknightModel(), 0.7F);
	}

	@Override
	public ResourceLocation getEntityTexture(HellknightEntity entity) {
		return TEXTURE;
	}

}