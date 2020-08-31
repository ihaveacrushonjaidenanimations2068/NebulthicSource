// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelStarswimmerConstruct extends EntityModel<Entity> {
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone16;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone12;
	private final ModelRenderer bone13;
	private final ModelRenderer bone14;
	private final ModelRenderer bone15;

	public ModelStarswimmerConstruct() {
		textureWidth = 512;
		textureHeight = 512;

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone5.setTextureOffset(0, 86).addBox(-34.0F, -6.0F, -13.0F, 67.0F, 1.0F, 84.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone5.addChild(bone6);
		bone6.setTextureOffset(158, 370).addBox(-34.0F, -31.0F, -15.0F, 67.0F, 26.0F, 1.0F, 0.0F, false);
		bone6.setTextureOffset(310, 0).addBox(-34.0F, -57.0F, 63.0F, 66.0F, 51.0F, 8.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone5.addChild(bone7);
		bone7.setTextureOffset(310, 59).addBox(-34.0F, -57.0F, -15.0F, 67.0F, 26.0F, 1.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone5.addChild(bone8);
		bone8.setTextureOffset(0, 286).addBox(33.0F, -57.0F, -15.0F, 1.0F, 51.0F, 78.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(-25.0F, 0.0F, 0.0F);
		bone5.addChild(bone9);
		bone9.setTextureOffset(229, 7).addBox(-10.0F, -57.0F, -14.0F, 1.0F, 51.0F, 79.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(6.5F, -12.5F, -23.5F);
		setRotationAngle(bone10, 0.0F, -0.7854F, 0.0F);
		bone10.setTextureOffset(292, 137).addBox(-22.5F, -11.5F, -14.5F, 45.0F, 23.0F, 45.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, -8.0F, 0.0F);
		bone11.setTextureOffset(0, 0).addBox(-34.0F, -26.0F, -14.0F, 69.0F, 1.0F, 85.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(-0.5F, -24.0F, 1.0F);
		bone11.addChild(bone16);
		setRotationAngle(bone16, -0.5236F, 0.0F, 0.0F);
		bone16.setTextureOffset(318, 336).addBox(-5.5F, -79.0F, -2.0F, 11.0F, 79.0F, 30.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(11.5F, 6.5F, -7.0F);
		bone.setTextureOffset(292, 205).addBox(22.5F, -2.5F, -3.0F, 66.0F, 3.0F, 29.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-37.5F, 6.5F, -7.0F);
		bone2.setTextureOffset(80, 304).addBox(-59.5F, -2.5F, -3.0F, 62.0F, 3.0F, 29.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone3.setTextureOffset(150, 188).addBox(-9.0F, -25.0F, -107.0F, 22.0F, 18.0F, 98.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone4.setTextureOffset(0, 171).addBox(-16.0F, -32.0F, 70.0F, 29.0F, 20.0F, 95.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(-0.5F, -21.0F, 52.0F);
		bone4.addChild(bone12);
		setRotationAngle(bone12, -0.5236F, 0.0F, 0.0F);
		bone12.setTextureOffset(0, 0).addBox(-0.5F, -96.7942F, 51.3179F, 1.0F, 51.0F, 17.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone13);
		bone13.setTextureOffset(292, 237).addBox(-56.0F, -17.0F, 105.0F, 52.0F, 1.0F, 37.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone4.addChild(bone14);
		bone14.setTextureOffset(158, 336).addBox(4.0F, -17.0F, 108.0F, 47.0F, 1.0F, 33.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone15.setTextureOffset(262, 304).addBox(-34.0F, -18.0F, -11.0F, 69.0F, 12.0F, 20.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone5.render(matrixStack, buffer, packedLight, packedOverlay);
		bone10.render(matrixStack, buffer, packedLight, packedOverlay);
		bone11.render(matrixStack, buffer, packedLight, packedOverlay);
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		bone2.render(matrixStack, buffer, packedLight, packedOverlay);
		bone3.render(matrixStack, buffer, packedLight, packedOverlay);
		bone4.render(matrixStack, buffer, packedLight, packedOverlay);
		bone15.render(matrixStack, buffer, packedLight, packedOverlay);
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