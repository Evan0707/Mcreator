
package net.mcreator.pirateurerror.item;

@PirateurErrorModElements.ModElement.Tag
public class OgreTeethItem extends PirateurErrorModElements.ModElement {

	@ObjectHolder("pirateur_error:ogre_teeth")
	public static final Item block = null;

	public OgreTeethItem(PirateurErrorModElements instance) {
		super(instance, 4);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("ogre_teeth");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
