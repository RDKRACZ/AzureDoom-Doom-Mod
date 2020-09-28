package mod.azure.doom.client.render.projectiles;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.LostSoulModel;
import mod.azure.doom.client.render.layers.LayerFlames;
import mod.azure.doom.entity.LostSoulEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class LostSoulShootRender extends MobRenderer<LostSoulEntity, LostSoulModel<LostSoulEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/lost_soul.png");

	public LostSoulShootRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new LostSoulModel<>(), 0.8F);
		this.addLayer(new LayerFlames(this));
	}

	@Override
	protected int getBlockLight(LostSoulEntity entityIn, BlockPos partialTicks) {
		return 10;
	}

	@Override
	protected float getDeathMaxRotation(LostSoulEntity entityLivingBaseIn) {
		return 180.0F;
	}

	@Override
	public ResourceLocation getEntityTexture(LostSoulEntity entity) {
		return TEXTURE;
	}
}