package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.PossessedScientistEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class PossessedScientistModel extends AnimatedGeoModel<PossessedScientistEntity> {

	public PossessedScientistModel() {
	}

	@Override
	public ResourceLocation getModelLocation(PossessedScientistEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/scientistpossessed.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(PossessedScientistEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/possessedscientist.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(PossessedScientistEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/possessed_scientist_animation.json");
	}
}