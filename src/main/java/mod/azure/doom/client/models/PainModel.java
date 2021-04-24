package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.tierheavy.PainEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class PainModel extends AnimatedGeoModel<PainEntity> {

	private static final ResourceLocation NORMAL = new ResourceLocation(DoomMod.MODID,
			"textures/entity/painelemental-normal.png");
	private static final ResourceLocation ATTACKING = new ResourceLocation(DoomMod.MODID,
			"textures/entity/painelemental-attacking.png");

	public PainModel() {
	}

	@Override
	public ResourceLocation getModelLocation(PainEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/pain.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(PainEntity object) {
		return object.isAttacking() ? ATTACKING : NORMAL;
	}

	@Override
	public ResourceLocation getAnimationFileLocation(PainEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/pain_animation.json");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setLivingAnimations(PainEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("body");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}