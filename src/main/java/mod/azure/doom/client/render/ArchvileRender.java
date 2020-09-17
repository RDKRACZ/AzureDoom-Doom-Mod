package mod.azure.doom.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;

import mod.azure.doom.DoomMod;
import mod.azure.doom.client.models.ArchvileModel;
import mod.azure.doom.entity.ArchvileEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3d;

public class ArchvileRender extends MobRenderer<ArchvileEntity, ArchvileModel<ArchvileEntity>> {

	protected static final ResourceLocation TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/archvile.png");

	public ArchvileRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new ArchvileModel<>(0.0F), 0.5F);
	}

	@Override
	public void render(ArchvileEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public Vector3d getRenderOffset(ArchvileEntity entityIn, float partialTicks) {
		return super.getRenderOffset(entityIn, partialTicks);
	}

	@Override
	public ResourceLocation getEntityTexture(ArchvileEntity entity) {
		return TEXTURE;
	}

}