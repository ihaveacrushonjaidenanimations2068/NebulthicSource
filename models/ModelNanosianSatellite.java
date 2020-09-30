// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelNanosianSatellite extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone11;
	private final ModelRenderer bone10;
	private final ModelRenderer bone12;

	public ModelNanosianSatellite() {
		textureWidth = 256;
		textureHeight = 256;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-15.0F, -73.0F, -16.0F, 30.0F, 30.0F, 30.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 8.0F, -24.0F);
		bone2.setTextureOffset(81, 93).addBox(-16.0F, -58.0F, -7.0F, 32.0F, 32.0F, 15.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 8.0F, -24.0F);
		setRotationAngle(bone3, 0.0F, 0.0F, 0.7854F);
		bone3.setTextureOffset(0, 60).addBox(-45.6985F, -45.6985F, -8.0F, 32.0F, 32.0F, 16.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone4.setTextureOffset(112, 140).addBox(-1.0F, -43.0F, -3.0F, 4.0F, 15.0F, 4.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.25F, -36.5F, 0.0F);
		bone4.addChild(bone5);
		setRotationAngle(bone5, 0.1745F, 0.0F, 0.0F);
		bone5.setTextureOffset(74, 140).addBox(-3.25F, 8.576F, -9.1318F, 7.0F, 6.0F, 12.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-0.25F, 36.5F, 0.0F);
		bone5.addChild(bone6);
		bone6.setTextureOffset(90, 0).addBox(-2.0F, -26.924F, -19.1318F, 5.0F, 4.0F, 10.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(-0.25F, 36.5F, 0.0F);
		bone5.addChild(bone7);
		bone7.setTextureOffset(0, 12).addBox(4.0F, -24.924F, -9.1318F, 5.0F, 0.0F, 12.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(-12.25F, 36.5F, 0.0F);
		bone5.addChild(bone8);
		bone8.setTextureOffset(0, 0).addBox(4.0F, -24.924F, -9.1318F, 5.0F, 0.0F, 12.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(16.5F, -31.0F, -0.5F);
		setRotationAngle(bone9, -0.4363F, 0.0F, 0.0F);
		bone9.setTextureOffset(80, 68).addBox(-1.5F, -5.5315F, -4.6131F, 36.0F, 4.0F, 4.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(-16.5F, 55.0F, 0.5F);
		bone9.addChild(bone11);
		bone11.setTextureOffset(120, 0).addBox(15.0F, -85.5315F, -4.1131F, 35.0F, 52.0F, 2.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(-16.5F, -30.0F, -0.5F);
		setRotationAngle(bone10, -0.4363F, 0.0F, 0.0F);
		bone10.setTextureOffset(80, 60).addBox(-34.5F, -6.5315F, -4.6131F, 36.0F, 4.0F, 4.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(-47.5F, 54.0F, 0.5F);
		bone10.addChild(bone12);
		bone12.setTextureOffset(0, 108).addBox(15.0F, -85.5315F, -4.1131F, 35.0F, 52.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		bone2.render(matrixStack, buffer, packedLight, packedOverlay);
		bone3.render(matrixStack, buffer, packedLight, packedOverlay);
		bone4.render(matrixStack, buffer, packedLight, packedOverlay);
		bone9.render(matrixStack, buffer, packedLight, packedOverlay);
		bone10.render(matrixStack, buffer, packedLight, packedOverlay);
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