package mod.azure.doomweapon.client.render;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.ImpModel;
import mod.azure.doomweapon.entity.ImpEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ImpRender extends MobRenderer<ImpEntity, ImpModel<ImpEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/imp-texturemap.png");

	public ImpRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ImpModel<ImpEntity>(0.5f, false), 0.5f);
	}

	@Override
	public ResourceLocation getEntityTexture(ImpEntity entity) {
		return TEXTURE;
	}

}