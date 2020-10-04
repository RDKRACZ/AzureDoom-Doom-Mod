package mod.azure.doomweapon.client.models;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.PinkyEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

/**
 * Pinky - Batpixxler
 */
public class PinkyModel extends AnimatedEntityModel<PinkyEntity> {

	private final AnimatedModelRenderer thighs;
	private final AnimatedModelRenderer chest;
	private final AnimatedModelRenderer rShoulder;
	private final AnimatedModelRenderer rArm1;
	private final AnimatedModelRenderer rArm2;
	private final AnimatedModelRenderer neck;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer lEye;
	private final AnimatedModelRenderer topJaw;
	private final AnimatedModelRenderer topTeeth;
	private final AnimatedModelRenderer snout;
	private final AnimatedModelRenderer rHorn1;
	private final AnimatedModelRenderer rHorn2;
	private final AnimatedModelRenderer rHorn3;
	private final AnimatedModelRenderer lHorn1;
	private final AnimatedModelRenderer lHorn2;
	private final AnimatedModelRenderer lHorn3;
	private final AnimatedModelRenderer lowJaw_flat;
	private final AnimatedModelRenderer lowJaw;
	private final AnimatedModelRenderer lowTeeth;
	private final AnimatedModelRenderer rEye;
	private final AnimatedModelRenderer lShoulder;
	private final AnimatedModelRenderer lArm1;
	private final AnimatedModelRenderer lArm2;
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

	public PinkyModel() {
		textureWidth = 60;
		textureHeight = 120;
		thighs = new AnimatedModelRenderer(this);
		thighs.setRotationPoint(0.0F, 1.6F, 3.0F);
		setRotationAngle(thighs, 0.182F, 0.0F, 0.0F);
		thighs.setTextureOffset(0, 18).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 7.0F, 6.0F, 0.0F, false);
		thighs.setModelRendererName("thighs");
		this.registerModelRenderer(thighs);

		chest = new AnimatedModelRenderer(this);
		chest.setRotationPoint(0.0F, 0.5F, 0.1F);
		thighs.addChild(chest);
		setRotationAngle(chest, 0.2276F, 0.0F, 0.0F);
		chest.setTextureOffset(15, 0).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 10.0F, 8.0F, 0.0F, false);
		chest.setModelRendererName("chest");
		this.registerModelRenderer(chest);

		rShoulder = new AnimatedModelRenderer(this);
		rShoulder.setRotationPoint(4.0F, -9.0F, -3.8F);
		chest.addChild(rShoulder);
		setRotationAngle(rShoulder, 0.0F, 0.0F, -0.3643F);
		rShoulder.setTextureOffset(0, 72).addBox(-1.0F, -2.0F, -2.0F, 5.0F, 6.0F, 5.0F, 0.0F, false);
		rShoulder.setModelRendererName("rShoulder");
		this.registerModelRenderer(rShoulder);

		rArm1 = new AnimatedModelRenderer(this);
		rArm1.setRotationPoint(1.5F, 2.0F, 0.5F);
		rShoulder.addChild(rArm1);
		rArm1.setTextureOffset(20, 72).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		rArm1.setModelRendererName("rArm1");
		this.registerModelRenderer(rArm1);

		rArm2 = new AnimatedModelRenderer(this);
		rArm2.setRotationPoint(0.0F, 8.0F, 2.0F);
		rArm1.addChild(rArm2);
		setRotationAngle(rArm2, -0.3643F, 0.0F, 0.0F);
		rArm2.setTextureOffset(36, 72).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);
		rArm2.setModelRendererName("rArm2");
		this.registerModelRenderer(rArm2);

		neck = new AnimatedModelRenderer(this);
		neck.setRotationPoint(0.0F, -10.0F, 1.0F);
		chest.addChild(neck);
		setRotationAngle(neck, -0.0911F, 0.0F, 0.0F);
		neck.setTextureOffset(0, 31).addBox(-4.0F, 0.0F, -12.0F, 8.0F, 8.0F, 12.0F, 0.0F, false);
		neck.setModelRendererName("neck");
		this.registerModelRenderer(neck);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, 1.0F, -10.8F);
		neck.addChild(head);
		setRotationAngle(head, -0.1367F, 0.0F, 0.0F);
		head.setTextureOffset(0, 51).addBox(-4.5F, -1.0F, -5.0F, 9.0F, 6.0F, 5.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		lEye = new AnimatedModelRenderer(this);
		lEye.setRotationPoint(-1.8F, 1.0F, -3.7F);
		head.addChild(lEye);
		setRotationAngle(lEye, 0.1367F, 0.2276F, 0.0F);
		lEye.setTextureOffset(21, 62).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, false);
		lEye.setModelRendererName("lEye");
		this.registerModelRenderer(lEye);

		topJaw = new AnimatedModelRenderer(this);
		topJaw.setRotationPoint(0.0F, 2.5F, -4.0F);
		head.addChild(topJaw);
		setRotationAngle(topJaw, 0.2276F, 0.0F, 0.0F);
		topJaw.setTextureOffset(23, 51).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);
		topJaw.setModelRendererName("topJaw");
		this.registerModelRenderer(topJaw);

		topTeeth = new AnimatedModelRenderer(this);
		topTeeth.setRotationPoint(0.0F, 1.8F, -1.8F);
		topJaw.addChild(topTeeth);
		topTeeth.setTextureOffset(26, 20).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		topTeeth.setModelRendererName("topTeeth");
		this.registerModelRenderer(topTeeth);

		snout = new AnimatedModelRenderer(this);
		snout.setRotationPoint(0.0F, 0.0F, -1.9F);
		topJaw.addChild(snout);
		setRotationAngle(snout, 1.1383F, 0.0F, 0.0F);
		snout.setTextureOffset(0, 0).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 2.0F, 4.0F, 0.0F, false);
		snout.setModelRendererName("snout");
		this.registerModelRenderer(snout);

		rHorn1 = new AnimatedModelRenderer(this);
		rHorn1.setRotationPoint(3.0F, 1.0F, -2.0F);
		head.addChild(rHorn1);
		setRotationAngle(rHorn1, 0.2276F, 0.0F, -2.2764F);
		rHorn1.setTextureOffset(20, 96).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		rHorn1.setModelRendererName("rHorn1");
		this.registerModelRenderer(rHorn1);

		rHorn2 = new AnimatedModelRenderer(this);
		rHorn2.setRotationPoint(0.0F, 2.5F, 0.0F);
		rHorn1.addChild(rHorn2);
		setRotationAngle(rHorn2, -0.3643F, 0.0F, 0.0F);
		rHorn2.setTextureOffset(32, 96).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		rHorn2.setModelRendererName("rHorn2");
		this.registerModelRenderer(rHorn2);

		rHorn3 = new AnimatedModelRenderer(this);
		rHorn3.setRotationPoint(0.0F, 2.5F, 0.0F);
		rHorn2.addChild(rHorn3);
		setRotationAngle(rHorn3, -0.7285F, 0.0F, 0.0F);
		rHorn3.setTextureOffset(40, 96).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		rHorn3.setModelRendererName("rHorn3");
		this.registerModelRenderer(rHorn3);

		lHorn1 = new AnimatedModelRenderer(this);
		lHorn1.setRotationPoint(-3.0F, 1.0F, -2.0F);
		head.addChild(lHorn1);
		setRotationAngle(lHorn1, 0.2276F, 0.0F, 2.2764F);
		lHorn1.setTextureOffset(20, 96).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		lHorn1.setModelRendererName("lHorn1");
		this.registerModelRenderer(lHorn1);

		lHorn2 = new AnimatedModelRenderer(this);
		lHorn2.setRotationPoint(0.0F, 2.5F, 0.0F);
		lHorn1.addChild(lHorn2);
		setRotationAngle(lHorn2, -0.3643F, 0.0F, 0.0F);
		lHorn2.setTextureOffset(32, 96).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
		lHorn2.setModelRendererName("lHorn2");
		this.registerModelRenderer(lHorn2);

		lHorn3 = new AnimatedModelRenderer(this);
		lHorn3.setRotationPoint(0.0F, 2.5F, 0.0F);
		lHorn2.addChild(lHorn3);
		setRotationAngle(lHorn3, -0.7285F, 0.0F, 0.0F);
		lHorn3.setTextureOffset(40, 96).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		lHorn3.setModelRendererName("lHorn3");
		this.registerModelRenderer(lHorn3);

		lowJaw_flat = new AnimatedModelRenderer(this);
		lowJaw_flat.setRotationPoint(0.0F, 4.0F, -0.5F);
		head.addChild(lowJaw_flat);
		lowJaw_flat.setTextureOffset(0, 62).addBox(2.5F, 0.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lowJaw_flat.setModelRendererName("lowJaw_flat");
		this.registerModelRenderer(lowJaw_flat);

		lowJaw = new AnimatedModelRenderer(this);
		lowJaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		lowJaw_flat.addChild(lowJaw);
		setRotationAngle(lowJaw, 0.8652F, 0.0F, 0.0F);
		lowJaw.setTextureOffset(0, 62).addBox(-3.5F, 0.0F, -7.0F, 7.0F, 3.0F, 7.0F, 0.0F, false);
		lowJaw.setModelRendererName("lowJaw");
		this.registerModelRenderer(lowJaw);

		lowTeeth = new AnimatedModelRenderer(this);
		lowTeeth.setRotationPoint(0.0F, 0.3F, -6.9F);
		lowJaw.addChild(lowTeeth);
		lowTeeth.setTextureOffset(28, 32).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 2.0F, 1.0F, 0.0F, false);
		lowTeeth.setModelRendererName("lowTeeth");
		this.registerModelRenderer(lowTeeth);

		rEye = new AnimatedModelRenderer(this);
		rEye.setRotationPoint(1.8F, 1.0F, -3.7F);
		head.addChild(rEye);
		setRotationAngle(rEye, 0.1367F, -0.2276F, 0.0F);
		rEye.setTextureOffset(21, 62).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 3.0F, 0.0F, true);
		rEye.setModelRendererName("rEye");
		this.registerModelRenderer(rEye);

		lShoulder = new AnimatedModelRenderer(this);
		lShoulder.setRotationPoint(-4.0F, -9.0F, -3.9F);
		chest.addChild(lShoulder);
		setRotationAngle(lShoulder, 0.0F, 0.0F, 0.3643F);
		lShoulder.setTextureOffset(0, 72).addBox(-4.0F, -2.0F, -2.0F, 5.0F, 6.0F, 5.0F, 0.0F, false);
		lShoulder.setModelRendererName("lShoulder");
		this.registerModelRenderer(lShoulder);

		lArm1 = new AnimatedModelRenderer(this);
		lArm1.setRotationPoint(-1.5F, 2.0F, 0.5F);
		lShoulder.addChild(lArm1);
		lArm1.setTextureOffset(20, 72).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		lArm1.setModelRendererName("lArm1");
		this.registerModelRenderer(lArm1);

		lArm2 = new AnimatedModelRenderer(this);
		lArm2.setRotationPoint(0.0F, 8.0F, 2.0F);
		lArm1.addChild(lArm2);
		setRotationAngle(lArm2, -0.3643F, 0.0F, 0.0F);
		lArm2.setTextureOffset(36, 72).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);
		lArm2.setModelRendererName("lArm2");
		this.registerModelRenderer(lArm2);

		lLeg1_flat = new AnimatedModelRenderer(this);
		lLeg1_flat.setRotationPoint(-3.0F, 6.9F, 2.0F);
		lLeg1_flat.setTextureOffset(0, 83).addBox(2.0F, 0.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lLeg1_flat.setModelRendererName("lLeg1_flat");
		this.registerModelRenderer(lLeg1_flat);

		lLeg1 = new AnimatedModelRenderer(this);
		lLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		lLeg1_flat.addChild(lLeg1);
		setRotationAngle(lLeg1, -0.4691F, 0.0F, 0.1658F);
		lLeg1.setTextureOffset(0, 83).addBox(-3.0F, 0.0F, -2.5F, 6.0F, 6.0F, 5.0F, 0.0F, false);
		lLeg1.setModelRendererName("lLeg1");
		this.registerModelRenderer(lLeg1);

		lLeg2 = new AnimatedModelRenderer(this);
		lLeg2.setRotationPoint(0.1F, 5.7F, -2.5F);
		lLeg1.addChild(lLeg2);
		setRotationAngle(lLeg2, 0.9561F, 0.0F, -0.1752F);
		lLeg2.setTextureOffset(22, 84).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 8.0F, 4.0F, 0.0F, false);
		lLeg2.setModelRendererName("lLeg2");
		this.registerModelRenderer(lLeg2);

		lLeg3 = new AnimatedModelRenderer(this);
		lLeg3.setRotationPoint(0.0F, 8.0F, 4.0F);
		lLeg2.addChild(lLeg3);
		setRotationAngle(lLeg3, -0.8652F, 0.0911F, -0.0524F);
		lLeg3.setTextureOffset(40, 86).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 7.0F, 3.0F, 0.0F, false);
		lLeg3.setModelRendererName("lLeg3");
		this.registerModelRenderer(lLeg3);

		lFoot = new AnimatedModelRenderer(this);
		lFoot.setRotationPoint(0.0F, 5.5F, 0.0F);
		lLeg3.addChild(lFoot);
		setRotationAngle(lFoot, 0.3643F, 0.0F, 0.0F);
		lFoot.setTextureOffset(0, 94).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 5.0F, 0.0F, false);
		lFoot.setModelRendererName("lFoot");
		this.registerModelRenderer(lFoot);

		rLeg1_flat = new AnimatedModelRenderer(this);
		rLeg1_flat.setRotationPoint(3.0F, 6.9F, 2.0F);
		rLeg1_flat.setTextureOffset(0, 83).addBox(2.0F, 0.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		rLeg1_flat.setModelRendererName("rLeg1_flat");
		this.registerModelRenderer(rLeg1_flat);

		rLeg1 = new AnimatedModelRenderer(this);
		rLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rLeg1_flat.addChild(rLeg1);
		setRotationAngle(rLeg1, -0.4691F, 0.0F, -0.1658F);
		rLeg1.setTextureOffset(0, 83).addBox(-3.0F, 0.0F, -2.5F, 6.0F, 6.0F, 5.0F, 0.0F, false);
		rLeg1.setModelRendererName("rLeg1");
		this.registerModelRenderer(rLeg1);

		rLeg2 = new AnimatedModelRenderer(this);
		rLeg2.setRotationPoint(-0.1F, 5.7F, -2.4F);
		rLeg1.addChild(rLeg2);
		setRotationAngle(rLeg2, 0.9561F, 0.0F, 0.1752F);
		rLeg2.setTextureOffset(22, 84).addBox(-2.5F, 0.0F, 0.0F, 5.0F, 8.0F, 4.0F, 0.0F, false);
		rLeg2.setModelRendererName("rLeg2");
		this.registerModelRenderer(rLeg2);

		rLeg3 = new AnimatedModelRenderer(this);
		rLeg3.setRotationPoint(0.0F, 8.0F, 4.0F);
		rLeg2.addChild(rLeg3);
		setRotationAngle(rLeg3, -0.8652F, -0.0911F, 0.0524F);
		rLeg3.setTextureOffset(40, 86).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 7.0F, 3.0F, 0.0F, false);
		rLeg3.setModelRendererName("rLeg3");
		this.registerModelRenderer(rLeg3);

		rFoot = new AnimatedModelRenderer(this);
		rFoot.setRotationPoint(0.0F, 5.5F, 0.0F);
		rLeg3.addChild(rFoot);
		setRotationAngle(rFoot, 0.3643F, 0.0F, 0.0F);
		rFoot.setTextureOffset(0, 94).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 5.0F, 0.0F, false);
		rFoot.setModelRendererName("rFoot");
		this.registerModelRenderer(rFoot);

		this.rootBones.add(thighs);
		this.rootBones.add(lLeg1_flat);
		this.rootBones.add(rLeg1_flat);
	}

	@Override
	public ResourceLocation getAnimationFileLocation() {
		return new ResourceLocation(DoomMod.MODID, "animations/pinky_animation.json");
	}
}