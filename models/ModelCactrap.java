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
		bone.setTextureOffset(0, 0).addBox(-5.0F, -25.0F, -5.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);

		frontRightLeg = new ModelRenderer(this);
		frontRightLeg.setRotationPoint(0.0F, 24.0F, 0.0F);
		frontRightLeg.setTextureOffset(67, 73).addBox(-6.0F, -11.0F, -6.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		frontLeftLeg = new ModelRenderer(this);
		frontLeftLeg.setRotationPoint(10.0F, 24.0F, 0.0F);
		frontLeftLeg.setTextureOffset(16, 71).addBox(-6.0F, -11.0F, -6.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		backLeftLeg = new ModelRenderer(this);
		backLeftLeg.setRotationPoint(10.0F, 24.0F, 9.0F);
		backLeftLeg.setTextureOffset(8, 71).addBox(-6.0F, -11.0F, -5.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		backLeftLeg2 = new ModelRenderer(this);
		backLeftLeg2.setRotationPoint(0.0F, 24.0F, 9.0F);
		backLeftLeg2.setTextureOffset(0, 71).addBox(-6.0F, -11.0F, -5.0F, 2.0F, 11.0F, 2.0F, 0.0F, false);

		branch1 = new ModelRenderer(this);
		branch1.setRotationPoint(0.0F, 24.0F, 0.0F);
		branch1.setTextureOffset(0, 67).addBox(5.0F, -15.0F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
		branch1.setTextureOffset(59, 67).addBox(15.0F, -30.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);

		branch2 = new ModelRenderer(this);
		branch2.setRotationPoint(-23.0F, 24.0F, 0.0F);
		branch2.setTextureOffset(63, 52).addBox(6.0F, -15.0F, -1.0F, 12.0F, 2.0F, 2.0F, 0.0F, false);
		branch2.setTextureOffset(28, 67).addBox(6.0F, -30.0F, -1.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);

		branch3 = new ModelRenderer(this);
		branch3.setRotationPoint(-23.0F, 24.0F, -10.0F);
		branch3.setTextureOffset(16, 28).addBox(22.0F, -15.0F, -7.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
		branch3.setTextureOffset(51, 65).addBox(22.0F, -30.0F, -7.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);

		branch4 = new ModelRenderer(this);
		branch4.setRotationPoint(-23.0F, 24.0F, 12.0F);
		branch4.setTextureOffset(0, 26).addBox(22.0F, -15.0F, -7.0F, 2.0F, 2.0F, 12.0F, 0.0F, false);
		branch4.setTextureOffset(43, 64).addBox(22.0F, -30.0F, 3.0F, 2.0F, 15.0F, 2.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone2.setTextureOffset(75, 75).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(40, 78).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
		bone2.setTextureOffset(0, 26).addBox(-5.3F, -40.0F, -5.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		bone2.setTextureOffset(0, 0).addBox(-4.3F, -45.0F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(8.0F, 24.0F, 0.0F);
		bone3.setTextureOffset(26, 70).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
		bone3.setTextureOffset(38, 78).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
		bone3.setTextureOffset(74, 28).addBox(-5.3F, -40.0F, -5.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		bone3.setTextureOffset(30, 0).addBox(-4.3F, -45.0F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(8.0F, 24.0F, 8.0F);
		bone4.setTextureOffset(24, 70).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(36, 78).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
		bone4.setTextureOffset(67, 67).addBox(-5.3F, -38.0F, -5.5F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		bone4.setTextureOffset(0, 34).addBox(-0.3F, -37.0F, -4.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 24.0F, 8.0F);
		bone5.setTextureOffset(40, 66).addBox(-4.0F, -36.0F, -4.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
		bone5.setTextureOffset(77, 77).addBox(-4.5F, -36.0F, -4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);
		bone5.setTextureOffset(16, 26).addBox(-5.3F, -40.0F, -5.5F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		bone5.setTextureOffset(4, 4).addBox(-4.3F, -45.0F, -4.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 8.75F, 0.0F);
		bone6.setTextureOffset(38, 66).addBox(0.0F, -20.75F, -0.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
		bone6.setTextureOffset(76, 36).addBox(-0.5F, -20.75F, 0.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(4.0F, 4.25F, -4.0F);
		bone6.addChild(bone7);
		bone7.setTextureOffset(36, 66).addBox(-4.0F, -36.0F, 3.5F, 0.0F, 11.0F, 1.0F, 0.0F, false);
		bone7.setTextureOffset(76, 16).addBox(-4.5F, -36.0F, 4.0F, 1.0F, 11.0F, 0.0F, 0.0F, false);

		SmallHead = new ModelRenderer(this);
		SmallHead.setRotationPoint(0.0F, 24.0F, 0.0F);
		SmallHead.setTextureOffset(41, 53).addBox(-4.0F, -39.0F, 15.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);
		SmallHead.setTextureOffset(19, 59).addBox(-3.0F, -34.0F, 17.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
		SmallHead.setTextureOffset(57, 44).addBox(-3.0F, -37.0F, 17.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);

		SmallHead2 = new ModelRenderer(this);
		SmallHead2.setRotationPoint(0.0F, 24.0F, 0.0F);
		SmallHead2.setTextureOffset(54, 20).addBox(-4.0F, -39.0F, -17.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);
		SmallHead2.setTextureOffset(62, 8).addBox(-3.0F, -34.0F, -22.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
		SmallHead2.setTextureOffset(58, 59).addBox(-3.0F, -37.0F, -22.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);

		SmallHead3 = new ModelRenderer(this);
		SmallHead3.setRotationPoint(0.0F, 24.0F, 0.0F);
		SmallHead3.setTextureOffset(35, 35).addBox(-17.0F, -39.0F, -5.0F, 2.0F, 9.0F, 9.0F, 0.0F, false);
		SmallHead3.setTextureOffset(17, 46).addBox(-22.0F, -34.0F, -4.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);
		SmallHead3.setTextureOffset(45, 10).addBox(-22.0F, -37.0F, -4.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);

		SmallHead4 = new ModelRenderer(this);
		SmallHead4.setRotationPoint(0.0F, 24.0F, 0.0F);
		SmallHead4.setTextureOffset(32, 17).addBox(15.0F, -39.0F, -4.0F, 2.0F, 9.0F, 9.0F, 0.0F, false);
		SmallHead4.setTextureOffset(0, 42).addBox(17.0F, -34.0F, -3.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);
		SmallHead4.setTextureOffset(30, 0).addBox(17.0F, -37.0F, -3.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);

		SmallHead5 = new ModelRenderer(this);
		SmallHead5.setRotationPoint(0.0F, 7.0F, 15.0F);
		SmallHead5.setTextureOffset(52, 33).addBox(-4.0F, -39.0F, -17.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);
		SmallHead5.setTextureOffset(0, 56).addBox(-3.0F, -34.0F, -22.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
		SmallHead5.setTextureOffset(54, 0).addBox(-3.0F, -37.0F, -22.0F, 7.0F, 3.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
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
}