package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.tiersuperheavy.FireBaronEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class FireBaronModel extends AnimatedGeoModel<FireBaronEntity> {

	@Override
	public ResourceLocation getModelLocation(FireBaronEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/firebaron.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(FireBaronEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/firebaron.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(FireBaronEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/firebaron.animation.json");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setLivingAnimations(FireBaronEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("neck");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX((extraData.headPitch + 20) * ((float) Math.PI / 360F));
		head.setRotationY((extraData.netHeadYaw) * ((float) Math.PI / 340F));
	}
}