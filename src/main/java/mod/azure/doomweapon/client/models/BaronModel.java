package mod.azure.doomweapon.client.models;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.BaronEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class BaronModel extends AnimatedEntityModel<BaronEntity> {

	private final AnimatedModelRenderer thighs;
	private final AnimatedModelRenderer chest;
	private final AnimatedModelRenderer rShoulder;
	private final AnimatedModelRenderer rArm1;
	private final AnimatedModelRenderer rArm2;
	private final AnimatedModelRenderer neck;
	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer lowJaw;
	private final AnimatedModelRenderer rMHorn1;
	private final AnimatedModelRenderer rMHorn2;
	private final AnimatedModelRenderer lMHorn1;
	private final AnimatedModelRenderer lMHorn2;
	private final AnimatedModelRenderer lHorn1;
	private final AnimatedModelRenderer lHorn2;
	private final AnimatedModelRenderer lHorn3;
	private final AnimatedModelRenderer lHorn4;
	private final AnimatedModelRenderer topJaw;
	private final AnimatedModelRenderer snout;
	private final AnimatedModelRenderer rHorn1;
	private final AnimatedModelRenderer rHorn2;
	private final AnimatedModelRenderer rHorn3;
	private final AnimatedModelRenderer rHorn4;
	private final AnimatedModelRenderer rightPec;
	private final AnimatedModelRenderer lShoulder;
	private final AnimatedModelRenderer lArm1;
	private final AnimatedModelRenderer lArm2;
	private final AnimatedModelRenderer leftPec;
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

	public BaronModel() {
		textureWidth = 60;
		textureHeight = 180;
		thighs = new AnimatedModelRenderer(this);
		thighs.setRotationPoint(0.0F, -9.0F, 5.0F);
		thighs.setTextureOffset(0, 19).addBox(-6.0F, 0.0F, -7.0F, 12.0F, 10.0F, 8.0F, 0.0F, false);
		thighs.setModelRendererName("thighs");
		this.registerModelRenderer(thighs);

		chest = new AnimatedModelRenderer(this);
		chest.setRotationPoint(0.0F, 0.3F, 0.0F);
		thighs.addChild(chest);
		setRotationAngle(chest, 0.1367F, 0.0F, 0.0F);
		chest.setTextureOffset(0, 0).addBox(-7.5F, -9.0F, -9.0F, 15.0F, 9.0F, 10.0F, 0.0F, false);
		chest.setModelRendererName("chest");
		this.registerModelRenderer(chest);

		rShoulder = new AnimatedModelRenderer(this);
		rShoulder.setRotationPoint(7.5F, -7.5F, -4.0F);
		chest.addChild(rShoulder);
		setRotationAngle(rShoulder, 0.0F, 0.0F, -0.0911F);
		rShoulder.setTextureOffset(0, 71).addBox(-1.0F, -2.0F, -3.5F, 6.0F, 6.0F, 7.0F, 0.0F, false);
		rShoulder.setModelRendererName("rShoulder");
		this.registerModelRenderer(rShoulder);

		rArm1 = new AnimatedModelRenderer(this);
		rArm1.setRotationPoint(2.0F, 4.0F, 0.0F);
		rShoulder.addChild(rArm1);
		rArm1.setTextureOffset(19, 66).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, 0.0F, false);
		rArm1.setModelRendererName("rArm1");
		this.registerModelRenderer(rArm1);

		rArm2 = new AnimatedModelRenderer(this);
		rArm2.setRotationPoint(0.0F, 6.7F, 2.5F);
		rArm1.addChild(rArm2);
		setRotationAngle(rArm2, -0.2731F, 0.0F, 0.0911F);
		rArm2.setTextureOffset(0, 84).addBox(-2.5F, 0.0F, -4.0F, 5.0F, 11.0F, 4.0F, 0.0F, false);
		rArm2.setModelRendererName("rArm2");
		this.registerModelRenderer(rArm2);

		neck = new AnimatedModelRenderer(this);
		neck.setRotationPoint(0.0F, -8.6F, -1.1F);
		chest.addChild(neck);
		setRotationAngle(neck, -0.0456F, 0.0F, 0.0F);
		neck.setTextureOffset(0, 99).addBox(-4.0F, -8.0F, -6.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		neck.setModelRendererName("neck");
		this.registerModelRenderer(neck);

		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, -3.8F, 0.5F);
		neck.addChild(head);
		setRotationAngle(head, 0.0911F, 0.0F, 0.0F);
		head.setTextureOffset(0, 115).addBox(-5.0F, -11.0F, -7.0F, 10.0F, 11.0F, 9.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		lowJaw = new AnimatedModelRenderer(this);
		lowJaw.setRotationPoint(0.0F, -1.0F, -6.5F);
		head.addChild(lowJaw);
		lowJaw.setTextureOffset(0, 144).addBox(-3.0F, -1.0F, -5.0F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		lowJaw.setModelRendererName("lowJaw");
		this.registerModelRenderer(lowJaw);

		rMHorn1 = new AnimatedModelRenderer(this);
		rMHorn1.setRotationPoint(1.5F, 0.1F, -4.0F);
		lowJaw.addChild(rMHorn1);
		setRotationAngle(rMHorn1, -0.3187F, -0.4554F, 0.0F);
		rMHorn1.setTextureOffset(32, 19).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		rMHorn1.setModelRendererName("rMHorn1");
		this.registerModelRenderer(rMHorn1);

		rMHorn2 = new AnimatedModelRenderer(this);
		rMHorn2.setRotationPoint(0.0F, 1.0F, -2.9F);
		rMHorn1.addChild(rMHorn2);
		setRotationAngle(rMHorn2, -0.9561F, 0.0F, 0.0F);
		rMHorn2.setTextureOffset(40, 26).addBox(-0.5F, -2.0F, -4.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
		rMHorn2.setModelRendererName("rMHorn2");
		this.registerModelRenderer(rMHorn2);

		lMHorn1 = new AnimatedModelRenderer(this);
		lMHorn1.setRotationPoint(-1.5F, 0.1F, -4.0F);
		lowJaw.addChild(lMHorn1);
		setRotationAngle(lMHorn1, -0.3187F, 0.4554F, 0.0F);
		lMHorn1.setTextureOffset(32, 19).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		lMHorn1.setModelRendererName("lMHorn1");
		this.registerModelRenderer(lMHorn1);

		lMHorn2 = new AnimatedModelRenderer(this);
		lMHorn2.setRotationPoint(0.0F, 1.0F, -2.9F);
		lMHorn1.addChild(lMHorn2);
		setRotationAngle(lMHorn2, -0.9561F, 0.0F, 0.0F);
		lMHorn2.setTextureOffset(40, 26).addBox(-0.5F, -2.0F, -4.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
		lMHorn2.setModelRendererName("lMHorn2");
		this.registerModelRenderer(lMHorn2);

		lHorn1 = new AnimatedModelRenderer(this);
		lHorn1.setRotationPoint(-3.0F, -9.0F, -2.5F);
		head.addChild(lHorn1);
		setRotationAngle(lHorn1, 0.0F, 0.0F, -0.5463F);
		lHorn1.setTextureOffset(27, 142).addBox(-2.5F, -3.0F, -2.5F, 5.0F, 3.0F, 5.0F, 0.0F, false);
		lHorn1.setModelRendererName("lHorn1");
		this.registerModelRenderer(lHorn1);

		lHorn2 = new AnimatedModelRenderer(this);
		lHorn2.setRotationPoint(0.0F, -2.0F, 2.0F);
		lHorn1.addChild(lHorn2);
		setRotationAngle(lHorn2, 0.6829F, 0.0F, -0.4098F);
		lHorn2.setTextureOffset(0, 151).addBox(-2.0F, -5.0F, -4.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		lHorn2.setModelRendererName("lHorn2");
		this.registerModelRenderer(lHorn2);

		lHorn3 = new AnimatedModelRenderer(this);
		lHorn3.setRotationPoint(0.0F, -5.0F, 0.0F);
		lHorn2.addChild(lHorn3);
		setRotationAngle(lHorn3, 0.5009F, 0.0F, 0.0F);
		lHorn3.setTextureOffset(16, 152).addBox(-1.5F, -4.0F, -3.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		lHorn3.setModelRendererName("lHorn3");
		this.registerModelRenderer(lHorn3);

		lHorn4 = new AnimatedModelRenderer(this);
		lHorn4.setRotationPoint(0.0F, -4.0F, 0.0F);
		lHorn3.addChild(lHorn4);
		setRotationAngle(lHorn4, 0.6374F, 0.0F, 0.0F);
		lHorn4.setTextureOffset(28, 152).addBox(-1.0F, -6.0F, -2.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		lHorn4.setModelRendererName("lHorn4");
		this.registerModelRenderer(lHorn4);

		topJaw = new AnimatedModelRenderer(this);
		topJaw.setRotationPoint(0.0F, -4.0F, -6.8F);
		head.addChild(topJaw);
		topJaw.setTextureOffset(0, 135).addBox(-3.5F, -2.0F, -5.0F, 7.0F, 4.0F, 5.0F, 0.0F, false);
		topJaw.setModelRendererName("topJaw");
		this.registerModelRenderer(topJaw);

		snout = new AnimatedModelRenderer(this);
		snout.setRotationPoint(0.0F, -2.0F, -5.0F);
		topJaw.addChild(snout);
		setRotationAngle(snout, 0.2731F, 0.0F, 0.0F);
		snout.setTextureOffset(24, 135).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		snout.setModelRendererName("snout");
		this.registerModelRenderer(snout);

		rHorn1 = new AnimatedModelRenderer(this);
		rHorn1.setRotationPoint(3.0F, -9.0F, -2.5F);
		head.addChild(rHorn1);
		setRotationAngle(rHorn1, 0.0F, 0.0F, 0.5463F);
		rHorn1.setTextureOffset(27, 142).addBox(-2.5F, -3.0F, -2.5F, 5.0F, 3.0F, 5.0F, 0.0F, false);
		rHorn1.setModelRendererName("rHorn1");
		this.registerModelRenderer(rHorn1);

		rHorn2 = new AnimatedModelRenderer(this);
		rHorn2.setRotationPoint(0.0F, -2.0F, 2.0F);
		rHorn1.addChild(rHorn2);
		setRotationAngle(rHorn2, 0.6829F, 0.0F, 0.4098F);
		rHorn2.setTextureOffset(0, 151).addBox(-2.0F, -5.0F, -4.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
		rHorn2.setModelRendererName("rHorn2");
		this.registerModelRenderer(rHorn2);

		rHorn3 = new AnimatedModelRenderer(this);
		rHorn3.setRotationPoint(0.0F, -5.0F, 0.0F);
		rHorn2.addChild(rHorn3);
		setRotationAngle(rHorn3, 0.5009F, 0.0F, 0.0F);
		rHorn3.setTextureOffset(16, 152).addBox(-1.5F, -4.0F, -3.0F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		rHorn3.setModelRendererName("rHorn3");
		this.registerModelRenderer(rHorn3);

		rHorn4 = new AnimatedModelRenderer(this);
		rHorn4.setRotationPoint(0.0F, -4.0F, 0.0F);
		rHorn3.addChild(rHorn4);
		setRotationAngle(rHorn4, 0.6374F, 0.0F, 0.0F);
		rHorn4.setTextureOffset(28, 152).addBox(-1.0F, -6.0F, -2.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		rHorn4.setModelRendererName("rHorn4");
		this.registerModelRenderer(rHorn4);

		rightPec = new AnimatedModelRenderer(this);
		rightPec.setRotationPoint(4.4F, -4.9F, -6.5F);
		chest.addChild(rightPec);
		setRotationAngle(rightPec, 0.0F, 0.0F, 0.0873F);
		rightPec.setTextureOffset(18, 84).addBox(-4.0F, -4.0F, -3.0F, 8.0F, 8.0F, 3.0F, 0.0F, false);
		rightPec.setModelRendererName("rightPec");
		this.registerModelRenderer(rightPec);

		lShoulder = new AnimatedModelRenderer(this);
		lShoulder.setRotationPoint(-7.5F, -7.5F, -4.0F);
		chest.addChild(lShoulder);
		setRotationAngle(lShoulder, 0.0F, 0.0F, 0.0911F);
		lShoulder.setTextureOffset(0, 71).addBox(-5.0F, -2.0F, -3.5F, 6.0F, 6.0F, 7.0F, 0.0F, false);
		lShoulder.setModelRendererName("lShoulder");
		this.registerModelRenderer(lShoulder);

		lArm1 = new AnimatedModelRenderer(this);
		lArm1.setRotationPoint(-2.0F, 4.0F, 0.0F);
		lShoulder.addChild(lArm1);
		lArm1.setTextureOffset(19, 66).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, 0.0F, false);
		lArm1.setModelRendererName("lArm1");
		this.registerModelRenderer(lArm1);

		lArm2 = new AnimatedModelRenderer(this);
		lArm2.setRotationPoint(0.0F, 6.7F, 2.5F);
		lArm1.addChild(lArm2);
		setRotationAngle(lArm2, -0.2731F, 0.0F, -0.0911F);
		lArm2.setTextureOffset(0, 84).addBox(-2.5F, 0.0F, -4.0F, 5.0F, 11.0F, 4.0F, 0.0F, false);
		lArm2.setModelRendererName("lArm2");
		this.registerModelRenderer(lArm2);

		leftPec = new AnimatedModelRenderer(this);
		leftPec.setRotationPoint(-4.3F, -4.9F, -6.5F);
		chest.addChild(leftPec);
		setRotationAngle(leftPec, 0.0F, 0.0F, -0.0873F);
		leftPec.setTextureOffset(18, 84).addBox(-4.0F, -4.0F, -3.0F, 8.0F, 8.0F, 3.0F, 0.0F, false);
		leftPec.setModelRendererName("leftPec");
		this.registerModelRenderer(leftPec);

		lLeg1_flat = new AnimatedModelRenderer(this);
		lLeg1_flat.setRotationPoint(-3.5F, -2.3F, 3.0F);
		lLeg1_flat.setTextureOffset(0, 37).addBox(2.5F, 0.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lLeg1_flat.setModelRendererName("lLeg1_flat");
		this.registerModelRenderer(lLeg1_flat);

		lLeg1 = new AnimatedModelRenderer(this);
		lLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		lLeg1_flat.addChild(lLeg1);
		setRotationAngle(lLeg1, -0.4098F, 0.0F, 0.0456F);
		lLeg1.setTextureOffset(0, 37).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 13.0F, 7.0F, 0.0F, false);
		lLeg1.setModelRendererName("lLeg1");
		this.registerModelRenderer(lLeg1);

		lLeg2 = new AnimatedModelRenderer(this);
		lLeg2.setRotationPoint(0.0F, 12.5F, -3.0F);
		lLeg1.addChild(lLeg2);
		setRotationAngle(lLeg2, 1.0928F, 0.0F, -0.0456F);
		lLeg2.setTextureOffset(28, 37).addBox(-3.0F, 0.0F, -0.5F, 6.0F, 9.0F, 5.0F, 0.0F, false);
		lLeg2.setModelRendererName("lLeg2");
		this.registerModelRenderer(lLeg2);

		lLeg3 = new AnimatedModelRenderer(this);
		lLeg3.setRotationPoint(0.0F, 9.0F, 4.5F);
		lLeg2.addChild(lLeg3);
		setRotationAngle(lLeg3, -0.9105F, 0.0F, 0.0F);
		lLeg3.setTextureOffset(0, 57).addBox(-2.5F, 0.0F, -4.0F, 5.0F, 10.0F, 4.0F, 0.0F, false);
		lLeg3.setModelRendererName("lLeg3");
		this.registerModelRenderer(lLeg3);

		lFoot = new AnimatedModelRenderer(this);
		lFoot.setRotationPoint(0.0F, 9.0F, -2.0F);
		lLeg3.addChild(lFoot);
		setRotationAngle(lFoot, 0.2276F, 0.0F, 0.0F);
		lFoot.setTextureOffset(18, 57).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 5.0F, 0.0F, false);
		lFoot.setModelRendererName("lFoot");
		this.registerModelRenderer(lFoot);

		rLeg1_flat = new AnimatedModelRenderer(this);
		rLeg1_flat.setRotationPoint(3.5F, -2.3F, 3.0F);
		rLeg1_flat.setTextureOffset(0, 37).addBox(2.5F, 0.0F, -3.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);
		rLeg1_flat.setModelRendererName("rLeg1_flat");
		this.registerModelRenderer(rLeg1_flat);

		rLeg1 = new AnimatedModelRenderer(this);
		rLeg1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rLeg1_flat.addChild(rLeg1);
		setRotationAngle(rLeg1, -0.4098F, 0.0F, -0.0456F);
		rLeg1.setTextureOffset(0, 37).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 13.0F, 7.0F, 0.0F, false);
		rLeg1.setModelRendererName("rLeg1");
		this.registerModelRenderer(rLeg1);

		rLeg2 = new AnimatedModelRenderer(this);
		rLeg2.setRotationPoint(0.0F, 12.5F, -3.0F);
		rLeg1.addChild(rLeg2);
		setRotationAngle(rLeg2, 1.0928F, 0.0F, 0.0456F);
		rLeg2.setTextureOffset(28, 37).addBox(-3.0F, 0.0F, -0.5F, 6.0F, 9.0F, 5.0F, 0.0F, false);
		rLeg2.setModelRendererName("rLeg2");
		this.registerModelRenderer(rLeg2);

		rLeg3 = new AnimatedModelRenderer(this);
		rLeg3.setRotationPoint(0.0F, 9.0F, 4.5F);
		rLeg2.addChild(rLeg3);
		setRotationAngle(rLeg3, -0.9105F, 0.0F, 0.0F);
		rLeg3.setTextureOffset(0, 57).addBox(-2.5F, 0.0F, -4.0F, 5.0F, 10.0F, 4.0F, 0.0F, false);
		rLeg3.setModelRendererName("rLeg3");
		this.registerModelRenderer(rLeg3);

		rFoot = new AnimatedModelRenderer(this);
		rFoot.setRotationPoint(0.0F, 9.0F, -2.0F);
		rLeg3.addChild(rFoot);
		setRotationAngle(rFoot, 0.2276F, 0.0F, 0.0F);
		rFoot.setTextureOffset(18, 57).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 4.0F, 5.0F, 0.0F, false);
		rFoot.setModelRendererName("rFoot");
		this.registerModelRenderer(rFoot);

		this.rootBones.add(thighs);
		this.rootBones.add(lLeg1_flat);
		this.rootBones.add(rLeg1_flat);
	}

	@Override
	public ResourceLocation getAnimationFileLocation() {
		return new ResourceLocation(DoomMod.MODID, "animations/baron_hell_animation.json");
	}
}