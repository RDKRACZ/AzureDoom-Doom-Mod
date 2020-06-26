package mod.azure.doomweapon.client.render;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.ChaingunnerModel;
import mod.azure.doomweapon.entity.ChaingunnerEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;

public class ChaingunnerRender extends MobRenderer<ChaingunnerEntity, ChaingunnerModel<ChaingunnerEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/chaingunner.png");

	public ChaingunnerRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ChaingunnerModel<ChaingunnerEntity>(0.5f, false), 0.5f);
		this.addLayer(new HeldItemLayer<>(this));
	}

	@Override
	public ResourceLocation getEntityTexture(ChaingunnerEntity entity) {
		return TEXTURE;
	}

}