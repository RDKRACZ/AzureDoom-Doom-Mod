package mod.azure.doomweapon.client.models;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.SpiderdemonEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class SpiderdemonModel extends AnimatedGeoModel<SpiderdemonEntity> {

	public SpiderdemonModel() {
	}

	@Override
	public ResourceLocation getModelLocation(SpiderdemonEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/spidermastermind.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(SpiderdemonEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/spidermastermind-texturemap.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(SpiderdemonEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/spidermastermind_animation.json");
	}
}