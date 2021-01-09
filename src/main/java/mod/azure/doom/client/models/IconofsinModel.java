package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.IconofsinEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IconofsinModel extends AnimatedGeoModel<IconofsinEntity> {

	public IconofsinModel() {
	}

	@Override
	public ResourceLocation getModelLocation(IconofsinEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/icon.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(IconofsinEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/iconofsin.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(IconofsinEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/icon.animation.json");
	}
}