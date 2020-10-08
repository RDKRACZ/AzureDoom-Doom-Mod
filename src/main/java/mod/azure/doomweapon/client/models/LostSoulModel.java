package mod.azure.doomweapon.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doomweapon.DoomMod;
import mod.azure.doomweapon.entity.LostSoulEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class LostSoulModel extends AnimatedEntityModel<LostSoulEntity> {

	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer Jaw_flat;
	private final AnimatedModelRenderer Jaw;
	private final AnimatedModelRenderer lHorn1;
	private final AnimatedModelRenderer lHorn2;
	private final AnimatedModelRenderer lHorn3;
	private final AnimatedModelRenderer lHorn4;
	private final AnimatedModelRenderer rHorn1;
	private final AnimatedModelRenderer rHorn2;
	private final AnimatedModelRenderer rHorn3;
	private final AnimatedModelRenderer rHorn4;
	private final AnimatedModelRenderer flame01;
	private final AnimatedModelRenderer flame02;
	private final AnimatedModelRenderer flame03;
	private final AnimatedModelRenderer smallFlame01;
	private final AnimatedModelRenderer smallFlame02;
	private final AnimatedModelRenderer smallFlame03;
	private final AnimatedModelRenderer smallFlame04;
	private final AnimatedModelRenderer smallFlame05;

	public LostSoulModel() {
		textureWidth = 64;
		textureHeight = 64;
		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, 18.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -5.0F, -5.0F, 8.0F, 6.0F, 8.0F, 0.0F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		Jaw_flat = new AnimatedModelRenderer(this);
		Jaw_flat.setRotationPoint(0.0F, 0.0F, 4.0F);
		head.addChild(Jaw_flat);
		Jaw_flat.setTextureOffset(32, 0).addBox(3.5F, 0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, false);
		Jaw_flat.setModelRendererName("Jaw_flat");
		this.registerModelRenderer(Jaw_flat);

		Jaw = new AnimatedModelRenderer(this);
		Jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		Jaw_flat.addChild(Jaw);
		setRotationAngle(Jaw, 0.391F, 0.0F, 0.0F);
		Jaw.setTextureOffset(32, 0).addBox(-3.5F, 0.5435F, -9.3056F, 7.0F, 2.0F, 8.0F, 0.0F, false);
		Jaw.setModelRendererName("Jaw");
		this.registerModelRenderer(Jaw);

		lHorn1 = new AnimatedModelRenderer(this);
		lHorn1.setRotationPoint(-3.0F, -4.0F, 0.0F);
		head.addChild(lHorn1);
		setRotationAngle(lHorn1, 0.3128F, 0.0F, 1.8769F);
		lHorn1.setTextureOffset(0, 13).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, true);
		lHorn1.setModelRendererName("lHorn1");
		this.registerModelRenderer(lHorn1);

		lHorn2 = new AnimatedModelRenderer(this);
		lHorn2.setRotationPoint(0.0F, 4.0F, 1.5F);
		lHorn1.addChild(lHorn2);
		setRotationAngle(lHorn2, -0.7037F, 0.0F, 0.0F);
		lHorn2.setTextureOffset(12, 14).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		lHorn2.setModelRendererName("lHorn2");
		this.registerModelRenderer(lHorn2);

		lHorn3 = new AnimatedModelRenderer(this);
		lHorn3.setRotationPoint(0.0F, 4.0F, 0.0F);
		lHorn2.addChild(lHorn3);
		setRotationAngle(lHorn3, -0.7428F, 0.0F, 0.0F);
		lHorn3.setTextureOffset(20, 14).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		lHorn3.setModelRendererName("lHorn3");
		this.registerModelRenderer(lHorn3);

		lHorn4 = new AnimatedModelRenderer(this);
		lHorn4.setRotationPoint(0.1F, 4.0F, 0.0F);
		lHorn3.addChild(lHorn4);
		setRotationAngle(lHorn4, -0.7821F, 0.0F, 0.0F);
		lHorn4.setTextureOffset(26, 14).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		lHorn4.setModelRendererName("lHorn4");
		this.registerModelRenderer(lHorn4);

		rHorn1 = new AnimatedModelRenderer(this);
		rHorn1.setRotationPoint(2.0F, -4.0F, 0.0F);
		head.addChild(rHorn1);
		setRotationAngle(rHorn1, 0.3128F, 0.0F, -1.8768F);
		rHorn1.setTextureOffset(0, 13).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		rHorn1.setModelRendererName("rHorn1");
		this.registerModelRenderer(rHorn1);

		rHorn2 = new AnimatedModelRenderer(this);
		rHorn2.setRotationPoint(0.0F, 4.0F, 1.5F);
		rHorn1.addChild(rHorn2);
		setRotationAngle(rHorn2, -0.7037F, 0.0F, 0.0F);
		rHorn2.setTextureOffset(12, 14).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		rHorn2.setModelRendererName("rHorn2");
		this.registerModelRenderer(rHorn2);

		rHorn3 = new AnimatedModelRenderer(this);
		rHorn3.setRotationPoint(0.0F, 4.0F, 0.0F);
		rHorn2.addChild(rHorn3);
		setRotationAngle(rHorn3, -0.7428F, 0.0F, 0.0F);
		rHorn3.setTextureOffset(20, 14).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		rHorn3.setModelRendererName("rHorn3");
		this.registerModelRenderer(rHorn3);

		rHorn4 = new AnimatedModelRenderer(this);
		rHorn4.setRotationPoint(-0.1F, 4.0F, 0.0F);
		rHorn3.addChild(rHorn4);
		setRotationAngle(rHorn4, -0.7819F, 0.0F, 0.0F);
		rHorn4.setTextureOffset(26, 14).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		rHorn4.setModelRendererName("rHorn4");
		this.registerModelRenderer(rHorn4);

		flame01 = new AnimatedModelRenderer(this);
		flame01.setRotationPoint(0.0F, -3.6F, 0.9F);
		head.addChild(flame01);
		setRotationAngle(flame01, 1.3963F, 0.2618F, -0.1571F);
		flame01.setTextureOffset(-16, 22).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 0.0F, 16.0F, 0.0F, false);
		flame01.setModelRendererName("flame01");
		this.registerModelRenderer(flame01);

		flame02 = new AnimatedModelRenderer(this);
		flame02.setRotationPoint(0.0F, 1.4F, 0.9F);
		head.addChild(flame02);
		setRotationAngle(flame02, 1.3963F, -0.2618F, 0.1571F);
		flame02.setTextureOffset(6, 22).addBox(-5.7555F, -0.6582F, 4.8986F, 10.0F, 0.0F, 16.0F, 0.0F, false);
		flame02.setModelRendererName("flame02");
		this.registerModelRenderer(flame02);

		flame03 = new AnimatedModelRenderer(this);
		flame03.setRotationPoint(0.0F, -3.4F, 2.1F);
		head.addChild(flame03);
		setRotationAngle(flame03, 1.1519F, 0.0F, 0.0F);
		flame03.setTextureOffset(27, 22).addBox(-5.0F, 0.5068F, 1.3203F, 10.0F, 0.0F, 16.0F, 0.0F, false);
		flame03.setModelRendererName("flame03");
		this.registerModelRenderer(flame03);

		smallFlame01 = new AnimatedModelRenderer(this);
		smallFlame01.setRotationPoint(0.7F, -0.6F, -1.6F);
		head.addChild(smallFlame01);
		setRotationAngle(smallFlame01, 1.3963F, 0.192F, 0.1571F);
		smallFlame01.setTextureOffset(-13, 40).addBox(-4.4607F, -0.6027F, 2.9025F, 8.0F, 0.0F, 13.0F, 0.0F, false);
		smallFlame01.setModelRendererName("smallFlame01");
		this.registerModelRenderer(smallFlame01);

		smallFlame02 = new AnimatedModelRenderer(this);
		smallFlame02.setRotationPoint(0.7F, -0.6F, -1.6F);
		head.addChild(smallFlame02);
		setRotationAngle(smallFlame02, 1.3963F, -0.192F, -0.1571F);
		smallFlame02.setTextureOffset(4, 40).addBox(-4.5089F, -0.4443F, 3.0893F, 8.0F, 0.0F, 13.0F, 0.0F, false);
		smallFlame02.setModelRendererName("smallFlame02");
		this.registerModelRenderer(smallFlame02);

		smallFlame03 = new AnimatedModelRenderer(this);
		smallFlame03.setRotationPoint(0.7F, 1.5F, 3.1F);
		head.addChild(smallFlame03);
		setRotationAngle(smallFlame03, 1.1617F, 0.0F, 0.0F);
		smallFlame03.setTextureOffset(21, 40).addBox(-4.6F, -0.3F, 0.4F, 8.0F, 0.0F, 13.0F, 0.0F, false);
		smallFlame03.setModelRendererName("smallFlame03");
		this.registerModelRenderer(smallFlame03);

		smallFlame04 = new AnimatedModelRenderer(this);
		smallFlame04.setRotationPoint(-1.8F, -1.4F, 0.3F);
		head.addChild(smallFlame04);
		setRotationAngle(smallFlame04, 1.0472F, 0.0F, -0.6283F);
		smallFlame04.setTextureOffset(21, 40).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 13.0F, 0.0F, false);
		smallFlame04.setModelRendererName("smallFlame04");
		this.registerModelRenderer(smallFlame04);

		smallFlame05 = new AnimatedModelRenderer(this);
		smallFlame05.setRotationPoint(1.8F, -1.4F, 0.3F);
		head.addChild(smallFlame05);
		setRotationAngle(smallFlame05, 1.0472F, 0.0F, 0.6283F);
		smallFlame05.setTextureOffset(-13, 40).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 13.0F, 0.0F, false);
		smallFlame05.setModelRendererName("smallFlame05");
		this.registerModelRenderer(smallFlame05);

		this.rootBones.add(head);
	}

	public void renderFlame(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn,
			int packedOverlayIn) {
		this.smallFlame01.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		this.smallFlame02.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		this.smallFlame03.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		this.smallFlame04.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
		this.smallFlame05.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
	}

	@Override
	public ResourceLocation getAnimationFileLocation() {
		return new ResourceLocation(DoomMod.MODID, "animations/lostsoul_animation.json");
	}
}