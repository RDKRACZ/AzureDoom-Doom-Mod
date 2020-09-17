package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class PinkyModel<T extends Entity> extends EntityModel<T> {
	public ModelRenderer thighs;
    public ModelRenderer lLeg1_flat;
    public ModelRenderer rLeg1_flat;
    public ModelRenderer chest;
    public ModelRenderer neck;
    public ModelRenderer lShoulder;
    public ModelRenderer rShoulder;
    public ModelRenderer head;
    public ModelRenderer rHorn1;
    public ModelRenderer topJaw;
    public ModelRenderer lEye;
    public ModelRenderer lHorn1;
    public ModelRenderer rEye;
    public ModelRenderer lowJaw_flat;
    public ModelRenderer rHorn2;
    public ModelRenderer rHorn3;
    public ModelRenderer snout;
    public ModelRenderer topTeeth;
    public ModelRenderer lHorn2;
    public ModelRenderer lHorn3;
    public ModelRenderer lowJaw;
    public ModelRenderer lowTeeth;
    public ModelRenderer lArm1;
    public ModelRenderer lArm2;
    public ModelRenderer rArm1;
    public ModelRenderer rArm2;
    public ModelRenderer lLeg1;
    public ModelRenderer lLeg2;
    public ModelRenderer lLeg3;
    public ModelRenderer lFoot;
    public ModelRenderer rLeg1;
    public ModelRenderer rLeg2;
    public ModelRenderer rLeg3;
    public ModelRenderer rFoot;

    public PinkyModel() {
        this.textureWidth = 60;
        this.textureHeight = 120;
        this.topTeeth = new ModelRenderer(this, 26, 20);
        this.topTeeth.setRotationPoint(0.0F, 1.8F, -1.8F);
        this.topTeeth.addBox(-4.0F, 0.0F, 0.0F, 8.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.lEye = new ModelRenderer(this, 21, 62);
        this.lEye.mirror = true;
        this.lEye.setRotationPoint(1.8F, 1.0F, -3.7F);
        this.lEye.addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lEye, 0.13665927909957545F, -0.2275909337942703F, 0.0F);
        this.topJaw = new ModelRenderer(this, 23, 51);
        this.topJaw.setRotationPoint(0.0F, 2.5F, -4.0F);
        this.topJaw.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(topJaw, 0.2275909337942703F, 0.0F, 0.0F);
        this.rShoulder = new ModelRenderer(this, 0, 72);
        this.rShoulder.setRotationPoint(-4.0F, -9.0F, -3.8F);
        this.rShoulder.addBox(-4.0F, -2.0F, -2.0F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rShoulder, 0.0F, 0.0F, 0.3642502295386026F);
        this.rHorn2 = new ModelRenderer(this, 32, 96);
        this.rHorn2.setRotationPoint(0.0F, 2.5F, 0.0F);
        this.rHorn2.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rHorn2, -0.3642502295386026F, 0.0F, 0.0F);
        this.rHorn3 = new ModelRenderer(this, 40, 96);
        this.rHorn3.setRotationPoint(0.0F, 2.5F, 0.0F);
        this.rHorn3.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rHorn3, -0.7285004590772052F, 0.0F, 0.0F);
        this.lLeg1 = new ModelRenderer(this, 0, 83);
        this.lLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lLeg1.addBox(-3.0F, 0.0F, -2.5F, 6.0F, 6.0F, 5.0F, 0.0F, 0.19999981F, 0.0F);
        this.setRotateAngle(lLeg1, -0.46914448828868976F, 0.0F, -0.16580627893946132F);
        this.neck = new ModelRenderer(this, 0, 31);
        this.neck.setRotationPoint(0.0F, -10.0F, 1.0F);
        this.neck.addBox(-4.0F, 0.0F, -12.0F, 8.0F, 8.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(neck, -0.0911061832922575F, 0.0F, 0.0F);
        this.lLeg2 = new ModelRenderer(this, 22, 84);
        this.lLeg2.setRotationPoint(-0.1F, 5.7F, -2.5F);
        this.lLeg2.addBox(-2.5F, 0.0F, 0.0F, 5.0F, 8.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg2, 0.956091342937205F, 0.0F, 0.1752310562344404F);
        this.lArm2 = new ModelRenderer(this, 36, 72);
        this.lArm2.setRotationPoint(0.0F, 8.0F, 2.0F);
        this.lArm2.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 10.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lArm2, -0.3642502295386026F, 0.0F, 0.0F);
        this.lLeg3 = new ModelRenderer(this, 40, 86);
        this.lLeg3.setRotationPoint(0.0F, 8.0F, 4.0F);
        this.lLeg3.addBox(-2.0F, 0.0F, -3.0F, 4.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg3, -0.8651597048872669F, -0.0911061832922575F, 0.05235987755982988F);
        this.thighs = new ModelRenderer(this, 0, 18);
        this.thighs.setRotationPoint(0.0F, 1.6F, 3.0F);
        this.thighs.addBox(-5.0F, 0.0F, -5.0F, 10.0F, 7.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(thighs, 0.18203784630933073F, 0.0F, 0.0F);
        this.lFoot = new ModelRenderer(this, 0, 94);
        this.lFoot.setRotationPoint(0.0F, 5.5F, 0.0F);
        this.lFoot.addBox(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lFoot, 0.3642502295386026F, 0.0F, 0.0F);
        this.rLeg1 = new ModelRenderer(this, 0, 83);
        this.rLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rLeg1.addBox(-3.0F, 0.0F, -2.5F, 6.0F, 6.0F, 5.0F, 0.0F, 0.19999981F, 0.0F);
        this.setRotateAngle(rLeg1, -0.46914448828868976F, 0.0F, 0.16580627893946132F);
        this.lLeg1_flat = new ModelRenderer(this, 0, 83);
        this.lLeg1_flat.setRotationPoint(3.0F, 6.9F, 2.0F);
        this.lLeg1_flat.addBox(-3.0F, 0.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.lArm1 = new ModelRenderer(this, 20, 72);
        this.lArm1.setRotationPoint(1.5F, 2.0F, 0.5F);
        this.lArm1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.rHorn1 = new ModelRenderer(this, 20, 96);
        this.rHorn1.setRotationPoint(-3.0F, 1.0F, -2.0F);
        this.rHorn1.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rHorn1, 0.2275909337942703F, 0.0F, 2.2764328155444717F);
        this.lHorn3 = new ModelRenderer(this, 40, 96);
        this.lHorn3.setRotationPoint(0.0F, 2.5F, 0.0F);
        this.lHorn3.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lHorn3, -0.7285004590772052F, 0.0F, 0.0F);
        this.lowJaw = new ModelRenderer(this, 0, 62);
        this.lowJaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lowJaw.addBox(-3.5F, 0.0F, -7.0F, 7.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lowJaw, 0.8651597048872669F, -0.0F, 0.0F);
        this.rArm1 = new ModelRenderer(this, 20, 72);
        this.rArm1.setRotationPoint(-1.5F, 2.0F, 0.5F);
        this.rArm1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.rLeg3 = new ModelRenderer(this, 40, 86);
        this.rLeg3.setRotationPoint(0.0F, 8.0F, 4.0F);
        this.rLeg3.addBox(-2.0F, 0.0F, -3.0F, 4.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg3, -0.8651597048872669F, 0.0911061832922575F, -0.05235987755982988F);
        this.lowTeeth = new ModelRenderer(this, 28, 32);
        this.lowTeeth.setRotationPoint(0.0F, 0.3F, -6.9F);
        this.lowTeeth.addBox(-3.0F, -2.0F, 0.0F, 6.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.rArm2 = new ModelRenderer(this, 36, 72);
        this.rArm2.setRotationPoint(0.0F, 8.0F, 2.0F);
        this.rArm2.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 10.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rArm2, -0.3642502295386026F, 0.0F, 0.0F);
        this.rFoot = new ModelRenderer(this, 0, 94);
        this.rFoot.setRotationPoint(0.0F, 5.5F, 0.0F);
        this.rFoot.addBox(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rFoot, 0.3642502295386026F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 51);
        this.head.setRotationPoint(0.0F, 1.0F, -10.8F);
        this.head.addBox(-4.5F, -1.0F, -5.0F, 9.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(head, -0.13665927909957545F, 0.0F, 0.0F);
        this.lHorn1 = new ModelRenderer(this, 20, 96);
        this.lHorn1.setRotationPoint(3.0F, 1.0F, -2.0F);
        this.lHorn1.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lHorn1, 0.2275909337942703F, 0.0F, -2.2764328155444717F);
        this.rLeg1_flat = new ModelRenderer(this, 0, 83);
        this.rLeg1_flat.setRotationPoint(-3.0F, 6.9F, 2.0F);
        this.rLeg1_flat.addBox(-3.0F, 0.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.lowJaw_flat = new ModelRenderer(this, 0, 62);
        this.lowJaw_flat.setRotationPoint(0.0F, 4.0F, -0.5F);
        this.lowJaw_flat.addBox(-3.5F, 0.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.lShoulder = new ModelRenderer(this, 0, 72);
        this.lShoulder.setRotationPoint(4.0F, -9.0F, -3.9F);
        this.lShoulder.addBox(-1.0F, -2.0F, -2.0F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lShoulder, -0.0F, 0.0F, -0.3642502295386026F);
        this.chest = new ModelRenderer(this, 15, 0);
        this.chest.setRotationPoint(0.0F, 0.5F, 0.1F);
        this.chest.addBox(-6.0F, -10.0F, -7.0F, 12.0F, 10.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(chest, 0.2275909337942703F, 0.0F, 0.0F);
        this.rLeg2 = new ModelRenderer(this, 22, 84);
        this.rLeg2.setRotationPoint(0.1F, 5.7F, -2.4F);
        this.rLeg2.addBox(-2.5F, 0.0F, 0.0F, 5.0F, 8.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg2, 0.956091342937205F, 0.0F, -0.1752310562344404F);
        this.lHorn2 = new ModelRenderer(this, 32, 96);
        this.lHorn2.setRotationPoint(0.0F, 2.5F, 0.0F);
        this.lHorn2.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lHorn2, -0.3642502295386026F, 0.0F, 0.0F);
        this.rEye = new ModelRenderer(this, 21, 62);
        this.rEye.setRotationPoint(-1.8F, 1.0F, -3.7F);
        this.rEye.addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rEye, 0.13665927909957545F, 0.2275909337942703F, 0.0F);
        this.snout = new ModelRenderer(this, 0, 0);
        this.snout.setRotationPoint(0.0F, 0.0F, -1.9F);
        this.snout.addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(snout, 1.1383037594559906F, 0.0F, 0.0F);
        this.topJaw.addChild(this.topTeeth);
        this.head.addChild(this.lEye);
        this.head.addChild(this.topJaw);
        this.chest.addChild(this.rShoulder);
        this.rHorn1.addChild(this.rHorn2);
        this.rHorn2.addChild(this.rHorn3);
        this.lLeg1_flat.addChild(this.lLeg1);
        this.chest.addChild(this.neck);
        this.lLeg1.addChild(this.lLeg2);
        this.lArm1.addChild(this.lArm2);
        this.lLeg2.addChild(this.lLeg3);
        this.lLeg3.addChild(this.lFoot);
        this.rLeg1_flat.addChild(this.rLeg1);
        this.lShoulder.addChild(this.lArm1);
        this.head.addChild(this.rHorn1);
        this.lHorn2.addChild(this.lHorn3);
        this.lowJaw_flat.addChild(this.lowJaw);
        this.rShoulder.addChild(this.rArm1);
        this.rLeg2.addChild(this.rLeg3);
        this.lowJaw.addChild(this.lowTeeth);
        this.rArm1.addChild(this.rArm2);
        this.rLeg3.addChild(this.rFoot);
        this.neck.addChild(this.head);
        this.head.addChild(this.lHorn1);
        this.head.addChild(this.lowJaw_flat);
        this.chest.addChild(this.lShoulder);
        this.thighs.addChild(this.chest);
        this.rLeg1.addChild(this.rLeg2);
        this.lHorn1.addChild(this.lHorn2);
        this.head.addChild(this.rEye);
        this.topJaw.addChild(this.snout);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.thighs, this.lLeg1_flat, this.rLeg1_flat).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.lowJaw_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
				/ 1.0F;
		this.rShoulder.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.lShoulder.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
				/ 1.0F;
		this.rLeg1_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.lLeg1_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
				/ 1.0F;
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}