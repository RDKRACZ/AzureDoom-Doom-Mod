package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.LostSoulEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.model.AnimatedGeoModel;

/**
 * LostSoul - __Botmon__
 */
public class LostSoulModel extends AnimatedGeoModel<LostSoulEntity> {

	private static final ResourceLocation[] TEX = {
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_1.png"),
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_2.png"),
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_3.png"),
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_4.png"),
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_5.png"),
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_6.png"),
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_7.png"),
			new ResourceLocation(DoomMod.MODID, "textures/entity/lost_soul_fire_8.png") };

	public LostSoulModel() {
	}

	@Override
	public ResourceLocation getModelLocation(LostSoulEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/lostsoul.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(LostSoulEntity object) {
		return TEX[(object.getFlameTimer())];
	}

	@Override
	public ResourceLocation getAnimationFileLocation(LostSoulEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/lostsoul_animation.json");
	}
}