package mod.azure.doomweapon.client.models;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.HellknightEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class HellknightModel extends AnimatedGeoModel<HellknightEntity> {

	public HellknightModel() {
	}

	@Override
	public ResourceLocation getModelLocation(HellknightEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/hellknight.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(HellknightEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/hellknight-texturemap.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(HellknightEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/baron_hell_animation.json");
	}
}