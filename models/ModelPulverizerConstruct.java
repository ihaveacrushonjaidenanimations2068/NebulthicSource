// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelPulverizerConstruct extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer legLeft;
	private final ModelRenderer bone5;
	private final ModelRenderer legRight;
	private final ModelRenderer bone6;
	private final ModelRenderer bone4;
	private final ModelRenderer bone7;

	public ModelPulverizerConstruct() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 37).addBox(-9.0F, -28.0F, -7.0F, 19.0F, 17.0F, 14.0F, 0.0F, false);

		legLeft = new ModelRenderer(this);
		legLeft.setRotationPoint(10.0F, -12.0F, 4.5F);
		bone.addChild(legLeft);
		legLeft.setTextureOffset(66, 37).addBox(-1.0F, 0.0F, -2.5F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-11.0F, -2.0F, -4.5F);
		legLeft.addChild(bone5);
		bone5.setTextureOffset(26, 68).addBox(10.0F, 12.0F, -5.0F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		legRight = new ModelRenderer(this);
		legRight.setRotationPoint(-8.5F, -12.0F, 4.5F);
		bone.addChild(legRight);
		legRight.setTextureOffset(60, 62).addBox(-5.5F, 0.0F, -2.5F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-15.5F, -2.0F, -4.5F);
		legRight.addChild(bone6);
		bone6.setTextureOffset(0, 68).addBox(10.0F, 12.0F, -5.0F, 6.0F, 2.0F, 7.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone4.setTextureOffset(0, 0).addBox(-9.0F, -28.0F, -27.0F, 19.0F, 17.0F, 20.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.5F, -28.5F, -8.0F);
		bone4.addChild(bone7);
		setRotationAngle(bone7, 0.6981F, 0.0F, 0.0F);
		bone7.setTextureOffset(58, 0).addBox(-9.5F, -14.5F, -1.0F, 19.0F, 15.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		bone4.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.legRight.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.legLeft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}