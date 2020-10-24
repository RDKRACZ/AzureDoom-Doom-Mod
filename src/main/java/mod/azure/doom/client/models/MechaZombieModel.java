package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.MechaZombieEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class MechaZombieModel extends AnimatedEntityModel<MechaZombieEntity> {

	private final AnimatedModelRenderer bone;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer left_arm;
	private final AnimatedModelRenderer cannon;
	private final AnimatedModelRenderer left_leg;
	private final AnimatedModelRenderer left_foreleg;
	private final AnimatedModelRenderer right_arm;
	private final AnimatedModelRenderer forearm;
	private final AnimatedModelRenderer right_leg;
	private final AnimatedModelRenderer right_foreleg;

	public MechaZombieModel() {
		textureWidth = 128;
		textureHeight = 128;
		bone = new AnimatedModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone, 0.0F, 3.1416F, 0.0F);

		bone.setModelRendererName("bone");
		this.registerModelRenderer(bone);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, -41.0F, 3.0F);
		bone.addChild(head);
		head.setTextureOffset(24, 63).addBox(-3.0F, -3.6F, -6.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(62, 54).addBox(1.3F, -3.7F, -6.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(62, 62).addBox(-2.2F, -3.5F, -6.7F, 4.0F, 3.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(53, 0).addBox(-3.6F, -9.2F, -1.2F, 6.0F, 5.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-3.5F, -9.1F, -7.3F, 6.0F, 5.0F, 7.0F, 0.0F, false);
		head.setTextureOffset(19, 0).addBox(-2.4F, -3.6F, -1.6F, 4.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(24, 18).addBox(-2.3F, -3.5F, -3.1F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(42, 58).addBox(2.1F, -8.5F, -6.5F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(32, 55).addBox(-3.8F, -8.5F, -6.5F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(42, 8).addBox(-2.2F, -0.6F, -5.1F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(32, 63).addBox(-4.9F, -5.2F, -6.3F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(3.4F, -5.2F, -6.3F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(-0.6F, -25.6F, 5.0F);
		bone.addChild(body);
		body.setTextureOffset(16, 33).addBox(-3.5F, -5.5F, -7.8F, 7.0F, 6.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(0, 12).addBox(-3.9F, -15.0F, -8.4F, 8.0F, 9.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(21, 22).addBox(-4.4F, -14.4F, -7.6F, 9.0F, 8.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(38, 38).addBox(-4.3F, -14.4F, -4.3F, 9.0F, 9.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(45, 22).addBox(-2.6F, 0.8F, -7.5F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(36, 63).addBox(-0.3F, -1.1F, -4.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(50, 13).addBox(-2.9F, -14.9F, -8.7F, 6.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(53, 28).addBox(-2.3F, -1.4F, -8.7F, 5.0F, 3.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(54, 54).addBox(-0.8F, -13.3F, -8.8F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		body.setModelRendererName("body");
		this.registerModelRenderer(body);

		left_arm = new AnimatedModelRenderer(this);
		left_arm.setRotationPoint(6.0F, -40.2F, 5.6F);
		bone.addChild(left_arm);
		left_arm.setTextureOffset(57, 6).addBox(-1.3F, -0.4F, -8.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		left_arm.setTextureOffset(10, 55).addBox(-1.2F, 3.1F, -7.8F, 2.0F, 7.0F, 3.0F, 0.0F, false);
		left_arm.setModelRendererName("left_arm");
		this.registerModelRenderer(left_arm);

		cannon = new AnimatedModelRenderer(this);
		cannon.setRotationPoint(0.5F, 9.0F, 0.4F);
		left_arm.addChild(cannon);
		cannon.setTextureOffset(38, 48).addBox(-2.0F, -0.3F, -9.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		cannon.setTextureOffset(58, 38).addBox(-1.5F, 7.6F, -8.3F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cannon.setTextureOffset(55, 17).addBox(-1.5F, 9.9F, -8.3F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cannon.setTextureOffset(0, 62).addBox(-1.6F, 8.4F, -8.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		cannon.setTextureOffset(58, 33).addBox(-1.6F, 10.8F, -8.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cannon.setTextureOffset(58, 43).addBox(-1.7F, 5.5F, -8.4F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		cannon.setModelRendererName("cannon");
		this.registerModelRenderer(cannon);

		left_leg = new AnimatedModelRenderer(this);
		left_leg.setRotationPoint(3.4F, -25.0F, 6.3F);
		bone.addChild(left_leg);
		left_leg.setTextureOffset(26, 0).addBox(-2.7F, -0.3F, -9.3F, 4.0F, 14.0F, 4.0F, 0.0F, false);
		left_leg.setModelRendererName("left_leg");
		this.registerModelRenderer(left_leg);

		left_foreleg = new AnimatedModelRenderer(this);
		left_foreleg.setRotationPoint(0.0F, 15.5F, 0.0F);
		left_leg.addChild(left_foreleg);
		left_foreleg.setTextureOffset(37, 13).addBox(-2.8F, -3.7F, -9.6F, 4.0F, 4.0F, 5.0F, 0.0F, false);
		left_foreleg.setTextureOffset(24, 43).addBox(-2.5F, 0.8F, -9.4F, 3.0F, 8.0F, 4.0F, 0.0F, false);
		left_foreleg.setTextureOffset(42, 0).addBox(-2.4F, 8.1F, -9.8F, 2.0F, 1.0F, 7.0F, 0.0F, false);
		left_foreleg.setTextureOffset(20, 63).addBox(-1.8F, -2.7F, -5.1F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		left_foreleg.setTextureOffset(38, 0).addBox(-3.1F, -2.1F, -7.6F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		left_foreleg.setModelRendererName("left_foreleg");
		this.registerModelRenderer(left_foreleg);

		right_arm = new AnimatedModelRenderer(this);
		right_arm.setRotationPoint(-6.8F, -40.7F, 6.0F);
		bone.addChild(right_arm);
		right_arm.setTextureOffset(20, 55).addBox(-1.4F, 3.6F, -8.2F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		right_arm.setTextureOffset(0, 43).addBox(-1.4F, 9.5F, -8.6F, 2.0F, 14.0F, 3.0F, 0.0F, false);
		right_arm.setTextureOffset(19, 3).addBox(-0.9F, 9.9F, -9.3F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		right_arm.setTextureOffset(20, 43).addBox(-1.8F, 18.85F, -7.7F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		right_arm.setTextureOffset(54, 48).addBox(-1.4F, 0.1F, -8.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		right_arm.setModelRendererName("right_arm");
		this.registerModelRenderer(right_arm);

		forearm = new AnimatedModelRenderer(this);
		forearm.setRotationPoint(0.5F, 18.0F, 0.0F);
		right_arm.addChild(forearm);

		forearm.setModelRendererName("forearm");
		this.registerModelRenderer(forearm);

		right_leg = new AnimatedModelRenderer(this);
		right_leg.setRotationPoint(-2.8F, -25.0F, 6.3F);
		bone.addChild(right_leg);
		right_leg.setTextureOffset(0, 25).addBox(-2.1F, -0.3F, -9.3F, 4.0F, 14.0F, 4.0F, 0.0F, false);
		right_leg.setModelRendererName("right_leg");
		this.registerModelRenderer(right_leg);

		right_foreleg = new AnimatedModelRenderer(this);
		right_foreleg.setRotationPoint(0.7F, 19.4F, 0.0F);
		right_leg.addChild(right_foreleg);
		right_foreleg.setTextureOffset(40, 28).addBox(-2.7F, -7.6F, -9.5F, 4.0F, 5.0F, 5.0F, 0.0F, false);
		right_foreleg.setTextureOffset(10, 43).addBox(-2.3F, -3.2F, -9.3F, 3.0F, 8.0F, 4.0F, 0.0F, false);
		right_foreleg.setTextureOffset(38, 2).addBox(-3.0F, -6.0F, -7.6F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		right_foreleg.setTextureOffset(16, 25).addBox(-1.4F, -6.3F, -5.1F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		right_foreleg.setModelRendererName("right_foreleg");
		this.registerModelRenderer(right_foreleg);

		this.rootBones.add(bone);
	}

	@Override
	public ResourceLocation getAnimationFileLocation() {
		return new ResourceLocation(DoomMod.MODID, "animations/mechazombie_animation.json");
	}
}