
package net.mcreator.pirateurerror.gui.overlay;

@PirateurErrorModElements.ModElement.Tag
public class BonCourrageOverlay extends PirateurErrorModElements.ModElement {

	public BonCourrageOverlay(PirateurErrorModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {

			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;

			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			if (true) {

				Minecraft.getInstance().fontRenderer.drawString("Bonne chance", posX + 96, posY + -92, -12829636);
			}
		}
	}

}
