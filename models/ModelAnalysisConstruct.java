// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelAnalysisConstruct extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone6;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone3;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;

	public ModelAnalysisConstruct() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-6.0F, -22.0F, -6.0F, 12.0F, 13.0F, 15.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -6.0F, -2.0F);
		bone.addChild(bone2);
		bone2.setTextureOffset(21, 32).addBox(-11.0F, -4.0F, -13.0F, 5.0F, 4.0F, 11.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(8.5147F, 0.0F, -4.5858F);
		bone2.addChild(bone6);
		bone6.setTextureOffset(42, 28).addBox(-19.5F, -4.0F, -13.4F, 5.0F, 4.0F, 5.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(16.0F, -6.0F, 0.0F);
		bone.addChild(bone4);
		bone4.setTextureOffset(39, 0).addBox(-10.0F, -14.0F, -10.0F, 5.0F, 11.0F, 4.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone5);
		bone5.setTextureOffset(0, 43).addBox(-10.0F, -14.0F, -15.0F, 5.0F, 4.0F, 5.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, -14.5F, -3.0F);
		bone.addChild(bone3);
		setRotationAngle(bone3, 0.0F, 0.7854F, 0.0F);
		bone3.setTextureOffset(0, 28).addBox(-1.8787F, -6.5F, -6.1213F, 8.0F, 7.0F, 8.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone7.setTextureOffset(15, 47).addBox(1.0F, -9.0F, 3.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(-6.0F, 24.0F, 0.0F);
		bone8.setTextureOffset(42, 37).addBox(0.0F, -9.0F, 3.0F, 5.0F, 1.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		bone7.render(matrixStack, buffer, packedLight, packedOverlay);
		bone8.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}