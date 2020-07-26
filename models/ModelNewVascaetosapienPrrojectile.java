// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelNewVascaetosapienPrrojectile extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer tentacleWest;
	private final ModelRenderer tentacleEast;
	private final ModelRenderer tentacleSouth;
	private final ModelRenderer tentacleNorth;

	public ModelNewVascaetosapienPrrojectile() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -8.0F, 0.0F);
		setRotationAngle(bone, 0.0F, 0.0F, -3.1416F);
		bone.setTextureOffset(0, 0).addBox(-2.0F, -14.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(0, 29).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -15.0F, 0.0F);
		bone.addChild(bone2);
		bone2.setTextureOffset(36, 36).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 1.0F, 12.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 8.0F, 1.0F);
		bone2.addChild(bone3);
		bone3.setTextureOffset(0, 0).addBox(-8.0F, -21.0F, -9.0F, 16.0F, 13.0F, 16.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.0F, -5.0F, 1.0F);
		bone2.addChild(bone4);
		bone4.setTextureOffset(0, 29).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 2.0F, 12.0F, 0.0F, false);

		tentacleWest = new ModelRenderer(this);
		tentacleWest.setRotationPoint(7.0F, -15.0F, 1.0F);
		bone.addChild(tentacleWest);
		setRotationAngle(tentacleWest, 0.0F, 0.0F, -2.1817F);
		tentacleWest.setTextureOffset(26, 36).addBox(0.0F, 0.0F, -7.0F, 0.0F, 13.0F, 13.0F, 0.0F, false);

		tentacleEast = new ModelRenderer(this);
		tentacleEast.setRotationPoint(-6.0F, -15.0F, 0.0F);
		bone.addChild(tentacleEast);
		setRotationAngle(tentacleEast, 0.0F, 0.0F, 1.9199F);
		tentacleEast.setTextureOffset(0, 30).addBox(-1.0F, 0.0F, -6.0F, 0.0F, 13.0F, 13.0F, 0.0F, false);

		tentacleSouth = new ModelRenderer(this);
		tentacleSouth.setRotationPoint(0.0F, -14.0F, 7.0F);
		bone.addChild(tentacleSouth);
		setRotationAngle(tentacleSouth, 2.0944F, 0.0F, 0.0F);
		tentacleSouth.setTextureOffset(48, 0).addBox(-7.0F, -1.0F, 0.0F, 14.0F, 13.0F, 0.0F, 0.0F, false);

		tentacleNorth = new ModelRenderer(this);
		tentacleNorth.setRotationPoint(0.0F, -14.0F, -7.0F);
		bone.addChild(tentacleNorth);
		setRotationAngle(tentacleNorth, -2.1817F, 0.0F, 0.0F);
		tentacleNorth.setTextureOffset(52, 52).addBox(-7.0F, -1.0F, 0.0F, 14.0F, 13.0F, 0.0F, 0.0F, false);
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
		this.bone.rotateAngleY = f2;
	}
}