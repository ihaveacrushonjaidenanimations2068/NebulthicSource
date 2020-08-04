// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelUnbornSpit extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;

	public ModelUnbornSpit() {
		textureWidth = 32;
		textureHeight = 32;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(3.0F, 0.0F, -3.0F);
		bone.addChild(bone2);
		bone2.setTextureOffset(16, 16).addBox(3.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(3.0F, 0.0F, 6.0F);
		bone.addChild(bone3);
		bone3.setTextureOffset(12, 16).addBox(3.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(3.0F, -4.0F, 6.0F);
		bone.addChild(bone4);
		bone4.setTextureOffset(8, 16).addBox(3.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-5.0F, -4.0F, 10.0F);
		bone.addChild(bone5);
		bone5.setTextureOffset(4, 16).addBox(3.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-5.0F, -8.0F, 10.0F);
		bone.addChild(bone6);
		bone6.setTextureOffset(0, 16).addBox(3.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(-10.0F, -5.0F, 9.0F);
		bone.addChild(bone7);
		bone7.setTextureOffset(0, 6).addBox(3.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(-10.0F, -5.0F, 3.0F);
		bone.addChild(bone8);
		bone8.setTextureOffset(3, 5).addBox(3.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(-10.0F, -1.0F, 3.0F);
		bone.addChild(bone9);
		bone9.setTextureOffset(0, 4).addBox(3.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(-10.0F, -1.0F, -3.0F);
		bone.addChild(bone10);
		bone10.setTextureOffset(3, 1).addBox(3.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(-5.0F, -1.0F, -3.0F);
		bone.addChild(bone11);
		bone11.setTextureOffset(3, 3).addBox(3.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(-5.0F, -5.0F, -3.0F);
		bone.addChild(bone12);
		bone12.setTextureOffset(0, 2).addBox(3.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(-5.0F, -9.0F, 1.0F);
		bone.addChild(bone13);
		bone13.setTextureOffset(0, 0).addBox(3.0F, -3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
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