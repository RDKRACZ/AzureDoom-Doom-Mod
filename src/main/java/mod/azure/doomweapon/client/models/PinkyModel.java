package mod.azure.doomweapon.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class PinkyModel<T extends Entity> extends EntityModel<T> {
	public ModelRenderer pinkyArmR;
	public ModelRenderer pinkyHead;
	public ModelRenderer pinkyLegR;
	public ModelRenderer pinkyArmL;
	public ModelRenderer pinkyLegL;
	public ModelRenderer pinkyBody;
	public ModelRenderer pinkyArmR_1;
	public ModelRenderer pinkyHornL;
	public ModelRenderer pinkyHornR;
	public ModelRenderer pinkyLegR_1;
	public ModelRenderer pinkyLegR_2;
	public ModelRenderer pinkyArmL_1;
	public ModelRenderer pinkyLegL_1;
	public ModelRenderer pinkyLegL_2;
	public ModelRenderer pinkyBody_1;

	public PinkyModel() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.pinkyLegR = new ModelRenderer(this, 21, 45);
		this.pinkyLegR.setRotationPoint(-5.0F, 13.0F, 10.0F);
		this.pinkyLegR.addBox(-2.5F, -6.6F, -6.8F, 5.0F, 10.0F, 5.0F, 0.0F, -2.0F, 0.0F);
		this.pinkyArmR_1 = new ModelRenderer(this, 66, 42);
		this.pinkyArmR_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pinkyArmR_1.addBox(-10.0F, -11.9F, 6.8F, 6.0F, 12.0F, 6.0F, -0.1F, 0.0F, -0.1F);
		this.setRotateAngle(pinkyArmR_1, -1.5707963267948966F, 0.0F, 0.0F);
		this.pinkyHead = new ModelRenderer(this, 61, 1);
		this.pinkyHead.setRotationPoint(0.0F, 2.0F, -12.0F);
		this.pinkyHead.addBox(-7.0F, 0.6F, -9.6F, 14.0F, 6.0F, 19.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(pinkyHead, 1.5372860371145385F, 0.0F, 0.0F);
		this.pinkyBody_1 = new ModelRenderer(this, 43, 28);
		this.pinkyBody_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pinkyBody_1.addBox(-2.1F, -11.1F, -6.3F, 5.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(pinkyBody_1, 1.1040952555168408F, 0.0F, 0.0F);
		this.pinkyArmL = new ModelRenderer(this, 41, 42);
		this.pinkyArmL.setRotationPoint(4.0F, 10.0F, -8.5F);
		this.pinkyArmL.addBox(4.0F, 1.0F, 6.9F, 6.0F, 12.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(pinkyArmL, 0.0F, 0.0F, -1.4856243072344728F);
		this.pinkyLegL = new ModelRenderer(this, 0, 45);
		this.pinkyLegL.setRotationPoint(5.0F, 13.0F, 10.0F);
		this.pinkyLegL.addBox(-2.5F, -6.6F, -6.8F, 5.0F, 10.0F, 5.0F, 0.0F, -2.0F, 0.0F);
		this.pinkyHornL = new ModelRenderer(this, 1, 13);
		this.pinkyHornL.setRotationPoint(7.0F, 2.0F, -12.0F);
		this.pinkyHornL.addBox(-0.3F, -8.7F, 15.1F, 2.0F, 11.0F, 2.0F, 0.0F, -2.4F, 0.0F);
		this.setRotateAngle(pinkyHornL, 0.0F, 0.0F, 1.4161601444155547F);
		this.pinkyHornR = new ModelRenderer(this, 10, 13);
		this.pinkyHornR.setRotationPoint(-7.0F, 2.0F, -12.0F);
		this.pinkyHornR.addBox(-1.7F, -8.6F, 15.1F, 2.0F, 11.0F, 2.0F, 0.0F, -2.4F, 0.0F);
		this.setRotateAngle(pinkyHornR, 0.0F, 0.0F, -1.4161601444155547F);
		this.pinkyArmR = new ModelRenderer(this, 66, 42);
		this.pinkyArmR.setRotationPoint(-4.0F, 10.0F, -8.5F);
		this.pinkyArmR.addBox(-10.0F, 0.8F, 6.9F, 6.0F, 12.0F, 6.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(pinkyArmR, -0.03909537541112055F, 0.0F, 1.4856243072344728F);
		this.pinkyBody = new ModelRenderer(this, 1, 1);
		this.pinkyBody.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.pinkyBody.addBox(-7.9F, -10.5F, -15.5F, 16.0F, 14.0F, 26.0F, -0.4F, -3.0F, -5.0F);
		this.setRotateAngle(pinkyBody, -1.13376586611655F, 0.0F, 0.0F);
		this.pinkyLegL_2 = new ModelRenderer(this, 0, 53);
		this.pinkyLegL_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pinkyLegL_2.addBox(-2.5F, 8.0F, -9.7F, 5.0F, 3.0F, 5.0F, 0.5F, 0.0F, 0.5F);
		this.setRotateAngle(pinkyLegL_2, 0.35185837453889574F, 0.0F, 0.0F);
		this.pinkyLegL_1 = new ModelRenderer(this, 0, 45);
		this.pinkyLegL_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pinkyLegL_1.addBox(-2.5F, 2.0F, -6.4F, 5.0F, 10.0F, 5.0F, -0.1F, 0.1F, -0.1F);
		this.setRotateAngle(pinkyLegL_1, -0.35185837453889574F, 0.0F, 0.0F);
		this.pinkyLegR_1 = new ModelRenderer(this, 21, 45);
		this.pinkyLegR_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pinkyLegR_1.addBox(-2.5F, 2.0F, -6.4F, 5.0F, 10.0F, 5.0F, -0.1F, 0.1F, -0.1F);
		this.setRotateAngle(pinkyLegR_1, -0.35185837453889574F, 0.0F, 0.0F);
		this.pinkyArmL_1 = new ModelRenderer(this, 41, 42);
		this.pinkyArmL_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pinkyArmL_1.addBox(4.0F, -12.0F, 7.0F, 6.0F, 12.0F, 6.0F, -0.1F, 0.0F, -0.1F);
		this.setRotateAngle(pinkyArmL_1, -1.5707963267948966F, 0.0F, 0.0F);
		this.pinkyLegR_2 = new ModelRenderer(this, 21, 53);
		this.pinkyLegR_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.pinkyLegR_2.addBox(-2.5F, 8.0F, -9.7F, 5.0F, 3.0F, 5.0F, 0.5F, 0.0F, 0.5F);
		this.setRotateAngle(pinkyLegR_2, 0.35185837453889574F, 0.0F, 0.0F);
		this.pinkyArmR.addChild(this.pinkyArmR_1);
		this.pinkyBody.addChild(this.pinkyBody_1);
		this.pinkyHead.addChild(this.pinkyHornL);
		this.pinkyHead.addChild(this.pinkyHornR);
		this.pinkyLegL_1.addChild(this.pinkyLegL_2);
		this.pinkyLegL.addChild(this.pinkyLegL_1);
		this.pinkyLegR.addChild(this.pinkyLegR_1);
		this.pinkyArmL.addChild(this.pinkyArmL_1);
		this.pinkyLegR_1.addChild(this.pinkyLegR_2);
	}

	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.pinkyHead);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.pinkyBody, this.pinkyArmR, this.pinkyArmL, this.pinkyLegR, this.pinkyLegL);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.pinkyHead.rotateAngleX = 1.3418090809963408F;
		this.pinkyHornR.rotateAngleZ = -1.4161601444155547F;
		this.pinkyHornL.rotateAngleZ = 1.4161601444155547F;
		this.pinkyBody.rotateAngleX = -1.13376586611655F;

		this.pinkyArmR.rotateAngleX = MathHelper.cos(limbSwing) * -0.7819074915776542F * limbSwingAmount;
		this.pinkyArmL.rotateAngleX = MathHelper.cos(limbSwing + (float) Math.PI) * -0.7819074915776542F
				* limbSwingAmount;
		this.pinkyArmR.rotateAngleX = MathHelper.cos(limbSwing) * 0.4F * limbSwingAmount;
		this.pinkyArmL.rotateAngleX = MathHelper.cos(limbSwing) * 0.4F * limbSwingAmount;

		this.pinkyArmR.rotateAngleY = MathHelper.cos(limbSwing) * -0.7819074915776542F * limbSwingAmount;
		this.pinkyArmL.rotateAngleY = MathHelper.cos(limbSwing + (float) Math.PI) * -0.7819074915776542F
				* limbSwingAmount;
		this.pinkyArmR.rotateAngleY = MathHelper.cos(limbSwing) * 0.2F * limbSwingAmount;
		this.pinkyArmL.rotateAngleY = MathHelper.cos(limbSwing) * 0.2F * limbSwingAmount;

		this.pinkyLegR.rotateAngleX = MathHelper.cos(limbSwing) * 0.6F * limbSwingAmount;
		this.pinkyLegL.rotateAngleX = MathHelper.cos(limbSwing + (float) Math.PI) * 0.6F * limbSwingAmount;
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.pinkyHead, this.pinkyArmL, this.pinkyLegL, this.pinkyLegR, this.pinkyArmR, this.pinkyBody)
				.forEach((modelRenderer) -> {
					modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue,
							alpha);
				});
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}