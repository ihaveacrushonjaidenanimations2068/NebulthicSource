// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelNewSclerosianBrute extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone5;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone15;
	private final ModelRenderer bone20;
	private final ModelRenderer bone21;
	private final ModelRenderer bone22;
	private final ModelRenderer bone23;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;
	private final ModelRenderer bone14;
	private final ModelRenderer bone16;
	private final ModelRenderer bone17;
	private final ModelRenderer bone18;
	private final ModelRenderer bone19;
	private final ModelRenderer bone24;
	private final ModelRenderer bone27;
	private final ModelRenderer bone25;
	private final ModelRenderer bone26;

	public ModelNewSclerosianBrute() {
		textureWidth = 256;
		textureHeight = 256;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-9.0F, -6.0F, 5.0F);
		bone.setTextureOffset(148, 0).addBox(-2.0F, 26.0F, -11.0F, 8.0F, 3.0F, 13.0F, 1.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(7.0F, 29.0F, -5.0F);
		bone.addChild(bone2);
		bone2.setTextureOffset(153, 27).addBox(-9.0F, -4.0F, -1.0F, 8.0F, 1.0F, 8.0F, 1.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(2.0F, 0.0F, -1.0F);
		bone.addChild(bone5);
		bone5.setTextureOffset(116, 158).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 25.0F, 8.0F, 1.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(7.0F, -7.0F, 5.0F);
		bone3.setTextureOffset(139, 112).addBox(-4.0F, 27.0F, -11.0F, 8.0F, 3.0F, 13.0F, 1.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(5.0F, 30.0F, -5.0F);
		bone3.addChild(bone4);
		bone4.setTextureOffset(152, 42).addBox(-9.0F, -4.0F, -1.0F, 8.0F, 1.0F, 8.0F, 1.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(5.0F, 11.0F, -5.0F);
		bone3.addChild(bone6);
		bone6.setTextureOffset(84, 158).addBox(-9.0F, -10.0F, 0.0F, 8.0F, 25.0F, 8.0F, 1.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone7.setTextureOffset(88, 45).addBox(-12.0F, -40.0F, -4.0F, 25.0F, 9.0F, 14.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone8.setTextureOffset(0, 59).addBox(-15.0F, -77.0F, -7.0F, 29.0F, 37.0F, 22.0F, 0.0F, false);
		bone8.setTextureOffset(0, 0).addBox(-15.0F, -77.0F, -7.0F, 29.0F, 37.0F, 22.0F, 1.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(16.0F, -53.0F, 6.0F);
		bone9.setTextureOffset(0, 118).addBox(-2.0F, 0.0F, -6.0F, 20.0F, 4.0F, 11.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(-16.0F, 77.0F, -6.0F);
		bone9.addChild(bone10);
		bone10.setTextureOffset(0, 133).addBox(18.0F, -73.0F, 0.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(23.0F, -57.0F, 5.0F);
		bone10.addChild(bone11);
		setRotationAngle(bone11, -0.6109F, 0.0F, 0.0F);
		bone11.setTextureOffset(52, 124).addBox(-5.0F, 0.0F, -5.0F, 10.0F, 25.0F, 10.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(-23.0F, 56.0F, -5.0F);
		bone11.addChild(bone15);
		bone15.setTextureOffset(80, 0).addBox(19.0F, -32.0F, 1.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(0.0F, 1.0F, 0.0F);
		bone15.addChild(bone20);
		bone20.setTextureOffset(8, 8).addBox(25.0F, -29.0F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(0.0F, 1.0F, -3.0F);
		bone15.addChild(bone21);
		bone21.setTextureOffset(0, 6).addBox(25.0F, -29.0F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(0.0F, 1.0F, -6.0F);
		bone15.addChild(bone22);
		bone22.setTextureOffset(0, 0).addBox(25.0F, -29.0F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		bone23 = new ModelRenderer(this);
		bone23.setRotationPoint(1.0F, 0.1808F, -0.5736F);
		bone15.addChild(bone23);
		bone23.setTextureOffset(64, 80).addBox(19.0F, -29.0F, -27.0F, 6.0F, 6.0F, 38.0F, 3.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(-11.0F, -49.0F, 7.0F);
		bone12.setTextureOffset(102, 27).addBox(-24.0F, -4.0F, -7.0F, 20.0F, 4.0F, 11.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(-38.0F, 73.0F, -7.0F);
		bone12.addChild(bone13);
		bone13.setTextureOffset(132, 132).addBox(18.0F, -73.0F, 0.0F, 10.0F, 16.0F, 10.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(22.0F, -58.0F, 7.0F);
		bone13.addChild(bone14);
		setRotationAngle(bone14, -0.5236F, 0.0F, 0.0F);
		bone14.setTextureOffset(92, 124).addBox(-4.0F, 1.0F, -7.0F, 10.0F, 24.0F, 10.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(-22.0F, 57.0F, -7.0F);
		bone14.addChild(bone16);
		bone16.setTextureOffset(80, 68).addBox(19.0F, -32.0F, 1.0F, 8.0F, 4.0F, 8.0F, 0.0F, false);

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(0.0F, 1.0F, 0.0F);
		bone16.addChild(bone17);
		bone17.setTextureOffset(8, 14).addBox(19.0F, -29.0F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(0.0F, 1.0F, -3.0F);
		bone16.addChild(bone18);
		bone18.setTextureOffset(0, 12).addBox(19.0F, -29.0F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(0.0F, 1.0F, -6.0F);
		bone16.addChild(bone19);
		bone19.setTextureOffset(8, 0).addBox(19.0F, -29.0F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(0.0F, -54.0F, 3.0F);
		bone24.setTextureOffset(114, 90).addBox(-8.0F, -9.0F, -8.0F, 15.0F, 6.0F, 16.0F, 0.0F, false);

		bone27 = new ModelRenderer(this);
		bone27.setRotationPoint(-2.0F, -10.0F, 8.0F);
		bone24.addChild(bone27);
		bone27.setTextureOffset(114, 68).addBox(-6.0F, 1.0F, -17.0F, 15.0F, 6.0F, 16.0F, 1.0F, false);

		bone25 = new ModelRenderer(this);
		bone25.setRotationPoint(0.0F, 62.0F, -3.0F);
		bone24.addChild(bone25);
		bone25.setTextureOffset(102, 0).addBox(-8.0F, -82.0F, -5.0F, 15.0F, 11.0F, 16.0F, 0.0F, false);

		bone26 = new ModelRenderer(this);
		bone26.setRotationPoint(0.0F, 68.0F, -3.0F);
		bone24.addChild(bone26);
		bone26.setTextureOffset(34, 153).addBox(-3.0F, -71.0F, 1.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		bone3.render(matrixStack, buffer, packedLight, packedOverlay);
		bone7.render(matrixStack, buffer, packedLight, packedOverlay);
		bone8.render(matrixStack, buffer, packedLight, packedOverlay);
		bone9.render(matrixStack, buffer, packedLight, packedOverlay);
		bone12.render(matrixStack, buffer, packedLight, packedOverlay);
		bone24.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.bone24.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.bone24.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.bone.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.bone9.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.bone12.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.bone3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}