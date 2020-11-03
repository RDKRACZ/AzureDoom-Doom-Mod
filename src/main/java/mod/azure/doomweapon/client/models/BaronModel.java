package mod.azure.doomweapon.client.models;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.BaronEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.model.AnimatedGeoModel;

public class BaronModel extends AnimatedGeoModel<BaronEntity> {

	public BaronModel() {
	}

	@Override
	public ResourceLocation getModelLocation(BaronEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/baron.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(BaronEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/baronofhell-texturemap.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(BaronEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/baron_hell_animation.json");
	}
}