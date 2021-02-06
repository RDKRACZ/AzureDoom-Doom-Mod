package mod.azure.doom.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import mod.azure.doom.entity.Cyberdemon2016Entity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class TestModel extends EntityModel<Cyberdemon2016Entity> {
	private final ModelRenderer main;
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer Head_r5;
	private final ModelRenderer Head_r6;
	private final ModelRenderer Head_r7;
	private final ModelRenderer Head_r8;
	private final ModelRenderer lower_jaw;
	private final ModelRenderer lower_jaw_r1;
	private final ModelRenderer Body;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer Body_r5;
	private final ModelRenderer Right_arm;
	private final ModelRenderer Right_arm_r1;
	private final ModelRenderer Right_arm_r2;
	private final ModelRenderer Right_forearm;
	private final ModelRenderer Right_forearm_r1;
	private final ModelRenderer Right_forearm_r2;
	private final ModelRenderer Right_Leg;
	private final ModelRenderer Right_Leg_r1;
	private final ModelRenderer Right_Leg_r2;
	private final ModelRenderer Right_tibia;
	private final ModelRenderer Right_tibia_r1;
	private final ModelRenderer Left_arm;
	private final ModelRenderer Left_arm_r1;
	private final ModelRenderer Left_arm_r2;
	private final ModelRenderer Left_forearm;
	private final ModelRenderer Left_forearm_r1;
	private final ModelRenderer Left_forearm_r2;
	private final ModelRenderer Left_leg;
	private final ModelRenderer Left_leg_r1;
	private final ModelRenderer Left_tibia;
	private final ModelRenderer Left_tibia_r1;
	private final ModelRenderer Left_tibia_r2;

	public TestModel() {
		textureWidth = 64;
		textureHeight = 64;

		main = new ModelRenderer(this);
		main.setRotationPoint(0.0F, 24.0F, 0.0F);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -26.0F, -1.0F);
		main.addChild(Head);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setRotationPoint(-1.1F, -26.2F, -2.6F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.0323F, -0.1569F, -0.0051F);
		Head_r1.setTextureOffset(0, 0).addBox(-2.7864F, 23.2824F, -0.1492F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setRotationPoint(-1.9F, -26.1F, -2.6F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.0323F, -0.1569F, -0.0051F);
		Head_r2.setTextureOffset(0, 2).addBox(3.7136F, 23.2824F, -0.4492F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setRotationPoint(-1.8F, -28.8F, -2.6F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 0.0323F, -0.1569F, -0.0051F);
		Head_r3.setTextureOffset(48, 17).addBox(-1.4114F, 27.6824F, -3.2492F, 1.0F, 2.0F, 5.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setRotationPoint(2.0F, -8.6F, -1.0F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, 0.0251F, -0.1738F, -0.0056F);
		Head_r4.setTextureOffset(41, 49).addBox(-0.9254F, 7.4475F, -3.5469F, 1.0F, 2.0F, 5.0F, 0.0F, false);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setRotationPoint(-1.9F, -12.8F, 5.6F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, 0.0323F, -0.1569F, -0.0051F);
		Head_r5.setTextureOffset(42, 34).addBox(-1.6888F, 11.5291F, -9.8535F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setRotationPoint(-0.1433F, -0.0619F, -2.3748F);
		Head.addChild(Head_r6);
		setRotationAngle(Head_r6, 0.0275F, -0.1565F, -0.0055F);
		Head_r6.setTextureOffset(19, 0).addBox(-2.2023F, -1.0076F, -3.1851F, 4.0F, 1.0F, 3.0F, 0.0F, false);

		Head_r7 = new ModelRenderer(this);
		Head_r7.setRotationPoint(-1.9F, -28.4F, -2.6F);
		Head.addChild(Head_r7);
		setRotationAngle(Head_r7, 0.0323F, -0.1569F, -0.0051F);
		Head_r7.setTextureOffset(0, 0).addBox(-1.4864F, 22.5074F, -4.2492F, 6.0F, 5.0F, 7.0F, 0.0F, false);

		Head_r8 = new ModelRenderer(this);
		Head_r8.setRotationPoint(-1.4857F, -27.5021F, -3.8864F);
		Head.addChild(Head_r8);
		setRotationAngle(Head_r8, 0.0323F, -0.1569F, -0.0051F);
		Head_r8.setTextureOffset(21, 6).addBox(-0.8864F, 22.4074F, -2.2492F, 4.0F, 4.0F, 6.0F, 0.0F, false);

		lower_jaw = new ModelRenderer(this);
		lower_jaw.setRotationPoint(0.1F, 1.5F, -4.8F);
		Head.addChild(lower_jaw);

		lower_jaw_r1 = new ModelRenderer(this);
		lower_jaw_r1.setRotationPoint(-2.0F, -24.0F, 2.0F);
		lower_jaw.addChild(lower_jaw_r1);
		setRotationAngle(lower_jaw_r1, 0.0423F, -0.1571F, 0.0003F);
		lower_jaw_r1.setTextureOffset(48, 49).addBox(-0.2936F, 23.4892F, -4.0491F, 4.0F, 1.0F, 3.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(-0.6F, -22.7F, -1.0F);
		main.addChild(Body);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setRotationPoint(-3.0912F, -3.2091F, -1.3141F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.5585F, -0.2618F, 0.0F);
		Body_r1.setTextureOffset(49, 11).addBox(0.3774F, 2.3865F, 2.6993F, 5.0F, 3.0F, 1.0F, 0.0F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setRotationPoint(0.0013F, -4.4534F, -3.4009F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.5585F, -0.2618F, 0.0F);
		Body_r2.setTextureOffset(0, 49).addBox(-2.6573F, 4.1974F, 3.9929F, 6.0F, 5.0F, 1.0F, 0.0F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setRotationPoint(1.787F, 10.4872F, 4.1619F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.0698F, -0.2443F, 0.0F);
		Body_r3.setTextureOffset(22, 22).addBox(-6.8502F, -8.2854F, -2.1025F, 7.0F, 6.0F, 4.0F, 0.0F, false);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setRotationPoint(-0.9915F, -9.8887F, -4.2929F);
		Body.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.5585F, -0.2618F, 0.0F);
		Body_r4.setTextureOffset(42, 42).addBox(-2.2664F, 8.3405F, -4.4032F, 7.0F, 5.0F, 1.0F, 0.0F, false);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setRotationPoint(-1.9F, -9.8F, -4.8F);
		Body.addChild(Body_r5);
		setRotationAngle(Body_r5, 0.5585F, -0.2618F, 0.0F);
		Body_r5.setTextureOffset(0, 12).addBox(-1.7746F, 8.3405F, -3.5679F, 8.0F, 7.0F, 5.0F, 0.0F, false);

		Right_arm = new ModelRenderer(this);
		Right_arm.setRotationPoint(4.3F, -25.4F, 0.2F);
		main.addChild(Right_arm);

		Right_arm_r1 = new ModelRenderer(this);
		Right_arm_r1.setRotationPoint(-0.8919F, -2.2465F, -1.539F);
		Right_arm.addChild(Right_arm_r1);
		setRotationAngle(Right_arm_r1, 0.4189F, -0.0524F, -0.2443F);
		Right_arm_r1.setTextureOffset(34, 45).addBox(0.2496F, 2.2647F, -2.0254F, 2.0F, 4.0F, 4.0F, 0.0F, false);

		Right_arm_r2 = new ModelRenderer(this);
		Right_arm_r2.setRotationPoint(-2.2F, -7.0F, -3.5F);
		Right_arm.addChild(Right_arm_r2);
		setRotationAngle(Right_arm_r2, 0.4189F, -0.0524F, -0.2443F);
		Right_arm_r2.setTextureOffset(51, 0).addBox(-1.1604F, 7.9261F, -1.7431F, 2.0F, 6.0F, 3.0F, 0.0F, false);

		Right_forearm = new ModelRenderer(this);
		Right_forearm.setRotationPoint(0.7851F, 5.4105F, 1.7244F);
		Right_arm.addChild(Right_forearm);

		Right_forearm_r1 = new ModelRenderer(this);
		Right_forearm_r1.setRotationPoint(-1.0F, -7.0F, 0.0F);
		Right_forearm.addChild(Right_forearm_r1);
		setRotationAngle(Right_forearm_r1, 0.0F, 0.0F, -0.1222F);
		Right_forearm_r1.setTextureOffset(14, 43).addBox(-1.1675F, 6.6777F, -1.3F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		Right_forearm_r2 = new ModelRenderer(this);
		Right_forearm_r2.setRotationPoint(-1.3073F, -4.3605F, -0.5875F);
		Right_forearm.addChild(Right_forearm_r2);
		setRotationAngle(Right_forearm_r2, 0.0F, 0.0F, -0.1222F);
		Right_forearm_r2.setTextureOffset(0, 39).addBox(-0.8978F, 3.942F, -1.2F, 3.0F, 5.0F, 4.0F, 0.0F, false);

		Right_Leg = new ModelRenderer(this);
		Right_Leg.setRotationPoint(0.5F, -13.5F, 2.6F);
		main.addChild(Right_Leg);

		Right_Leg_r1 = new ModelRenderer(this);
		Right_Leg_r1.setRotationPoint(0.887F, 3.9872F, -0.9381F);
		Right_Leg.addChild(Right_Leg_r1);
		setRotationAngle(Right_Leg_r1, -0.2153F, -0.2271F, -0.1592F);
		Right_Leg_r1.setTextureOffset(37, 12).addBox(-2.1469F, -2.3188F, -1.702F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		Right_Leg_r2 = new ModelRenderer(this);
		Right_Leg_r2.setRotationPoint(0.687F, 1.5872F, 0.7619F);
		Right_Leg.addChild(Right_Leg_r2);
		setRotationAngle(Right_Leg_r2, -0.2132F, -0.2344F, -0.1794F);
		Right_Leg_r2.setTextureOffset(28, 32).addBox(-2.3775F, -1.6963F, -2.8079F, 3.0F, 8.0F, 4.0F, 0.0F, false);

		Right_tibia = new ModelRenderer(this);
		Right_tibia.setRotationPoint(0.887F, 3.9872F, -0.9381F);
		Right_Leg.addChild(Right_tibia);

		Right_tibia_r1 = new ModelRenderer(this);
		Right_tibia_r1.setRotationPoint(1.1038F, 1.789F, -1.7088F);
		Right_tibia.addChild(Right_tibia_r1);
		setRotationAngle(Right_tibia_r1, -0.0436F, -0.2094F, -0.0175F);
		Right_tibia_r1.setTextureOffset(0, 24).addBox(-2.0375F, 1.174F, -0.7348F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		Left_arm = new ModelRenderer(this);
		Left_arm.setRotationPoint(-6.6F, -25.7F, -2.4F);
		main.addChild(Left_arm);

		Left_arm_r1 = new ModelRenderer(this);
		Left_arm_r1.setRotationPoint(1.4296F, -0.4127F, 0.7927F);
		Left_arm.addChild(Left_arm_r1);
		setRotationAngle(Left_arm_r1, 0.0F, -0.3142F, 0.2967F);
		Left_arm_r1.setTextureOffset(52, 25).addBox(-3.3F, 0.8F, -2.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		Left_arm_r2 = new ModelRenderer(this);
		Left_arm_r2.setRotationPoint(-2.0F, 0.7F, -0.8F);
		Left_arm.addChild(Left_arm_r2);
		setRotationAngle(Left_arm_r2, 0.0F, -0.3142F, 0.2967F);
		Left_arm_r2.setTextureOffset(53, 53).addBox(1.002F, -1.2668F, -1.3982F, 2.0F, 6.0F, 3.0F, 0.0F, false);

		Left_forearm = new ModelRenderer(this);
		Left_forearm.setRotationPoint(-1.0F, 6.1F, -0.4F);
		Left_arm.addChild(Left_forearm);

		Left_forearm_r1 = new ModelRenderer(this);
		Left_forearm_r1.setRotationPoint(-0.4665F, -6.3952F, 2.9886F);
		Left_forearm.addChild(Left_forearm_r1);
		setRotationAngle(Left_forearm_r1, -0.1222F, -0.3142F, 0.1047F);
		Left_forearm_r1.setTextureOffset(31, 54).addBox(-2.4178F, 6.3832F, -3.4942F, 1.0F, 6.0F, 3.0F, 0.0F, false);

		Left_forearm_r2 = new ModelRenderer(this);
		Left_forearm_r2.setRotationPoint(-0.698F, -7.6862F, 3.1825F);
		Left_forearm.addChild(Left_forearm_r2);
		setRotationAngle(Left_forearm_r2, -0.1222F, -0.3142F, 0.1047F);
		Left_forearm_r2.setTextureOffset(24, 45).addBox(-1.0303F, 7.1698F, -3.6357F, 2.0F, 8.0F, 3.0F, 0.0F, false);

		Left_leg = new ModelRenderer(this);
		Left_leg.setRotationPoint(-4.5F, -13.6F, 2.5F);
		main.addChild(Left_leg);

		Left_leg_r1 = new ModelRenderer(this);
		Left_leg_r1.setRotationPoint(-0.3F, -10.8F, 3.5F);
		Left_leg.addChild(Left_leg_r1);
		setRotationAngle(Left_leg_r1, -0.1745F, -0.2793F, 0.1222F);
		Left_leg_r1.setTextureOffset(35, 0).addBox(-1.1F, 11.1F, -4.2F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		Left_tibia = new ModelRenderer(this);
		Left_tibia.setRotationPoint(0.0F, 9.0F, 3.0F);
		Left_leg.addChild(Left_tibia);

		Left_tibia_r1 = new ModelRenderer(this);
		Left_tibia_r1.setRotationPoint(-0.4013F, -8.3681F, -4.3285F);
		Left_tibia.addChild(Left_tibia_r1);
		setRotationAngle(Left_tibia_r1, 0.192F, -0.2618F, 0.1222F);
		Left_tibia_r1.setTextureOffset(39, 27).addBox(-1.4F, 9.9F, -4.3F, 4.0F, 1.0F, 5.0F, 0.0F, false);

		Left_tibia_r2 = new ModelRenderer(this);
		Left_tibia_r2.setRotationPoint(0.2F, -5.9F, -9.2F);
		Left_tibia.addChild(Left_tibia_r2);
		setRotationAngle(Left_tibia_r2, 0.192F, -0.2618F, 0.1222F);
		Left_tibia_r2.setTextureOffset(12, 32).addBox(-0.5756F, 3.6865F, 1.7118F, 4.0F, 7.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Cyberdemon2016Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}