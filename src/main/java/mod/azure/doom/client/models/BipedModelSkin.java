package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;

//Created by Marctron
public class BipedModelSkin<T extends LivingEntity> extends BipedModel<T> {

	public ModelRenderer HeadWear;
	public ModelRenderer LeftLeg;
	public ModelRenderer RightArm;
	public ModelRenderer LeftArmWear;
	public ModelRenderer Head;
	public ModelRenderer Body;
	public ModelRenderer field_78121_j;
	public ModelRenderer RightArmWear;
	public ModelRenderer RightLeg;
	public ModelRenderer LeftLegWear;
	public ModelRenderer BodyWear;
	public ModelRenderer RightLegWear;
	public ModelRenderer LeftArm;
	private float remainingItemUseTime;

	public BipedModelSkin(float modelSize, boolean smallArmsIn) {
		super(modelSize);
		textureWidth = 64;
		textureHeight = 64;
		HeadWear = new ModelRenderer(this).setTextureOffset(32, 0);
		HeadWear.setRotationPoint(0.0F, 0.0F, 0.0F);
		HeadWear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, modelSize + 0.26F);
		LeftLeg = new ModelRenderer(this).setTextureOffset(16, 48);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		LeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, modelSize + 0.01F);
		RightArm = new ModelRenderer(this).setTextureOffset(40, 16);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, modelSize + 0.01F);
		LeftArmWear = new ModelRenderer(this).setTextureOffset(48, 48);
		LeftArmWear.setRotationPoint(0.0F, 0.0F, 0.0F);
		LeftArmWear.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, modelSize + 0.26F);
		Head = new ModelRenderer(this).setTextureOffset(0, 0);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, modelSize + 0.01F);
		Body = new ModelRenderer(this).setTextureOffset(16, 16);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, modelSize + 0.01F);
		field_78121_j = new ModelRenderer(this).setTextureOffset(24, 0);
		field_78121_j.setRotationPoint(0.0F, 0.0F, 0.0F);
		field_78121_j.addBox(-3.0F, -6.01F, -1.0F, 6, 6, 1, modelSize + 0.01F);
		RightArmWear = new ModelRenderer(this).setTextureOffset(40, 32);
		RightArmWear.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightArmWear.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, modelSize + 0.26F);
		RightLeg = new ModelRenderer(this).setTextureOffset(0, 16);
		RightLeg.setRotationPoint(-1.899999976158142F, 12.0F, 0.0F);
		RightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, modelSize + 0.01F);
		LeftLegWear = new ModelRenderer(this).setTextureOffset(0, 48);
		LeftLegWear.setRotationPoint(0F, 0.0F, 0.0F);
		LeftLegWear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, modelSize + 0.26F);
		BodyWear = new ModelRenderer(this).setTextureOffset(16, 32);
		BodyWear.setRotationPoint(0.0F, 0.0F, 0.0F);
		BodyWear.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, modelSize + 0.26F);
		RightLegWear = new ModelRenderer(this).setTextureOffset(0, 32);
		RightLegWear.setRotationPoint(0.0F, 0.0F, 0.0F);
		RightLegWear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, modelSize + 0.26F);
		LeftArm = new ModelRenderer(this).setTextureOffset(32, 48);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, modelSize + 0.01F); 
		this.Head.addChild(HeadWear);
		this.Body.addChild(BodyWear);
		this.LeftArm.addChild(LeftArmWear);
		this.RightArm.addChild(RightArmWear);
		this.LeftLeg.addChild(LeftLegWear);
		this.RightLeg.addChild(RightLegWear);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.Body, this.RightArm, this.LeftArm, this.RightLeg, this.LeftLeg, this.Head);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setVisible(boolean visible) {
		this.bipedHead.showModel = false;
		this.bipedHeadwear.showModel = false;
		this.bipedBody.showModel = false;
		this.bipedRightArm.showModel = false;
		this.bipedLeftArm.showModel = false;
		this.bipedRightLeg.showModel = false;
		this.bipedLeftLeg.showModel = false;
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

		boolean flag = entityIn.getTicksElytraFlying() > 4;
		boolean flag1 = entityIn.isActualySwimming();
		this.Head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.bipedHead.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.bipedHeadwear.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.Head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.bipedHead.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.bipedHeadwear.rotateAngleX = headPitch * ((float) Math.PI / 180F);

		if (flag) {
			this.Head.rotateAngleX = (-(float) Math.PI / 4F);
		} else if (this.swimAnimation > 0.0F) {
			if (flag1) {
				this.Head.rotateAngleX = this.rotLerpRad(this.Head.rotateAngleX, (-(float) Math.PI / 4F),
						this.swimAnimation);
				this.bipedHead.rotateAngleX = this.rotLerpRad(this.Head.rotateAngleX, (-(float) Math.PI / 4F),
						this.swimAnimation);
				this.bipedHeadwear.rotateAngleX = this.rotLerpRad(this.Head.rotateAngleX, (-(float) Math.PI / 4F),
						this.swimAnimation);
			} else {
				this.Head.rotateAngleX = this.rotLerpRad(this.Head.rotateAngleX, headPitch * ((float) Math.PI / 180F),
						this.swimAnimation);
				this.bipedHead.rotateAngleX = this.rotLerpRad(this.Head.rotateAngleX,
						headPitch * ((float) Math.PI / 180F), this.swimAnimation);
				this.bipedHeadwear.rotateAngleX = this.rotLerpRad(this.Head.rotateAngleX,
						headPitch * ((float) Math.PI / 180F), this.swimAnimation);
			}
		} else {
			this.Head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		}

		this.Body.rotateAngleY = 0.0F;
		this.RightArm.rotationPointZ = 0.0F;
		this.RightArm.rotationPointX = -5.0F;
		this.LeftArm.rotationPointZ = 0.0F;
		this.LeftArm.rotationPointX = 5.0F;
		float f = 1.0F;
		if (flag) {
			f = (float) entityIn.getMotion().lengthSquared();
			f = f / 0.2F;
			f = f * f * f;
		}

		if (f < 1.0F) {
			f = 1.0F;
		}

		this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount
				* 0.5F / f;
		this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.RightArm.rotateAngleZ = 0.0F;
		this.LeftArm.rotateAngleZ = 0.0F;
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / f;
		this.RightLeg.rotateAngleY = 0.0F;
		this.LeftLeg.rotateAngleY = 0.0F;
		this.RightLeg.rotateAngleZ = 0.0F;
		this.LeftLeg.rotateAngleZ = 0.0F;
		if (this.isSitting) {
			this.RightArm.rotateAngleX += (-(float) Math.PI / 5F);
			this.LeftArm.rotateAngleX += (-(float) Math.PI / 5F);
			this.RightLeg.rotateAngleX = -1.4137167F;
			this.RightLeg.rotateAngleY = ((float) Math.PI / 10F);
			this.RightLeg.rotateAngleZ = 0.07853982F;
			this.LeftLeg.rotateAngleX = -1.4137167F;
			this.LeftLeg.rotateAngleY = (-(float) Math.PI / 10F);
			this.LeftLeg.rotateAngleZ = -0.07853982F;
		}

		this.RightArm.rotateAngleY = 0.0F;
		this.RightArm.rotateAngleZ = 0.0F;
		switch (this.leftArmPose) {
		case EMPTY:
			this.LeftArm.rotateAngleY = 0.0F;
			break;
		case BLOCK:
			this.LeftArm.rotateAngleX = this.LeftArm.rotateAngleX * 0.5F - 0.9424779F;
			this.LeftArm.rotateAngleY = ((float) Math.PI / 6F);
			break;
		case ITEM:
			this.LeftArm.rotateAngleX = this.LeftArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F);
			this.LeftArm.rotateAngleY = 0.0F;
		}

		switch (this.rightArmPose) {
		case EMPTY:
			this.RightArm.rotateAngleY = 0.0F;
			break;
		case BLOCK:
			this.RightArm.rotateAngleX = this.RightArm.rotateAngleX * 0.5F - 0.9424779F;
			this.RightArm.rotateAngleY = (-(float) Math.PI / 6F);
			break;
		case ITEM:
			this.RightArm.rotateAngleX = this.RightArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F);
			this.RightArm.rotateAngleY = 0.0F;
			break;
		case THROW_SPEAR:
			this.RightArm.rotateAngleX = this.RightArm.rotateAngleX * 0.5F - (float) Math.PI;
			this.RightArm.rotateAngleY = 0.0F;
		}

		if (this.leftArmPose == BipedModel.ArmPose.THROW_SPEAR && this.rightArmPose != BipedModel.ArmPose.BLOCK
				&& this.rightArmPose != BipedModel.ArmPose.THROW_SPEAR
				&& this.rightArmPose != BipedModel.ArmPose.BOW_AND_ARROW) {
			this.LeftArm.rotateAngleX = this.LeftArm.rotateAngleX * 0.5F - (float) Math.PI;
			this.LeftArm.rotateAngleY = 0.0F;
		}

		if (this.swingProgress > 0.0F) {
			HandSide handside = this.getMainHand(entityIn);
			ModelRenderer modelrenderer = this.getArmForSide(handside);
			float f1 = this.swingProgress;
			this.Body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float) Math.PI * 2F)) * 0.2F;
			if (handside == HandSide.LEFT) {
				this.Body.rotateAngleY *= -1.0F;
			}

			this.RightArm.rotationPointZ = MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.RightArm.rotationPointX = -MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.LeftArm.rotationPointZ = -MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.LeftArm.rotationPointX = MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.RightArm.rotateAngleY += this.Body.rotateAngleY;
			this.LeftArm.rotateAngleY += this.Body.rotateAngleY;
			this.LeftArm.rotateAngleX += this.Body.rotateAngleY;
			f1 = 1.0F - this.swingProgress;
			f1 = f1 * f1;
			f1 = f1 * f1;
			f1 = 1.0F - f1;
			float f2 = MathHelper.sin(f1 * (float) Math.PI);
			float f3 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.Head.rotateAngleX - 0.7F) * 0.75F;
			modelrenderer.rotateAngleX = (float) ((double) modelrenderer.rotateAngleX
					- ((double) f2 * 1.2D + (double) f3));
			modelrenderer.rotateAngleY += this.Body.rotateAngleY * 2.0F;
			modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F;
		}

		if (this.isSneak) {
			this.Body.rotateAngleX = 0.5F;
			this.RightArm.rotateAngleX += 0.4F;
			this.LeftArm.rotateAngleX += 0.4F;
			this.RightLeg.rotationPointZ = 4.0F;
			this.LeftLeg.rotationPointZ = 4.0F;
			this.RightLeg.rotationPointY = 12.2F;
			this.LeftLeg.rotationPointY = 12.2F;
			this.Head.rotationPointY = 4.2F;
			this.Body.rotationPointY = 3.2F;
			this.LeftArm.rotationPointY = 5.2F;
			this.RightArm.rotationPointY = 5.2F;
		} else {
			this.Body.rotateAngleX = 0.0F;
			this.RightLeg.rotationPointZ = 0.1F;
			this.LeftLeg.rotationPointZ = 0.1F;
			this.RightLeg.rotationPointY = 12.0F;
			this.LeftLeg.rotationPointY = 12.0F;
			this.Head.rotationPointY = 0.0F;
			this.Body.rotationPointY = 0.0F;
			this.LeftArm.rotationPointY = 2.0F;
			this.RightArm.rotationPointY = 2.0F;
		}

		this.RightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.LeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.RightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.LeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		if (this.rightArmPose == BipedModel.ArmPose.BOW_AND_ARROW) {
			this.RightArm.rotateAngleY = -0.1F + this.Head.rotateAngleY;
			this.LeftArm.rotateAngleY = 0.1F + this.Head.rotateAngleY + 0.4F;
			this.RightArm.rotateAngleX = (-(float) Math.PI / 2F) + this.Head.rotateAngleX;
			this.LeftArm.rotateAngleX = (-(float) Math.PI / 2F) + this.Head.rotateAngleX;
		} else if (this.leftArmPose == BipedModel.ArmPose.BOW_AND_ARROW
				&& this.rightArmPose != BipedModel.ArmPose.THROW_SPEAR
				&& this.rightArmPose != BipedModel.ArmPose.BLOCK) {
			this.RightArm.rotateAngleY = -0.1F + this.Head.rotateAngleY - 0.4F;
			this.LeftArm.rotateAngleY = 0.1F + this.Head.rotateAngleY;
			this.RightArm.rotateAngleX = (-(float) Math.PI / 2F) + this.Head.rotateAngleX;
			this.LeftArm.rotateAngleX = (-(float) Math.PI / 2F) + this.Head.rotateAngleX;
		}

		if (this.rightArmPose == BipedModel.ArmPose.CROSSBOW_HOLD && this.swingProgress <= 0.0F) {
			this.RightArm.rotateAngleY = -0.3F + this.Head.rotateAngleY;
			this.LeftArm.rotateAngleY = 0.6F + this.Head.rotateAngleY;
			this.RightArm.rotateAngleX = (-(float) Math.PI / 2F) + this.Head.rotateAngleX + 0.1F;
			this.LeftArm.rotateAngleX = -1.5F + this.Head.rotateAngleX;
		} else if (this.leftArmPose == BipedModel.ArmPose.CROSSBOW_HOLD) {
			this.RightArm.rotateAngleY = -0.6F + this.Head.rotateAngleY;
			this.LeftArm.rotateAngleY = 0.3F + this.Head.rotateAngleY;
			this.RightArm.rotateAngleX = -1.5F + this.Head.rotateAngleX;
			this.LeftArm.rotateAngleX = (-(float) Math.PI / 2F) + this.Head.rotateAngleX + 0.1F;
		}

		if (this.swimAnimation > 0.0F) {
			float f7 = limbSwing % 26.0F;
			float f8 = this.swingProgress > 0.0F ? 0.0F : this.swimAnimation;
			if (f7 < 14.0F) {
				this.LeftArm.rotateAngleX = this.rotLerpRad(this.LeftArm.rotateAngleX, 0.0F, this.swimAnimation);
				this.RightArm.rotateAngleX = MathHelper.lerp(f8, this.RightArm.rotateAngleX, 0.0F);
				this.LeftArm.rotateAngleY = this.rotLerpRad(this.LeftArm.rotateAngleY, (float) Math.PI,
						this.swimAnimation);
				this.RightArm.rotateAngleY = MathHelper.lerp(f8, this.RightArm.rotateAngleY, (float) Math.PI);
				this.LeftArm.rotateAngleZ = this.rotLerpRad(this.LeftArm.rotateAngleZ,
						(float) Math.PI + 1.8707964F * this.getArmAngleSq(f7) / this.getArmAngleSq(14.0F),
						this.swimAnimation);
				this.RightArm.rotateAngleZ = MathHelper.lerp(f8, this.RightArm.rotateAngleZ,
						(float) Math.PI - 1.8707964F * this.getArmAngleSq(f7) / this.getArmAngleSq(14.0F));
			} else if (f7 >= 14.0F && f7 < 22.0F) {
				float f10 = (f7 - 14.0F) / 8.0F;
				this.LeftArm.rotateAngleX = this.rotLerpRad(this.LeftArm.rotateAngleX, ((float) Math.PI / 2F) * f10,
						this.swimAnimation);
				this.RightArm.rotateAngleX = MathHelper.lerp(f8, this.RightArm.rotateAngleX,
						((float) Math.PI / 2F) * f10);
				this.LeftArm.rotateAngleY = this.rotLerpRad(this.LeftArm.rotateAngleY, (float) Math.PI,
						this.swimAnimation);
				this.RightArm.rotateAngleY = MathHelper.lerp(f8, this.RightArm.rotateAngleY, (float) Math.PI);
				this.LeftArm.rotateAngleZ = this.rotLerpRad(this.LeftArm.rotateAngleZ, 5.012389F - 1.8707964F * f10,
						this.swimAnimation);
				this.RightArm.rotateAngleZ = MathHelper.lerp(f8, this.RightArm.rotateAngleZ,
						1.2707963F + 1.8707964F * f10);
			} else if (f7 >= 22.0F && f7 < 26.0F) {
				float f9 = (f7 - 22.0F) / 4.0F;
				this.LeftArm.rotateAngleX = this.rotLerpRad(this.LeftArm.rotateAngleX,
						((float) Math.PI / 2F) - ((float) Math.PI / 2F) * f9, this.swimAnimation);
				this.RightArm.rotateAngleX = MathHelper.lerp(f8, this.RightArm.rotateAngleX,
						((float) Math.PI / 2F) - ((float) Math.PI / 2F) * f9);
				this.LeftArm.rotateAngleY = this.rotLerpRad(this.LeftArm.rotateAngleY, (float) Math.PI,
						this.swimAnimation);
				this.RightArm.rotateAngleY = MathHelper.lerp(f8, this.RightArm.rotateAngleY, (float) Math.PI);
				this.LeftArm.rotateAngleZ = this.rotLerpRad(this.LeftArm.rotateAngleZ, (float) Math.PI,
						this.swimAnimation);
				this.RightArm.rotateAngleZ = MathHelper.lerp(f8, this.RightArm.rotateAngleZ, (float) Math.PI);
			}

			@SuppressWarnings("unused")
			float f11 = 0.3F;
			@SuppressWarnings("unused")
			float f12 = 0.33333334F;
			this.LeftLeg.rotateAngleX = MathHelper.lerp(this.swimAnimation, this.LeftLeg.rotateAngleX,
					0.3F * MathHelper.cos(limbSwing * 0.33333334F + (float) Math.PI));
			this.RightLeg.rotateAngleX = MathHelper.lerp(this.swimAnimation, this.RightLeg.rotateAngleX,
					0.3F * MathHelper.cos(limbSwing * 0.33333334F));
		}

		if (entityIn instanceof ArmorStandEntity) {
			netHeadYaw = 0;
			ArmorStandEntity entityarmorstand = (ArmorStandEntity) entityIn;
			this.Head.rotateAngleX = 0.0F * entityarmorstand.getHeadRotation().getX();
			this.Head.rotateAngleX = 0.0F * entityarmorstand.getHeadRotation().getY();
			this.Head.rotateAngleX = 0.0F * entityarmorstand.getHeadRotation().getZ();

			this.LeftArm.rotateAngleX = 0.0F * entityarmorstand.getLeftArmRotation().getX();
			this.LeftArm.rotateAngleY = 0.0F * entityarmorstand.getLeftArmRotation().getY();
			this.LeftArm.rotateAngleZ = 0.0F * entityarmorstand.getLeftArmRotation().getZ();

			this.RightArm.rotateAngleX = 0.0F * entityarmorstand.getRightArmRotation().getX();
			this.RightArm.rotateAngleY = 0.0F * entityarmorstand.getRightArmRotation().getY();
			this.RightArm.rotateAngleZ = 0.0F * entityarmorstand.getRightArmRotation().getZ();

			this.bipedLeftLeg.rotateAngleX = 0.017453292F * entityarmorstand.getLeftLegRotation().getX();
			this.bipedLeftLeg.rotateAngleY = 0.017453292F * entityarmorstand.getLeftLegRotation().getY();
			this.bipedLeftLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftLegRotation().getZ();
			this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);

			this.bipedRightLeg.rotateAngleX = 0.017453292F * entityarmorstand.getRightLegRotation().getX();
			this.bipedRightLeg.rotateAngleY = 0.017453292F * entityarmorstand.getRightLegRotation().getY();
			this.bipedRightLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getRightLegRotation().getZ();
			this.bipedRightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);

		}

		float f4 = (float) CrossbowItem.getChargeTime(entityIn.getActiveItemStack());
		if (this.rightArmPose == BipedModel.ArmPose.CROSSBOW_CHARGE) {
			this.RightArm.rotateAngleY = -0.8F;
			this.RightArm.rotateAngleX = -0.97079635F;
			this.LeftArm.rotateAngleX = -0.97079635F;
			float f5 = MathHelper.clamp(this.remainingItemUseTime, 0.0F, f4);
			this.LeftArm.rotateAngleY = MathHelper.lerp(f5 / f4, 0.4F, 0.85F);
			this.LeftArm.rotateAngleX = MathHelper.lerp(f5 / f4, this.LeftArm.rotateAngleX, (-(float) Math.PI / 2F));
		} else if (this.leftArmPose == BipedModel.ArmPose.CROSSBOW_CHARGE) {
			this.LeftArm.rotateAngleY = 0.8F;
			this.RightArm.rotateAngleX = -0.97079635F;
			this.LeftArm.rotateAngleX = -0.97079635F;
			float f6 = MathHelper.clamp(this.remainingItemUseTime, 0.0F, f4);
			this.RightArm.rotateAngleY = MathHelper.lerp(f6 / f4, -0.4F, -0.85F);
			this.RightArm.rotateAngleX = MathHelper.lerp(f6 / f4, this.RightArm.rotateAngleX, (-(float) Math.PI / 2F));
		}

		bipedHead.rotationPointY = Head.rotationPointY;
		bipedHead.showModel = false;
		bipedBody.showModel = false;
		bipedLeftArm.showModel = false;
		bipedRightArm.showModel = false;
		bipedLeftLeg.showModel = false;
		bipedRightLeg.showModel = false;

	}

	public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		this.swimAnimation = entityIn.getSwimAnimation(partialTick);
		this.remainingItemUseTime = (float) entityIn.getItemInUseMaxCount();
		super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);
	}

	private float getArmAngleSq(float limbSwing) {
		return -65.0F * limbSwing + limbSwing * limbSwing;
	}

	protected ModelRenderer getArmForSide(HandSide side) {
		return side == HandSide.LEFT ? this.LeftArm : this.RightArm;
	}
}