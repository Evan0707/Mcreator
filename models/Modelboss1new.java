// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelboss1new extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer head;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;

	public Modelboss1new() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-8.0F, -24.0F, -7.0F, 15.0F, 33.0F, 11.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(118, 0).addBox(11.0F, -12.0F, 12.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(40, 32).addBox(-8.0F, -36.0F, -7.0F, 15.0F, 12.0F, 12.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(12.0F, -11.0F, 15.0F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		head.setTextureOffset(124, 126).addBox(12.0F, -11.0F, 10.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(122, 2).addBox(12.0F, -10.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		rightArm.setTextureOffset(18, 44).addBox(2.0F, -23.0F, -3.0F, 4.0F, 27.0F, 5.0F, 0.0F, false);
		rightArm.setTextureOffset(0, 44).addBox(-16.0F, -23.0F, -3.0F, 4.0F, 27.0F, 5.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-5.0F, 2.0F, 0.0F);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
		rightLeg.setTextureOffset(36, 56).addBox(-1.0F, -3.0F, -3.0F, 3.0F, 10.0F, 4.0F, 0.0F, false);
		rightLeg.setTextureOffset(52, 0).addBox(-6.0F, -3.0F, -3.0F, 3.0F, 10.0F, 4.0F, 0.0F, false);
		rightLeg.setTextureOffset(0, 0).addBox(-1.0F, 4.0F, -7.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		rightLeg.setTextureOffset(0, 0).addBox(-6.0F, 4.0F, -7.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.rightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}