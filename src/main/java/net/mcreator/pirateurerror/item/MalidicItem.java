
package net.mcreator.pirateurerror.item;

@PirateurErrorModElements.ModElement.Tag
public class MalidicItem extends PirateurErrorModElements.ModElement {

	@ObjectHolder("pirateur_error:malidic")
	public static final Item block = null;

	public MalidicItem(PirateurErrorModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("malidic");
		}

	}

}
