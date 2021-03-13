package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.Cyberdemon2016Model;
import mod.azure.doom.entity.Cyberdemon2016Entity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class Cyberdemon2016Render extends MobRenderer<Cyberdemon2016Entity, Cyberdemon2016Model<Cyberdemon2016Entity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/cyberdemon2016.png");

	public Cyberdemon2016Render(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new Cyberdemon2016Model<Cyberdemon2016Entity>(0.5f, false), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Cyberdemon2016Entity entity) {
		return TEXTURE;
	}

	protected void scale(Cyberdemon2016Entity entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
		matrixStackIn.scale(2.5F, 2.5F, 2.5F);
	}

}