package mod.azure.doomweapon.client.models;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.CyberdemonEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class CyberdemonModel extends AnimatedGeoModel<CyberdemonEntity> {

	public CyberdemonModel() {
	}

	@Override
	public ResourceLocation getModelLocation(CyberdemonEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/cyberdemon.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(CyberdemonEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/cyberdemon-texturemap.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(CyberdemonEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/cyberdemon_animation.json");
	}
}