package mod.azure.doom.client.render.projectiles;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.projectiles.BFGEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;

public class BFGCellRender extends EntityRenderer<BFGEntity> {

	private static final ResourceLocation BFG_CELL_TEXTURE = new ResourceLocation(DoomMod.MODID,
			"textures/entity/projectiles/bfg.png");
	private static final RenderType field_229044_e_ = RenderType.getEntityCutoutNoCull(BFG_CELL_TEXTURE);
	private static final RenderType field_229056_k_ = RenderType
			.getEntitySmoothCutout(new ResourceLocation(DoomMod.MODID, "textures/entity/projectiles/bfg_beam.png"));

	public BFGCellRender(EntityRendererManager renderManagerIn) {
		super(renderManagerIn);
	}

	@Override
	public ResourceLocation getEntityTexture(BFGEntity entity) {
		return BFG_CELL_TEXTURE;
	}

	protected int getBlockLight(BFGEntity entityIn, BlockPos partialTicks) {
		return 15;
	}

	public void render(BFGEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
			IRenderTypeBuffer bufferIn, int packedLightIn) {
		matrixStackIn.push();
		float f = func_229051_a_(entityIn, partialTicks);
		matrixStackIn.scale(4.0F, 4.0F, 4.0F);
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
		LivingEntity blockpos = entityIn.getTargetedEntity();
		if (blockpos != null) {
			float f3 = (float) blockpos.getPosX() + 0.5F;
			float f4 = (float) blockpos.getPosY() + 0.5F;
			float f5 = (float) blockpos.getPosZ() + 0.5F;
			float f6 = (float) ((double) f3 - entityIn.getPosX());
			float f7 = (float) ((double) f4 - entityIn.getPosY());
			float f8 = (float) ((double) f5 - entityIn.getPosZ());
			matrixStackIn.translate((double) f6, (double) f7, (double) f8);
			func_229059_a_(-f6, -f7 + f, -f8, partialTicks, entityIn.ticksExisted, matrixStackIn, bufferIn,
					packedLightIn);
		}
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	private static void func_229045_a_(IVertexBuilder p_229045_0_, Matrix4f p_229045_1_, Matrix3f p_229045_2_,
			int p_229045_3_, float p_229045_4_, int p_229045_5_, int p_229045_6_, int p_229045_7_) {
		p_229045_0_.pos(p_229045_1_, p_229045_4_ - 0.5F, (float) p_229045_5_ - 0.25F, 0.0F).color(255, 255, 255, 255)
				.tex((float) p_229045_6_, (float) p_229045_7_).overlay(OverlayTexture.NO_OVERLAY).lightmap(p_229045_3_)
				.normal(p_229045_2_, 0.0F, 1.0F, 0.0F).endVertex();
	}

	public static void func_229059_a_(float p_229059_0_, float p_229059_1_, float p_229059_2_, float p_229059_3_,
			int p_229059_4_, MatrixStack p_229059_5_, IRenderTypeBuffer p_229059_6_, int p_229059_7_) {
		float f = MathHelper.sqrt(p_229059_0_ * p_229059_0_ + p_229059_2_ * p_229059_2_);
		float f1 = MathHelper.sqrt(p_229059_0_ * p_229059_0_ + p_229059_1_ * p_229059_1_ + p_229059_2_ * p_229059_2_);
		p_229059_5_.push();
		p_229059_5_.translate(0.0D, 2.0D, 0.0D);
		p_229059_5_.rotate(Vector3f.YP
				.rotation((float) (-Math.atan2((double) p_229059_2_, (double) p_229059_0_)) - ((float) Math.PI / 2F)));
		p_229059_5_.rotate(
				Vector3f.XP.rotation((float) (-Math.atan2((double) f, (double) p_229059_1_)) - ((float) Math.PI / 2F)));
		IVertexBuilder ivertexbuilder = p_229059_6_.getBuffer(field_229056_k_);
		float f2 = 0.0F - ((float) p_229059_4_ + p_229059_3_) * 0.01F;
		float f3 = MathHelper.sqrt(p_229059_0_ * p_229059_0_ + p_229059_1_ * p_229059_1_ + p_229059_2_ * p_229059_2_)
				/ 32.0F - ((float) p_229059_4_ + p_229059_3_) * 0.01F;
		float f4 = 0.0F;
		float f5 = 0.75F;
		float f6 = 0.0F;
		MatrixStack.Entry matrixstack$entry = p_229059_5_.getLast();
		Matrix4f matrix4f = matrixstack$entry.getMatrix();
		Matrix3f matrix3f = matrixstack$entry.getNormal();

		for (int j = 1; j <= 8; ++j) {
			float f7 = MathHelper.sin((float) j * ((float) Math.PI * 2F) / 8.0F) * 0.75F;
			float f8 = MathHelper.cos((float) j * ((float) Math.PI * 2F) / 8.0F) * 0.75F;
			float f9 = (float) j / 8.0F;
			ivertexbuilder.pos(matrix4f, f4 * 0.2F, f5 * 0.2F, 0.0F).color(0, 0, 0, 255).tex(f6, f2)
					.overlay(OverlayTexture.NO_OVERLAY).lightmap(p_229059_7_).normal(matrix3f, 0.0F, -1.0F, 0.0F)
					.endVertex();
			ivertexbuilder.pos(matrix4f, f4, f5, f1).color(255, 255, 255, 255).tex(f6, f3)
					.overlay(OverlayTexture.NO_OVERLAY).lightmap(p_229059_7_).normal(matrix3f, 0.0F, -1.0F, 0.0F)
					.endVertex();
			ivertexbuilder.pos(matrix4f, f7, f8, f1).color(255, 255, 255, 255).tex(f9, f3)
					.overlay(OverlayTexture.NO_OVERLAY).lightmap(p_229059_7_).normal(matrix3f, 0.0F, -1.0F, 0.0F)
					.endVertex();
			ivertexbuilder.pos(matrix4f, f7 * 0.2F, f8 * 0.2F, 0.0F).color(0, 0, 0, 255).tex(f9, f2)
					.overlay(OverlayTexture.NO_OVERLAY).lightmap(p_229059_7_).normal(matrix3f, 0.0F, -1.0F, 0.0F)
					.endVertex();
			f4 = f7;
			f5 = f8;
			f6 = f9;
		}

		p_229059_5_.pop();
	}

	public static float func_229051_a_(BFGEntity p_229051_0_, float p_229051_1_) {
		float f = (float) p_229051_0_.ticksExisted + p_229051_1_;
		float f1 = MathHelper.sin(f * 0.2F) / 2.0F + 0.5F;
		f1 = (f1 * f1 + f1) * 0.4F;
		return f1 - 1.4F;
	}

}