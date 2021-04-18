// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelbaby2 extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;

	public Modelbaby2() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone2.setTextureOffset(12, 21).addBox(7.0F, -6.0F, 7.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(8, 21).addBox(-8.0F, -6.0F, 7.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(8, 0).addBox(7.0F, -6.0F, -8.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone3.setTextureOffset(42, 54).addBox(-3.0F, -12.0F, -11.0F, 6.0F, 5.0F, 5.0F, 0.0F, false);
		bone3.setTextureOffset(0, 50).addBox(-4.0F, -21.0F, -4.0F, 8.0F, 7.0F, 7.0F, 0.0F, false);
		bone3.setTextureOffset(3, 55).addBox(-3.0F, -25.0F, -3.0F, 6.0F, 4.0F, 5.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(16, 21).addBox(-8.0F, -6.0F, -8.0F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-6.0F, -14.0F, -6.0F, 12.0F, 9.0F, 12.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.3491F, 0.7418F, 0.0F);
		cube_r1.setTextureOffset(0, 0).addBox(0.0F, -10.0F, 5.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.3491F, -0.829F, 0.0F);
		cube_r2.setTextureOffset(0, 4).addBox(0.0F, -10.0F, 5.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.3491F, -2.3126F, 0.0F);
		cube_r3.setTextureOffset(0, 8).addBox(-1.0F, -10.0F, 5.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r4);
		setRotationAngle(cube_r4, -0.3491F, 2.3126F, 0.0F);
		cube_r4.setTextureOffset(0, 21).addBox(0.0F, -10.0F, 5.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		bone2.render(matrixStack, buffer, packedLight, packedOverlay);
		bone3.render(matrixStack, buffer, packedLight, packedOverlay);
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