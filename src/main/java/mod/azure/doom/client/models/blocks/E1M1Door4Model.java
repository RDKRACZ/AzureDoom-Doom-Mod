package mod.azure.doom.client.models.blocks;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.tileentity.E1M1Door4Entity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class E1M1Door4Model extends AnimatedGeoModel<E1M1Door4Entity> {

	public E1M1Door4Model() {
	}

	@Override
	public ResourceLocation getModelLocation(E1M1Door4Entity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/e1m1_door4.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(E1M1Door4Entity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/blocks/bigdoor4.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(E1M1Door4Entity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/e1m1_door4.animation.json");
	}
}