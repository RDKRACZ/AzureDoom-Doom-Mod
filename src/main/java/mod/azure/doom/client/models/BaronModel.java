package mod.azure.doom.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Baron of Hell - Batpixxler Created using Tabula 8.0.0
 */
public class BaronModel<T extends Entity> extends EntityModel<T> {
	public ModelRenderer thighs;
	public ModelRenderer lLeg1_flat;
	public ModelRenderer rLeg1_flat;
	public ModelRenderer chest;
	public ModelRenderer neck;
	public ModelRenderer rightPec;
	public ModelRenderer lShoulder;
	public ModelRenderer rShoulder;
	public ModelRenderer leftPec;
	public ModelRenderer head;
	public ModelRenderer topJaw;
	public ModelRenderer lowJaw;
	public ModelRenderer lHorn1;
	public ModelRenderer rHorn1;
	public ModelRenderer snout;
	public ModelRenderer lMHorn1;
	public ModelRenderer rMHorn1;
	public ModelRenderer lMHorn2;
	public ModelRenderer rMHorn2;
	public ModelRenderer lHorn2;
	public ModelRenderer lHorn3;
	public ModelRenderer lHorn4;
	public ModelRenderer rHorn2;
	public ModelRenderer rHorn3;
	public ModelRenderer rHorn4;
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

	public BaronModel() {
		this.textureWidth = 60;
		this.textureHeight = 180;
		this.lFoot = new ModelRenderer(this, 18, 57);
		this.lFoot.setRotationPoint(0.0F, 9.0F, -2.0F);
		this.lFoot.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lFoot, 0.2275909337942703F, 0.0F, 0.0F);
		this.rShoulder = new ModelRenderer(this, 0, 71);
		this.rShoulder.mirror = true;
		this.rShoulder.setRotationPoint(-7.5F, -7.5F, -4.0F);
		this.rShoulder.addBox(-5.0F, -2.0F, -3.5F, 6.0F, 6.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rShoulder, 0.0F, 0.0F, 0.0911061832922575F);
		this.lowJaw = new ModelRenderer(this, 0, 144);
		this.lowJaw.setRotationPoint(0.0F, -1.0F, -6.5F);
		this.lowJaw.addBox(-3.0F, -1.0F, -5.0F, 6.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.lHorn1 = new ModelRenderer(this, 27, 142);
		this.lHorn1.setRotationPoint(3.0F, -9.0F, -2.5F);
		this.lHorn1.addBox(-2.5F, -3.0F, -2.5F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn1, 0.0F, 0.0F, 0.5462880425584197F);
		this.lArm2 = new ModelRenderer(this, 0, 84);
		this.lArm2.setRotationPoint(0.0F, 6.7F, 2.5F);
		this.lArm2.addBox(-2.5F, 0.0F, -4.0F, 5.0F, 11.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lArm2, -0.27314402127920984F, 0.0F, 0.0911061832922575F);
		this.lLeg2 = new ModelRenderer(this, 28, 37);
		this.lLeg2.setRotationPoint(0.0F, 12.5F, -3.0F);
		this.lLeg2.addBox(-3.0F, 0.0F, -0.5F, 6.0F, 9.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg2, 1.092750655326294F, 0.0F, 0.04555309164612875F);
		this.rLeg1 = new ModelRenderer(this, 0, 37);
		this.rLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rLeg1.addBox(-3.5F, 0.0F, -3.5F, 7.0F, 13.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg1, -0.4098033003787853F, 0.0F, 0.04555309164612875F);
		this.topJaw = new ModelRenderer(this, 0, 135);
		this.topJaw.setRotationPoint(0.0F, -4.0F, -6.8F);
		this.topJaw.addBox(-3.5F, -2.0F, -5.0F, 7.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.lMHorn2 = new ModelRenderer(this, 40, 26);
		this.lMHorn2.setRotationPoint(0.0F, 1.0F, -2.9F);
		this.lMHorn2.addBox(-0.5F, -2.0F, -4.0F, 1.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lMHorn2, -0.956091342937205F, 0.0F, 0.0F);
		this.neck = new ModelRenderer(this, 0, 99);
		this.neck.setRotationPoint(0.0F, -8.6F, -1.1F);
		this.neck.addBox(-4.0F, -8.0F, -6.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(neck, -0.04555309164612875F, 0.0F, 0.0F);
		this.thighs = new ModelRenderer(this, 0, 19);
		this.thighs.setRotationPoint(0.0F, -9.0F, 5.0F);
		this.thighs.addBox(-6.0F, 0.0F, -7.0F, 12.0F, 10.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.chest = new ModelRenderer(this, 0, 0);
		this.chest.setRotationPoint(0.0F, 0.3F, 0.0F);
		this.chest.addBox(-7.5F, -9.0F, -9.0F, 15.0F, 9.0F, 10.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(chest, 0.13665927909957545F, 0.0F, 0.0F);
		this.rMHorn1 = new ModelRenderer(this, 32, 19);
		this.rMHorn1.setRotationPoint(-1.5F, 0.1F, -4.0F);
		this.rMHorn1.addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rMHorn1, -0.3186971254089062F, 0.45535640450848164F, 0.0F);
		this.rMHorn2 = new ModelRenderer(this, 40, 26);
		this.rMHorn2.setRotationPoint(0.0F, 1.0F, -2.9F);
		this.rMHorn2.addBox(-0.5F, -2.0F, -4.0F, 1.0F, 2.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rMHorn2, -0.956091342937205F, 0.0F, 0.0F);
		this.rHorn2 = new ModelRenderer(this, 0, 151);
		this.rHorn2.setRotationPoint(0.0F, -2.0F, 2.0F);
		this.rHorn2.addBox(-2.0F, -5.0F, -4.0F, 4.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn2, 0.6829473549475088F, 0.0F, -0.4098033003787853F);
		this.head = new ModelRenderer(this, 0, 115);
		this.head.setRotationPoint(0.0F, -3.8F, 0.5F);
		this.head.addBox(-5.0F, -11.0F, -7.0F, 10.0F, 11.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(head, 0.0911061832922575F, 0.0F, 0.0F);
		this.rightPec = new ModelRenderer(this, 18, 84);
		this.rightPec.mirror = true;
		this.rightPec.setRotationPoint(-4.4F, -4.9F, -6.5F);
		this.rightPec.addBox(-4.0F, -4.0F, -3.0F, 8.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rightPec, 0.0F, 0.0F, -0.08726646259971647F);
		this.lShoulder = new ModelRenderer(this, 0, 71);
		this.lShoulder.mirror = true;
		this.lShoulder.setRotationPoint(7.5F, -7.5F, -4.0F);
		this.lShoulder.addBox(-1.0F, -2.0F, -3.5F, 6.0F, 6.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lShoulder, 0.0F, 0.0F, -0.0911061832922575F);
		this.lHorn2 = new ModelRenderer(this, 0, 151);
		this.lHorn2.setRotationPoint(0.0F, -2.0F, 2.0F);
		this.lHorn2.addBox(-2.0F, -5.0F, -4.0F, 4.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn2, 0.6829473549475088F, 0.0F, 0.4098033003787853F);
		this.rHorn1 = new ModelRenderer(this, 27, 142);
		this.rHorn1.setRotationPoint(-3.0F, -9.0F, -2.5F);
		this.rHorn1.addBox(-2.5F, -3.0F, -2.5F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn1, 0.0F, 0.0F, -0.5462880425584197F);
		this.rFoot = new ModelRenderer(this, 18, 57);
		this.rFoot.setRotationPoint(0.0F, 9.0F, -2.0F);
		this.rFoot.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rFoot, 0.2275909337942703F, 0.0F, 0.0F);
		this.leftPec = new ModelRenderer(this, 18, 84);
		this.leftPec.setRotationPoint(4.3F, -4.9F, -6.5F);
		this.leftPec.addBox(-4.0F, -4.0F, -3.0F, 8.0F, 8.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leftPec, 0.0F, 0.0F, 0.08726646259971647F);
		this.rHorn3 = new ModelRenderer(this, 16, 152);
		this.rHorn3.setRotationPoint(0.0F, -5.0F, 0.0F);
		this.rHorn3.addBox(-1.5F, -4.0F, -3.0F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn3, 0.500909508638178F, 0.0F, 0.0F);
		this.rLeg3 = new ModelRenderer(this, 0, 57);
		this.rLeg3.setRotationPoint(0.0F, 9.0F, 4.5F);
		this.rLeg3.addBox(-2.5F, 0.0F, -4.0F, 5.0F, 10.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg3, -0.9105382388075086F, 0.0F, 0.0F);
		this.lHorn3 = new ModelRenderer(this, 16, 152);
		this.lHorn3.setRotationPoint(0.0F, -5.0F, 0.0F);
		this.lHorn3.addBox(-1.5F, -4.0F, -3.0F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn3, 0.500909508638178F, 0.0F, 0.0F);
		this.rHorn4 = new ModelRenderer(this, 28, 152);
		this.rHorn4.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.rHorn4.addBox(-1.0F, -6.0F, -2.0F, 2.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn4, 0.6373942508178124F, 0.0F, 0.0F);
		this.lArm1 = new ModelRenderer(this, 19, 66);
		this.lArm1.mirror = true;
		this.lArm1.setRotationPoint(2.0F, 4.0F, 0.0F);
		this.lArm1.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.rArm1 = new ModelRenderer(this, 19, 66);
		this.rArm1.mirror = true;
		this.rArm1.setRotationPoint(-2.0F, 4.0F, 0.0F);
		this.rArm1.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.snout = new ModelRenderer(this, 24, 135);
		this.snout.setRotationPoint(0.0F, -2.0F, -5.0F);
		this.snout.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(snout, 0.27314402127920984F, 0.0F, 0.0F);
		this.lLeg1 = new ModelRenderer(this, 0, 37);
		this.lLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lLeg1.addBox(-3.5F, 0.0F, -3.5F, 7.0F, 13.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg1, -0.4098033003787853F, 0.0F, -0.04555309164612875F);
		this.lMHorn1 = new ModelRenderer(this, 32, 19);
		this.lMHorn1.setRotationPoint(1.5F, 0.1F, -4.0F);
		this.lMHorn1.addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lMHorn1, -0.3186971254089062F, -0.45535640450848164F, 0.0F);
		this.rLeg2 = new ModelRenderer(this, 28, 37);
		this.rLeg2.setRotationPoint(0.0F, 12.5F, -3.0F);
		this.rLeg2.addBox(-3.0F, 0.0F, -0.5F, 6.0F, 9.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg2, 1.092750655326294F, 0.0F, -0.04555309164612875F);
		this.lHorn4 = new ModelRenderer(this, 28, 152);
		this.lHorn4.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.lHorn4.addBox(-1.0F, -6.0F, -2.0F, 2.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn4, 0.6373942508178124F, 0.0F, 0.0F);
		this.rArm2 = new ModelRenderer(this, 0, 84);
		this.rArm2.setRotationPoint(0.0F, 6.7F, 2.5F);
		this.rArm2.addBox(-2.5F, 0.0F, -4.0F, 5.0F, 11.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rArm2, -0.27314402127920984F, 0.0F, -0.0911061832922575F);
		this.lLeg3 = new ModelRenderer(this, 0, 57);
		this.lLeg3.setRotationPoint(0.0F, 9.0F, 4.5F);
		this.lLeg3.addBox(-2.5F, 0.0F, -4.0F, 5.0F, 10.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg3, -0.9105382388075086F, 0.0F, 0.0F);
		this.rLeg1_flat = new ModelRenderer(this, 0, 37);
		this.rLeg1_flat.setRotationPoint(-3.5F, -2.3F, 3.0F);
		this.rLeg1_flat.addBox(-3.2F, 0.0F, -3.5F, 0.70000005F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.lLeg1_flat = new ModelRenderer(this, 0, 37);
		this.lLeg1_flat.setRotationPoint(3.5F, -2.3F, 3.0F);
		this.lLeg1_flat.addBox(-3.5F, 0.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.lLeg3.addChild(this.lFoot);
		this.chest.addChild(this.rShoulder);
		this.head.addChild(this.lowJaw);
		this.head.addChild(this.lHorn1);
		this.lArm1.addChild(this.lArm2);
		this.lLeg1.addChild(this.lLeg2);
		this.head.addChild(this.topJaw);
		this.lMHorn1.addChild(this.lMHorn2);
		this.chest.addChild(this.neck);
		this.thighs.addChild(this.chest);
		this.lowJaw.addChild(this.rMHorn1);
		this.rMHorn1.addChild(this.rMHorn2);
		this.rHorn1.addChild(this.rHorn2);
		this.neck.addChild(this.head);
		this.chest.addChild(this.rightPec);
		this.chest.addChild(this.lShoulder);
		this.lHorn1.addChild(this.lHorn2);
		this.head.addChild(this.rHorn1);
		this.rLeg3.addChild(this.rFoot);
		this.chest.addChild(this.leftPec);
		this.rHorn2.addChild(this.rHorn3);
		this.rLeg2.addChild(this.rLeg3);
		this.lHorn2.addChild(this.lHorn3);
		this.rHorn3.addChild(this.rHorn4);
		this.lShoulder.addChild(this.lArm1);
		this.rShoulder.addChild(this.rArm1);
		this.topJaw.addChild(this.snout);
		this.lowJaw.addChild(this.lMHorn1);
		this.rLeg1.addChild(this.rLeg2);
		this.lHorn3.addChild(this.lHorn4);
		this.rArm1.addChild(this.rArm2);
		this.lLeg2.addChild(this.lLeg3);
		this.rLeg1_flat.addChild(this.rLeg1);
		this.lLeg1_flat.addChild(this.lLeg1);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.lLeg1_flat, this.thighs, this.rLeg1_flat).forEach((modelRenderer) -> {
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.rShoulder.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.lShoulder.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
				/ 1.0F;
		this.rLeg1_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.lLeg1_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount
				/ 1.0F;
		this.lowJaw.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount
				/ 1.3F;
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}