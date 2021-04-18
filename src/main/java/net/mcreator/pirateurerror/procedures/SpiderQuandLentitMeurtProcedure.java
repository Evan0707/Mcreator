package net.mcreator.pirateurerror.procedures;

@PirateurErrorModElements.ModElement.Tag
public class SpiderQuandLentitMeurtProcedure extends PirateurErrorModElements.ModElement {

	public SpiderQuandLentitMeurtProcedure(PirateurErrorModElements instance) {
		super(instance, 12);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SpiderQuandLentitMeurt!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).addExperienceLevel((int) 12);
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(EggspiderItem.block, (int) (1));
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}

	}

}
