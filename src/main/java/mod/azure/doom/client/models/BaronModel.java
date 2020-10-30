package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.BaronEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class BaronModel extends AnimatedGeoModel<BaronEntity> {

	public BaronModel() {
	}

	@Override
	public ResourceLocation getModelLocation(BaronEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/baron.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(BaronEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/baronofhell-texturemap.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(BaronEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/baron_hell_animation.json");
	}
}