package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ArchMakyrEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArchMaykrModel extends AnimatedGeoModel<ArchMakyrEntity> {

	@Override
	public ResourceLocation getModelLocation(ArchMakyrEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/archmaykr_" + object.getVariant() + ".geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(ArchMakyrEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/archmaykr_" + object.getVariant() + ".png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(ArchMakyrEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/archmaykr.animation.json");
	}

}