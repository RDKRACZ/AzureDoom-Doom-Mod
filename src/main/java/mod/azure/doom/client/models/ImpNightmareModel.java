package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.NightmareImpEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ImpNightmareModel extends AnimatedGeoModel<NightmareImpEntity> {

	public ImpNightmareModel() {
	}

	@Override
	public ResourceLocation getModelLocation(NightmareImpEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/nightmareimp.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(NightmareImpEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/nightmareimp-texture.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(NightmareImpEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/imp_animation.json");
	}
}