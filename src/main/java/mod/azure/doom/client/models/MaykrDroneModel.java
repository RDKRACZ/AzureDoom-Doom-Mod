package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.MaykrDroneEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MaykrDroneModel extends AnimatedGeoModel<MaykrDroneEntity> {

	@Override
	public ResourceLocation getModelLocation(MaykrDroneEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/doomhunter.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(MaykrDroneEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/doomhunter.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(MaykrDroneEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/empty.animation.json");
	}
}
