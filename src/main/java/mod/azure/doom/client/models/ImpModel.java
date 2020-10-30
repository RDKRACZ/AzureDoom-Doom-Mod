package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ImpEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class ImpModel extends AnimatedGeoModel<ImpEntity> {

	public ImpModel() {
	}

	@Override
	public ResourceLocation getModelLocation(ImpEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/imp.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(ImpEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/imp-texturemap.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(ImpEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/imp_animation.json");
	}
}