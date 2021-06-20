package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.tierheavy.BloodMaykrEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BloodMaykrModel extends AnimatedGeoModel<BloodMaykrEntity> {

	@Override
	public ResourceLocation getModelLocation(BloodMaykrEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/whiplash.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(BloodMaykrEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/bloodmaykr.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(BloodMaykrEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/whiplash.animation.json");
	}

}