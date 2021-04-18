
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.CreeperEntity;
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

import net.mcreator.pirateurerror.procedures.SpiderQuandLentitMeurtProcedure;
import net.mcreator.pirateurerror.item.BouteilledeveninItem;
import net.mcreator.pirateurerror.PirateurErrorModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@PirateurErrorModElements.ModElement.Tag
public class SpiderEntity extends PirateurErrorModElements.ModElement {
	public static EntityType entity = null;
	public SpiderEntity(PirateurErrorModElements instance) {
		super(instance, 12);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("spider")
						.setRegistryName("spider");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -16777216, -6750208, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("spider_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			biome.getSpawns(EntityClassification.MONSTER).add(new Biome.SpawnListEntry(entity, 20, 4, 4));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				MonsterEntity::canMonsterSpawn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelmongg(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("pirateur_error:textures/sss.png");
				}
			};
		});
	}
	public static class CustomEntity extends CreeperEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 12;
			setNoAI(false);
			enablePersistence();
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
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(BouteilledeveninItem.block, (int) (1)));
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
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
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
				$_dependencies.put("entity", entity);
				SpiderQuandLentitMeurtProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(105);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(9);
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
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
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

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
