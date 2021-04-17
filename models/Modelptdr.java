// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelptdr extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer body_r1;
	private final ModelRenderer head;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer leftArm_r1;
	private final ModelRenderer bb_main;
	private final ModelRenderer leftArm_r2;

	public Modelptdr() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.setTextureOffset(0, 16).addBox(-4.0F, 22.0F, 4.0F, 8.0F, 2.0F, 9.0F, 0.0F, false);
		body.setTextureOffset(25, 9).addBox(-4.0F, 20.0F, 6.0F, 8.0F, 2.0F, 7.0F, 0.0F, false);

		body_r1 = new ModelRenderer(this);
		body_r1.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.addChild(body_r1);
		setRotationAngle(body_r1, 1.0472F, 0.0F, 0.0F);
		body_r1.setTextureOffset(0, 27).addBox(-4.0F, -10.0F, 2.0F, 8.0F, 14.0F, 5.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, 9.0F, -14.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(5.0F, 2.0F, 0.0F);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-10.0F, 0.0F, 0.0F);
		rightArm.addChild(leftArm);

		leftArm_r1 = new ModelRenderer(this);
		leftArm_r1.setRotationPoint(5.0F, 22.0F, 0.0F);
		leftArm.addChild(leftArm_r1);
		setRotationAngle(leftArm_r1, -0.0436F, 0.0F, 0.1745F);
		leftArm_r1.setTextureOffset(34, 18).addBox(-7.0F, -7.0F, -6.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);

		leftArm_r2 = new ModelRenderer(this);
		leftArm_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(leftArm_r2);
		setRotationAngle(leftArm_r2, -0.0436F, 0.0F, -0.1745F);
		leftArm_r2.setTextureOffset(26, 27).addBox(5.0F, -7.0F, -5.0F, 2.0F, 8.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
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