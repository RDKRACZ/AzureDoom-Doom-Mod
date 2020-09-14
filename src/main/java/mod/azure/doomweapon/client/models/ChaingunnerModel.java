package mod.azure.doomweapon.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doomweapon.entity.ChaingunnerEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;

public class ChaingunnerModel<T extends ChaingunnerEntity> extends BipedModel<T> {
	public ModelRenderer bipedRightLeg_flat;
	public ModelRenderer bipedRightArm_flat;
	public ModelRenderer bipedBody;
	public ModelRenderer bipedHead;
	public ModelRenderer bipedLeftArm_flat;
	public ModelRenderer bipedLeftLeg_flat;
	public ModelRenderer bipedRightLeg;
	public ModelRenderer bipedRightLegwear;
	public ModelRenderer bipedRightLeg_1;
	public ModelRenderer bipedRightLegwear_1;
	public ModelRenderer bipedRightArm;
	public ModelRenderer bipedRightArmwear;
	public ModelRenderer bipedRightArm_1;
	public ModelRenderer bipedBodyWear;
	public ModelRenderer bipedHeadwear;
	public ModelRenderer bipedLeftArm;
	public ModelRenderer bipedLeftArmwear;
	public ModelRenderer bipedLeftArm_1;
	public ModelRenderer bipedLeftLeg;
	public ModelRenderer bipedLeftLegwear;
	public ModelRenderer bipedLeftLeg_1;
	public ModelRenderer bipedLeftLegwear_1;

	public ChaingunnerModel(float modelSize, boolean smallArmsIn) {
		super(RenderType::getEntityTranslucent, modelSize, 0.0F, 64, 64);
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.bipedBody = new ModelRenderer(this, 16, 16);
		this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.bipedRightLeg_1 = new ModelRenderer(this, 0, 22);
		this.bipedRightLeg_1.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.bipedRightLeg_1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, -0.1F, 0.5F, 0.4F);
		this.setRotateAngle(bipedRightLeg_1, 0.0781907508222411F, 0.0F, 0.0F);
		this.bipedLeftLeg = new ModelRenderer(this, 16, 48);
		this.bipedLeftLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.5F, 0.5F);
		this.setRotateAngle(bipedLeftLeg, -0.07330382525481048F, 0.0F, 0.0F);
		this.bipedRightArm = new ModelRenderer(this, 40, 16);
		this.bipedRightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.setRotateAngle(bipedRightArm, 0.0F, 0.0F, 0.10000736647217022F);
		this.bipedRightArm_flat = new ModelRenderer(this, 40, 16);
		this.bipedRightArm_flat.setRotationPoint(-6.4F, 2.0F, 0.0F);
		this.bipedRightArm_flat.addBox(-3.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.5F, 0.5F, 0.5F);
		this.bipedRightLeg = new ModelRenderer(this, 0, 16);
		this.bipedRightLeg.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.5F, 0.5F);
		this.setRotateAngle(bipedRightLeg, -0.07330382525481048F, 0.0F, 0.0F);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, 0.5F, 0.5F);
		this.bipedRightLegwear = new ModelRenderer(this, 0, 32);
		this.bipedRightLegwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedRightLegwear.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.25F, 0.75F, 0.75F);
		this.bipedRightLeg_flat = new ModelRenderer(this, 0, 16);
		this.bipedRightLeg_flat.setRotationPoint(-2.2F, 11.3F, -0.3F);
		this.bipedRightLeg_flat.addBox(-2.0F, 0.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.5F, 0.5F);
		this.bipedLeftArm_flat = new ModelRenderer(this, 32, 48);
		this.bipedLeftArm_flat.setRotationPoint(6.4F, 2.0F, 0.0F);
		this.bipedLeftArm_flat.addBox(-1.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.5F, 0.5F, 0.5F);
		this.bipedLeftArm_1 = new ModelRenderer(this, 32, 53);
		this.bipedLeftArm_1.setRotationPoint(0.0F, 5.0F, -1.2F);
		this.bipedLeftArm_1.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.4F, 1.0F, 0.4F);
		this.setRotateAngle(bipedLeftArm_1, -0.7037167490777915F, 0.0F, 0.0F);
		this.bipedRightArmwear = new ModelRenderer(this, 40, 32);
		this.bipedRightArmwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedRightArmwear.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.75F, 0.75F, 0.75F);
		this.bipedBodyWear = new ModelRenderer(this, 16, 32);
		this.bipedBodyWear.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedBodyWear.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.75F, 0.75F, 0.75F);
		this.bipedLeftLegwear_1 = new ModelRenderer(this, 0, 54);
		this.bipedLeftLegwear_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedLeftLegwear_1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.15F, 0.75F, 0.65F);
		this.bipedRightLegwear_1 = new ModelRenderer(this, 0, 38);
		this.bipedRightLegwear_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedRightLegwear_1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.15F, 0.75F, 0.65F);
		this.bipedLeftLegwear = new ModelRenderer(this, 0, 48);
		this.bipedLeftLegwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedLeftLegwear.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.25F, 0.75F, 0.75F);
		this.bipedLeftArm = new ModelRenderer(this, 32, 48);
		this.bipedLeftArm.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.setRotateAngle(bipedLeftArm, 0.0F, 0.0F, -0.10000736647217022F);
		this.bipedLeftArmwear = new ModelRenderer(this, 48, 48);
		this.bipedLeftArmwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedLeftArmwear.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.75F, 0.75F, 0.75F);
		this.bipedLeftLeg_flat = new ModelRenderer(this, 16, 48);
		this.bipedLeftLeg_flat.setRotationPoint(2.5F, 11.3F, 0.1F);
		this.bipedLeftLeg_flat.addBox(-2.0F, 0.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.5F, 0.5F);
		this.bipedRightArm_1 = new ModelRenderer(this, 40, 20);
		this.bipedRightArm_1.setRotationPoint(0.0F, 5.0F, -1.2F);
		this.bipedRightArm_1.addBox(-3.0F, -1.9F, -2.0F, 4.0F, 7.0F, 4.0F, 0.4F, 1.0F, 0.4F);
		this.setRotateAngle(bipedRightArm_1, -0.7037167490777915F, 0.0F, 0.0F);
		this.bipedHeadwear = new ModelRenderer(this, 32, 0);
		this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 1.0F, 1.0F, 1.0F);
		this.bipedLeftLeg_1 = new ModelRenderer(this, 16, 54);
		this.bipedLeftLeg_1.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.bipedLeftLeg_1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, 0.5F, 0.5F);
		this.setRotateAngle(bipedLeftLeg_1, 0.0781907508222411F, 0.0F, 0.0F);
		this.bipedRightLeg.addChild(this.bipedRightLeg_1);
		this.bipedLeftLeg_flat.addChild(this.bipedLeftLeg);
		this.bipedRightArm_flat.addChild(this.bipedRightArm);
		this.bipedRightLeg_flat.addChild(this.bipedRightLeg);
		this.bipedRightLeg.addChild(this.bipedRightLegwear);
		this.bipedLeftArm.addChild(this.bipedLeftArm_1);
		this.bipedRightArm.addChild(this.bipedRightArmwear);
		this.bipedBody.addChild(this.bipedBodyWear);
		this.bipedLeftLeg_1.addChild(this.bipedLeftLegwear_1);
		this.bipedRightLeg_1.addChild(this.bipedRightLegwear_1);
		this.bipedLeftLeg.addChild(this.bipedLeftLegwear);
		this.bipedLeftArm_flat.addChild(this.bipedLeftArm);
		this.bipedLeftArm.addChild(this.bipedLeftArmwear);
		this.bipedRightArm.addChild(this.bipedRightArm_1);
		this.bipedHead.addChild(this.bipedHeadwear);
		this.bipedLeftLeg.addChild(this.bipedLeftLeg_1);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.bipedBody, this.bipedRightArm_flat, this.bipedHead, this.bipedRightLeg_flat,
				this.bipedLeftArm_flat, this.bipedLeftLeg_flat).forEach((modelRenderer) -> {
					modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue,
							alpha);
				});
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.bipedRightArm_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount / 1.0F;
		this.bipedLeftArm_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
				* limbSwingAmount / 1.0F;
		if (this.swingProgress > 0.0F) {
			HandSide handside = this.getMainHand(entityIn);
			ModelRenderer modelrenderer = this.getArmForSide(handside);
			float f1 = this.swingProgress;
			if (handside == HandSide.LEFT) {
				this.bipedBody.rotateAngleY *= -1.0F;
			}

			f1 = 1.0F - this.swingProgress;
			float f2 = MathHelper.sin(f1 * (float) Math.PI);
			float f3 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.bipedHead.rotateAngleX - 0.7F)
					* 0.75F;
			modelrenderer.rotateAngleX = (float) ((double) modelrenderer.rotateAngleX
					- ((double) f2 * 1.2D + (double) f3));
			modelrenderer.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
			modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F;
		}
		this.bipedRightLeg_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.bipedLeftLeg_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
				* limbSwingAmount / 1.0F;
	}

	@Override
	public void translateHand(HandSide sideIn, MatrixStack matrixStackIn) {
		this.getArmForSide(sideIn).translateRotate(matrixStackIn);
		matrixStackIn.translate(-0.4D, -0.15D, 0.55D);
		matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(4.0F));
	}

	@Override
	protected ModelRenderer getArmForSide(HandSide side) {
		return side == HandSide.LEFT ? this.bipedLeftArm_1 : this.bipedRightArm_1;
	}

	protected HandSide getMainHand(T entityIn) {
		HandSide handside = entityIn.getPrimaryHand();
		return entityIn.swingingHand == Hand.MAIN_HAND ? handside : handside.opposite();
	}
}