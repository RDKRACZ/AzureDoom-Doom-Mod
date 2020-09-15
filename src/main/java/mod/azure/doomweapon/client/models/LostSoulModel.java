package mod.azure.doomweapon.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class LostSoulModel<T extends Entity> extends EntityModel<T> {
	public ModelRenderer head;
	public ModelRenderer smallFlame02;
	public ModelRenderer smallFlame04;
	public ModelRenderer flame01;
	public ModelRenderer flame02;
	public ModelRenderer smallFlame03;
	public ModelRenderer Jaw_flat;
	public ModelRenderer smallFlame05;
	public ModelRenderer smallFlame01;
	public ModelRenderer flame03;
	public ModelRenderer lHorn1;
	public ModelRenderer rHorn1;
	public ModelRenderer Jaw;
	public ModelRenderer lHorn2;
	public ModelRenderer lHorn3;
	public ModelRenderer lHorn4;
	public ModelRenderer rHorn2;
	public ModelRenderer rHorn3;
	public ModelRenderer rHorn4;

	public LostSoulModel() {
		this.textureWidth = 64;
		this.textureHeight = 64;
		this.smallFlame04 = new ModelRenderer(this, 21, 40);
		this.smallFlame04.setRotationPoint(1.8F, -1.4F, 0.3F);
		this.smallFlame04.addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(smallFlame04, 1.0471975511965976F, 0.0F, 0.6283185307179586F);
		this.lHorn3 = new ModelRenderer(this, 20, 14);
		this.lHorn3.mirror = true;
		this.lHorn3.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.lHorn3.addBox(-0.5F, 0.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn3, -0.7428121536172364F, 0.0F, 0.0F);
		this.rHorn3 = new ModelRenderer(this, 20, 14);
		this.rHorn3.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.rHorn3.addBox(-0.5F, 0.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn3, -0.7428121536172364F, 0.0F, 0.0F);
		this.flame01 = new ModelRenderer(this, -16, 22);
		this.flame01.setRotationPoint(0.0F, 1.4F, 0.9F);
		this.flame01.addBox(-5.0F, 0.0F, 0.0F, 10.0F, 0.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(flame01, 1.3962634015954636F, -0.2617993877991494F, 0.15707963267948966F);
		this.smallFlame03 = new ModelRenderer(this, 21, 40);
		this.smallFlame03.setRotationPoint(-0.7F, 1.5F, 3.1F);
		this.smallFlame03.addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(smallFlame03, 1.1616911075168483F, 0.0F, 0.0F);
		this.Jaw_flat = new ModelRenderer(this, 32, 0);
		this.Jaw_flat.setRotationPoint(0.0F, 0.0F, 4.0F);
		this.Jaw_flat.addBox(-3.5F, 0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		this.lHorn1 = new ModelRenderer(this, 0, 14);
		this.lHorn1.mirror = true;
		this.lHorn1.setRotationPoint(3.0F, -4.0F, 0.0F);
		this.lHorn1.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn1, 0.3127630032889644F, 0.0F, -1.8769270935736684F);
		this.Jaw = new ModelRenderer(this, 32, 0);
		this.Jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Jaw.addBox(-3.5F, 0.0F, -8.0F, 7.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(Jaw, 0.3909537457888271F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, 18.0F, 0.0F);
		this.head.addBox(-4.0F, -6.0F, -4.0F, 8.0F, 6.0F, 8.0F, 0.0F, 0.0F, 0.0F);
		this.flame02 = new ModelRenderer(this, 6, 22);
		this.flame02.setRotationPoint(0.0F, 1.4F, 0.9F);
		this.flame02.addBox(-5.0F, 0.0F, 0.0F, 10.0F, 0.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(flame02, 1.3962634015954636F, 0.2617993877991494F, -0.15707963267948966F);
		this.smallFlame01 = new ModelRenderer(this, -13, 40);
		this.smallFlame01.setRotationPoint(-0.7F, -0.6F, -1.6F);
		this.smallFlame01.addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(smallFlame01, 1.3962634015954636F, -0.19198621771937624F, -0.15707963267948966F);
		this.flame03 = new ModelRenderer(this, 27, 22);
		this.flame03.setRotationPoint(0.0F, -3.4F, 2.1F);
		this.flame03.addBox(-5.0F, 0.0F, 0.0F, 10.0F, 0.0F, 16.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(flame03, 1.1519173063162573F, 0.0F, 0.0F);
		this.rHorn4 = new ModelRenderer(this, 26, 14);
		this.rHorn4.setRotationPoint(0.1F, 4.0F, 0.0F);
		this.rHorn4.addBox(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn4, -0.7819074915776542F, 0.0F, 0.0F);
		this.smallFlame05 = new ModelRenderer(this, -13, 40);
		this.smallFlame05.setRotationPoint(-1.8F, -1.4F, 0.3F);
		this.smallFlame05.addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(smallFlame05, 1.0471975511965976F, 0.0F, -0.6283185307179586F);
		this.lHorn2 = new ModelRenderer(this, 12, 14);
		this.lHorn2.mirror = true;
		this.lHorn2.setRotationPoint(0.0F, 4.0F, 1.5F);
		this.lHorn2.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn2, -0.7037167490777915F, 0.0F, 0.0F);
		this.lHorn4 = new ModelRenderer(this, 26, 14);
		this.lHorn4.mirror = true;
		this.lHorn4.setRotationPoint(-0.1F, 4.0F, 0.0F);
		this.lHorn4.addBox(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(lHorn4, -0.7820820617871088F, 0.0F, 0.0F);
		this.rHorn1 = new ModelRenderer(this, 0, 14);
		this.rHorn1.setRotationPoint(-2.0F, -4.0F, 0.0F);
		this.rHorn1.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn1, 0.3127630032889644F, 0.0F, 1.8767525233642137F);
		this.smallFlame02 = new ModelRenderer(this, 4, 40);
		this.smallFlame02.setRotationPoint(-0.7F, -0.6F, -1.6F);
		this.smallFlame02.addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 13.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(smallFlame02, 1.3962634015954636F, 0.19198621771937624F, 0.15707963267948966F);
		this.rHorn2 = new ModelRenderer(this, 12, 14);
		this.rHorn2.setRotationPoint(0.0F, 4.0F, 1.5F);
		this.rHorn2.addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
		this.setRotateAngle(rHorn2, -0.7037167490777915F, 0.0F, 0.0F);
		this.head.addChild(this.smallFlame04);
		this.lHorn2.addChild(this.lHorn3);
		this.rHorn2.addChild(this.rHorn3);
		this.head.addChild(this.flame01);
		this.head.addChild(this.smallFlame03);
		this.head.addChild(this.Jaw_flat);
		this.head.addChild(this.lHorn1);
		this.Jaw_flat.addChild(this.Jaw);
		this.head.addChild(this.flame02);
		this.head.addChild(this.smallFlame01);
		this.head.addChild(this.flame03);
		this.rHorn3.addChild(this.rHorn4);
		this.head.addChild(this.smallFlame05);
		this.lHorn1.addChild(this.lHorn2);
		this.lHorn3.addChild(this.lHorn4);
		this.head.addChild(this.rHorn1);
		this.head.addChild(this.smallFlame02);
		this.rHorn1.addChild(this.rHorn2);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float alpha) {
		ImmutableList.of(this.head).forEach((modelRenderer) -> {
			modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		});
	}

	public void renderFlame(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn,
			int packedOverlayIn) {
		this.smallFlame01.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		this.smallFlame02.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		this.smallFlame03.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		this.smallFlame04.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		this.smallFlame05.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
	}

	@Override
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.Jaw_flat.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.4F * limbSwingAmount
				/ 1.0F;
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}