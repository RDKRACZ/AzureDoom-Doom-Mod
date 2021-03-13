package mod.azure.doom.client.models;

import java.util.List;
import java.util.Random;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.mojang.blaze3d.matrix.MatrixStack;

import mod.azure.doom.entity.Cyberdemon2016Entity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.HandSide;

public class Cyberdemon2016Model<T extends Cyberdemon2016Entity> extends BipedModel<T> {
	private List<ModelRenderer> modelRenderers = Lists.newArrayList();
	public final ModelRenderer bipedLeftArmwear;
	public final ModelRenderer bipedRightArmwear;
	public final ModelRenderer bipedLeftLegwear;
	public final ModelRenderer bipedRightLegwear;
	public final ModelRenderer bipedBodyWear;
	public final ModelRenderer hornLeft;
	public final ModelRenderer hornLeft_1;
	public final ModelRenderer hornLeft_2;
	public final ModelRenderer hornRight;
	public final ModelRenderer hornRight_1;

	public Cyberdemon2016Model(float modelSize, boolean smallArmsIn) {
		super(RenderType::entityTranslucent, modelSize, 0.0F, 64, 64);
		this.leftArm = new ModelRenderer(this, 32, 48);
		this.leftArm.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);
		this.leftArm.setPos(5.0F, 2.0F, 0.0F);
		this.bipedLeftArmwear = new ModelRenderer(this, 48, 48);
		this.bipedLeftArmwear.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.25F);
		this.bipedLeftArmwear.setPos(5.0F, 2.0F, 0.0F);
		this.bipedRightArmwear = new ModelRenderer(this, 40, 32);
		this.bipedRightArmwear.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.25F);
		this.bipedRightArmwear.setPos(-5.0F, 2.0F, 10.0F);
		this.leftLeg = new ModelRenderer(this, 16, 48);
		this.leftLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);
		this.leftLeg.setPos(1.9F, 12.0F, 0.0F);
		this.bipedLeftLegwear = new ModelRenderer(this, 0, 48);
		this.bipedLeftLegwear.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.25F);
		this.bipedLeftLegwear.setPos(1.9F, 12.0F, 0.0F);
		this.bipedRightLegwear = new ModelRenderer(this, 0, 32);
		this.bipedRightLegwear.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.25F);
		this.bipedRightLegwear.setPos(-1.9F, 12.0F, 0.0F);
		this.bipedBodyWear = new ModelRenderer(this, 16, 32);
		this.bipedBodyWear.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, modelSize + 0.25F);
		this.bipedBodyWear.setPos(0.0F, 0.0F, 0.0F);
		this.hornLeft_2 = new ModelRenderer(this, 40, 2);
		this.hornLeft_2.setPos(0.0F, 0.0F, 0.0F);
		this.hornLeft_2.addBox(3.1F, -9.0F, 9.0F, 0.5F, 0.6F, 0.5F, 1.0F, 1.0F, 1.0F);
		this.hornLeft_1 = new ModelRenderer(this, 40, 2);
		this.hornLeft_1.setPos(0.0F, 0.0F, 0.0F);
		this.hornLeft_1.addBox(3.1F, -8.0F, 6.5F, 0.5F, 0.6F, 0.5F, 1.0F, 2.0F, 1.0F);
		this.hornLeft = new ModelRenderer(this, 40, 2);
		this.hornLeft.setPos(0.0F, 0.0F, 0.0F);
		this.hornLeft.addBox(3.1F, -4.7F, 6.5F, 0.5F, 0.6F, 0.5F, 0.8F, 1.0F, 0.8F);
		this.setRotateAngle(hornLeft, 1.3484414173750743F, 1.5707963267948966F, 0.0F);
		this.hornRight = new ModelRenderer(this, 40, 2);
		this.hornRight.setPos(0.0F, 0.0F, 0.0F);
		this.hornRight.addBox(-3.6F, -4.7F, 6.5F, 0.5F, 0.6F, 0.5F, 0.8F, 1.0F, 0.8F);
		this.setRotateAngle(hornRight, 1.3484414173750743F, -1.5707963267948966F, 0.0F);
		this.hornRight_1 = new ModelRenderer(this, 40, 2);
		this.hornRight_1.setPos(0.0F, 0.0F, 0.0F);
		this.hornRight_1.addBox(-3.6F, -8.0F, 6.5F, 0.5F, 0.6F, 0.5F, 0.7F, 2.0F, 0.8F);
		this.head.addChild(this.hornRight);
		this.hornLeft_1.addChild(this.hornLeft_2);
		this.hornLeft.addChild(this.hornLeft_1);
		this.head.addChild(this.hornLeft);
		this.hornRight.addChild(this.hornRight_1);
	}

	protected Iterable<ModelRenderer> bodyParts() {
		return Iterables.concat(super.bodyParts(), ImmutableList.of(this.bipedLeftLegwear, this.bipedRightLegwear,
				this.bipedLeftArmwear, this.bipedRightArmwear, this.bipedBodyWear));
	}

	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		super.setupAnim(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		this.bipedLeftLegwear.copyFrom(this.leftLeg);
		this.bipedRightLegwear.copyFrom(this.rightLeg);
		this.bipedLeftArmwear.copyFrom(this.leftArm);
		this.bipedRightArmwear.copyFrom(this.rightArm);
		this.bipedBodyWear.copyFrom(this.body);
	}

	public void setAllVisible(boolean visible) {
		super.setAllVisible(visible);
		this.bipedLeftArmwear.visible = visible;
		this.bipedRightArmwear.visible = visible;
		this.bipedLeftLegwear.visible = visible;
		this.bipedRightLegwear.visible = visible;
		this.bipedBodyWear.visible = visible;
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void translateToHand(HandSide sideIn, MatrixStack matrixStackIn) {
		ModelRenderer modelrenderer = this.getArm(sideIn);
		modelrenderer.translateAndRotate(matrixStackIn);
	}

	public ModelRenderer getRandomModelRenderer(Random randomIn) {
		return this.modelRenderers.get(randomIn.nextInt(this.modelRenderers.size()));
	}

	public void accept(ModelRenderer p_accept_1_) {
		if (this.modelRenderers == null) {
			this.modelRenderers = Lists.newArrayList();
		}

		this.modelRenderers.add(p_accept_1_);
	}

	public boolean isAggressive(T entityIn) {
		return entityIn.isAggressive();
	}
}