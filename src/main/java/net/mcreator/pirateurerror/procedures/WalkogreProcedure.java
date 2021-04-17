package net.mcreator.pirateurerror.procedures;

import software.bernie.geckolib.entity.IAnimatedEntity;
import software.bernie.geckolib.animation.builder.AnimationBuilder;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.pirateurerror.entity.OGREEntity;
import net.mcreator.pirateurerror.PirateurErrorModElements;

import java.util.Map;
import java.util.HashMap;

@PirateurErrorModElements.ModElement.Tag
public class WalkogreProcedure extends PirateurErrorModElements.ModElement {
	public WalkogreProcedure(PirateurErrorModElements instance) {
		super(instance, 3);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Walkogre!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof OGREEntity.CustomEntity)) {
			if (entity instanceof IAnimatedEntity) {
				new Object() {
					@OnlyIn(Dist.CLIENT)
					void playAnimation(Entity entity, String animationID) {
						IAnimatedEntity aniEntity = (IAnimatedEntity) entity;
						aniEntity.getAnimationManager().get("controller").setAnimation(new AnimationBuilder().addAnimation(animationID, (true)));
					}
				}.playAnimation(entity, "model.animationwalk");
			}
		}
	}

	@SubscribeEvent
	public void onEntitySpawned(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		World world = event.getWorld().getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
