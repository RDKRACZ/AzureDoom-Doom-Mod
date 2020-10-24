package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.MechaZombieModel;
import mod.azure.doom.entity.MechaZombieEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MechaZombieRender extends MobRenderer<MechaZombieEntity, MechaZombieModel> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/mechazombie.png");

	public MechaZombieRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new MechaZombieModel(), 0.5f);

	}

	@Override
	protected void preRenderCallback(MechaZombieEntity entitylivingbaseIn, MatrixStack matrixStackIn,
			float partialTickTime) {
//		matrixStackIn.scale(0.7F, 0.7F, 0.7F);
	}

	@Override
	protected float getDeathMaxRotation(MechaZombieEntity entityLivingBaseIn) {
		return 0.0F;
	}

	@Override
	public ResourceLocation getEntityTexture(MechaZombieEntity entity) {
		return TEXTURE;
	}

}