// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.12
// Paste this class into your mod and generate all required imports

public static class ModelHypotarantula extends ModelBase {
	private final ModelRenderer sac;
	private final ModelRenderer stinger;
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer jaw;
	private final ModelRenderer mandible2;
	private final ModelRenderer jaw2;
	private final ModelRenderer mandible;
	private final ModelRenderer leg1;
	private final ModelRenderer leg1Child;
	private final ModelRenderer leg2;
	private final ModelRenderer leg1Child2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg1Child3;
	private final ModelRenderer leg4;
	private final ModelRenderer leg1Child4;
	private final ModelRenderer leg1Child5;
	private final ModelRenderer leg5;
	private final ModelRenderer leg1Child6;
	private final ModelRenderer leg6;
	private final ModelRenderer leg1Child7;
	private final ModelRenderer leg7;
	private final ModelRenderer leg1Child8;
	private final ModelRenderer leg8;

	public ModelHypotarantula() {
		textureWidth = 128;
		textureHeight = 128;

		sac = new ModelRenderer(this);
		sac.setRotationPoint(0.0F, 14.0F, -9.0F);
		setRotationAngle(sac, 0.5236F, 0.0F, 0.0F);
		sac.cubeList.add(new ModelBox(sac, 0, 34, -8.0F, 4.3301F, 18.2846F, 16, 12, 17, 0.0F, false));

		stinger = new ModelRenderer(this);
		stinger.setRotationPoint(0.0F, 10.0F, 9.0F);
		sac.addChild(stinger);
		stinger.cubeList.add(new ModelBox(stinger, 0, 0, 0.0F, -0.2583F, 27.2846F, 0, 1, 5, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 13.0F, -29.0F);
		body.cubeList.add(new ModelBox(body, 0, 0, -5.0F, -2.0F, 18.0F, 11, 8, 26, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 48, 0, -3.0F, -16.0F, -20.0F, 8, 6, 9, 0.0F, false));

		jaw = new ModelRenderer(this);
		jaw.setRotationPoint(3.0F, -11.0F, -11.0F);
		head.addChild(jaw);
		setRotationAngle(jaw, 0.3491F, 0.0F, 0.0F);
		jaw.cubeList.add(new ModelBox(jaw, 0, 67, -2.0F, 1.0F, -9.0F, 4, 3, 10, 1.0F, false));

		mandible2 = new ModelRenderer(this);
		mandible2.setRotationPoint(6.0F, 17.0F, 5.0F);
		jaw.addChild(mandible2);
		mandible2.cubeList.add(new ModelBox(mandible2, 0, 6, -4.0F, -22.0F, -15.0F, 1, 5, 1, 0.0F, false));

		jaw2 = new ModelRenderer(this);
		jaw2.setRotationPoint(0.0F, -9.0F, -11.0F);
		head.addChild(jaw2);
		setRotationAngle(jaw2, 0.3491F, 0.0F, 0.0F);
		jaw2.cubeList.add(new ModelBox(jaw2, 66, 50, -3.0F, -1.0F, -9.0F, 4, 3, 10, 1.0F, false));

		mandible = new ModelRenderer(this);
		mandible.setRotationPoint(0.0F, 15.0F, 5.0F);
		jaw2.addChild(mandible);
		mandible.cubeList.add(new ModelBox(mandible, 4, 6, -4.0F, -22.0F, -15.0F, 1, 5, 1, 0.0F, false));

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(6.0F, 13.0F, -8.0F);
		leg1.cubeList.add(new ModelBox(leg1, 48, 71, 0.0F, -1.0F, -1.0F, 13, 2, 2, 0.0F, false));

		leg1Child = new ModelRenderer(this);
		leg1Child.setRotationPoint(12.6F, -1.2F, 0.0F);
		leg1.addChild(leg1Child);
		setRotationAngle(leg1Child, 0.0F, 0.0F, 0.7854F);
		leg1Child.cubeList.add(new ModelBox(leg1Child, 42, 63, 0.4037F, -0.1433F, -1.0F, 19, 2, 2, 0.0F, false));

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(5.0F, 13.0F, -5.0F);
		leg2.cubeList.add(new ModelBox(leg2, 18, 71, 1.0F, -1.0F, -1.0F, 13, 2, 2, 0.0F, false));

		leg1Child2 = new ModelRenderer(this);
		leg1Child2.setRotationPoint(14.0F, -1.0F, 0.0F);
		leg2.addChild(leg1Child2);
		setRotationAngle(leg1Child2, 0.0F, 0.0F, 0.7854F);
		leg1Child2.cubeList.add(new ModelBox(leg1Child2, 0, 63, 0.0F, 0.0F, -1.0F, 19, 2, 2, 0.0F, false));

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(6.0F, 13.0F, -2.0F);
		leg3.cubeList.add(new ModelBox(leg3, 48, 67, 0.0F, -1.0F, -1.0F, 13, 2, 2, 0.0F, false));

		leg1Child3 = new ModelRenderer(this);
		leg1Child3.setRotationPoint(13.0F, -1.0F, 0.0F);
		leg3.addChild(leg1Child3);
		setRotationAngle(leg1Child3, 0.0F, 0.0F, 0.7854F);
		leg1Child3.cubeList.add(new ModelBox(leg1Child3, 49, 46, 0.0F, 0.0F, -1.0F, 19, 2, 2, 0.0F, false));

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(7.0F, 13.0F, 1.0F);
		leg4.cubeList.add(new ModelBox(leg4, 18, 67, -1.0F, -1.0F, -1.0F, 13, 2, 2, 0.0F, false));

		leg1Child4 = new ModelRenderer(this);
		leg1Child4.setRotationPoint(12.0F, -1.0F, 0.0F);
		leg4.addChild(leg1Child4);
		setRotationAngle(leg1Child4, 0.0F, 0.0F, 0.7854F);
		leg1Child4.cubeList.add(new ModelBox(leg1Child4, 49, 42, 0.0F, 0.0F, -1.0F, 19, 2, 2, 0.0F, false));

		leg1Child5 = new ModelRenderer(this);
		leg1Child5.setRotationPoint(-5.0F, 13.0F, -8.0F);
		leg1Child5.cubeList.add(new ModelBox(leg1Child5, 74, 27, -12.0F, -1.0F, -1.0F, 12, 2, 2, 0.0F, false));

		leg5 = new ModelRenderer(this);
		leg5.setRotationPoint(-12.0F, -1.0F, 0.0F);
		leg1Child5.addChild(leg5);
		setRotationAngle(leg5, 0.0F, 0.0F, -0.7854F);
		leg5.cubeList.add(new ModelBox(leg5, 49, 38, -19.0F, 0.0F, -1.0F, 19, 2, 2, 0.0F, false));

		leg1Child6 = new ModelRenderer(this);
		leg1Child6.setRotationPoint(-4.0F, 12.0F, -5.0F);
		leg1Child6.cubeList.add(new ModelBox(leg1Child6, 74, 23, -13.0F, 0.0F, -1.0F, 12, 2, 2, 0.0F, false));

		leg6 = new ModelRenderer(this);
		leg6.setRotationPoint(-13.0F, 0.0F, 0.0F);
		leg1Child6.addChild(leg6);
		setRotationAngle(leg6, 0.0F, 0.0F, -0.7854F);
		leg6.cubeList.add(new ModelBox(leg6, 49, 34, -19.0F, 0.0F, -1.0F, 19, 2, 2, 0.0F, false));

		leg1Child7 = new ModelRenderer(this);
		leg1Child7.setRotationPoint(-5.0F, 13.0F, -2.0F);
		leg1Child7.cubeList.add(new ModelBox(leg1Child7, 73, 4, -12.0F, -1.0F, -1.0F, 12, 2, 2, 0.0F, false));

		leg7 = new ModelRenderer(this);
		leg7.setRotationPoint(-12.0F, -1.0F, 0.0F);
		leg1Child7.addChild(leg7);
		setRotationAngle(leg7, 0.0F, 0.0F, -0.7854F);
		leg7.cubeList.add(new ModelBox(leg7, 48, 19, -19.0F, 0.0F, -1.0F, 19, 2, 2, 0.0F, false));

		leg1Child8 = new ModelRenderer(this);
		leg1Child8.setRotationPoint(-5.0F, 13.0F, 1.0F);
		leg1Child8.cubeList.add(new ModelBox(leg1Child8, 73, 0, -12.0F, -1.0F, -1.0F, 12, 2, 2, 0.0F, false));

		leg8 = new ModelRenderer(this);
		leg8.setRotationPoint(-18.0F, -1.0F, 0.0F);
		leg1Child8.addChild(leg8);
		setRotationAngle(leg8, 0.0F, 0.0F, -0.7854F);
		leg8.cubeList.add(new ModelBox(leg8, 48, 15, -14.7574F, 4.2426F, -1.0F, 19, 2, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		sac.render(f5);
		body.render(f5);
		head.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
		leg1Child5.render(f5);
		leg1Child6.render(f5);
		leg1Child7.render(f5);
		leg1Child8.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.leg1.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
		this.leg4.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
		this.leg2.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
		this.leg3.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
		this.leg1Child6.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leg1Child5.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leg1Child8.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leg1Child7.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}