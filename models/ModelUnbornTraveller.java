// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelUnbornTraveller extends EntityModel<Entity> {
	private final ModelRenderer rightLeg;
	private final ModelRenderer bone;
	private final ModelRenderer bone4;
	private final ModelRenderer bone7;
	private final ModelRenderer bone5;
	private final ModelRenderer leftLeg;
	private final ModelRenderer bone3;
	private final ModelRenderer bone6;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;
	private final ModelRenderer bone14;
	private final ModelRenderer Backpac;
	private final ModelRenderer leftArm;
	private final ModelRenderer bone16;
	private final ModelRenderer bone17;
	private final ModelRenderer bone21;
	private final ModelRenderer bone22;
	private final ModelRenderer bone23;
	private final ModelRenderer bone24;
	private final ModelRenderer RightArm;
	private final ModelRenderer bone19;
	private final ModelRenderer bone20;
	private final ModelRenderer bone29;
	private final ModelRenderer bone30;
	private final ModelRenderer bone31;
	private final ModelRenderer bone32;
	private final ModelRenderer Head;
	private final ModelRenderer Jaw;

	public ModelUnbornTraveller() {
		textureWidth = 128;
		textureHeight = 128;

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(-3.0F, 6.0F, -0.7F);
		setRotationAngle(rightLeg, 0.0F, 0.0873F, 0.0F);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(3.0F, 18.0F, 0.7F);
		rightLeg.addChild(bone);
		bone.setTextureOffset(31, 55).addBox(-5.0F, -1.0F, -5.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(3.0F, 18.0F, 0.7F);
		rightLeg.addChild(bone4);
		bone4.setTextureOffset(49, 52).addBox(-5.0F, -9.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(3.0F, 18.0F, 0.7F);
		rightLeg.addChild(bone7);
		bone7.setTextureOffset(50, 9).addBox(-5.0F, -18.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(3.0F, 18.0F, 0.7F);
		rightLeg.addChild(bone5);
		bone5.setTextureOffset(7, 9).addBox(-4.0F, -10.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(4.0F, 7.0F, -0.7F);
		setRotationAngle(leftLeg, 0.0F, -0.0873F, 0.0F);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-4.0F, 17.0F, 0.7F);
		leftLeg.addChild(bone3);
		bone3.setTextureOffset(52, 44).addBox(3.0F, -1.0F, -5.0F, 3.0F, 1.0F, 5.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-4.0F, 17.0F, 0.7F);
		leftLeg.addChild(bone6);
		bone6.setTextureOffset(24, 47).addBox(3.0F, -9.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(-4.0F, 17.0F, 0.7F);
		leftLeg.addChild(bone9);
		bone9.setTextureOffset(12, 47).addBox(3.0F, -18.0F, -2.0F, 3.0F, 8.0F, 3.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(-4.0F, 17.0F, 0.7F);
		leftLeg.addChild(bone10);
		bone10.setTextureOffset(0, 9).addBox(4.0F, -10.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone11.setTextureOffset(28, 28).addBox(-3.0F, -20.0F, -3.0F, 7.0F, 4.0F, 5.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone12.setTextureOffset(37, 20).addBox(-2.0F, -24.0F, -2.0F, 5.0F, 4.0F, 3.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone13.setTextureOffset(0, 20).addBox(-3.0F, -33.0F, -5.0F, 7.0F, 9.0F, 7.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, -9.0F, -1.0F);
		setRotationAngle(bone14, 0.3491F, 0.0F, 0.0F);
		bone14.setTextureOffset(0, 0).addBox(-6.0F, -7.9739F, -8.1809F, 14.0F, 9.0F, 11.0F, 0.0F, false);

		Backpac = new ModelRenderer(this);
		Backpac.setRotationPoint(0.0F, 33.0F, 1.0F);
		bone14.addChild(Backpac);
		Backpac.setTextureOffset(76, 32).addBox(-6.0F, -42.5373F, 1.6238F, 14.0F, 17.0F, 5.0F, 0.0F, false);
		Backpac.setTextureOffset(114, 49).addBox(-6.0F, -36.4562F, -9.9281F, 0.0F, 1.0F, 12.0F, 0.0F, false);
		Backpac.setTextureOffset(114, 49).addBox(8.1F, -36.4562F, -9.9281F, 0.0F, 1.0F, 12.0F, 0.0F, true);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(9.0F, -15.0F, -3.0F);
		leftArm.setTextureOffset(20, 37).addBox(-1.0F, -2.0F, -2.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(-9.0F, 39.0F, 3.0F);
		leftArm.addChild(bone16);
		bone16.setTextureOffset(52, 34).addBox(9.0F, -36.0F, -4.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(1.6F, 11.0F, 0.3F);
		leftArm.addChild(bone17);
		setRotationAngle(bone17, -0.6109F, 0.0F, 0.0F);
		bone17.setTextureOffset(0, 46).addBox(-1.6F, -1.7942F, -2.181F, 3.0F, 12.0F, 3.0F, 0.0F, false);

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(1.4F, 18.0F, -6.0F);
		leftArm.addChild(bone21);
		setRotationAngle(bone21, -0.6109F, 0.0F, 0.0F);
		bone21.setTextureOffset(9, 58).addBox(0.4F, 0.8F, -1.1F, 1.0F, 3.0F, 3.0F, 0.0F, false);

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone21.addChild(bone22);
		bone22.setTextureOffset(8, 3).addBox(1.5F, 3.8F, -1.1F, 0.0F, 3.0F, 1.0F, 0.0F, false);

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone21.addChild(bone23);
		bone23.setTextureOffset(8, 0).addBox(1.4F, 3.8F, 0.1F, 0.0F, 3.0F, 1.0F, 0.0F, false);

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone21.addChild(bone24);
		bone24.setTextureOffset(6, 6).addBox(1.4F, 3.8F, 1.2F, 0.0F, 3.0F, 1.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-6.9F, -14.0F, -2.6F);
		setRotationAngle(RightArm, 0.0873F, 0.0F, 0.0F);
		RightArm.setTextureOffset(0, 36).addBox(-4.0F, -3.0F, -2.4F, 5.0F, 5.0F, 5.0F, 0.0F, false);

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(7.0F, 38.0F, 2.6F);
		RightArm.addChild(bone19);
		bone19.setTextureOffset(52, 24).addBox(-10.0F, -36.0F, -4.0F, 3.0F, 7.0F, 3.0F, 0.0F, false);

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(-1.0F, 10.0F, 0.6F);
		RightArm.addChild(bone20);
		setRotationAngle(bone20, -0.6981F, 0.0F, 0.0F);
		bone20.setTextureOffset(40, 40).addBox(-2.0F, -1.4088F, -2.8767F, 3.0F, 12.0F, 3.0F, 0.0F, false);

		bone29 = new ModelRenderer(this);
		bone29.setRotationPoint(-3.4F, 17.0F, -6.4F);
		RightArm.addChild(bone29);
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

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.6F, -14.0F, -9.0F);
		Head.setTextureOffset(39, 0).addBox(-2.3F, -4.0F, -5.3F, 5.0F, 4.0F, 5.0F, 0.0F, false);

		Jaw = new ModelRenderer(this);
		Jaw.setRotationPoint(-0.6F, 0.0F, -2.0F);
		Head.addChild(Jaw);
		setRotationAngle(Jaw, 0.2618F, 0.0F, 0.0F);
		Jaw.setTextureOffset(21, 20).addBox(-0.7F, 0.0F, -3.3F, 3.0F, 2.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		bone11.render(matrixStack, buffer, packedLight, packedOverlay);
		bone12.render(matrixStack, buffer, packedLight, packedOverlay);
		bone13.render(matrixStack, buffer, packedLight, packedOverlay);
		bone14.render(matrixStack, buffer, packedLight, packedOverlay);
		leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}