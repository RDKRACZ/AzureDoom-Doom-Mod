package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.SpectreEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SpectreModel extends AnimatedGeoModel<SpectreEntity> {

	public SpectreModel() {
	}

	@Override
	public ResourceLocation getModelLocation(SpectreEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/pinky.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(SpectreEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/pinky-texturemap.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(SpectreEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/pinky_animation.json");
	}
}