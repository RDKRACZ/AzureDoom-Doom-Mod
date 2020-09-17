package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ImpNightmare - Batpixxler Created using Tabula 8.0.0
 */
public class ImpNightmareModel<T extends Entity> extends EntityModel<T> {

	public ModelRenderer thighs;
    public ModelRenderer torso;
    public ModelRenderer rLeg1;
    public ModelRenderer lLeg1;
    public ModelRenderer neck;
    public ModelRenderer rShoulder;
    public ModelRenderer lShoulder;
    public ModelRenderer backSpike1;
    public ModelRenderer backSpike2;
    public ModelRenderer rightPec;
    public ModelRenderer leftPec;
    public ModelRenderer head;
    public ModelRenderer chin;
    public ModelRenderer browMiddle;
    public ModelRenderer lBrow1;
    public ModelRenderer rBrow1;
    public ModelRenderer lBrow2;
    public ModelRenderer rBrow2;
    public ModelRenderer rArm1;
    public ModelRenderer rArm2;
    public ModelRenderer lArm1;
    public ModelRenderer lArm2;
    public ModelRenderer rLeg2;
    public ModelRenderer lLeg2;

	public ImpNightmareModel(float modelSize, boolean smallArmsIn) {
		this.textureWidth = 60;
        this.textureHeight = 80;
        this.rLeg2 = new ModelRenderer(this, 16, 21);
        this.rLeg2.mirror = true;
        this.rLeg2.setRotationPoint(0.0F, 6.8F, -2.0F);
        this.rLeg2.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg2, 0.0911061832922575F, 0.0F, -0.04555309164612875F);
        this.chin = new ModelRenderer(this, 21, 52);
        this.chin.setRotationPoint(0.0F, -0.1F, -4.0F);
        this.chin.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(chin, 0.13665927909957545F, 0.0F, 0.0F);
        this.rBrow1 = new ModelRenderer(this, 0, 58);
        this.rBrow1.setRotationPoint(-0.4F, 0.3F, 0.0F);
        this.rBrow1.addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rBrow1, 0.0F, 0.0F, 0.7285004590772052F);
        this.torso = new ModelRenderer(this, 0, 0);
        this.torso.setRotationPoint(0.0F, 0.0F, 1.3F);
        this.torso.addBox(-5.0F, -7.0F, -4.0F, 10.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.rArm2 = new ModelRenderer(this, 16, 41);
        this.rArm2.mirror = true;
        this.rArm2.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.rArm2.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 7.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rArm2, -0.13665927909957545F, 0.0F, 0.0F);
        this.backSpike2 = new ModelRenderer(this, 30, 5);
        this.backSpike2.setRotationPoint(-3.3F, -5.0F, 0.0F);
        this.backSpike2.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(backSpike2, 0.956091342937205F, 0.0F, -0.500909508638178F);
        this.neck = new ModelRenderer(this, 0, 49);
        this.neck.setRotationPoint(0.0F, -7.0F, 1.0F);
        this.neck.addBox(-2.5F, -4.0F, -5.0F, 5.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(neck, 0.27314402127920984F, 0.0F, 0.0F);
        this.lShoulder = new ModelRenderer(this, 16, 32);
        this.lShoulder.setRotationPoint(4.0F, -6.0F, -1.9F);
        this.lShoulder.addBox(-1.0F, -2.0F, -2.0F, 5.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lShoulder, 0.0F, 0.0F, -0.13665927909957545F);
        this.lArm2 = new ModelRenderer(this, 16, 41);
        this.lArm2.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.lArm2.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 7.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lArm2, -0.13665927909957545F, 0.0F, 0.0F);
        this.rShoulder = new ModelRenderer(this, 16, 32);
        this.rShoulder.mirror = true;
        this.rShoulder.setRotationPoint(-4.0F, -6.0F, -1.9F);
        this.rShoulder.addBox(-4.0F, -2.0F, -2.0F, 5.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rShoulder, 0.0F, 0.0F, 0.13665927909957545F);
        this.lLeg2 = new ModelRenderer(this, 16, 21);
        this.lLeg2.setRotationPoint(0.0F, 6.8F, -2.0F);
        this.lLeg2.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg2, 0.0911061832922575F, 0.0F, 0.04555309164612875F);
        this.rBrow2 = new ModelRenderer(this, 0, 58);
        this.rBrow2.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.rBrow2.addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rBrow2, 0.0F, 0.0F, -1.092750655326294F);
        this.browMiddle = new ModelRenderer(this, 0, 58);
        this.browMiddle.setRotationPoint(0.0F, -2.4F, -4.5F);
        this.browMiddle.addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.lBrow1 = new ModelRenderer(this, 0, 58);
        this.lBrow1.setRotationPoint(0.4F, 0.3F, 0.0F);
        this.lBrow1.addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lBrow1, 0.0F, 0.0F, -0.7285004590772052F);
        this.rArm1 = new ModelRenderer(this, 0, 40);
        this.rArm1.mirror = true;
        this.rArm1.setRotationPoint(-1.5F, 2.0F, 0.5F);
        this.rArm1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.backSpike1 = new ModelRenderer(this, 30, 5);
        this.backSpike1.setRotationPoint(2.3F, -5.5F, 0.0F);
        this.backSpike1.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(backSpike1, 0.956091342937205F, 0.0F, 0.500909508638178F);
        this.rLeg1 = new ModelRenderer(this, 0, 21);
        this.rLeg1.mirror = true;
        this.rLeg1.setRotationPoint(-1.9F, 5.0F, 0.0F);
        this.rLeg1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg1, -0.04555309164612875F, 0.0F, 0.04555309164612875F);
        this.lArm1 = new ModelRenderer(this, 0, 40);
        this.lArm1.setRotationPoint(1.5F, 2.0F, 0.5F);
        this.lArm1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.lLeg1 = new ModelRenderer(this, 0, 21);
        this.lLeg1.setRotationPoint(1.9F, 5.0F, 0.0F);
        this.lLeg1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg1, -0.04555309164612875F, 0.0F, -0.04555309164612875F);
        this.lBrow2 = new ModelRenderer(this, 0, 58);
        this.lBrow2.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.lBrow2.addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lBrow2, 0.0F, 0.0F, 1.092750655326294F);
        this.thighs = new ModelRenderer(this, 0, 12);
        this.thighs.setRotationPoint(0.0F, 5.5F, 0.0F);
        this.thighs.addBox(-3.5F, 0.0F, -2.0F, 7.0F, 5.0F, 4.0F, 0.25F, 0.25F, 0.25F);
        this.rightPec = new ModelRenderer(this, 0, 32);
        this.rightPec.setRotationPoint(-2.7F, -5.3F, -2.0F);
        this.rightPec.addBox(-2.5F, -2.5F, -3.0F, 5.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rightPec, 0.0F, 0.0F, -0.08726646259971647F);
        this.leftPec = new ModelRenderer(this, 0, 32);
        this.leftPec.setRotationPoint(2.7F, -5.3F, -2.0F);
        this.leftPec.addBox(-2.5F, -2.5F, -3.0F, 5.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leftPec, 0.0F, 0.0F, 0.08726646259971647F);
        this.head = new ModelRenderer(this, 0, 58);
        this.head.setRotationPoint(0.0F, -3.0F, -2.7F);
        this.head.addBox(-3.5F, -5.0F, -4.0F, 7.0F, 5.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(head, -0.0911061832922575F, 0.0F, 0.0F);
        this.rLeg1.addChild(this.rLeg2);
        this.head.addChild(this.chin);
        this.browMiddle.addChild(this.rBrow1);
        this.thighs.addChild(this.torso);
        this.rArm1.addChild(this.rArm2);
        this.torso.addChild(this.backSpike2);
        this.torso.addChild(this.neck);
        this.torso.addChild(this.lShoulder);
        this.lArm1.addChild(this.lArm2);
        this.torso.addChild(this.rShoulder);
        this.lLeg1.addChild(this.lLeg2);
        this.rBrow1.addChild(this.rBrow2);
        this.head.addChild(this.browMiddle);
        this.browMiddle.addChild(this.lBrow1);
        this.rShoulder.addChild(this.rArm1);
        this.torso.addChild(this.backSpike1);
        this.thighs.addChild(this.rLeg1);
        this.lShoulder.addChild(this.lArm1);
        this.thighs.addChild(this.lLeg1);
        this.lBrow1.addChild(this.lBrow2);
        this.torso.addChild(this.rightPec);
        this.torso.addChild(this.leftPec);
        this.neck.addChild(this.head);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.thighs).forEach((modelRenderer) -> {
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// ModelHelper.func_239105_a_(this.lArmSpike, this.rArmSpike, false,
		// this.swingProgress, ageInTicks);
		this.rShoulder.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.lShoulder.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
				/ 1.0F;
		this.rLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.lLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / 1.0F;
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}