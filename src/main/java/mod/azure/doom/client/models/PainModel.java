package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.PainEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PainModel extends AnimatedGeoModel<PainEntity> {

	private static final ResourceLocation NORMAL = new ResourceLocation(DoomMod.MODID,
			"textures/entity/painelemental-normal.png");
	private static final ResourceLocation ATTACKING = new ResourceLocation(DoomMod.MODID,
			"textures/entity/painelemental-attacking.png");

	public PainModel() {
	}

	@Override
	public ResourceLocation getModelLocation(PainEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/pain.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(PainEntity object) {
		return object.isAttacking() ? ATTACKING : NORMAL;
	}

	@Override
	public ResourceLocation getAnimationFileLocation(PainEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/pain_animation.json");
	}
}