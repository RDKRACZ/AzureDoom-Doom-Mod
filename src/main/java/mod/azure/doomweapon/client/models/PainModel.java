package mod.azure.doomweapon.client.models;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PainModel<T extends Entity> extends SegmentedModel<T> {
	private final ImmutableList<ModelRenderer> field_228260_b_;

	public PainModel() {
		Builder<ModelRenderer> builder = ImmutableList.builder();
		ModelRenderer modelrenderer = new ModelRenderer(this, 0, 0);
		modelrenderer.addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F);
		modelrenderer.rotationPointY = 17.6F;
		builder.add(modelrenderer);
		this.field_228260_b_ = builder.build();
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {

	}

	public Iterable<ModelRenderer> getParts() {
		return this.field_228260_b_;
	}
}