package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.GargoyleEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GargoyleModel extends AnimatedGeoModel<GargoyleEntity> {

	public GargoyleModel() {
	}

	@Override
	public ResourceLocation getModelLocation(GargoyleEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/gargoyleimp.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(GargoyleEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/gargoyleimp.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(GargoyleEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/gargoyleimp.animation.json");
	}
}