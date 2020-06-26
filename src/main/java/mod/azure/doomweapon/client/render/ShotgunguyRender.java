package mod.azure.doomweapon.client.render;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.ShotgunguyModel;
import mod.azure.doomweapon.entity.ShotgunguyEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;

public class ShotgunguyRender extends MobRenderer<ShotgunguyEntity, ShotgunguyModel<ShotgunguyEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/shotgunguy.png");

	public ShotgunguyRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ShotgunguyModel<ShotgunguyEntity>(0.5f, false), 0.5f);
		this.addLayer(new HeldItemLayer<>(this));
	}

	@Override
	public ResourceLocation getEntityTexture(ShotgunguyEntity entity) {
		return TEXTURE;
	}

}