// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelunbornmage extends EntityModel<Entity> {
	private final ModelRenderer bone8;
	private final ModelRenderer bone;
	private final ModelRenderer bone4;
	private final ModelRenderer bone7;
	private final ModelRenderer bone5;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone6;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone39;
	private final ModelRenderer bone40;
	private final ModelRenderer bone12;
	private final ModelRenderer bone38;
	private final ModelRenderer bone13;
	private final ModelRenderer bone33;
	private final ModelRenderer bone14;
	private final ModelRenderer bone28;
	private final ModelRenderer bone15;
	private final ModelRenderer bone34;
	private final ModelRenderer bone16;
	private final ModelRenderer bone36;
	private final ModelRenderer bone17;
	private final ModelRenderer bone21;
	private final ModelRenderer bone22;
	private final ModelRenderer bone23;
	private final ModelRenderer bone24;
	private final ModelRenderer bone41;
	private final ModelRenderer bone42;
	private final ModelRenderer bone18;
	private final ModelRenderer bone35;
	private final ModelRenderer bone19;
	private final ModelRenderer bone20;
	private final ModelRenderer bone29;
	private final ModelRenderer bone30;
	private final ModelRenderer bone31;
	private final ModelRenderer bone32;
	private final ModelRenderer bone37;
	private final ModelRenderer bone25;
	private final ModelRenderer bone26;
	private final ModelRenderer bone27;

	public Modelunbornmage() {
		textureWidth = 128;
		textureHeight = 128;

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(-3.0F, 6.0F, -0.7F);
		setRotationAngle(bone8, 0.0F, 0.0873F, 0.0F);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(3.0F, 18.0F, 0.7F);
		bone8.addChild(bone);
		bone.setTextureOffset(31, 55).addBox(-5.0F, -1.0F, -5.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(3.0F, 18.0F, 0.7F);
		bone8.addChild(bone4);
		bone4.setTextureOffset(49, 52).addBox(-5.0F, -9.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(3.0F, 18.0F, 0.7F);
		bone8.addChild(bone7);
		bone7.setTextureOffset(50, 9).addBox(-5.0F, -18.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(3.0F, 18.0F, 0.7F);
		bone8.addChild(bone5);
		bone5.setTextureOffset(7, 9).addBox(-4.0F, -10.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(4.0F, 7.0F, -0.7F);
		setRotationAngle(bone2, 0.0F, -0.0873F, 0.0F);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-4.0F, 17.0F, 0.7F);
		bone2.addChild(bone3);
		bone3.setTextureOffset(52, 44).addBox(3.0F, -1.0F, -5.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-4.0F, 17.0F, 0.7F);
		bone2.addChild(bone6);
		bone6.setTextureOffset(24, 47).addBox(3.0F, -9.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(-4.0F, 17.0F, 0.7F);
		bone2.addChild(bone9);
		bone9.setTextureOffset(12, 47).addBox(3.0F, -18.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(-4.0F, 17.0F, 0.7F);
		bone2.addChild(bone10);
		bone10.setTextureOffset(0, 9).addBox(4.0F, -10.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone11.setTextureOffset(28, 28).addBox(-3.0F, -20.0F, -3.0F, 7.0F, 4.0F, 5.0F, 0.0F, false);

		bone39 = new ModelRenderer(this);
		bone39.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone11.addChild(bone39);
		bone39.setTextureOffset(77, 54).addBox(-3.0F, -20.0F, -3.0F, 7.0F, 4.0F, 5.0F, 1.0F, false);

		bone40 = new ModelRenderer(this);
		bone40.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone11.addChild(bone40);
		bone40.setTextureOffset(71, 67).addBox(-4.0F, -23.0F, -6.0F, 9.0F, 9.0F, 9.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone12.setTextureOffset(37, 20).addBox(-2.0F, -24.0F, -2.0F, 5.0F, 4.0F, 3.0F, 0.0F, false);

		bone38 = new ModelRenderer(this);
		bone38.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone12.addChild(bone38);
		bone38.setTextureOffset(111, 67).addBox(-2.0F, -24.0F, -2.0F, 5.0F, 4.0F, 3.0F, 1.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone13.setTextureOffset(0, 20).addBox(-3.0F, -33.0F, -5.0F, 7.0F, 9.0F, 7.0F, 0.0F, false);

		bone33 = new ModelRenderer(this);
		bone33.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone13.addChild(bone33);
		bone33.setTextureOffset(75, 35).addBox(-3.0F, -33.0F, -5.0F, 7.0F, 9.0F, 7.0F, 1.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, -9.0F, -1.0F);
		setRotationAngle(bone14, 0.3491F, 0.0F, 0.0F);
		bone14.setTextureOffset(0, 0).addBox(-6.0F, -7.9739F, -8.1809F, 14.0F, 9.0F, 11.0F, 0.0F, false);

		bone28 = new ModelRenderer(this);
		bone28.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone14.addChild(bone28);
		bone28.setTextureOffset(69, 13).addBox(-6.0F, -7.9739F, -8.1809F, 14.0F, 9.0F, 11.0F, 1.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(9.0F, -15.0F, -3.0F);
		bone15.setTextureOffset(20, 37).addBox(-1.0F, -2.0F, -2.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);

		bone34 = new ModelRenderer(this);
		bone34.setRotationPoint(-9.0F, 39.0F, 3.0F);
		bone15.addChild(bone34);
		bone34.setTextureOffset(108, 38).addBox(8.0F, -41.0F, -5.0F, 5.0F, 5.0F, 5.0F, 1.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(-9.0F, 39.0F, 3.0F);
		bone15.addChild(bone16);
		bone16.setTextureOffset(52, 34).addBox(9.0F, -36.0F, -4.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		bone36 = new ModelRenderer(this);
		bone36.setRotationPoint(-9.0F, 39.0F, 3.0F);
		bone15.addChild(bone36);
		bone36.setTextureOffset(113, 52).addBox(9.0F, -36.0F, -4.0F, 3.0F, 7.0F, 3.0F, 1.0F, false);

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(1.6F, 11.0F, 0.3F);
		bone15.addChild(bone17);
		setRotationAngle(bone17, -0.6109F, 0.0F, 0.0F);
		bone17.setTextureOffset(0, 46).addBox(-1.6F, -1.7942F, -2.181F, 3.0F, 12.0F, 3.0F, 0.0F, false);

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(1.4F, 18.0F, -6.0F);
		bone15.addChild(bone21);
		setRotationAngle(bone21, -0.6109F, 0.0F, 0.0F);
		bone21.setTextureOffset(9, 58).addBox(0.4F, 0.8F, -1.1F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(1.6F, 3.9F, -0.6F);
		bone21.addChild(bone22);
		setRotationAngle(bone22, 0.0F, 0.0F, 0.6109F);
		bone22.setTextureOffset(8, 3).addBox(-0.1F, -0.1F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, false);

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(1.6F, 4.2F, 0.5F);
		bone21.addChild(bone23);
		setRotationAngle(bone23, 0.0F, 0.0F, 0.6109F);
		bone23.setTextureOffset(8, 0).addBox(-0.2F, -0.4F, -0.4F, 0.0F, 3.0F, 1.0F, 0.0F, false);

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(1.4F, 4.0F, 1.7F);
		bone21.addChild(bone24);
		setRotationAngle(bone24, 0.0F, 0.0F, 0.6109F);
		bone24.setTextureOffset(6, 6).addBox(0.0F, -0.2F, -0.5F, 0.0F, 3.0F, 1.0F, 0.0F, false);

		bone41 = new ModelRenderer(this);
		bone41.setRotationPoint(39.0F, 7.2075F, -12.3714F);
		bone15.addChild(bone41);
		setRotationAngle(bone41, 0.9599F, 0.0F, 0.0F);
		bone41.setTextureOffset(116, 83).addBox(-38.0F, 4.2873F, -8.6036F, 1.0F, 17.0F, 1.0F, 0.0F, false);

		bone42 = new ModelRenderer(this);
		bone42.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone41.addChild(bone42);
		bone42.setTextureOffset(73, 89).addBox(-41.0F, -2.9514F, -11.7541F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(-6.9F, -14.0F, -2.6F);
		bone18.setTextureOffset(0, 36).addBox(-4.0F, -3.0F, -2.4F, 5.0F, 5.0F, 5.0F, 0.0F, false);

		bone35 = new ModelRenderer(this);
		bone35.setRotationPoint(6.9F, 38.0F, 2.6F);
		bone18.addChild(bone35);
		bone35.setTextureOffset(108, 38).addBox(-11.0F, -41.0F, -5.0F, 5.0F, 5.0F, 5.0F, 1.0F, false);

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(7.0F, 38.0F, 2.6F);
		bone18.addChild(bone19);
		bone19.setTextureOffset(52, 24).addBox(-10.0F, -36.0F, -4.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(-1.0F, 10.0F, 0.6F);
		bone18.addChild(bone20);
		setRotationAngle(bone20, -0.6981F, 0.0F, 0.0F);
		bone20.setTextureOffset(40, 40).addBox(-2.0F, -1.4088F, -2.8767F, 3.0F, 12.0F, 3.0F, 0.0F, false);

		bone29 = new ModelRenderer(this);
		bone29.setRotationPoint(-3.4F, 17.0F, -6.4F);
		bone18.addChild(bone29);
		setRotationAngle(bone29, -0.6109F, 0.0F, 0.0F);
		bone29.setTextureOffset(0, 0).addBox(0.5F, 0.6527F, -1.9356F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		bone30 = new ModelRenderer(this);
		bone30.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone29.addChild(bone30);
		bone30.setTextureOffset(4, 5).addBox(0.5F, 3.6527F, -1.9356F, 0.0F, 3.0F, 1.0F, 0.0F, false);

		bone31 = new ModelRenderer(this);
		bone31.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone29.addChild(bone31);
		bone31.setTextureOffset(2, 5).addBox(0.6F, 3.6527F, -0.7356F, 0.0F, 3.0F, 1.0F, 0.0F, false);

		bone32 = new ModelRenderer(this);
		bone32.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone29.addChild(bone32);
		bone32.setTextureOffset(0, 5).addBox(0.6F, 3.6527F, 0.3644F, 0.0F, 3.0F, 1.0F, 0.0F, false);

		bone37 = new ModelRenderer(this);
		bone37.setRotationPoint(-12.1F, 38.0F, 2.6F);
		bone18.addChild(bone37);
		bone37.setTextureOffset(113, 52).addBox(9.0F, -36.0F, -4.0F, 3.0F, 7.0F, 3.0F, 1.0F, false);

		bone25 = new ModelRenderer(this);
		bone25.setRotationPoint(0.6F, -14.0F, -9.0F);
		bone25.setTextureOffset(39, 0).addBox(-2.3F, -4.0F, -5.3F, 5.0F, 4.0F, 5.0F, 0.0F, false);

		bone26 = new ModelRenderer(this);
		bone26.setRotationPoint(-0.6F, 0.0F, -2.0F);
		bone25.addChild(bone26);
		setRotationAngle(bone26, 0.2618F, 0.0F, 0.0F);
		bone26.setTextureOffset(21, 20).addBox(-0.7F, 0.0F, -3.3F, 3.0F, 2.0F, 5.0F, 0.0F, false);

		bone27 = new ModelRenderer(this);
		bone27.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone25.addChild(bone27);
		bone27.setTextureOffset(76, 0).addBox(-2.3F, -4.0F, -5.3F, 5.0F, 4.0F, 5.0F, 1.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone8.render(matrixStack, buffer, packedLight, packedOverlay);
		bone2.render(matrixStack, buffer, packedLight, packedOverlay);
		bone11.render(matrixStack, buffer, packedLight, packedOverlay);
		bone12.render(matrixStack, buffer, packedLight, packedOverlay);
		bone13.render(matrixStack, buffer, packedLight, packedOverlay);
		bone14.render(matrixStack, buffer, packedLight, packedOverlay);
		bone15.render(matrixStack, buffer, packedLight, packedOverlay);
		bone18.render(matrixStack, buffer, packedLight, packedOverlay);
		bone25.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.bone25.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.bone25.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.bone18.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.bone15.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.bone8.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.bone2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}