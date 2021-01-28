// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelSymbicelium extends EntityModel<Entity> {
	private final ModelRenderer leftFrontLeg;
	private final ModelRenderer leftBackLeg;
	private final ModelRenderer rightBackLeg;
	private final ModelRenderer rightFrontLeg;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;
	private final ModelRenderer bone14;

	public ModelSymbicelium() {
		textureWidth = 64;
		textureHeight = 64;

		leftFrontLeg = new ModelRenderer(this);
		leftFrontLeg.setRotationPoint(7.0F, 16.0F, -7.0F);
		leftFrontLeg.setTextureOffset(22, 47).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		leftBackLeg = new ModelRenderer(this);
		leftBackLeg.setRotationPoint(5.0F, 16.0F, 5.0F);
		leftBackLeg.setTextureOffset(0, 46).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		rightBackLeg = new ModelRenderer(this);
		rightBackLeg.setRotationPoint(-5.0F, 16.0F, 5.0F);
		rightBackLeg.setTextureOffset(14, 45).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		rightFrontLeg = new ModelRenderer(this);
		rightFrontLeg.setRotationPoint(-7.0F, 16.0F, -7.0F);
		rightFrontLeg.setTextureOffset(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone5.setTextureOffset(0, 0).addBox(-6.0F, -19.0F, -6.0F, 12.0F, 11.0F, 12.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, -8.0F, -0.25F);
		bone5.addChild(bone6);
		bone6.setTextureOffset(0, 34).addBox(-2.0F, -4.0F, -2.75F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, -7.0F, -10.75F);
		bone6.addChild(bone7);
		bone7.setTextureOffset(44, 44).addBox(-2.0F, 8.0F, 4.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, -7.0F, -14.75F);
		bone6.addChild(bone8);
		bone8.setTextureOffset(28, 42).addBox(-2.0F, 8.0F, 4.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, -7.0F, -18.75F);
		bone6.addChild(bone9);
		bone9.setTextureOffset(40, 23).addBox(-2.0F, 8.0F, 4.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, -3.0F, 0.0F);
		bone9.addChild(bone10);
		bone10.setTextureOffset(16, 38).addBox(-2.0F, 8.0F, 4.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, -3.0F, 0.0F);
		bone10.addChild(bone11);
		bone11.setTextureOffset(36, 0).addBox(-2.0F, 8.0F, 4.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, -3.0F, 0.0F);
		bone11.addChild(bone12);
		bone12.setTextureOffset(24, 23).addBox(-2.0F, 8.0F, 4.0F, 4.0F, 3.0F, 4.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 0.0F, -4.0F);
		bone12.addChild(bone13);
		bone13.setTextureOffset(28, 30).addBox(-4.0F, 5.0F, 4.0F, 8.0F, 8.0F, 4.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, -11.0F, 0.0F);
		bone5.addChild(bone14);
		bone14.setTextureOffset(0, 23).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 3.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		leftFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		bone5.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.leftBackLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.bone6.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.bone6.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leftFrontLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.rightFrontLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightBackLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}