// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelNanosianWinged extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer bone9;
	private final ModelRenderer bone19;
	private final ModelRenderer bone13;
	private final ModelRenderer bone8;
	private final ModelRenderer bone10;
	private final ModelRenderer bone18;
	private final ModelRenderer bone12;
	private final ModelRenderer bone11;
	private final ModelRenderer bone14;
	private final ModelRenderer bone15;
	private final ModelRenderer bone20;
	private final ModelRenderer bone17;
	private final ModelRenderer bone16;

	public ModelNanosianWinged() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-2.0F, 9.0F, 1.0F);
		bone.setTextureOffset(0, 34).addBox(-3.0F, 13.0F, -5.0F, 4.0F, 2.0F, 7.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(2.0F, 15.0F, 0.0F);
		bone.addChild(bone2);
		bone2.setTextureOffset(30, 39).addBox(-4.0F, -16.0F, -2.0F, 2.0F, 14.0F, 2.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(4.0F, 8.0F, 1.0F);
		bone3.setTextureOffset(21, 30).addBox(-3.0F, 14.0F, -5.0F, 4.0F, 2.0F, 7.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(-2.0F, 16.0F, 0.0F);
		bone3.addChild(bone4);
		bone4.setTextureOffset(22, 39).addBox(0.0F, -16.0F, -2.0F, 2.0F, 14.0F, 2.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone5.setTextureOffset(38, 38).addBox(-2.0F, -16.0F, -2.0F, 4.0F, 3.0F, 5.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(2.0F, 0.0F, 0.0F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, 0.0F, 3.1416F, 0.0F);
		bone6.setTextureOffset(0, 0).addBox(-2.0F, -25.0F, -2.0F, 8.0F, 9.0F, 5.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(5.0F, 0.0F, 0.0F);
		bone7.setTextureOffset(38, 4).addBox(-1.0F, -1.0F, -3.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(-5.0F, 24.0F, 0.0F);
		bone7.addChild(bone9);
		bone9.setTextureOffset(38, 46).addBox(5.0F, -23.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		bone19 = new ModelRenderer(this);
		bone19.setRotationPoint(2.0F, 6.0F, 0.0F);
		bone7.addChild(bone19);
		setRotationAngle(bone19, -0.4363F, 0.0F, 0.0F);
		bone19.setTextureOffset(0, 43).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(-6.0F, 18.0F, 0.0F);
		bone19.addChild(bone13);
		bone13.setTextureOffset(0, 14).addBox(5.0F, -13.0F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(-5.0F, 0.0F, 0.1667F);
		bone8.setTextureOffset(36, 30).addBox(-3.0F, -1.0F, -2.1667F, 4.0F, 2.0F, 5.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(7.0F, 24.0F, -0.1667F);
		bone8.addChild(bone10);
		bone10.setTextureOffset(45, 11).addBox(-9.0F, -23.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(0.0F, 6.0F, -0.1667F);
		bone8.addChild(bone18);
		setRotationAngle(bone18, -0.4363F, 0.0F, 0.0F);
		bone18.setTextureOffset(8, 43).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(-7.0F, 18.0F, 0.0F);
		bone18.addChild(bone12);
		bone12.setTextureOffset(0, 34).addBox(5.0F, -13.0F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(2.0F, 24.0F, 0.0F);
		setRotationAngle(bone11, 0.0F, 3.1416F, 0.0F);
		bone11.setTextureOffset(19, 7).addBox(-1.0F, -31.0F, -3.0F, 6.0F, 6.0F, 7.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, -6.0F, 0.0F);
		bone11.addChild(bone14);
		setRotationAngle(bone14, 0.2618F, 0.0F, 0.0F);
		bone14.setTextureOffset(0, 14).addBox(-1.0F, -28.1469F, 3.0754F, 6.0F, 6.0F, 7.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(-1.0F, 0.0F, -2.0F);
		setRotationAngle(bone15, 0.0F, 0.0F, 0.5236F);
		bone15.setTextureOffset(0, 30).addBox(-12.866F, -0.5F, 4.1F, 13.0F, 3.0F, 1.0F, 0.0F, false);

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(-1.0F, 4.0F, -2.0F);
		setRotationAngle(bone20, 0.0F, 0.0F, -0.5236F);
		bone20.setTextureOffset(21, 0).addBox(-12.866F, -1.5F, 4.0F, 13.0F, 3.0F, 1.0F, 0.0F, false);

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(4.0F, 5.0F, -2.0F);
		setRotationAngle(bone17, 0.0F, 0.0F, 0.5236F);
		bone17.setTextureOffset(25, 26).addBox(-1.866F, -1.5F, 4.0F, 13.0F, 3.0F, 1.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(5.0F, 1.0F, 4.0F);
		setRotationAngle(bone16, 0.0F, 0.0F, -0.5236F);
		bone16.setTextureOffset(26, 20).addBox(-1.866F, -2.5F, -2.0F, 13.0F, 3.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		bone3.render(matrixStack, buffer, packedLight, packedOverlay);
		bone5.render(matrixStack, buffer, packedLight, packedOverlay);
		bone7.render(matrixStack, buffer, packedLight, packedOverlay);
		bone8.render(matrixStack, buffer, packedLight, packedOverlay);
		bone11.render(matrixStack, buffer, packedLight, packedOverlay);
		bone15.render(matrixStack, buffer, packedLight, packedOverlay);
		bone20.render(matrixStack, buffer, packedLight, packedOverlay);
		bone17.render(matrixStack, buffer, packedLight, packedOverlay);
		bone16.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.bone.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.bone7.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.bone8.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.bone3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}