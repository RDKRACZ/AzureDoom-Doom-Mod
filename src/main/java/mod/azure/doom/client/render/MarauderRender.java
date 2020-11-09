package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.MarauderModel;
import mod.azure.doom.entity.MarauderEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;

public class MarauderRender extends MobRenderer<MarauderEntity, MarauderModel<MarauderEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/marauder.png");

	public MarauderRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new MarauderModel<MarauderEntity>(0.5f, false), 0.5f);
		this.addLayer(new HeldItemLayer<>(this));
	}

	@Override
	public ResourceLocation getEntityTexture(MarauderEntity entity) {
		return TEXTURE;
	}

	protected void preRenderCallback(MarauderEntity entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		matrixStackIn.scale(1.0F, 1.0F, 1.0F);
	}

}