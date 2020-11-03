package mod.azure.doomweapon.client.models;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.PinkyEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class PinkyModel extends AnimatedGeoModel<PinkyEntity> {

	public PinkyModel() {
	}

	@Override
	public ResourceLocation getModelLocation(PinkyEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/pinky.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(PinkyEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/pinky-texturemap.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(PinkyEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/pinky_animation.json");
	}
}