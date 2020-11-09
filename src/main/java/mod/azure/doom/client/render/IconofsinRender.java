package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.IconofsinModel;
import mod.azure.doom.entity.IconofsinEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;

public class IconofsinRender extends MobRenderer<IconofsinEntity, IconofsinModel<IconofsinEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/iconofsin.png");

	public IconofsinRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new IconofsinModel<IconofsinEntity>(0.5f, false), 0.5f);
		this.addLayer(new HeldItemLayer<>(this));
	}

	@Override
	public ResourceLocation getEntityTexture(IconofsinEntity entity) {
		return TEXTURE;
	}

	protected void preRenderCallback(IconofsinEntity entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		matrixStackIn.scale(5.0F, 5.0F, 5.0F);
	}

}