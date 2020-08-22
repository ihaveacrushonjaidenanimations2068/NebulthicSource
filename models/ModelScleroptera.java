// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelScleroptera extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer legLeft;
	private final ModelRenderer bone8;
	private final ModelRenderer legRight;
	private final ModelRenderer bone9;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;

	public ModelScleroptera() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-0.5F, 17.5F, -0.5F);
		setRotationAngle(bone, 0.4363F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-2.5F, -6.3126F, -1.6548F, 5.0F, 9.0F, 5.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(2.5F, -5.8289F, 1.0163F);
		bone.addChild(bone4);
		bone4.setTextureOffset(20, 0).addBox(0.0F, -1.0F, 0.0F, 8.0F, 8.0F, 0.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-6.5F, -5.8289F, 1.0163F);
		bone.addChild(bone5);
		bone5.setTextureOffset(20, 20).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 8.0F, 0.0F, 0.0F, false);

		legLeft = new ModelRenderer(this);
		legLeft.setRotationPoint(3.0F, 21.0F, 1.0F);
		legLeft.setTextureOffset(8, 23).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(3.0F, 0.0F, 0.0F);
		legLeft.addChild(bone8);
		bone8.setTextureOffset(14, 23).addBox(-4.0F, 1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		legRight = new ModelRenderer(this);
		legRight.setRotationPoint(-4.0F, 21.0F, 1.0F);
		legRight.setTextureOffset(0, 23).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(14.0F, 1.0F, 1.0F);
		legRight.addChild(bone9);
		bone9.setTextureOffset(20, 8).addBox(-15.0F, 0.0F, -1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone6.setTextureOffset(0, 14).addBox(-3.0F, -16.6349F, -5.136F, 5.0F, 4.0F, 5.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 0.0F, -5.0F);
		bone6.addChild(bone7);
		bone7.setTextureOffset(16, 10).addBox(-2.0F, -15.0F, -4.0F, 3.0F, 2.0F, 4.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone10.setTextureOffset(0, 14).addBox(1.0F, -18.7F, -1.1F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(-5.0F, 24.0F, 0.0F);
		bone11.setTextureOffset(0, 0).addBox(2.0F, -18.7F, -1.1F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone12.setTextureOffset(20, 16).addBox(-3.0F, -5.4782F, 3.6676F, 5.0F, 4.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		legLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		legRight.render(matrixStack, buffer, packedLight, packedOverlay);
		bone6.render(matrixStack, buffer, packedLight, packedOverlay);
		bone10.render(matrixStack, buffer, packedLight, packedOverlay);
		bone11.render(matrixStack, buffer, packedLight, packedOverlay);
		bone12.render(matrixStack, buffer, packedLight, packedOverlay);
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