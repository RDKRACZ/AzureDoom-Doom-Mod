package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.RevenantEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class RevenantModel extends AnimatedGeoModel<RevenantEntity> {

	public RevenantModel() {
	}

	@Override
	public ResourceLocation getModelLocation(RevenantEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/revenant.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(RevenantEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/revenant.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(RevenantEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/revenant.animation.json");
	}
}