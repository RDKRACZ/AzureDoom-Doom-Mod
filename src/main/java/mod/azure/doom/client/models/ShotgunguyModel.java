package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ShotgunguyEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ShotgunguyModel extends AnimatedGeoModel<ShotgunguyEntity> {

	public ShotgunguyModel() {
	}

	@Override
	public ResourceLocation getModelLocation(ShotgunguyEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/shotgunzombie.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(ShotgunguyEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/shotgunguy.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(ShotgunguyEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/shotgunzombie.animation.json");
	}
}