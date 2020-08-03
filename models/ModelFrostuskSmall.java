// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelFrostuskSmall extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer frontLeftLeg;
	private final ModelRenderer bone2;
	private final ModelRenderer frontRightLeg;
	private final ModelRenderer bone3;
	private final ModelRenderer backRightLeg;
	private final ModelRenderer bone6;
	private final ModelRenderer backLeftLeg;
	private final ModelRenderer bone7;
	private final ModelRenderer head;
	private final ModelRenderer bone4;
	private final ModelRenderer bone8;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone12;
	private final ModelRenderer spine;
	private final ModelRenderer bone5;
	private final ModelRenderer bone11;

	public ModelFrostuskSmall() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-2.0F, -5.0F, -5.0F, 4.0F, 3.0F, 10.0F, 0.0F, false);

		frontLeftLeg = new ModelRenderer(this);
		frontLeftLeg.setRotationPoint(2.4F, 21.5F, -3.6F);
		frontLeftLeg.setTextureOffset(4, 15).addBox(-0.4F, -0.5F, -0.4F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-2.4F, 2.5F, 3.6F);
		frontLeftLeg.addChild(bone2);
		bone2.setTextureOffset(6, 4).addBox(2.0F, 0.0F, -5.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		frontRightLeg = new ModelRenderer(this);
		frontRightLeg.setRotationPoint(-2.2F, 21.6F, -3.5F);
		frontRightLeg.setTextureOffset(0, 15).addBox(-0.8F, -0.6F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-2.8F, 2.4F, 3.5F);
		frontRightLeg.addChild(bone3);
		bone3.setTextureOffset(5, 1).addBox(2.0F, 0.0F, -5.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		backRightLeg = new ModelRenderer(this);
		backRightLeg.setRotationPoint(-2.2F, 21.7F, 3.3F);
		backRightLeg.setTextureOffset(4, 4).addBox(-0.8F, -0.7F, -0.3F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-2.8F, 2.3F, 3.7F);
		backRightLeg.addChild(bone6);
		bone6.setTextureOffset(5, 0).addBox(2.0F, 0.0F, -5.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		backLeftLeg = new ModelRenderer(this);
		backLeftLeg.setRotationPoint(2.5F, 21.5F, 3.5F);
		backLeftLeg.setTextureOffset(0, 4).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(-2.5F, 2.5F, 3.5F);
		backLeftLeg.addChild(bone7);
		bone7.setTextureOffset(2, 4).addBox(2.0F, 0.0F, -5.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.setTextureOffset(14, 23).addBox(-2.0F, -6.0F, -9.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(bone4);
		bone4.setTextureOffset(0, 15).addBox(-3.0F, -4.0F, -13.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(3.0F, 0.0F, 0.0F);
		head.addChild(bone8);
		bone8.setTextureOffset(10, 13).addBox(-1.0F, -4.0F, -13.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(bone9);
		bone9.setTextureOffset(20, 13).addBox(-2.0F, -7.0F, -9.0F, 4.0F, 2.0F, 5.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(bone10);
		bone10.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -11.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		bone12 = new ModelRenderer(this);
		bone12.setRotationPoint(0.0F, -3.0F, 0.0F);
		head.addChild(bone12);
		bone12.setTextureOffset(26, 0).addBox(-2.0F, -2.0F, -11.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);

		spine = new ModelRenderer(this);
		spine.setRotationPoint(0.0F, 24.0F, 0.0F);
		spine.setTextureOffset(0, 4).addBox(0.0F, -7.0F, -4.0F, 0.0F, 2.0F, 9.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone5.setTextureOffset(0, 25).addBox(-1.0F, -4.0F, 5.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);
		bone5.setTextureOffset(22, 5).addBox(-1.0F, -4.0F, 9.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone5.addChild(bone11);
		bone11.setTextureOffset(9, 0).addBox(-2.0F, -3.6F, 5.0F, 4.0F, 0.0F, 9.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		frontLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		frontRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		backRightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		backLeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		spine.render(matrixStack, buffer, packedLight, packedOverlay);
		bone5.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.frontRightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.backRightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.frontLeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.backLeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}