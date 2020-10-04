package mod.azure.doomweapon.client.models;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.CyberdemonEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class CyberdemonModel extends AnimatedEntityModel<CyberdemonEntity> {

	private final AnimatedModelRenderer thighs;
	private final AnimatedModelRenderer torso;
	private final AnimatedModelRenderer leftPec;
	private final AnimatedModelRenderer lShoulder;
	private final AnimatedModelRenderer lArm;
	private final AnimatedModelRenderer lArm2;
	private final AnimatedModelRenderer gunBase;
	private final AnimatedModelRenderer gunBarrel;
	private final AnimatedModelRenderer gunrim;
	private final AnimatedModelRenderer neck;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer rHorn1;
	private final AnimatedModelRenderer rHorn2;
	private final AnimatedModelRenderer rHorn3;
	private final AnimatedModelRenderer rHorn4;
	private final AnimatedModelRenderer rHorn5;
	private final AnimatedModelRenderer topJaw;
	private final AnimatedModelRenderer snout;
	private final AnimatedModelRenderer topTeethR;
	private final AnimatedModelRenderer topTeethL;
	private final AnimatedModelRenderer lHorn1;
	private final AnimatedModelRenderer lHorn2;
	private final AnimatedModelRenderer lHorn3;
	private final AnimatedModelRenderer lHorn4;
	private final AnimatedModelRenderer lHorn5;
	private final AnimatedModelRenderer chin;
	private final AnimatedModelRenderer lowJaw;
	private final AnimatedModelRenderer rFang;
	private final AnimatedModelRenderer lFang;
	private final AnimatedModelRenderer lowTeeth;
	private final AnimatedModelRenderer rShoulder;
	private final AnimatedModelRenderer rArm1;
	private final AnimatedModelRenderer rArm2;
	private final AnimatedModelRenderer armWires;
	private final AnimatedModelRenderer rightPec;
	private final AnimatedModelRenderer lLeg1_flat;
	private final AnimatedModelRenderer lLeg1;
	private final AnimatedModelRenderer lLeg2;
	private final AnimatedModelRenderer lLeg3;
	private final AnimatedModelRenderer lFoot;
	private final AnimatedModelRenderer rLeg1_flat;
	private final AnimatedModelRenderer rLeg1;
	private final AnimatedModelRenderer rLeg2;
	private final AnimatedModelRenderer rLeg3;
	private final AnimatedModelRenderer rFoot;
	private final AnimatedModelRenderer rLeg3_2;
	private final AnimatedModelRenderer rLegP2;
	private final AnimatedModelRenderer rLegP1;

	public CyberdemonModel() {
		textureWidth = 100;
		textureHeight = 200;
		thighs = new AnimatedModelRenderer(this);
		thighs.setRotationPoint(0.0F, -14.0F, 3.5F);
		thighs.setTextureOffset(0, 24).addBox(-7.0F, -2.0F, -8.0F, 14.0F, 12.0F, 10.0F, 0.0F, true);
		thighs.setModelRendererName("thighs");
		this.registerModelRenderer(thighs);

		torso = new AnimatedModelRenderer(this);
		torso.setRotationPoint(0.0F, -1.0F, 2.3F);
		thighs.addChild(torso);
		setRotationAngle(torso, 0.0456F, 0.0F, 0.0F);
		torso.setTextureOffset(0, 0).addBox(-9.5F, -13.0F, -12.0F, 19.0F, 12.0F, 12.0F, 0.0F, true);
		torso.setModelRendererName("torso");
		this.registerModelRenderer(torso);

		leftPec = new AnimatedModelRenderer(this);
		leftPec.setRotationPoint(-5.1F, -7.7F, -10.0F);
		torso.addChild(leftPec);
		setRotationAngle(leftPec, 0.0F, 0.0F, -0.0873F);
		leftPec.setTextureOffset(52, 124).addBox(-5.0F, -5.0F, -3.0F, 10.0F, 10.0F, 3.0F, 0.0F, true);
		leftPec.setModelRendererName("leftPec");
		this.registerModelRenderer(leftPec);

		lShoulder = new AnimatedModelRenderer(this);
		lShoulder.setRotationPoint(8.7F, -12.0F, -6.0F);
		torso.addChild(lShoulder);
		setRotationAngle(lShoulder, 0.0F, 0.0F, -0.1367F);
		lShoulder.setTextureOffset(0, 99).addBox(-1.0F, -2.0F, -4.0F, 7.0F, 8.0F, 7.0F, 0.0F, true);
		lShoulder.setModelRendererName("lShoulder");
		this.registerModelRenderer(lShoulder);

		lArm = new AnimatedModelRenderer(this);
		lArm.setRotationPoint(2.5F, 6.0F, 0.0F);
		lShoulder.addChild(lArm);
		lArm.setTextureOffset(28, 94).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F, 0.0F, true);
		lArm.setModelRendererName("lArm");
		this.registerModelRenderer(lArm);

		lArm2 = new AnimatedModelRenderer(this);
		lArm2.setRotationPoint(0.0F, 9.0F, 3.0F);
		lArm.addChild(lArm2);
		setRotationAngle(lArm2, -0.2731F, 0.0F, 0.1367F);
		lArm2.setTextureOffset(52, 94).addBox(-3.0F, 0.0F, -6.0F, 6.0F, 6.0F, 6.0F, 0.0F, true);
		lArm2.setModelRendererName("lArm2");
		this.registerModelRenderer(lArm2);

		gunBase = new AnimatedModelRenderer(this);
		gunBase.setRotationPoint(0.0F, 5.0F, -3.0F);
		lArm2.addChild(gunBase);
		gunBase.setTextureOffset(24, 110).addBox(-3.5F, 0.0F, -4.0F, 7.0F, 9.0F, 8.0F, 0.0F, false);
		gunBase.setModelRendererName("gunBase");
		this.registerModelRenderer(gunBase);

		gunBarrel = new AnimatedModelRenderer(this);
		gunBarrel.setRotationPoint(-0.5F, 9.0F, 0.0F);
		gunBase.addChild(gunBarrel);
		gunBarrel.setTextureOffset(54, 106).addBox(-2.0F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F, 0.0F, true);
		gunBarrel.setModelRendererName("gunBarrel");
		this.registerModelRenderer(gunBarrel);

		gunrim = new AnimatedModelRenderer(this);
		gunrim.setRotationPoint(0.5F, 11.5F, 0.0F);
		gunBarrel.addChild(gunrim);
		gunrim.setTextureOffset(26, 128).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, true);
		gunrim.setModelRendererName("gunrim");
		this.registerModelRenderer(gunrim);

		neck = new AnimatedModelRenderer(this);
		neck.setRotationPoint(0.0F, -11.9F, -4.0F);
		torso.addChild(neck);
		setRotationAngle(neck, 0.2731F, 0.0F, 0.0F);
		neck.setTextureOffset(18, 132).addBox(-4.5F, -8.0F, -4.0F, 9.0F, 8.0F, 8.0F, 0.0F, true);
		neck.setModelRendererName("neck");
		this.registerModelRenderer(neck);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, -6.0F, 1.3F);
		neck.addChild(head);
		setRotationAngle(head, -0.2731F, 0.0063F, 0.0F);
		head.setTextureOffset(7, 148).addBox(-7.5F, -10.0F, -8.0F, 15.0F, 10.0F, 11.0F, 0.0F, true);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		rHorn1 = new AnimatedModelRenderer(this);
		rHorn1.setRotationPoint(-5.0F, -5.0F, 0.0F);
		head.addChild(rHorn1);
		setRotationAngle(rHorn1, -0.2276F, 0.0F, 1.3659F);
		rHorn1.setTextureOffset(0, 173).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 7.0F, 6.0F, 0.0F, true);
		rHorn1.setModelRendererName("rHorn1");
		this.registerModelRenderer(rHorn1);

		rHorn2 = new AnimatedModelRenderer(this);
		rHorn2.setRotationPoint(0.0F, 5.9F, 0.0F);
		rHorn1.addChild(rHorn2);
		setRotationAngle(rHorn2, -0.4098F, 0.0F, 0.0F);
		rHorn2.setTextureOffset(24, 173).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, 0.0F, true);
		rHorn2.setModelRendererName("rHorn2");
		this.registerModelRenderer(rHorn2);

		rHorn3 = new AnimatedModelRenderer(this);
		rHorn3.setRotationPoint(0.0F, 5.7F, 0.0F);
		rHorn2.addChild(rHorn3);
		setRotationAngle(rHorn3, -0.4554F, 0.0F, 0.1367F);
		rHorn3.setTextureOffset(44, 173).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, true);
		rHorn3.setModelRendererName("rHorn3");
		this.registerModelRenderer(rHorn3);

		rHorn4 = new AnimatedModelRenderer(this);
		rHorn4.setRotationPoint(0.0F, 5.7F, 0.0F);
		rHorn3.addChild(rHorn4);
		setRotationAngle(rHorn4, -0.6374F, 0.0F, 0.0911F);
		rHorn4.setTextureOffset(60, 173).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, true);
		rHorn4.setModelRendererName("rHorn4");
		this.registerModelRenderer(rHorn4);

		rHorn5 = new AnimatedModelRenderer(this);
		rHorn5.setRotationPoint(0.0F, 6.0F, 0.0F);
		rHorn4.addChild(rHorn5);
		setRotationAngle(rHorn5, -0.5918F, 0.0F, 0.0911F);
		rHorn5.setTextureOffset(72, 173).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, true);
		rHorn5.setModelRendererName("rHorn5");
		this.registerModelRenderer(rHorn5);

		topJaw = new AnimatedModelRenderer(this);
		topJaw.setRotationPoint(0.0F, 0.0F, -7.9F);
		head.addChild(topJaw);
		topJaw.setTextureOffset(52, 137).addBox(-5.0F, -5.0F, -3.0F, 10.0F, 5.0F, 3.0F, 0.0F, true);
		topJaw.setModelRendererName("topJaw");
		this.registerModelRenderer(topJaw);

		snout = new AnimatedModelRenderer(this);
		snout.setRotationPoint(0.0F, -5.0F, -3.0F);
		topJaw.addChild(snout);
		setRotationAngle(snout, 0.5463F, 0.0F, 0.0F);
		snout.setTextureOffset(52, 145).addBox(-4.5F, 0.0F, 0.0F, 9.0F, 2.0F, 4.0F, 0.0F, true);
		snout.setModelRendererName("snout");
		this.registerModelRenderer(snout);

		topTeethR = new AnimatedModelRenderer(this);
		topTeethR.setRotationPoint(-0.2F, -0.1F, -2.4F);
		topJaw.addChild(topTeethR);
		topTeethR.setTextureOffset(0, 169).addBox(-4.0F, 0.0F, 0.0F, 4.0F, 1.0F, 2.0F, 0.0F, true);
		topTeethR.setModelRendererName("topTeethR");
		this.registerModelRenderer(topTeethR);

		topTeethL = new AnimatedModelRenderer(this);
		topTeethL.setRotationPoint(0.2F, -0.1F, -2.4F);
		topJaw.addChild(topTeethL);
		topTeethL.setTextureOffset(0, 169).addBox(0.0F, 0.0F, 0.0F, 4.0F, 1.0F, 2.0F, 0.0F, true);
		topTeethL.setModelRendererName("topTeethL");
		this.registerModelRenderer(topTeethL);

		lHorn1 = new AnimatedModelRenderer(this);
		lHorn1.setRotationPoint(5.0F, -5.0F, 0.0F);
		head.addChild(lHorn1);
		setRotationAngle(lHorn1, -0.2276F, 0.0F, -1.3659F);
		lHorn1.setTextureOffset(0, 173).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 7.0F, 6.0F, 0.0F, true);
		lHorn1.setModelRendererName("lHorn1");
		this.registerModelRenderer(lHorn1);

		lHorn2 = new AnimatedModelRenderer(this);
		lHorn2.setRotationPoint(0.0F, 5.9F, 0.0F);
		lHorn1.addChild(lHorn2);
		setRotationAngle(lHorn2, -0.4098F, 0.0F, 0.0F);
		lHorn2.setTextureOffset(24, 173).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, 0.0F, true);
		lHorn2.setModelRendererName("lHorn2");
		this.registerModelRenderer(lHorn2);

		lHorn3 = new AnimatedModelRenderer(this);
		lHorn3.setRotationPoint(0.0F, 5.7F, 0.0F);
		lHorn2.addChild(lHorn3);
		setRotationAngle(lHorn3, -0.4554F, 0.0F, -0.1367F);
		lHorn3.setTextureOffset(44, 173).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, true);
		lHorn3.setModelRendererName("lHorn3");
		this.registerModelRenderer(lHorn3);

		lHorn4 = new AnimatedModelRenderer(this);
		lHorn4.setRotationPoint(0.0F, 5.7F, 0.0F);
		lHorn3.addChild(lHorn4);
		setRotationAngle(lHorn4, -0.6374F, 0.0F, -0.0911F);
		lHorn4.setTextureOffset(60, 173).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, 0.0F, true);
		lHorn4.setModelRendererName("lHorn4");
		this.registerModelRenderer(lHorn4);

		lHorn5 = new AnimatedModelRenderer(this);
		lHorn5.setRotationPoint(0.0F, 6.0F, 0.0F);
		lHorn4.addChild(lHorn5);
		setRotationAngle(lHorn5, -0.5918F, 0.0F, -0.0911F);
		lHorn5.setTextureOffset(72, 173).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, true);
		lHorn5.setModelRendererName("lHorn5");
		this.registerModelRenderer(lHorn5);

		chin = new AnimatedModelRenderer(this);
		chin.setRotationPoint(0.0F, -0.1F, -8.0F);
		head.addChild(chin);
		setRotationAngle(chin, 0.1367F, 0.0F, 0.0F);
		chin.setTextureOffset(52, 162).addBox(-5.0F, 0.0F, -0.2F, 10.0F, 3.0F, 7.0F, 0.0F, true);
		chin.setModelRendererName("chin");
		this.registerModelRenderer(chin);

		lowJaw = new AnimatedModelRenderer(this);
		lowJaw.setRotationPoint(0.0F, 0.0F, 0.4F);
		chin.addChild(lowJaw);
		setRotationAngle(lowJaw, -0.2276F, 0.0F, 0.0F);
		lowJaw.setTextureOffset(52, 151).addBox(-4.5F, 0.0F, -3.0F, 9.0F, 3.0F, 3.0F, 0.0F, true);
		lowJaw.setModelRendererName("lowJaw");
		this.registerModelRenderer(lowJaw);

		rFang = new AnimatedModelRenderer(this);
		rFang.setRotationPoint(1.5F, 0.3F, -2.3F);
		lowJaw.addChild(rFang);
		setRotationAngle(rFang, -0.9561F, 0.0F, 0.0F);
		rFang.setTextureOffset(0, 25).addBox(0.0F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);
		rFang.setModelRendererName("rFang");
		this.registerModelRenderer(rFang);

		lFang = new AnimatedModelRenderer(this);
		lFang.setRotationPoint(-2.5F, 0.3F, -2.3F);
		lowJaw.addChild(lFang);
		setRotationAngle(lFang, -0.9561F, 0.0F, 0.0F);
		lFang.setTextureOffset(0, 25).addBox(0.0F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);
		lFang.setModelRendererName("lFang");
		this.registerModelRenderer(lFang);

		lowTeeth = new AnimatedModelRenderer(this);
		lowTeeth.setRotationPoint(0.0F, -0.7F, -2.8F);
		lowJaw.addChild(lowTeeth);
		lowTeeth.setTextureOffset(13, 169).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 1.0F, 3.0F, 0.0F, true);
		lowTeeth.setModelRendererName("lowTeeth");
		this.registerModelRenderer(lowTeeth);

		rShoulder = new AnimatedModelRenderer(this);
		rShoulder.setRotationPoint(-8.7F, -12.0F, -6.0F);
		torso.addChild(rShoulder);
		setRotationAngle(rShoulder, 0.0F, 0.0F, 0.1367F);
		rShoulder.setTextureOffset(0, 99).addBox(-6.0F, -2.0F, -4.0F, 7.0F, 8.0F, 7.0F, 0.0F, true);
		rShoulder.setModelRendererName("rShoulder");
		this.registerModelRenderer(rShoulder);

		rArm1 = new AnimatedModelRenderer(this);
		rArm1.setRotationPoint(-2.5F, 6.0F, 0.0F);
		rShoulder.addChild(rArm1);
		rArm1.setTextureOffset(28, 94).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 10.0F, 6.0F, 0.0F, true);
		rArm1.setModelRendererName("rArm1");
		this.registerModelRenderer(rArm1);

		rArm2 = new AnimatedModelRenderer(this);
		rArm2.setRotationPoint(0.0F, 9.0F, 3.0F);
		rArm1.addChild(rArm2);
		setRotationAngle(rArm2, -0.2731F, 0.0F, -0.1367F);
		rArm2.setTextureOffset(0, 114).addBox(-3.0F, 0.0F, -6.0F, 6.0F, 15.0F, 6.0F, 0.0F, true);
		rArm2.setModelRendererName("rArm2");
		this.registerModelRenderer(rArm2);

		armWires = new AnimatedModelRenderer(this);
		armWires.setRotationPoint(-6.0F, 0.0F, 2.0F);
		rShoulder.addChild(armWires);
		setRotationAngle(armWires, 0.0F, 0.0F, -0.0911F);
		armWires.setTextureOffset(0, 135).addBox(-5.0F, 0.0F, -4.0F, 5.0F, 14.0F, 4.0F, 0.0F, false);
		armWires.setModelRendererName("armWires");
		this.registerModelRenderer(armWires);

		rightPec = new AnimatedModelRenderer(this);
		rightPec.setRotationPoint(5.1F, -7.7F, -10.0F);
		torso.addChild(rightPec);
		setRotationAngle(rightPec, 0.0F, 0.0F, 0.0873F);
		rightPec.setTextureOffset(52, 124).addBox(-5.0F, -5.0F, -3.0F, 10.0F, 10.0F, 3.0F, 0.0F, true);
		rightPec.setModelRendererName("rightPec");
		this.registerModelRenderer(rightPec);

		lLeg1_flat = new AnimatedModelRenderer(this);
		lLeg1_flat.setRotationPoint(4.5F, -7.7F, 1.4F);
		lLeg1_flat.setTextureOffset(0, 46).addBox(-3.5F, 0.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		lLeg1_flat.setModelRendererName("lLeg1_flat");
		this.registerModelRenderer(lLeg1_flat);

		lLeg1 = new AnimatedModelRenderer(this);
		lLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		lLeg1_flat.addChild(lLeg1);
		setRotationAngle(lLeg1, -0.4302F, 0.0F, 0.0F);
		lLeg1.setTextureOffset(0, 46).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 14.0F, 7.0F, 0.0F, true);
		lLeg1.setModelRendererName("lLeg1");
		this.registerModelRenderer(lLeg1);

		lLeg2 = new AnimatedModelRenderer(this);
		lLeg2.setRotationPoint(0.0F, 13.5F, -3.0F);
		lLeg1.addChild(lLeg2);
		setRotationAngle(lLeg2, 1.0928F, 0.0F, 0.0F);
		lLeg2.setTextureOffset(28, 46).addBox(-3.0F, 0.0F, -0.5F, 6.0F, 13.0F, 5.0F, 0.0F, true);
		lLeg2.setModelRendererName("lLeg2");
		this.registerModelRenderer(lLeg2);

		lLeg3 = new AnimatedModelRenderer(this);
		lLeg3.setRotationPoint(0.0F, 13.0F, 4.5F);
		lLeg2.addChild(lLeg3);
		setRotationAngle(lLeg3, -0.9105F, 0.0F, 0.0F);
		lLeg3.setTextureOffset(50, 47).addBox(-2.5F, 0.0F, -4.0F, 5.0F, 11.0F, 4.0F, 0.0F, true);
		lLeg3.setModelRendererName("lLeg3");
		this.registerModelRenderer(lLeg3);

		lFoot = new AnimatedModelRenderer(this);
		lFoot.setRotationPoint(0.0F, 10.0F, -2.0F);
		lLeg3.addChild(lFoot);
		setRotationAngle(lFoot, 0.2276F, 0.0F, 0.0F);
		lFoot.setTextureOffset(48, 36).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 5.0F, 0.0F, true);
		lFoot.setModelRendererName("lFoot");
		this.registerModelRenderer(lFoot);

		rLeg1_flat = new AnimatedModelRenderer(this);
		rLeg1_flat.setRotationPoint(-4.5F, -5.1F, 0.0F);
		rLeg1_flat.setTextureOffset(0, 67).addBox(-3.5F, 0.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		rLeg1_flat.setModelRendererName("rLeg1_flat");
		this.registerModelRenderer(rLeg1_flat);

		rLeg1 = new AnimatedModelRenderer(this);
		rLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rLeg1_flat.addChild(rLeg1);
		setRotationAngle(rLeg1, -0.4302F, 0.0F, 0.0F);
		rLeg1.setTextureOffset(0, 67).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 14.0F, 7.0F, 0.0F, true);
		rLeg1.setModelRendererName("rLeg1");
		this.registerModelRenderer(rLeg1);

		rLeg2 = new AnimatedModelRenderer(this);
		rLeg2.setRotationPoint(0.0F, 13.5F, -3.0F);
		rLeg1.addChild(rLeg2);
		setRotationAngle(rLeg2, 1.0928F, 0.0F, 0.0F);
		rLeg2.setTextureOffset(42, 64).addBox(-2.5F, 0.0F, -0.5F, 5.0F, 11.0F, 5.0F, 0.0F, true);
		rLeg2.setModelRendererName("rLeg2");
		this.registerModelRenderer(rLeg2);

		rLeg3 = new AnimatedModelRenderer(this);
		rLeg3.setRotationPoint(0.0F, 11.0F, 4.5F);
		rLeg2.addChild(rLeg3);
		setRotationAngle(rLeg3, -0.9105F, 0.0F, 0.0F);
		rLeg3.setTextureOffset(0, 88).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 7.0F, 4.0F, 0.0F, true);
		rLeg3.setModelRendererName("rLeg3");
		this.registerModelRenderer(rLeg3);

		rFoot = new AnimatedModelRenderer(this);
		rFoot.setRotationPoint(0.0F, 9.0F, -2.0F);
		rLeg3.addChild(rFoot);
		setRotationAngle(rFoot, 0.2276F, 0.0F, 0.0F);
		rFoot.setTextureOffset(36, 84).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 5.0F, 0.0F, true);
		rFoot.setModelRendererName("rFoot");
		this.registerModelRenderer(rFoot);

		rLeg3_2 = new AnimatedModelRenderer(this);
		rLeg3_2.setRotationPoint(0.0F, 7.0F, -2.0F);
		rLeg3.addChild(rLeg3_2);
		rLeg3_2.setTextureOffset(20, 88).addBox(-2.5F, 0.0F, -1.5F, 5.0F, 3.0F, 3.0F, 0.0F, true);
		rLeg3_2.setModelRendererName("rLeg3_2");
		this.registerModelRenderer(rLeg3_2);

		rLegP2 = new AnimatedModelRenderer(this);
		rLegP2.setRotationPoint(3.0F, 0.5F, 0.0F);
		rLeg1.addChild(rLegP2);
		rLegP2.setTextureOffset(28, 64).addBox(0.0F, 0.0F, -3.0F, 1.0F, 14.0F, 6.0F, 0.0F, true);
		rLegP2.setModelRendererName("rLegP2");
		this.registerModelRenderer(rLegP2);

		rLegP1 = new AnimatedModelRenderer(this);
		rLegP1.setRotationPoint(-4.0F, 0.5F, 0.0F);
		rLeg1.addChild(rLegP1);
		rLegP1.setTextureOffset(28, 64).addBox(0.0F, 0.0F, -3.0F, 1.0F, 14.0F, 6.0F, 0.0F, true);
		rLegP1.setModelRendererName("rLegP1");
		this.registerModelRenderer(rLegP1);

		this.rootBones.add(thighs);
		this.rootBones.add(lLeg1_flat);
		this.rootBones.add(rLeg1_flat);
	}

	@Override
	public ResourceLocation getAnimationFileLocation() {
		return new ResourceLocation(DoomMod.MODID, "animations/cyberdemon_animation.json");
	}
}