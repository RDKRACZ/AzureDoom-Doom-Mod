package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.CacodemonEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CacodemonModel extends AnimatedGeoModel<CacodemonEntity> {

	public CacodemonModel() {
	}

	@Override
	public ResourceLocation getModelLocation(CacodemonEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/cacodemon.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(CacodemonEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/cacodemon.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(CacodemonEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/cacodemon_animation.json");
	}
}