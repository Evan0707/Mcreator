// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelmongg extends EntityModel<Entity> {
	private final ModelRenderer Pate1;
	private final ModelRenderer Pate2;
	private final ModelRenderer Pate3;
	private final ModelRenderer Pate4;
	private final ModelRenderer bone;
	private final ModelRenderer Pate5;
	private final ModelRenderer Pate6;
	private final ModelRenderer bb_main;

	public Modelmongg() {
		textureWidth = 64;
		textureHeight = 64;

		Pate1 = new ModelRenderer(this);
		Pate1.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(Pate1, 0.0F, 0.0F, -1.0908F);
		Pate1.setTextureOffset(24, 30).addBox(8.0F, -2.0F, -10.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		Pate2 = new ModelRenderer(this);
		Pate2.setRotationPoint(-3.0F, 22.0F, 19.0F);
		setRotationAngle(Pate2, 0.3491F, 0.0F, -1.0908F);
		Pate2.setTextureOffset(12, 30).addBox(8.0F, -4.0F, -18.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		Pate3 = new ModelRenderer(this);
		Pate3.setRotationPoint(3.0F, 25.0F, 10.0F);
		setRotationAngle(Pate3, 0.0F, 0.0F, -1.2217F);
		Pate3.setTextureOffset(4, 0).addBox(8.0F, -4.0F, -14.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		Pate4 = new ModelRenderer(this);
		Pate4.setRotationPoint(-10.0F, 10.0F, -23.0F);
		setRotationAngle(Pate4, 3.1416F, 0.0F, 1.0908F);
		Pate4.setTextureOffset(8, 30).addBox(8.0F, -2.0F, -14.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 25.0F, 1.0F);
		setRotationAngle(bone, 0.2618F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-3.0F, -13.0F, 1.0F, 6.0F, 7.0F, 10.0F, 0.0F, false);

		Pate5 = new ModelRenderer(this);
		Pate5.setRotationPoint(-9.0F, 9.0F, 10.0F);
		setRotationAngle(Pate5, 0.0F, 0.0F, 1.2217F);
		Pate5.setTextureOffset(0, 0).addBox(8.0F, -4.0F, -14.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		Pate6 = new ModelRenderer(this);
		Pate6.setRotationPoint(-4.0F, 10.0F, 19.0F);
		setRotationAngle(Pate6, 0.3491F, 0.0F, 1.0908F);
		Pate6.setTextureOffset(4, 17).addBox(5.0F, -5.0F, -18.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(32, 5).addBox(7.0F, -6.0F, -10.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(20, 30).addBox(9.0F, -6.0F, -4.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(16, 30).addBox(7.0F, -6.0F, 3.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(4, 30).addBox(-8.0F, -6.0F, -10.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(28, 26).addBox(-2.0F, -10.0F, -16.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 17).addBox(-4.0F, -11.0F, -7.0F, 8.0F, 5.0F, 8.0F, 0.0F, false);
		bb_main.setTextureOffset(22, 0).addBox(-4.0F, -10.0F, -9.0F, 8.0F, 3.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(24, 17).addBox(-3.0F, -10.0F, -12.0F, 6.0F, 3.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 30).addBox(-10.0F, -6.0F, -4.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 17).addBox(-8.0F, -6.0F, 2.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Pate1.render(matrixStack, buffer, packedLight, packedOverlay);
		Pate2.render(matrixStack, buffer, packedLight, packedOverlay);
		Pate3.render(matrixStack, buffer, packedLight, packedOverlay);
		Pate4.render(matrixStack, buffer, packedLight, packedOverlay);
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		Pate5.render(matrixStack, buffer, packedLight, packedOverlay);
		Pate6.render(matrixStack, buffer, packedLight, packedOverlay);
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