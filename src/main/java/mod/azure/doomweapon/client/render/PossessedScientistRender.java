package mod.azure.doomweapon.client.render;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.client.models.PossessedScientistModel;
import mod.azure.doomweapon.entity.PossessedScientistEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;

public class PossessedScientistRender extends MobRenderer<PossessedScientistEntity, PossessedScientistModel<PossessedScientistEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/possessedscientist.png");

	public PossessedScientistRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PossessedScientistModel<PossessedScientistEntity>(0.5f, false), 0.5f);
		this.addLayer(new HeldItemLayer<>(this));
	}

	@Override
	public ResourceLocation getEntityTexture(PossessedScientistEntity entity) {
		return TEXTURE;
	}

}