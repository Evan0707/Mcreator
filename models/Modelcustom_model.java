// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends EntityModel<Entity> {
	private final ModelRenderer Corp;
	private final ModelRenderer corne;
	private final ModelRenderer bras1;
	private final ModelRenderer bras2;
	private final ModelRenderer arme;
	private final ModelRenderer tete;
	private final ModelRenderer oreille;
	private final ModelRenderer piedG;
	private final ModelRenderer piedD;
	private final ModelRenderer corp2;
	private final ModelRenderer bouch;

	public Modelcustom_model() {
		textureWidth = 128;
		textureHeight = 128;

		Corp = new ModelRenderer(this);
		Corp.setRotationPoint(0.0F, 26.0F, -5.0F);
		setRotationAngle(Corp, -0.1745F, 0.0F, 0.0F);
		Corp.setTextureOffset(0, 22).addBox(-9.0F, -35.0F, -5.0F, 18.0F, 10.0F, 10.0F, 0.0F, false);

		corne = new ModelRenderer(this);
		corne.setRotationPoint(0.0F, 18.0F, 20.0F);
		setRotationAngle(corne, 0.4363F, 0.0F, 0.0F);
		corne.setTextureOffset(0, 0).addBox(3.0F, -51.0F, -6.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		corne.setTextureOffset(0, 22).addBox(-5.0F, -51.0F, -6.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);

		bras1 = new ModelRenderer(this);
		bras1.setRotationPoint(0.0F, 26.0F, -5.0F);
		bras1.setTextureOffset(63, 61).addBox(9.0F, -34.0F, 2.0F, 6.0F, 7.0F, 7.0F, 0.0F, false);
		bras1.setTextureOffset(39, 75).addBox(12.0F, -31.0F, 3.0F, 5.0F, 11.0F, 5.0F, 0.0F, false);
		bras1.setTextureOffset(73, 26).addBox(11.0F, -23.0F, 2.0F, 7.0F, 8.0F, 5.0F, 0.0F, false);

		bras2 = new ModelRenderer(this);
		bras2.setRotationPoint(0.0F, 26.0F, -5.0F);
		bras2.setTextureOffset(0, 64).addBox(-18.0F, -23.0F, 2.0F, 7.0F, 8.0F, 5.0F, 0.0F, false);
		bras2.setTextureOffset(19, 72).addBox(-17.0F, -31.0F, 3.0F, 5.0F, 11.0F, 5.0F, 0.0F, false);
		bras2.setTextureOffset(37, 61).addBox(-15.0F, -34.0F, 2.0F, 6.0F, 7.0F, 7.0F, 0.0F, false);

		arme = new ModelRenderer(this);
		arme.setRotationPoint(0.0F, 24.0F, 0.0F);
		arme.setTextureOffset(56, 61).addBox(-17.0F, -19.0F, -9.0F, 5.0F, 5.0F, 2.0F, 0.0F, false);
		arme.setTextureOffset(34, 42).addBox(-16.0F, -18.0F, -7.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		arme.setTextureOffset(0, 42).addBox(-16.0F, -18.0F, -11.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		arme.setTextureOffset(79, 79).addBox(-17.0F, -19.0F, -17.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);

		tete = new ModelRenderer(this);
		tete.setRotationPoint(0.0F, 24.0F, 0.0F);
		tete.setTextureOffset(0, 42).addBox(-6.0F, -46.0F, -5.0F, 12.0F, 12.0F, 10.0F, 0.0F, false);
		tete.setTextureOffset(19, 64).addBox(-5.0F, -44.0F, -6.0F, 10.0F, 3.0F, 1.0F, 0.0F, false);

		oreille = new ModelRenderer(this);
		oreille.setRotationPoint(0.0F, 24.0F, 0.0F);
		oreille.setTextureOffset(23, 113).addBox(-8.0F, -43.0F, 0.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		oreille.setTextureOffset(31, 96).addBox(6.0F, -44.0F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		oreille.setTextureOffset(31, 96).addBox(-9.0F, -44.0F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		oreille.setTextureOffset(36, 108).addBox(6.0F, -40.0F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		oreille.setTextureOffset(36, 108).addBox(-9.0F, -40.0F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
		oreille.setTextureOffset(2, 108).addBox(8.0F, -43.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		oreille.setTextureOffset(95, 103).addBox(7.0F, -40.0F, -2.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		oreille.setTextureOffset(95, 103).addBox(7.0F, -40.0F, 1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		oreille.setTextureOffset(95, 103).addBox(7.0F, -38.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		oreille.setTextureOffset(2, 108).addBox(-9.0F, -43.0F, -1.0F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		oreille.setTextureOffset(23, 113).addBox(6.0F, -43.0F, 0.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		oreille.setTextureOffset(95, 103).addBox(7.0F, -41.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);

		piedG = new ModelRenderer(this);
		piedG.setRotationPoint(0.0F, 24.0F, 0.0F);
		piedG.setTextureOffset(56, 31).addBox(-4.0F, -2.0F, -6.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		piedG.setTextureOffset(59, 75).addBox(-9.0F, -2.0F, -5.0F, 5.0F, 2.0F, 8.0F, 0.0F, false);
		piedG.setTextureOffset(52, 16).addBox(-9.0F, -11.0F, -3.0F, 7.0F, 9.0F, 6.0F, 0.0F, false);

		piedD = new ModelRenderer(this);
		piedD.setRotationPoint(0.0F, 24.0F, 0.0F);
		piedD.setTextureOffset(0, 79).addBox(2.0F, -2.0F, -6.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
		piedD.setTextureOffset(76, 7).addBox(4.0F, -2.0F, -5.0F, 5.0F, 2.0F, 8.0F, 0.0F, false);
		piedD.setTextureOffset(58, 0).addBox(2.0F, -11.0F, -3.0F, 7.0F, 9.0F, 6.0F, 0.0F, false);

		corp2 = new ModelRenderer(this);
		corp2.setRotationPoint(0.0F, 24.0F, 0.0F);
		corp2.setTextureOffset(0, 0).addBox(-10.0F, -24.0F, -5.0F, 20.0F, 13.0F, 9.0F, 0.0F, false);
		corp2.setTextureOffset(44, 42).addBox(-7.0F, -34.0F, -3.0F, 14.0F, 10.0F, 9.0F, 0.0F, false);
		corp2.setTextureOffset(81, 39).addBox(-11.0F, -14.0F, -3.0F, 1.0F, 4.0F, 6.0F, 0.0F, false);

		bouch = new ModelRenderer(this);
		bouch.setRotationPoint(0.0F, 24.0F, 0.0F);
		bouch.setTextureOffset(6, 22).addBox(1.0F, -38.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bouch.setTextureOffset(0, 30).addBox(-2.0F, -38.0F, -6.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bouch.setTextureOffset(45, 42).addBox(-4.0F, -39.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bouch.setTextureOffset(72, 17).addBox(-4.0F, -37.0F, -6.0F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		bouch.setTextureOffset(34, 42).addBox(3.0F, -39.0F, -6.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Corp.render(matrixStack, buffer, packedLight, packedOverlay);
		corne.render(matrixStack, buffer, packedLight, packedOverlay);
		bras1.render(matrixStack, buffer, packedLight, packedOverlay);
		bras2.render(matrixStack, buffer, packedLight, packedOverlay);
		arme.render(matrixStack, buffer, packedLight, packedOverlay);
		tete.render(matrixStack, buffer, packedLight, packedOverlay);
		oreille.render(matrixStack, buffer, packedLight, packedOverlay);
		piedG.render(matrixStack, buffer, packedLight, packedOverlay);
		piedD.render(matrixStack, buffer, packedLight, packedOverlay);
		corp2.render(matrixStack, buffer, packedLight, packedOverlay);
		bouch.render(matrixStack, buffer, packedLight, packedOverlay);
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