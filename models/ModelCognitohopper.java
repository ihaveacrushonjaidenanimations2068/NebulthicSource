// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelCognitohopper extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone4;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer legLeft;
	private final ModelRenderer legLeft2;
	private final ModelRenderer legLeft3;
	private final ModelRenderer legLeft4;
	private final ModelRenderer legLeft5;
	private final ModelRenderer legLeft6;
	private final ModelRenderer legLeft7;
	private final ModelRenderer legLeft8;
	private final ModelRenderer legLeft9;
	private final ModelRenderer legLeft10;
	private final ModelRenderer legLeft11;
	private final ModelRenderer legLeft12;

	public ModelCognitohopper() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(1.5F, 10.5F, 6.0F);
		setRotationAngle(bone, -0.6981F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-8.5F, -23.6148F, -17.9572F, 16.0F, 17.0F, 32.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(-1.0F, -13.433F, -6.073F);
		bone.addChild(bone4);
		setRotationAngle(bone4, 0.6545F, 0.0F, 0.0F);
		bone4.setTextureOffset(0, 49).addBox(-8.5F, -15.1922F, -31.2769F, 18.0F, 17.0F, 27.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(bone2);
		bone2.setTextureOffset(62, 62).addBox(0.0F, -33.2934F, -17.9413F, 0.0F, 9.0F, 31.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-0.5F, -19.8711F, -19.1976F);
		bone.addChild(bone3);
		setRotationAngle(bone3, 0.6981F, 0.0F, 0.0F);
		bone3.setTextureOffset(0, 62).addBox(0.5F, -9.3237F, -21.7116F, 0.0F, 11.0F, 31.0F, 0.0F, false);

		legLeft = new ModelRenderer(this);
		legLeft.setRotationPoint(10.5F, 8.25F, 14.25F);
		legLeft.setTextureOffset(96, 36).addBox(-4.5F, -2.25F, -1.25F, 6.0F, 3.0F, 3.0F, 0.0F, false);

		legLeft2 = new ModelRenderer(this);
		legLeft2.setRotationPoint(-1.5F, 4.2576F, -14.401F);
		legLeft.addChild(legLeft2);
		setRotationAngle(legLeft2, -1.0036F, 0.0F, 0.0F);
		legLeft2.setTextureOffset(96, 18).addBox(-2.0F, -17.6884F, 0.5309F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		legLeft3 = new ModelRenderer(this);
		legLeft3.setRotationPoint(1.0F, 11.4924F, -0.849F);
		legLeft2.addChild(legLeft3);
		setRotationAngle(legLeft3, 1.0036F, 0.0F, 0.0F);
		legLeft3.setTextureOffset(90, 67).addBox(-3.0F, -6.0F, 13.0F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		legLeft4 = new ModelRenderer(this);
		legLeft4.setRotationPoint(-7.5F, 7.25F, 15.25F);
		legLeft4.setTextureOffset(90, 85).addBox(-2.5F, -1.25F, -2.25F, 6.0F, 3.0F, 3.0F, 0.0F, false);

		legLeft5 = new ModelRenderer(this);
		legLeft5.setRotationPoint(0.5F, 5.2576F, -15.401F);
		legLeft4.addChild(legLeft5);
		setRotationAngle(legLeft5, -1.0036F, 0.0F, 0.0F);
		legLeft5.setTextureOffset(88, 0).addBox(-4.0F, -17.6884F, 0.5309F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		legLeft6 = new ModelRenderer(this);
		legLeft6.setRotationPoint(-1.0F, 11.4924F, -0.849F);
		legLeft5.addChild(legLeft6);
		setRotationAngle(legLeft6, 1.0036F, 0.0F, 0.0F);
		legLeft6.setTextureOffset(87, 49).addBox(-3.0F, -6.0F, 13.0F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		legLeft7 = new ModelRenderer(this);
		legLeft7.setRotationPoint(-7.5F, -4.75F, 3.25F);
		legLeft7.setTextureOffset(63, 67).addBox(-2.5F, -1.25F, -2.25F, 6.0F, 3.0F, 3.0F, 0.0F, false);

		legLeft8 = new ModelRenderer(this);
		legLeft8.setRotationPoint(0.5F, 5.2576F, -14.401F);
		legLeft7.addChild(legLeft8);
		setRotationAngle(legLeft8, -1.0036F, 0.0F, 0.0F);
		legLeft8.setTextureOffset(63, 49).addBox(-4.0F, -16.0016F, -0.5437F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		legLeft9 = new ModelRenderer(this);
		legLeft9.setRotationPoint(-1.0F, 11.4924F, -0.849F);
		legLeft8.addChild(legLeft9);
		setRotationAngle(legLeft9, 1.0036F, 0.0F, 0.0F);
		legLeft9.setTextureOffset(64, 0).addBox(-3.0F, -6.0F, 13.0F, 6.0F, 24.0F, 6.0F, 0.0F, false);

		legLeft10 = new ModelRenderer(this);
		legLeft10.setRotationPoint(10.5F, -6.25F, 1.25F);
		legLeft10.setTextureOffset(0, 67).addBox(-4.5F, 0.25F, -0.25F, 6.0F, 3.0F, 3.0F, 0.0F, false);

		legLeft11 = new ModelRenderer(this);
		legLeft11.setRotationPoint(-1.5F, 6.7576F, -12.401F);
		legLeft10.addChild(legLeft11);
		setRotationAngle(legLeft11, -1.0036F, 0.0F, 0.0F);
		legLeft11.setTextureOffset(0, 49).addBox(-2.0F, -16.0016F, -0.5437F, 6.0F, 12.0F, 6.0F, 0.0F, false);

		legLeft12 = new ModelRenderer(this);
		legLeft12.setRotationPoint(1.0F, 11.4924F, -0.849F);
		legLeft11.addChild(legLeft12);
		setRotationAngle(legLeft12, 1.0036F, 0.0F, 0.0F);
		legLeft12.setTextureOffset(0, 0).addBox(-3.0F, -6.0F, 13.0F, 6.0F, 24.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		legLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		legLeft4.render(matrixStack, buffer, packedLight, packedOverlay);
		legLeft7.render(matrixStack, buffer, packedLight, packedOverlay);
		legLeft10.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.legLeft4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.legLeft10.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.legLeft7.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.legLeft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}