package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.MarauderEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MarauderModel extends AnimatedGeoModel<MarauderEntity> {

	public MarauderModel() {
	}

	@Override
	public ResourceLocation getModelLocation(MarauderEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/shotgunzombie.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(MarauderEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/marauder.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(MarauderEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/shotgunzombie.animation.json");
	}
}