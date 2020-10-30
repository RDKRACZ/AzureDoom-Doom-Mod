package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.MancubusEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class MancubusModel extends AnimatedGeoModel<MancubusEntity> {

	public MancubusModel() {
	}

	@Override
	public ResourceLocation getModelLocation(MancubusEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/mancubus.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(MancubusEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/mancubus.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(MancubusEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/mancubus_animation.json");
	}
}