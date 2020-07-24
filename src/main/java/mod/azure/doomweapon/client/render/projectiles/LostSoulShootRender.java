package mod.azure.doomweapon.client.render.projectiles;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.projectiles.PainShootEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;

public class LostSoulShootRender extends EntityRenderer<PainShootEntity> {

	private static final ResourceLocation ROCKET_TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/projectiles/pain.png");
	private static final RenderType field_229044_e_ = RenderType.getEntityCutoutNoCull(ROCKET_TEXTURE);

	public LostSoulShootRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getEntityTexture(PainShootEntity entity) {
		return ROCKET_TEXTURE;
	}

	protected int getBlockLight(PainShootEntity entityIn, BlockPos partialTicks) {
		return 15;
	}

	public void render(PainShootEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		matrixStackIn.push();
		matrixStackIn.scale(1.0F, 1.0F, 1.0F);
		matrixStackIn.rotate(this.renderManager.getCameraOrientation());
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F));
		MatrixStack.Entry matrixstack$entry = matrixStackIn.getLast();
		Matrix4f matrix4f = matrixstack$entry.getMatrix();
		Matrix3f matrix3f = matrixstack$entry.getNormal();
		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(field_229044_e_);
		func_229045_a_(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 0.0F, 0, 0, 1);
		func_229045_a_(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 1.0F, 0, 1, 1);
		func_229045_a_(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 1.0F, 1, 1, 0);
		func_229045_a_(ivertexbuilder, matrix4f, matrix3f, packedLightIn, 0.0F, 1, 0, 0);
		matrixStackIn.pop();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	private static void func_229045_a_(IVertexBuilder p_229045_0_, Matrix4f p_229045_1_, Matrix3f p_229045_2_,
			int p_229045_3_, float p_229045_4_, int p_229045_5_, int p_229045_6_, int p_229045_7_) {
		p_229045_0_.pos(p_229045_1_, p_229045_4_ - 0.5F, (float) p_229045_5_ - 0.25F, 0.0F).color(255, 255, 255, 255)
				.tex((float) p_229045_6_, (float) p_229045_7_).overlay(OverlayTexture.NO_OVERLAY).lightmap(p_229045_3_)
				.normal(p_229045_2_, 0.0F, 1.0F, 0.0F).endVertex();
	}

}