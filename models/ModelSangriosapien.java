// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelSangriosapien extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;

	public ModelSangriosapien() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-9.0F, -1.0F, -8.0F, 17.0F, 1.0F, 16.0F, 0.0F, false);
		bone.setTextureOffset(0, 17).addBox(-8.0F, -10.0F, -7.0F, 15.0F, 9.0F, 14.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-2.0F, 14.0F, 7.0F);
		bone2.setTextureOffset(0, 40).addBox(-6.0F, -6.0F, -14.0F, 15.0F, 6.0F, 14.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(7.0F, 14.0F, 1.0F);
		setRotationAngle(bone3, 0.0F, 0.0F, 0.6981F);
		bone3.setTextureOffset(44, 17).addBox(0.0F, -1.0F, -2.0F, 7.0F, 3.0F, 4.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(-9.0F, 14.0F, 0.0F);
		setRotationAngle(bone4, 0.0F, 0.0F, -0.6981F);
		bone4.setTextureOffset(44, 44).addBox(-6.0F, -1.0F, -1.0F, 7.0F, 3.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		bone2.render(matrixStack, buffer, packedLight, packedOverlay);
		bone3.render(matrixStack, buffer, packedLight, packedOverlay);
		bone4.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.bone3.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.bone2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.bone4.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}