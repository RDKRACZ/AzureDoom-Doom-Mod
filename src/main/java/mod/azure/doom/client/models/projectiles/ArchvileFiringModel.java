package mod.azure.doom.client.models.projectiles;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.projectiles.entity.ArchvileFiring;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ArchvileFiringModel extends AnimatedGeoModel<ArchvileFiring> {
	@Override
	public ResourceLocation getModelLocation(ArchvileFiring object) {
		return new ResourceLocation(DoomMod.MODID, "geo/archvilefiring.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(ArchvileFiring object) {
		return new ResourceLocation(DoomMod.MODID, "textures/items/empty.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(ArchvileFiring animatable) {
		return new ResourceLocation(DoomMod.MODID, "animations/archvilefiring.animation.json");
	}
}
