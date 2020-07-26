package mod.azure.doomweapon.client.models;

import com.google.common.collect.ImmutableList;

import mod.azure.doomweapon.entity.SpiderdemonEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class SpiderdemonModel<T extends SpiderdemonEntity> extends SegmentedModel<T> {
	private final ModelRenderer spiderNeck;
	private final ModelRenderer spiderRLegR;
	private final ModelRenderer spiderLLegR;
	private final ModelRenderer spiderRLegF;
	private final ModelRenderer spiderLLegF;

	public SpiderdemonModel() {
		this.spiderNeck = new ModelRenderer(this, 0, 12);
		this.spiderNeck.addBox(-5.0F, -6.0F, -6.0F, 10.0F, 8.0F, 12.0F, 0.0F);
		this.spiderNeck.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.spiderRLegR = new ModelRenderer(this, 18, 0);
		this.spiderRLegR.addBox(-9.0F, -0.9F, 1.5F, 8.0F, 2.0F, 2.0F, 0.0F);
		this.spiderRLegR.setRotationPoint(-4.0F, 15.0F, 2.0F);
		this.spiderLLegR = new ModelRenderer(this, 18, 0);
		this.spiderLLegR.addBox(1.0F, -0.9F, 2.2F, 8.0F, 2.0F, 2.0F, 0.0F);
		this.spiderLLegR.setRotationPoint(4.0F, 15.0F, 1.0F);
		this.spiderRLegF = new ModelRenderer(this, 18, 0);
		this.spiderRLegF.addBox(-9.0F, -0.9F, -5.0F, 8.0F, 2.0F, 2.0F, 0.0F);
		this.spiderRLegF.setRotationPoint(-4.0F, 15.0F, 0.0F);
		this.spiderLLegF = new ModelRenderer(this, 18, 0);
		this.spiderLLegF.addBox(1.0F, -0.9F, -3.0F, 8.0F, 2.0F, 2.0F, 0.0F);
		this.spiderLLegF.setRotationPoint(4.0F, 15.0F, -1.0F);
	}

	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.spiderNeck, this.spiderRLegR, this.spiderLLegR, this.spiderRLegF,
				this.spiderLLegF);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.spiderRLegR.rotateAngleZ = -1.58119464F;
		this.spiderLLegR.rotateAngleZ = 1.58119464F;
		this.spiderRLegF.rotateAngleZ = -1.58119464F;
		this.spiderLLegF.rotateAngleZ = 1.58119464F;
		this.spiderRLegR.rotateAngleY = 0.0F;
		this.spiderLLegR.rotateAngleY = 0.0F;
		this.spiderRLegF.rotateAngleY = 0.0F;
		this.spiderLLegF.rotateAngleY = 0.0F;
		float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
		float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * limbSwingAmount;
		float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
		float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
		float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
		float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float) Math.PI) * 0.4F) * limbSwingAmount;
		float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
		float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
		this.spiderRLegR.rotateAngleY += f3;
		this.spiderLLegR.rotateAngleY += -f4;
		this.spiderRLegF.rotateAngleY += f5;
		this.spiderLLegF.rotateAngleY += -f6;
		this.spiderRLegR.rotateAngleZ += f7;
		this.spiderLLegR.rotateAngleZ += -f8;
		this.spiderRLegF.rotateAngleZ += f9;
		this.spiderLLegF.rotateAngleZ += -f10;
	}
}