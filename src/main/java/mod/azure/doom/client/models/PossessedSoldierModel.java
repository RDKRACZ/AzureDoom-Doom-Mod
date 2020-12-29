package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.PossessedSoldierEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PossessedSoldierModel extends AnimatedGeoModel<PossessedSoldierEntity> {

	public PossessedSoldierModel() {
	}

	@Override
	public ResourceLocation getModelLocation(PossessedSoldierEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/shotgunzombie.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(PossessedSoldierEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/possessedsoldier.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(PossessedSoldierEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/shotgunzombie.animation.json");
	}
}