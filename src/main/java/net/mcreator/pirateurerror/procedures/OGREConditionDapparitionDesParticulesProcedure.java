package net.mcreator.pirateurerror.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.pirateurerror.PirateurErrorModElements;

import java.util.Map;

@PirateurErrorModElements.ModElement.Tag
public class OGREConditionDapparitionDesParticulesProcedure extends PirateurErrorModElements.ModElement {
	public OGREConditionDapparitionDesParticulesProcedure(PirateurErrorModElements instance) {
		super(instance, 1);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure OGREConditionDapparitionDesParticules!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (!entity.world.isRemote)
			entity.remove();
	}
}
