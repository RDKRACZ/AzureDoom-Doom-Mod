package mod.azure.doomweapon.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class BaronModel<T extends Entity> extends EntityModel<T> {
	public ModelRenderer bipedRightArm;
	public ModelRenderer bipedLeftLeg;
	public ModelRenderer bipedHeadwear;
	public ModelRenderer bipedLeftArm;
	public ModelRenderer bipedBody;
	public ModelRenderer bipedHead;
	public ModelRenderer bipedRightLeg;
	public ModelRenderer bipedRightArm_1;
	public ModelRenderer bipedLeftLeg_1;
	public ModelRenderer bipedLeftLeg_2;
	public ModelRenderer bipedLeftLeg_3;
	public ModelRenderer bipedLeftArm_1;
	public ModelRenderer bipedBody_1;
	public ModelRenderer pinkyHornL;
	public ModelRenderer pinkyHornR;
	public ModelRenderer pinkyHornL_1;
	public ModelRenderer pinkyHornR_1;
	public ModelRenderer bipedRightLeg_1;
	public ModelRenderer bipedRightLeg_2;
	public ModelRenderer bipedRightLeg_3;

	public BaronModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.pinkyHornR_1 = new ModelRenderer(this, 0, 53);
		this.pinkyHornR_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pinkyHornR_1.addBox(7.3F, -8.0F, -5.0F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6F, -0.099999905F);
		this.setRotateAngle(pinkyHornR_1, 1.5707963267948966F, 0.0F, -1.5707963267948966F);
		this.bipedLeftLeg_2 = new ModelRenderer(this, 0, 16);
		this.bipedLeftLeg_2.mirror = true;
		this.bipedLeftLeg_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedLeftLeg_2.addBox(0.0F, 4.6F, -1.0F, 4.0F, 6.8F, 4.0F, 0.6F, -1.5F, 0.6F);
		this.bipedLeftLeg_3 = new ModelRenderer(this, 0, 26);
		this.bipedLeftLeg_3.mirror = true;
		this.bipedLeftLeg_3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedLeftLeg_3.addBox(0.0F, 10.0F, -1.0F, 4.0F, 2.0F, 4.0F, 0.6F, 0.1F, 0.6F);
		this.bipedRightLeg_3 = new ModelRenderer(this, 0, 26);
		this.bipedRightLeg_3.mirror = true;
		this.bipedRightLeg_3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedRightLeg_3.addBox(0.0F, 10.0F, -1.0F, 4.0F, 2.0F, 4.0F, 0.6F, 0.1F, 0.6F);
		this.bipedHeadwear = new ModelRenderer(this, 32, 0);
		this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 1.0F, 1.0F, 1.0F);
		this.bipedLeftLeg_1 = new ModelRenderer(this, 0, 16);
		this.bipedLeftLeg_1.mirror = true;
		this.bipedLeftLeg_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedLeftLeg_1.addBox(0.0F, 0.9F, -5.5F, 4.0F, 8.0F, 4.0F, 0.5F, -2.0F, 0.5F);
		this.setRotateAngle(bipedLeftLeg_1, 0.6646214111173737F, 0.0F, 0.0F);
		this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
		this.bipedLeftLeg.mirror = true;
		this.bipedLeftLeg.setRotationPoint(1.1F, 12.0F, 0.1F);
		this.bipedLeftLeg.addBox(0.0F, -2.6F, -2.1F, 4.0F, 9.9F, 4.0F, 0.6F, -1.5F, 0.6F);
		this.bipedLeftArm = new ModelRenderer(this, 40, 16);
		this.bipedLeftArm.mirror = true;
		this.bipedLeftArm.setRotationPoint(6.8F, 2.0F, 0.0F);
		this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 1.0F, 0.5F, 1.0F);
		this.setRotateAngle(bipedLeftArm, -1.0555751236166873F, 0.0F, 0.0F);
		this.bipedRightArm = new ModelRenderer(this, 40, 16);
		this.bipedRightArm.setRotationPoint(-6.8F, 2.0F, 0.0F);
		this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, 1.0F, 0.5F, 1.0F);
		this.setRotateAngle(bipedRightArm, -1.0555751236166873F, 0.0F, 0.0F);
		this.bipedBody = new ModelRenderer(this, 16, 16);
		this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, 0.8F, 0.5F, 0.7F);
		this.bipedBody_1 = new ModelRenderer(this, 16, 16);
		this.bipedBody_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedBody_1.addBox(-4.0F, 6.0F, -2.0F, 8.0F, 6.0F, 4.0F, 0.4F, 0.5F, 0.4F);
		this.pinkyHornL_1 = new ModelRenderer(this, 0, 53);
		this.pinkyHornL_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pinkyHornL_1.addBox(7.3F, -8.0F, 3.0F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6F, -0.099999905F);
		this.setRotateAngle(pinkyHornL_1, 1.5707963267948966F, 0.0F, -1.5707963267948966F);
		this.bipedRightLeg_2 = new ModelRenderer(this, 0, 16);
		this.bipedRightLeg_2.mirror = true;
		this.bipedRightLeg_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedRightLeg_2.addBox(0.0F, 4.6F, -1.0F, 4.0F, 6.8F, 4.0F, 0.6F, -1.5F, 0.6F);
		this.bipedRightLeg = new ModelRenderer(this, 0, 16);
		this.bipedRightLeg.mirror = true;
		this.bipedRightLeg.setRotationPoint(-5.1F, 12.0F, 0.1F);
		this.bipedRightLeg.addBox(0.0F, -2.6F, -2.1F, 4.0F, 9.9F, 4.0F, 0.6F, -1.5F, 0.6F);
		this.bipedRightArm_1 = new ModelRenderer(this, 40, 22);
		this.bipedRightArm_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedRightArm_1.addBox(-3.0F, 5.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.bipedLeftArm_1 = new ModelRenderer(this, 40, 22);
		this.bipedLeftArm_1.mirror = true;
		this.bipedLeftArm_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedLeftArm_1.addBox(-1.0F, 5.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.pinkyHornR = new ModelRenderer(this, 0, 53);
		this.pinkyHornR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pinkyHornR.addBox(3.0F, -12.0F, -1.5F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6000001F, 0.0F);
		this.setRotateAngle(pinkyHornR, 0.0F, 0.0F, -1.4161601444155547F);
		this.bipedHead = new ModelRenderer(this, 0, 0);
		this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, 0.5F, 0.5F);
		this.bipedRightLeg_1 = new ModelRenderer(this, 0, 16);
		this.bipedRightLeg_1.mirror = true;
		this.bipedRightLeg_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bipedRightLeg_1.addBox(0.0F, 0.9F, -5.5F, 4.0F, 8.0F, 4.0F, 0.5F, -2.0F, 0.2F);
		this.setRotateAngle(bipedRightLeg_1, 0.6646214111173737F, 0.0F, 0.0F);
		this.pinkyHornL = new ModelRenderer(this, 0, 53);
		this.pinkyHornL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pinkyHornL.addBox(-5.0F, -12.0F, -1.5F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6000001F, 0.0F);
		this.setRotateAngle(pinkyHornL, 0.0F, 0.0F, 1.4161601444155547F);
		this.pinkyHornR.addChild(this.pinkyHornR_1);
		this.bipedLeftLeg.addChild(this.bipedLeftLeg_2);
		this.bipedLeftLeg_2.addChild(this.bipedLeftLeg_3);
		this.bipedRightLeg_2.addChild(this.bipedRightLeg_3);
		this.bipedLeftLeg.addChild(this.bipedLeftLeg_1);
		this.bipedBody.addChild(this.bipedBody_1);
		this.pinkyHornL.addChild(this.pinkyHornL_1);
		this.bipedRightLeg.addChild(this.bipedRightLeg_2);
		this.bipedRightArm.addChild(this.bipedRightArm_1);
		this.bipedLeftArm.addChild(this.bipedLeftArm_1);
		this.bipedHead.addChild(this.pinkyHornR);
		this.bipedRightLeg.addChild(this.bipedRightLeg_1);
		this.bipedHead.addChild(this.pinkyHornL);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.bipedHeadwear, this.bipedHead, this.bipedRightArm, this.bipedLeftLeg, this.bipedRightLeg,
				this.bipedLeftArm, this.bipedBody).forEach((modelRenderer) -> {
					modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue,
							alpha);
				});
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		ModelHelper.func_239105_a_(this.bipedLeftArm, this.bipedRightArm, false, this.swingProgress, ageInTicks);
		this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
				/ 1.0F;
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}