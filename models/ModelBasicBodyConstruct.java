// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelBasicBodyConstruct extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer legLeft;
	private final ModelRenderer bone4;
	private final ModelRenderer bone3;
	private final ModelRenderer bone5;

	public ModelBasicBodyConstruct() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(3.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-12.0F, -33.0F, -8.0F, 19.0F, 23.0F, 17.0F, 0.0F, false);

		legLeft = new ModelRenderer(this);
		legLeft.setRotationPoint(3.5F, -7.75F, 2.5F);
		bone.addChild(legLeft);
		legLeft.setTextureOffset(32, 40).addBox(0.5F, -3.25F, -3.5F, 8.0F, 11.0F, 8.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(5.5F, 7.75F, -4.5F);
		legLeft.addChild(bone4);
		bone4.setTextureOffset(55, 0).addBox(-5.0F, -2.0F, -8.0F, 8.0F, 2.0F, 9.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-7.5F, -9.75F, 3.5F);
		bone.addChild(bone3);
		bone3.setTextureOffset(0, 40).addBox(-8.5F, -1.25F, -4.5F, 8.0F, 11.0F, 8.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-3.5F, 9.75F, -5.5F);
		bone3.addChild(bone5);
		bone5.setTextureOffset(55, 55).addBox(-5.0F, -2.0F, -8.0F, 8.0F, 2.0F, 9.0F, 0.0F, false);
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
		this.bone3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.legLeft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}