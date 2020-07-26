package mod.azure.doomweapon.client.models;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.IFlinging;
import net.minecraft.util.math.MathHelper;

public class PinkyModel<T extends MobEntity & IFlinging> extends AgeableModel<T> {
	private final ModelRenderer pinkyHorn2;
	private final ModelRenderer pinkyBody;
	private final ModelRenderer field_239110_h_;
	private final ModelRenderer field_239111_i_;
	private final ModelRenderer field_239112_j_;
	private final ModelRenderer field_239113_k_;

	public PinkyModel() {
		super(true, 8.0F, 6.0F, 1.9F, 2.0F, 24.0F);
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.pinkyBody = new ModelRenderer(this);
		this.pinkyBody.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.pinkyBody.setTextureOffset(1, 1).addBox(-8.0F, -7.0F, -13.0F, 16.0F, 14.0F, 26.0F);
		this.pinkyHorn2 = new ModelRenderer(this);
		this.pinkyHorn2.setRotationPoint(0.0F, 2.0F, -12.0F);
		this.pinkyHorn2.setTextureOffset(61, 1).addBox(-7.0F, -3.0F, -19.0F, 14.0F, 6.0F, 19.0F);
		this.pinkyHorn2.rotateAngleX = 0.87266463F;
		this.field_239110_h_ = new ModelRenderer(this);
		this.field_239110_h_.setRotationPoint(-4.0F, 10.0F, -8.5F);
		this.field_239110_h_.setTextureOffset(66, 42).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F);
		this.field_239111_i_ = new ModelRenderer(this);
		this.field_239111_i_.setRotationPoint(4.0F, 10.0F, -8.5F);
		this.field_239111_i_.setTextureOffset(41, 42).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F);
		this.field_239112_j_ = new ModelRenderer(this);
		this.field_239112_j_.setRotationPoint(-5.0F, 13.0F, 10.0F);
		this.field_239112_j_.setTextureOffset(21, 45).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 11.0F, 5.0F);
		this.field_239113_k_ = new ModelRenderer(this);
		this.field_239113_k_.setRotationPoint(5.0F, 13.0F, 10.0F);
		this.field_239113_k_.setTextureOffset(0, 45).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 11.0F, 5.0F);
	}

	protected Iterable<ModelRenderer> getHeadParts() {
		return ImmutableList.of(this.pinkyHorn2);
	}

	protected Iterable<ModelRenderer> getBodyParts() {
		return ImmutableList.of(this.pinkyBody, this.field_239110_h_, this.field_239111_i_, this.field_239112_j_,
				this.field_239113_k_);
	}

	/**
	 * Sets this entity's model rotation angles
	 */
	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		this.pinkyHorn2.rotateAngleY = 0.0F;
		int i = entityIn.func_230290_eL_();
		float f = 1.0F - (float) MathHelper.abs(10 - 2 * i) / 10.0F;
		this.pinkyHorn2.rotateAngleX =  70.0F;
		this.field_239110_h_.rotateAngleX = MathHelper.cos(limbSwing) * 1.2F * limbSwingAmount;
		this.field_239111_i_.rotateAngleX = MathHelper.cos(limbSwing + (float) Math.PI) * 1.2F * limbSwingAmount;
		this.field_239112_j_.rotateAngleX = this.field_239111_i_.rotateAngleX;
		this.field_239113_k_.rotateAngleX = this.field_239110_h_.rotateAngleX;
	}
}