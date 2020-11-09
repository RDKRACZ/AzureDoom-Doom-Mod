package mod.azure.doom.client.render;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.RevenantModel;
import mod.azure.doom.entity.RevenantEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;

public class RevenantRender extends BipedRenderer<RevenantEntity, RevenantModel<RevenantEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/revenant.png");

	@SuppressWarnings("rawtypes")
	public RevenantRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new RevenantModel<>(), 0.5F);
		this.addLayer(new HeldItemLayer<>(this));
		this.addLayer(new BipedArmorLayer<>(this, new RevenantModel(0.5F, true), new RevenantModel(1.0F, true)));
	}

	@Override
	public ResourceLocation getEntityTexture(RevenantEntity entity) {
		return TEXTURE;
	}

}