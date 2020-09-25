package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.ArachnotronEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

/**
 * Arachnotron - Batpixxler
 */
public class ArachnotronModel extends AnimatedEntityModel<ArachnotronEntity> {

	private final AnimatedModelRenderer base;
	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer topL;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer lowJaw;
	private final AnimatedModelRenderer lowTeeth;
	private final AnimatedModelRenderer lEye;
	private final AnimatedModelRenderer topJaw;
	private final AnimatedModelRenderer topTeeth;
	private final AnimatedModelRenderer rEye;
	private final AnimatedModelRenderer topR;
	private final AnimatedModelRenderer gunBase;
	private final AnimatedModelRenderer gunBarrel;
	private final AnimatedModelRenderer lLeg1_1_flat;
	private final AnimatedModelRenderer lLeg1_1;
	private final AnimatedModelRenderer lArm;
	private final AnimatedModelRenderer lLeg1_2;
	private final AnimatedModelRenderer lLeg1_3;
	private final AnimatedModelRenderer lLeg1_4;
	private final AnimatedModelRenderer lLeg1_5;
	private final AnimatedModelRenderer lLeg2_1_flat;
	private final AnimatedModelRenderer lLeg2_1;
	private final AnimatedModelRenderer lLeg2_2;
	private final AnimatedModelRenderer lLeg2_3;
	private final AnimatedModelRenderer lLeg2_4;
	private final AnimatedModelRenderer lLeg2_5;
	private final AnimatedModelRenderer rLeg1_1_flat;
	private final AnimatedModelRenderer rLeg1_1;
	private final AnimatedModelRenderer rArm;
	private final AnimatedModelRenderer rLeg1_2;
	private final AnimatedModelRenderer rLeg1_3;
	private final AnimatedModelRenderer rLeg1_4;
	private final AnimatedModelRenderer rLeg1_5;
	private final AnimatedModelRenderer rLeg2_1_flat;
	private final AnimatedModelRenderer rLeg2_1;
	private final AnimatedModelRenderer rLeg2_2;
	private final AnimatedModelRenderer rLeg2_3;
	private final AnimatedModelRenderer rLeg2_4;
	private final AnimatedModelRenderer rLeg2_5;

	public ArachnotronModel() {
		textureWidth = 100;
		textureHeight = 130;
		base = new AnimatedModelRenderer(this);
		base.setRotationPoint(0.0F, 7.5F, 0.0F);
		setRotationAngle(base, 0.0F, 0.0F, -0.0063F);
		base.setTextureOffset(0, 79).addBox(-11.5F, 0.0F, -11.5F, 23.0F, 7.0F, 23.0F, 0.0F, false);
		base.setModelRendererName("base");
		this.registerModelRenderer(base);

		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(0.0F, -2.0F, 0.0F);
		base.addChild(body);
		body.setTextureOffset(0, 0).addBox(-10.5F, -11.0F, -10.0F, 21.0F, 13.0F, 20.0F, 0.0F, false);
		body.setModelRendererName("body");
		this.registerModelRenderer(body);

		topL = new AnimatedModelRenderer(this);
		topL.setRotationPoint(1.0F, -10.5F, 0.0F);
		body.addChild(topL);
		setRotationAngle(topL, 0.0F, 0.0F, -0.2731F);
		topL.setTextureOffset(0, 55).addBox(-11.1637F, -5.8356F, -9.5F, 10.0F, 5.0F, 19.0F, 0.0F, false);
		topL.setModelRendererName("topL");
		this.registerModelRenderer(topL);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, -8.3F, -10.0F);
		body.addChild(head);
		head.setTextureOffset(0, 6).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		lowJaw = new AnimatedModelRenderer(this);
		lowJaw.setRotationPoint(0.0F, 6.0F, 0.0F);
		head.addChild(lowJaw);
		setRotationAngle(lowJaw, 0.5918F, 0.0F, 0.0F);
		lowJaw.setTextureOffset(0, 59).addBox(-2.5F, 0.0F, -2.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		lowJaw.setModelRendererName("lowJaw");
		this.registerModelRenderer(lowJaw);

		lowTeeth = new AnimatedModelRenderer(this);
		lowTeeth.setRotationPoint(1.5F, -0.4F, -1.6F);
		lowJaw.addChild(lowTeeth);

		lowTeeth.setModelRendererName("lowTeeth");
		this.registerModelRenderer(lowTeeth);

		lEye = new AnimatedModelRenderer(this);
		lEye.setRotationPoint(-2.5F, 5.0F, -0.9F);
		head.addChild(lEye);
		setRotationAngle(lEye, 0.0F, 0.0F, -0.6374F);
		lEye.setTextureOffset(0, 0).addBox(3.5993F, -0.7981F, 0.0F, 7.0F, 5.0F, 1.0F, 0.0F, false);
		lEye.setModelRendererName("lEye");
		this.registerModelRenderer(lEye);

		topJaw = new AnimatedModelRenderer(this);
		topJaw.setRotationPoint(0.0F, 4.0F, 0.0F);
		head.addChild(topJaw);
		topJaw.setTextureOffset(0, 11).addBox(-2.5F, 0.0F, -2.0F, 5.0F, 2.0F, 2.0F, 0.0F, false);
		topJaw.setModelRendererName("topJaw");
		this.registerModelRenderer(topJaw);

		topTeeth = new AnimatedModelRenderer(this);
		topTeeth.setRotationPoint(0.0F, 1.4F, -1.9F);
		topJaw.addChild(topTeeth);

		topTeeth.setModelRendererName("topTeeth");
		this.registerModelRenderer(topTeeth);

		rEye = new AnimatedModelRenderer(this);
		rEye.setRotationPoint(2.0F, 5.0F, -0.9F);
		head.addChild(rEye);
		setRotationAngle(rEye, 0.0F, 0.0F, 0.6374F);
		rEye.setTextureOffset(0, 0).addBox(-10.6512F, -0.9317F, 0.0F, 7.0F, 5.0F, 1.0F, 0.0F, false);
		rEye.setModelRendererName("rEye");
		this.registerModelRenderer(rEye);

		topR = new AnimatedModelRenderer(this);
		topR.setRotationPoint(-1.0F, -10.5F, 0.0F);
		body.addChild(topR);
		setRotationAngle(topR, 0.0F, 0.0F, 0.2731F);
		topR.setTextureOffset(0, 55).addBox(1.1734F, -5.7078F, -9.5F, 10.0F, 5.0F, 19.0F, 0.0F, false);
		topR.setModelRendererName("topR");
		this.registerModelRenderer(topR);

		gunBase = new AnimatedModelRenderer(this);
		gunBase.setRotationPoint(0.0F, 0.2F, -13.0F);
		base.addChild(gunBase);
		gunBase.setTextureOffset(40, 43).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 5.0F, 2.0F, 0.0F, false);
		gunBase.setModelRendererName("gunBase");
		this.registerModelRenderer(gunBase);

		gunBarrel = new AnimatedModelRenderer(this);
		gunBarrel.setRotationPoint(0.0F, 2.5F, 0.0F);
		gunBase.addChild(gunBarrel);
		gunBarrel.setTextureOffset(54, 43).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		gunBarrel.setModelRendererName("gunBarrel");
		this.registerModelRenderer(gunBarrel);

		lLeg1_1_flat = new AnimatedModelRenderer(this);
		lLeg1_1_flat.setRotationPoint(-8.0F, 3.0F, -9.0F);
		base.addChild(lLeg1_1_flat);

		lLeg1_1_flat.setModelRendererName("lLeg1_1_flat");
		this.registerModelRenderer(lLeg1_1_flat);

		lLeg1_1 = new AnimatedModelRenderer(this);
		lLeg1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		lLeg1_1_flat.addChild(lLeg1_1);
		setRotationAngle(lLeg1_1, -1.9228F, 0.5918F, 0.0F);
		lLeg1_1.setTextureOffset(0, 33).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, false);
		lLeg1_1.setModelRendererName("lLeg1_1");
		this.registerModelRenderer(lLeg1_1);

		lArm = new AnimatedModelRenderer(this);
		lArm.setRotationPoint(0.0F, 10.0F, -1.0F);
		lLeg1_1.addChild(lArm);
		setRotationAngle(lArm, -0.9561F, 0.0F, 0.0F);
		lArm.setTextureOffset(27, 44).addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		lArm.setModelRendererName("lArm");
		this.registerModelRenderer(lArm);

		lLeg1_2 = new AnimatedModelRenderer(this);
		lLeg1_2.setRotationPoint(0.0F, 21.0F, 0.0F);
		lLeg1_1.addChild(lLeg1_2);
		setRotationAngle(lLeg1_2, 0.4098F, 0.0F, 0.0F);
		lLeg1_2.setTextureOffset(16, 33).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, false);
		lLeg1_2.setModelRendererName("lLeg1_2");
		this.registerModelRenderer(lLeg1_2);

		lLeg1_3 = new AnimatedModelRenderer(this);
		lLeg1_3.setRotationPoint(0.0F, 3.0F, 0.0F);
		lLeg1_2.addChild(lLeg1_3);
		setRotationAngle(lLeg1_3, 0.6829F, 0.0F, 0.0F);
		lLeg1_3.setTextureOffset(0, 33).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, false);
		lLeg1_3.setModelRendererName("lLeg1_3");
		this.registerModelRenderer(lLeg1_3);

		lLeg1_4 = new AnimatedModelRenderer(this);
		lLeg1_4.setRotationPoint(0.0F, 21.0F, 0.0F);
		lLeg1_3.addChild(lLeg1_4);
		setRotationAngle(lLeg1_4, 0.5463F, 0.0F, 0.0F);
		lLeg1_4.setTextureOffset(16, 42).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, false);
		lLeg1_4.setModelRendererName("lLeg1_4");
		this.registerModelRenderer(lLeg1_4);

		lLeg1_5 = new AnimatedModelRenderer(this);
		lLeg1_5.setRotationPoint(0.0F, 5.2F, 0.0F);
		lLeg1_4.addChild(lLeg1_5);
		setRotationAngle(lLeg1_5, 0.2731F, 0.0F, 0.0F);
		lLeg1_5.setTextureOffset(36, 33).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F, 0.0F, false);
		lLeg1_5.setModelRendererName("lLeg1_5");
		this.registerModelRenderer(lLeg1_5);

		lLeg2_1_flat = new AnimatedModelRenderer(this);
		lLeg2_1_flat.setRotationPoint(-8.0F, 2.5F, 9.0F);
		base.addChild(lLeg2_1_flat);

		lLeg2_1_flat.setModelRendererName("lLeg2_1_flat");
		this.registerModelRenderer(lLeg2_1_flat);

		lLeg2_1 = new AnimatedModelRenderer(this);
		lLeg2_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		lLeg2_1_flat.addChild(lLeg2_1);
		setRotationAngle(lLeg2_1, 1.9216F, -0.5918F, 0.0F);
		lLeg2_1.setTextureOffset(0, 33).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, false);
		lLeg2_1.setModelRendererName("lLeg2_1");
		this.registerModelRenderer(lLeg2_1);

		lLeg2_2 = new AnimatedModelRenderer(this);
		lLeg2_2.setRotationPoint(0.0F, 21.0F, 0.0F);
		lLeg2_1.addChild(lLeg2_2);
		setRotationAngle(lLeg2_2, -0.4098F, 0.0F, 0.0F);
		lLeg2_2.setTextureOffset(16, 33).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, false);
		lLeg2_2.setModelRendererName("lLeg2_2");
		this.registerModelRenderer(lLeg2_2);

		lLeg2_3 = new AnimatedModelRenderer(this);
		lLeg2_3.setRotationPoint(0.0F, 3.0F, 0.0F);
		lLeg2_2.addChild(lLeg2_3);
		setRotationAngle(lLeg2_3, -0.6829F, 0.0F, 0.0F);
		lLeg2_3.setTextureOffset(0, 33).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, false);
		lLeg2_3.setModelRendererName("lLeg2_3");
		this.registerModelRenderer(lLeg2_3);

		lLeg2_4 = new AnimatedModelRenderer(this);
		lLeg2_4.setRotationPoint(0.0F, 21.0F, 0.0F);
		lLeg2_3.addChild(lLeg2_4);
		setRotationAngle(lLeg2_4, -0.5463F, 0.0F, 0.0F);
		lLeg2_4.setTextureOffset(16, 42).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, false);
		lLeg2_4.setModelRendererName("lLeg2_4");
		this.registerModelRenderer(lLeg2_4);

		lLeg2_5 = new AnimatedModelRenderer(this);
		lLeg2_5.setRotationPoint(0.0F, 5.2F, 0.0F);
		lLeg2_4.addChild(lLeg2_5);
		setRotationAngle(lLeg2_5, -0.2731F, 0.0F, 0.0F);
		lLeg2_5.setTextureOffset(36, 33).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F, 0.0F, false);
		lLeg2_5.setModelRendererName("lLeg2_5");
		this.registerModelRenderer(lLeg2_5);

		rLeg1_1_flat = new AnimatedModelRenderer(this);
		rLeg1_1_flat.setRotationPoint(7.0F, 3.0F, -9.0F);
		base.addChild(rLeg1_1_flat);

		rLeg1_1_flat.setModelRendererName("rLeg1_1_flat");
		this.registerModelRenderer(rLeg1_1_flat);

		rLeg1_1 = new AnimatedModelRenderer(this);
		rLeg1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rLeg1_1_flat.addChild(rLeg1_1);
		setRotationAngle(rLeg1_1, -1.9216F, -0.5918F, 0.0F);
		rLeg1_1.setTextureOffset(0, 33).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, false);
		rLeg1_1.setModelRendererName("rLeg1_1");
		this.registerModelRenderer(rLeg1_1);

		rArm = new AnimatedModelRenderer(this);
		rArm.setRotationPoint(0.0F, 10.0F, -1.0F);
		rLeg1_1.addChild(rArm);
		setRotationAngle(rArm, -0.9561F, 0.0F, 0.0F);
		rArm.setTextureOffset(27, 44).addBox(-1.0F, -1.0F, -9.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		rArm.setModelRendererName("rArm");
		this.registerModelRenderer(rArm);

		rLeg1_2 = new AnimatedModelRenderer(this);
		rLeg1_2.setRotationPoint(0.0F, 21.0F, 0.0F);
		rLeg1_1.addChild(rLeg1_2);
		setRotationAngle(rLeg1_2, 0.4098F, 0.0F, 0.0F);
		rLeg1_2.setTextureOffset(16, 33).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, false);
		rLeg1_2.setModelRendererName("rLeg1_2");
		this.registerModelRenderer(rLeg1_2);

		rLeg1_3 = new AnimatedModelRenderer(this);
		rLeg1_3.setRotationPoint(0.0F, 3.0F, 0.0F);
		rLeg1_2.addChild(rLeg1_3);
		setRotationAngle(rLeg1_3, 0.6829F, 0.0F, 0.0F);
		rLeg1_3.setTextureOffset(0, 33).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, false);
		rLeg1_3.setModelRendererName("rLeg1_3");
		this.registerModelRenderer(rLeg1_3);

		rLeg1_4 = new AnimatedModelRenderer(this);
		rLeg1_4.setRotationPoint(0.0F, 21.0F, 0.0F);
		rLeg1_3.addChild(rLeg1_4);
		setRotationAngle(rLeg1_4, 0.5463F, 0.0F, 0.0F);
		rLeg1_4.setTextureOffset(16, 42).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, false);
		rLeg1_4.setModelRendererName("rLeg1_4");
		this.registerModelRenderer(rLeg1_4);

		rLeg1_5 = new AnimatedModelRenderer(this);
		rLeg1_5.setRotationPoint(0.0F, 5.2F, 0.0F);
		rLeg1_4.addChild(rLeg1_5);
		setRotationAngle(rLeg1_5, 0.2731F, 0.0F, 0.0F);
		rLeg1_5.setTextureOffset(36, 33).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F, 0.0F, false);
		rLeg1_5.setModelRendererName("rLeg1_5");
		this.registerModelRenderer(rLeg1_5);

		rLeg2_1_flat = new AnimatedModelRenderer(this);
		rLeg2_1_flat.setRotationPoint(7.0F, 2.5F, 9.0F);
		base.addChild(rLeg2_1_flat);

		rLeg2_1_flat.setModelRendererName("rLeg2_1_flat");
		this.registerModelRenderer(rLeg2_1_flat);

		rLeg2_1 = new AnimatedModelRenderer(this);
		rLeg2_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rLeg2_1_flat.addChild(rLeg2_1);
		setRotationAngle(rLeg2_1, 1.9216F, 0.5918F, 0.0F);
		rLeg2_1.setTextureOffset(0, 33).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, false);
		rLeg2_1.setModelRendererName("rLeg2_1");
		this.registerModelRenderer(rLeg2_1);

		rLeg2_2 = new AnimatedModelRenderer(this);
		rLeg2_2.setRotationPoint(0.0F, 21.0F, 0.0F);
		rLeg2_1.addChild(rLeg2_2);
		setRotationAngle(rLeg2_2, -0.4098F, 0.0F, 0.0F);
		rLeg2_2.setTextureOffset(16, 33).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, false);
		rLeg2_2.setModelRendererName("rLeg2_2");
		this.registerModelRenderer(rLeg2_2);

		rLeg2_3 = new AnimatedModelRenderer(this);
		rLeg2_3.setRotationPoint(0.0F, 3.0F, 0.0F);
		rLeg2_2.addChild(rLeg2_3);
		setRotationAngle(rLeg2_3, -0.6829F, 0.0F, 0.0F);
		rLeg2_3.setTextureOffset(0, 33).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 22.0F, 4.0F, 0.0F, false);
		rLeg2_3.setModelRendererName("rLeg2_3");
		this.registerModelRenderer(rLeg2_3);

		rLeg2_4 = new AnimatedModelRenderer(this);
		rLeg2_4.setRotationPoint(0.0F, 21.0F, 0.0F);
		rLeg2_3.addChild(rLeg2_4);
		setRotationAngle(rLeg2_4, -0.5463F, 0.0F, 0.0F);
		rLeg2_4.setTextureOffset(16, 42).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, 0.0F, false);
		rLeg2_4.setModelRendererName("rLeg2_4");
		this.registerModelRenderer(rLeg2_4);

		rLeg2_5 = new AnimatedModelRenderer(this);
		rLeg2_5.setRotationPoint(0.0F, 5.2F, 0.0F);
		rLeg2_4.addChild(rLeg2_5);
		setRotationAngle(rLeg2_5, -0.2731F, 0.0F, 0.0F);
		rLeg2_5.setTextureOffset(36, 33).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 2.0F, 8.0F, 0.0F, false);
		rLeg2_5.setModelRendererName("rLeg2_5");
		this.registerModelRenderer(rLeg2_5);

		this.rootBones.add(base);
	}

	@Override
	public ResourceLocation getAnimationFileLocation() {
		return new ResourceLocation(DoomMod.MODID, "animations/arachnotron_walking.json");
	}
}