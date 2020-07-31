package mod.azure.doomweapon.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class PinkyModel<T extends Entity> extends EntityModel<T> {
	public ModelRenderer pinkyLegL;
	public ModelRenderer pinkyArmL;
	public ModelRenderer pinkyLegR;
	public ModelRenderer pinkyBody;
	public ModelRenderer pinkyArmR;
	public ModelRenderer pinkyHead;
	public ModelRenderer pinkyHornR;
	public ModelRenderer pinkyHornL;

	public PinkyModel() {
		this.textureWidth = 128;
        this.textureHeight = 64;
        this.pinkyLegR = new ModelRenderer(this, 21, 45);
        this.pinkyLegR.setRotationPoint(-5.0F, 13.0F, 10.0F);
        this.pinkyLegR.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 11.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.pinkyBody = new ModelRenderer(this, 1, 1);
        this.pinkyBody.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.pinkyBody.addBox(-7.9F, -11.0F, -15.5F, 16.0F, 14.0F, 26.0F, 0.0F, 0.0F, 0.0F);
        this.pinkyHornL = new ModelRenderer(this, 1, 13);
        this.pinkyHornL.setRotationPoint(7.0F, 2.0F, -12.0F);
        this.pinkyHornL.addBox(-2.8F, -8.7F, 15.1F, 2.0F, 11.0F, 2.0F, 0.0F, -2.4F, 0.0F);
        this.pinkyHornR = new ModelRenderer(this, 10, 13);
        this.pinkyHornR.setRotationPoint(-7.0F, 2.0F, -12.0F);
        this.pinkyHornR.addBox(1.2F, -8.6F, 15.1F, 2.0F, 11.0F, 2.0F, 0.0F, -2.4F, 0.0F);
        this.pinkyLegL = new ModelRenderer(this, 0, 45);
        this.pinkyLegL.setRotationPoint(5.0F, 13.0F, 10.0F);
        this.pinkyLegL.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 11.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.pinkyArmL = new ModelRenderer(this, 41, 42);
        this.pinkyArmL.setRotationPoint(4.0F, 10.0F, -8.5F);
        this.pinkyArmL.addBox(4.0F, -12.0F, 2.1F, 6.0F, 14.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.pinkyArmR = new ModelRenderer(this, 66, 42);
        this.pinkyArmR.setRotationPoint(-4.0F, 10.0F, -8.5F);
        this.pinkyArmR.addBox(-10.0F, -12.0F, 2.1F, 6.0F, 14.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.pinkyHead = new ModelRenderer(this, 61, 1);
        this.pinkyHead.setRotationPoint(0.0F, 2.0F, -12.0F);
        this.pinkyHead.addBox(-7.0F, -2.8F, -10.3F, 14.0F, 6.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.pinkyHead.addChild(this.pinkyHornL);
        this.pinkyHead.addChild(this.pinkyHornR);
	}

	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.pinkyHead);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.pinkyBody, this.pinkyArmR, this.pinkyArmL, this.pinkyLegR, this.pinkyLegL);
	}

	/**
	 * Sets this entity's model rotation angles
	 */
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.pinkyHead.rotateAngleX = 1.3418090809963408F;
		this.pinkyHornR.rotateAngleZ = -1.4161601444155547F;
		this.pinkyHornL.rotateAngleZ = 1.4161601444155547F;
		this.pinkyBody.rotateAngleX = -1.13376586611655F;
		this.pinkyArmR.rotateAngleX = MathHelper.cos(limbSwing) * -0.7819074915776542F* limbSwingAmount;
		this.pinkyArmL.rotateAngleX = MathHelper.cos(limbSwing + (float)Math.PI) * -0.7819074915776542F * limbSwingAmount;
		this.pinkyArmR.rotateAngleX = MathHelper.cos(limbSwing) * 0.2F * limbSwingAmount;
		this.pinkyArmL.rotateAngleX = MathHelper.cos(limbSwing) * 0.2F * limbSwingAmount;
		this.pinkyLegR.rotateAngleX = MathHelper.cos(limbSwing) * 0.2F * limbSwingAmount;
		this.pinkyLegL.rotateAngleX = MathHelper.cos(limbSwing + (float) Math.PI) * 0.2F * limbSwingAmount;
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.pinkyArmL, this.pinkyBody, this.pinkyLegR, this.pinkyArmR, this.pinkyLegL, this.pinkyHead)
				.forEach((modelRenderer) -> {
					modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue,
							alpha);
				});
	}
}