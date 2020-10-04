package mod.azure.doomweapon.client.render;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.HellknightModel;
import mod.azure.doomweapon.entity.HellknightEntity;
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