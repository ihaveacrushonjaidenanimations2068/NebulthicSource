// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelFactorion extends EntityModel<Entity> {
	private final ModelRenderer RightLegBase;
	private final ModelRenderer tankTread;
	private final ModelRenderer bone5;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer tankTread3;
	private final ModelRenderer bone10;
	private final ModelRenderer bone24;
	private final ModelRenderer bone25;
	private final ModelRenderer bone26;
	private final ModelRenderer bone27;
	private final ModelRenderer bone28;
	private final ModelRenderer bone29;
	private final ModelRenderer bone30;
	private final ModelRenderer bone19;
	private final ModelRenderer bone22;
	private final ModelRenderer RightLegBase2;
	private final ModelRenderer tankTread2;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;
	private final ModelRenderer bone14;
	private final ModelRenderer bone15;
	private final ModelRenderer bone16;
	private final ModelRenderer bone17;
	private final ModelRenderer bone18;
	private final ModelRenderer tankTread4;
	private final ModelRenderer bone31;
	private final ModelRenderer bone32;
	private final ModelRenderer bone33;
	private final ModelRenderer bone34;
	private final ModelRenderer bone35;
	private final ModelRenderer bone36;
	private final ModelRenderer bone37;
	private final ModelRenderer bone38;
	private final ModelRenderer bone20;
	private final ModelRenderer bone21;
	private final ModelRenderer bone23;
	private final ModelRenderer bone;
	private final ModelRenderer leftArm;
	private final ModelRenderer bone41;
	private final ModelRenderer bone48;
	private final ModelRenderer rightArm;
	private final ModelRenderer bone42;
	private final ModelRenderer bone49;
	private final ModelRenderer head;
	private final ModelRenderer bone44;
	private final ModelRenderer bone45;
	private final ModelRenderer bone46;
	private final ModelRenderer bone47;
	private final ModelRenderer bone39;

	public ModelFactorion() {
		textureWidth = 512;
		textureHeight = 512;

		RightLegBase = new ModelRenderer(this);
		RightLegBase.setRotationPoint(13.0F, -82.0F, -2.0F);
		RightLegBase.setTextureOffset(210, 384).addBox(-2.0F, -9.0F, -7.0F, 19.0F, 109.0F, 18.0F, 0.0F, false);

		tankTread = new ModelRenderer(this);
		tankTread.setRotationPoint(-13.0F, 106.0F, 4.0F);
		RightLegBase.addChild(tankTread);
		tankTread.setTextureOffset(331, 295).addBox(30.0F, -57.0F, -8.0F, 7.0F, 30.0F, 2.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
		tankTread.addChild(bone5);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -4.0F, 7.0F);
		tankTread.addChild(bone2);
		setRotationAngle(bone2, 0.4363F, 0.0F, 0.0F);
		bone2.setTextureOffset(266, 188).addBox(30.0F, -27.278F, -4.297F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
		tankTread.addChild(bone3);
		bone3.setTextureOffset(200, 245).addBox(30.0F, -22.0F, -5.0F, 7.0F, 2.0F, 10.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, -4.0F, -6.0F);
		tankTread.addChild(bone4);
		setRotationAngle(bone4, -0.3491F, 0.0F, 0.0F);
		bone4.setTextureOffset(266, 179).addBox(30.0F, -25.8576F, 3.2063F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
		tankTread.addChild(bone6);
		bone6.setTextureOffset(322, 89).addBox(30.0F, -56.5778F, 5.3941F, 7.0F, 30.0F, 2.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 0.0F, -1.0F);
		tankTread.addChild(bone7);
		setRotationAngle(bone7, 0.2618F, 0.0F, 0.0F);
		bone7.setTextureOffset(262, 47).addBox(30.0F, -58.5456F, 20.2339F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 0.0F, -1.0F);
		tankTread.addChild(bone8);
		bone8.setTextureOffset(86, 245).addBox(30.0F, -62.8217F, -5.3494F, 7.0F, 2.0F, 10.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, -8.0F, -36.0F);
		tankTread.addChild(bone9);
		setRotationAngle(bone9, -0.1745F, 0.0F, 0.0F);
		bone9.setTextureOffset(254, 37).addBox(30.0F, -59.1481F, 19.4132F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		tankTread3 = new ModelRenderer(this);
		tankTread3.setRotationPoint(-13.0F, 62.0F, 3.0F);
		RightLegBase.addChild(tankTread3);
		tankTread3.setTextureOffset(304, 0).addBox(30.0F, -57.0F, -8.0F, 7.0F, 30.0F, 2.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
		tankTread3.addChild(bone10);

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(0.0F, -4.0F, 7.0F);
		tankTread3.addChild(bone24);
		setRotationAngle(bone24, 0.4363F, 0.0F, 0.0F);
		bone24.setTextureOffset(0, 242).addBox(30.0F, -27.278F, -4.297F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		bone25 = new ModelRenderer(this);
		bone25.setRotationPoint(0.0F, 0.0F, 0.0F);
		tankTread3.addChild(bone25);
		bone25.setTextureOffset(86, 233).addBox(30.0F, -22.0F, -5.0F, 7.0F, 2.0F, 10.0F, 0.0F, false);

		bone26 = new ModelRenderer(this);
		bone26.setRotationPoint(0.0F, -4.0F, -6.0F);
		tankTread3.addChild(bone26);
		setRotationAngle(bone26, -0.3491F, 0.0F, 0.0F);
		bone26.setTextureOffset(110, 233).addBox(30.0F, -25.8576F, 3.2063F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		bone27 = new ModelRenderer(this);
		bone27.setRotationPoint(0.0F, 0.0F, 0.0F);
		tankTread3.addChild(bone27);
		bone27.setTextureOffset(246, 295).addBox(30.0F, -56.5778F, 5.3941F, 7.0F, 30.0F, 2.0F, 0.0F, false);

		bone28 = new ModelRenderer(this);
		bone28.setRotationPoint(0.0F, 0.0F, -1.0F);
		tankTread3.addChild(bone28);
		setRotationAngle(bone28, 0.2618F, 0.0F, 0.0F);
		bone28.setTextureOffset(0, 233).addBox(30.0F, -58.5456F, 20.2339F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		bone29 = new ModelRenderer(this);
		bone29.setRotationPoint(0.0F, 0.0F, -1.0F);
		tankTread3.addChild(bone29);
		bone29.setTextureOffset(230, 37).addBox(30.0F, -62.8217F, -5.3494F, 7.0F, 2.0F, 10.0F, 0.0F, false);

		bone30 = new ModelRenderer(this);
		bone30.setRotationPoint(0.0F, -8.0F, -36.0F);
		tankTread3.addChild(bone30);
		setRotationAngle(bone30, -0.1745F, 0.0F, 0.0F);
		bone30.setTextureOffset(220, 145).addBox(30.0F, -59.1481F, 19.4132F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(-13.0F, 106.0F, 2.0F);
		RightLegBase.addChild(bone19);
		bone19.setTextureOffset(266, 201).addBox(11.0F, -6.0F, -9.0F, 19.0F, 4.0F, 18.0F, 0.0F, false);

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(27.0F, 99.0F, -2.0F);
		RightLegBase.addChild(bone22);
		setRotationAngle(bone22, 0.8727F, 0.0F, 0.0F);
		bone22.setTextureOffset(0, 19).addBox(-29.0F, -3.3698F, -10.2265F, 19.0F, 2.0F, 6.0F, 0.0F, false);

		RightLegBase2 = new ModelRenderer(this);
		RightLegBase2.setRotationPoint(-10.0F, -81.0F, -4.0F);
		RightLegBase2.setTextureOffset(382, 179).addBox(-19.0F, -10.0F, -5.0F, 19.0F, 110.0F, 18.0F, 0.0F, false);

		tankTread2 = new ModelRenderer(this);
		tankTread2.setRotationPoint(-31.0F, 105.0F, 6.0F);
		RightLegBase2.addChild(tankTread2);
		tankTread2.setTextureOffset(313, 295).addBox(5.0F, -56.0F, -8.0F, 7.0F, 30.0F, 2.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
		tankTread2.addChild(bone11);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, -4.0F, 7.0F);
		tankTread2.addChild(bone12);
		setRotationAngle(bone12, 0.4363F, 0.0F, 0.0F);
		bone12.setTextureOffset(120, 251).addBox(5.0F, -26.278F, -4.297F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 0.0F, 0.0F);
		tankTread2.addChild(bone13);
		bone13.setTextureOffset(224, 235).addBox(5.0F, -21.0F, -5.0F, 7.0F, 2.0F, 10.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, -4.0F, -6.0F);
		tankTread2.addChild(bone14);
		setRotationAngle(bone14, -0.3491F, 0.0F, 0.0F);
		bone14.setTextureOffset(0, 251).addBox(5.0F, -24.8576F, 3.2063F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, 0.0F, 0.0F);
		tankTread2.addChild(bone15);
		bone15.setTextureOffset(304, 89).addBox(5.0F, -55.5778F, 5.3941F, 7.0F, 30.0F, 2.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(0.0F, 0.0F, -1.0F);
		tankTread2.addChild(bone16);
		setRotationAngle(bone16, 0.2618F, 0.0F, 0.0F);
		bone16.setTextureOffset(234, 247).addBox(5.0F, -58.5115F, 20.4927F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(0.0F, 0.0F, -1.0F);
		tankTread2.addChild(bone17);
		bone17.setTextureOffset(200, 233).addBox(5.0F, -61.8217F, -5.3494F, 7.0F, 2.0F, 10.0F, 0.0F, false);

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(0.0F, -8.0F, -36.0F);
		tankTread2.addChild(bone18);
		setRotationAngle(bone18, -0.1745F, 0.0F, 0.0F);
		bone18.setTextureOffset(120, 242).addBox(5.0F, -58.1481F, 19.4132F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		tankTread4 = new ModelRenderer(this);
		tankTread4.setRotationPoint(-31.0F, 56.0F, 5.0F);
		RightLegBase2.addChild(tankTread4);
		tankTread4.setTextureOffset(228, 295).addBox(5.0F, -56.0F, -8.0F, 7.0F, 30.0F, 2.0F, 0.0F, false);

		bone31 = new ModelRenderer(this);
		bone31.setRotationPoint(0.0F, 0.0F, 0.0F);
		tankTread4.addChild(bone31);

		bone32 = new ModelRenderer(this);
		bone32.setRotationPoint(0.0F, -4.0F, 7.0F);
		tankTread4.addChild(bone32);
		setRotationAngle(bone32, 0.4363F, 0.0F, 0.0F);
		bone32.setTextureOffset(220, 136).addBox(5.0F, -26.278F, -4.297F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		bone33 = new ModelRenderer(this);
		bone33.setRotationPoint(0.0F, 0.0F, 0.0F);
		tankTread4.addChild(bone33);
		bone33.setTextureOffset(0, 169).addBox(5.0F, -21.0F, -5.0F, 7.0F, 2.0F, 10.0F, 0.0F, false);

		bone34 = new ModelRenderer(this);
		bone34.setRotationPoint(0.0F, -4.0F, -6.0F);
		tankTread4.addChild(bone34);
		setRotationAngle(bone34, -0.3491F, 0.0F, 0.0F);
		bone34.setTextureOffset(24, 169).addBox(5.0F, -24.8576F, 3.2063F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		bone35 = new ModelRenderer(this);
		bone35.setRotationPoint(0.0F, 0.0F, 0.0F);
		tankTread4.addChild(bone35);
		bone35.setTextureOffset(286, 89).addBox(5.0F, -55.5778F, 5.3941F, 7.0F, 30.0F, 2.0F, 0.0F, false);

		bone36 = new ModelRenderer(this);
		bone36.setRotationPoint(0.0F, 0.0F, -1.0F);
		tankTread4.addChild(bone36);
		setRotationAngle(bone36, 0.2618F, 0.0F, 0.0F);
		bone36.setTextureOffset(11, 136).addBox(5.0F, -57.5456F, 20.2339F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		bone37 = new ModelRenderer(this);
		bone37.setRotationPoint(0.0F, 0.0F, -1.0F);
		tankTread4.addChild(bone37);
		bone37.setTextureOffset(22, 44).addBox(5.0F, -61.8217F, -5.3494F, 7.0F, 2.0F, 10.0F, 0.0F, false);

		bone38 = new ModelRenderer(this);
		bone38.setRotationPoint(0.0F, -8.0F, -36.0F);
		tankTread4.addChild(bone38);
		setRotationAngle(bone38, -0.1745F, 0.0F, 0.0F);
		bone38.setTextureOffset(32, 35).addBox(5.0F, -58.1481F, 19.4132F, 7.0F, 7.0F, 2.0F, 0.0F, false);

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(50.0F, 105.0F, 4.0F);
		RightLegBase2.addChild(bone20);
		bone20.setTextureOffset(266, 179).addBox(-69.0F, -5.0F, -9.0F, 19.0F, 4.0F, 18.0F, 0.0F, false);

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(10.0F, 98.0F, 0.0F);
		RightLegBase2.addChild(bone21);
		setRotationAngle(bone21, 0.8727F, 0.0F, 0.0F);
		bone21.setTextureOffset(0, 27).addBox(-29.0F, -3.2139F, -11.1698F, 19.0F, 2.0F, 6.0F, 0.0F, false);

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(-31.0F, 33.0F, 0.0F);
		bone23.setTextureOffset(230, 0).addBox(21.0F, -124.0F, -8.0F, 21.0F, 21.0F, 16.0F, 0.0F, false);
		bone23.setTextureOffset(220, 136).addBox(-5.0F, -145.0F, -13.0F, 71.0F, 21.0F, 22.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 136).addBox(-46.0F, -183.0F, -24.0F, 87.0F, 51.0F, 46.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-46.0F, -261.0F, -28.0F, 87.0F, 80.0F, 56.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(50.0F, -223.0F, 3.0F);
		leftArm.setTextureOffset(228, 233).addBox(-9.0F, -13.0F, -16.0F, 47.0F, 32.0F, 30.0F, 0.0F, false);

		bone41 = new ModelRenderer(this);
		bone41.setRotationPoint(-165.0F, 247.0F, -3.0F);
		leftArm.addChild(bone41);
		bone41.setTextureOffset(114, 233).addBox(160.0F, -228.0F, -12.0F, 29.0F, 129.0F, 28.0F, 0.0F, false);

		bone48 = new ModelRenderer(this);
		bone48.setRotationPoint(-50.0F, 247.0F, -3.0F);
		leftArm.addChild(bone48);
		bone48.setTextureOffset(228, 295).addBox(74.0F, -179.0F, -17.0F, 23.0F, 50.0F, 39.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(-55.0F, -224.0F, 0.0F);
		rightArm.setTextureOffset(352, 352).addBox(-36.0F, -12.0F, -13.0F, 45.0F, 32.0F, 30.0F, 0.0F, false);

		bone42 = new ModelRenderer(this);
		bone42.setRotationPoint(-183.0F, 248.0F, 0.0F);
		rightArm.addChild(bone42);
		bone42.setTextureOffset(0, 233).addBox(155.0F, -228.0F, -12.0F, 29.0F, 129.0F, 28.0F, 0.0F, false);

		bone49 = new ModelRenderer(this);
		bone49.setRotationPoint(-118.0F, 248.0F, 0.0F);
		rightArm.addChild(bone49);
		bone49.setTextureOffset(286, 0).addBox(70.0F, -179.0F, -17.0F, 23.0F, 50.0F, 39.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(-11.0F, -229.0F, 8.0F);
		head.setTextureOffset(0, 390).addBox(-9.0F, -35.0F, -21.0F, 30.0F, 27.0F, 30.0F, 0.0F, false);

		bone44 = new ModelRenderer(this);
		bone44.setRotationPoint(21.0F, -29.0F, -3.0F);
		head.addChild(bone44);
		setRotationAngle(bone44, -0.6109F, 0.0F, 0.0F);
		bone44.setTextureOffset(20, 136).addBox(0.0F, -18.0F, -5.0F, 1.0F, 24.0F, 9.0F, 0.0F, false);

		bone45 = new ModelRenderer(this);
		bone45.setRotationPoint(-11.0F, -29.0F, -3.0F);
		head.addChild(bone45);
		setRotationAngle(bone45, -0.6109F, 0.0F, 0.0F);
		bone45.setTextureOffset(0, 136).addBox(0.0F, -18.0F, -5.0F, 1.0F, 24.0F, 9.0F, 0.0F, false);

		bone46 = new ModelRenderer(this);
		bone46.setRotationPoint(11.0F, 253.0F, -8.0F);
		head.addChild(bone46);
		bone46.setTextureOffset(0, 35).addBox(-9.0F, -272.0F, -14.0F, 9.0F, 12.0F, 7.0F, 0.0F, false);

		bone47 = new ModelRenderer(this);
		bone47.setRotationPoint(-10.0F, 20.0F, 0.0F);
		bone47.setTextureOffset(0, 0).addBox(-26.0F, -268.0F, -7.0F, 13.0F, 11.0F, 8.0F, 0.0F, false);
		bone47.setTextureOffset(361, 40).addBox(-28.0F, -272.0F, -56.0F, 15.0F, 15.0F, 49.0F, 0.0F, false);

		bone39 = new ModelRenderer(this);
		bone39.setRotationPoint(49.0F, 20.0F, 0.0F);
		bone39.setTextureOffset(0, 0).addBox(-26.0F, -268.0F, -7.0F, 13.0F, 11.0F, 8.0F, 0.0F, false);
		bone39.setTextureOffset(361, 40).addBox(-28.0F, -272.0F, -56.0F, 15.0F, 15.0F, 49.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		RightLegBase.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLegBase2.render(matrixStack, buffer, packedLight, packedOverlay);
		bone23.render(matrixStack, buffer, packedLight, packedOverlay);
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		bone47.render(matrixStack, buffer, packedLight, packedOverlay);
		bone39.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.RightLegBase2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.RightLegBase.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}