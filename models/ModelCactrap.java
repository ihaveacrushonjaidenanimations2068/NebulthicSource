// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelCactrap extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer frontRightLeg;
	private final ModelRenderer frontLeftLeg;
	private final ModelRenderer backLeftLeg;
	private final ModelRenderer backLeftLeg2;
	private final ModelRenderer branch1;
	private final ModelRenderer branch2;
	private final ModelRenderer branch3;
	private final ModelRenderer branch4;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer SmallHead;
	private final ModelRenderer SmallHead2;
	private final ModelRenderer SmallHead3;
	private final ModelRenderer SmallHead4;
	private final ModelRenderer SmallHead5;

	public ModelCactrap() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(34, 0).addBox(-5.0F, -25.0F, -5.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);

		frontRightLeg = new ModelRenderer(this);
		frontRightLeg.setRotationPoint(-5.0F, 14.0F, -4.0F);
		frontRightLeg.setTextureOffset(90, 96).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		frontLeftLeg = new ModelRenderer(this);
		frontLeftLeg.setRotationPoint(5.0F, 14.0F, -5.0F);
		frontLeftLeg.setTextureOffset(82, 96).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		backLeftLeg = new ModelRenderer(this);
		backLeftLeg.setRotationPoint(5.0F, 14.0F, 4.0F);
		backLeftLeg.setTextureOffset(8, 95).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		backLeftLeg2 = new ModelRenderer(this);
		backLeftLeg2.setRotationPoint(-5.0F, 14.0F, 5.0F);
		backLeftLeg2.setTextureOffset(0, 95).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		branch1 = new ModelRenderer(this);
		branch1.setRotationPoint(0.0F, 24.0F, 0.0F);
		branch1.setTextureOffset(78, 20).addBox(5.0F, -15.0F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
		branch1.setTextureOffset(30, 91).addBox(15.0F, -30.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
		branch1.setTextureOffset(34, 66).addBox(8.0F, -31.0F, -0.2F, 17.0F, 15.0F, 0.0F, 0.0F, false);
		branch1.setTextureOffset(34, 34).addBox(16.0F, -31.0F, -9.2F, 0.0F, 15.0F, 17.0F, 0.0F, false);

		branch2 = new ModelRenderer(this);
		branch2.setRotationPoint(-23.0F, 24.0F, 0.0F);
		branch2.setTextureOffset(68, 62).addBox(6.0F, -15.0F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
		branch2.setTextureOffset(22, 91).addBox(6.0F, -30.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
		branch2.setTextureOffset(34, 34).addBox(0.0F, -31.0F, -0.8F, 17.0F, 15.0F, 0.0F, 0.0F, false);
		branch2.setTextureOffset(0, 15).addBox(7.2F, -31.0F, -9.0F, 0.0F, 15.0F, 17.0F, 0.0F, false);

		branch3 = new ModelRenderer(this);
		branch3.setRotationPoint(-23.0F, 24.0F, -10.0F);
		branch3.setTextureOffset(62, 14).addBox(22.0F, -15.0F, -7.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
		branch3.setTextureOffset(74, 89).addBox(22.0F, -30.0F, -7.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
		branch3.setTextureOffset(0, 62).addBox(13.8F, -31.0F, -6.0F, 17.0F, 15.0F, 0.0F, 0.0F, false);
		branch3.setTextureOffset(0, 30).addBox(22.8F, -31.0F, -15.0F, 0.0F, 15.0F, 17.0F, 0.0F, false);

		branch4 = new ModelRenderer(this);
		branch4.setRotationPoint(-23.0F, 24.0F, 12.0F);
		branch4.setTextureOffset(56, 37).addBox(22.0F, -15.0F, -7.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
		branch4.setTextureOffset(66, 89).addBox(22.0F, -30.0F, 3.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);
		branch4.setTextureOffset(0, 0).addBox(22.8F, -31.0F, -3.0F, 0.0F, 15.0F, 17.0F, 0.0F, false);
		branch4.setTextureOffset(0, 0).addBox(14.0F, -31.0F, 4.2F, 17.0F, 15.0F, 0.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone2.setTextureOffset(16, 94).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(44, 100).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
		bone2.setTextureOffset(90, 66).addBox(-5.3F, -40.0F, -5.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		bone2.setTextureOffset(62, 28).addBox(-4.3F, -45.0F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(8.0F, 24.0F, 0.0F);
		bone3.setTextureOffset(42, 90).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(99, 57).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
		bone3.setTextureOffset(46, 81).addBox(-5.3F, -40.0F, -5.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		bone3.setTextureOffset(58, 26).addBox(-4.3F, -45.0F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(8.0F, 24.0F, 8.0F);
		bone4.setTextureOffset(40, 90).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(98, 74).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
		bone4.setTextureOffset(13, 77).addBox(-5.3F, -40.0F, -5.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		bone4.setTextureOffset(38, 0).addBox(-4.3F, -45.0F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 24.0F, 8.0F);
		bone5.setTextureOffset(38, 90).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(98, 98).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
		bone5.setTextureOffset(68, 28).addBox(-5.3F, -40.0F, -5.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		bone5.setTextureOffset(34, 0).addBox(-4.3F, -45.0F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 8.75F, 0.0F);
		bone6.setTextureOffset(27, 76).addBox(0.0F, -20.75F, -0.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
		bone6.setTextureOffset(20, 95).addBox(-0.5F, -20.75F, 0.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(4.0F, 4.25F, -4.0F);
		bone6.addChild(bone7);
		bone7.setTextureOffset(25, 76).addBox(-4.0F, -36.0F, 3.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
		bone7.setTextureOffset(18, 95).addBox(-4.5F, -36.0F, 4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);

		SmallHead = new ModelRenderer(this);
		SmallHead.setRotationPoint(0.0F, 24.0F, 0.0F);
		SmallHead.setTextureOffset(44, 89).addBox(-4.0F, -39.0F, 15.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);
		SmallHead.setTextureOffset(90, 49).addBox(-3.0F, -34.0F, 17.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
		SmallHead.setTextureOffset(89, 41).addBox(-3.0F, -37.0F, 17.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);

		SmallHead2 = new ModelRenderer(this);
		SmallHead2.setRotationPoint(0.0F, 24.0F, 0.0F);
		SmallHead2.setTextureOffset(88, 26).addBox(-4.0F, -39.0F, -17.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);
		SmallHead2.setTextureOffset(88, 0).addBox(-3.0F, -34.0F, -22.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
		SmallHead2.setTextureOffset(34, 26).addBox(-3.0F, -37.0F, -22.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);

		SmallHead3 = new ModelRenderer(this);
		SmallHead3.setRotationPoint(0.0F, 24.0F, 0.0F);
		SmallHead3.setTextureOffset(0, 77).addBox(-17.0F, -39.0F, -5.0F, 2.0F, 9.0F, 9.0F, 0.0F, false);
		SmallHead3.setTextureOffset(22, 81).addBox(-22.0F, -34.0F, -4.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);
		SmallHead3.setTextureOffset(61, 79).addBox(-22.0F, -37.0F, -4.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);

		SmallHead4 = new ModelRenderer(this);
		SmallHead4.setRotationPoint(0.0F, 24.0F, 0.0F);
		SmallHead4.setTextureOffset(72, 28).addBox(15.0F, -39.0F, -4.0F, 2.0F, 9.0F, 9.0F, 0.0F, false);
		SmallHead4.setTextureOffset(78, 10).addBox(17.0F, -34.0F, -3.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);
		SmallHead4.setTextureOffset(64, 0).addBox(17.0F, -37.0F, -3.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);

		SmallHead5 = new ModelRenderer(this);
		SmallHead5.setRotationPoint(0.0F, 7.0F, 15.0F);
		SmallHead5.setTextureOffset(85, 85).addBox(-4.0F, -39.0F, -17.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);
		SmallHead5.setTextureOffset(68, 51).addBox(-3.0F, -34.0F, -25.0F, 7.0F, 3.0F, 8.0F, 0.0F, false);
		SmallHead5.setTextureOffset(68, 68).addBox(-3.0F, -37.0F, -25.0F, 7.0F, 3.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		frontRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		frontLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		backLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		backLeftLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
		branch1.render(matrixStack, buffer, packedLight, packedOverlay);
		branch2.render(matrixStack, buffer, packedLight, packedOverlay);
		branch3.render(matrixStack, buffer, packedLight, packedOverlay);
		branch4.render(matrixStack, buffer, packedLight, packedOverlay);
		bone2.render(matrixStack, buffer, packedLight, packedOverlay);
		bone3.render(matrixStack, buffer, packedLight, packedOverlay);
		bone4.render(matrixStack, buffer, packedLight, packedOverlay);
		bone5.render(matrixStack, buffer, packedLight, packedOverlay);
		bone6.render(matrixStack, buffer, packedLight, packedOverlay);
		SmallHead.render(matrixStack, buffer, packedLight, packedOverlay);
		SmallHead2.render(matrixStack, buffer, packedLight, packedOverlay);
		SmallHead3.render(matrixStack, buffer, packedLight, packedOverlay);
		SmallHead4.render(matrixStack, buffer, packedLight, packedOverlay);
		SmallHead5.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.frontRightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.frontLeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.backLeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.backLeftLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}