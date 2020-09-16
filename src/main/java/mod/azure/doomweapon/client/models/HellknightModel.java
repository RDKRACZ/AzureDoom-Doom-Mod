package mod.azure.doomweapon.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * Hell Knight - Batpixxler Created using Tabula 8.0.0
 */
public class HellknightModel<T extends Entity> extends EntityModel<T> {
	public ModelRenderer thighs;
	public ModelRenderer lLeg1_flat;
	public ModelRenderer rLeg1_flat;
	public ModelRenderer chest;
	public ModelRenderer neck;
	public ModelRenderer rShoulder;
	public ModelRenderer rightPec;
	public ModelRenderer leftPec;
	public ModelRenderer lShoulder;
	public ModelRenderer head;
	public ModelRenderer lHorn1;
	public ModelRenderer rHorn1;
	public ModelRenderer topJaw;
	public ModelRenderer lowJaw_flat;
	public ModelRenderer lHorn2;
	public ModelRenderer lHorn3;
	public ModelRenderer lHorn4;
	public ModelRenderer rHorn2;
	public ModelRenderer rHorn3;
	public ModelRenderer rHorn4;
	public ModelRenderer snout;
	public ModelRenderer lowJaw;
	public ModelRenderer lMHorn1;
	public ModelRenderer rMHorn1;
	public ModelRenderer lMHorn2;
	public ModelRenderer rMHorn2;
	public ModelRenderer rArm1;
	public ModelRenderer rArm2;
	public ModelRenderer lArm1;
	public ModelRenderer lArm2;
	public ModelRenderer lLeg1;
	public ModelRenderer lLeg2;
	public ModelRenderer lLeg3;
	public ModelRenderer lFoot;
	public ModelRenderer rLeg1;
	public ModelRenderer rLeg2;
	public ModelRenderer rLeg3;
	public ModelRenderer rFoot;

	public HellknightModel() {
		this.textureWidth = 60;
		this.textureHeight = 150;
		this.lLeg1 = new ModelRenderer(this, 20, 62);
		this.lLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lLeg1.addBox(-3.5F, 0.0F, -3.5F, 7.0F, 11.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg1, -0.4098033003787853F, 0.0F, -0.04555309164612875F);
		this.lHorn2 = new ModelRenderer(this, 0, 131);
		this.lHorn2.setRotationPoint(0.0F, -2.0F, 2.0F);
		this.lHorn2.addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn2, 0.6829473549475088F, 0.0F, 0.4098033003787853F);
		this.lShoulder = new ModelRenderer(this, 0, 51);
		this.lShoulder.setRotationPoint(7.0F, -7.5F, -4.0F);
		this.lShoulder.addBox(-1.0F, -2.0F, -3.5F, 6.0F, 6.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lShoulder, -0.0F, 0.0F, -0.0911061832922575F);
		this.rLeg1 = new ModelRenderer(this, 20, 62);
		this.rLeg1.mirror = true;
		this.rLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.rLeg1.addBox(-3.5F, 0.0F, -3.5F, 7.0F, 11.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg1, -0.4098033003787853F, 0.0F, 0.04555309164612875F);
		this.lLeg3 = new ModelRenderer(this, 25, 67);
		this.lLeg3.setRotationPoint(0.0F, 9.0F, 4.5F);
		this.lLeg3.addBox(-2.5F, 0.0F, -4.0F, 5.0F, 10.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg3, -0.9105382388075086F, 0.0F, 0.0F);
		this.leftPec = new ModelRenderer(this, 32, 36);
		this.leftPec.setRotationPoint(3.8F, -5.5F, -6.5F);
		this.leftPec.addBox(-3.5F, -3.5F, -3.0F, 7.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(leftPec, 0.0F, 0.0F, 0.08726646259971647F);
		this.rightPec = new ModelRenderer(this, 32, 36);
		this.rightPec.mirror = true;
		this.rightPec.setRotationPoint(-3.8F, -5.5F, -6.5F);
		this.rightPec.addBox(-3.5F, -3.5F, -3.0F, 7.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rightPec, 0.0F, 0.0F, -0.08726646259971647F);
		this.lLeg2 = new ModelRenderer(this, 0, 79);
		this.lLeg2.setRotationPoint(0.0F, 10.5F, -3.0F);
		this.lLeg2.addBox(-3.0F, 0.0F, -0.5F, 6.0F, 9.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lLeg2, 1.092750655326294F, 0.0F, 0.04555309164612875F);
		this.rLeg2 = new ModelRenderer(this, 0, 79);
		this.rLeg2.setRotationPoint(0.0F, 10.5F, -3.0F);
		this.rLeg2.addBox(-3.0F, 0.0F, -0.5F, 6.0F, 9.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg2, 1.092750655326294F, 0.0F, -0.04555309164612875F);
		this.lLeg1_flat = new ModelRenderer(this, 20, 62);
		this.lLeg1_flat.setRotationPoint(3.5F, -0.3F, 3.0F);
		this.lLeg1_flat.addBox(-3.5F, 0.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.lHorn1 = new ModelRenderer(this, 26, 121);
		this.lHorn1.setRotationPoint(3.0F, -9.0F, -2.5F);
		this.lHorn1.addBox(-2.5F, -3.0F, -2.5F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn1, 0.0F, 0.0F, 0.5462880092689061F);
		this.head = new ModelRenderer(this, 13, 94);
		this.head.setRotationPoint(0.0F, -2.8F, 0.5F);
		this.head.addBox(-5.0F, -11.0F, -7.0F, 10.0F, 11.0F, 9.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(head, 0.0911061832922575F, 0.0F, 0.0F);
		this.rHorn1 = new ModelRenderer(this, 26, 121);
		this.rHorn1.setRotationPoint(-3.0F, -9.0F, -2.5F);
		this.rHorn1.addBox(-2.5F, -3.0F, -2.5F, 5.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn1, 0.0F, 0.0F, -0.5462880092689061F);
		this.rShoulder = new ModelRenderer(this, 0, 51);
		this.rShoulder.mirror = true;
		this.rShoulder.setRotationPoint(-7.0F, -7.5F, -4.0F);
		this.rShoulder.addBox(-5.0F, -2.0F, -3.5F, 6.0F, 6.0F, 7.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rShoulder, 0.0F, 0.0F, 0.0911061832922575F);
		this.thighs = new ModelRenderer(this, 0, 18);
		this.thighs.setRotationPoint(0.0F, -7.0F, 5.0F);
		this.thighs.addBox(-5.5F, 0.0F, -7.0F, 11.0F, 10.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.neck = new ModelRenderer(this, 0, 36);
		this.neck.setRotationPoint(0.0F, -8.6F, -1.1F);
		this.neck.addBox(-4.0F, -7.0F, -6.0F, 8.0F, 7.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(neck, -0.04555309164612875F, 0.0F, 0.0F);
		this.rMHorn2 = new ModelRenderer(this, 0, 107);
		this.rMHorn2.setRotationPoint(0.0F, 1.0F, -2.9F);
		this.rMHorn2.addBox(-0.5F, -2.0F, -3.0F, 1.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rMHorn2, -0.956091342937205F, 0.0F, 0.0F);
		this.rArm2 = new ModelRenderer(this, 0, 64);
		this.rArm2.mirror = true;
		this.rArm2.setRotationPoint(0.0F, 5.8F, 2.5F);
		this.rArm2.addBox(-2.5F, 0.0F, -4.0F, 5.0F, 11.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rArm2, -0.27314402127920984F, 0.0F, -0.0911061832922575F);
		this.snout = new ModelRenderer(this, 24, 114);
		this.snout.setRotationPoint(0.0F, -2.0F, -5.0F);
		this.snout.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(snout, 0.27314400463445304F, 0.0F, 0.0F);
		this.lMHorn1 = new ModelRenderer(this, 0, 102);
		this.lMHorn1.setRotationPoint(1.5F, 0.1F, -4.0F);
		this.lMHorn1.addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lMHorn1, -0.3186971254089062F, -0.45535640450848164F, 0.0F);
		this.chest = new ModelRenderer(this, 0, 0);
		this.chest.setRotationPoint(0.0F, 1.2F, 0.2F);
		this.chest.addBox(-7.0F, -9.0F, -9.0F, 14.0F, 8.0F, 10.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(chest, 0.13665927909957545F, 0.0F, 0.0F);
		this.rHorn4 = new ModelRenderer(this, 28, 131);
		this.rHorn4.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.rHorn4.addBox(-1.0F, -4.0F, -2.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn4, 0.6373942508178124F, 0.0F, 0.0F);
		this.lHorn4 = new ModelRenderer(this, 28, 131);
		this.lHorn4.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.lHorn4.addBox(-1.0F, -4.0F, -2.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn4, 0.6373942508178124F, 0.0F, 0.0F);
		this.lowJaw = new ModelRenderer(this, 0, 123);
		this.lowJaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lowJaw.addBox(-3.0F, -1.0F, -5.0F, 6.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lowJaw, -0.04555309164612875F, 0.0F, 0.0F);
		this.rMHorn1 = new ModelRenderer(this, 0, 102);
		this.rMHorn1.setRotationPoint(-1.5F, 0.1F, -4.0F);
		this.rMHorn1.addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rMHorn1, -0.3186971254089062F, 0.45535640450848164F, 0.0F);
		this.lMHorn2 = new ModelRenderer(this, 0, 107);
		this.lMHorn2.setRotationPoint(0.0F, 1.0F, -2.9F);
		this.lMHorn2.addBox(-0.5F, -2.0F, -3.0F, 1.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lMHorn2, -0.956091342937205F, 0.0F, 0.0F);
		this.lHorn3 = new ModelRenderer(this, 16, 131);
		this.lHorn3.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.lHorn3.addBox(-1.5F, -4.0F, -3.0F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn3, 0.500909508638178F, 0.0F, 0.0F);
		this.lArm1 = new ModelRenderer(this, 26, 51);
		this.lArm1.setRotationPoint(2.0F, 4.0F, 0.0F);
		this.lArm1.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.rFoot = new ModelRenderer(this, 0, 93);
		this.rFoot.setRotationPoint(0.0F, 9.0F, -2.0F);
		this.rFoot.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rFoot, 0.2275909337942703F, 0.0F, 0.0F);
		this.lArm2 = new ModelRenderer(this, 0, 64);
		this.lArm2.setRotationPoint(0.0F, 5.8F, 2.5F);
		this.lArm2.addBox(-2.5F, 0.0F, -4.0F, 5.0F, 11.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lArm2, -0.27314400463445304F, 0.0F, 0.0911061832922575F);
		this.lowJaw_flat = new ModelRenderer(this, 0, 123);
		this.lowJaw_flat.setRotationPoint(0.0F, -1.0F, -6.5F);
		this.lowJaw_flat.addBox(-3.0F, -1.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.rLeg3 = new ModelRenderer(this, 25, 67);
		this.rLeg3.mirror = true;
		this.rLeg3.setRotationPoint(0.0F, 9.0F, 4.5F);
		this.rLeg3.addBox(-2.5F, 0.0F, -4.0F, 5.0F, 10.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rLeg3, -0.9105382388075086F, 0.0F, 0.0F);
		this.lFoot = new ModelRenderer(this, 0, 93);
		this.lFoot.setRotationPoint(0.0F, 9.0F, -2.0F);
		this.lFoot.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lFoot, 0.2275909337942703F, 0.0F, 0.0F);
		this.rArm1 = new ModelRenderer(this, 26, 51);
		this.rArm1.mirror = true;
		this.rArm1.setRotationPoint(-2.0F, 4.0F, 0.0F);
		this.rArm1.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.topJaw = new ModelRenderer(this, 0, 114);
		this.topJaw.setRotationPoint(0.0F, -4.0F, -6.8F);
		this.topJaw.addBox(-3.5F, -2.0F, -5.0F, 7.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F);
		this.rHorn3 = new ModelRenderer(this, 16, 131);
		this.rHorn3.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.rHorn3.addBox(-1.5F, -4.0F, -3.0F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn3, 0.500909508638178F, 0.0F, 0.0F);
		this.rLeg1_flat = new ModelRenderer(this, 20, 62);
		this.rLeg1_flat.setRotationPoint(-3.5F, -0.3F, 3.0F);
		this.rLeg1_flat.addBox(-3.0F, 0.0F, -3.5F, 2.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.rHorn2 = new ModelRenderer(this, 0, 131);
		this.rHorn2.setRotationPoint(0.0F, -2.0F, 2.0F);
		this.rHorn2.addBox(-2.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn2, 0.6829473549475088F, 0.0F, -0.4098033003787853F);
		this.lLeg1_flat.addChild(this.lLeg1);
		this.lHorn1.addChild(this.lHorn2);
		this.chest.addChild(this.lShoulder);
		this.rLeg1_flat.addChild(this.rLeg1);
		this.lLeg2.addChild(this.lLeg3);
		this.chest.addChild(this.leftPec);
		this.chest.addChild(this.rightPec);
		this.lLeg1.addChild(this.lLeg2);
		this.rLeg1.addChild(this.rLeg2);
		this.head.addChild(this.lHorn1);
		this.neck.addChild(this.head);
		this.head.addChild(this.rHorn1);
		this.chest.addChild(this.rShoulder);
		this.chest.addChild(this.neck);
		this.rMHorn1.addChild(this.rMHorn2);
		this.rArm1.addChild(this.rArm2);
		this.topJaw.addChild(this.snout);
		this.lowJaw.addChild(this.lMHorn1);
		this.thighs.addChild(this.chest);
		this.rHorn3.addChild(this.rHorn4);
		this.lHorn3.addChild(this.lHorn4);
		this.lowJaw_flat.addChild(this.lowJaw);
		this.lowJaw.addChild(this.rMHorn1);
		this.lMHorn1.addChild(this.lMHorn2);
		this.lHorn2.addChild(this.lHorn3);
		this.lShoulder.addChild(this.lArm1);
		this.rLeg3.addChild(this.rFoot);
		this.lArm1.addChild(this.lArm2);
		this.head.addChild(this.lowJaw_flat);
		this.rLeg2.addChild(this.rLeg3);
		this.lLeg3.addChild(this.lFoot);
		this.rShoulder.addChild(this.rArm1);
		this.head.addChild(this.topJaw);
		this.rHorn2.addChild(this.rHorn3);
		this.rHorn1.addChild(this.rHorn2);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.rLeg1_flat, this.thighs, this.lLeg1_flat).forEach((modelRenderer) -> {
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
		this.lowJaw_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.0F * limbSwingAmount / 1.3F;
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}