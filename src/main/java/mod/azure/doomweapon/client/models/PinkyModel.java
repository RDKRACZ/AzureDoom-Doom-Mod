package mod.azure.doomweapon.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.IFlinging;
import net.minecraft.util.math.MathHelper;

public class PinkyModel<T extends MobEntity & IFlinging> extends AgeableModel<T> {
	private final ModelRenderer pinkyHead;
	private final ModelRenderer pinkyBody;
	private final ModelRenderer pinkyArmR;
	private final ModelRenderer pinkyArmL;
	private final ModelRenderer pinkyLegR;
	private final ModelRenderer pinkyLegL;

	public PinkyModel() {
		super(true, 8.0F, 6.0F, 1.9F, 2.0F, 24.0F);
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.pinkyBody = new ModelRenderer(this);
		this.pinkyBody.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.pinkyBody.setTextureOffset(1, 1).addBox(-8.0F, -7.0F, -20.0F, 16.0F, 14.0F, 26.0F);
		this.pinkyHead = new ModelRenderer(this);
		this.pinkyHead.setRotationPoint(0.0F, 2.0F, -12.0F);
		this.pinkyHead.setTextureOffset(61, 1).addBox(-7.0F, 5.5F, 14.5F, 14.0F, 6.0F, 19.0F);
		this.pinkyHead.rotateAngleX = 0.87266463F;
		this.pinkyArmR = new ModelRenderer(this);
		this.pinkyArmR.setRotationPoint(-4.0F, 10.0F, -8.5F);
		this.pinkyArmR.setTextureOffset(66, 42).addBox(-10.0F, -22.0F, 5.0F, 6.0F, 14.0F, 6.0F);
		this.pinkyArmL = new ModelRenderer(this);
		this.pinkyArmL.setRotationPoint(4.0F, 10.0F, -8.5F);
		this.pinkyArmL.setTextureOffset(41, 42).addBox(4.0F, -22.0F, 5.0F, 6.0F, 14.0F, 6.0F);
		this.pinkyLegR = new ModelRenderer(this);
		this.pinkyLegR.setRotationPoint(-5.0F, 13.0F, 10.0F);
		this.pinkyLegR.setTextureOffset(21, 45).addBox(-2.5F, 0.0F, -10.5F, 5.0F, 11.0F, 5.0F);
		this.pinkyLegL = new ModelRenderer(this);
		this.pinkyLegL.setRotationPoint(5.0F, 13.0F, 10.0F);
		this.pinkyLegL.setTextureOffset(0, 45).addBox(-2.5F, 0.0F, -10.5F, 5.0F, 11.0F, 5.0F);
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
		this.pinkyBody.rotateAngleX = 80.15F;
		this.pinkyHead.rotateAngleX = 70.73F;
		this.pinkyHead.rotateAngleY = 0.0F;
		this.pinkyArmR.rotateAngleZ = 0.0F;
		this.pinkyArmR.rotateAngleX = MathHelper.cos(limbSwing) * 0.2F * limbSwingAmount;
		this.pinkyArmL.rotateAngleZ = 0.0F;
		this.pinkyArmL.rotateAngleX = MathHelper.cos(limbSwing) * 0.2F * limbSwingAmount;
		this.pinkyLegR.rotateAngleX = MathHelper.cos(limbSwing) * 0.2F * limbSwingAmount;
		this.pinkyLegL.rotateAngleX = MathHelper.cos(limbSwing + (float) Math.PI) * 0.2F * limbSwingAmount;
	}
}