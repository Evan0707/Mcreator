package net.mcreator.pirateurerror.procedures;

@PirateurErrorModElements.ModElement.Tag
public class WatherOgreMobplayerCollidesBlockProcedure extends PirateurErrorModElements.ModElement {

	public WatherOgreMobplayerCollidesBlockProcedure(PirateurErrorModElements instance) {
		super(instance, 6);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure WatherOgreMobplayerCollidesBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 20, (int) 4));

	}

}
