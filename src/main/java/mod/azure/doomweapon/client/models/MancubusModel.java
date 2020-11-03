package mod.azure.doomweapon.client.models;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.MancubusEntity;
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