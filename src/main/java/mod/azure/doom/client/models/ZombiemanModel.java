package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ZombiemanEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ZombiemanModel extends AnimatedGeoModel<ZombiemanEntity> {

	public ZombiemanModel() {
	}

	@Override
	public ResourceLocation getModelLocation(ZombiemanEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/shotgunzombie.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(ZombiemanEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/eternalzombiemen.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(ZombiemanEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/shotgunzombie.animation.json");
	}
}