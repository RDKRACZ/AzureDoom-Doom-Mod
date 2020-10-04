package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ImpEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class ImpModel extends AnimatedEntityModel<ImpEntity> {

	private final AnimatedModelRenderer thighs;
	private final AnimatedModelRenderer rLeg1;
	private final AnimatedModelRenderer rLeg2;
	private final AnimatedModelRenderer kneeSpikeR;
	private final AnimatedModelRenderer torso;
	private final AnimatedModelRenderer backSpike2;
	private final AnimatedModelRenderer rShoulder;
	private final AnimatedModelRenderer rShoulderSpike;
	private final AnimatedModelRenderer rArm1;
	private final AnimatedModelRenderer rArm2;
	private final AnimatedModelRenderer rElbowSpike;
	private final AnimatedModelRenderer rArmSpike;
	private final AnimatedModelRenderer lShoulder;
	private final AnimatedModelRenderer lArm1;
	private final AnimatedModelRenderer lArm2;
	private final AnimatedModelRenderer lElbowSpike;
	private final AnimatedModelRenderer lArmSpike;
	private final AnimatedModelRenderer lShoulderSpike;
	private final AnimatedModelRenderer backSpike1;
	private final AnimatedModelRenderer neck;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer chin;
	private final AnimatedModelRenderer browMiddle;
	private final AnimatedModelRenderer lBrow1;
	private final AnimatedModelRenderer lBrow2;
	private final AnimatedModelRenderer rBrow1;
	private final AnimatedModelRenderer rBrow2;
	private final AnimatedModelRenderer rightPec;
	private final AnimatedModelRenderer chestSpikeR;
	private final AnimatedModelRenderer leftPec;
	private final AnimatedModelRenderer chestSpikeL;
	private final AnimatedModelRenderer lLeg1;
	private final AnimatedModelRenderer lLeg2;
	private final AnimatedModelRenderer kneeSpikeL;

	public ImpModel() {
		textureWidth = 60;
		textureHeight = 80;
		thighs = new AnimatedModelRenderer(this);
		thighs.setRotationPoint(0.0F, 5.5F, 0.0F);
		thighs.setTextureOffset(0, 12).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 5.0F, 4.0F, 0.0F, false);
		thighs.setModelRendererName("thighs");
		this.registerModelRenderer(thighs);

		rLeg1 = new AnimatedModelRenderer(this);
		rLeg1.setRotationPoint(1.9F, 5.0F, 0.0F);
		thighs.addChild(rLeg1);
		setRotationAngle(rLeg1, 0.0F, 0.0F, -0.0456F);
		rLeg1.setTextureOffset(0, 21).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		rLeg1.setModelRendererName("rLeg1");
		this.registerModelRenderer(rLeg1);

		rLeg2 = new AnimatedModelRenderer(this);
		rLeg2.setRotationPoint(0.0F, 6.8F, -2.0F);
		rLeg1.addChild(rLeg2);
		setRotationAngle(rLeg2, 0.0911F, 0.0F, 0.0456F);
		rLeg2.setTextureOffset(16, 21).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		rLeg2.setModelRendererName("rLeg2");
		this.registerModelRenderer(rLeg2);

		kneeSpikeR = new AnimatedModelRenderer(this);
		kneeSpikeR.setRotationPoint(0.0F, 0.5F, 1.0F);
		rLeg2.addChild(kneeSpikeR);
		setRotationAngle(kneeSpikeR, -0.6374F, 0.0F, 0.0F);
		kneeSpikeR.setTextureOffset(22, 17).addBox(-0.5F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		kneeSpikeR.setModelRendererName("kneeSpikeR");
		this.registerModelRenderer(kneeSpikeR);

		torso = new AnimatedModelRenderer(this);
		torso.setRotationPoint(0.0F, 0.0F, 1.3F);
		thighs.addChild(torso);
		torso.setTextureOffset(0, 0).addBox(-5.0F, -7.0F, -4.0F, 10.0F, 7.0F, 5.0F, 0.0F, false);
		torso.setModelRendererName("torso");
		this.registerModelRenderer(torso);

		backSpike2 = new AnimatedModelRenderer(this);
		backSpike2.setRotationPoint(3.3F, -5.0F, 0.0F);
		torso.addChild(backSpike2);
		setRotationAngle(backSpike2, 0.9561F, 0.0F, 0.5009F);
		backSpike2.setTextureOffset(30, 5).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		backSpike2.setModelRendererName("backSpike2");
		this.registerModelRenderer(backSpike2);

		rShoulder = new AnimatedModelRenderer(this);
		rShoulder.setRotationPoint(4.0F, -6.0F, -1.9F);
		torso.addChild(rShoulder);
		setRotationAngle(rShoulder, 0.0F, 0.0F, -0.1367F);
		rShoulder.setTextureOffset(16, 32).addBox(-1.0F, -2.0F, -2.0F, 5.0F, 4.0F, 5.0F, 0.0F, false);
		rShoulder.setModelRendererName("rShoulder");
		this.registerModelRenderer(rShoulder);

		rShoulderSpike = new AnimatedModelRenderer(this);
		rShoulderSpike.setRotationPoint(3.5F, 0.0F, 0.0F);
		rShoulder.addChild(rShoulderSpike);
		setRotationAngle(rShoulderSpike, 0.0F, -0.5009F, -0.3643F);
		rShoulderSpike.setTextureOffset(24, 13).addBox(0.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		rShoulderSpike.setModelRendererName("rShoulderSpike");
		this.registerModelRenderer(rShoulderSpike);

		rArm1 = new AnimatedModelRenderer(this);
		rArm1.setRotationPoint(1.5F, 2.0F, 0.5F);
		rShoulder.addChild(rArm1);
		rArm1.setTextureOffset(0, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		rArm1.setModelRendererName("rArm1");
		this.registerModelRenderer(rArm1);

		rArm2 = new AnimatedModelRenderer(this);
		rArm2.setRotationPoint(0.0F, 5.0F, 2.0F);
		rArm1.addChild(rArm2);
		setRotationAngle(rArm2, -0.1367F, 0.0F, 0.0F);
		rArm2.setTextureOffset(16, 41).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		rArm2.setModelRendererName("rArm2");
		this.registerModelRenderer(rArm2);

		rElbowSpike = new AnimatedModelRenderer(this);
		rElbowSpike.setRotationPoint(0.0F, 0.5F, -0.6F);
		rArm2.addChild(rElbowSpike);
		setRotationAngle(rElbowSpike, 0.6374F, 0.3187F, 0.0F);
		rElbowSpike.setTextureOffset(30, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		rElbowSpike.setModelRendererName("rElbowSpike");
		this.registerModelRenderer(rElbowSpike);

		rArmSpike = new AnimatedModelRenderer(this);
		rArmSpike.setRotationPoint(1.5F, 0.4F, 1.0F);
		rArm1.addChild(rArmSpike);
		setRotationAngle(rArmSpike, 0.0F, 0.5463F, 0.0F);
		rArmSpike.setTextureOffset(28, 20).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		rArmSpike.setModelRendererName("rArmSpike");
		this.registerModelRenderer(rArmSpike);

		lShoulder = new AnimatedModelRenderer(this);
		lShoulder.setRotationPoint(-4.0F, -6.0F, -1.9F);
		torso.addChild(lShoulder);
		setRotationAngle(lShoulder, 0.0F, 0.0F, 0.1367F);
		lShoulder.setTextureOffset(16, 32).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 4.0F, 5.0F, 0.0F, false);
		lShoulder.setModelRendererName("lShoulder");
		this.registerModelRenderer(lShoulder);

		lArm1 = new AnimatedModelRenderer(this);
		lArm1.setRotationPoint(-1.5F, 2.0F, 0.5F);
		lShoulder.addChild(lArm1);
		lArm1.setTextureOffset(0, 40).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		lArm1.setModelRendererName("lArm1");
		this.registerModelRenderer(lArm1);

		lArm2 = new AnimatedModelRenderer(this);
		lArm2.setRotationPoint(0.0F, 5.0F, 2.0F);
		lArm1.addChild(lArm2);
		setRotationAngle(lArm2, -0.1367F, 0.0F, 0.0F);
		lArm2.setTextureOffset(16, 41).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		lArm2.setModelRendererName("lArm2");
		this.registerModelRenderer(lArm2);

		lElbowSpike = new AnimatedModelRenderer(this);
		lElbowSpike.setRotationPoint(0.0F, 0.5F, -0.6F);
		lArm2.addChild(lElbowSpike);
		setRotationAngle(lElbowSpike, 0.6374F, -0.3187F, 0.0F);
		lElbowSpike.setTextureOffset(30, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		lElbowSpike.setModelRendererName("lElbowSpike");
		this.registerModelRenderer(lElbowSpike);

		lArmSpike = new AnimatedModelRenderer(this);
		lArmSpike.setRotationPoint(-1.5F, 0.4F, 1.0F);
		lArm1.addChild(lArmSpike);
		setRotationAngle(lArmSpike, 0.0F, -0.5463F, 0.0F);
		lArmSpike.setTextureOffset(28, 20).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		lArmSpike.setModelRendererName("lArmSpike");
		this.registerModelRenderer(lArmSpike);

		lShoulderSpike = new AnimatedModelRenderer(this);
		lShoulderSpike.setRotationPoint(-3.5F, 0.0F, 0.0F);
		lShoulder.addChild(lShoulderSpike);
		setRotationAngle(lShoulderSpike, 0.0F, 0.5009F, 0.3643F);
		lShoulderSpike.setTextureOffset(24, 13).addBox(-3.0F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		lShoulderSpike.setModelRendererName("lShoulderSpike");
		this.registerModelRenderer(lShoulderSpike);

		backSpike1 = new AnimatedModelRenderer(this);
		backSpike1.setRotationPoint(-2.3F, -5.5F, 0.0F);
		torso.addChild(backSpike1);
		setRotationAngle(backSpike1, 0.9561F, 0.0F, -0.5009F);
		backSpike1.setTextureOffset(30, 5).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		backSpike1.setModelRendererName("backSpike1");
		this.registerModelRenderer(backSpike1);

		neck = new AnimatedModelRenderer(this);
		neck.setRotationPoint(0.0F, -7.0F, 1.0F);
		torso.addChild(neck);
		setRotationAngle(neck, 0.2731F, 0.0F, 0.0F);
		neck.setTextureOffset(0, 49).addBox(-2.5F, -4.0F, -5.0F, 5.0F, 4.0F, 5.0F, 0.0F, false);
		neck.setModelRendererName("neck");
		this.registerModelRenderer(neck);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, -3.0F, -2.7F);
		neck.addChild(head);
		setRotationAngle(head, -0.0911F, 0.0F, 0.0F);
		head.setTextureOffset(0, 58).addBox(-3.5F, -5.0F, -4.0F, 7.0F, 5.0F, 7.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		chin = new AnimatedModelRenderer(this);
		chin.setRotationPoint(0.0F, -0.1F, -4.0F);
		head.addChild(chin);
		setRotationAngle(chin, 0.1367F, 0.0F, 0.0F);
		chin.setTextureOffset(21, 52).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 4.0F, 4.0F, 0.0F, false);
		chin.setModelRendererName("chin");
		this.registerModelRenderer(chin);

		browMiddle = new AnimatedModelRenderer(this);
		browMiddle.setRotationPoint(0.0F, -2.4F, -4.5F);
		head.addChild(browMiddle);
		browMiddle.setTextureOffset(0, 58).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		browMiddle.setModelRendererName("browMiddle");
		this.registerModelRenderer(browMiddle);

		lBrow1 = new AnimatedModelRenderer(this);
		lBrow1.setRotationPoint(-0.4F, 0.3F, 0.0F);
		browMiddle.addChild(lBrow1);
		setRotationAngle(lBrow1, 0.0F, 0.0F, 0.7285F);
		lBrow1.setTextureOffset(0, 58).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		lBrow1.setModelRendererName("lBrow1");
		this.registerModelRenderer(lBrow1);

		lBrow2 = new AnimatedModelRenderer(this);
		lBrow2.setRotationPoint(-2.0F, 0.0F, 0.0F);
		lBrow1.addChild(lBrow2);
		setRotationAngle(lBrow2, 0.0F, 0.0F, -1.0928F);
		lBrow2.setTextureOffset(0, 58).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		lBrow2.setModelRendererName("lBrow2");
		this.registerModelRenderer(lBrow2);

		rBrow1 = new AnimatedModelRenderer(this);
		rBrow1.setRotationPoint(0.4F, 0.3F, 0.0F);
		browMiddle.addChild(rBrow1);
		setRotationAngle(rBrow1, 0.0F, 0.0F, -0.7285F);
		rBrow1.setTextureOffset(0, 58).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		rBrow1.setModelRendererName("rBrow1");
		this.registerModelRenderer(rBrow1);

		rBrow2 = new AnimatedModelRenderer(this);
		rBrow2.setRotationPoint(2.0F, 0.0F, 0.0F);
		rBrow1.addChild(rBrow2);
		setRotationAngle(rBrow2, 0.0F, 0.0F, 1.0928F);
		rBrow2.setTextureOffset(0, 58).addBox(0.0F, 0.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		rBrow2.setModelRendererName("rBrow2");
		this.registerModelRenderer(rBrow2);

		rightPec = new AnimatedModelRenderer(this);
		rightPec.setRotationPoint(2.7F, -5.3F, -2.0F);
		torso.addChild(rightPec);
		setRotationAngle(rightPec, 0.0F, 0.0F, 0.0873F);
		rightPec.setTextureOffset(0, 32).addBox(-2.5F, -2.5F, -3.0F, 5.0F, 5.0F, 3.0F, 0.0F, false);
		rightPec.setModelRendererName("rightPec");
		this.registerModelRenderer(rightPec);

		chestSpikeR = new AnimatedModelRenderer(this);
		chestSpikeR.setRotationPoint(1.0F, 0.2F, -2.7F);
		rightPec.addChild(chestSpikeR);
		setRotationAngle(chestSpikeR, 0.3187F, -0.3643F, 0.0F);
		chestSpikeR.setTextureOffset(18, 12).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		chestSpikeR.setModelRendererName("chestSpikeR");
		this.registerModelRenderer(chestSpikeR);

		leftPec = new AnimatedModelRenderer(this);
		leftPec.setRotationPoint(-2.7F, -5.3F, -2.0F);
		torso.addChild(leftPec);
		setRotationAngle(leftPec, 0.0F, 0.0F, -0.0873F);
		leftPec.setTextureOffset(0, 32).addBox(-2.5F, -2.5F, -3.0F, 5.0F, 5.0F, 3.0F, 0.0F, false);
		leftPec.setModelRendererName("leftPec");
		this.registerModelRenderer(leftPec);

		chestSpikeL = new AnimatedModelRenderer(this);
		chestSpikeL.setRotationPoint(-1.0F, 0.2F, -2.7F);
		leftPec.addChild(chestSpikeL);
		setRotationAngle(chestSpikeL, 0.3187F, 0.3643F, 0.0F);
		chestSpikeL.setTextureOffset(18, 12).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		chestSpikeL.setModelRendererName("chestSpikeL");
		this.registerModelRenderer(chestSpikeL);

		lLeg1 = new AnimatedModelRenderer(this);
		lLeg1.setRotationPoint(-1.9F, 5.0F, 0.0F);
		thighs.addChild(lLeg1);
		setRotationAngle(lLeg1, 0.0F, 0.0F, 0.0456F);
		lLeg1.setTextureOffset(0, 21).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		lLeg1.setModelRendererName("lLeg1");
		this.registerModelRenderer(lLeg1);

		lLeg2 = new AnimatedModelRenderer(this);
		lLeg2.setRotationPoint(0.0F, 6.8F, -2.0F);
		lLeg1.addChild(lLeg2);
		setRotationAngle(lLeg2, 0.0911F, 0.0F, -0.0456F);
		lLeg2.setTextureOffset(16, 21).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		lLeg2.setModelRendererName("lLeg2");
		this.registerModelRenderer(lLeg2);

		kneeSpikeL = new AnimatedModelRenderer(this);
		kneeSpikeL.setRotationPoint(0.0F, 0.5F, 1.0F);
		lLeg2.addChild(kneeSpikeL);
		setRotationAngle(kneeSpikeL, -0.6374F, 0.0F, 0.0F);
		kneeSpikeL.setTextureOffset(22, 17).addBox(-0.5F, 0.0F, -3.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		kneeSpikeL.setModelRendererName("kneeSpikeL");
		this.registerModelRenderer(kneeSpikeL);

		this.rootBones.add(thighs);
	}
	
	@Override
	public ResourceLocation getAnimationFileLocation() {
		return new ResourceLocation(DoomMod.MODID, "animations/imp_animation.json");
	}
}