
package net.mcreator.pirateurerror.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import net.mcreator.pirateurerror.procedures.OGREQuandLentiteMeurtProcedure;
import net.mcreator.pirateurerror.PirateurErrorModElements;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@PirateurErrorModElements.ModElement.Tag
public class OGREEntity extends PirateurErrorModElements.ModElement {
	public static EntityType entity = null;
	public OGREEntity(PirateurErrorModElements instance) {
		super(instance, 1);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("ogre")
						.setRegistryName("ogre");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -1, -1, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("ogre_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 20, 1, 1));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelcustom_model(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pirateur_error:textures/ddd.png");
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
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.ambient"));
		}

		@Override
		public void playStepSound(BlockPos pos, BlockState blockIn) {
			this.playSound((net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.step")),
					0.15f, 1);
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
			if (source.getImmediateSource() instanceof ArrowEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = source.getTrueSource();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				OGREQuandLentiteMeurtProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.GREEN, BossInfo.Overlay.PROGRESS);
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

		public void livingTick() {
			super.livingTick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Random random = this.rand;
			Entity entity = this;
			if (true)
				for (int l = 0; l < 1; ++l) {
					double d0 = (x + random.nextFloat());
					double d1 = (y + random.nextFloat());
					double d2 = (z + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 1.9D;
					double d4 = (random.nextFloat() - 0.5D) * 1.9D;
					double d5 = (random.nextFloat() - 0.5D) * 1.9D;
					world.addParticle(ParticleTypes.EXPLOSION, d0, d1, d2, d3, d4, d5);
				}
		}
	}

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
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
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

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
