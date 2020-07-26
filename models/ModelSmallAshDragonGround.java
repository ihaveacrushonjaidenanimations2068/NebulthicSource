// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelSmallAshDragonGround extends EntityModel<Entity> {
	private final ModelRenderer legRight;
	private final ModelRenderer bone3;
	private final ModelRenderer bone5;
	private final ModelRenderer LegLeft;
	private final ModelRenderer bone4;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer wingLeft;
	private final ModelRenderer bone10;
	private final ModelRenderer bone14;
	private final ModelRenderer wingRight;
	private final ModelRenderer bone11;
	private final ModelRenderer bone13;
	private final ModelRenderer head;
	private final ModelRenderer bone15;
	private final ModelRenderer bone24;
	private final ModelRenderer bone16;
	private final ModelRenderer bone17;
	private final ModelRenderer bone18;
	private final ModelRenderer taill;
	private final ModelRenderer bone20;
	private final ModelRenderer bone21;
	private final ModelRenderer bone22;
	private final ModelRenderer Spine;

	public ModelSmallAshDragonGround() {
		textureWidth = 128;
		textureHeight = 128;

		legRight = new ModelRenderer(this);
		legRight.setRotationPoint(-4.0F, -4.0F, 1.0F);
		legRight.setTextureOffset(24, 71).addBox(-2.0F, 27.0F, -6.0F, 4.0F, 1.0F, 8.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 27.0F, 0.0F);
		legRight.addChild(bone3);
		setRotationAngle(bone3, 0.3491F, 0.0F, 0.0F);
		bone3.setTextureOffset(32, 80).addBox(-1.0F, -15.316F, -0.1206F, 2.0F, 16.0F, 2.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 12.0F, -6.0F);
		legRight.addChild(bone5);
		setRotationAngle(bone5, -0.4363F, 0.0F, 0.0F);
		bone5.setTextureOffset(56, 73).addBox(-1.0F, -15.6858F, 0.8618F, 2.0F, 16.0F, 2.0F, 0.0F, false);

		LegLeft = new ModelRenderer(this);
		LegLeft.setRotationPoint(4.0F, -4.0F, 2.0F);
		LegLeft.setTextureOffset(61, 61).addBox(-2.0F, 27.0F, -7.0F, 4.0F, 1.0F, 8.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 27.0F, -2.0F);
		LegLeft.addChild(bone4);
		setRotationAngle(bone4, 0.3491F, 0.0F, 0.0F);
		bone4.setTextureOffset(24, 80).addBox(-1.0F, -14.9739F, 0.8191F, 2.0F, 16.0F, 2.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(0.0F, 12.0F, -7.0F);
		LegLeft.addChild(bone6);
		setRotationAngle(bone6, -0.4363F, 0.0F, 0.0F);
		bone6.setTextureOffset(48, 73).addBox(-1.0F, -15.6858F, 0.8618F, 2.0F, 16.0F, 2.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone7.setTextureOffset(0, 33).addBox(-5.0F, -48.0F, -3.0F, 10.0F, 19.0F, 9.0F, 0.0F, false);

		wingLeft = new ModelRenderer(this);
		wingLeft.setRotationPoint(6.0F, -22.0F, 0.0F);
		setRotationAngle(wingLeft, 0.0F, 0.0F, 0.7854F);
		wingLeft.setTextureOffset(38, 50).addBox(-2.0F, -1.0F, 0.0F, 24.0F, 2.0F, 2.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(-6.0F, 46.0F, 0.0F);
		wingLeft.addChild(bone10);
		bone10.setTextureOffset(31, 0).addBox(5.0F, -46.0F, 2.0F, 23.0F, 0.0F, 8.0F, 0.0F, false);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(0.0F, 0.0F, 1.0F);
		wingLeft.addChild(bone14);
		bone14.setTextureOffset(52, 20).addBox(21.9203F, -1.2929F, -1.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

		wingRight = new ModelRenderer(this);
		wingRight.setRotationPoint(-6.0F, -22.0F, 1.0F);
		setRotationAngle(wingRight, 0.0F, 0.0F, -0.7854F);
		wingRight.setTextureOffset(39, 8).addBox(-22.0F, -1.0F, -1.0F, 24.0F, 2.0F, 2.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(-27.0F, 46.0F, -1.0F);
		wingRight.addChild(bone11);
		bone11.setTextureOffset(0, 25).addBox(5.0F, -46.0F, 2.0F, 23.0F, 0.0F, 8.0F, 0.0F, false);

		bone13 = new ModelRenderer(this);
		bone13.setRotationPoint(0.0F, 0.0F, 0.0F);
		wingRight.addChild(bone13);
		bone13.setTextureOffset(61, 54).addBox(-29.9203F, -1.2929F, -1.0F, 8.0F, 2.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -24.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-7.0F, -12.0F, -8.0F, 13.0F, 12.0F, 13.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(0.0F, -1.0F, -8.0F);
		head.addChild(bone15);
		setRotationAngle(bone15, 0.5236F, 0.0F, 0.0F);
		bone15.setTextureOffset(45, 24).addBox(-7.0F, -2.0F, -9.0F, 13.0F, 3.0F, 9.0F, 0.0F, false);

		bone24 = new ModelRenderer(this);
		bone24.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone15.addChild(bone24);
		bone24.setTextureOffset(52, 12).addBox(-6.0F, -4.0F, -7.0F, 11.0F, 2.0F, 6.0F, 0.0F, false);

		bone16 = new ModelRenderer(this);
		bone16.setRotationPoint(0.0F, -3.0F, 0.0F);
		head.addChild(bone16);
		bone16.setTextureOffset(38, 38).addBox(-7.0F, -3.0F, -17.0F, 13.0F, 3.0F, 9.0F, 0.0F, false);

		bone17 = new ModelRenderer(this);
		bone17.setRotationPoint(0.0F, -5.0F, 4.0F);
		head.addChild(bone17);
		setRotationAngle(bone17, -0.6109F, 0.0F, 0.0F);
		bone17.setTextureOffset(70, 70).addBox(6.0F, -14.0F, -9.0F, 1.0F, 14.0F, 6.0F, 0.0F, false);

		bone18 = new ModelRenderer(this);
		bone18.setRotationPoint(-14.0F, -12.0F, -4.0F);
		head.addChild(bone18);
		setRotationAngle(bone18, -0.6109F, 0.0F, 0.0F);
		bone18.setTextureOffset(10, 69).addBox(6.0F, -10.5425F, 0.7207F, 1.0F, 14.0F, 6.0F, 0.0F, false);

		taill = new ModelRenderer(this);
		taill.setRotationPoint(0.0F, -4.0F, 7.0F);
		setRotationAngle(taill, -0.5236F, 0.0F, 0.0F);
		taill.setTextureOffset(42, 56).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 15.0F, 0.0F, false);

		bone20 = new ModelRenderer(this);
		bone20.setRotationPoint(0.0F, 28.0F, -6.0F);
		taill.addChild(bone20);
		bone20.setTextureOffset(0, 50).addBox(0.0F, -34.0F, 5.0F, 0.0F, 4.0F, 15.0F, 0.0F, false);

		bone21 = new ModelRenderer(this);
		bone21.setRotationPoint(7.0F, -7.0F, 29.0F);
		taill.addChild(bone21);
		bone21.setTextureOffset(23, 54).addBox(-8.0F, 5.0F, -15.0F, 2.0F, 2.0F, 15.0F, 0.0F, false);

		bone22 = new ModelRenderer(this);
		bone22.setRotationPoint(-7.0F, 6.0F, -14.0F);
		bone21.addChild(bone22);
		bone22.setTextureOffset(0, 46).addBox(0.0F, -5.0F, -1.0F, 0.0F, 4.0F, 15.0F, 0.0F, false);

		Spine = new ModelRenderer(this);
		Spine.setRotationPoint(0.0F, 24.0F, 0.0F);
		Spine.setTextureOffset(0, 64).addBox(0.0F, -48.0F, 6.0F, 0.0F, 19.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		legRight.render(matrixStack, buffer, packedLight, packedOverlay);
		LegLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		bone7.render(matrixStack, buffer, packedLight, packedOverlay);
		wingLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		wingRight.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		taill.render(matrixStack, buffer, packedLight, packedOverlay);
		Spine.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.wingRight.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.legRight.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.wingLeft.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.LegLeft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}