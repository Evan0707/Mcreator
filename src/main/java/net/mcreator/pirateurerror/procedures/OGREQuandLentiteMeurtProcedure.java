package net.mcreator.pirateurerror.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.pirateurerror.PirateurErrorModElements;

import java.util.Map;

@PirateurErrorModElements.ModElement.Tag
public class OGREQuandLentiteMeurtProcedure extends PirateurErrorModElements.ModElement {
	public OGREQuandLentiteMeurtProcedure(PirateurErrorModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure OGREQuandLentiteMeurt!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).addExperienceLevel((int) 12);
	}
}
