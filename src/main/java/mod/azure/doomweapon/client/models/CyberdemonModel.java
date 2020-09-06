package mod.azure.doomweapon.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class CyberdemonModel<T extends Entity> extends EntityModel<T> {
	public ModelRenderer field_178723_h;
	public ModelRenderer field_178721_j;
	public ModelRenderer field_78116_c;
	public ModelRenderer field_78115_e;
	public ModelRenderer field_178724_i;
	public ModelRenderer field_178722_k;
	public ModelRenderer hornLeft;
	public ModelRenderer hornRight;
	public ModelRenderer hornLeft_1;
	public ModelRenderer hornLeft_2;
	public ModelRenderer hornRight_1;
	public ModelRenderer hornRight_2;
	public ModelRenderer field_78115_e_1;
	public ModelRenderer field_78115_e_2;
    public ModelRenderer field_78115_reversed;

	public CyberdemonModel(float modelSize, boolean smallArmsIn) {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.hornRight_1 = new ModelRenderer(this, 0, 10);
		this.hornRight_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hornRight_1.addBox(-6.6F, -5.6F, -3.1F, 1.0F, 2.0F, 1.0F, 0.7F, 0.6F, 1.1F);
		this.setRotateAngle(hornRight_1, -0.35185837453889574F, 0.0F, 0.0F);
		this.field_178723_h = new ModelRenderer(this, 40, 16);
		this.field_178723_h.setRotationPoint(-5.0F, 2.0F, 0.0F);
		this.field_178723_h.addBox(-4.7F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.setRotateAngle(field_178723_h, 0.0F, 0.0F, 0.10000000116728046F);
		this.field_78116_c = new ModelRenderer(this, 0, 0);
		this.field_78116_c.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.field_78116_c.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, 0.5F, 0.5F);
		this.field_78115_e_1 = new ModelRenderer(this, 16, 22);
		this.field_78115_e_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.field_78115_e_1.addBox(-3.6F, 5.8F, -2.1F, 8.0F, 5.0F, 4.0F, 1.1F, 0.5F, 0.0F);
        this.field_78115_reversed = new ModelRenderer(this, 16, 22);
        this.field_78115_reversed.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_78115_reversed.addBox(-4.4F, 5.8F, -2.1F, 8.0F, 5.0F, 4.0F, 1.2F, 0.5F, 0.0F);
        this.setRotateAngle(field_78115_reversed, 0.0F, 3.141592653589793F, 0.0F);
		this.field_178724_i = new ModelRenderer(this, 32, 48);
		this.field_178724_i.setRotationPoint(5.0F, 2.0F, 0.0F);
		this.field_178724_i.addBox(1.4F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.setRotateAngle(field_178724_i, 0.0F, 0.0F, -0.10000000116728046F);
		this.hornRight = new ModelRenderer(this, 0, 10);
		this.hornRight.setRotationPoint(12.2F, 0.0F, 0.0F);
		this.hornRight.addBox(-6.6F, -5.6F, 1.0F, 1.0F, 2.0F, 1.0F, 1.1F, 0.7F, 1.2F);
		this.hornLeft_1 = new ModelRenderer(this, 0, 10);
		this.hornLeft_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hornLeft_1.addBox(-6.6F, -5.6F, -3.1F, 1.0F, 2.0F, 1.0F, 0.7F, 0.6F, 1.1F);
		this.setRotateAngle(hornLeft_1, -0.35185837453889574F, 0.0F, 0.0F);
		this.field_178721_j = new ModelRenderer(this, 0, 16);
		this.field_178721_j.setRotationPoint(-1.9F, 12.0F, 0.1F);
		this.field_178721_j.addBox(-2.5F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.field_78115_e = new ModelRenderer(this, 16, 16);
		this.field_78115_e.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.field_78115_e.addBox(-3.6F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, 1.5F, 0.5F, 0.5F);
		this.field_178722_k = new ModelRenderer(this, 16, 48);
		this.field_178722_k.setRotationPoint(1.9F, 12.0F, 0.1F);
		this.field_178722_k.addBox(-0.5F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, 0.5F, 0.5F);
		this.field_78115_e_2 = new ModelRenderer(this, 16, 27);
		this.field_78115_e_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.field_78115_e_2.addBox(-3.6F, 11.0F, -2.0F, 8.0F, 1.0F, 4.0F, 1.5F, 0.5F, 0.7F);
		this.hornRight_2 = new ModelRenderer(this, 0, 10);
		this.hornRight_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hornRight_2.addBox(-6.6F, -4.0F, -7.4F, 1.0F, 2.0F, 1.0F, 0.6F, 0.3F, 2.1F);
		this.setRotateAngle(hornRight_2, -0.35185837453889574F, 0.0F, 0.0F);
		this.hornLeft = new ModelRenderer(this, 0, 10);
		this.hornLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hornLeft.addBox(-6.6F, -5.6F, 1.2F, 1.0F, 2.0F, 1.0F, 1.1F, 0.7F, 1.2F);
		this.hornLeft_2 = new ModelRenderer(this, 0, 10);
		this.hornLeft_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hornLeft_2.addBox(-6.6F, -4.0F, -7.4F, 1.0F, 2.0F, 1.0F, 0.6F, 0.3F, 2.1F);
		this.setRotateAngle(hornLeft_2, -0.35185837453889574F, 0.0F, 0.0F);
		this.hornRight.addChild(this.hornRight_1);
		this.field_78115_e.addChild(this.field_78115_e_1);
		this.field_78116_c.addChild(this.hornRight);
		this.hornLeft.addChild(this.hornLeft_1);
        this.field_78115_e.addChild(this.field_78115_reversed);
		this.field_78115_e.addChild(this.field_78115_e_2);
		this.hornRight_1.addChild(this.hornRight_2);
		this.field_78116_c.addChild(this.hornLeft);
		this.hornLeft_1.addChild(this.hornLeft_2);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.field_178723_h, this.field_78116_c, this.field_178724_i, this.field_178721_j,
				this.field_78115_e, this.field_178722_k).forEach((modelRenderer) -> {
					modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue,
							alpha);
				});
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.field_178723_h.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F
				* limbSwingAmount * 0.5F / 1.0F;
		this.field_178724_i.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / 1.0F;
		this.field_178723_h.rotateAngleZ = 0.0F;
		this.field_178724_i.rotateAngleZ = 0.0F;
		this.field_178721_j.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / 1.0F;
		this.field_178722_k.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F
				* limbSwingAmount / 1.0F;
		this.field_178721_j.rotateAngleY = 0.0F;
		this.field_178722_k.rotateAngleY = 0.0F;
		this.field_178721_j.rotateAngleZ = 0.0F;
		this.field_178722_k.rotateAngleZ = 0.0F;
	}
}