package mod.azure.doomweapon.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Arachnotron - Batpixxler Created using Tabula 8.0.0
 */
public class ArachnotronModel<T extends Entity> extends EntityModel<T> {
	public ModelRenderer lLeg1_1_flat;
    public ModelRenderer lLeg2_1_flat;
    public ModelRenderer base;
    public ModelRenderer rLeg2_1_flat;
    public ModelRenderer rLeg1_1_flat;
    public ModelRenderer lLeg1_1;
    public ModelRenderer lArm;
    public ModelRenderer lLeg1_2;
    public ModelRenderer lLeg1_3;
    public ModelRenderer lLeg1_4;
    public ModelRenderer lLeg1_5;
    public ModelRenderer lLeg2_1;
    public ModelRenderer lLeg2_2;
    public ModelRenderer lLeg2_3;
    public ModelRenderer lLeg2_4;
    public ModelRenderer lLeg2_5;
    public ModelRenderer gunBase;
    public ModelRenderer body;
    public ModelRenderer gunBarrel;
    public ModelRenderer topR;
    public ModelRenderer head;
    public ModelRenderer topL;
    public ModelRenderer lowJaw;
    public ModelRenderer lEye;
    public ModelRenderer rEye;
    public ModelRenderer topJaw;
    public ModelRenderer lowTeeth;
    public ModelRenderer topTeeth;
    public ModelRenderer rLeg2_1;
    public ModelRenderer rLeg2_2;
    public ModelRenderer rLeg2_3;
    public ModelRenderer rLeg2_4;
    public ModelRenderer rLeg2_5;
    public ModelRenderer rLeg1_1;
    public ModelRenderer rLeg1_2;
    public ModelRenderer rArm;
    public ModelRenderer rLeg1_3;
    public ModelRenderer rLeg1_4;
    public ModelRenderer rLeg1_5;

    public ArachnotronModel() {
        this.textureWidth = 100;
        this.textureHeight = 130;
        this.lLeg1_5 = new ModelRenderer(this, 36, 33);
        this.lLeg1_5.setRotationPoint(0.0F, 5.2F, 0.0F);
        this.lLeg1_5.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg1_5, 0.27314400463445304F, 0.0F, 0.0F);
        this.lLeg2_1_flat = new ModelRenderer(this, 0, 33);
        this.lLeg2_1_flat.setRotationPoint(8.0F, 10.0F, 9.0F);
        this.lLeg2_1_flat.addBox(-2.0F, 0.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.topL = new ModelRenderer(this, 0, 55);
        this.topL.setRotationPoint(-1.0F, -10.5F, 0.0F);
        this.topL.addBox(-9.0F, -5.0F, -9.5F, 10.0F, 5.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(topL, 0.0F, 0.0F, -0.27314400463445304F);
        this.lLeg2_1 = new ModelRenderer(this, 0, 33);
        this.lLeg2_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lLeg2_1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg2_1, 1.921607479814146F, 0.591841146688116F, 0.0F);
        this.lowJaw = new ModelRenderer(this, 0, 59);
        this.lowJaw.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.lowJaw.addBox(-2.5F, 0.0F, -2.0F, 5.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lowJaw, 0.591841146688116F, 0.0F, 0.0F);
        this.rLeg1_1 = new ModelRenderer(this, 0, 33);
        this.rLeg1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rLeg1_1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg1_1, -1.921607479814146F, 0.591841146688116F, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.body.addBox(-10.5F, -11.0F, -10.0F, 21.0F, 13.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.lLeg1_1_flat = new ModelRenderer(this, 0, 33);
        this.lLeg1_1_flat.setRotationPoint(8.0F, 10.5F, -9.0F);
        this.lLeg1_1_flat.addBox(-2.0F, 0.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.rLeg1_1_flat = new ModelRenderer(this, 0, 33);
        this.rLeg1_1_flat.setRotationPoint(-7.0F, 10.5F, -9.0F);
        this.rLeg1_1_flat.addBox(-2.0F, 0.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.lArm = new ModelRenderer(this, 27, 44);
        this.lArm.setRotationPoint(0.0F, 10.0F, -1.0F);
        this.lArm.addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lArm, -0.956091342937205F, 0.0F, 0.0F);
        this.rLeg2_1 = new ModelRenderer(this, 0, 33);
        this.rLeg2_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rLeg2_1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg2_1, 1.921607479814146F, -0.591841146688116F, 0.0F);
        this.rArm = new ModelRenderer(this, 27, 44);
        this.rArm.setRotationPoint(0.0F, 10.0F, -1.0F);
        this.rArm.addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rArm, -0.956091342937205F, 0.0F, 0.0F);
        this.lEye = new ModelRenderer(this, 0, 0);
        this.lEye.mirror = true;
        this.lEye.setRotationPoint(2.5F, 5.0F, -0.9F);
        this.lEye.addBox(0.0F, -5.0F, 0.0F, 7.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lEye, 0.0F, 0.0F, -0.6373942508178124F);
        this.rLeg1_3 = new ModelRenderer(this, 0, 33);
        this.rLeg1_3.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.rLeg1_3.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg1_3, 0.6829473549475088F, 0.0F, 0.0F);
        this.rLeg2_1_flat = new ModelRenderer(this, 0, 33);
        this.rLeg2_1_flat.setRotationPoint(-7.0F, 10.0F, 9.0F);
        this.rLeg2_1_flat.addBox(-2.0F, 0.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.lLeg1_3 = new ModelRenderer(this, 0, 33);
        this.lLeg1_3.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.lLeg1_3.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg1_3, 0.6829473549475088F, 0.0F, 0.0F);
        this.rLeg1_2 = new ModelRenderer(this, 16, 33);
        this.rLeg1_2.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.rLeg1_2.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg1_2, 0.4098033003787853F, 0.0F, 0.0F);
        this.rLeg2_2 = new ModelRenderer(this, 16, 33);
        this.rLeg2_2.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.rLeg2_2.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg2_2, -0.4098033003787853F, 0.0F, 0.0F);
        this.rLeg2_3 = new ModelRenderer(this, 0, 33);
        this.rLeg2_3.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.rLeg2_3.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg2_3, -0.6829473549475088F, 0.0F, 0.0F);
        this.lLeg2_5 = new ModelRenderer(this, 36, 33);
        this.lLeg2_5.setRotationPoint(0.0F, 5.2F, 0.0F);
        this.lLeg2_5.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg2_5, -0.27314400463445304F, 0.0F, 0.0F);
        this.lLeg2_2 = new ModelRenderer(this, 16, 33);
        this.lLeg2_2.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.lLeg2_2.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg2_2, -0.4098033003787853F, 0.0F, 0.0F);
        this.topJaw = new ModelRenderer(this, 0, 11);
        this.topJaw.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.topJaw.addBox(-2.5F, 0.0F, -2.0F, 5.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.rLeg2_5 = new ModelRenderer(this, 36, 33);
        this.rLeg2_5.setRotationPoint(0.0F, 5.2F, 0.0F);
        this.rLeg2_5.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg2_5, -0.27314400463445304F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 6);
        this.head.setRotationPoint(0.0F, -8.3F, -10.0F);
        this.head.addBox(-2.0F, 0.0F, -1.0F, 4.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.topR = new ModelRenderer(this, 0, 55);
        this.topR.setRotationPoint(1.0F, -10.5F, 0.0F);
        this.topR.addBox(-1.0F, -5.0F, -9.5F, 10.0F, 5.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(topR, 0.0F, 0.0F, 0.27314400463445304F);
        this.topTeeth = new ModelRenderer(this, 0, 15);
        this.topTeeth.setRotationPoint(0.0F, 1.4F, -1.9F);
        this.topTeeth.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.rLeg1_4 = new ModelRenderer(this, 16, 42);
        this.rLeg1_4.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.rLeg1_4.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg1_4, 0.5462880092689061F, 0.0F, 0.0F);
        this.lLeg2_4 = new ModelRenderer(this, 16, 42);
        this.lLeg2_4.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.lLeg2_4.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg2_4, -0.5462880092689061F, 0.0F, 0.0F);
        this.rEye = new ModelRenderer(this, 0, 0);
        this.rEye.setRotationPoint(-2.0F, 5.0F, -0.9F);
        this.rEye.addBox(-7.0F, -5.0F, 0.0F, 7.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rEye, 0.0F, 0.0F, 0.6373942508178124F);
        this.lowTeeth = new ModelRenderer(this, 0, 64);
        this.lowTeeth.setRotationPoint(-1.5F, -0.4F, -1.6F);
        this.lowTeeth.addBox(0.0F, 0.0F, 0.0F, 3.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.gunBarrel = new ModelRenderer(this, 54, 43);
        this.gunBarrel.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.gunBarrel.addBox(-2.0F, 0.0F, -4.0F, 4.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.lLeg1_2 = new ModelRenderer(this, 16, 33);
        this.lLeg1_2.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.lLeg1_2.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg1_2, 0.4098033003787853F, 0.0F, 0.0F);
        this.rLeg2_4 = new ModelRenderer(this, 16, 42);
        this.rLeg2_4.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.rLeg2_4.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg2_4, -0.5462880092689061F, 0.0F, 0.0F);
        this.lLeg1_4 = new ModelRenderer(this, 16, 42);
        this.lLeg1_4.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.lLeg1_4.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg1_4, 0.5462880092689061F, 0.0F, 0.0F);
        this.base = new ModelRenderer(this, 0, 79);
        this.base.setRotationPoint(0.0F, 7.5F, 0.0F);
        this.base.addBox(-11.5F, 0.0F, -11.5F, 23.0F, 7.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(base, 0.0F, 0.0F, -0.006283185556850939F);
        this.lLeg2_3 = new ModelRenderer(this, 0, 33);
        this.lLeg2_3.setRotationPoint(0.0F, 3.0F, 0.0F);
        this.lLeg2_3.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg2_3, -0.6829473549475088F, 0.0F, 0.0F);
        this.lLeg1_1 = new ModelRenderer(this, 0, 33);
        this.lLeg1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lLeg1_1.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(lLeg1_1, -1.9228292049642197F, -0.591841146688116F, 0.0F);
        this.gunBase = new ModelRenderer(this, 40, 43);
        this.gunBase.setRotationPoint(0.0F, 0.2F, -13.0F);
        this.gunBase.addBox(-2.5F, 0.0F, 0.0F, 5.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.rLeg1_5 = new ModelRenderer(this, 36, 33);
        this.rLeg1_5.setRotationPoint(0.0F, 5.2F, 0.0F);
        this.rLeg1_5.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rLeg1_5, 0.27314400463445304F, 0.0F, 0.0F);
        this.lLeg1_4.addChild(this.lLeg1_5);
        this.body.addChild(this.topL);
        this.lLeg2_1_flat.addChild(this.lLeg2_1);
        this.head.addChild(this.lowJaw);
        this.rLeg1_1_flat.addChild(this.rLeg1_1);
        this.base.addChild(this.body);
        this.lLeg1_1.addChild(this.lArm);
        this.rLeg2_1_flat.addChild(this.rLeg2_1);
        this.rLeg1_1.addChild(this.rArm);
        this.head.addChild(this.lEye);
        this.rLeg1_2.addChild(this.rLeg1_3);
        this.lLeg1_2.addChild(this.lLeg1_3);
        this.rLeg1_1.addChild(this.rLeg1_2);
        this.rLeg2_1.addChild(this.rLeg2_2);
        this.rLeg2_2.addChild(this.rLeg2_3);
        this.lLeg2_4.addChild(this.lLeg2_5);
        this.lLeg2_1.addChild(this.lLeg2_2);
        this.head.addChild(this.topJaw);
        this.rLeg2_4.addChild(this.rLeg2_5);
        this.body.addChild(this.head);
        this.body.addChild(this.topR);
        this.topJaw.addChild(this.topTeeth);
        this.rLeg1_3.addChild(this.rLeg1_4);
        this.lLeg2_3.addChild(this.lLeg2_4);
        this.head.addChild(this.rEye);
        this.lowJaw.addChild(this.lowTeeth);
        this.gunBase.addChild(this.gunBarrel);
        this.lLeg1_1.addChild(this.lLeg1_2);
        this.rLeg2_3.addChild(this.rLeg2_4);
        this.lLeg1_3.addChild(this.lLeg1_4);
        this.lLeg2_2.addChild(this.lLeg2_3);
        this.lLeg1_1_flat.addChild(this.lLeg1_1);
        this.base.addChild(this.gunBase);
        this.rLeg1_4.addChild(this.rLeg1_5);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.lLeg2_1_flat, this.lLeg1_1_flat, this.rLeg1_1_flat, this.rLeg2_1_flat, this.base).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.rLeg1_1_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount / 1.0F;
		this.lLeg1_1_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.4F * limbSwingAmount
				/ 1.0F;
		this.rLeg1_1_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.4F * limbSwingAmount / 1.0F;
		this.lLeg2_1_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.4F * limbSwingAmount
				/ 1.0F;
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}