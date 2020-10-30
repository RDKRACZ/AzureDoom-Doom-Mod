package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.LostSoulEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.model.AnimatedGeoModel;

/**
 * LostSoul - __Botmon__
 */
public class LostSoulModel extends AnimatedGeoModel<LostSoulEntity> {

	public LostSoulModel() {
	}

	@Override
	public ResourceLocation getModelLocation(LostSoulEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/lostsoul.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(LostSoulEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(LostSoulEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/lostsoul_animation.json");
	}
}