package mod.azure.doom.client.models;

import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.GoreNestEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class GoreNestModel extends AnimatedEntityModel<GoreNestEntity> {

	private final AnimatedModelRenderer top;
	private final AnimatedModelRenderer bone10;
	private final AnimatedModelRenderer bone7;
	private final AnimatedModelRenderer bone9;
	private final AnimatedModelRenderer bone8;
	private final AnimatedModelRenderer bottom;
	private final AnimatedModelRenderer bone6;
	private final AnimatedModelRenderer bone3;
	private final AnimatedModelRenderer bone2;
	private final AnimatedModelRenderer bone;
	private final AnimatedModelRenderer bone4;
	private final AnimatedModelRenderer bone5;
	private final AnimatedModelRenderer bone11;

	public GoreNestModel() {
		textureWidth = 128;
		textureHeight = 128;
		top = new AnimatedModelRenderer(this);
		top.setRotationPoint(-1.5F, 21.2F, 0.9F);
		top.setTextureOffset(92, 108).addBox(3.9F, -20.2F, 3.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		top.setTextureOffset(124, 124).addBox(2.4F, -19.0F, -1.3F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		top.setTextureOffset(16, 29).addBox(0.373F, -23.8058F, -13.4603F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		top.setTextureOffset(27, 25).addBox(-1.8F, -21.5F, -11.4F, 2.0F, 5.0F, 2.0F, 0.0F, false);
		top.setTextureOffset(107, 110).addBox(-1.3F, -20.9F, 1.8F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		top.setTextureOffset(99, 107).addBox(0.6F, -20.2F, 3.3F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		top.setTextureOffset(124, 125).addBox(-1.5F, -25.2F, 6.8F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		top.setTextureOffset(81, 103).addBox(-1.5F, 1.8F, -0.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		top.setTextureOffset(106, 16).addBox(-3.2F, -17.8F, 5.7F, 1.0F, 5.0F, 4.0F, 0.0F, false);
		top.setTextureOffset(39, 4).addBox(-2.0F, -10.3F, 5.7F, 6.0F, 4.0F, 4.0F, 0.0F, false);
		top.setTextureOffset(0, 22).addBox(-2.6F, -10.3F, -5.3F, 7.0F, 2.0F, 11.0F, 0.0F, false);
		top.setTextureOffset(10, 26).addBox(-1.8F, -10.4F, -12.4F, 5.0F, 4.0F, 5.0F, 0.0F, false);
		top.setTextureOffset(0, 22).addBox(-2.0F, -16.9F, -10.1F, 6.0F, 5.0F, 1.0F, 0.0F, false);
		top.setTextureOffset(0, 0).addBox(-1.8F, -13.8F, -12.4F, 5.0F, 2.0F, 6.0F, 0.0F, false);
		top.setTextureOffset(0, 0).addBox(-1.8F, -11.9F, -10.3F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		top.setTextureOffset(4, 24).addBox(-3.8F, -16.9F, -8.3F, 10.0F, 6.0F, 7.0F, 0.0F, false);
		top.setTextureOffset(0, 23).addBox(-2.0F, -17.9F, 1.7F, 8.0F, 7.0F, 11.0F, 0.0F, false);
		top.setTextureOffset(5, 16).addBox(-2.5F, -15.9F, -1.3F, 6.0F, 5.0F, 3.0F, 0.0F, false);
		top.setTextureOffset(47, 3).addBox(-1.4F, -9.2367F, 10.1816F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		top.setTextureOffset(0, 0).addBox(-1.9F, -11.2724F, 10.2862F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		top.setTextureOffset(0, 0).addBox(-1.7F, -17.3F, 9.3F, 5.0F, 7.0F, 5.0F, 0.0F, false);
		top.setTextureOffset(16, 26).addBox(-1.6F, -15.2465F, 14.4421F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		top.setTextureOffset(12, 35).addBox(-1.7F, -21.5F, 14.7F, 5.0F, 5.0F, 4.0F, 0.0F, false);
		top.setTextureOffset(0, 19).addBox(-2.0F, -19.9F, 4.9F, 7.0F, 2.0F, 10.0F, 0.0F, false);
		top.setTextureOffset(0, 32).addBox(-1.7F, -21.9658F, 11.3625F, 5.0F, 5.0F, 4.0F, 0.0F, false);
		top.setTextureOffset(17, 27).addBox(-4.2F, -21.6F, 9.3F, 3.0F, 2.0F, 5.0F, 0.0F, false);
		top.setTextureOffset(0, 44).addBox(-2.0F, -22.8F, 6.5F, 7.0F, 2.0F, 9.0F, 0.0F, false);
		top.setTextureOffset(0, 33).addBox(-2.0F, -26.7F, 8.4F, 6.0F, 3.0F, 8.0F, 0.0F, false);
		top.setTextureOffset(1, 19).addBox(-4.2F, -28.7F, 9.3F, 3.0F, 6.0F, 5.0F, 0.0F, false);
		top.setTextureOffset(4, 44).addBox(-2.0F, -28.9F, 7.4F, 6.0F, 2.0F, 7.0F, 0.0F, false);
		top.setTextureOffset(4, 31).addBox(-2.0F, -30.3F, 6.9F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		top.setTextureOffset(4, 25).addBox(-2.0F, -31.7F, 6.0F, 6.0F, 1.0F, 5.0F, 0.0F, false);
		top.setTextureOffset(0, 18).addBox(2.5F, -17.5942F, -13.4491F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		top.setTextureOffset(0, 27).addBox(-2.5F, -17.9F, -8.3F, 7.0F, 1.0F, 5.0F, 0.0F, false);
		top.setTextureOffset(0, 0).addBox(2.7F, -11.8F, -10.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		top.setModelRendererName("top");
		this.registerModelRenderer(top);

		bone10 = new AnimatedModelRenderer(this);
		bone10.setRotationPoint(-0.6F, -17.0F, -2.5F);
		top.addChild(bone10);
		bone10.setTextureOffset(102, 117).addBox(-0.7F, -3.0F, -0.1F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone10.setModelRendererName("bone10");
		this.registerModelRenderer(bone10);

		bone7 = new AnimatedModelRenderer(this);
		bone7.setRotationPoint(-2.8F, -16.9F, -3.6F);
		top.addChild(bone7);
		bone7.setTextureOffset(99, 111).addBox(-1.0F, -3.0F, -0.4F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone7.setModelRendererName("bone7");
		this.registerModelRenderer(bone7);

		bone9 = new AnimatedModelRenderer(this);
		bone9.setRotationPoint(4.3F, -18.0F, -6.9F);
		top.addChild(bone9);
		bone9.setTextureOffset(94, 109).addBox(-1.0F, -3.1F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone9.setModelRendererName("bone9");
		this.registerModelRenderer(bone9);

		bone8 = new AnimatedModelRenderer(this);
		bone8.setRotationPoint(-1.0F, -18.0F, -6.9F);
		top.addChild(bone8);
		bone8.setTextureOffset(87, 116).addBox(-1.0F, -3.1F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		bone8.setModelRendererName("bone8");
		this.registerModelRenderer(bone8);

		bottom = new AnimatedModelRenderer(this);
		bottom.setRotationPoint(-1.5F, 21.2F, 0.9F);
		bottom.setTextureOffset(12, 0).addBox(-5.2F, -1.7F, -8.3F, 12.0F, 4.0F, 14.0F, 0.0F, false);
		bottom.setTextureOffset(88, 108).addBox(-5.4F, -4.5F, 2.7F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottom.setTextureOffset(124, 125).addBox(2.5F, -4.3F, 6.9F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bottom.setModelRendererName("bottom");
		this.registerModelRenderer(bottom);

		bone6 = new AnimatedModelRenderer(this);
		bone6.setRotationPoint(0.0F, 0.7F, -10.9F);
		bottom.addChild(bone6);
		bone6.setTextureOffset(0, 0).addBox(-5.1F, 0.1F, -17.4F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		bone6.setTextureOffset(0, 0).addBox(-6.0F, -0.3F, -14.1F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		bone6.setTextureOffset(0, 0).addBox(-7.0F, -0.3F, -11.1F, 3.0F, 2.0F, 4.0F, 0.0F, false);
		bone6.setTextureOffset(0, 0).addBox(-4.1F, -0.9F, -9.7F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		bone6.setTextureOffset(0, 0).addBox(-0.6F, -1.7F, -7.6F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		bone6.setTextureOffset(0, 0).addBox(-2.0F, -2.4F, -2.7F, 5.0F, 4.0F, 5.0F, 0.0F, false);
		bone6.setModelRendererName("bone6");
		this.registerModelRenderer(bone6);

		bone3 = new AnimatedModelRenderer(this);
		bone3.setRotationPoint(2.2F, 1.7F, 6.3F);
		bottom.addChild(bone3);
		bone3.setTextureOffset(0, 0).addBox(12.0F, -0.6F, 14.9F, 3.0F, 1.0F, 4.0F, 0.0F, false);
		bone3.setTextureOffset(0, 1).addBox(9.7F, -0.8F, 9.2F, 4.0F, 2.0F, 5.0F, 0.0F, false);
		bone3.setTextureOffset(0, 0).addBox(5.7F, -1.5F, 6.3F, 4.0F, 2.0F, 6.0F, 0.0F, false);
		bone3.setTextureOffset(0, 0).addBox(0.7F, -2.1F, 3.2F, 5.0F, 3.0F, 6.0F, 0.0F, false);
		bone3.setTextureOffset(0, 0).addBox(-2.3F, -3.2F, -3.5F, 5.0F, 4.0F, 6.0F, 0.0F, false);
		bone3.setModelRendererName("bone3");
		this.registerModelRenderer(bone3);

		bone2 = new AnimatedModelRenderer(this);
		bone2.setRotationPoint(-2.8F, 1.7F, 6.7F);
		bottom.addChild(bone2);
		bone2.setTextureOffset(0, 10).addBox(-12.4F, -0.2F, 7.1F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		bone2.setTextureOffset(0, 0).addBox(-8.2F, -0.5F, 5.2F, 5.0F, 1.0F, 3.0F, 0.0F, false);
		bone2.setTextureOffset(0, 0).addBox(-5.0F, -0.8F, 1.8F, 5.0F, 2.0F, 4.0F, 0.0F, false);
		bone2.setTextureOffset(0, 0).addBox(-2.3F, -1.9F, -2.8F, 5.0F, 3.0F, 4.0F, 0.0F, false);
		bone2.setModelRendererName("bone2");
		this.registerModelRenderer(bone2);

		bone = new AnimatedModelRenderer(this);
		bone.setRotationPoint(-5.3F, 1.7F, -3.5F);
		bottom.addChild(bone);
		bone.setTextureOffset(0, 0).addBox(-5.3F, -2.9F, -3.5F, 5.0F, 4.0F, 7.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-10.5F, -2.2F, -4.0F, 5.0F, 3.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-15.2F, -1.6F, -5.2F, 4.0F, 2.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-19.1F, -1.0F, -3.9F, 3.0F, 2.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-19.9F, -1.0F, -6.8F, 2.0F, 2.0F, 3.0F, 0.0F, false);
		bone.setModelRendererName("bone");
		this.registerModelRenderer(bone);

		bone4 = new AnimatedModelRenderer(this);
		bone4.setRotationPoint(7.2F, 1.7F, 5.8F);
		bottom.addChild(bone4);
		bone4.setTextureOffset(0, 1).addBox(13.8F, -1.3F, 4.4F, 6.0F, 2.0F, 3.0F, 0.0F, false);
		bone4.setTextureOffset(0, 0).addBox(10.9F, -1.8F, -0.4F, 5.0F, 3.0F, 5.0F, 0.0F, false);
		bone4.setTextureOffset(0, 0).addBox(4.4F, -2.2F, -2.7F, 6.0F, 3.0F, 6.0F, 0.0F, false);
		bone4.setTextureOffset(0, 0).addBox(-0.2F, -2.8F, -3.2F, 6.0F, 4.0F, 5.0F, 0.0F, false);
		bone4.setModelRendererName("bone4");
		this.registerModelRenderer(bone4);

		bone5 = new AnimatedModelRenderer(this);
		bone5.setRotationPoint(7.4F, 1.8F, -4.8F);
		bottom.addChild(bone5);
		bone5.setTextureOffset(0, 0).addBox(8.6F, -1.1F, -17.5F, 3.0F, 2.0F, 4.0F, 0.0F, false);
		bone5.setTextureOffset(0, 0).addBox(5.4F, -2.7F, -6.2F, 7.0F, 3.0F, 5.0F, 0.0F, false);
		bone5.setTextureOffset(0, 0).addBox(-0.2F, -3.1F, -2.6F, 9.0F, 4.0F, 5.0F, 0.0F, false);
		bone5.setTextureOffset(0, 0).addBox(8.9F, -2.3F, -13.3F, 5.0F, 3.0F, 7.0F, 0.0F, false);
		bone5.setModelRendererName("bone5");
		this.registerModelRenderer(bone5);

		bone11 = new AnimatedModelRenderer(this);
		bone11.setRotationPoint(0.9F, -1.4F, -2.3F);
		bottom.addChild(bone11);
		bone11.setTextureOffset(8, 22).addBox(-2.9F, -6.6F, -2.7F, 6.0F, 8.0F, 9.0F, 0.0F, false);
		bone11.setTextureOffset(0, 0).addBox(-2.9F, -2.3F, -7.8F, 6.0F, 2.0F, 5.0F, 0.0F, false);
		bone11.setTextureOffset(31, 16).addBox(-4.1F, -4.3F, -3.6F, 1.0F, 5.0F, 8.0F, 0.0F, false);
		bone11.setModelRendererName("bone11");
		this.registerModelRenderer(bone11);

		this.rootBones.add(top);
		this.rootBones.add(bottom);
	}

	@Override
	public ResourceLocation getAnimationFileLocation() {
		return new ResourceLocation(DoomMod.MODID, "animations/gorenest_animation.json");
	}
}