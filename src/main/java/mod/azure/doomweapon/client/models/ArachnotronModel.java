package mod.azure.doomweapon.client.models;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.ArachnotronEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.model.AnimatedGeoModel;

/**
 * Arachnotron - Batpixxler
 */
public class ArachnotronModel extends AnimatedGeoModel<ArachnotronEntity> {

	public ArachnotronModel() {
	}

	@Override
	public ResourceLocation getModelLocation(ArachnotronEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/arachnotron.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(ArachnotronEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/arachnotron-texturemap.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(ArachnotronEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/arachnotron_walking.json");
	}
}