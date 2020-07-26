// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelNewRazorbird extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone21;
	private final ModelRenderer bone24;
	private final ModelRenderer bone8;
	private final ModelRenderer bone22;
	private final ModelRenderer bone23;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;
	private final ModelRenderer bone14;
	private final ModelRenderer bone15;
	private final ModelRenderer bone16;
	private final ModelRenderer bone17;
	private final ModelRenderer bone18;
	private final ModelRenderer bone19;
	private final ModelRenderer bone20;

	public ModelNewRazorbird() {
		textureWidth = 256;
		textureHeight = 256;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 36).addBox(-9.0F, -43.0F, -19.0F, 16.0F, 13.0F, 30.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 30.0F);
		bone.addChild(bone2);
		bone2.setTextureOffset(62, 38).addBox(-7.0F, -41.0F, -19.0F, 12.0F, 9.0F, 15.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(8.0F, -12.0F, -18.0F);
		bone3.setTextureOffset(62, 36).addBox(-1.0F, -3.0F, -1.0F, 49.0F, 1.0F, 1.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(-10.0F, 36.0F, 19.0F);
		bone3.addChild(bone4);
		bone4.setTextureOffset(0, 18).addBox(9.0F, -38.0F, -19.0F, 44.0F, 1.0F, 17.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-13.0F, -14.0F, -12.0F);
		bone5.setTextureOffset(62, 62).addBox(-47.0F, -1.0F, -7.0F, 51.0F, 1.0F, 1.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-36.0F, 38.0F, 13.0F);
		bone5.addChild(bone6);
		bone6.setTextureOffset(0, 0).addBox(-7.0F, -38.0F, -19.0F, 47.0F, 1.0F, 17.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(-9.0F, -12.0F, 18.0F);
		setRotationAngle(bone7, 1.5708F, 0.0F, 0.0F);
		bone7.setTextureOffset(16, 123).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 19.0F, 4.0F, 0.0F, false);

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(0.0F, 37.5397F, 1.4559F);
		bone7.addChild(bone21);
		setRotationAngle(bone21, -1.0472F, 0.0F, 0.0F);
		bone21.setTextureOffset(118, 86).addBox(-1.0F, -10.741F, -21.5159F, 4.0F, 19.0F, 4.0F, 0.0F, false);

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(14.0F, 18.0F, 10.0F);
		bone7.addChild(bone24);
		setRotationAngle(bone24, -0.3491F, 0.0F, 0.0F);
		bone24.setTextureOffset(0, 36).addBox(-15.0F, 16.3513F, -31.0725F, 4.0F, 2.0F, 11.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(5.0F, -10.0F, 18.0F);
		setRotationAngle(bone8, 1.5708F, 0.0F, 0.0F);
		bone8.setTextureOffset(0, 123).addBox(-2.0F, -3.8126F, -1.1548F, 4.0F, 19.0F, 4.0F, 0.0F, false);

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(-1.0F, 35.7271F, 10.3012F);
		bone8.addChild(bone22);
		setRotationAngle(bone22, -0.7854F, 0.0F, 0.0F);
		bone22.setTextureOffset(108, 118).addBox(-1.0F, -9.2516F, -23.7959F, 4.0F, 19.0F, 4.0F, 0.0F, false);

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(0.0F, 18.7271F, 2.3012F);
		bone8.addChild(bone23);
		setRotationAngle(bone23, -0.2618F, 0.0F, 0.0F);
		bone23.setTextureOffset(0, 49).addBox(-2.0F, 12.8946F, -20.8906F, 4.0F, 2.0F, 11.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(4.0F, -16.0F, 25.0F);
		setRotationAngle(bone9, 0.0F, 0.3491F, 0.0F);
		bone9.setTextureOffset(0, 101).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 20.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(2.0F, -16.0F, 25.0F);
		setRotationAngle(bone10, 0.0F, 0.1745F, 0.0F);
		bone10.setTextureOffset(96, 64).addBox(-1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 20.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, -17.0F, 27.0F);
		setRotationAngle(bone11, 0.0F, 0.0873F, 0.0F);
		bone11.setTextureOffset(94, 96).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 20.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(-2.0F, -17.0F, 27.0F);
		setRotationAngle(bone12, 0.0F, -0.0873F, 0.0F);
		bone12.setTextureOffset(70, 94).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 20.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(-3.0F, -16.0F, 27.0F);
		setRotationAngle(bone13, 0.0F, -0.1745F, 0.0F);
		bone13.setTextureOffset(46, 79).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 20.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(-6.0F, -17.0F, 28.0F);
		setRotationAngle(bone14, 0.0F, -0.3491F, 0.0F);
		bone14.setTextureOffset(72, 72).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 2.0F, 20.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(-1.0F, -13.0F, -16.0F);
		bone15.setTextureOffset(0, 79).addBox(-6.0F, -4.0F, -14.0F, 12.0F, 11.0F, 11.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(1.0F, 37.0F, 16.0F);
		bone15.addChild(bone16);
		bone16.setTextureOffset(101, 38).addBox(-4.0F, -36.0F, -43.0F, 6.0F, 2.0F, 13.0F, 0.0F, false);

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(0.0F, 23.0F, -4.0F);
		bone15.addChild(bone17);
		setRotationAngle(bone17, 0.4363F, 0.0F, 0.0F);
		bone17.setTextureOffset(76, 118).addBox(-3.0F, -22.5397F, -11.4559F, 6.0F, 2.0F, 10.0F, 0.0F, false);

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(1.0F, 37.0F, 16.0F);
		bone15.addChild(bone18);
		bone18.setTextureOffset(0, 0).addBox(-1.0F, -48.0F, -25.0F, 0.0F, 7.0F, 7.0F, 0.0F, false);

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone19.setTextureOffset(117, 7).addBox(-13.0F, -46.0F, -19.0F, 5.0F, 15.0F, 11.0F, 0.0F, false);

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(22.0F, 24.0F, 0.0F);
		bone20.setTextureOffset(44, 105).addBox(-15.0F, -46.0F, -19.0F, 5.0F, 15.0F, 11.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		bone3.render(matrixStack, buffer, packedLight, packedOverlay);
		bone5.render(matrixStack, buffer, packedLight, packedOverlay);
		bone7.render(matrixStack, buffer, packedLight, packedOverlay);
		bone8.render(matrixStack, buffer, packedLight, packedOverlay);
		bone9.render(matrixStack, buffer, packedLight, packedOverlay);
		bone10.render(matrixStack, buffer, packedLight, packedOverlay);
		bone11.render(matrixStack, buffer, packedLight, packedOverlay);
		bone12.render(matrixStack, buffer, packedLight, packedOverlay);
		bone13.render(matrixStack, buffer, packedLight, packedOverlay);
		bone14.render(matrixStack, buffer, packedLight, packedOverlay);
		bone15.render(matrixStack, buffer, packedLight, packedOverlay);
		bone19.render(matrixStack, buffer, packedLight, packedOverlay);
		bone20.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.bone4.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.bone7.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.bone8.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.bone3.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
	}
}