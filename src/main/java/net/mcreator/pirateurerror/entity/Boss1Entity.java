
package net.mcreator.pirateurerror.entity;

import net.minecraft.block.material.Material;

@PirateurErrorModElements.ModElement.Tag
public class Boss1Entity extends PirateurErrorModElements.ModElement {

	public static EntityType entity = null;

	public Boss1Entity(PirateurErrorModElements instance) {
		super(instance, 1);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("boss_1")
						.setRegistryName("boss_1");

		elements.entities.add(() -> entity);

		elements.items
				.add(() -> new SpawnEggItem(entity, -1, -3407872, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("boss_1_spawn_egg"));

	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {

			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 100, 1, 1));
		}

		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);

	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelboss(), 0.5f) {

				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pirateur_error:textures/bossl.png");
				}
			};
		});

	}

	public static class CustomEntity extends MonsterEntity {

		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);

		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();

			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 10, false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));

		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(Items.BLAZE_POWDER, (int) (1)));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PlayerEntity)
				return false;
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();

			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1);

			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);

			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12);

			if (this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
			this.getAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(5D);

			if (this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK);
			this.getAttribute(SharedMonsterAttributes.ATTACK_KNOCKBACK).setBaseValue(5D);

		}

		@Override
		public boolean isNonBoss() {
			return false;
		}

		private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS);

		@Override
		public void addTrackingPlayer(ServerPlayerEntity player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(ServerPlayerEntity player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void updateAITasks() {
			super.updateAITasks();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}

	}

	// Made with Blockbench 3.8.3
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports

	public static class Modelboss extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer head;
		private final ModelRenderer rightArm;
		private final ModelRenderer leftArm;
		private final ModelRenderer rightLeg;
		private final ModelRenderer leftLeg;

		public Modelboss() {
			textureWidth = 128;
			textureHeight = 128;

			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-8.0F, -24.0F, -7.0F, 15.0F, 33.0F, 11.0F, 0.0F, false);

			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.setTextureOffset(118, 0).addBox(11.0F, -12.0F, 12.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
			head.setTextureOffset(40, 32).addBox(-8.0F, -36.0F, -7.0F, 15.0F, 12.0F, 12.0F, 0.0F, false);
			head.setTextureOffset(0, 126).addBox(12.0F, -11.0F, 15.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
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
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
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

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}

}
