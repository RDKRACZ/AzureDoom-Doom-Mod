package mod.azure.doomweapon.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SpiderdemonModel<T extends Entity> extends SegmentedModel<T> {
	public ModelRenderer spiderNeck;
	public ModelRenderer spiderLLegF;
	public ModelRenderer spiderRLegR;
	public ModelRenderer spiderLLegR;
	public ModelRenderer spiderRLegF;
	public ModelRenderer spiderLLegF_1;
	public ModelRenderer spiderRLegR_1;
	public ModelRenderer spiderLLegR_1;
	public ModelRenderer spiderRLegF_1;

	public SpiderdemonModel() {
		this.spiderLLegF_1 = new ModelRenderer(this, 18, 0);
		this.spiderLLegF_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.spiderLLegF_1.addBox(0.5F, -4.0F, -4.1F, 8.0F, 2.0F, 2.0F, 0.5F, 0.0F, -0.1F);
		this.setRotateAngle(spiderLLegF_1, 0.0F, 0.0F, 2.399827721492203F);
		this.spiderRLegR = new ModelRenderer(this, 18, 0);
		this.spiderRLegR.setRotationPoint(-4.0F, 15.0F, 2.0F);
		this.spiderRLegR.addBox(-4.0F, 1.4F, 1.0F, 8.0F, 2.0F, 2.0F, -1.8F, 0.0F, 0.0F);
		this.setRotateAngle(spiderRLegR, 0.0F, 0.0F, 0.8192575269176885F);
		this.spiderRLegF_1 = new ModelRenderer(this, 18, 0);
		this.spiderRLegF_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.spiderRLegF_1.addBox(-8.5F, -4.0F, -5.0F, 8.0F, 2.0F, 2.0F, 0.5F, 0.0F, -0.1F);
		this.setRotateAngle(spiderRLegF_1, 0.0F, 0.0F, -2.399827721492203F);
		this.spiderLLegR_1 = new ModelRenderer(this, 18, 0);
		this.spiderLLegR_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.spiderLLegR_1.addBox(0.5F, -4.0F, 2.1F, 8.0F, 2.0F, 2.0F, 0.5F, 0.0F, -0.1F);
		this.setRotateAngle(spiderLLegR_1, 0.0F, 0.0F, 2.399827721492203F);
		this.spiderLLegF = new ModelRenderer(this, 18, 0);
		this.spiderLLegF.setRotationPoint(4.0F, 15.0F, -1.0F);
		this.spiderLLegF.addBox(-4.0F, 1.4F, -4.1F, 8.0F, 2.0F, 2.0F, -1.8F, 0.0F, 0.0F);
		this.setRotateAngle(spiderLLegF, 0.0F, 0.0F, -0.8192575269176885F);
		this.spiderNeck = new ModelRenderer(this, 0, 12);
		this.spiderNeck.setRotationPoint(0.0F, 15.0F, 0.0F);
		this.spiderNeck.addBox(-5.0F, -4.2F, -6.0F, 10.0F, 8.0F, 12.0F, 0.0F, 0.0F, -0.7F);
		this.spiderRLegF = new ModelRenderer(this, 18, 0);
		this.spiderRLegF.setRotationPoint(-4.0F, 15.0F, 0.0F);
		this.spiderRLegF.addBox(-4.0F, 1.4F, -5.0F, 8.0F, 2.0F, 2.0F, -1.8F, 0.0F, 0.0F);
		this.setRotateAngle(spiderRLegF, 0.0F, 0.0F, 0.8192575269176885F);
		this.spiderLLegR = new ModelRenderer(this, 18, 0);
		this.spiderLLegR.setRotationPoint(4.0F, 15.0F, 1.0F);
		this.spiderLLegR.addBox(-4.0F, 1.4F, 2.1F, 8.0F, 2.0F, 2.0F, -1.8F, 0.0F, 0.0F);
		this.setRotateAngle(spiderLLegR, 0.0F, 0.0F, -0.8192575269176885F);
		this.spiderRLegR_1 = new ModelRenderer(this, 18, 0);
		this.spiderRLegR_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.spiderRLegR_1.addBox(-8.5F, -4.0F, 1.0F, 8.0F, 2.0F, 2.0F, 0.5F, 0.0F, -0.1F);
		this.setRotateAngle(spiderRLegR_1, 0.0F, 0.0F, -2.399827721492203F);
		this.spiderLLegF.addChild(this.spiderLLegF_1);
		this.spiderRLegF.addChild(this.spiderRLegF_1);
		this.spiderLLegR.addChild(this.spiderLLegR_1);
		this.spiderRLegR.addChild(this.spiderRLegR_1);
	}

	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.spiderNeck, this.spiderRLegR, this.spiderLLegR, this.spiderRLegF,
				this.spiderLLegF);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.spiderLLegF.rotateAngleX = MathHelper.cos(limbSwing) * 0.2F * limbSwingAmount;
		this.spiderLLegR.rotateAngleX = MathHelper.cos(limbSwing + (float) Math.PI) * 0.2F * limbSwingAmount;
		this.spiderRLegF.rotateAngleX = MathHelper.cos(limbSwing) * 0.2F * limbSwingAmount;
		this.spiderRLegR.rotateAngleX = MathHelper.cos(limbSwing + (float) Math.PI) * 0.2F * limbSwingAmount;
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}