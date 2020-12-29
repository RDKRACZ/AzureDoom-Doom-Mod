package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ChaingunnerEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ChaingunnerModel extends AnimatedGeoModel<ChaingunnerEntity> {

	public ChaingunnerModel() {
	}

	@Override
	public ResourceLocation getModelLocation(ChaingunnerEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/chaingunner.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(ChaingunnerEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/chaingunner.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(ChaingunnerEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/chaingunner.animation.json");
	}
}