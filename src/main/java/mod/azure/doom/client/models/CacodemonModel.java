package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.tierheavy.CacodemonEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class CacodemonModel extends AnimatedGeoModel<CacodemonEntity> {

	public CacodemonModel() {
	}

	@Override
	public ResourceLocation getModelLocation(CacodemonEntity object) {
		return new ResourceLocation(DoomMod.MODID, "geo/cacodemon.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(CacodemonEntity object) {
		return new ResourceLocation(DoomMod.MODID, "textures/entity/cacodemon.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(CacodemonEntity object) {
		return new ResourceLocation(DoomMod.MODID, "animations/cacodemon_animation.json");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setLivingAnimations(CacodemonEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("body");

		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}