// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelAutomaton extends EntityModel<Entity> {
	private final ModelRenderer waist;
	private final ModelRenderer spine;
	private final ModelRenderer legLeft;
	private final ModelRenderer legRight4;
	private final ModelRenderer legRight;
	private final ModelRenderer legRight2;
	private final ModelRenderer powerCore;
	private final ModelRenderer chest1;
	private final ModelRenderer chest2;
	private final ModelRenderer hatch;
	private final ModelRenderer hatch2;
	private final ModelRenderer batteryPack;
	private final ModelRenderer headBase;
	private final ModelRenderer shoulderRight;
	private final ModelRenderer bone;
	private final ModelRenderer shoulderRight2;
	private final ModelRenderer bone2;

	public ModelAutomaton() {
		textureWidth = 128;
		textureHeight = 128;

		waist = new ModelRenderer(this);
		waist.setRotationPoint(0.0F, 24.0F, 0.0F);
		waist.setTextureOffset(0, 29).addBox(-9.0F, -37.0F, -4.0F, 18.0F, 6.0F, 9.0F, 0.0F, false);

		spine = new ModelRenderer(this);
		spine.setRotationPoint(0.0F, -38.0F, 4.0F);
		waist.addChild(spine);
		spine.setTextureOffset(58, 88).addBox(-2.0F, -13.0F, 0.0F, 4.0F, 14.0F, 1.0F, 0.0F, false);

		legLeft = new ModelRenderer(this);
		legLeft.setRotationPoint(-5.0F, -31.0F, 0.0F);
		waist.addChild(legLeft);
		legLeft.setTextureOffset(59, 66).addBox(-3.0F, 16.0F, -3.0F, 7.0F, 15.0F, 7.0F, 0.0F, false);

		legRight4 = new ModelRenderer(this);
		legRight4.setRotationPoint(-4.0F, 15.0F, 0.0F);
		legLeft.addChild(legRight4);
		legRight4.setTextureOffset(54, 0).addBox(1.0F, -15.0F, -3.0F, 7.0F, 16.0F, 7.0F, 0.0F, false);

		legRight = new ModelRenderer(this);
		legRight.setRotationPoint(5.0F, -32.0F, 0.0F);
		waist.addChild(legRight);
		legRight.setTextureOffset(0, 68).addBox(-4.0F, 17.0F, -3.0F, 7.0F, 15.0F, 7.0F, 0.0F, false);

		legRight2 = new ModelRenderer(this);
		legRight2.setRotationPoint(-5.0F, 16.0F, 0.0F);
		legRight.addChild(legRight2);
		legRight2.setTextureOffset(31, 66).addBox(1.0F, -15.0F, -3.0F, 7.0F, 16.0F, 7.0F, 0.0F, false);

		powerCore = new ModelRenderer(this);
		powerCore.setRotationPoint(0.0F, 24.0F, 0.0F);
		powerCore.setTextureOffset(26, 44).addBox(-2.4F, -49.0F, -1.0F, 5.0F, 5.0F, 5.0F, 0.0F, false);

		chest1 = new ModelRenderer(this);
		chest1.setRotationPoint(0.0F, 0.0F, 0.0F);
		powerCore.addChild(chest1);
		chest1.setTextureOffset(0, 44).addBox(-9.0F, -51.0F, -7.0F, 7.0F, 12.0F, 12.0F, 0.0F, false);

		chest2 = new ModelRenderer(this);
		chest2.setRotationPoint(11.0F, 0.0F, 0.0F);
		powerCore.addChild(chest2);
		chest2.setTextureOffset(42, 42).addBox(-9.0F, -51.0F, -7.0F, 7.0F, 12.0F, 12.0F, 0.0F, false);

		hatch = new ModelRenderer(this);
		hatch.setRotationPoint(0.0F, 0.0F, 0.0F);
		powerCore.addChild(hatch);
		hatch.setTextureOffset(45, 23).addBox(-3.0F, -51.0F, -7.0F, 6.0F, 1.0F, 12.0F, 0.0F, false);

		hatch2 = new ModelRenderer(this);
		hatch2.setRotationPoint(0.0F, 0.0F, 0.0F);
		hatch.addChild(hatch2);
		hatch2.setTextureOffset(87, 64).addBox(-3.0F, -51.0F, -8.0F, 6.0F, 12.0F, 1.0F, 0.0F, false);

		batteryPack = new ModelRenderer(this);
		batteryPack.setRotationPoint(0.0F, 0.0F, 0.0F);
		powerCore.addChild(batteryPack);
		batteryPack.setTextureOffset(0, 0).addBox(-9.0F, -51.0F, 5.0F, 18.0F, 20.0F, 9.0F, 0.0F, false);

		headBase = new ModelRenderer(this);
		headBase.setRotationPoint(0.0F, -26.0F, -1.0F);
		headBase.setTextureOffset(68, 36).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		shoulderRight = new ModelRenderer(this);
		shoulderRight.setRotationPoint(9.0F, -25.0F, -1.0F);
		shoulderRight.setTextureOffset(80, 52).addBox(0.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(1.0F, -2.0F, 0.0F);
		shoulderRight.addChild(bone);
		bone.setTextureOffset(82, 0).addBox(0.0F, 5.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);

		shoulderRight2 = new ModelRenderer(this);
		shoulderRight2.setRotationPoint(-12.0F, -25.0F, 0.0F);
		shoulderRight2.setTextureOffset(69, 23).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(2.0F, -2.0F, -1.0F);
		shoulderRight2.addChild(bone2);
		bone2.setTextureOffset(83, 84).addBox(-4.0F, 5.0F, -2.0F, 4.0F, 13.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		waist.render(matrixStack, buffer, packedLight, packedOverlay);
		powerCore.render(matrixStack, buffer, packedLight, packedOverlay);
		headBase.render(matrixStack, buffer, packedLight, packedOverlay);
		shoulderRight.render(matrixStack, buffer, packedLight, packedOverlay);
		shoulderRight2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.legRight.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.headBase.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.headBase.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.shoulderRight.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.shoulderRight2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.legLeft.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}