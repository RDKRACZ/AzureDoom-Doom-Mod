package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.UnwillingEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class UnwillingModel extends AnimatedGeoModel<UnwillingEntity> {

	public UnwillingModel() {
	}

	@Override
	public ResourceLocation getModelLocation(UnwillingEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/shotgunzombie.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(UnwillingEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/unwilling.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(UnwillingEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/shotgunzombie.animation.json");
	}

}