// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelLithosaurus extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer legFrontLeftBase;
	private final ModelRenderer bone2;
	private final ModelRenderer legFrontRightBase;
	private final ModelRenderer bone3;
	private final ModelRenderer legBackRightBase;
	private final ModelRenderer bone4;
	private final ModelRenderer legBackLeftBase;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;

	public ModelLithosaurus() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-8.0F, -24.0F, -12.0F, 16.0F, 15.0F, 29.0F, 1.0F, false);

		legFrontLeftBase = new ModelRenderer(this);
		legFrontLeftBase.setRotationPoint(10.0F, 10.0F, -9.0F);
		legFrontLeftBase.setTextureOffset(43, 74).addBox(-2.0F, -3.0F, -2.0F, 3.0F, 5.0F, 5.0F, 1.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(9.0F, 14.0F, -8.0F);
		legFrontLeftBase.addChild(bone2);
		bone2.setTextureOffset(34, 44).addBox(-11.0F, -10.0F, 6.0F, 3.0F, 9.0F, 5.0F, 1.0F, false);

		legFrontRightBase = new ModelRenderer(this);
		legFrontRightBase.setRotationPoint(-9.0F, 9.0F, -8.0F);
		legFrontRightBase.setTextureOffset(27, 74).addBox(-2.0F, -2.0F, -3.0F, 3.0F, 5.0F, 5.0F, 1.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(9.0F, 15.0F, -9.0F);
		legFrontRightBase.addChild(bone3);
		bone3.setTextureOffset(0, 44).addBox(-11.0F, -10.0F, 6.0F, 3.0F, 9.0F, 5.0F, 1.0F, false);

		legBackRightBase = new ModelRenderer(this);
		legBackRightBase.setRotationPoint(-10.0F, 9.0F, 9.0F);
		legBackRightBase.setTextureOffset(16, 68).addBox(-1.0F, -2.0F, -3.0F, 3.0F, 5.0F, 5.0F, 1.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(10.0F, 15.0F, -9.0F);
		legBackRightBase.addChild(bone4);
		bone4.setTextureOffset(11, 11).addBox(-11.0F, -10.0F, 6.0F, 3.0F, 9.0F, 5.0F, 1.0F, false);

		legBackLeftBase = new ModelRenderer(this);
		legBackLeftBase.setRotationPoint(10.0F, 10.0F, 9.0F);
		legBackLeftBase.setTextureOffset(0, 68).addBox(-2.0F, -3.0F, -3.0F, 3.0F, 5.0F, 5.0F, 1.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(9.0F, 14.0F, -9.0F);
		legBackLeftBase.addChild(bone5);
		bone5.setTextureOffset(0, 0).addBox(-11.0F, -10.0F, 6.0F, 3.0F, 9.0F, 5.0F, 1.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone6.setTextureOffset(68, 44).addBox(-6.0F, -23.0F, -25.0F, 12.0F, 6.0F, 13.0F, 1.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 8.0F, 0.0F);
		bone6.addChild(bone7);
		bone7.setTextureOffset(73, 73).addBox(-6.0F, -23.0F, -25.0F, 12.0F, 3.0F, 13.0F, 1.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 24.0F, 2.0F);
		bone8.setTextureOffset(34, 50).addBox(-3.0F, -19.0F, 11.0F, 8.0F, 6.0F, 18.0F, 1.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, 0.0F, 18.0F);
		bone8.addChild(bone9);
		bone9.setTextureOffset(0, 44).addBox(-3.0F, -19.0F, 13.0F, 8.0F, 6.0F, 18.0F, 1.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, 0.0F, -2.0F);
		bone8.addChild(bone10);
		bone10.setTextureOffset(61, 0).addBox(-7.0F, -22.0F, 52.0F, 16.0F, 13.0F, 10.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		legFrontLeftBase.render(matrixStack, buffer, packedLight, packedOverlay);
		legFrontRightBase.render(matrixStack, buffer, packedLight, packedOverlay);
		legBackRightBase.render(matrixStack, buffer, packedLight, packedOverlay);
		legBackLeftBase.render(matrixStack, buffer, packedLight, packedOverlay);
		bone6.render(matrixStack, buffer, packedLight, packedOverlay);
		bone8.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.legFrontRightBase.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.legFrontLeftBase.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.legBackRightBase.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.legBackLeftBase.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}