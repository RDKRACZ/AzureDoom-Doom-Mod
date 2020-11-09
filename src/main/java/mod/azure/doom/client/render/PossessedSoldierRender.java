package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.PossessedSoldierModel;
import mod.azure.doom.entity.PossessedSoldierEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;

public class PossessedSoldierRender
		extends MobRenderer<PossessedSoldierEntity, PossessedSoldierModel<PossessedSoldierEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/possessedsoldier.png");

	public PossessedSoldierRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new PossessedSoldierModel<PossessedSoldierEntity>(0.5f, false), 0.5f);
		this.addLayer(new HeldItemLayer<>(this));
	}

	@Override
	public ResourceLocation getEntityTexture(PossessedSoldierEntity entity) {
		return TEXTURE;
	}

}