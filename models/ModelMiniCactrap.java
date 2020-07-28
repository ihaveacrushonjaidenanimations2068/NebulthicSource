// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelMiniCactrap extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;

	public ModelMiniCactrap() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-5.0F, -16.0F, -5.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);
		bone.setTextureOffset(29, 29).addBox(-6.0F, -2.0F, -6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 26).addBox(4.0F, -2.0F, -6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 4).addBox(4.0F, -2.0F, 4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-6.0F, -2.0F, 4.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(1.0F, 24.0F, -0.6F);
		bone2.setTextureOffset(0, 40).addBox(-1.0F, -28.0F, 0.0F, 0.0F, 12.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(40, 0).addBox(-1.5F, -28.0F, 0.5F, 1.0F, 12.0F, 0.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-1.0F, -28.0F, 0.0F);
		bone2.addChild(bone3);
		bone3.setTextureOffset(38, 39).addBox(-6.0F, -12.0F, -1.0F, 12.0F, 12.0F, 2.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(1.0F, 28.0F, 0.0F);
		bone3.addChild(bone4);
		bone4.setTextureOffset(29, 15).addBox(-6.0F, -33.0F, -12.0F, 9.0F, 3.0F, 11.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(1.0F, 32.0F, 0.0F);
		bone3.addChild(bone5);
		bone5.setTextureOffset(0, 26).addBox(-6.0F, -41.0F, -12.0F, 9.0F, 4.0F, 11.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		bone2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.bone3.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.bone3.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}