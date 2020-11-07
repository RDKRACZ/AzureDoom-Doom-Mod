package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.MechaZombieEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MechaZombieModel extends AnimatedGeoModel<MechaZombieEntity> {

	public MechaZombieModel() {
	}

	@Override
	public ResourceLocation getModelLocation(MechaZombieEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/mechazombie.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(MechaZombieEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/mechazombie.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(MechaZombieEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/mechazombie_animation.json");
	}
}