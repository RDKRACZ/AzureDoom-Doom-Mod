package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.tiersuperheavy.DoomHunterEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DoomHunterModel extends AnimatedGeoModel<DoomHunterEntity> {

	@Override
	public ResourceLocation getModelLocation(DoomHunterEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/doomhunter.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(DoomHunterEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/doomhunter.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(DoomHunterEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/doomhunter.animation.json");
	}

}