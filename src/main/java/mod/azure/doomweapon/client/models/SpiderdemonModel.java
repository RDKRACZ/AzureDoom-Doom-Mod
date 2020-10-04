package mod.azure.doomweapon.client.models;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.SpiderdemonEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class SpiderdemonModel extends AnimatedEntityModel<SpiderdemonEntity> {

	private final AnimatedModelRenderer base;
	private final AnimatedModelRenderer rLeg2_1_flat;
	private final AnimatedModelRenderer rLeg2_1;
	private final AnimatedModelRenderer rLeg2_2;
	private final AnimatedModelRenderer rLeg2_3;
	private final AnimatedModelRenderer rLeg2_4;
	private final AnimatedModelRenderer rLeg2_5;
	private final AnimatedModelRenderer lLeg1_1_flat;
	private final AnimatedModelRenderer lLeg1_1;
	private final AnimatedModelRenderer lLeg1_2;
	private final AnimatedModelRenderer lLeg1_3;
	private final AnimatedModelRenderer lLeg1_4;
	private final AnimatedModelRenderer lLeg1_5;
	private final AnimatedModelRenderer gunBase;
	private final AnimatedModelRenderer gunBarrel;
	private final AnimatedModelRenderer lLeg2_1_flat;
	private final AnimatedModelRenderer lLeg2_1;
	private final AnimatedModelRenderer lLeg2_2;
	private final AnimatedModelRenderer lLeg2_3;
	private final AnimatedModelRenderer lLeg2_4;
	private final AnimatedModelRenderer lLeg2_5;
	private final AnimatedModelRenderer rLeg1_1_flat;
	private final AnimatedModelRenderer rLeg1_1;
	private final AnimatedModelRenderer rLeg1_2;
	private final AnimatedModelRenderer rLeg1_3;
	private final AnimatedModelRenderer rLeg1_4;
	private final AnimatedModelRenderer rLeg1_5;
	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer topL;
	private final AnimatedModelRenderer lWire;
	private final AnimatedModelRenderer topR;
	private final AnimatedModelRenderer rWire;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer topJaw;
	private final AnimatedModelRenderer snout;
	private final AnimatedModelRenderer topTeeth;
	private final AnimatedModelRenderer lEye;
	private final AnimatedModelRenderer rEye;
	private final AnimatedModelRenderer lowJaw;
	private final AnimatedModelRenderer lowTeeth;

	public SpiderdemonModel() {
		textureWidth = 200;
		textureHeight = 160;
		base = new AnimatedModelRenderer(this);
		base.setRotationPoint(0.0F, -6.5F, 3.0F);
		setRotationAngle(base, 0.0F, 0.0F, 0.0063F);
		base.setTextureOffset(0, 94).addBox(-17.0F, 0.0F, -18.0F, 35.0F, 8.0F, 36.0F, 0.0F, false);
		base.setModelRendererName("base");
		this.registerModelRenderer(base);

		rLeg2_1_flat = new AnimatedModelRenderer(this);
		rLeg2_1_flat.setRotationPoint(13.0F, 5.0F, 17.0F);
		base.addChild(rLeg2_1_flat);
		rLeg2_1_flat.setTextureOffset(0, 94).addBox(2.5F, 0.0F, -2.5F, 0.0F, 0.0F, 0.0F, 0.0F, false);
		rLeg2_1_flat.setModelRendererName("rLeg2_1_flat");
		this.registerModelRenderer(rLeg2_1_flat);

		rLeg2_1 = new AnimatedModelRenderer(this);
		rLeg2_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rLeg2_1_flat.addChild(rLeg2_1);
		setRotationAngle(rLeg2_1, 1.7757F, 0.6829F, 0.0F);
		rLeg2_1.setTextureOffset(0, 94).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, false);
		rLeg2_1.setModelRendererName("rLeg2_1");
		this.registerModelRenderer(rLeg2_1);

		rLeg2_2 = new AnimatedModelRenderer(this);
		rLeg2_2.setRotationPoint(0.0F, 24.0F, 0.0F);
		rLeg2_1.addChild(rLeg2_2);
		setRotationAngle(rLeg2_2, -0.4098F, 0.0F, 0.0F);
		rLeg2_2.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		rLeg2_2.setModelRendererName("rLeg2_2");
		this.registerModelRenderer(rLeg2_2);

		rLeg2_3 = new AnimatedModelRenderer(this);
		rLeg2_3.setRotationPoint(0.0F, 4.0F, 0.0F);
		rLeg2_2.addChild(rLeg2_3);
		setRotationAngle(rLeg2_3, -0.6829F, 0.0F, 0.0F);
		rLeg2_3.setTextureOffset(0, 94).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, false);
		rLeg2_3.setModelRendererName("rLeg2_3");
		this.registerModelRenderer(rLeg2_3);

		rLeg2_4 = new AnimatedModelRenderer(this);
		rLeg2_4.setRotationPoint(0.0F, 24.0F, 0.0F);
		rLeg2_3.addChild(rLeg2_4);
		setRotationAngle(rLeg2_4, -0.5463F, 0.0F, 0.0F);
		rLeg2_4.setTextureOffset(0, 12).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, false);
		rLeg2_4.setModelRendererName("rLeg2_4");
		this.registerModelRenderer(rLeg2_4);

		rLeg2_5 = new AnimatedModelRenderer(this);
		rLeg2_5.setRotationPoint(0.0F, 7.2F, 0.0F);
		rLeg2_4.addChild(rLeg2_5);
		setRotationAngle(rLeg2_5, -0.182F, 0.0F, 0.0F);
		rLeg2_5.setTextureOffset(67, 68).addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F, 0.0F, false);
		rLeg2_5.setModelRendererName("rLeg2_5");
		this.registerModelRenderer(rLeg2_5);

		lLeg1_1_flat = new AnimatedModelRenderer(this);
		lLeg1_1_flat.setRotationPoint(-13.0F, 5.0F, -15.0F);
		base.addChild(lLeg1_1_flat);
		lLeg1_1_flat.setTextureOffset(0, 94).addBox(1.5F, 0.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lLeg1_1_flat.setModelRendererName("lLeg1_1_flat");
		this.registerModelRenderer(lLeg1_1_flat);

		lLeg1_1 = new AnimatedModelRenderer(this);
		lLeg1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		lLeg1_1_flat.addChild(lLeg1_1);
		setRotationAngle(lLeg1_1, -1.7757F, 0.6829F, 0.0F);
		lLeg1_1.setTextureOffset(0, 94).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, false);
		lLeg1_1.setModelRendererName("lLeg1_1");
		this.registerModelRenderer(lLeg1_1);

		lLeg1_2 = new AnimatedModelRenderer(this);
		lLeg1_2.setRotationPoint(0.0F, 24.0F, 0.0F);
		lLeg1_1.addChild(lLeg1_2);
		setRotationAngle(lLeg1_2, 0.4098F, 0.0F, 0.0F);
		lLeg1_2.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		lLeg1_2.setModelRendererName("lLeg1_2");
		this.registerModelRenderer(lLeg1_2);

		lLeg1_3 = new AnimatedModelRenderer(this);
		lLeg1_3.setRotationPoint(0.0F, 4.0F, 0.0F);
		lLeg1_2.addChild(lLeg1_3);
		setRotationAngle(lLeg1_3, 0.6829F, 0.0F, 0.0F);
		lLeg1_3.setTextureOffset(0, 94).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, false);
		lLeg1_3.setModelRendererName("lLeg1_3");
		this.registerModelRenderer(lLeg1_3);

		lLeg1_4 = new AnimatedModelRenderer(this);
		lLeg1_4.setRotationPoint(0.0F, 24.0F, 0.0F);
		lLeg1_3.addChild(lLeg1_4);
		setRotationAngle(lLeg1_4, 0.5463F, 0.0F, 0.0F);
		lLeg1_4.setTextureOffset(0, 12).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, false);
		lLeg1_4.setModelRendererName("lLeg1_4");
		this.registerModelRenderer(lLeg1_4);

		lLeg1_5 = new AnimatedModelRenderer(this);
		lLeg1_5.setRotationPoint(0.0F, 7.2F, 0.0F);
		lLeg1_4.addChild(lLeg1_5);
		setRotationAngle(lLeg1_5, 0.182F, 0.0F, 0.0F);
		lLeg1_5.setTextureOffset(67, 68).addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F, 0.0F, false);
		lLeg1_5.setModelRendererName("lLeg1_5");
		this.registerModelRenderer(lLeg1_5);

		gunBase = new AnimatedModelRenderer(this);
		gunBase.setRotationPoint(0.0F, 0.2F, -20.0F);
		base.addChild(gunBase);
		gunBase.setTextureOffset(0, 138).addBox(-7.5F, 0.0F, 0.0F, 15.0F, 7.0F, 2.0F, 0.0F, false);
		gunBase.setModelRendererName("gunBase");
		this.registerModelRenderer(gunBase);

		gunBarrel = new AnimatedModelRenderer(this);
		gunBarrel.setRotationPoint(0.0F, 0.5F, 0.0F);
		gunBase.addChild(gunBarrel);
		gunBarrel.setTextureOffset(35, 138).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 6.0F, 4.0F, 0.0F, false);
		gunBarrel.setModelRendererName("gunBarrel");
		this.registerModelRenderer(gunBarrel);

		lLeg2_1_flat = new AnimatedModelRenderer(this);
		lLeg2_1_flat.setRotationPoint(-13.0F, 5.0F, 17.0F);
		base.addChild(lLeg2_1_flat);
		lLeg2_1_flat.setTextureOffset(0, 94).addBox(1.5F, 0.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lLeg2_1_flat.setModelRendererName("lLeg2_1_flat");
		this.registerModelRenderer(lLeg2_1_flat);

		lLeg2_1 = new AnimatedModelRenderer(this);
		lLeg2_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		lLeg2_1_flat.addChild(lLeg2_1);
		setRotationAngle(lLeg2_1, 1.7757F, -0.6829F, 0.0F);
		lLeg2_1.setTextureOffset(0, 94).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, false);
		lLeg2_1.setModelRendererName("lLeg2_1");
		this.registerModelRenderer(lLeg2_1);

		lLeg2_2 = new AnimatedModelRenderer(this);
		lLeg2_2.setRotationPoint(0.0F, 24.0F, 0.0F);
		lLeg2_1.addChild(lLeg2_2);
		setRotationAngle(lLeg2_2, -0.4098F, 0.0F, 0.0F);
		lLeg2_2.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		lLeg2_2.setModelRendererName("lLeg2_2");
		this.registerModelRenderer(lLeg2_2);

		lLeg2_3 = new AnimatedModelRenderer(this);
		lLeg2_3.setRotationPoint(0.0F, 4.0F, 0.0F);
		lLeg2_2.addChild(lLeg2_3);
		setRotationAngle(lLeg2_3, -0.6829F, 0.0F, 0.0F);
		lLeg2_3.setTextureOffset(0, 94).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, false);
		lLeg2_3.setModelRendererName("lLeg2_3");
		this.registerModelRenderer(lLeg2_3);

		lLeg2_4 = new AnimatedModelRenderer(this);
		lLeg2_4.setRotationPoint(0.0F, 24.0F, 0.0F);
		lLeg2_3.addChild(lLeg2_4);
		setRotationAngle(lLeg2_4, -0.5463F, 0.0F, 0.0F);
		lLeg2_4.setTextureOffset(0, 12).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, false);
		lLeg2_4.setModelRendererName("lLeg2_4");
		this.registerModelRenderer(lLeg2_4);

		lLeg2_5 = new AnimatedModelRenderer(this);
		lLeg2_5.setRotationPoint(0.0F, 7.2F, 0.0F);
		lLeg2_4.addChild(lLeg2_5);
		setRotationAngle(lLeg2_5, -0.182F, 0.0F, 0.0F);
		lLeg2_5.setTextureOffset(67, 68).addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F, 0.0F, false);
		lLeg2_5.setModelRendererName("lLeg2_5");
		this.registerModelRenderer(lLeg2_5);

		rLeg1_1_flat = new AnimatedModelRenderer(this);
		rLeg1_1_flat.setRotationPoint(13.0F, 5.0F, -15.0F);
		base.addChild(rLeg1_1_flat);
		rLeg1_1_flat.setTextureOffset(0, 94).addBox(1.5F, 0.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rLeg1_1_flat.setModelRendererName("rLeg1_1_flat");
		this.registerModelRenderer(rLeg1_1_flat);

		rLeg1_1 = new AnimatedModelRenderer(this);
		rLeg1_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rLeg1_1_flat.addChild(rLeg1_1);
		setRotationAngle(rLeg1_1, -1.7757F, -0.6829F, 0.0F);
		rLeg1_1.setTextureOffset(0, 94).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, false);
		rLeg1_1.setModelRendererName("rLeg1_1");
		this.registerModelRenderer(rLeg1_1);

		rLeg1_2 = new AnimatedModelRenderer(this);
		rLeg1_2.setRotationPoint(0.0F, 24.0F, 0.0F);
		rLeg1_1.addChild(rLeg1_2);
		setRotationAngle(rLeg1_2, 0.4098F, 0.0F, 0.0F);
		rLeg1_2.setTextureOffset(0, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		rLeg1_2.setModelRendererName("rLeg1_2");
		this.registerModelRenderer(rLeg1_2);

		rLeg1_3 = new AnimatedModelRenderer(this);
		rLeg1_3.setRotationPoint(0.0F, 4.0F, 0.0F);
		rLeg1_2.addChild(rLeg1_3);
		setRotationAngle(rLeg1_3, 0.6829F, 0.0F, 0.0F);
		rLeg1_3.setTextureOffset(0, 94).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 26.0F, 5.0F, 0.0F, false);
		rLeg1_3.setModelRendererName("rLeg1_3");
		this.registerModelRenderer(rLeg1_3);

		rLeg1_4 = new AnimatedModelRenderer(this);
		rLeg1_4.setRotationPoint(0.0F, 24.0F, 0.0F);
		rLeg1_3.addChild(rLeg1_4);
		setRotationAngle(rLeg1_4, 0.5463F, 0.0F, 0.0F);
		rLeg1_4.setTextureOffset(0, 12).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, false);
		rLeg1_4.setModelRendererName("rLeg1_4");
		this.registerModelRenderer(rLeg1_4);

		rLeg1_5 = new AnimatedModelRenderer(this);
		rLeg1_5.setRotationPoint(0.0F, 7.2F, 0.0F);
		rLeg1_4.addChild(rLeg1_5);
		setRotationAngle(rLeg1_5, 0.182F, 0.0F, 0.0F);
		rLeg1_5.setTextureOffset(67, 68).addBox(-4.5F, 0.0F, -4.5F, 9.0F, 4.0F, 9.0F, 0.0F, false);
		rLeg1_5.setModelRendererName("rLeg1_5");
		this.registerModelRenderer(rLeg1_5);

		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(0.0F, -4.0F, -3.5F);
		base.addChild(body);
		body.setTextureOffset(0, 0).addBox(-16.5F, -11.0F, -13.5F, 34.0F, 15.0F, 34.0F, 0.0F, false);
		body.setModelRendererName("body");
		this.registerModelRenderer(body);

		topL = new AnimatedModelRenderer(this);
		topL.setRotationPoint(2.0F, -17.5F, 0.0F);
		body.addChild(topL);
		setRotationAngle(topL, 0.0F, 0.0F, 0.2731F);
		topL.setTextureOffset(0, 49).addBox(0.0F, -5.0F, -13.0F, 17.0F, 12.0F, 33.0F, 0.0F, false);
		topL.setModelRendererName("topL");
		this.registerModelRenderer(topL);

		lWire = new AnimatedModelRenderer(this);
		lWire.setRotationPoint(9.0F, 3.0F, 3.0F);
		topL.addChild(lWire);
		setRotationAngle(lWire, 0.0F, 0.0F, 0.7285F);
		lWire.setTextureOffset(91, 3).addBox(-1.0F, -17.0F, -23.0F, 1.0F, 17.0F, 46.0F, 0.0F, false);
		lWire.setModelRendererName("lWire");
		this.registerModelRenderer(lWire);

		topR = new AnimatedModelRenderer(this);
		topR.setRotationPoint(-2.0F, -17.5F, 0.0F);
		body.addChild(topR);
		setRotationAngle(topR, 0.0F, 0.0F, -0.2731F);
		topR.setTextureOffset(0, 49).addBox(-16.0F, -5.0F, -13.0F, 17.0F, 12.0F, 33.0F, 0.0F, false);
		topR.setModelRendererName("topR");
		this.registerModelRenderer(topR);

		rWire = new AnimatedModelRenderer(this);
		rWire.setRotationPoint(-9.0F, 3.0F, 3.0F);
		topR.addChild(rWire);
		setRotationAngle(rWire, 0.0F, 0.0F, -0.7285F);
		rWire.setTextureOffset(91, 3).addBox(-1.0F, -17.0F, -23.0F, 1.0F, 17.0F, 46.0F, 0.0F, false);
		rWire.setModelRendererName("rWire");
		this.registerModelRenderer(rWire);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(1.0F, -7.3F, -13.4F);
		body.addChild(head);
		head.setTextureOffset(0, 49).addBox(-5.0F, -1.0F, -1.0F, 10.0F, 10.0F, 1.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		topJaw = new AnimatedModelRenderer(this);
		topJaw.setRotationPoint(0.0F, 3.9F, -1.0F);
		head.addChild(topJaw);
		topJaw.setTextureOffset(0, 60).addBox(-3.5F, -2.0F, -3.0F, 7.0F, 4.0F, 3.0F, 0.0F, false);
		topJaw.setModelRendererName("topJaw");
		this.registerModelRenderer(topJaw);

		snout = new AnimatedModelRenderer(this);
		snout.setRotationPoint(0.0F, -1.7F, -3.0F);
		topJaw.addChild(snout);
		setRotationAngle(snout, 0.7741F, 0.0F, 0.0F);
		snout.setTextureOffset(0, 67).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 4.0F, 0.0F, false);
		snout.setModelRendererName("snout");
		this.registerModelRenderer(snout);

		topTeeth = new AnimatedModelRenderer(this);
		topTeeth.setRotationPoint(0.0F, 0.4F, -2.8F);
		topJaw.addChild(topTeeth);
		topTeeth.setTextureOffset(0, 125).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 3.0F, 0.0F, false);
		topTeeth.setModelRendererName("topTeeth");
		this.registerModelRenderer(topTeeth);

		lEye = new AnimatedModelRenderer(this);
		lEye.setRotationPoint(-5.5F, 7.0F, -0.6F);
		head.addChild(lEye);
		setRotationAngle(lEye, 0.0F, 0.0F, 0.6374F);
		lEye.setTextureOffset(0, 74).addBox(-9.0F, -7.0F, 0.0F, 9.0F, 7.0F, 1.0F, 0.0F, false);
		lEye.setModelRendererName("lEye");
		this.registerModelRenderer(lEye);

		rEye = new AnimatedModelRenderer(this);
		rEye.setRotationPoint(5.0F, 7.0F, -0.6F);
		head.addChild(rEye);
		setRotationAngle(rEye, 0.0F, 0.0F, -0.6374F);
		rEye.setTextureOffset(0, 74).addBox(0.0F, -7.0F, 0.0F, 9.0F, 7.0F, 1.0F, 0.0F, true);
		rEye.setModelRendererName("rEye");
		this.registerModelRenderer(rEye);

		lowJaw = new AnimatedModelRenderer(this);
		lowJaw.setRotationPoint(0.0F, 5.8F, -0.9F);
		head.addChild(lowJaw);
		setRotationAngle(lowJaw, 0.9105F, 0.0F, 0.0F);
		lowJaw.setTextureOffset(0, 27).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		lowJaw.setModelRendererName("lowJaw");
		this.registerModelRenderer(lowJaw);

		lowTeeth = new AnimatedModelRenderer(this);
		lowTeeth.setRotationPoint(0.5F, -1.3F, -2.6F);
		lowJaw.addChild(lowTeeth);
		lowTeeth.setTextureOffset(18, 125).addBox(-3.0F, 0.0F, 0.0F, 5.0F, 2.0F, 3.0F, 0.0F, false);
		lowTeeth.setModelRendererName("lowTeeth");
		this.registerModelRenderer(lowTeeth);

		this.rootBones.add(base);
	}

	@Override
	public ResourceLocation getAnimationFileLocation() {
		return new ResourceLocation(DoomMod.MODID, "animations/spidermastermind_animation.json");
	}
}