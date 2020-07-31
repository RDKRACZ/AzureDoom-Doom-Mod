package mod.azure.doomweapon.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class PainModel<T extends Entity> extends EntityModel<T> {
	public ModelRenderer painBody;
	public ModelRenderer painArmR;
	public ModelRenderer painArmL;
	public ModelRenderer painHornL;
	public ModelRenderer painHornR;
	public ModelRenderer painArmR_1;
	public ModelRenderer painArmL_1;

	public PainModel() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.painArmL = new ModelRenderer(this, 0, 18);
		this.painArmL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.painArmL.addBox(17.9F, -11.0F, -7.7F, 3.0F, 10.0F, 3.0F, 0.0F, -2.6F, 0.0F);
		this.setRotateAngle(painArmL, 0.0F, 0.0F, 1.3638002668557248F);
		this.painArmL_1 = new ModelRenderer(this, 0, 18);
		this.painArmL_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.painArmL_1.addBox(5.3F, -14.1F, -20.9F, 3.0F, 10.0F, 3.0F, 0.0F, -2.6F, -0.1F);
		this.setRotateAngle(painArmL_1, 1.5707963267948966F, 0.0F, -1.5707963267948966F);
		this.painHornL = new ModelRenderer(this, 0, 0);
		this.painHornL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.painHornL.addBox(-7.0F, -15.6F, -7.8F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6F, 0.0F);
		this.setRotateAngle(painHornL, 0.0F, 0.0F, 1.4161601444155547F);
		this.painArmR = new ModelRenderer(this, 0, 18);
		this.painArmR.setRotationPoint(0.0F, 17.6F, 0.0F);
		this.painArmR.addBox(-2.9F, -14.8F, -7.7F, 3.0F, 10.0F, 3.0F, 0.0F, -2.6F, 0.0F);
		this.setRotateAngle(painArmR, 0.0F, 0.0F, -1.3638002668557248F);
		this.painBody = new ModelRenderer(this, 0, 0);
		this.painBody.setRotationPoint(0.0F, 17.6F, 0.0F);
		this.painBody.addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.painHornR = new ModelRenderer(this, 0, 0);
		this.painHornR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.painHornR.addBox(5.0F, -15.6F, -7.7F, 2.0F, 10.0F, 2.0F, 0.0F, -2.6F, 0.0F);
		this.setRotateAngle(painHornR, 0.0F, 0.0F, -1.4161601444155547F);
		this.painArmR_1 = new ModelRenderer(this, 0, 18);
		this.painArmR_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.painArmR_1.addBox(9.0F, -14.5F, -0.1F, 3.0F, 10.0F, 3.0F, 0.0F, -2.6F, -0.1F);
		this.setRotateAngle(painArmR_1, 1.5707963267948966F, 0.0F, -1.5707963267948966F);
		this.painArmL.addChild(this.painArmL_1);
		this.painBody.addChild(this.painHornL);
		this.painBody.addChild(this.painHornR);
		this.painArmR.addChild(this.painArmR_1);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.painArmR.rotateAngleX = MathHelper.cos(limbSwing) * -0.7819074915776542F* limbSwingAmount;
		this.painArmL.rotateAngleX = MathHelper.cos(limbSwing + (float)Math.PI) * -0.7819074915776542F * limbSwingAmount;
		this.painArmR.rotateAngleX = MathHelper.cos(limbSwing) * 0.2F * limbSwingAmount;
		this.painArmL.rotateAngleX = MathHelper.cos(limbSwing) * 0.2F * limbSwingAmount;
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.painArmL, this.painArmR, this.painBody).forEach((modelRenderer) -> {
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}