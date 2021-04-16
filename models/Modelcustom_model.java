// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public static class Modelcustom_model extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;

	public Modelcustom_model() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -14.0F, -4.0F, 8, 7, 10, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 17, -4.0F, -5.0F, -4.0F, 8, 1, 8, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 26, 0, -3.9F, -7.0F, 1.0F, 8, 2, 4, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 4, 2, -3.0F, -7.0F, -4.0F, 1, 2, 0, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 2, -4.0F, -7.0F, -2.0F, 0, 2, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, 4.0F, -7.0F, -3.0F, 0, 2, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 2, 2, -4.0F, -6.0F, -3.0F, 0, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 2, 1, -4.0F, -7.0F, 0.0F, 0, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, 4.0F, -5.0F, 0.0F, 0, 0, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 2, 0, 4.0F, -7.0F, -2.0F, 0, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -7.0F, -4.0F, 1, 1, 0, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 4, 0, 3.0F, -7.0F, -4.0F, 1, 2, 0, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 2, 4, -1.0F, -7.0F, -4.0F, 1, 2, 0, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 4, 4, 0.0F, -6.0F, -4.0F, 1, 1, 0, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 2, 0, 2.0F, -7.0F, -4.0F, 1, 1, 0, 0.0F, false));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 0, 26, -4.0F, -4.0F, -2.0F, 8, 12, 4, 0.0F, false));

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		leftArm.cubeList.add(new ModelBox(leftArm, 32, 17, -1.0F, -6.0F, -1.0F, 2, 22, 2, 0.0F, false));

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		rightArm.cubeList.add(new ModelBox(rightArm, 24, 26, -1.0F, -6.0F, -1.0F, 2, 22, 2, 0.0F, false));

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		leftLeg.cubeList.add(new ModelBox(leftLeg, 40, 6, -1.0F, -4.0F, -1.0F, 2, 16, 2, 0.0F, false));

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		rightLeg.cubeList.add(new ModelBox(rightLeg, 38, 39, -1.0F, -4.0F, -1.0F, 2, 16, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		head.render(f5);
		body.render(f5);
		leftArm.render(f5);
		rightArm.render(f5);
		leftLeg.render(f5);
		rightLeg.render(f5);
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