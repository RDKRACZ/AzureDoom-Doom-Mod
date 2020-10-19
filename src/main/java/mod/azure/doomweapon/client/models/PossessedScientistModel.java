package mod.azure.doomweapon.client.models;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.PossessedScientistEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class PossessedScientistModel extends AnimatedEntityModel<PossessedScientistEntity> {

	private final AnimatedModelRenderer Main;
	private final AnimatedModelRenderer Head;
	private final AnimatedModelRenderer Body;
	private final AnimatedModelRenderer Right_Leg;
	private final AnimatedModelRenderer lower_right_leg;
	private final AnimatedModelRenderer Right_arm;
	private final AnimatedModelRenderer lower_right_arm;
	private final AnimatedModelRenderer Left_leg;
	private final AnimatedModelRenderer lower_left_leg;
	private final AnimatedModelRenderer Left_arm;
	private final AnimatedModelRenderer lower_left_arm;

	public PossessedScientistModel() {
		textureWidth = 128;
		textureHeight = 128;
		Main = new AnimatedModelRenderer(this);
		Main.setRotationPoint(0.0F, 29.0F, -4.0F);

		Main.setModelRendererName("Main");
		this.registerModelRenderer(Main);

		Head = new AnimatedModelRenderer(this);
		Head.setRotationPoint(0.0F, -52.0F, 3.0F);
		Main.addChild(Head);
		Head.setTextureOffset(0, 20).addBox(-4.6F, -7.075F, -3.5F, 9.0F, 6.0F, 9.0F, 0.0F, false);
		Head.setTextureOffset(38, 42).addBox(-3.6F, -0.1F, -4.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(38, 44).addBox(-2.6F, -1.1F, -4.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(70, 0).addBox(2.4F, -0.1F, -3.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(54, 39).addBox(3.4F, 0.9F, -4.5F, 0.0F, 1.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(14, 53).addBox(3.4F, 2.6F, -4.5F, 0.0F, 1.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(68, 60).addBox(-3.6F, -0.1F, -3.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(14, 54).addBox(-3.5F, 0.9F, -4.5F, 0.0F, 1.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(53, 38).addBox(-3.6F, 2.6F, -4.5F, 0.0F, 1.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(0, 58).addBox(-3.6F, 0.9F, -4.5F, 7.0F, 1.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(0, 57).addBox(-3.6F, 2.6F, -4.5F, 7.0F, 1.0F, 0.0F, 0.0F, false);
		Head.setTextureOffset(66, 45).addBox(-3.6F, 3.6F, -4.5F, 7.0F, 1.0F, 5.0F, 0.0F, false);
		Head.setTextureOffset(46, 64).addBox(-2.6F, 3.5F, -0.5F, 5.0F, 1.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(66, 51).addBox(-3.6F, -1.5F, 1.5F, 7.0F, 6.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(46, 61).addBox(-4.6F, -7.1F, -4.5F, 9.0F, 2.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(22, 44).addBox(-2.7F, -2.1F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(67, 70).addBox(3.1F, -1.1F, -3.5F, 1.0F, 5.0F, 7.0F, 0.0F, false);
		Head.setTextureOffset(45, 70).addBox(-4.325F, -1.1F, -3.5F, 1.0F, 5.0F, 7.0F, 0.0F, false);
		Head.setTextureOffset(22, 42).addBox(1.5F, -2.1F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(54, 67).addBox(-4.6F, -5.1F, -4.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(27, 20).addBox(4.4F, -3.1F, 2.3F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(27, 20).addBox(-5.6F, -3.1F, 2.3F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(38, 59).addBox(2.4F, -5.1F, -4.5F, 2.0F, 5.0F, 1.0F, 0.0F, false);
		Head.setModelRendererName("Head");
		this.registerModelRenderer(Head);

		Body = new AnimatedModelRenderer(this);
		Body.setRotationPoint(0.4F, -47.7F, 3.0F);
		Main.addChild(Body);
		Body.setTextureOffset(0, 0).addBox(-7.0F, 0.0F, -2.4F, 13.0F, 14.0F, 6.0F, 0.0F, false);
		Body.setTextureOffset(0, 1).addBox(0.0F, 11.8F, 3.6F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 1).addBox(-3.0F, 12.8F, 3.6F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 1).addBox(-5.0F, 11.8F, 3.6F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 1).addBox(3.0F, 11.0F, 3.6F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 1).addBox(-6.0F, 10.8F, 3.6F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(0, 1).addBox(-6.0F, 8.8F, 4.6F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 1).addBox(-5.0F, 7.8F, 4.6F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 59).addBox(-6.0F, 0.0F, -3.3F, 11.0F, 11.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(38, 18).addBox(-6.0F, 0.0F, 3.6F, 11.0F, 11.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 54).addBox(-5.0F, 11.0F, -3.3F, 10.0F, 2.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(4, 20).addBox(-6.9F, 1.1F, -3.3F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(0, 0).addBox(-6.9F, 8.1F, -4.3F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(0, 36).addBox(-6.0F, 11.0F, -4.3F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(60, 45).addBox(-5.1F, 12.9F, -4.3F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(0, 71).addBox(-5.0F, 0.8F, 4.6F, 9.0F, 7.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(32, 0).addBox(2.0F, 12.9F, -4.3F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(0, 20).addBox(5.0F, 1.1F, -3.3F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(38, 46).addBox(-3.0F, 13.0F, -3.3F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		Body.setTextureOffset(30, 30).addBox(-6.0F, 14.0F, -2.4F, 11.0F, 6.0F, 6.0F, 0.0F, false);
		Body.setModelRendererName("Body");
		this.registerModelRenderer(Body);

		Right_Leg = new AnimatedModelRenderer(this);
		Right_Leg.setRotationPoint(3.0F, -28.0F, 3.5F);
		Main.addChild(Right_Leg);
		Right_Leg.setTextureOffset(22, 42).addBox(-2.6F, 0.2F, -2.9F, 5.0F, 11.0F, 6.0F, 0.0F, false);
		Right_Leg.setTextureOffset(60, 60).addBox(2.4F, 0.8F, -2.9F, 1.0F, 11.0F, 6.0F, 0.0F, false);
		Right_Leg.setTextureOffset(38, 61).addBox(-3.5F, 1.5F, -2.9F, 1.0F, 10.0F, 6.0F, 0.0F, false);
		Right_Leg.setModelRendererName("Right_Leg");
		this.registerModelRenderer(Right_Leg);

		lower_right_leg = new AnimatedModelRenderer(this);
		lower_right_leg.setRotationPoint(-0.7F, 12.2F, 0.1F);
		Right_Leg.addChild(lower_right_leg);
		lower_right_leg.setTextureOffset(0, 36).addBox(-2.0F, -1.0F, -3.0F, 5.0F, 12.0F, 6.0F, 0.0F, false);
		lower_right_leg.setModelRendererName("lower_right_leg");
		this.registerModelRenderer(lower_right_leg);

		Right_arm = new AnimatedModelRenderer(this);
		Right_arm.setRotationPoint(8.3F, -47.4F, 3.2F);
		Main.addChild(Right_arm);
		Right_arm.setTextureOffset(62, 17).addBox(-1.9F, -0.1F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);
		Right_arm.setTextureOffset(38, 78).addBox(2.1F, -1.1F, -2.0F, 1.0F, 6.0F, 4.0F, 0.0F, false);
		Right_arm.setTextureOffset(0, 79).addBox(-0.9F, -1.1F, -2.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		Right_arm.setModelRendererName("Right_arm");
		this.registerModelRenderer(Right_arm);

		lower_right_arm = new AnimatedModelRenderer(this);
		lower_right_arm.setRotationPoint(0.0F, 10.0F, 0.0F);
		Right_arm.addChild(lower_right_arm);
		lower_right_arm.setTextureOffset(24, 59).addBox(-1.4F, -0.2F, -2.0F, 3.0F, 13.0F, 4.0F, 0.0F, false);
		lower_right_arm.setTextureOffset(28, 76).addBox(-2.4F, -0.1F, -2.0F, 1.0F, 8.0F, 4.0F, 0.0F, false);
		lower_right_arm.setTextureOffset(76, 26).addBox(2.6F, 2.6F, -3.0F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		lower_right_arm.setTextureOffset(76, 60).addBox(1.6F, -0.1F, -2.0F, 1.0F, 9.0F, 4.0F, 0.0F, false);
		lower_right_arm.setTextureOffset(56, 77).addBox(2.6F, 6.9F, -3.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		lower_right_arm.setTextureOffset(78, 13).addBox(-2.4F, -0.1F, -3.0F, 5.0F, 8.0F, 1.0F, 0.0F, false);
		lower_right_arm.setModelRendererName("lower_right_arm");
		this.registerModelRenderer(lower_right_arm);

		Left_leg = new AnimatedModelRenderer(this);
		Left_leg.setRotationPoint(-3.0F, -28.0F, 3.5F);
		Main.addChild(Left_leg);
		Left_leg.setTextureOffset(44, 44).addBox(-2.6F, 0.2F, -2.9F, 5.0F, 11.0F, 6.0F, 0.0F, false);
		Left_leg.setModelRendererName("Left_leg");
		this.registerModelRenderer(Left_leg);

		lower_left_leg = new AnimatedModelRenderer(this);
		lower_left_leg.setRotationPoint(0.0F, 0.0F, 0.0F);
		Left_leg.addChild(lower_left_leg);
		lower_left_leg.setTextureOffset(38, 0).addBox(-2.6F, 11.2F, -2.9F, 5.0F, 12.0F, 6.0F, 0.0F, false);
		lower_left_leg.setTextureOffset(80, 34).addBox(-3.5F, 15.4F, -3.9F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		lower_left_leg.setTextureOffset(14, 73).addBox(-3.5F, 13.5F, -2.9F, 1.0F, 6.0F, 6.0F, 0.0F, false);
		lower_left_leg.setTextureOffset(16, 36).addBox(-3.5F, 14.4F, 3.0F, 6.0F, 5.0F, 1.0F, 0.0F, false);
		lower_left_leg.setModelRendererName("lower_left_leg");
		this.registerModelRenderer(lower_left_leg);

		Left_arm = new AnimatedModelRenderer(this);
		Left_arm.setRotationPoint(-8.6F, -44.7F, 3.6F);
		Main.addChild(Left_arm);
		Left_arm.setTextureOffset(64, 31).addBox(-2.0F, -2.8F, -2.4F, 4.0F, 10.0F, 4.0F, 0.0F, false);
		Left_arm.setTextureOffset(27, 20).addBox(-3.0F, -3.8F, -2.4F, 1.0F, 5.0F, 4.0F, 0.0F, false);
		Left_arm.setTextureOffset(79, 79).addBox(-2.0F, -3.8F, -2.4F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		Left_arm.setTextureOffset(58, 31).addBox(-3.0F, -3.8F, -3.4F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		Left_arm.setModelRendererName("Left_arm");
		this.registerModelRenderer(Left_arm);

		lower_left_arm = new AnimatedModelRenderer(this);
		lower_left_arm.setRotationPoint(0.0F, 8.0F, 0.0F);
		Left_arm.addChild(lower_left_arm);
		lower_left_arm.setTextureOffset(60, 0).addBox(-1.0F, -0.9F, -2.4F, 3.0F, 13.0F, 4.0F, 0.0F, false);
		lower_left_arm.setTextureOffset(74, 0).addBox(-2.9F, -1.0F, -2.4F, 2.0F, 9.0F, 4.0F, 0.0F, false);
		lower_left_arm.setModelRendererName("lower_left_arm");
		this.registerModelRenderer(lower_left_arm);

		this.rootBones.add(Main);
	}

	@Override
	public ResourceLocation getAnimationFileLocation() {
		return new ResourceLocation(DoomMod.MODID, "animations/possessed_scientist_animation.json");
	}
}